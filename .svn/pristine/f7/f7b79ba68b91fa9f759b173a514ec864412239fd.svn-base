$(document).ready(function() {
	userlogin();
});



function userlogin() {
	$.post("../../UserServlet",{
		method : "getUserInfo"
	}, function(json) {
		var json = JSON.parse(json);
		//console.log(json);
		if(json.msg==false) {
			window.location.href="../login/login.jsp";
		}
		else {
			$('#name').append(
				json.data.name	
            );
			$('#school').append(
				'学校：     ' + json.data.school
			);
			$('#motto').append(
				'座右铭：   '+json.data.motto
			);
			$('#sex').append(
				'性别：      ' + json.data.sex 
			);
			$('#phonenumber').append(
				'注册手机号：      ' + json.data.phonenumber
			);
			$('#address').append(
				'地址：      ' + json.data.address
			);
			$('#grade').append(
				'年级：     ' + json.data.grade
			);
			$('#username').append(
				'用户名：    ' +  json.data.name	
			);
			$('#iDcard').append(
				'身份证：    ' + json.data.iDcard
			);
			
		}
	})
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



