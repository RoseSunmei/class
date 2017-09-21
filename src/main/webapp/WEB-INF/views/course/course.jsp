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
	<s:form id="domainForm" action="course">
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
					<li class="active">课程&amp;管理</li>
				</ul>
				<!-- .breadcrumb -->
			</div>
			<div class="page-content">
				<div class="page-header">
					<h3>
						<span class="suwz">编号:</span>
						<s:textfield name="baseQuery.couNum" placeholder="课程编号" />
						&nbsp;&nbsp;<span class="suwz">名称:</span>
						<s:textfield name="baseQuery.couName" placeholder="课程名称" />
						&nbsp;&nbsp;<span class="suwz">性质:</span> <span class="suwz"><s:select
								list="#{'':'--请选择--','学位':'学位','必修':'必修','选修':'选修'}"
								name="baseQuery.couPro" style="font-size:16px;"
								onchange='$("#domainForm").submit();' /></span> &nbsp;&nbsp;<span
							class="suwz">学分:</span> <span class="suwz"><s:textfield
								name="baseQuery.couCre" placeholder="课程学分" /></span> <a
							class="btn btn-purple btn-sm" href="javascript:;"
							onclick="go(1);"> 搜索 <i
							class="icon-search icon-on-right bigger-110"></i>
						</a> <a href="course_input.action" class="btn btn-sm btn-danger">添加</a>
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
												<th>性质</th>
												<th>学分</th>
												<th><i class="icon-time bigger-110 hidden-480"></i> 操作</th>
											</tr>
										</thead>
										<tbody>
											<s:iterator value="pageList.rows" status="st">
												<tr
													<s:if test="couId==#parameters['couId'][0]">style="color: red"</s:if>>
													<td><s:property value='#st.count' /></td>
													<td>${couNum}</td>
													<td>${couName}</td>
													<td>${couPro}</td>
													<td>${couCre}</td>
													<td>
														<div
															class="visible-md visible-lg hden-sm hidden-xs btn-group">
															<button type="button" class="btn btn-xs btn-info"
																title="编辑"
																onclick="updateDomain('course_input.action?couId=${couId}');">
																<i class="icon-edit bigger-120"></i>
															</button>
															<button type="button" class="btn btn-xs btn-danger"
																title="删除"
																onclick="deleteDomain('course_delete.action?couId=${couId}');">
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