var subjectID,teacherID;
var trainGrade,trainSubject,trainName;
$(document).ready(function(){
	getUserInfo();
	trainGrade = decodeURIComponent(getUrlParam("trainGrade"));
	trainSubject = decodeURIComponent(getUrlParam("trainSubject"));
	trainName = decodeURIComponent(getUrlParam("trainName"));
//	console.log("trainGrade="+trainGrade+"   trainSubject="+trainSubject);
//	var Url = window.document.location.href,signPosition = Url.indexOf("="),
//	newUrl = Url.substr(signPosition+1),signPosition1 = newUrl.indexOf("&"),
//	signPosition2 = newUrl.indexOf("=")
//	subjectID = newUrl.substr(0,signPosition1);
	teacherID = getUrlParam("tTeacherID");
	subjectID = getUrlParam("subjectID");
	$('#comName').append(
			'<h1 class="first-title" title="'+trainName+'"><a href="train_detail.jsp?tSubject_ID='+subjectID+'" target="_blank" id="trainName">'+trainName+'</a></h1>'
	)
	$("#subject").val(trainSubject);
	showGrade(trainGrade);
})

function getUserInfo(){
	$.post("../../UserServlet",{
		method:"getUserInfo"
	},function(json){
		var json = JSON.parse(json);
		if(json.msg == false){
			window.location.href = "../login/login.jsp";
		}
		else{
			json = json.data;
//			console.log(json);
			showInfo(json);
		}
	})
}

function showInfo(json){
//	console.log(json+"      "+setgrade(json.grade));
	if(json.iDcard == null||json.grade == null||json.school == null||json.name == null){
		alert("请先完善您的个人信息！");
		window.location.href = "../User/editInfo.jsp";
	}
	$("#name").val(json.name);
	$("#iDcard").val(json.iDcard);
	$("#school").val(json.school);
	/*document.getElementById("iDCard").value=json.iDcard;
	document.getElementById("school").value=json.school;*/
	if(json.grade != null) {
		$("#grade option[value="+setgrade(json.grade)+"]").attr("selected",true)
	}
	$("#contectPhone").val(json.phonenumber);
}
function setgrade(json){
	switch(json){
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

function showGrade(json){
	var l = json.length;
	var i = 0;
	while(l > 0){
		i = json.indexOf("，");
		l = l-i;
		var str = "";
		
		str = '<option value="'+json.substring(0,i)+'">'+showgrade(json.substring(0,i))+'</option>';
		if(i == -1){
			l = 0;
			str = '<option value="'+json.substring(0,1)+'">'+showgrade(json.substring(0,1))+'</option>';
		}
		$("#trainGrade").append(str);
		json = json.substring(i+1);
	}
}



function showgrade(json){
//Object map = new Object();
//map.put();	
//	var str = map.get(json);
	
	switch(json){
		case "1":
			return "小学一年级";
			break;
		case "2":
			return "小学二年级";
			break;
		case "3":
			return "小学三年级";
			break;
		case "4":
			return "小学四年级";
			break;
		case "5":
			return "小学五年级";
			break;
		case "6":
			return "小学六年级";
			break;
		case "7":
			return "初中一年级";
			break;
		case "8":
			return "初中二年级";
			break;
		case "9":
			return "初中三年级";
			break;
		case "10":
			return "高中一年级";
			break;
		case "11":
			return "高中二年级";
			break;
		case "12":
			return "高中三年级";
			break;
	}
}

function toconfirm(){
	var message = getData();
//	console.log(message.contectName == "");
	if(message.contectName == ""){
		alert("请输入联系人姓名!!");
		return ;
	}
	console.log(message);
	$.post("../../TrainServlet",{
		method:"apply",
		name:message.name,  //姓名
		idCard:message.idCard,  //身份证
		school:message.school,  //所在学校
		grade:message.grade,  //年级
		trainName:message.trainName,  //培训名字 
		trainSubject:message.trainSubject,  //培训科目
		trainGrade:message.trainGrade,  //培训的年级
		contectName:message.contectName,  //联系人姓名
		contectPhone:message.contectPhone,  //联系方式
		money:decodeURIComponent(getUrlParam("money"))  //价格
	},function(json){
		var data = JSON.parse(json);
		console.log(data.msg);
//		alert(data.data);
//		$("#wx_out").val(data.data);
		if(data.msg==1||data.msg==3) {
			window.location.href = "confirmApply.jsp?out_trade_no="+data.data+"&&name="+encodeURI(encodeURI(message.name))+
			"&&school="+encodeURI(encodeURI(message.school))+"&&grade="+message.grade+"&&idCard="+message.idCard+
			"&&trainGrade="+message.trainGrade+"&&trainSubject="+encodeURI(encodeURI(message.trainSubject))+
			"&&contectName="+encodeURI(encodeURI(message.contectName))+"&&contectPhone="+message.contectPhone+
			"&&money="+decodeURIComponent(getUrlParam("money"))+"&&trainName="+encodeURI(encodeURI(message.trainName))+
			"&&subjectID="+subjectID+"&&teacherID="+teacherID;
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
	})
}

function getUrlParam(name) {
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); // 构造一个含有目标参数的正则表达式对象
	var r = window.location.search.substr(1).match(reg);
	if (r != null)
		return unescape(r[2]);
	return null; // 返回参数值
}

function getData(){
	var message = new Object();
	message.name = $("#name").val();
	message.idCard = $("#iDcard").val();
	message.school = $("#school").val();
	message.grade = $("#grade").val();
	message.trainName = $("#trainName").html();
	message.trainSubject = $("#subject").val();
	message.trainGrade = $("#trainGrade").val();
	message.contectName = $("#contectName").val();
	message.contectPhone = $("#contectPhone").val();
	return message;
}