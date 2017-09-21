package com.sm.service.impl;

import java.math.BigDecimal;
import java.util.List;

import com.sm.entities.Score;
import com.sm.service.IScoreService;

public class ScoreServiceImpl extends BaseServiceImpl<Score> implements
		IScoreService {

	@Override
	public List<Object[]> findMaxMin() {
		String hql = "select s.course.couNum, s.course.couName, max(s.scoNum), min(s.scoNum), avg(s.scoNum)"
				+ "  from Score s group by s.course.couNum,s.course.couName";
		return baseDao.findByHql(hql);
	}

	@Override
	public List<Object[]> findMaxMin(Long couId) {
		String hql = "select s.course.couNum,s.course.couName,max(s.scoNum),min(s.scoNum),avg(s.scoNum)"
				+ "from Score s "
				+ "where s.course.couId =  " + couId + " group by s.course.couNum,s.course.couName";
		return baseDao.findByHql(hql);
	}

	@Override
	public List<Object[]> findStuCourse(String stuNum) {
		String hql = "select s.student.stuNum,s.course.couNum,s.course.couName,s.course.couCre,s.course.couPro,s.scoNum "
				+ " from Score s "
				+ " where s.student.stuNum =  " + stuNum
				+ " and s.scoNum != null";
		return baseDao.findByHql(hql);
	}

	@Override
	public BigDecimal findTotalcouCre(String stuNum) {
		String hql = "select sum(s.course.couCre) from Score s where s.student.stuNum = ?"
				+ " and s.scoNum >= 60";
		List<BigDecimal> list = baseDao.findByHql(hql, stuNum);
		return (BigDecimal) list.get(0);
	}

	@Override
	public Score findBystucou(String stuNum, String couName) {
		String hql = "select o from Score o where o.student.stuNum like ? and o.course.couName like ?";
		List<Score> list = baseDao.findByHql(hql, stuNum, couName);
		System.out.println("成绩:"+list.get(0));
		if (list.size() > 0) {
			return list.get(0);
		}
		return null;
	}
}
