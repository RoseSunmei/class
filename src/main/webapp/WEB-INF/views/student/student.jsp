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
	<s:form id="domainForm" action="student">
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
					<li><a href="#">学生</a></li>
					<li class="active">学生&amp;管理</li>
				</ul>
				<!-- .breadcrumb -->
			</div>
			<div class="page-content">
				<div class="page-header">
					<h3>
						<span class="suwz">学号:</span>
						<s:textfield name="baseQuery.stuNum" placeholder="学号" />
						&nbsp;&nbsp;<span class="suwz">姓名:</span>
						<s:textfield name="baseQuery.stuName" placeholder="姓名" />
						&nbsp;&nbsp;<span class="suwz">班级:</span> <span class="suwz"><s:select
								list="#allClas" name="baseQuery.clasId" listValue="clasName"
								listKey="clasId" headerKey="-1" headerValue="-----请选择-----"
								style="font-size:16px;" onchange='$("#domainForm").submit();'/></span> &nbsp;&nbsp;<span class="suwz">家庭地址:</span>
						<s:textfield name="baseQuery.stuAddress" placeholder="家庭住址" />
						<a class="btn btn-purple btn-sm" href="javascript:;"
							onclick="go(1);"> 搜索 <i
							class="icon-search icon-on-right bigger-110"></i>
						</a> <a href="student_input.action" class="btn btn-sm btn-danger">添加</a>
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
												<th>学号</th>
												<th>班级</th>
												<th>姓名</th>
												<th>性别</th>
												<th>出生日期</th>
												<th>联系电话</th>
												<th>家庭住址</th>
												<th><i class="icon-time bigger-110 hidden-480"></i> 操作</th>
											</tr>
										</thead>
										<tbody>
											<s:iterator value="pageList.rows" status="st">
												<tr
													<s:if test="stuId==#parameters['stuId'][0]">style="color: red"</s:if>>
													<td><s:property value='#st.count' /></td>
													<td>${stuNum}</td>
													<td>${clas.clasName}</td>
													<td>${stuName}</td>
													<td>${stuSex}</td>
													<td>${stuBirth}</td>
													<td>${stuPhone}</td>
													<td>${stuAddress}</td>
													<td>
														<div
															class="visible-md visible-lg hden-sm hidden-xs btn-group">
															<button type="button" class="btn btn-xs btn-info" title="编辑"
																onclick="updateDomain('student_input.action?stuId=${stuId}');">
																<i class="icon-edit bigger-120"></i>
															</button>
															<button type="button" class="btn btn-xs btn-danger" title="删除"
																onclick="deleteDomain('student_delete.action?stuId=${stuId}');">
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