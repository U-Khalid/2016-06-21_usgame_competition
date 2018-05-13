var CampId;
var camp_Name;
var phonenumber;
var camp_Age;
var camp_Address;
var money;


$(document).ready(function () {
	getCampId();
	judgeAttention();
});

function getCampId(){
	var strHref = window.document.location.href;
	var intPos = strHref.indexOf("=");
	var strRight = strHref.substr(intPos + 1);
	CampId = strRight;
	getCampDetails(CampId);
}

function getCampDetails(CampId){
	$.post('../../CampServlet',{
		method : 'Web_getCampDetails',
		CampId : CampId
	},function(json) {
		var data = JSON.parse(json);
		//console.log(data);
		var json = data.data;
		camp_Name = json.camp_Name;
		camp_Age = json.camp_Age;
		camp_Address = json.camp_Address;
		money = json.camp_Money;
		showCampInfo(json);
	});
}

function showCampInfo(json){
	$('.sk-event4-1-detail-banner').append(
			 '<img src="/2016-06-21_usgame_competition/images/main/'+json.camp_BigPic+'"  class="sk-event4-1-detail-img">'+
			 '</div>'	
	);
	
	/*营地简介*/
	$('#campName').append(
			json.camp_Name
	);
	$('#campName1').append(
			json.camp_Name
	);
	
	$('#campAddress').append(
			json.camp_Address
	);
	$('#campAge').append(
			json.camp_Age
	);
	$('#campFeatures').append(
			json.camp_Features
	);
	$('#campInfo').append(
			json.camp_Info
	);
	
	
	/*营地费用*/
	$('#campMoney').append(
			json.camp_Money + '元'
	);
	$('#moneyInfo').append(
			json.money_Info 
	);
	
	
	/*报名须知*/
	$('#campSchedule').append(
			json.camp_Schedule
	);
	$('#applyInfo').append(
			json.apply_Info
	);
	$('#attentionInfo').append(
			json.attention_Info
	);
	
	/*报名信息*/
	$('#date-start').append(
			json.camp_startTime  + ' - 开始'               
	);
	$('#date-end').append(
			json.camp_endTime + ' - 结束'
	);
	$('#camp_goTime').append(
			json.camp_goTime
	);
	
	$('#campstate').append(
			conversionstate(json.campstate)
	);
}


		
function judgeAttention(){
	$.ajax({
		type : "post",
		url : "../../UserServlet",
		data : {method : "getUserInfo"},
		async : false,
		success : function(json){
			var json = JSON.parse(json);
			if(json.msg) {
				phonenumber = json.data.phonenumber;
				judgeAttentionState(phonenumber,CampId);
			}
			else{
				$("#add").show();
			}
		}
	});
}

function judgeAttentionState(phonenumber,CampId){
	$.post("../../CampServlet",{
		method : "judgeAttentionState",
		phonenumber : phonenumber,
		CampId : CampId
	}, function(json) {
		console.log(json)
		if(json==1){
			$("#add").hide();
			$("#yet").show();
		}
		else {
			$("#add").show();
			$("#yet").hide();
		}
		/*if(json){
			//alert("关注成功！");
			$("#add").hide();
			$("#yet").show();
		} else {
			alert("关注失败！");
		}*/
		
	})
}
/*添加关注*/
function payAttention() {
	getUser();
	Addattention(phonenumber,CampId);
}

function getUser() {
	$.ajax({
		type : "post",
		url : "../../UserServlet",
		data : {method : "getUserInfo"},
		async : false,
		success : function(json){
			//console.log(json)
			var json = JSON.parse(json);
			if(json.msg==false) {
				window.location.href="../login/login.jsp";
			}
			else {
				phonenumber = json.data.phonenumber;
			}
		}
	});
}

function Addattention(phonenumber,CampId){
	/*alert(CampId);*/
	$.post("../../CampServlet",{
		method : "payAttention",
		phonenumber : phonenumber,
		CampId : CampId
	}, function(json) {
		if(json){
			//alert("关注成功！");
			$("#add").hide();
			$("#yet").show();
		} else {
			alert("关注失败！");
		}
		
	})
}

function delectAttention(){
	getUser();
	DelAttention(phonenumber,CampId);
}

function delectAttention(){
	$.post("../../CampServlet",{
		method : "DelAttention",
		phonenumber : phonenumber,
		CampId : CampId
	}, function(json) {
		if(json){
			//alert("取消关注成功！");
			$("#add").show();
			$("#yet").hide();
		} else {
			alert("取消关注失败！");
		}
	})
}

function camp_apply() {
	/*alert(CampId);*/
	window.location.href="applyInfo.jsp?camp_Name="+encodeURI(encodeURI(camp_Name))+"&&camp_Address="+encodeURI(encodeURI(camp_Address))+"&&CampId="+encodeURI(encodeURI(CampId))+"&&money="+money;
}





