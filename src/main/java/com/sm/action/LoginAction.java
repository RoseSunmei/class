package com.sm.action;

import org.apache.struts2.ServletActionContext;
import com.sm.entities.Student;
import com.sm.service.IStudentService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.interceptor.annotations.InputConfig;

public class LoginAction extends BaseAction {
	private IStudentService studentService;
	private String stuName;
	private String stuPwd;

	public void setStudentService(IStudentService studentService) {
		this.studentService = studentService;
	}

	// 杩涘叆鐧诲綍
	@Override
	public String execute() throws Exception {
		return LOGIN;
	}

	// 澶勭悊鐧诲綍璇锋眰
	@InputConfig(resultName = "login")
	public String check() throws Exception {
		Student student = studentService.findByLogin(stuName, stuPwd);
		// 鐧诲綍鎴愬姛涔嬪悗锛屾妸user瀵硅薄(鏈塱d)鏀惧叆session涓�
		if (student != null && "sm123456".equals(student.getStuName())) {
			ActionContext.getContext().getSession().put("studentInsession", student);
			return "main";// 閲嶅畾鍚戝悗鍙颁富椤�
		}else if(student != null){
			ActionContext.getContext().getSession().put("studentInsession", student);
			return "stu";// 閲嶅畾鍚戝悗鍙颁富椤�
		}
		addActionError("鐧诲綍澶辫触"); 
		return LOGIN;
	}

	// 娉ㄩ攢閫�嚭
	public String logout() throws Exception {
		ServletActionContext.getRequest().getSession().invalidate();
		return LOGIN;
	}

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public String getStuPwd() {
		return stuPwd;
	}

	public void setStuPwd(String stuPwd) {
		this.stuPwd = stuPwd;
	}

}
