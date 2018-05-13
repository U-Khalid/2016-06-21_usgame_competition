
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
												
	$("#competitionName").append(competitionName);
	$("#admissionTicket").append(admissionTicket);
	$("#competitionSubject").append(competitionSubject);
	$("#userName").append(userName);
	$("#userGrade").append(userGrade);
	$("#password").append(password);
	$("#competitionGrade").append(competitionGrade);
	$("#promotion").append(promotion);
	$("#award").append(award);
	$("#note").append(note);
	
}



function backquery(){
	window.location.href = "querygrade.jsp";
}