var money;
$(document).ready(function(){
	getInfo();
	var competitionSubject = decodeURIComponent(getUrlParam("competitionSubject"));
	var competitionName = decodeURIComponent(getUrlParam("competitionName"));
	var grade = decodeURIComponent(getUrlParam("competitionGrade"));
	money = getUrlParam("money");
	$('#competitionName').html(competitionName);
	$('#competitionSubject').html(competitionSubject);	
	var i = 1;
	var length = grade.length;
	while(length>0) {
		var Pos = grade.indexOf("，");
		length = length - Pos;
		if(Pos==-1){
			length=0;
			$('#competitionGrade').append(
					"<option value='"+grade.substring(0)+"'>"+showgrade(grade.substring(0))+"</option>"
			);
		}
		else {
			$('#competitionGrade').append(
					"<option value='"+grade.substring(0,Pos)+"'>"+showgrade(grade.substring(0,Pos))+"</option>"
			);
		}
		i++;
		grade = grade.substring(Pos+1);	
	}
});
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
function getInfo() {
	$.post("../UserServlet", {
		method : "getUserInfo"
	}, function(json) {
		var data = JSON.parse(json);
		//console.log(data);
		var json = data.data;
		showInfo(json);
	});
}
function showInfo(json) {
if(json.name==""||json.iDcard==""||json.school=="") {
	showdialog3()
}
	document.getElementById("name").value=json.name;
	document.getElementById("idCard").value=json.iDcard;
	document.getElementById("school").value=json.school;
	if(json.grade!="") {
		document.getElementById("grade")[setgrade(json.grade)-1].selected=true;
	}
}
function showdialog3() {
	 $('#dialog3').show().on('click', '.weui_btn_dialog', function () {
	        $('#dialog3').off('click').hide();
	    });
}
function toziliao() {
	window.location.href="ziliao.html";
}
function setgrade(a) {
	switch (a) {
	case "小学一年级" :
		return "1";
		break;
	case "小学二年级" :
		return "2";
		break;
	case "小学三年级" :
		return "3";
		break;
	case "小学四年级" :
		return "4";
		break;
	case "小学五年级" :
		return "5";
		break;
	case "小学六年级" :
		return "6";
		break;
	case "初中一年级" :
		return "7";
		break;
	case "初中二年级" :
		return "8";
		break;
	case "初中三年级" :
		return "9";
		break;
	case "高中一年级" :
		return "10";
		break;
	case "高中二年级" :
		return "11";
		break;
	case "高中三年级" :
		return "12";
		break;
 }
}
function qd() {
	var message = getData();
	if(message.name.length!=0&&message.idCard.length!=0&&message.contectName.length!=0&&message.contectPhone.length!=0) {
		$.post("../CompetitionServlet", {
			method : "apply",
			name :message.name,
			idCard : message.idCard,
			school : message.school,
			grade : message.grade,
			competitionSubject : message.competitionSubject,
			competitionName : message.competitionName,
			competitionGrade : message.competitionGrade,
			contectName : message.contectName,
			contectPhone : message.contectPhone,
			money : money
		}, function(json) {
			var data = JSON.parse(json);
//			alert(data.data);
			$("#wx_out").val(data.data);
			if(data.msg==1||data.msg==3) {
				window.location.href="bmqr.html?name="+encodeURI(encodeURI(message.name))+"&&idCard="+message.idCard+"&&school="+encodeURI(encodeURI(message.school))+"&&" +
						"grade="+message.grade+"&&competitionSubject="+encodeURI(encodeURI(message.competitionSubject))+"&&competitionName="+encodeURI(encodeURI(message.competitionName))+"&&" +
								"competitionGrade="+message.competitionGrade+"&&contectName="+encodeURI(encodeURI(message.contectName))+"&&contectPhone="+message.contectPhone  + "&out_trade_no=" + data.data+"&money="+money
			}
			else if(data.msg==2) {
				$('#warming_title').html("提醒");
				$('#warming').html("您已报过名!");
				show2();
			}
			else if(data.msg==0) {
				$('#warming_title').html("提醒");
				$('#warming').html("请先登陆!");
				show2();
			}
			else if(data.msg==4) {
				$('#warming_title').html("报名失败");
				$('#warming').html(data.other);
				show2();
			}
		});
	}
	else {
		$('#warming').html("资料未填写完全！");
		show2();
	}
}

//获取用户填写的值
function getData() {
	var message = new Object();
	message.name = $('#name').val();
	message.idCard = $('#idCard').val();
	message.school = $('#school').val();
	message.grade = $('#grade').val();
	message.competitionSubject = $('#competitionSubject').html();
	message.competitionName = $('#competitionName').html();
	message.competitionGrade = $('#competitionGrade').val();
	message.contectName = $('#contectName').val();
	message.contectPhone = $('#contectPhone').val();
	return message;
}



function getUrlParam(name) {
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); // 构造一个含有目标参数的正则表达式对象
	var r = window.location.search.substr(1).match(reg);
	if (r != null)
		return unescape(r[2]);
	return null; // 返回参数值
}
function show2() {
    $('#dialog2').show().on('click', '.weui_btn_dialog', function () {
        $('#dialog2').off('click').hide();
    });
}

function qx() {
	if($('#warming').html()=="请先登陆!") {
		window.location.href="denglu.html";
	}
}