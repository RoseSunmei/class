package com.sm.query;

import org.apache.commons.lang.StringUtils;
import com.sm.entities.Clas;

/**
 * 
 * 瀛愮被鑷繁鐨勬煡璇㈡潯浠讹細鐢ㄦ埛鍚嶏紝email锛岄儴闂�
 * 
 */
public class ClasQuery extends BaseQuery {

	private String clasNum;
	private String clasName;

	public ClasQuery() {
		super(Clas.class.getName());
	}

	@Override
	protected void addWhere() {
		if (StringUtils.isNotBlank(clasNum)) {
			addCondition("o.clasNum like ?", "%" + clasNum + "%");
		}
		if (StringUtils.isNotBlank(clasName)) {
			addCondition("o.clasName like ?", "%" + clasName + "%");
		}
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

}
