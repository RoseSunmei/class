$(function() {
	// 输入学号非数字验证
	$("#stuNum").keyup(function() { // keyup事件处理
		$(this).val($(this).val().replace(/\D|^0/g, ''));
	}).bind("paste", function() { // CTR+V事件处理
		$(this).val($(this).val().replace(/\D|^0/g, ''));
	}).css("ime-mode", "disabled"); // CSS设置输入法不可用
	// 输入手机号非数字验证
	$("#stuPhone").keyup(function() { // keyup事件处理
		$(this).val($(this).val().replace(/\D|^0/g, ''));
	}).bind("paste", function() { // CTR+V事件处理
		$(this).val($(this).val().replace(/\D|^0/g, ''));
	}).css("ime-mode", "disabled"); // CSS设置输入法不可用

	// ajax验证学号是否存在
	$("#stuNum").keyup(function() {
		var stuNum = $("#stuNum").val();
		$.ajax({
			url : "student_checkstuNum.action?stuNum=" + stuNum,
			type : "post",
			dataType : "json",
			success : function(data) {
				if (data) {
					$("#stuNum").css("background", "white");
					$("#pdstuNum").html("<font color='green'>√</font>");
					$("#saveBtn").attr("disabled", false);
				} else {
					$("#stuNum").css("background", "red");
					$("#pdstuNum").html("<font color='red'> * 该学号已经存在</font>");
					$("#saveBtn").attr("disabled", true);
				}
			}
		});
	});
	// 密码验证
	$("#stuPwd").blur(function() {
		if ($("#stuPwd").val() != "") {
			$("#pdstuPwd").html("<font color='green'>√</font>");
		}
	});
	// 班级验证
	$("#clas").change(function() {
		if ($("#area option:selected").val() != -1) {
			$("#pdclas").html("<font color='green'>√</font>");
		}
	});
	// 姓名验证
	$("#stuName").blur(function() {
		if ($("#stuName").val() != "") {
			$("#pdstuName").html("<font color='green'>√</font>");
		}
	});
	// 性别验证
	$("input[name=stuSex]").click(function() {
		$("#pdstuSex").html("<font color='green'>√</font>");
	});
	// 出生日期验证
	$("#stuBirth")
			.blur(
					function() {
						var stuBirth = $("#stuBirth").val();
						var month = stuBirth.substring(5, 7);
						var day = stuBirth.substring(8, 10);
						var birth = /^[0-9]{4}-[0-1]?[0-9]{1}-[0-3]?[0-9]{1}$/;
						if (stuBirth != "") {
							if (birth.test(stuBirth) && month <= 12 && day <= 31) {
								$("#pdstuBirth").html(
										"<font color='green'>√</font>");
							} else {
								$("#pdstuBirth")
										.html(
												"<font color='red'> * 出生日期格式不正确，正确格式应为2011-10-10</font>");
							}
						}
					});
});
// 保存按钮验证
function checkSaveBtn() {
	var flag = 0;
	// 学号验证
	if ($("#stuNum").val() == "") {
		$("#pdstuNum").html("<font color='red'> * 学号不能为空</font>");
		flag = 1;
	}
	// 密码验证
	if ($("#stuPwd").val() == "") {
		$("#pdstuPwd").html("<font color='red'> * 密码不能为空</font>");
		flag = 1;
	}
	// 班级验证
	if ($("#clas option:selected").val() == -1) {
		$("#pdclas").html("<font color='red'> * 班级不能为空</font>");
		flag = 1;
	}
	// 姓名验证
	if ($("#stuName").val() == "") {
		$("#pdstuName").html("<font color='red'> * 姓名不能为空</font>");
		flag = 1;
	}
	// 学生性别验证
	var stuSex = $("input[name=stuSex]");
	var sex = 0;
	for ( var i = 0; i < stuSex.length; i++) {
		if (stuSex[i].checked) {
			sex = 1;
		}
	}
	if (sex == 0) {
		$("#pdstuSex").html("<font color='red'> * 请选择性别</font>");
		flag = 1;
	}
	// 出生日期验证
	var stuBirth = $("#stuBirth").val();
	var month = stuBirth.substring(5, 7);
	var day = stuBirth.substring(8, 10);
	var birth = /^[0-9]{4}-[0-1]?[0-9]{1}-[0-3]?[0-9]{1}$/;
	if (stuBirth != "") {
		if (!birth.test(stuBirth) || month > 12 || day > 30) {
			$("#pdstuBirth")
					.html(
							"<font color='red'> * 出生日期格式不正确，正确格式应为2011-10-10</font></font>");
			flag = 1;
		}
	}
	// 判定页面输入是否合法
	if (flag == 1) {
		return false;
	} else if (flag == 0) {
		return true;
	}
}