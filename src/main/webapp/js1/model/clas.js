$(function() {
	// ajax验证班级编号是否存在
	$("#clasNum").keyup(
			function() {
				var clasNum = $("#clasNum").val();
				$.ajax({
					url : "clas_checkclasNum.action?clasNum=" + clasNum,
					type : "post",
					dataType : "json",
					success : function(data) {
						if (data) {
							$("#clasNum").css("background", "white");
							$("#pdclasNum")
									.html("<font color='green'>√</font>");
							$("#saveBtn").attr("disabled", false);
						} else {
							$("#clasNum").css("background", "red");
							$("#pdclasNum").html(
									"<font color='red'> * 该班级编号已经存在</font>");
							$("#saveBtn").attr("disabled", true);
						}
					}
				});
			});
	// ajax验证班级名称是否存在
	$("#clasName").keyup(
			function() {
				var clasName = $("#clasName").val();
				$.ajax({
					url : "clas_checkclasName.action?clasName=" + clasName,
					type : "post",
					dataType : "json",
					success : function(data) {
						if (data) {
							$("#clasName").css("background", "white");
							$("#pdclasName").html(
									"<font color='green'>√</font>");
							$("#saveBtn").attr("disabled", false);
						} else {
							$("#clasName").css("background", "red");
							$("#pdclasName").html(
									"<font color='red'> * 该班级名称已经存在</font>");
							$("#saveBtn").attr("disabled", true);
						}
					}
				});
			});
});
// 保存按钮验证
function checkSaveBtn() {
	var flag = 0;
	if ($("#clasNum").val() == "") {
		$("#pdclasNum").html("<font color='red'> * 班级编号不能为空</font>");
		flag = 1;
	}
	if ($("#clasName").val() == "") {
		$("#pdclasName").html("<font color='red'> * 班级名称不能为空</font>");
		flag = 1;
	}
	// 判定页面输入是否合法
	if (flag == 1) {
		return false;
	} else if (flag == 0) {
		return true;
	}
}