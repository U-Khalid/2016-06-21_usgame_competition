
$(document).keydown(function(event){ 
		if(event.keyCode==13){ 
			login();
		} 
		}); 

function login() {
	var username = $("#username").val();
	var password = $("#password").val();
	
	$.post("../UserServlet", {
		method : "Administratorlogin",
		username :username,
		password : password
	}, function(json) {
		var json = JSON.parse(json);
		if(json.msg==true) {
			toadmin();
		} 
		else {
			alert("登录失败，请重新登录")
			location.reload(true);
		}
	});
}

function toadmin() {
  window.location.href = "index.html";
}