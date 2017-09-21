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
	<%-- 	<s:debug /> --%>
	<s:form id="domainForm" action="chocourse">
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
					<li><a href="#">课程</a></li>
					<li class="active">学生&amp;选课</li>
				</ul>
				<!-- .breadcrumb -->
			</div>
			<div class="page-content">
				<div class="page-header">
					<h3>
						<span class="suwz">课程:&nbsp;<s:select list="#allCourses"
								name="baseQuery.couId" id="course" listValue="couName"
								listKey="couId" headerKey="-1" headerValue="-------请选择-------"
								style="font-size:16px;" /></span> <span class="suwz">&nbsp;&nbsp;班级:&nbsp;<s:select
								list="#allClas" name="baseQuery.clasId" id="clas"
								listValue="clasName" listKey="clasId" headerKey="-1"
								headerValue="-----请选择-----" style="font-size:16px;" /></span>
						<button id="btnSubmit" class="btn btn-info" type="button">
							<i class="icon-ok bigger-110"></i> 确认选课
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
										</thead>
										<tbody>
										</tbody>
									</table>
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