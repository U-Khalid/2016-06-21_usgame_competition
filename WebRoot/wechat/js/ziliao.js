$(document).ready(function(){
	getInfo();
});
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
function showInfo (json) {
	document.getElementById("name").value=json.name;
	
	document.getElementById("school").value=json.school;
	
	document.getElementById("iDcard").value=json.iDcard;
	document.getElementById("address").value=json.address;
	document.getElementById("motto").value=json.motto;
	$("#phonenumber").append("<p id='phone'>"+json.phonenumber+"</p>");
	if(json.sex!="") {
		if(json.sex=="男") {
			document.getElementById("sex")[0].selected=true;
		}
		if(json.sex=="女") {
			document.getElementById("sex")[1].selected=true;
		}
	}
	if(json.grade!="") {
		document.getElementById("grade")[showgrade(json.grade)-1].selected=true;
	}
}
function showgrade(a) {
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
function saveInfo () {
	var name = $("#name").val();
	var sex = document.getElementById("sex").value;
	if(sex==0) {
		sex="男";
	}
	if(sex==1) {
		sex="女";
	}
	var school = $("#school").val();
	var grade = document.getElementById("grade").value;
	grade = conversiongrade(grade);
	var iDcard = $("#iDcard").val();
	var address = $("#address").val();
	var motto = $("#motto").val(); 
	var phonenumber = $("#phone").text();
	
	$.post("../UserServlet", {
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
			showdialog1();
		}
		else {
			showdialog2();
		}
	});
	
}
function conversiongrade(a) {
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
function showdialog1 () {
	$("#dialog1").show();
}
function showdialog2 () {
	$("#dialog2").show();
}
function togeren () {
	$("#dialog1").hide();
	$("#dialog2").hide();
	window.location.href = "geren.html";
}
function toziliao () {
	$("#dialog1").hide();
	$("#dialog2").hide();
	window.location.href = "ziliao.html";
}