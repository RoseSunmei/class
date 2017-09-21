package com.sm.action;

import com.sm.service.IClasService;
import com.sm.service.ICourseService;
import com.sm.service.IScoreService;
import com.sm.service.IStudentService;
public class ChoCourseAction extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private IStudentService studentService;
	private IScoreService scoreService;
	private ICourseService courseService;
	private IClasService clasService;
	private Long couId;
	private Long clasId;

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

	public void setStudentService(IStudentService studentService) {
		this.studentService = studentService;
	}

	public void setScoreService(IScoreService scoreService) {
		this.scoreService = scoreService;
	}

	public void setCourseService(ICourseService courseService) {
		this.courseService = courseService;
	}

	public void setClasService(IClasService clasService) {
		this.clasService = clasService;
	}

	@Override
	public String execute() throws Exception {
		putContext("allClas", clasService.getAll());
		putContext("allCourses", courseService.getAll());
		return SUCCESS;
	}

}
