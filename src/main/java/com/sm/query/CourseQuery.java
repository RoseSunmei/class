package com.sm.query;

import java.math.BigDecimal;

import org.apache.commons.lang.StringUtils;
import com.sm.entities.Course;

/**
 * 
 * 瀛愮被鑷繁鐨勬煡璇㈡潯浠讹細鐢ㄦ埛鍚嶏紝email锛岄儴闂�
 * 
 */
public class CourseQuery extends BaseQuery {

	private String couNum;
	private String couName;
	private String couPro;
	private BigDecimal couCre;

	public CourseQuery() {
		super(Course.class.getName());
	}

	@Override
	protected void addWhere() {
		if (StringUtils.isNotBlank(couNum)) {
			addCondition("o.couNum like ?", "%" + couNum + "%");
		}
		if (StringUtils.isNotBlank(couName)) {
			addCondition("o.couName like ?", "%" + couName + "%");
		}
		if (StringUtils.isNotBlank(couPro)) {
			addCondition("o.couPro like ?", "%" + couPro + "%");
		}
		if (couCre != null) {
			addCondition("o.couCre = ?", couCre);
		}
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

}
