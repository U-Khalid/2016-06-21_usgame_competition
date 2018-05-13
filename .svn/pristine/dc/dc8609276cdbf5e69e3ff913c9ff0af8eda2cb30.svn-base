//注册
function changepw() {
	var phonenumber = $("#phonenumber").val();
	var password = $("#password").val();
	var confirm_pw = $("#confirm_pw").val();
	if(password!=confirm_pw) {
		showdialog3();
	}
	if($('#yanzhengma').val()==null) {
		$("#tishi").text("验证码不能为空！");
		showdialog4();
	}
	else {
		$.post("../UserServlet", {
			method : "Setpw",
			phone :phonenumber,
			password : password,
			yanzhengma : $('#yanzhengma').val()
		}, function(json) {
			var data = JSON.parse(json);
			if(data.msg==true) {
				showdialog1();
			}
			else {
				$("#tishi").text(data.other);
				showdialog4();
			}
		});
	}
}

function getTest() {
	var phonenumber = $("#phonenumber").val();
	if(phonenumber==""){
		$("#tishi").text("手机号码不能为空！");
		showdialog4();
	}else {
		$.post("../UserServlet", {
			method : "sentCode",
			phone :phonenumber
		}, function(json) {
			var data = JSON.parse(json);
			if(data.msg==true) {
				countdown();
			}
			else {
				$("#tishi").text(data.other);
				showdialog4();
			}
		});
	}
	
}
//倒计时60秒
var i=60;
function countdown () {
    document.getElementById("verification").innerHTML = i+"s";
    i--;
    if(i>0) {
    	setTimeout("countdown()",1000);
    }
    if(i==0) {
    	document.getElementById("verification").innerHTML = "<a href='javascript:getTest()' >| 获取验证码</a>";
    	i=60;
    }
	
}
function showdialog1 () {
	$("#dialog1").show();
}
function showdialog2 () {
	$("#dialog2").show();
}
function showdialog3 () {
	$("#dialog3").show();
}
function showdialog4 () {
	$("#dialog4").show();
}
function tosetpw () {
	$("#dialog2").hide();
	$("#dialog3").hide();
	window.location.href = "setpw.html";
}

function todenglu() {
	$("#dialog1").hide();
	window.location.href = "denglu.html";
}
