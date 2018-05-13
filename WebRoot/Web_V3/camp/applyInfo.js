var money;
var campId;
var camp_Address;
$(document).ready(function(){
	getInfo();                     
	var camp_Name = decodeURIComponent(getUrlParam("camp_Name"));
	campId = decodeURIComponent(getUrlParam("CampId"));
	camp_Address = decodeURIComponent(getUrlParam("camp_Address"));
	money  =  getUrlParam("money");
	/*alert(camp_Address);*/
	$('#campName').append(
			'<h1 class="first-title" title="'+camp_Name+'"><a href="camp_details.jsp?CampId='+campId+'" target="_blank" id="camp_Name">'+camp_Name+'</a></h1>'
	);
	$("#camp_Address").val(camp_Address);
	
});


function getInfo(){
	$.post("../../UserServlet", {
		method : "getUserInfo"
	}, function(json) {
		var data = JSON.parse(json);
		//console.log(data);
		if(data.msg==false) {
			window.location.href="../login/login.jsp";
		}
		else {
			var json = data.data;
			showInfo(json);
		}
	});
}

function showInfo(json){
	//console.log(json);
	if(json.name==null||json.iDcard==""||json.school=="") {
		alert("请先完善您的个人信息！")
		window.location.href="../User/editInfo.jsp"
	}
		$("#name").val(json.name);
		$("#iDcard").val(json.iDcard);
		$("#school").val(json.school);
		$("#address").val(json.address);
		/*document.getElementById("iDCard").value=json.iDcard;
		document.getElementById("school").value=json.school;*/
}

/*function getUrlParam(name) {
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); // 构造一个含有目标参数的正则表达式对象
	var r = window.location.search.substr(1).match(reg);
	if (r != null)
		return unescape(r[2]);
	return null; // 返回参数值
}*/


function toconfirm(){
	var message = getData();
	if(message.name.length!=0&&message.idCard.length!=0&&message.contectName.length!=0&&message.contectPhone.length!=0&&message.school.length!=0) {
		$.post("../../CampServlet",{
			method:"apply",
			name :message.name,
			idCard : message.idCard,
			school : message.school,
			camp_Age : message.camp_Age,
			camp_Name : message.camp_Name,
			camp_Address : message.camp_Address,
			address : message.address,
			contectName : message.contectName,
			contectPhone : message.contectPhone,
			money : money
		},function(json){
			var data = JSON.parse(json);
			console.log(data)
			$("#wx_out").val(data.data);
			if(data.msg==1||data.msg==3) {
				window.location.href="confirmApply.jsp?name="+encodeURI(encodeURI(message.name))+"&&idCard="+message.idCard+"&&school="+encodeURI(encodeURI(message.school))+"&&" +
						"camp_Age="+message.camp_Age+"&&camp_Address="+encodeURI(encodeURI(message.camp_Address))+"&&campId="+campId+"&&address="+encodeURI(encodeURI(message.address))+"&&camp_Name="+encodeURI(encodeURI(message.camp_Name))+"&&" +
								"address="+encodeURI(encodeURI(message.address))+"&&contectName="+encodeURI(encodeURI(message.contectName))+"&&contectPhone="+message.contectPhone  + "&out_trade_no=" + data.data+"&money="+money
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

function getData(){
	var message = new Object();
	message.name = $('#name').val();
	message.idCard = $('#iDcard').val();
	message.school = $('#school').val();
	message.camp_Age = $('#camp_Age').val();
	message.camp_Name=$('#camp_Name').html();
	message.camp_Address = $('#camp_Address').val();
	message.address = $('#address').val();
	message.contectName = $('#contectName').val();
	message.contectPhone = $('#contectPhone').val();
	console.log(message);
	return message;
}
