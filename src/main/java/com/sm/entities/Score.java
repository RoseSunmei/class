package com.sm.entities;

import java.math.BigDecimal;

public class Score {

	private Long scoId;
	private BigDecimal scoNum;
	private Student student;// 瀛︾敓澶氬涓�
	private Course course;// 璇剧▼澶氬涓�
	
	

	public Long getScoId() {
		return scoId;
	}

	public void setScoId(Long scoId) {
		this.scoId = scoId;
	}

	public BigDecimal getScoNum() {
		return scoNum;
	}

	public void setScoNum(BigDecimal scoNum) {
		this.scoNum = scoNum;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	@Override
	public String toString() {
		return "Score [scoId=" + scoId + ", scoNum=" + scoNum + ", student="
				+ student + ", course=" + course + "]";
	}

}
