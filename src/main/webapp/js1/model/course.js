$(function() {
	// 学分数字验证
	$("#couCre").keyup(function() { // keyup事件处理
		$(this).val($(this).val().replace(/[^0-9.]/g, ''))
	}).bind("paste", function() { // CTR+V事件处理
		$(this).val($(this).val().replace(/\D|^0/g, ''))
	}).css("ime-mode", "disabled"); // CSS设置输入法不可用
	// ajax验证课程编号是否存在
	$("#couNum")
			.keyup(
					function() {
						var couNum = $("#couNum").val();
						$
								.ajax({
									url : "course_checkcouNum.action?couNum="
											+ couNum,
									type : "post",
									dataType : "json",
									success : function(data) {
										if (data) {
											$("#couNum").css("background",
													"white");
											$("#pdcouNum")
													.html(
															"<font color='green'>√</font>");
											$("#saveBtn").attr("disabled",
													false);
										} else {
											$("#couNum").css("background",
													"red");
											$("#pdcouNum")
													.html(
															"<font color='red'> * 该课程编号已经存在</font>");
											$("#saveBtn")
													.attr("disabled", true);
										}
									}
								});
					});
	// ajax验证课程名称是否存在
	$("#couName").keyup(
			function() {
				var couName = $("#couName").val();
				$.ajax({
					url : "course_checkcouName.action?couName=" + couName,
					type : "post",
					dataType : "json",
					success : function(data) {
						if (data) {
							$("#couName").css("background", "white");
							$("#pdcouName")
									.html("<font color='green'>√</font>");
							$("#saveBtn").attr("disabled", false);
						} else {
							$("#couName").css("background", "red");
							$("#pdcouName").html(
									"<font color='red'> * 该课程名称已经存在</font>");
							$("#saveBtn").attr("disabled", true);
						}
					}
				});
			});
	// 课程性质验证
	$("input[name=couPro]").click(function() {
		$("#pdcouPro").html("<font color='green'>√</font>");
	});
	// 学分验证
	$("#couCre").blur(function() {
		$("#pdcouCre").html("<font color='green'>√</font>");
	});
});
// 保存按钮验证
function checkSaveBtn() {
	var flag = 0;
	// 验证课程编号
	if ($("#couNum").val() == "") {
		$("#pdcouNum").html("<font color='red'> * 课程编号不能为空</font>");
		flag = 1;
	}
	// 验证课程名称
	if ($("#couName").val() == "") {
		$("#pdcouName").html("<font color='red'> * 课程名称不能为空</font>");
		flag = 1;
	}
	// 课程性质验证
	var couPro = $("input[name=couPro]");
	var pro = 0;
	for ( var i = 0; i < couPro.length; i++) {
		if (couPro[i].checked) {
			pro = 1;
		}
	}
	if (pro == 0) {
		$("#pdcouPro").html("<font color='red'> * 请选择课程性质</font>");
		flag = 1;
	}
	// 学分验证
	if ($("#couCre").val() == "") {
		$("#pdcouCre").html("<font color='red'> * 课程学分不能为空</font>");
		flag = 1;
	}
	// 判定页面输入是否合法
	if (flag == 1) {
		return false;
	} else if (flag == 0) {
		return true;
	}
}