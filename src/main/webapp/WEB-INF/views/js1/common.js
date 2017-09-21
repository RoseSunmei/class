function go(no) {
	$("#pageNo").val(no);
	$("#domainForm").submit();
}

// 高级修改
function updateDomain(url) {
	// 修改list.jsp表单的地址
	$("#domainForm").attr("action", url);
	// 表单提交，显示修改页面
	$("#domainForm").submit();
	// 把list.jsp表单的地址修改查询的地址
	$("#domainForm").attr("action", url + ".action");
}

// ajax删除
function deleteDomain(url) {
	if (confirm("你想要删除这条数据吗?")) {
		$.get(url, function(data) {
			if (data.success) {
				alert(data.msg);
				$("#domainForm").submit();
			} else {
				alert(data.msg);
			}
		})
	}else{
		return false;
	}
}

// ajax重置密码
function resetDomain(url) {
	if (confirm("你确定要重置密码吗?")) {
		$.get(url, function(data) {
			// alert(data);
			if (data.success) {
				alert(data.msg);
				$("#domainForm").submit();
			} else {
				alert(data.msg);
			}
		})
	}else{
		return false;
	}
}

$(function() {
	// 1.输入查询页面的时候,只要用户输入非数字,就把非数字退掉
	$("#pageNo").keyup(function() { // keyup事件处理
		$(this).val($(this).val().replace(/\D|^0/g, ''));
	}).bind("paste", function() { // CTR+V事件处理
		$(this).val($(this).val().replace(/\D|^0/g, ''));
	}).css("ime-mode", "disabled"); // CSS设置输入法不可用
	// 2.修改的时候取消不保存
	// <button id="cancelBtn" class="btn" type="button">
	$("#cancelBtn").click(function() {
		if (confirm("确定取消吗?")) {
			window.history.back();// 获取浏览器缓存对象
		}else{
			return false;
		}
		// location.href="employee.action";//很多人同时管理数据使用此方法，每次获取实时数据
	});
});
