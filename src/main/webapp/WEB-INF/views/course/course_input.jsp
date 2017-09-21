<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="/WEB-INF/views/common/head.jsp"%>
<script type="text/javascript" src="js/model/course.js"></script>
<title>课程管理</title>
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
				<li><a href="#">课程</a></li>
				<li class="active">课程&amp;编辑管理</li>
			</ul>
			<!-- .breadcrumb -->
		</div>

		<div class="page-content">
			<div class="page-header">
				<h1>
					课程 <small> <i class="icon-double-angle-right"></i> 编辑页面
					</small>
				</h1>
			</div>
			<!-- /.page-header -->
			<div class="row">
				<div class="col-xs-12">
					<!-- PAGE CONTENT BEGINS -->
					<s:form action="course_save" cssClass="form-horizontal" role="form">
						<s:hidden name="couId" />
						<s:hidden name="baseQuery.currentPage" />
						<s:hidden name="baseQuery.pageSize" />
						<s:hidden name="baseQuery.couNum" />
						<s:hidden name="baseQuery.couName" />
						<s:hidden name="baseQuery.couPro" />
						<s:hidden name="baseQuery.couCre" />
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right"
								for="form-field-1">课程编号 </label>
							<div class="col-sm-9">
								<s:textfield name="couNum" id="couNum" placeholder="编号 "
									cssClass="col-xs-10 col-sm-5" />
								<span class="suwz" id="pdcouNum"></span>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right"
								for="form-field-2">课程名称</label>
							<div class="col-sm-9">
								<s:textfield name="couName" id="couName" placeholder="名称"
									cssClass="col-xs-10 col-sm-5" />
								<span class="suwz" id="pdcouName"></span>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right"
								for="form-field-2">性质</label>
							<div class="col-sm-9">
								<span class="suwz"><s:radio name="couPro"
										id="couPro" list="#{'必修':'必修','选修':'选修','学位':'学位'}" /></span> <span class="suwz" id="pdcouPro"></span>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right"
								for="form-field-2">学分</label>
							<div class="col-sm-9">
								<s:textfield name="couCre" id="couCre" placeholder="学分"
									cssClass="col-xs-10 col-sm-5" />
								<span class="suwz" id="pdcouCre"></span>
							</div>
						</div>
						<div class="col-md-offset-3 col-md-9">
							<button class="btn btn-info" id="saveBtn" type="submit"
								onclick="return checkSaveBtn()">
								<i class="icon-ok bigger-110"></i> 保存
							</button>
							&nbsp; &nbsp; &nbsp;
							<button class="btn" id="cancelBtn">
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