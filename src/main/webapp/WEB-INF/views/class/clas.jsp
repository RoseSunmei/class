<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="/WEB-INF/views/common/head.jsp"%>
<title>学生管理</title>
<style type="text/css">
.suwz {
	position: relative;
	top: 2px;
}
</style>
</head>
<body>
	<%-- 	<s:debug /> --%>
	<s:form id="domainForm" action="clas">
		<div class="main-content">
			<div class="breadcrumbs" id="breadcrumbs">
				<script type="text/javascript">
					try {
						ace.settings.check('breadcrumbs', 'fixed')
					} catch (e) {
					}
				</script>
				<ul class="breadcrumb">
					<li><i class="icon-home home-icon"></i> <a href="/"
						target="_top">首页</a></li>
					<li><a href="#">班级</a></li>
					<li class="active">班级&amp;管理</li>
				</ul>
				<!-- .breadcrumb -->
			</div>
			<div class="page-content">
				<div class="page-header">
					<h3>
						<span class="suwz">编号:</span>
						<s:textfield name="baseQuery.clasNum" placeholder="班级编号" />
						&nbsp;&nbsp;<span class="suwz">名称:</span>
						<s:textfield name="baseQuery.stuName" placeholder="班级名称" />
						<a class="btn btn-purple btn-sm" href="javascript:;"
							onclick="go(1);"> 搜索 <i
							class="icon-search icon-on-right bigger-110"></i>
						</a> <a href="clas_input.action" class="btn btn-sm btn-danger">添加</a>
					</h3>
				</div>
				<!-- /.page-header -->
				<div class="row">
					<div class="col-xs-12">
						<!-- PAGE CONTENT BEGINS -->
						<div class="row">
							<div class="col-xs-12">
								<div class="table-responsive">
									<table id="sample-table-1"
										class="table table-striped table-bordered table-hover">
										<thead>
											<tr>
												<th>序号</th>
												<th>编号</th>
												<th>名称</th>
												<th><i class="icon-time bigger-110 hidden-480"></i> 操作</th>
											</tr>
										</thead>
										<tbody>
											<s:iterator value="pageList.rows" status="st">
												<tr
													<s:if test="clasId==#parameters['clasId'][0]">style="color: red"</s:if>>
													<td><s:property value='#st.count' /></td>
													<td>${clasNum}</td>
													<td>${clasName}</td>
													<td>
														<div
															class="visible-md visible-lg hden-sm hidden-xs btn-group">
															<button type="button" class="btn btn-xs btn-info"
																title="编辑"
																onclick="updateDomain('clas_input.action?clasId=${clasId}');">
																<i class="icon-edit bigger-120"></i>
															</button>
															<button type="button" class="btn btn-xs btn-danger"
																title="删除"
																onclick="deleteDomain('clas_delete.action?clasId=${clasId}');">
																<i class="icon-trash bigger-120"></i>
															</button>
														</div>
													</td>
												</tr>
											</s:iterator>
										</tbody>
									</table>
									<%@include file="/WEB-INF/views/common/page.jsp"%>
								</div>
								<!-- /.table-responsive -->
							</div>
							<!-- /span -->
						</div>
						<!-- /row -->
					</div>
				</div>
			</div>
		</div>
	</s:form>
</body>
</html>