var applyReportId;
var message;
$(document).ready(function(){
	getapplyReportId();
});

function getapplyReportId() {
	var strHref = window.document.location.href;
	var intPos = strHref.indexOf("=");
	var strRight = strHref.substr(intPos + 1);
	applyReportId=strRight;
	getData(applyReportId);
}
function applyReportState(a) {
	if(a==0) {
		return "未付款";
	}
	if(a==1) {
		return "已付款";
	}
}
//年级转换
	function gradeconversion(a) {
		switch (a) {
		case 1 :
			return "小学一年级";
			break;
		case 2 :
			return "小学二年级";
			break;
		case 3 :
			return "小学三年级";
			break;
		case 4 :
			return "小学四年级";
			break;
		case 5 :
			return "小学五年级";
			break;
		case 6 :
			return "小学六年级";
			break;
		case 7 :
			return "初中一年级";
			break;
		case 8 :
			return "初中二年级";
			break;
		case 9 :
			return "初中三年级";
			break;
		case 10 :
			return "高中一年级";
			break;
		case 11 :
			return "高中二年级";
			break;
		case 12 :
			return "高中三年级";
			break;
				
		}
	}
function showdialog1 () {
	$("#dialog1").show();
	$("#dialog2").show();
}
function hidedialog1() {
	$("#dialog1").hide();
	$("#dialog2").hide();
}
function showdialog3 () {
	$("#dialog3").show();
}
function showdialog4 () {
	$("#dialog4").show();
}
function showdialog5 () {
	$("#dialog5").show();
}
function cancel() {
	$("#dialog3").hide();
}
function getData(applyReportId) {
	$.post("../UserServlet", {
		method : "applyreportInfo" ,
		applyReportId : applyReportId	
	}, function(json) {
		var data = JSON.parse(json);
		//console.log(data);
		var json = data.data;
		message = data.data;
		//console.log(json);
			$("#list").append(
					"<div class='weui_panel weui_panel_access'>"+
					"<div class='weui_panel_hd'>"+
					"<h4 class='weui_media_title' id='competition_name'>"+json.competitionName+"</h4>"+
					"</div>"+
					"<div class='weui_media_box weui_media_text '>"+
					"<div class='info_list'>"+
					"<strong>科目 :</strong>"+
					"<p class='info_text' id='subject_info_text'>"+json.competitionSubject+"</p>"+
					"</div>"+
					"<div class='info_list'>"+
					"<strong>参赛者 :</strong>"+
					"<p class='info_text' id='subject_info_text'>"+json.name+"</p>"+
					"</div>"+
					"<div class='info_list'>"+
					"<strong>身份证号:</strong>"+
					"<p class='info_text' id='subject_info_text'>"+json.idCard+"</p>"+
					"</div>"+
					"<div class='info_list'>"+
					"<strong>学校 :</strong>"+
					"<p class='info_text' id='subject_info_text'>"+json.school+"</p>"+
					"</div>"+
					"<div class='info_list'>"+
					"<strong>年级 :</strong>"+
					"<p class='info_text' id='subject_info_text'>"+gradeconversion(json.grade)+"</p>"+
					"</div>"+
					"<div class='info_list'>"+
					"<strong>竞赛年级 :</strong>"+
					"<p class='info_text' id='subject_info_text'>"+gradeconversion(json.competitionGrade)+"</p>"+
					"</div>"+
					"<div class='info_list'>"+
					"<strong>联系人 :</strong>"+
					"<p class='info_text' id='subject_info_text'>"+json.contectName+"</p>"+
					"</div>"+
					"<div class='info_list'>"+
					"<strong>联系号码 :</strong>"+
					"<p class='info_text' id='subject_info_text'>"+json.contectPhone+"</p>"+
					"</div>"+
					"<div class='info_list'>"+
					"<strong>订单号 :</strong>"+
					"<p class='info_text' id='subject_info_text'>"+json.out_trade_no+"</p>"+
				    "</div>"+
					"<div class='info_list'>"+
								"<strong>订单状态 :</strong>"+
								"<p class='info_text' id='subject_info_text'>"+applyReportState(json.applyReportState)+"</p>"+
					"</div>"+
					
						"<div class='info_list' onclick='ticketAddress()'>"+
						"<strong>准考证:</strong>"+
						"<p class='info_text' id='subject_info_text'>准考证领取</p>"+
					    "</div>"+
					"</div>"+
		          "</div>"
			)
					if(json.applyReportState==0) {
						showdialog1();
					}else {
						hidedialog1();
					}
	});
}
function deleteorder() {
	$.post("../UserServlet", {
		method : "deleteapplyreport" ,
		applyReportId : applyReportId	
	}, function(json) {
		var data = JSON.parse(json);
		//console.log(data.msg);
		if(data.msg){
			showdialog4();
		}
		else {
			showdialog5();
		}
	});
}

function togeren() {
	window.location.href="geren.html";
}
function toapplyreportInfo() {
	window.location.href="applyreportInfo.html?applyReportId="+applyReportId;
}
function ticketAddress() {
	window.location.href="ticket.html?competitionName="+encodeURI(encodeURI(message.competitionName));
}
function topay() {
	window.location.href="bmqr.html?name="+encodeURI(encodeURI(message.name))+"&&idCard="+message.idCard+"&&school="+encodeURI(encodeURI(message.school))+"&&" +
	"grade="+message.grade+"&&competitionSubject="+encodeURI(encodeURI(message.competitionSubject))+"&&competitionName="+encodeURI(encodeURI(message.competitionName))+"&&" +
			"competitionGrade="+message.competitionGrade+"&&contectName="+encodeURI(encodeURI(message.contectName))+"&&contectPhone="+message.contectPhone  + "&out_trade_no=" + message.out_trade_no+"&money="+message.money
}