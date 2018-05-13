function showPasswd() {
	if($("#regpass").attr("type")=="password"){
		$("#regpass").attr("type","text");
		$(".js_view_pass_btn").addClass("active");
	}
	else{
		$("#regpass").attr("type","password");
		$(".js_view_pass_btn").removeClass("active");
	}
}

function getTest() {
	var phonenumber = $("#regname").val();
	$.post("/2016-06-21_usgame_competition/UserServlet", {
		method : "RCAPTCHA",
		phone :phonenumber,
	}, function(json) {
		var data = JSON.parse(json);
		if(data.msg==true) {
			countdown();
		}
		else {
		}
	});
}
//倒计时60秒
var i=60;
function countdown () {
	//颜色变掉（灰）
	$("#getCodeBtn").addClass("disable"); 
	/*$("#getCodeBtn").attr("style", "background-color: #bbb!important");*/
	/*$("#getCodeBtn").attr("style", "border-color: #bbb!important");*/
	
    document.getElementById("getCodeBtn").innerHTML = i+"秒后重试";
    i--;
    if(i>0) {
    	setTimeout("countdown()",1000);
    }
    if(i==0) {
    	//颜色变掉（绿）
    	$("#getCodeBtn").removeClass("disable"); 
    	document.getElementById("getCodeBtn").innerHTML = "获取验证码";
    	i=60;
    }
	
}