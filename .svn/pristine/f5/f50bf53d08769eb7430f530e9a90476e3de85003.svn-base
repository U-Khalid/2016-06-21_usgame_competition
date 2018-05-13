var out_trade_no ;
var money ;
var trainName;
var subjectID,teacherID;
var trainSubject;
var trainGrade;
$(document).ready(function() {
	trainName = decodeURI(getUrlParam("trainName"));
	subjectID = getUrlParam("subjectID");
	teacherID = getUrlParam("teacherID");
	trainSubject = decodeURIComponent(getUrlParam("trainSubject"))
	trainGrade = decodeURIComponent(getUrlParam("trainGrade"));
	console.log("trainName="+trainName+"   subjectID="+subjectID+"    trainSubject"+trainSubject+"  trainGrade="+trainGrade);
	$('#comName').append(
			'<h1 class="first-title" title="'+trainName+'"><a href="train_detail.jsp?tSubjectID='+subjectID+'" target="_blank" id="trainName">'+trainName+'</a></h1>'
	)
	$('#name').html(decodeURIComponent(getUrlParam("name")));
	$('#idCard').html(getUrlParam("idCard"));
	$('#school').html(decodeURI(getUrlParam("school")));
	$('#grade').html(showgrade(getUrlParam("grade")));
	$('#trainSubject').html(trainSubject);
	$('#trainGrade').html(showgrade(getUrlParam("trainGrade")));
	$('#contectName').html(decodeURIComponent(getUrlParam("contectName")));
	$('#contectPhone').html(getUrlParam("contectPhone"));
	out_trade_no = getUrlParam("out_trade_no");
	money = getUrlParam("money")
	$('#out_trade_no').html(out_trade_no);
	$('.count').html("￥ "+money);
	
});
function backapplyInfo(){
	window.location.href="enroll_info.jsp?trainSubject="+encodeURI(encodeURI(trainSubject))+" &&trainGrade="+
					encodeURI(encodeURI(trainGrade))+" &&tTeacherID="+teacherID+"&&trainName="+
					encodeURI(encodeURI(trainName))+"&&subjectID="+subjectID+"&&money="+money;
}
function topay() {
	window.location.href = "Webpay.jsp?out_trade_no=" + out_trade_no + "&money="+money;
}
function showgrade(a) {
	switch (a) {
	case "1" :
		return "小学一年级";
		break;
	case "2" :
		return "小学二年级";
		break;
	case "3" :
		return "小学三年级";
		break;
	case "4" :
		return "小学四年级";
		break;
	case "5" :
		return "小学五年级";
		break;
	case "6" :
		return "小学六年级";
		break;
	case "7" :
		return "初中一年级";
		break;
	case "8" :
		return "初中二年级";
		break;
	case "9" :
		return "初中三年级";
		break;
	case "10" :
		return "高中一年级";
		break;
	case "11" :
		return "高中二年级";
		break;
	case "12" :
		return "高中三年级";
		break;
}
}

function getUrlParam(name) {
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); // 构造一个含有目标参数的正则表达式对象
	var r = window.location.search.substr(1).match(reg);
	if (r != null)
		return unescape(r[2]);
	return null; // 返回参数值
}