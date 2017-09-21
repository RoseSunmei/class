package com.sm.action;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * 闈濩RUD闇�眰鐨勭埗绫�
 *
 */
public abstract class BaseAction extends ActionSupport {
	// 閲嶅畾鍚戠殑瑙嗗浘鍚嶇О
	public static final String RELOAD = "reload";
	
	// org.slf4j.Logger 闈㈠悜鎺ュ彛缂栫▼锛岄�鎷╁疄鐜帮紙閫夋嫨閮戒娇鐢ㄨ繖涓級
	protected Logger logger = LoggerFactory.getLogger(getClass());

	// 娣诲姞鍒癿ap鏍�
	protected void putContext(String key, Object value) {
		ActionContext.getContext().put(key, value);
	}

}
