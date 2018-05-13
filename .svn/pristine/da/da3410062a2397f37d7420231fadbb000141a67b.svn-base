$(document).ready(function(){
	getInfo();
});
function getUrlParam(name) {
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); // 构造一个含有目标参数的正则表达式对象
	var r = window.location.search.substr(1).match(reg);
	if (r != null)
		return unescape(r[2]);
	return null; // 返回参数值
}
function getInfo() {
	var competitionName = decodeURI(getUrlParam("competitionName"));
	$.post("../CompetitionServlet", {
		method : "getticketAddress" ,
		competitionName : competitionName	
	}, function(json) {
		var data = JSON.parse(json);
		if(data.msg){
			var json = data.data;
			//console.log(json);
			showInfo(json);
		}
		else {
			alert("查找失败");
		}
		
	})
}
function showInfo(json) {
	$("#address").html(json.competitionApplyAddress);
}