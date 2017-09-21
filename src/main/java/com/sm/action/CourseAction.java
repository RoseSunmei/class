package com.sm.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;
import com.sm.entities.Course;
import com.sm.query.CourseQuery;
import com.sm.query.PageList;
import com.sm.service.ICourseService;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.interceptor.annotations.InputConfig;

public class CourseAction extends CRUDAction<Course> {
	private ICourseService courseService;
	private Course course;
	private PageList pageList;
	private CourseQuery baseQuery = new CourseQuery();
	private Long couId;

	public void setCourseService(ICourseService courseService) {
		this.courseService = courseService;
	}

	@Override
	protected void list() throws Exception {
		logger.debug("list");
		this.pageList = courseService.findByQuery(baseQuery);
	}

	@Override
	public String input() throws Exception {
		logger.debug("input");
		return INPUT;
	}

	@Override
	@InputConfig(methodName = Action.INPUT)
	public String save() throws Exception {
		if (couId == null) {
			baseQuery.setCurrentPage(Integer.MAX_VALUE);
			courseService.save(course);
		} else {
			courseService.update(course);
		}
		return RELOAD;
	}

	// ajax删除
	@Override
	public String delete() throws Exception {
		logger.debug("delete");
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		try {
			if (couId != null) {
				courseService.delete(couId);
				out.print("{\"success\":true,\"msg\":\"删除成功\"}");
			} else {
				out.print("{\"success\":false,\"msg\":\"删除失败：没有对应的数据\"}");
			}
		} catch (Exception e) {
			e.printStackTrace();
			out.print("{\"success\":false,\"msg\":\"<font color='red'>异常信息："
					+ e.getMessage() + "</font>\"}");
		}
		return NONE;
	}

	@Override
	public void prepareInput() throws Exception {
		if (couId != null) {
			course = courseService.get(couId);
		}
	}

	@Override
	public void prepareSave() throws Exception {
		if (couId != null) {
			course = courseService.get(couId);
		} else {
			course = new Course();
		}
	}

	@Override
	public Course getModel() {
		return course;
	}

	public CourseQuery getBaseQuery() {
		return baseQuery;
	}

	public void setBaseQuery(CourseQuery baseQuery) {
		this.baseQuery = baseQuery;
	}

	public Long getCouId() {
		return couId;
	}

	public void setCouId(Long couId) {
		this.couId = couId;
	}

	public PageList getPageList() {
		return pageList;
	}

	// ajax验证班级编号是否重复
	private String couNum;

	public String getCouNum() {
		return couNum;
	}

	public void setCouNum(String couNum) {
		this.couNum = couNum;
	}

	public String checkcouNum() throws Exception {
		logger.debug("checkcouNum");
		System.out.println("checkcouNum:" + couNum);
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter out = response.getWriter();
		if (couId == null) {// 新增直接验证用户名是否重复
			System.out.println(courseService.findBycouNum(couNum));
			out.print(courseService.findBycouNum(couNum));
		}
		return NONE;
	}

	// ajax验证班级名称是否重复
	private String couName;

	public String getCouName() {
		return couName;
	}

	public void setCouName(String couName) {
		this.couName = couName;
	}

	public String checkcouName() throws Exception {
		logger.debug("checkcouName");
		System.out.println("checkcouName:" + couName);
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter out = response.getWriter();
		if (couId == null) {// 新增直接验证用户名是否重复
			System.out.println(courseService.findBycouName(couName));
			out.print(courseService.findBycouName(couName));
		}
		return NONE;
	}
}
