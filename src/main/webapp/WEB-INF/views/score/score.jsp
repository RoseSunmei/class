<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="/WEB-INF/views/common/head.jsp"%>
<script type="text/javascript" src="js/model/score.js"></script>
<title>学生管理</title>
<style type="text/css">
.suwz {
	position: relative;
	top: 2px;
}
</style>
</head>
<body>
	<s:debug />
	<s:form id="domainForm" action="score" method="post">
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
					<li><a href="#">成绩</a></li>
					<li class="active">成绩&amp;录入</li>
				</ul>
				<!-- .breadcrumb -->
			</div>
			<div class="page-content">
				<div class="page-header">
					<h3>
						<span class="suwz">&nbsp;&nbsp;班级:&nbsp;<s:select
								list="#allClas" name="baseQuery.clasId" listValue="clasName"
								listKey="clasId" headerKey="-1" headerValue="-----请选择-----"
								style="font-size:16px;" onchange='$("#domainForm").submit();' /></span>
						<span class="suwz">&nbsp;&nbsp;课程:&nbsp;<s:select
								list="#allCourses" name="baseQuery.couId" listValue="couName"
								listKey="couId" headerKey="-1" headerValue="-----请选择-----"
								style="font-size:16px;" onchange='$("#domainForm").submit();' /></span>
						<span class="suwz">&nbsp;&nbsp;学号:&nbsp;</span>
						<s:textfield name="baseQuery.stuNum" placeholder="根据学号录入" />
						<a class="btn btn-purple btn-sm" href="javascript:;"
							onclick="go(1);"> 搜索 <i
							class="icon-search icon-on-right bigger-110"></i>
						</a>
						<button id="btnSubmit" class="btn btn-info" type="submit"
							style="position: relative; left: 22%">
							<i class="icon-ok bigger-110"></i> 全部保存
						</button>
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
												<th>课程</th>
												<th>班级</th>
												<th>学号</th>
												<th>姓名</th>
												<th>成绩</th>
												<th><i class="icon-time bigger-110 hidden-480"></i>保存</th>
											</tr>
										</thead>
										<tbody>
											<s:iterator value="pageList.rows" status="st">
												<tr id="">
													<td style="width: 5%"><s:property value='#st.count' /></td>
													<td>${course.couName }</td>
													<td>${student.clas.clasName }</td>
													<td>${student.stuNum }</td>
													<td>${student.stuName }</td>
													<td style="width: 10%"><s:textfield name="scoNum"></s:textfield></td>
													<td style="width: 15%"><a href="#"
														onclick="update(this)"><button type="button"
																class="btn btn-xs btn-info">
																<i class="icon-save bigger-120"></i>
															</button></a></td>
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