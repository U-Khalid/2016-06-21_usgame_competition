$(document).ready(function(){
	getInfo();
});
function getInfo() {
	$.post("../../UserServlet", {
		method : "getUserInfo"
	}, function(json) {
		var data = JSON.parse(json);
		//console.log(data);
		//var json = data.data;
		if(data.msg==false) {
			 window.location.href="../login/login.jsp"
		}
		else{
			
			showInfo(data);
		}
	});
}
function showInfo (json) {
	$('#input-name').append(
		'<input type="text"  name="name" id="name" value=' + json.data.name +'>'	
	);
	$('#input-school').append(
		'<input type="text"  name="school" id="school" value=' + json.data.school +'>'	
	);
	$('#input-phonenumber').append(
		'<input type="text" disabled="true" name="phonenumber" id= "phone" value=' + json.data.phonenumber+'>'	
	);
	$('#input-iDcard').append(
		'<input type="text" name="iDcard" id="iDcard"  value=' + json.data.iDcard+'>'	
	);
	$('#input-address').append(
		'<input type="text" name="address" id="address" value=' + json.data.address+'>'	
	);
	$('#input-motto').append(
		'<input type="text" name="motto" id="motto" placeholder="可以是职业或教育经历介绍，也可以是个性宣言~" value=' + json.data.motto +'>'
	);
	
	if(json.data.name == null){
		$("#name").attr("value","");
	}
	if(json.data.school == null){
		$("#school").attr("value","");
	}
	if(json.data.iDcard == null){
		$("#iDcard").attr("value","");
	}
	if(json.data.address == null){
		$("#address").attr("value","");
	}
	if(json.data.motto == null){
		$("#motto").attr("value","");
	}
		if(json.data.sex!="") {
			if(json.data.sex=="男") {
				document.getElementById("choice-sex")[0].selected=true;
			}
			if(json.data.sex=="女") {
				document.getElementById("choice-sex")[1].selected=true;
			}
		}
		else{
			document.getElementById("choice-sex")[0].selected=true;
		}
		if(json.data.grade!="") {
			document.getElementById("choice-grade")[showgrade(json.data.grade)-1].selected=true;
		}
		else {
			document.getElementById("choice-grade")[0].selected=true;
		}
}

function saveUserInfo () {
	var name = $("#name").val();
	var sex = document.getElementById("choice-sex").value;
	if(sex==0) {
		sex="男";
	}
	if(sex==1) {
		sex="女";
	}
	var school = $("#school").val();
	var grade = document.getElementById("choice-grade").value;
	grade = conversiongrade(grade);
	var iDcard = $("#iDcard").val();
	var address = $("#address").val();
	var motto = $("#motto").val(); 
	var phonenumber = $("#phone").val();
	
	$.post("../../UserServlet", {
		method : "toUser",
		name: name,
		sex : sex,
		school : school,
		grade : grade,
		iDcard : iDcard,
		address : address,
		motto : motto,
		phonenumber : phonenumber
	}, function(json) {
		var data = JSON.parse(json);
		//console.log(data);
		if(data.msg==true) {
			alert("删除成功!");
			window.location.href="userInfo.jsp";
		}
		else {
			alert("删除失败!");
		}
	});

}
/*function showgrade(a) {
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
}*/

/*function conversiongrade(a) {
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
}*/
