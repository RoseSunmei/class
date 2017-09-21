package com.sm.action;

import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.opensymphony.xwork2.interceptor.annotations.InputConfig;

/**
 * 
 * 楂樼骇鏌ヨ+鍒嗛〉锛欳RUD闇�眰鐨勭埗绫�
 * 
 */
public abstract class CRUDAction<T> extends BaseAction implements
		ModelDriven<T>, Preparable {

	// 鍒楄〃鐨勬柟娉曞悕绉�
	@Override
	// 濡傛灉鍑虹幇浜嗚浆鎹㈠紓甯告垨鑰呴獙璇佸紓甯革紝鏀瑰彉榛樿鐨勮烦杞鍥惧悕绉�璺宠浆鍒癳xecute鏂规硶
	@InputConfig(methodName = "execute")
	public String execute() throws Exception {
		list();
		return SUCCESS;
	}

	// 涓嶇洿鎺ヨ澶栭儴(url鍦板潃)璁块棶灏变笉闇�瀹氫箟涓簆ublic
	protected abstract void list() throws Exception;

	// 淇濆瓨鐨勬柟娉曞悕绉�
	public abstract String save() throws Exception;

	// 鍒犻櫎鐨勬柟娉曞悕绉�
	public abstract String delete() throws Exception;

	// 瑙勫畾prepare鏂规硶鐨勫悕绉帮紝蹇呴』鍦╥nput鏂规硶鎴栬�save涔嬪墠鑷姩璋冪敤
	public abstract void prepareInput() throws Exception;

	public abstract void prepareSave() throws Exception;

	@Override
	public void prepare() throws Exception {
	}

}
