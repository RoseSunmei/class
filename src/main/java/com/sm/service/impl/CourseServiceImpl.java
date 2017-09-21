package com.sm.service.impl;

import java.util.List;

import com.sm.entities.Course;
import com.sm.service.ICourseService;

public class CourseServiceImpl extends BaseServiceImpl<Course> implements
		ICourseService {

	@Override
	public boolean findBycouNum(String couNum) {
		String hql = "select count(o) from Course o where o.couNum=?";
		List<Long> list = baseDao.findByHql(hql, couNum);
		if (list.get(0) > 0) {// 课程编号重复
			return false;
		}
		return true;
	}

	@Override
	public boolean findBycouName(String couName) {
		String hql = "select count(o) from Course o where o.couName=?";
		List<Long> list = baseDao.findByHql(hql, couName);
		if (list.get(0) > 0) {// 课程名称重复
			return false;
		}
		return true;
	}

}
