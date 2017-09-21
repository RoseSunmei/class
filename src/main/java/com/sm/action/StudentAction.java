package com.sm.action;

import java.io.PrintWriter;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;
import com.sm.entities.Clas;
import com.sm.entities.Student;
import com.sm.query.PageList;
import com.sm.query.StudentQuery;
import com.sm.service.IClasService;
import com.sm.service.IStudentService;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.interceptor.annotations.InputConfig;

public class StudentAction extends CRUDAction<Student> {
	private IStudentService studentService;
	private IClasService clasService;
	private Student student;
	private Clas clas;
	private PageList pageList;
	private StudentQuery baseQuery = new StudentQuery();
	private Long stuId;

	public void setStudentService(IStudentService studentService) {
		this.studentService = studentService;
	}

	public void setClasService(IClasService clasService) {
		this.clasService = clasService;
	}

	@Override
	protected void list() throws Exception {
		logger.debug("list");
		this.pageList = studentService.findByQuery(baseQuery);
		putContext("allClas", clasService.getAll());
	}

	@Override
	public String input() throws Exception {
		logger.debug("input");
		putContext("allClas", clasService.getAll());
		return INPUT;
	}

	@Override
	@InputConfig(methodName = Action.INPUT)
	public String save() throws Exception {
		logger.debug("save");
		// ���û��ѡ��༶
		Clas clas = student.getClas();
		if (clas != null && clas.getClasId() == -1) {
			student.setClas(null);
		}
		if (stuId == null) {
			baseQuery.setCurrentPage(Integer.MAX_VALUE);
			studentService.save(student);
		} else {
			studentService.update(student);
		}
		return RELOAD;
	}

	// ajaxɾ��
	@Override
	public String delete() throws Exception {
		logger.debug("delete");
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		try {
			if (stuId != null) {
				studentService.delete(stuId);
				out.print("{\"success\":true,\"msg\":\"ɾ���ɹ�\"}");
			} else {
				out.print("{\"success\":false,\"msg\":\"ɾ��ʧ�ܣ�û�ж�Ӧ������\"}");
			}
		} catch (Exception e) {
			e.printStackTrace();
			out.print("{\"success\":false,\"msg\":\"<font color='red'>�쳣��Ϣ��"
					+ e.getMessage() + "</font>\"}");
		}
		return NONE;
	}

	@Override
	public void prepareInput() throws Exception {
		if (stuId != null) {
			student = studentService.get(stuId);
		}
	}

	@Override
	public void prepareSave() throws Exception {
		if (stuId != null) {
			// �����޸ĺ�û�г�����jspҳ������Բ���ʧ
			student = studentService.get(stuId);
			// ��ʱClas�ǳ־�״̬
			// �ı�student��Clas�����ǳ־�״̬
			student.setClas(null);
		} else {
			// ������ı���
			student = new Student();
		}
	}

	@Override
	public Student getModel() {
		return student;
	}

	public StudentQuery getBaseQuery() {
		return baseQuery;
	}

	public void setBaseQuery(StudentQuery baseQuery) {
		this.baseQuery = baseQuery;
	}

	public Long getStuId() {
		return stuId;
	}

	public void setStuId(Long stuId) {
		this.stuId = stuId;
	}

	public PageList getPageList() {
		return pageList;
	}

	// ajax��֤ѧ���Ƿ��ظ�
	private String stuNum;

	public String getStuNum() {
		return stuNum;
	}

	public void setStuNum(String stuNum) {
		this.stuNum = stuNum;
	}

	public Clas getClas() {
		return clas;
	}

	public void setClas(Clas clas) {
		this.clas = clas;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public String checkstuNum() throws Exception {
		logger.debug("checkstuNum");
		System.out.println("checkstuNum:" + stuNum);
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter out = response.getWriter();
		if (stuId == null) {// ����ֱ����֤�û����Ƿ��ظ�
			System.out.println(studentService.findBystuNum(stuNum));
			out.print(studentService.findBystuNum(stuNum));
		}
		return NONE;
	}

}
