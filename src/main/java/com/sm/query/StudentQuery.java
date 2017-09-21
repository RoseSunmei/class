package com.sm.query;

import org.apache.commons.lang.StringUtils;
import com.sm.entities.Student;

/**
 * 
 * 瀛愮被鑷繁鐨勬煡璇㈡潯浠讹細鐢ㄦ埛鍚嶏紝email锛岄儴闂�
 * 
 */
public class StudentQuery extends BaseQuery {

	private String stuNum;
	private String stuName;
	private String stuAddress;
	private Long clasId;
	private Long stuId;

	public StudentQuery() {
		super(Student.class.getName());
	}

	@Override
	protected void addWhere() {
		if (StringUtils.isNotBlank(stuNum)) {
			addCondition("o.stuNum like ?", "%" + stuNum + "%");
		}
		if (StringUtils.isNotBlank(stuName)) {
			addCondition("o.stuName like ?", "%" + stuName + "%");
		}
		if (StringUtils.isNotBlank(stuAddress)) {
			addCondition("o.stuAddress like ?", "%" + stuAddress + "%");
		}
		if (clasId != null && clasId != -1L) {
			addCondition("o.clas.clasId=?", clasId);
		}
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

	public String getStuAddress() {
		return stuAddress;
	}

	public void setStuAddress(String stuAddress) {
		this.stuAddress = stuAddress;
	}

	public Long getClasId() {
		return clasId;
	}

	public void setClasId(Long clasId) {
		this.clasId = clasId;
	}

	public Long getStuId() {
		return stuId;
	}

	public void setStuId(Long stuId) {
		this.stuId = stuId;
	}

}
