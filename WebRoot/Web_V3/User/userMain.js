var applyReportId;
$(document).ready(function(){
	$("#campInfo").hide();
	$("#trainInfo").hide();
	getCompetitionInfo();
	getAttentionCompetition();
	getCampInfo();
	getAttentionCamp();
	getTrainInfo();
	getAttentionTrain();
	$(".listcamp").hide();
	$(".Attentionlistcamp").hide();
	
	$(".listtrain").hide();
	$(".Attentionlisttrain").hide();
});


function toUserCompetition(){
	$("#competitionbox").show();
	$("#trainbox").hide();
	$("#campbox").hide();
	
	$("#competitionInfo").show();
	$(".Attentionlist").hide();
	$("#trainInfo").hide();
	$("#campInfo").hide();
	
	$(".listcamp").hide();
	$(".Attentionlistcamp").hide();
	$(".listtrain").hide();
	$(".Attentionlisttrain").hide();
	
	$("#usercompetition").addClass("active");
	$("#usertrain").removeClass("active");
	$("#usercamp").removeClass("active");
	
	
	$("#AttentionCompetition").removeClass("active");
	$("#payCompetition").addClass(" active");
	$(".list").show();
	

}

function toUserCamp(){
	
	$("#competitionbox").hide();
	$("#trainbox").hide();
	$("#campbox").show();
	$(".Attentionlistcamp").hide();
	
	$("#competitionInfo").hide();
	$("#trainInfo").hide();
	$("#campInfo").show();
	
	$(".list").hide();
	$(".Attentionlist").hide();
	$(".listtrain").hide();
	$(".Attentionlisttrain").hide();
	
	$("#usercompetition").removeClass("active");
	$("#usertrain").removeClass("active");
	$("#usercamp").addClass("active");
	
	$("#AttentionCamp").removeClass("active");
	$("#payCamp").addClass(" active");
	
	
	$(".listcamp").show();
}

function toUserTrain(){
	$("#competitionbox").hide();
	$("#trainbox").show();
	$("#campbox").hide();
	
	$("#competitionInfo").hide();
	$("#trainInfo").show();
	$("#campInfo").hide();
	$(".list").hide();
	$(".Attentionlist").hide();
	$(".listcamp").hide();
	$(".Attentionlistcamp").hide();
	$("#usercompetition").removeClass("active");
	$("#usertrain").addClass("active");
	$("#usercamp").removeClass("active");
	
	$("#AttentionTrain").removeClass("active");
	$("#payTrain").addClass(" active");
	$(".Attentionlisttrain").hide();
	$(".listtrain").show();
}

function applyReportState(a) {
	if(a==0) {
		return "未付款";
	}
	if(a==1) {
		return "已付款";
	}
}


//获取竞赛关注
function getAttentionCompetition() {
	getUserAttention(1);   
}

//获取营地关注
function getAttentionCamp(){
	getUserAttention(2);
}

//获得培训关注
function getAttentionTrain(){
	getUserAttention(3);
}


//竞赛
function showAttentionCompetition() {
	
	$("#payCompetition").removeClass("active");
	$("#AttentionCompetition").addClass(" active");
	$(".list").hide();
	$(".Attentionlist").show();
}
function showCompetitionInfo() {
	$("#AttentionCompetition").removeClass("active");
	$("#payCompetition").addClass(" active");
	$(".list").show();
	$(".Attentionlist").hide();
}


//营地
function showAttentionCamp(){
	$("#payCamp").removeClass("active");
	$("#AttentionCamp").addClass(" active");
	$(".listcamp").hide();
	$(".Attentionlistcamp").show();
}
function showCampInfo() {
	$("#AttentionCamp").removeClass("active");
	$("#payCamp").addClass(" active");
	$(".listcamp").show();
	$(".Attentionlistcamp").hide();
}


//培训
function showAttentionTrain(){
	$("#payTrain").removeClass("active");
	$("#AttentionTrain").addClass(" active");
	$(".listtrain").hide();
	$(".Attentionlisttrain").show();
}
function showTrainInfo() {
	$("#AttentionTrain").removeClass("active");
	$("#payTrain").addClass(" active");
	$(".listtrain").show();
	$(".Attentionlisttrain").hide();
}

function getUserAttention(type) {
	
	$.post("../../UserServlet", {
		method : "getUserAttention",
		type : type
	}, function(json) {
		//竞赛
		if(type==1){
			/*console.log(json);*/
			var data = JSON.parse(json);
			var json = data.data;
			if(json.length>0) {
				$("#comAttentionCount").html(json.length);
				for(var i=0;i<json.length;i++) {
					$(".Attentionlist").append(
						 '<li class="item clearfix js_item"><a href="../competition/competition_details.jsp?CompetitionId='+json[i].competitionId+'"'+
								'title="'+json[i].competitionName+'" class="event4-1-img-box fl">'+
									'<img'+
									' src="/2016-06-21_usgame_competition/images/main/'+json[i].competitionPic+'"'+
									' alt="'+json[i].competitionName+'">'+
							'</a>'+
								'<div class="event4-1-detail-box fr">'+
									'<h3 class="tit">'+
										'<a href="../competition/competition_details.jsp?CompetitionId='+json[i].competitionId+'" title="'+json[i].competitionName+'" '+
										'class="link">'+json[i].competitionName+'</a>'+
									'</h3>'+
									'<p class="event4-1-company event4-1-plan">'+
										'<i class="common-icon-big event4-1-company-icon"></i>竞赛科目：'+json[i].competitionSubject+' '+
									'</p>'+
									'<p class="event4-1-plan">'+
										'<i class="common-icon-big event4-1-time-icon"></i>报名时间：'+changeTime(json[i].competitionApplyStartTime)+' ～'+changeTime(json[i].competitionApplyEndTime)+' '+
									'</p>'+
								'</div></li>'
								
					)
				}
			}
			else {
				$("#comAttentionCount").html('0');
			}
		}
		//营地
		if(type==2){
			/*console.log(json);*/
			var data = JSON.parse(json);
			var json = data.data;
			if(json.length>0) {
				$("#campAttentionCount").html(json.length);
				for(var i=0;i<json.length;i++) {
					$(".Attentionlistcamp").append(
						 '<li class="item clearfix js_item"><a href="../camp/camp_details.jsp?CampId='+json[i].campId+'"'+
								'title="'+json[i].camp_Name+'" class="event4-1-img-box fl">'+
									'<img'+
									' src="/2016-06-21_usgame_competition/images/main/'+json[i].camp_Pic+'"'+
									' alt="'+json[i].camp_Name+'">'+
							'</a>'+
								'<div class="event4-1-detail-box fr">'+
									'<h3 class="tit">'+
										'<a href="../camp/camp_details.jsp?CampId='+json[i].campId+'" title="'+json[i].camp_Name+'" '+
										'class="link">'+json[i].camp_Name+'</a>'+
									'</h3>'+
									'<p class="event4-1-company event4-1-plan">'+
										'<i class="common-icon-big event4-1-company-icon"></i>营地目的地：'+json[i].camp_Address+' '+
									'</p>'+
									'<p class="event4-1-plan">'+
										'<i class="common-icon-big event4-1-time-icon"></i>报名时间：'+changeTime(json[i].camp_startTime)+' ～'+changeTime(json[i].camp_endTime)+' '+
									'</p>'+
								'</div></li>'
								
					)
				}
			}
			else {
				$("#campAttentionCount").html('0');
			}
		}
		
		
		//培训
		if(type==3){
			var data = JSON.parse(json);
			var json = data.data;
			if(json.length>0) {
				$("#trainAttentionCount").html(json.length);
				for(var i=0;i<json.length;i++) {
					$(".Attentionlisttrain").append(
						 '<li class="item clearfix js_item"><a href="../train/train_detail.jsp?tSubject_ID='+json[i].tSubject_ID+'"'+
								'title="'+json[i].tSubject_CourseName+'" class="event4-1-img-box fl">'+
									'<img'+
									' src="/2016-06-21_usgame_competition/images/main/'+json[i].tSubject_PictureUrl+'"'+
									' alt="'+json[i].tSubject_CourseName+'">'+
							'</a>'+
								'<div class="event4-1-detail-box fr">'+
									'<h3 class="tit">'+
										'<a href="../train/train_detail.jsp?tSubject_ID='+json[i].tSubject_ID+'" title="'+json[i].tSubject_CourseName+'" '+
										'class="link">'+json[i].tSubject_CourseName+'</a>'+
									'</h3>'+
									'<p class="event4-1-company event4-1-plan">'+
										'<i class="common-icon-big event4-1-company-icon"></i>培训科目：'+json[i].tSubject_Course+' '+
									'</p>'+
									'<p class="event4-1-plan">'+
										'<i class="common-icon-big event4-1-time-icon"></i>报名时间：'+json[i].tSubject_EnrollStart+' ～'+json[i].tSubject_EnrollEnd+' '+
									'</p>'+
								'</div></li>'
								
					)
				}
			}
			else {
				$("#trainAttentionCount").html('0');
			}
		}
	});
	
}
function getCompetitionInfo() {
	$.post("../../UserServlet", {
		method : "getUserCompetition"
	}, function(json) {
		
		var data = JSON.parse(json);
		var json = data.data;
		var competitionInfo;
		//console.log(json);
		if(json.length>=1) {
			$("#comApplyCount").html(json.length);
			for( var i=0;i<json.length;i++) {
				$.post("../../CompetitionServlet", {
					method : "getCompetitionbyInfo",
					competitionName : json[i].competitionName,
					competitionSubject :json[i].competitionSubject,
					money :json[i].money,
					applyorder:JSON.stringify(json[i])
				}, function(json) {
					
					var data = JSON.parse(json);
					//console.log(data);
					var applyReport = JSON.parse(data.applyReport);
					//console.log(applyReport)
					if(data.msg) {
						 competitionInfo = data.data;
												// console.log(jsondata[i].applyReportState)
						 $(".list").append(
								 '<li class="item clearfix js_item" ><a href="../competition/competition_details.jsp?CompetitionId='+competitionInfo.competitionId+'"'+
										'title="'+competitionInfo.competitionName+'" class="event4-1-img-box fl">'+
											'<img'+
											' src="/2016-06-21_usgame_competition/images/main/'+competitionInfo.competitionPic+'"'+
											' alt="'+competitionInfo.competitionName+'">'+
									'</a>'+
										'<div class="event4-1-detail-box fr">'+
											'<h3 class="tit">'+
												'<a href="../competition/competition_details.jsp?CompetitionId='+competitionInfo.competitionId+'" title="'+competitionInfo.competitionName+'" '+
												'class="link">'+competitionInfo.competitionName+'</a>'+
											'</h3>'+
											'<p class="event4-1-company event4-1-plan">'+
												'<i class="common-icon-big event4-1-company-icon"></i>竞赛科目：'+competitionInfo.competitionSubject+' '+
											'</p>'+
											'<p class="event4-1-plan">'+
												'<i class="common-icon-big event4-1-time-icon"></i>报名时间：'+changeTime(competitionInfo.competitionApplyStartTime)+' ～'+changeTime(competitionInfo.competitionApplyEndTime)+' '+
											'</p>'+
											'<p class="event4-1-plan">'+
												'<i class="common-icon-big event4-1-time-icon"></i>订单状态：'+applyReportState(applyReport.applyReportState)+' '+
											'</p>'+
											'<div class="event4-1-btn-box">'+
												'<a href="../competition/applyInfo.jsp?competitionName='+encodeURI(encodeURI(competitionInfo.competitionName))+'&&competitionSubject='+encodeURI(encodeURI(competitionInfo.competitionSubject))+'&&competitionGrade='+encodeURI(encodeURI(competitionInfo.competitionGrade))+'&&CompetitionId='+encodeURI(encodeURI(competitionInfo.competitionId))+'&&money='+competitionInfo.competitionMoney+' " class="sk-btn msg  fr"> <span>报名管理</span>'+
												'</a> <a href="javascript:showdialog('+applyReport.applyReportId+');"'+
													'class="sk-btn sk-btn-grey delete js_delete_action"'+
													'action-data="{&quot;team_id&quot;:&quot;119266&quot;}"'+
													'action-cid="#hpApplyCount" action-msg="取消">取消报名</a>'+
											'</div>'+
										'</div></li>'
										
							)
					}
					
				});
		 }	
		}
		else {
			$("#comApplyCount").html('0');
		}
		
	
	});
	
}


function getCampInfo() {
	$.post("../../UserServlet", {
		method : "getUserCamp"
	}, function(json) {
		
		var data = JSON.parse(json);
		var json = data.data;
		var campInfo;
		//console.log(json);
		if(json.length>=1) {
			$("#campApplyCount").html(json.length);
			
			for( var i=0;i<json.length;i++) {
				
				$.post("../../CampServlet", {
					method : "getCampbyInfo",
					camp_Name : json[i].camp_Name,
					camp_Address :json[i].camp_Address,
					money :json[i].money,
					applyorder:JSON.stringify(json[i])
				}, function(json) {
					
					var data = JSON.parse(json);
					/*console.log(data);*/
					var applyReport = JSON.parse(data.applyReport);
					//console.log(applyReport)
					if(data.msg) {
						 campInfo = data.data;
												// console.log(jsondata[i].applyReportState)
						 $(".listcamp").append(
								 '<li class="item clearfix js_item" ><a href="../camp/camp_details.jsp?CampId='+campInfo.campId+'"'+
										'title="'+campInfo.camp_Name+'" class="event4-1-img-box fl">'+
											'<img'+
											' src="/2016-06-21_usgame_competition/images/main/'+campInfo.camp_Pic+'"'+
											' alt="'+campInfo.camp_Name+'">'+
									'</a>'+
										'<div class="event4-1-detail-box fr">'+
											'<h3 class="tit">'+
												'<a href="../camp/camp_details.jsp?CampId='+campInfo.campId+'" title="'+campInfo.camp_Name+'" '+
												'class="link">'+campInfo.camp_Name+'</a>'+
											'</h3>'+
											'<p class="event4-1-company event4-1-plan">'+
												'<i class="common-icon-big event4-1-company-icon"></i>营地目的地：'+campInfo.camp_Address+' '+
											'</p>'+
											'<p class="event4-1-plan">'+
												'<i class="common-icon-big event4-1-time-icon"></i>报名时间：'+changeTime(campInfo.camp_startTime)+' ～'+changeTime(campInfo.camp_endTime)+' '+
											'</p>'+
											'<p class="event4-1-plan">'+
												'<i class="common-icon-big event4-1-time-icon"></i>订单状态：'+applyReportState(applyReport.applyReportState)+' '+
											'</p>'+
											'<div class="event4-1-btn-box">'+
												'<a href="../camp/applyInfo.jsp?camp_Name='+encodeURI(encodeURI(campInfo.camp_Name))+'&&camp_Address='+encodeURI(encodeURI(campInfo.camp_Address))+'&&CampId='+encodeURI(encodeURI(campInfo.campId))+'&&money='+campInfo.camp_Money+' " class="sk-btn msg  fr"> <span>报名管理</span>'+
												'</a> <a href="javascript:showdialogcamp('+applyReport.applyReportId+');"'+
													'class="sk-btn sk-btn-grey delete js_delete_action"'+
													'action-data="{&quot;team_id&quot;:&quot;119266&quot;}"'+
													'action-cid="#hpApplyCount" action-msg="取消">取消报名</a>'+
											'</div>'+
										'</div></li>'
										
							)
					}
					
				});
		 }	
		}
		else {
			$("#campApplyCount").html('0');
		}
		
	
	});
	
}

function getTrainInfo(){
	$.post("../../UserServlet", {
		method : "getUserTrain"
	}, function(json) {
		
		var data = JSON.parse(json);
		var json = data.data;
		var trainInfo;
		console.log(json);
		if(json.length>=1) {
			$("#trainApplyCount").html(json.length);
			for( var i=0;i<json.length;i++) {
				$.post("../../TrainServlet", {
					method : "getTrainbyInfo",
					trainName : json[i].trainName,
					trainSubject :json[i].trainSubject,
					money :json[i].money,
					applyorder:JSON.stringify(json[i])
				}, function(json) {
					var data = JSON.parse(json);
					console.log(data);
					var applyReport= JSON.parse(data.applyReport);
					//console.log(applyReport)
					if(data.msg){
						trainInfo = data.data;
						 $(".listtrain").append(
								 '<li class="item clearfix js_item" ><a href="../train/train_detail.jsp?tSubject_ID='+trainInfo.tSubject_ID+'"'+
										'title="'+trainInfo.tSubject_CourseName+'" class="event4-1-img-box fl">'+
											'<img'+
											' src="/2016-06-21_usgame_competition/images/main/'+trainInfo.tSubject_PictureUrl+'"'+
											' alt="'+trainInfo.tSubject_CourseName+'">'+
									'</a>'+
										'<div class="event4-1-detail-box fr">'+
											'<h3 class="tit">'+
												'<a href="../train/train_detail.jsp?tSubject_ID='+trainInfo.tSubject_ID+'" title="'+trainInfo.tSubject_CourseName+'" '+
												'class="link">'+trainInfo.tSubject_CourseName+'</a>'+
											'</h3>'+
											'<p class="event4-1-company event4-1-plan">'+
												'<i class="common-icon-big event4-1-company-icon"></i>培训名字：'+trainInfo.tSubject_Course+' '+
											'</p>'+
											'<p class="event4-1-plan">'+
												'<i class="common-icon-big event4-1-time-icon"></i>报名时间：'+trainInfo.tSubject_Start+' ～'+trainInfo.tSubject_End+' '+
											'</p>'+
											'<p class="event4-1-plan">'+
												'<i class="common-icon-big event4-1-time-icon"></i>订单状态：'+applyReportState(applyReport.applyReportState)+' '+
											'</p>'+
											'<div class="event4-1-btn-box">'+
												'<a href="../train/enroll_info.jsp?trainName='+encodeURI(encodeURI(trainInfo.tSubject_CourseName))+'&&trainSubject='+encodeURI(encodeURI(trainInfo.tSubject_Course))+'&&trainGrade='+encodeURI(encodeURI(applyReport.trainGrade))+'&&subjectID='+encodeURI(encodeURI(trainInfo.tSubject_ID))+'&&money='+applyReport.money+' " class="sk-btn msg  fr"> <span>报名管理</span>'+
												'</a> <a href="javascript:showdialogtrain('+applyReport.applyReportId+');"'+
													'class="sk-btn sk-btn-grey delete js_delete_action"'+
													'action-data="{&quot;team_id&quot;:&quot;119266&quot;}"'+
													'action-cid="#hpApplyCount" action-msg="取消">取消报名</a>'+
											'</div>'+
										'</div></li>'
										
							)
					}
					
				});
		 }	
		}
		else {
			$("#trainApplyCount").html('0');
		}
		
	
	});
}

function showdialog(id) {
	$("#promptMessageBox").show();
	applyReportId = id;
}
function hidedialog() {
	$("#promptMessageBox").hide();
}
function showalertbox() {
	$("#alertBox").show();
}
function reload() {
	location.reload(); 
}
function deleteorder() {
	$.post("../../UserServlet", {
		method : "deleteapplyreport" ,
		applyReportId : applyReportId	
	}, function(json) {
		var data = JSON.parse(json);
		//console.log(data.msg);
		if(data.msg){
			$("#alertMessge").text("删除成功!");
			showalertbox();
		}			
		else {
			$("#alertMessge").text("删除失败!");
			location.reload(); 
			showalertbox();
		}
	});
}
function showalertbox(){
	$("#alertBox").show();
}
function reload(){
	location.reload();
}


function showdialogcamp(id) {
	$("#promptMessageBoxcamp").show();
	applyReportId = id;
}
function hidedialogcamp() {
	$("#promptMessageBoxcamp").hide();
}
function deleteordercamp() {
	$.post("../../UserServlet", {
		method : "deletecampapply" ,
		applyReportId : applyReportId	
	}, function(json) {
		var data = JSON.parse(json);
		//console.log(data.msg);
		if(data.msg){
			$("#alertMessage").text("删除成功！");
			showalertbox();
		}			
		else {
			$("#alertMessage").text("删除失败！");
			showalertbox();
		}
	});
}


function showdialogtrain(id) {
	$("#promptMessageBoxtrain").show();
	applyReportId = id;
}
function hidedialogtrain() {
	$("#promptMessageBoxtrain").hide();
}
function deleteordertrain() {
	$.post("../../UserServlet", {
		method : "deletetrainapply" ,
		applyReportId : applyReportId	
	}, function(json) {
		var data = JSON.parse(json);
		//console.log(data.msg);
		if(data.msg){
			$("#alertMessage").text("删除成功！");
			showalertbox();
		}			
		else {
			$("#alertMessage").text("删除失败！");
			showalertbox();
		}
	});
}

