$(document).ready(function(){
	getInfo();
});

function getInfo() {
	$.post("../../UserServlet", {
		method : "getUserInfo"
	}, function(json) {
		var data = JSON.parse(json);
		if(data.msg==false) {
			 window.location.href="../login/login.jsp"
		}
		else{
			/*window.location.href="querygrade.jsp"*/
		}
	});
}


var message;
function query() {
	var admissionTicket = $("#admissionTicket").val();
	var pw = $("#pw").val();
	$.post("../../CompetitionServlet", {
		method : "querygrade",
		admissionTicket: admissionTicket,
		pw : pw
	}, function(json) {
		var data = JSON.parse(json);
		console.log(data);
		if(data.msg==true) {
			message=data.data;
			showgrade();
		}
		else {
			showdialog2();
		}
	});
}

function showgrade(){
	window.location.href="showgrade.jsp?competitionName="+encodeURI(encodeURI(message.competitionName))+"&&admissionTicket="+message.admissionTicket+"&&competitionSubject="+encodeURI(encodeURI(message.competitionSubject))+"&&" +
	"userName="+encodeURI(encodeURI(message.userName))+"&&userGrade="+encodeURI(encodeURI(message.userGrade))+"&&password="+encodeURI(encodeURI(message.password))+"&&" +
			"competitionGrade="+encodeURI(encodeURI(message.competitionGrade))+"&&promotion="+encodeURI(encodeURI(message.promotion))+"&&award="+encodeURI(encodeURI(message.award))  + "&note=" + encodeURI(encodeURI(message.note))
}

function showdialog2(){
	alert("查询失败！");
	window.location.href = "querygrade.jsp";
}

