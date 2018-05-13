var money;
var competitionId
var allcompetitionGrade;
$(document).ready(function(){
	getInfo();
	var competitionSubject = decodeURIComponent(getUrlParam("competitionSubject"));
	var competitionName = decodeURIComponent(getUrlParam("competitionName"));
	var grade = decodeURIComponent(getUrlParam("competitionGrade"));
	allcompetitionGrade = grade;
	 competitionId = decodeURIComponent(getUrlParam("CompetitionId"));
	$('#comName').append(
			'<h1 class="first-title" title="'+competitionName+'"><a href="competition_details.jsp?CompetitionId='+competitionId+'" target="_blank" id="competitionName">'+competitionName+'</a></h1>'
	)
	money = getUrlParam("money");
	showcompetitiongtade(grade);
	$("#subject").val(competitionSubject);
	
	
});
function showcompetitiongtade(grade) {
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
		grade = grade.substring(Pos+1);	
	}
}
function getInfo() {
	$.post("../../UserServlet", {
		method : "getUserInfo"
	}, function(json) {
		
		var data = JSON.parse(json);
		//console.log(data);
		if(data.msg == false) {
			window.location.href="../login/login.jsp";
		}
		else {
			var json = data.data;
			showInfo(json);
		}
	});
}
function showInfo(json) {
	console.log(json);
if(json.name==null||json.iDcard==""||json.school=="") {
	alert("请先完善您的个人信息！")
	window.location.href="../User/editInfo.jsp"
}
	$("#name").val(json.name);
	$("#iDcard").val(json.iDcard);
	$("#school").val(json.school);
	/*document.getElementById("iDCard").value=json.iDcard;
	document.getElementById("school").value=json.school;*/
	if(json.grade!="") {
		document.getElementById("grade")[setgrade(json.grade)-1].selected=true;
	}
}



function toconfirm() {
	var message = getData();
	if(message.name.length!=0&&message.idCard.length!=0&&message.contectName.length!=0&&message.contectPhone.length!=0&&message.school.length!=0) {
		$.post("../../CompetitionServlet", {
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
				window.location.href="confirmApply.jsp?name="+encodeURI(encodeURI(message.name))+"&&idCard="+message.idCard+"&&school="+encodeURI(encodeURI(message.school))+"&&" +
						"grade="+message.grade+"&&allcompetitionGrade="+encodeURI(encodeURI(allcompetitionGrade))+"&&competitionId="+competitionId+"&&competitionSubject="+encodeURI(encodeURI(message.competitionSubject))+"&&competitionName="+encodeURI(encodeURI(message.competitionName))+"&&" +
								"competitionGrade="+message.competitionGrade+"&&contectName="+encodeURI(encodeURI(message.contectName))+"&&contectPhone="+message.contectPhone  + "&out_trade_no=" + data.data+"&money="+money
			}
			else if(data.msg==2) {
				//$('#warming_title').html("提醒");
				//$('#warming').html("您已报过名!");
				alert("您已报过名!");
				/*show2();*/
			}
			else if(data.msg==0) {
				//$('#warming_title').html("提醒");
				//$('#warming').html("请先登陆!");
				alert("请先登陆!");
				/*show2();*/
			}
			else if(data.msg==4) {
				//$('#warming_title').html("报名失败");
				//$('#warming').html(data.other);
				alert(data.other);
				/*show2();*/
			}
		});
	}
	else {
		//$('#warming').html("资料未填写完全！");
		alert("资料未填写完全！");
		/*show2();*/
	}
}

//获取用户填写的值
function getData() {
	var message = new Object();
	message.name = $('#name').val();
	message.idCard = $('#iDcard').val();
	message.school = $('#school').val();
	message.grade = $('#grade').val();
	message.competitionSubject = $('#subject').val();
	message.competitionName = $('#competitionName').html();
	message.competitionGrade = $('#competitionGrade').val();
	message.contectName = $('#contectName').val();
	message.contectPhone = $('#contectPhone').val();
	//console.log(message);
	return message;
}

function getUrlParam(name) {
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); // 构造一个含有目标参数的正则表达式对象
	var r = window.location.search.substr(1).match(reg);
	if (r != null)
		return unescape(r[2]);
	return null; // 返回参数值
}