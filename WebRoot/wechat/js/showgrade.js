function getUrlParam(name) {
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); // 构造一个含有目标参数的正则表达式对象
	var r = window.location.search.substr(1).match(reg);
	if (r != null)
		return unescape(r[2]);
	return null; // 返回参数值
}
$(document).ready(function(){
	getInfo();
});
function getInfo() {
	var competitionName =decodeURIComponent(getUrlParam("competitionName"));
	var admissionTicket =getUrlParam("admissionTicket");
	var competitionSubject =decodeURIComponent(getUrlParam("competitionSubject"));
	var userName =decodeURIComponent(getUrlParam("userName"));
	var userGrade =decodeURIComponent(getUrlParam("userGrade"));
	var password =decodeURIComponent(getUrlParam("password"));
	var competitionGrade =decodeURIComponent(getUrlParam("competitionGrade"));
	var promotion =decodeURIComponent(getUrlParam("promotion"));
	var award =decodeURIComponent(getUrlParam("award"));
	var note =decodeURIComponent(getUrlParam("note"));
												
	$("#competitionName").append("<p>"+competitionName+"</p>");
	$("#admissionTicket").append("<p>"+admissionTicket+"</p>");
	$("#competitionSubject").append("<p>"+competitionSubject+"</p>");
	$("#userName").append("<p>"+userName+"</p>");
	$("#userGrade").append("<p>"+userGrade+"</p>");
	$("#password").append("<p>"+password+"</p>");
	$("#competitionGrade").append("<p>"+competitionGrade+"</p>");
	$("#promotion").append("<p>"+promotion+"</p>");
	$("#award").append("<p>"+award+"</p>");
	$("#note").append("<p>"+note+"</p>");
	
}