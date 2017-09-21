package com.sm.entities;

public class Clas {

	private Long clasId;// 班级id
	private String clasNum;// 班级编号
	private String clasName;// 班级名称

	public Clas() {
	}

	public Clas(Long clasId) {
		this.clasId = clasId;
	}

	public Long getClasId() {
		return clasId;
	}

	public void setClasId(Long clasId) {
		this.clasId = clasId;
	}

	public String getClasNum() {
		return clasNum;
	}

	public void setClasNum(String clasNum) {
		this.clasNum = clasNum;
	}

	public String getClasName() {
		return clasName;
	}

	public void setClasName(String clasName) {
		this.clasName = clasName;
	}

	@Override
	public String toString() {
		return "Clas [clasId=" + clasId + ", clasNum=" + clasNum
				+ ", clasName=" + clasName + "]";
	}

}
