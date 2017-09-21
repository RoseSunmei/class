package com.sm.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;

import com.sm.query.ClasQuery;
import com.sm.query.PageList;
import com.sm.service.IClasService;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.interceptor.annotations.InputConfig;
import com.sm.entities.Clas;

public class ClasAction extends CRUDAction<Clas> {
	private IClasService clasService;
	private Clas clas;
	private PageList pageList;
	private ClasQuery baseQuery = new ClasQuery();
	private Long clasId;

	public void setClasService(IClasService clasService) {
		this.clasService = clasService;
	}

	@Override
	protected void list() throws Exception {
		logger.debug("list");
		this.pageList = clasService.findByQuery(baseQuery);
	}

	@Override
	public String input() throws Exception {
		logger.debug("input");
		return INPUT;
	}

	@Override
	@InputConfig(methodName = Action.INPUT)
	public String save() throws Exception {
		if (clasId == null) {
			baseQuery.setCurrentPage(Integer.MAX_VALUE);
			clasService.save(clas);
		} else {
			clasService.update(clas);
		}
		return RELOAD;
	}

	// ajax鍒犻櫎
	@Override
	public String delete() throws Exception {
		logger.debug("delete");
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		try {
			if (clasId != null) {
				clasService.delete(clasId);
				out.print("{\"success\":true,\"msg\":\"鍒犻櫎鎴愬姛\"}");
			} else {
				out.print("{\"success\":false,\"msg\":\"鍒犻櫎澶辫触锛氭病鏈夊搴旂殑鏁版嵁\"}");
			}
		} catch (Exception e) {
			e.printStackTrace();
			out.print("{\"success\":false,\"msg\":\"璇ョ彮绾ф湁瀛︾敓,鏃犳硶鍒犻櫎\"}");
		}
		return NONE;
	}

	@Override
	public void prepareInput() throws Exception {
		if (clasId != null) {
			clas = clasService.get(clasId);
		}
	}

	@Override
	public void prepareSave() throws Exception {
		if (clasId != null) {
			clas = clasService.get(clasId);
		} else {
			clas = new Clas();
		}
	}

	@Override
	public Clas getModel() {
		return clas;
	}

	public ClasQuery getBaseQuery() {
		return baseQuery;
	}

	public void setBaseQuery(ClasQuery baseQuery) {
		this.baseQuery = baseQuery;
	}

	public Long getClasId() {
		return clasId;
	}

	public void setClasId(Long clasId) {
		this.clasId = clasId;
	}

	public PageList getPageList() {
		return pageList;
	}

	// ajax楠岃瘉鐝骇缂栧彿鏄惁閲嶅
	private String clasNum;

	public String getClasNum() {
		return clasNum;
	}

	public void setClasNum(String clasNum) {
		this.clasNum = clasNum;
	}

	public String checkclasNum() throws Exception {
		logger.debug("checkclasNum");
		System.out.println("checkclasNum:" + clasNum);
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter out = response.getWriter();
		if (clasId == null) {// 鏂板鐩存帴楠岃瘉鐢ㄦ埛鍚嶆槸鍚﹂噸澶�
			System.out.println(clasService.findByclasNum(clasNum));
			out.print(clasService.findByclasNum(clasNum));
		}
		return NONE;
	}
	
	//ajax楠岃瘉鐝骇鍚嶇О鏄惁閲嶅
	private String clasName;
	
	public String getClasName() {
		return clasName;
	}

	public void setClasName(String clasName) {
		this.clasName = clasName;
	}

	public String checkclasName() throws Exception {
		logger.debug("checkclasName");
		System.out.println("checkclasName:" + clasName);
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter out = response.getWriter();
		if (clasId == null) {// 鏂板鐩存帴楠岃瘉鐢ㄦ埛鍚嶆槸鍚﹂噸澶�
			System.out.println(clasService.findByclasName(clasName));
			out.print(clasService.findByclasName(clasName));
		}
		return NONE;
	}

}
