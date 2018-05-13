var searchInfo;
$(document).ready(function(){
	searchInfo = decodeURIComponent(getUrlParam("searchInfo"));
	$("#search").val(searchInfo);
	getsearchInfo(searchInfo,1);
});
function getUrlParam(name) {
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); // 构造一个含有目标参数的正则表达式对象
	var r = window.location.search.substr(1).match(reg);
	if (r != null)
		return unescape(r[2]);
	return null; // 返回参数值
}
function getsearchInfo(searchInfo,type) {
	//竞赛
	if(type==1){
		$.post("../../CompetitionServlet", {
			method : "getCompetitionSearchInfo",
			searchInfo : searchInfo,
		}, function(json) {
			var data = JSON.parse(json);
			if(data.msg){
				var json = data.data;
				showSearchCompetitionList(json);
			}
		});
	}
	//营地
	if(type==2){
		$.post("../../CampServlet", {
			method : "getCampSearchInfo",
			searchInfo : searchInfo,
		}, function(json) {
			var data = JSON.parse(json);
			if(data.msg){
				var json = data.data;
				showSearchCampList(json);
			}
		});
		
	}
	//培训
	if(type==3){
		$.post("../../TrainServlet", {
			method : "getTrainSearchInfo",
			searchInfo : searchInfo,
		}, function(json) {
			var data = JSON.parse(json);
			
			if(data.msg){
				var json = data.data;
				//console.log(json);
				showSearchTrainList(json);
			}
			
		});
	}
	
}

function showCompetition(){
	$(".item").removeClass("active");
	$("#competition").addClass(" active");
	$(".campList").hide();
	$(".trainList").hide();
	$(".competitionList").show();
	getsearchInfo(searchInfo,1);
}

function showCamp() {
	$(".item").removeClass("active");
	$("#camp").addClass(" active");
	$(".competitionList").hide();
	$(".trainList").hide();
	$(".campList").show();
	getsearchInfo(searchInfo,2);
}

function showTrain() {
	$(".item").removeClass("active");
	$("#train").addClass(" active");
	$(".competitionList").hide();
	$(".campList").hide();
	$(".trainList").show();
	getsearchInfo(searchInfo,3);
}

function showSearchCompetitionList(json) {
	$(".competitionList").empty();
	for(var i=0;i<json.length;i++){
		$('.competitionList').append(
				'<li class="item clearfix">'+
				'<a href="javascript:toCompetitiondetails('+json[i].competitionId+')" class="event4-1-img-box fl" title='+json[i].competitionName+' target="_blank">'+
				'<img src="/2016-06-21_usgame_competition/images/main/'+json[i].competitionPic+'" alt='+json[i].competitionName+'>'+
				'</a>'+
				'<div class="event4-1-detail-box fr">'+
				'<h3 class="tit">'+
				'<a href="javascript:toCompetitiondetails('+json[i].competitionId+')" title='+json[i].competitionName+' class="link" target="_blank">'+json[i].competitionName+' </a>'+
				'</h3>'+
				'<p class="event4-1-company event4-1-plan"><i class="common-icon-big event4-1-company-icon"></i>主办方：'+json[i].competitionSupportDesc+'</p>'+
				'<p class="event4-1-plan"><i class="common-icon-big event4-1-time-icon"></i>报名时间：'+changeTime(json[i].competitionApplyStartTime)+' ～ '+changeTime(json[i].competitionApplyEndTime)+'</p>'+
				'<p class="event4-1-plan"><i class="common-icon-big event4-1-time-icon"></i>比赛时间：'+json[i].competitionTestTimeDes+'</p>'+
				'<div class="event4-1-btn-box">'+
				'<a href="javascript:toCompetitiondetails('+json[i].competitionId+')" class="sk-btn sk-btn-green" target="_blank">查看详情</a>'+
				'</div>'+
				'</div>'+
				'</li>'
		)
	}
}
function toCompetitiondetails(id) {
	window.location.href="/2016-06-21_usgame_competition/Web_V3/competition/competition_details.jsp?CompetitionId="+id;
}
function showSearchCampList(json) {
	$(".campList").empty();
	for(var i=0;i<json.length;i++) {
		$(".campList").append(
		'<li class="item clearfix">'+
                     '<a href="javascript:to_campdetails('+json[i].campId+')" class="event4-1-img-box fl" title='+json[i].camp_Name+' target="_blank">'+
                         '<img src="/2016-06-21_usgame_competition/images/main/'+json[i].camp_Pic+'" alt="'+json[i].camp_Name+'">'+
                     '</a>'+
                     '<div class="event4-1-detail-box fr" >'+
                         '<h3 class="tit" >'+
                             '<a href="javascript:to_campdetails('+json[i].campId+')" title='+json[i].camp_Name+' class="link" target="_blank">'+json[i].camp_Name+'</a>'+
                         '</h3>'+
                         '<p class="event4-1-company event4-1-plan"><i class="common-icon-big event4-1-company-icon"></i>目的地：'+json[i].camp_Address+'</p>'+
                         '<p class="event4-1-plan"><i class="common-icon-big event4-1-time-icon"></i>主题：'+json[i].camp_theme+'</p>'+
                         '<p class="event4-1-plan"><i class="common-icon-big event4-1-time-icon"></i>时长：'+turnTimeLength(json[i].camp_TimeLength)+'</p>'+
                         '<p class="event4-1-plan"><i class="common-icon-big event4-1-time-icon"></i>报名时间：'+changeTime(json[i].camp_startTime)+' ～ '+changeTime(json[i].camp_endTime)+'</p>'+
                         '<p class="event4-1-plan"><i class="common-icon-big event4-1-time-icon"></i>出发时间：'+changeTime(json[i].camp_goTime)+'</p>'+
                         /*'<div class="event4-1-data-box">'+
                            '<span class="event4-1-data-con"><i class="common-icon-big event4-1-scan-icon"></i>浏览<em>1690</em></span>'+
                            '<span class="event4-1-data-con c-666">离报名结束还剩<em class="orange">0</em>天</span>'+
                         '</div>'+*/
                         '<div class="event4-1-btn-box">'+
                            '<a href="javascript:to_campdetails('+json[i].campId+')" class="sk-btn sk-btn-green" target="_blank">查看详情</a>'+
                         '</div>'+
                     '</div>'+
                 '</li>'		
		)
	}
}
function to_campdetails(id) {
	window.location.href="/2016-06-21_usgame_competition/Web_V3/camp/camp_details.jsp?CampId="+id;
}
function showSearchTrainList(json) {
	$(".trainList").empty();
	for(var i=0;i<json.length;i++){
		var now = new Date();
		var ersta = new Date(json[i].tSubject_EnrollStart);
		var erend = new Date(json[i].tSubject_EnrollEnd);
		var day;
		
		//console.log("现在的时间是"+now.getTime()+"报名开始的时间是"+ersta.getTime()+"报名结束的时间是"+erend.getTime());
		if(now.getTime() < ersta.getTime()){
			day = parseInt((ersta.getTime()-now.getTime())/(1000*60*60*24));
			
			$(".trainList").append(
				'<li class="item clearfix">'+
	             	'<a href="javascript:to_Traindetails('+json[i].tSubject_ID +')" class="event4-1-img-box fl" title="'+json[i].tMechanism_Name+json[i].tSubject_CourseName+'" target="_blank">'+
	                   '<img src="/2016-06-21_usgame_competition/images/main/'+json[i].tSubject_PictureUrl+'" alt="'+json[i].tMechanism_Name+json[i].tSubject_CourseName+'">'+
	                 '</a>'+
	            '<div class="event4-1-detail-box fr">'+
	                '<h3 class="tit">'+
	                    '<a href="javascript:to_Traindetails('+json[i].tSubject_ID +')" title="'+json[i].tMechanism_Name+json[i].tSubject_CourseName+'" class="link" target="_blank">'+json[i].tSubject_CourseName+'</a>'+
	                '</h3>'+
	                '<p class="event4-1-company event4-1-plan"><i class="common-icon-big event4-1-company-icon"></i>主办方：'+json[i].tMechanism_Name+'</p>'+
	                '<p class="event4-1-plan"><i class="common-icon-big event4-1-time-icon"></i>报名时间：'+json[i].tSubject_EnrollStart+'～' + json[i].tSubject_EnrollEnd+'</p>'+
	                '<p class="event4-1-plan"><i class="common-icon-big event4-1-time-icon"></i>比赛时间：'+json[i].tSubject_Start+' ～'+ json[i].tSubject_End+'</p>'+
	                '<div class="event4-1-data-box">'+
	                   '<span class="event4-1-data-con c-666">'+
	                   	'报名未开始，离报名开始还有<em class="orange">'+(day+1)+'</em>天'+
	                   '</span>'+
	            '</div>'+
	           '<div class="event4-1-btn-box">'+
	            '<!-- <span class="sk-btn sk-btn-orange">添加关注</span> -->'+
	           '<a href="javascript:to_Traindetails('+json[i].tSubject_ID+')" class="sk-btn sk-btn-green" target="_blank">查看详情</a>'+
	                '</div>'+
	               '</div>'+
	              '</li>');
		}
		else if(now.getTime() >= ersta.getTime() && now.getTime() <= erend.getTime()){
			day = parseInt((erend.getTime()-now.getTime())/(1000*60*60*24));
			
			$(".trainList").append(
					'<li class="item clearfix">'+
	             	'<a href="javascript:to_Traindetails('+json[i].tSubject_ID +')" class="event4-1-img-box fl" title="'+json[i].tMechanism_Name+json[i].tSubject_CourseName+'" target="_blank">'+
	                   '<img src="/2016-06-21_usgame_competition/images/main/'+json[i].tSubject_PictureUrl+'" alt="'+json[i].tMechanism_Name+json[i].tSubject_CourseName+'">'+
	                 '</a>'+
	            '<div class="event4-1-detail-box fr">'+
	                '<h3 class="tit">'+
	                    '<a href="javascript:to_Traindetails('+json[i].tSubject_ID +')" title="'+json[i].tMechanism_Name+json[i].tSubject_CourseName+'" class="link" target="_blank">'+json[i].tSubject_CourseName+'</a>'+
	                '</h3>'+
	                '<p class="event4-1-company event4-1-plan"><i class="common-icon-big event4-1-company-icon"></i>主办方：'+json[i].tMechanism_Name+'</p>'+
	                '<p class="event4-1-plan"><i class="common-icon-big event4-1-time-icon"></i>报名时间：'+json[i].tSubject_EnrollStart+'～' + json[i].tSubject_EnrollEnd+'</p>'+
	                '<p class="event4-1-plan"><i class="common-icon-big event4-1-time-icon"></i>比赛时间：'+json[i].tSubject_Start+' ～'+ json[i].tSubject_End+'</p>'+
	                '<div class="event4-1-data-box">'+
	                   '<span class="event4-1-data-con c-666">'+
	                   	'离报名结束还剩<em class="orange">'+(day+1)+'</em>天'+
	                   '</span>'+
	            '</div>'+
	           '<div class="event4-1-btn-box">'+
	            '<!-- <span class="sk-btn sk-btn-orange">添加关注</span> -->'+
	           '<a href="javascript:to_Traindetails('+json[i].tSubject_ID+')" class="sk-btn sk-btn-green" target="_blank">查看详情</a>'+
	                '</div>'+
	               '</div>'+
	              '</li>');
		}
		else{
			$(".trainList").append(
					'<li class="item clearfix">'+
		             	'<a href="javascript:to_Traindetails('+json[i].tSubject_ID +')" class="event4-1-img-box fl" title="'+json[i].tMechanism_Name+json[i].tSubject_CourseName+'" target="_blank">'+
		                   '<img src="/2016-06-21_usgame_competition/images/main/'+json[i].tSubject_PictureUrl+'" alt="'+json[i].tMechanism_Name+json[i].tSubject_CourseName+'">'+
		                 '</a>'+
		            '<div class="event4-1-detail-box fr">'+
		                '<h3 class="tit">'+
		                    '<a href="javascript:to_Traindetails('+json[i].tSubject_ID +')" title="'+json[i].tMechanism_Name+json[i].tSubject_CourseName+'" class="link" target="_blank">'+json[i].tSubject_CourseName+'</a>'+
		                '</h3>'+
		                '<p class="event4-1-company event4-1-plan"><i class="common-icon-big event4-1-company-icon"></i>主办方：'+json[i].tMechanism_Name+'</p>'+
		                '<p class="event4-1-plan"><i class="common-icon-big event4-1-time-icon"></i>报名时间：'+json[i].tSubject_EnrollStart+'～' + json[i].tSubject_EnrollEnd+'</p>'+
		                '<p class="event4-1-plan"><i class="common-icon-big event4-1-time-icon"></i>比赛时间：'+json[i].tSubject_Start+' ～'+ json[i].tSubject_End+'</p>'+
		                '<div class="event4-1-data-box">'+
		                   '<span class="event4-1-data-con c-666">'+
		                      '报名已<em class="orange">结束</em>'+
		                   '</span>'+
		            '</div>'+
		           '<div class="event4-1-btn-box">'+
		            '<!-- <span class="sk-btn sk-btn-orange">添加关注</span> -->'+
		           '<a href="javascript:to_Traindetails('+json[i].tSubject_ID+')" class="sk-btn sk-btn-green" target="_blank">查看详情</a>'+
		                '</div>'+
		               '</div>'+
		              '</li>');
		}
		
	}
}
function to_Traindetails(data){
	window.location.href="/2016-06-21_usgame_competition/Web_V3/train/train_detail.jsp?tSubject_ID="+data;
}