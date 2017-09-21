<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="/WEB-INF/views/common/head.jsp"%>
<script type="text/javascript" src="js/model/student.js"></script>
<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>
<title>学生管理</title>
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
				<li><a href="#">学生</a></li>
				<li class="active">学生&amp;编辑管理</li>
			</ul>
			<!-- .breadcrumb -->
		</div>

		<div class="page-content">
			<div class="page-header">
				<h1>
					学生 <small> <i class="icon-double-angle-right"></i> 编辑页面
					</small>
				</h1>
			</div>
			<!-- /.page-header -->
			<div class="row">
				<div class="col-xs-12">
					<!-- PAGE CONTENT BEGINS -->
					<s:form action="student_save" cssClass="form-horizontal"
						role="form">
						<s:hidden name="stuId" />
						<s:hidden name="baseQuery.currentPage" />
						<s:hidden name="baseQuery.pageSize" />
						<s:hidden name="baseQuery.stuNum" />
						<s:hidden name="baseQuery.stuName" />
						<s:hidden name="baseQuery.clasId" />
						<s:hidden name="baseQuery.stuAddress" />
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right"
								for="form-field-1">学号 </label>
							<div class="col-sm-9">
								<s:textfield name="stuNum" id="stuNum" placeholder="例如:20142922"
									cssClass="col-xs-10 col-sm-5" />
								<span class="suwz" id="pdstuNum"></span>
							</div>
						</div>
						<s:if test="stuId==null">
							<div class="space-4"></div>
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"
									for="form-field-2">密码</label>
								<div class="col-sm-9">
									<s:password name="stuPwd" id="stuPwd" placeholder="密码"
										cssClass="col-xs-10 col-sm-5" />
									<span class="suwz" id="pdstuPwd"></span>
								</div>
							</div>
						</s:if>
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right"
								for="form-field-1">班级 </label>
							<div class="col-sm-9">
								<s:select list="#allClas" id="clas" name="clas.clasId"
									listValue="clasName" listKey="clasId" headerKey="-1"
									headerValue="-----请选择-----" style="font-size:16px;" />
								<span id="pdclas"></span>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right"
								for="form-field-1">姓名 </label>
							<div class="col-sm-9">
								<s:textfield name="stuName" id="stuName" placeholder="例如:张三"
									cssClass="col-xs-10 col-sm-5" />
								<span id="pdstuName"></span>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right"
								for="form-field-1">性别 </label>
							<div class="col-sm-9">
								<div class="suwz">
									<s:radio name="stuSex" id="stuSex" list="#{'男':'男','女':'女'}" />
									<span id="pdstuSex"></span>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right"
								for="form-field-1">出生日期 </label>
							<div class="col-sm-9">
								<s:textfield name="stuBirth" id="stuBirth" size="12"
									style="height:30px;" cssClass="Wdate"
									onClick="WdatePicker({maxDate:new Date()})" />
								<span id="pdstuBirth"></span>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right"
								for="form-field-1">联系电话 </label>
							<div class="col-sm-9">
								<s:textfield name="stuPhone" id="stuPhone"
									placeholder="例如:15130256325" cssClass="col-xs-10 col-sm-5" />
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right"
								for="form-field-1">家庭住址 </label>
							<div class="col-sm-9">
								<s:textfield name="stuAddress" id="stuAddress"
									placeholder="例如:河北省石家庄市北二环" cssClass="col-xs-10 col-sm-5" />
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