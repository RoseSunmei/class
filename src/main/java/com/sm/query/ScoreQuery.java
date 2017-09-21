package com.sm.query;

import org.apache.commons.lang.StringUtils;
import com.sm.entities.Score;

public class ScoreQuery extends BaseQuery {

	private Long couId;
	private Long clasId;
	private String stuNum;

	public ScoreQuery() {
		super(Score.class.getName());
	}

	@Override
	protected void addWhere() {
		if (couId != null && couId != -1) {
			addCondition("o.course.couId=?", couId);
		}
		if (clasId != null && clasId != -1) {
			addCondition("o.student.clas.clasId=?", clasId);
		}
		if (StringUtils.isNotBlank(stuNum)) {
			addCondition("o.student.stuNum like ?", "%" + stuNum + "%");
		}
	}

	public Long getCouId() {
		return couId;
	}

	public void setCouId(Long couId) {
		this.couId = couId;
	}

	public Long getClasId() {
		return clasId;
	}

	public void setClasId(Long clasId) {
		this.clasId = clasId;
	}

	public String getStuNum() {
		return stuNum;
	}

	public void setStuNum(String stuNum) {
		this.stuNum = stuNum;
	}

}
