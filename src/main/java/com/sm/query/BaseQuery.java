package com.sm.query;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * 澶勭悊鍏叡鏌ヨ鏉′欢锛氫竴椤垫樉绀烘潯鏁帮紝褰撳墠椤电爜
 *
 */
public abstract class BaseQuery {
	// 褰撳墠椤电爜
	private int currentPage = 1;
	// 涓�〉鏄剧ず鏉℃暟
	private int pageSize = 10;
	// 澶勭悊2鏉ql
	// select count(o) from Employee o where o.name=? and o.email=?
	// select o from Employee o where o.name=? and o.email=? 涓嶅啓limit ?,?
	private StringBuilder countHql;
	private StringBuilder limitHql;
	// 澶勭悊hql閲岄潰鐨�,鍙傛暟鐨勫�
	private List paramList;

	public BaseQuery(String className) {
		countHql = new StringBuilder("select count(o) from " + className + " o");
		limitHql = new StringBuilder("select o from " + className + " o");
		paramList = new ArrayList();
	}

	// 蹇呴』璁╁瓙绫婚噸鍐欑殑鏂规硶锛氬瓙绫讳紶鍏ュ弬鏁扮殑鏉′欢鍜屽�
	protected abstract void addWhere();

	// 鍦ㄦ彁渚涗竴涓柟娉曪紝鐢卞瓙绫荤洿鎺ヨ皟鐢紝鏀惧叆鎷兼帴鐨刪ql鏉′欢鍜屽�
	// select count(o) from Employee o where o.date between ? and ?
	protected void addCondition(String where, Object... objects) {
		// 鎬庢牱鐭ラ亾搴旇鎷兼帴where 杩樻槸and鐪媝aramList.size
		if (paramList.size() == 0) {
			countHql.append(" where ").append(where);
			limitHql.append(" where ").append(where);
		} else {
			countHql.append(" and ").append(where);
			limitHql.append(" and ").append(where);
		}
		// 鎶婂弬鏁扮殑鍊兼斁鍏ist paramList;
		// paramList.add(objects);//閿欒鐨�
		// paramList.add(Arrays.asList(objects));//閿欒鐨�
		paramList.addAll(Arrays.asList(objects));
	}

	// 淇濊瘉addWhere瀛愮被閲嶅啓鐨勬柟娉曞彧鑳借皟鐢ㄤ竴娆�
	private boolean flag = false;
	private void buildWhere() {
		if (!flag) {
			addWhere();
			flag = true;
		}
	}

	// 鎻愪緵涓�釜get鏂规硶缁檇ao浣跨敤
	public String getCountHql() {
		// 璋冪敤涓�釜鏂规硶鎷兼帴hql
		buildWhere();
		return countHql.toString();
	}

	public String getLimitHql() {
		// 璋冪敤涓�釜鏂规硶鎷兼帴hql
		buildWhere();
		return limitHql.toString();
	}

	public List getParamList() {
		// 璋冪敤涓�釜鏂规硶鎷兼帴hql
		buildWhere();
		return paramList;
	}

	// 缁檚truts浣跨敤
	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

}
