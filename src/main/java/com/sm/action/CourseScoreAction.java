package com.sm.action;

import java.util.ArrayList;
import java.util.List;

import com.sm.service.ICourseService;
import com.sm.service.IScoreService;

public class CourseScoreAction extends BaseAction {
	private ICourseService courseService;
	private IScoreService scoreService;

	List<Object[]> list = new ArrayList<Object[]>();
	private Long couId;

	public void setCourseService(ICourseService courseService) {
		this.courseService = courseService;
	}

	public void setScoreService(IScoreService scoreService) {
		this.scoreService = scoreService;
	}

	@Override

	public String execute() throws Exception {
		System.out.println(couId);
		if (couId != null && couId != -1) {
			list = scoreService.findMaxMin(couId);
		} else {
			list = scoreService.findMaxMin();
		}
		putContext("allCourses", courseService.getAll());
		putContext("list", list);
		return SUCCESS;
	}

	public Long getCouId() {
		return couId;
	}

	public void setCouId(Long couId) {
		this.couId = couId;
	}

	public List<Object[]> getList() {
		return list;
	}

	public void setList(List<Object[]> list) {
		this.list = list;
	}

}
