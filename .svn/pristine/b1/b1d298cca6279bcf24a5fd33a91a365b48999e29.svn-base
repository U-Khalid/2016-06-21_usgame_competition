var  Id;
var teacherID;
var trainGrade,trainSubject,trainName,money;
var phonenumber;
var tMechanism_ID;
$(document).ready(function(){
//	alert("!");
	var URL = window.document.location.href;
	var SignPosition = URL.indexOf("=");
	Id = URL.substr(SignPosition+1);
//	console.log(Id);
	getInfo();
	judgeAttention();
})


function judgeAttention(){
	$.ajax({
		type : "post",
		url : "../../UserServlet",
		data : {method : "getUserInfo"},
		async : false,
		success : function(json){
			var json = JSON.parse(json);
			if(json.msg) {
				phonenumber = json.data.phonenumber;
				judgeAttentionState(phonenumber,Id);
			}
			else{
				$("#add").show();
			}
		}
	});
}

function judgeAttentionState(phonenumber,Id) {
	$.post("../../TrainServlet",{
		method : "judgeAttentionState",
		phonenumber : phonenumber,
		Id : Id
	}, function(json) {
		console.log(json)
		if(json==1){
			$("#add").hide();
			$("#yet").show();
		}
		else {
			$("#add").show();
			$("#yet").hide();
		}
		/*if(json){
			//alert("关注成功！");
			$("#add").hide();
			$("#yet").show();
		} else {
			alert("关注失败！");
		}*/
		
	})
}


function getInfo(){
	getDetail();
	getTeacher();
}
//培训详细信息获取功能开始
function getDetail(){
	$.post("../../TrainServlet",{
		method:"getDetailByID",
		ID:Id
	},function(json){
		var json = JSON.parse(json);
		var data = json.json;
		var data2 = json.jsona;
		/*console.log(data);*/
		trainGrade = data.tSubject_Grade;
		trainSubject = data.tSubject_Course;
		trainName = data.tSubject_CourseName;
		tMechanism_ID = data.tMechanism_ID;
		showDetail(data,data2);
		/*getMechanismdetails(tMechanism_ID);*/
	})
}

function showDetail(data,data2){
	
	$("#trainSupportDesc").html(data2.tMechanism_Name);
	$("#trainSupportDesc1").html(data2.tMechanism_Name);
	$("#trainTestAddress").html(data2.tMechanism_Address);
	$("#trainMechanical_details").html(data2.tMechanism_Detail);
	
	$("#sign").show();
	$("#others").hide();
	
	$("#eventDetailNav .active").removeClass('active');
	$("#eventDetailNav a:first").addClass('active');
	
	$("#date_b_e").html(data.tSubject_EnrollStart+'~'+data.tSubject_EnrollEnd);
	
	$("#trainName").html(data.tSubject_CourseName);
	$("#trainName1").html(data.tSubject_CourseName);
	
	$("#trainCourse").html(data.tSubject_Course);
	
	$("#trainJoinerDes").html(data.tSubject_Personnel);
	
	$("#date-start").html(data.tSubject_Start+'~'+data.tSubject_End);
	
	$("#trainApplyAddress").html(data.tSubject_EnrollAddress);
	
	$("#train_details").html(data.tSubject_Detail);
	
	$("#trainSubject").html(data.tSubject_Course);
	
	$("#trainType").html(data.tSubject_Times);
	
	$("#trainForm").html(data.tSubject_Form);
	
	$("#date-start1").html('<em class="red">'+data.tSubject_Start+'</em>~<em class="red">'+data.tSubject_End+'</em>');
	$("#date-end1").html(data.tSubject_DetailTime);
	
	var now = (new Date()).getTime();
	var ersta = (new Date(data.tSubject_EnrollStart)).getTime();
	var erend = (new Date(data.tSubject_EnrollEnd)).getTime();
	var day;
	
	if(now < ersta){
		day = parseInt((ersta-now)/(1000*60*60*24));
		
		$("#trainState").html('未开始,离开始报名还剩<em class="orange">'+(day+1)+'天.</em>');
	}
	else if(now >= ersta && now <= erend){
		day = parseInt((erend-now)/(1000*60*60*24));
		
		$("#trainState").html('正在报名,离报名结束还剩<em class="orange">'+(day+1)+'天.</em>');
	}
	else{
		$("#trainState").html('报名已<em class="orange">结束</em>');
	}
	
}


//培训信息详细内容结束

//讨论区和通知公告
function toblank(obj){
	
	$("#eventDetailNav .active").removeClass('active');
	$(obj).addClass('active');
	
	$("#sign").hide();
	$("#others").show();

}
//讨论区和通知公告


//教师详情相关信息
function getTeacher(){
	$.post("../../TrainServlet",{
		method:"getTeacherDetail",
		ID:Id
	},function(json){
		var json = JSON.parse(json);
		json = json.data;
		money = json[0].tTeacher_Price;
//		console.log(json);
		showTeacher(json);
	})
}

function showTeacher(json){
	$("#teacher_Candidates").attr("onchange","showTeacherDetail()");
	$("#teacher_Candidates").html('');
	for(var i = 0;i < json.length;i++){
		$("#teacher_Candidates").append('<option value='+json[i].tTeacher_ID+'>'+json[i].tTeacher_Name+'</option>');
	}
	$("#teacherDetail").html(json[0].tTeacher_Info);
	
	$("#teacherPrice").html(json[0].tTeacher_Price);
}

function showTeacherDetail(){
	teacherID = $("#teacher_Candidates option:selected").val();
//	console.log("teacherID="+teacherID);
	$.post("../../TrainServlet",{
		method:"getTeacherByID",
		ID:teacherID
	},function(json){
		var json = JSON.parse(json);
		json = json.data;
//		console.log(json);
		money = json.tTeacher_Price;
//		console.log(money);
		$("#teacherDetail").html(json.tTeacher_Info);
		
		$("#teacherPrice").html(json.tTeacher_Price);
	})
}
//教师详情相关信息

function toEnroll(){
	teacherID = $("#teacher_Candidates option:selected").val();
	window.location.href = "enroll_info.jsp?trainSubject="+encodeURI(encodeURI(trainSubject))+" &&trainGrade="+encodeURI(encodeURI(trainGrade))+" &&tTeacherID="+teacherID+
		"&&trainName="+encodeURI(encodeURI(trainName))+"&&subjectID="+Id+"&&money="+money;
}



function payAttention() {
	getUser();
	Addattention(phonenumber,Id);
}

function getUser() {
	$.ajax({
		type : "post",
		url : "../../UserServlet",
		data : {method : "getUserInfo"},
		async : false,
		success : function(json){
			//console.log(json)
			var json = JSON.parse(json);
			if(json.msg==false) {
				window.location.href="../login/login.jsp";
			}
			else {
				phonenumber = json.data.phonenumber;
			}
		}
	});
}

function Addattention(phonenumber,Id){
	$.post("../../TrainServlet",{
		method : "payAttention",
		phonenumber : phonenumber,
		Id : Id
	}, function(json) {
		if(json){
			/*alert("关注成功！");*/
			$("#add").hide();
			$("#yet").show();
		} else {
			alert("关注失败！");
		}
		
	})
}


function delectAttention(){
	getUser();
	DelAttention(phonenumber,Id);
}

function DelAttention(phonenumber,Id) {
	$.post("../../TrainServlet",{
		method : "DelAttention",
		phonenumber : phonenumber,
		Id : Id
	}, function(json) {
		if(json){
			//alert("取消关注成功！");
			$("#add").show();
			$("#yet").hide();
		} else {
			alert("取消关注失败！");
		}
	})
}



