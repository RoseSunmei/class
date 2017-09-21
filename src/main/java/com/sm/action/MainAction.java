package com.sm.action;

public class MainAction extends BaseAction {

	// 显示后台框架主页
	@Override
	public String execute() throws Exception {
		return SUCCESS;
	}

	// 显示后台右边
	public String right() throws Exception {
		return "right";
	}
}
