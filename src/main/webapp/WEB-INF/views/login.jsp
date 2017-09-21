 <%@ page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>班级信息管理系统登录页面</title>
<style type="text/css">
/body {
	background-image: url(images/wen1.jpg);
} 
</style>
<%@include file="/WEB-INF/views/common/head.jsp"%>
<script type="text/javascript">
	function show_box(id) {
		jQuery('.widget-box.visible').removeClass('visible');
		jQuery('#' + id).addClass('visible');
	}
	if (top != window) {
		top.location.href = window.location.href;
	}
</script>
</head>
<body class="login-layout">
	<div class="main-container">
		<div class="main-content">
			<div class="row">
				<div class="col-sm-10 col-sm-offset-1">
					<div class="login-container">
						<div class="center">
						<br/>
							<h1>
								<i class="icon-leaf green"></i> <span class="white">班级信息管理系统</span>
							</h1>
							<h4 class="blue">&copy; 信息科学与技术学院1405-2班</h4>
						</div>

						<div class="space-6"></div>

						<div class="position-relative">
							<div id="login-box"
								class="login-box visible widget-box no-border">
								<div class="widget-body">
									<div class="widget-main">
										<h4 class="header blue lighter bigger">
											<i class="icon-coffee green"></i> 请输入账户信息
										</h4>
										<div class="space-6"></div>
										<form action="login_check.action" method="post">
											<fieldset>
												<label class="block clearfix"> <span
													class="block input-icon input-icon-right"> <input
														type="text" name="stuName" class="form-control"
														placeholder="用户名" /> <i class="icon-user"></i>
												</span>
												</label> <label class="block clearfix"> <span
													class="block input-icon input-icon-right"> <input
														type="password" name="stuPwd" class="form-control"
														placeholder="密码" /> <i class="icon-lock"></i>
												</span>
												</label>
												<div class="space"></div>
												<div class="clearfix">
													<label class="inline"> <input type="checkbox"
														class="ace" /> <span class="lbl"> 记住我</span>
													</label>
													<button type="submit"
														class="width-35 pull-right btn btn-sm btn-primary">
														<i class="icon-key"></i> 登录
													</button>
												</div>
												<span style="color: red">${msg}</span>
												<div class="space-4"></div>
											</fieldset>
										</form>
									</div>
								</div>
							</div>
						</div>
						<!-- /position-relative -->
					</div>
				</div>
				<!-- /.col -->
			</div>
			<!-- /.row -->
		</div>
	</div>
	<!-- /.main-container -->
</body>
</html> 

