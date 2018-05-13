var competitionId=0;
var campId=0;

var tSubject_ID =0;


$(document).ready(function(){
	adminloginstate();
});
function adminloginstate() {
	$.post("../UserServlet", {
		method : "adminloginstate",
	}, function(json) {
		var json = JSON.parse(json);
		if(json.msg==false) {
			window.location.href = "administratorlogin.html";
		} 
	});
}
$("a").click(function() {
	var title = $(this).text();
	
	title = $.trim(title);
	
	if ("赛事列表" == title) {
		var flag = $("#tabsID").tabs("exists", title);
		if (!flag) {
			$("#tabsID").tabs("add", {
				"title" : title,
				"closable" : true,
				"href" : "competitionList.html"
			});
		}
	} 
	if ("增加赛事" == title) {
		var flag = $("#tabsID").tabs("exists", title);
		if (!flag) {
			$("#tabsID").tabs("add", {
				"title" : title,
				"closable" : true,
				"href" : "addCompetition.html"
			});
		competitionId=0;
		}
	}
	
	
	
	if ("竞赛订单" == title) {
		var flag = $("#tabsID").tabs("exists", title);
		if (!flag) {
			$("#tabsID").tabs("add", {
				"title" : title,
				"closable" : true,
				"href" : "orderList.html"
			});
		}
	}
	
	if ("成绩列表" == title) {
		var flag = $("#tabsID").tabs("exists", title);
		if (!flag) {
			$("#tabsID").tabs("add", {
				"title" : title,
				"closable" : true,
				"href" : "gradeList.html"
			});
		}
	}
	
	if ("新闻列表" == title) {
		var flag = $("#tabsID").tabs("exists", title);
		if (!flag) {
			$("#tabsID").tabs("add", {
				"title" : title,
				"closable" : true,
				"href" : "News.html"
			});
		}
	}
	
	if ("准考证管理" == title) {
		var flag = $("#tabsID").tabs("exists", title);
		if (!flag) {
			$("#tabsID").tabs("add", {
				"title" : title,
				"closable" : true,
				"href" : "ticket.html"
			});
		}
	}
	//营地
	if ("营地列表" == title) {
		var flag = $("#tabsID").tabs("exists", title);
		if (!flag) {
			$("#tabsID").tabs("add", {
				"title" : title,
				"closable" : true,
				"href" : "CampList.html"
			});
		}
	}
	if ("增加营地" == title) {
		var flag = $("#tabsID").tabs("exists", title);
		if (!flag) {
			$("#tabsID").tabs("add", {
				"title" : title,
				"closable" : true,
				"href" : "addCamp.html"
			});
		}
	}
	if ("营地订单" == title) {
		var flag = $("#tabsID").tabs("exists", title);
		if (!flag) {
			$("#tabsID").tabs("add", {
				"title" : title,
				"closable" : true,
				"href" : "CampOrderList.html"
			});
		}
	}
	//培训
	if("增加培训" == title){
		var flag = $("#tabsID").tabs("exists", title);
		if (!flag) {
			$("#tabsID").tabs("add", {
				"title" : title,
				"closable" : true,
				"href" : "addTrain.html"
			});
		}
	}
	
	if("增加教师" == title){
		var flag = $("#tabsID").tabs("exists", title);
		if (!flag) {
			$("#tabsID").tabs("add", {
				"title" : title,
				"closable" : true,
				"href" : "addTeacher.html"
			});
		}
	}
	
	if("增加培训机构" == title){
		var flag = $("#tabsID").tabs("exists", title);
		if (!flag) {
			$("#tabsID").tabs("add", {
				"title" : title,
				"closable" : true,
				"href" : "addMechanism.html"
			});
		}
	}
	
	if("培训列表" == title){
		var flag = $("#tabsID").tabs("exists", title);
		if (!flag) {
			$("#tabsID").tabs("add", {
				"title" : title,
				"closable" : true,
				"href" : "TrainList.html"
			});
		}
	}
	
	if("培训订单" == title){
		var flag = $("#tabsID").tabs("exists", title);
		if (!flag) {
			$("#tabsID").tabs("add", {
				"title" : title,
				"closable" : true,
				"href" : "TrainOrderList.html"
			});
		}
	}
	
});

function getCompetitionSelect() {
	var temp = ($('#competition').datagrid('getSelections'));
	if(temp=="") {
		alert("请先选中数据！");
	}
	return temp[0].competitionId;
}
function getCampSelect() {
	var temp = ($('#camp').datagrid('getSelections'));
	if(temp=="") {
		alert("请先选中数据！");
	}
	return temp[0].campId;
}
function getTrainSelect(){
	var temp = ($('#train').datagrid('getSelections'));
	if(temp=="") {
		alert("请先选中数据！");
	}
	return temp[0].tSubject_ID;
}
function getMechanismSelect(){
	var temp = ($('#mechanism').datagrid('getSelections'));
	if(temp=="") {
		alert("请先选中数据！");
	}
	return temp[0].tMechanism_ID;
}

//function deleteCompetition(competitionId) {
//	$.post("../CompetitionServlet", {
//		method : "delete",
//		competitionId : competitionId
//	}, function(json) {
//		console.log(json);
//	});
//}
function toaddCompetition() {
	var flag = $("#tabsID").tabs("exists", "增加赛事");
	if (!flag) {
		$("#tabsID").tabs("add", {
			"title" : "增加赛事",
			"closable" : true,
			"href" : "addCompetition.html"
		});
	}
	competitionId = getCompetitionSelect();
}

function toaddCamp() {
	var flag = $("#tabsID").tabs("exists", "增加营地");
	if (!flag) {
		$("#tabsID").tabs("add", {
			"title" : "增加营地",
			"closable" : true,
			"href" : "addCamp.html"
		});
	}
	campId = getCampSelect();
}

function toaddTrain(){
	var flag = $("#tabsID").tabs("exists", "增加培训");
	if (!flag) {
		$("#tabsID").tabs("add", {
			"title" : "增加培训",
			"closable" : true,
			"href" : "addTrain.html"
		});
	}
	tSubject_ID = getTrainSelect();
}

