package com.sm.entities;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

public class Student {
	private Long stuId;// 瀛︾敓id
	private String stuNum;// 瀛︾敓缂栧彿
	private String stuName;// 瀛︾敓濮撳悕
	private String stuSex;// 瀛︾敓鎬у埆
	private Date stuBirth;// 瀛︾敓鍑虹敓鏃ユ湡
	private String stuPwd;// 瀛︾敓瀵嗙爜
	private String stuPhone;// 瀛︾敓鑱旂郴鐢佃瘽
	private String stuAddress;// 瀛︾敓瀹跺涵浣忓潃
	private Clas clas;// 鐝骇澶氬涓�
	private Set<Course> courses = new HashSet<Course>();// 璇剧▼澶氬澶�

	public Set<Course> getCourses() {
		return courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}

	public Student() {

	}

	public Student(String stuNum) {
		this.stuNum = stuNum;
	}

	public Student(Long stuId) {
		this.stuId = stuId;
	}

	public Long getStuId() {
		return stuId;
	}

	public void setStuId(Long stuId) {
		this.stuId = stuId;
	}

	public String getStuNum() {
		return stuNum;
	}

	public void setStuNum(String stuNum) {
		this.stuNum = stuNum;
	}

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public String getStuSex() {
		return stuSex;
	}

	public void setStuSex(String stuSex) {
		this.stuSex = stuSex;
	}

	public Date getStuBirth() {
		return stuBirth;
	}

	public void setStuBirth(Date stuBirth) {
		this.stuBirth = stuBirth;
	}

	public String getStuPwd() {
		return stuPwd;
	}

	public void setStuPwd(String stuPwd) {
		this.stuPwd = stuPwd;
	}

	public String getStuPhone() {
		return stuPhone;
	}

	public void setStuPhone(String stuPhone) {
		this.stuPhone = stuPhone;
	}

	public String getStuAddress() {
		return stuAddress;
	}

	public void setStuAddress(String stuAddress) {
		this.stuAddress = stuAddress;
	}

	public Clas getClas() {
		return clas;
	}

	public void setClas(Clas clas) {
		this.clas = clas;
	}

}
