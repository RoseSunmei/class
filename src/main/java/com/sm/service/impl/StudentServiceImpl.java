package com.sm.service.impl;

import java.util.List;
import com.sm.entities.Student;
import com.sm.service.IStudentService;

public  class StudentServiceImpl extends BaseServiceImpl<Student> implements
		IStudentService {

	@Override
	public boolean findBystuNum(String stuNum) {
		String hql = "select count(o) from Student o where o.stuNum=?";
		List<Long> list = baseDao.findByHql(hql, stuNum);
		if (list.get(0) > 0) {// 学号重复
			return false;
		}
		return true;
	}

	@Override
	public Student findByLogin(String stuName, String stuPwd) {
		String hql = "select o from Student o where o.stuName=? and o.stuPwd=?";
		List<Student> list = baseDao.findByHql(hql, stuName, stuPwd);
		if (list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

}
