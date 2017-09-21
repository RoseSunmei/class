package com.sm.entities;

import java.math.BigDecimal;

public class Course {

	private Long couId;// 课程id
	private String couNum;// 课程编号
	private String couName;// 课程名称
	private String couPro;// 课程性质
	private BigDecimal couCre;// 课程学分

	public Course() {

	}
	
	public Course(String couName){
		this.couName = couName;
	}

	public Course(Long couId) {
		this.couId = couId;
	}

	public Long getCouId() {
		return couId;
	}

	public void setCouId(Long couId) {
		this.couId = couId;
	}

	public String getCouNum() {
		return couNum;
	}

	public void setCouNum(String couNum) {
		this.couNum = couNum;
	}

	public String getCouName() {
		return couName;
	}

	public void setCouName(String couName) {
		this.couName = couName;
	}

	public String getCouPro() {
		return couPro;
	}

	public void setCouPro(String couPro) {
		this.couPro = couPro;
	}

	public BigDecimal getCouCre() {
		return couCre;
	}

	public void setCouCre(BigDecimal couCre) {
		this.couCre = couCre;
	}

	@Override
	public String toString() {
		return "Course [couId=" + couId + ", couNum=" + couNum + ", couName="
				+ couName + ", couPro=" + couPro + ", couCre=" + couCre + "]";
	}

}
