package com.sm.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import com.sm.query.BaseQuery;
import com.sm.query.PageList;

/**
 * 
 * 鍏叡鐨刣ao绫伙紝涓嶈兘鍐欐垚鎶借薄绫伙紝鍥犱负闇�瀹炰緥鍖�
 * 
 * 
 */
public class BaseDao<T> extends HibernateDaoSupport {
	public void save(T t) {
		getHibernateTemplate().save(t);
	}

	public void update(T t) {
		getHibernateTemplate().update(t);
	}

	/**
	 * 
	 * @param Serializable
	 *            id:閫氱敤涓�簺锛孡ong,String
	 */
	public void delete(Class<T> entityClass, Serializable id) {
		T t = get(entityClass, id);
		if (t != null) {
			getHibernateTemplate().delete(t);// 涓嶈兘鍐欐垚delete(id)
		}
	}

	public T get(Class<T> entityClass, Serializable id) {
		return getHibernateTemplate().get(entityClass, id);
	}

	public List<T> getAll(Class<T> entityClass) {
		return getHibernateTemplate().loadAll(entityClass);
	}

	public PageList findByQuery(final BaseQuery baseQuery) {

		Long count = getHibernateTemplate().executeWithNativeSession(
				new HibernateCallback<Long>() {

					@Override
					public Long doInHibernate(Session session)
							throws HibernateException, SQLException {
						Query query = session.createQuery(baseQuery
								.getCountHql());
						// 娣诲姞鏌ヨ鏉′欢
						List paramList = baseQuery.getParamList();
						for (int i = 0; i < paramList.size(); i++) {
							// jdbc.setObject(i+1,)
							query.setParameter(i, paramList.get(i));
						}
						return (Long) query.uniqueResult();
					}

				});
		// 4.浼樺寲
		if (count.intValue() == 0) {
			return new PageList();
		}
		final PageList pageList = new PageList(baseQuery.getCurrentPage(),
				baseQuery.getPageSize(), count.intValue());
		// 5.limit
		List rows = getHibernateTemplate().executeWithNativeSession(
				new HibernateCallback<List>() {

					@Override
					public List doInHibernate(Session session)
							throws HibernateException, SQLException {
						// ***************淇敼涓簂imit******************
						Query query = session.createQuery(baseQuery
								.getLimitHql());
						// 娣诲姞鏌ヨ鏉′欢
						List paramList = baseQuery.getParamList();
						for (int i = 0; i < paramList.size(); i++) {
							// jdbc.setObject(i+1,)
							query.setParameter(i, paramList.get(i));
						}
						// 澶勭悊鍒嗛〉
						// 娣诲姞2涓柟娉�
						// **********************蹇呴』浣跨敤缁忚繃澶勭悊鍚庣殑pageList*************************
						int firstResult = (pageList.getCurrentPage() - 1)
								* pageList.getPageSize();// 浠庡摢涓储寮曞彇鏁版嵁
						int maxResults = pageList.getPageSize();// 鍙栧灏戞潯
						query.setFirstResult(firstResult).setMaxResults(
								maxResults);
						return query.list();
					}

				});
		pageList.setRows(rows);
		return pageList;
	}

	public List findByHql(String hql, Object... objects) {
		return getHibernateTemplate().find(hql, objects);
	}

	public List findByHql(String hql) {
		System.out.println("asdfds"+hql);
		return getHibernateTemplate().find(hql);
	}

	// 娌℃湁鏉′欢鍙傛暟鐨勫彲浠ヤ娇鐢ㄦ鏂规硶
	public List findCacheByHql(final String hql) {
		return getHibernateTemplate().executeWithNativeSession(
				new HibernateCallback<List>() {
					@Override
					public List doInHibernate(Session session)
							throws HibernateException, SQLException {
						Query query = session.createQuery(hql);
						// 鏌ヨ缂撳瓨鐢熸晥
						query.setCacheable(true);
						return query.list();
					}
				});
	}

}
