<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="/WEB-INF/views/common/head.jsp"%>
<script type="text/javascript" src="js/model/clas.js"></script>

<title>班级管理</title>
<style type="text/css">
.suwz {
	position: relative;
	top: 5px;
}
</style>
</head>
<body>
	<%-- 	<s:debug /> --%>
	<s:fielderror style="color:red" />
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
				<li class="active">班级&amp;编辑管理</li>
			</ul>
			<!-- .breadcrumb -->
		</div>

		<div class="page-content">
			<div class="page-header">
				<h1>
					班级 <small> <i class="icon-double-angle-right"></i> 编辑页面
					</small>
				</h1>
			</div>
			<!-- /.page-header -->
			<div class="row">
				<div class="col-xs-12">
					<!-- PAGE CONTENT BEGINS -->
					<s:form action="clas_save" cssClass="form-horizontal" role="form">
						<s:hidden name="clasId" />
						<s:hidden name="baseQuery.currentPage" />
						<s:hidden name="baseQuery.pageSize" />
						<s:hidden name="baseQuery.clasNum" />
						<s:hidden name="baseQuery.clasName" />
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right"
								for="form-field-1">班级编号 </label>
							<div class="col-sm-9">
								<s:textfield name="clasNum" id="clasNum" placeholder="编号"
									cssClass="col-xs-10 col-sm-5" />
								<span class="suwz" id="pdclasNum"></span>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right"
								for="form-field-2">班级名称</label>
							<div class="col-sm-9">
								<s:textfield name="clasName" id="clasName" placeholder="名称"
									cssClass="col-xs-10 col-sm-5" />
								<span class="suwz" id="pdclasName"></span>
							</div>
						</div>
						<div class="col-md-offset-3 col-md-9">
							<button class="btn btn-info" id="saveBtn" type="submit"
								onclick="return checkSaveBtn()">
								<i class="icon-ok bigger-110"></i> 保存
							</button>
							&nbsp; &nbsp; &nbsp;
							<button type="button" class="btn" id="cancelBtn">
								<i class="icon-undo bigger-110"></i> 取消
							</button>
						</div>
					</s:form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>