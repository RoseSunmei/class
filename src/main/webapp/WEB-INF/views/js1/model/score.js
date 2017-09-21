function update(data) {
	var tr = $(data).parent().parent();// 获取当前tr对象
	var alltd = [];
	tr.find('td').each(function(i, td) {
		if ($(td).find('a').length == 0) {
			alltd.push($(td).html());
		}
	});
	var stuScore = $(data).parent().prev().find("input").val();
	var couName = alltd[1];
	var stuNum = alltd[3];
	$.ajax({
		url : "score_save.action?couName=" + couName + "&stuNum=" + stuNum
				+ "&stuScore=" + stuScore,
		type : "post",
		dataType : "json",
		success : function(data) {
			if (data.success) {
				alert(data.msg);
			} else {
				alert(data.msg);
			}
		} 
	});
}
function allSave(){
	
}