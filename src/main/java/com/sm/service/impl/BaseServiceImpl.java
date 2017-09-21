package com.sm.service.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.lang.reflect.Type;
import com.sm.dao.BaseDao;
import com.sm.query.BaseQuery;
import com.sm.query.PageList;
import com.sm.service.IBaseService;

/**
 * 
 * 鍏叡涓氬姟绫�涓嶈兘瀹炰緥鍖栵紝涓嶈兘鎶夿aseServiceImpl閰嶇疆鍒皊pring鐨刢lass閲岄潰
 *
 * 
 */
public abstract class BaseServiceImpl<T> implements IBaseService<T> {
	protected BaseDao<T> baseDao;
	private Class<T> entityClass;

	public void setBaseDao(BaseDao<T> baseDao) {
		this.baseDao = baseDao;
	}

	public BaseServiceImpl() {
		// getClass() 杩斿洖姝�Object 鐨勮繍琛屾椂绫汇�
		// public final native Class<?> getClass();
		// new BaseServiceImpl 杩斿洖灏辨槸鐖剁被锛堝鏋滄妸鐖剁被瀹氫箟涓烘娊璞★級 new EmployeeServiceImpl杩斿洖灏辨槸瀛愮被
		Class clazz = getClass();// 鍥犱负鐖剁被鏄娊璞＄殑锛屽喅瀹氳繑鍥炲瓙绫荤殑瀹炰緥
		// System.out.println("BaseServiceImpl clazz:" + clazz);
		// getGenericSuperclass() 杩斿洖琛ㄧず姝�Class 鎵�〃绀虹殑瀹炰綋鐨勭洿鎺ョ埗绫荤殑 Type銆�
		// EmployeeServiceImpl extends BaseServiceImpl<Employee>
		// java.lang.reflect.Type鏍囩ず鎺ュ彛锛岄噷闈粈涔堜唬鐮侀兘娌℃湁
		Type type = clazz.getGenericSuperclass();// BaseServiceImpl<Employee>鐨勭被鍨婽ype
		// System.out.println("BaseServiceImpl type:" + type);
		if (type instanceof ParameterizedType) {
			// ParameterizedType 琛ㄧず鍙傛暟鍖栫被鍨嬶紝濡�Collection<String>銆�
			ParameterizedType parameterizedType = (ParameterizedType) type;
			// getActualTypeArguments() 杩斿洖琛ㄧず姝ょ被鍨嬪疄闄呯被鍨嬪弬鏁扮殑 Type 瀵硅薄鐨勬暟缁勩�<Employee>
			entityClass = (Class<T>) parameterizedType.getActualTypeArguments()[0];
		}
		System.out.println("BaseServiceImpl entityClass:" + entityClass);
	}

	@Override
	public void save(T t) {
		baseDao.save(t);
	}

	@Override
	public void update(T t) {
		baseDao.update(t);
	}

	@Override
	public void delete(Serializable id) {
		baseDao.delete(entityClass, id);
	}

	@Override
	public T get(Serializable id) {
		return baseDao.get(entityClass, id);
	}

	@Override
	public List<T> getAll() {
		return baseDao.getAll(entityClass);
	}

	@Override
	public PageList findByQuery(BaseQuery baseQuery) {
		return baseDao.findByQuery(baseQuery);
	}

}
