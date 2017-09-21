<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="/WEB-INF/views/common/head.jsp"%>
<title>课程分数管理</title>
<style type="text/css">
.suwz {
	position: relative;
	top: 2px;
}
</style>
</head>
<body>
	<%-- 	<s:debug /> --%>
	<s:form id="domainForm" action="coursescore">
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
					<li><a href="#">课程分数</a></li>
					<li class="active">课程分数&amp;统计</li>
				</ul>
				<!-- .breadcrumb -->
			</div>
			<div class="page-content">
				<div class="page-header">
					<h3>
						<span class="suwz">课程名称:</span> <span class="suwz"> <s:select
								list="#allCourses" name="couId" listValue="couName"
								listKey="couId" headerKey="-1" headerValue="-----请选择-----"
								style="font-size:16px;" onchange='$("#domainForm").submit();'/></span> <a class="btn btn-purple btn-sm"
							href="javascript:;" onclick="go(1);"> 搜索 <i
							class="icon-search icon-on-right bigger-110"></i>
						</a>
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
												<th>课程编号</th>
												<th>课程名称</th>
												<th>最高分</th>
												<th>最低分</th>
												<th>平均分</th>
											</tr>
										</thead>
										<tbody>
											<s:iterator value="#list" id="value" status="st">
												<tr>
													<td><s:property value='#st.count' /></td>
													<td><s:property value='#list[#st.index][0]' /></td>
													<td><s:property value='#list[#st.index][1]' /></td>
													<td><s:property value='#list[#st.index][2]' /></td>
													<td><s:property value='#list[#st.index][3]' /></td>
													<td><s:property value='#list[#st.index][4]' /></td>
												</tr>
											</s:iterator>
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