$(document).ready(function() {
	$(".cp-head").removeClass("active");
	$("#head_competition").addClass(" active");
	showCompetitionList();
	getCompetitionslides();
});
function getCompetitionslides() {
	$.post('../../CompetitionServlet', {
		method : 'getMainCompetition' 
	}, function(json) {
		var data = JSON.parse(json);
		//console.log(data);
		var json = data.data;
		showCompetitionslides(json);
	});
}
function showCompetitionslides(json){
	for(var i=0;i<4;i++) {
	$('.slides').append(
			'<li>'+
			'<a href="javascript:toCompetitiondetails('+json[i].competitionId+')" target=_blank>'+
		    '<img src="/2016-06-21_usgame_competition/images/main/'+ json[i].competitionBigPic+'" />'+
			'</a>'+
		'</li>'
	);
	}
}
function toCompetitiondetails(id) {
	window.location.href="competition_details.jsp?CompetitionId="+id;
}
function formoption(obj){
	var id=$(obj).parent().attr('id');
	var s="#"+id+" .item";
	$(s).removeClass("active");
	$(obj).addClass("active");
	
	$.post("../../CompetitionServlet",{
		method:"getCompetitionListByForm",
		course:$("#course .active").attr('action-data'),
		/*level:$("#level .active").attr('action-data'),*/
		rtime:$("#rtime .active").attr('action-data'),
	},function(json){
		$('.competitionlist').empty();
		var data = JSON.parse(json);
		//console.log(data);
		var json = data.data;
		showCompetitionInfo(json);
		
	});
}

function showCompetitionList(){
	$.post('../../CompetitionServlet', {
		method : 'getCompetitionList' 
	}, function(json) {
		var data = JSON.parse(json);
		//console.log(data);
		var json = data.data;
		showCompetitionInfo(json);
	});
}
function showCompetitionInfo(json) {
	//console.log(json);
	for(var i=0;i<json.length;i++){
		$('.competitionlist').append(
				'<li class="item clearfix">'+
				'<a href="javascript:toCompetitiondetails('+json[i].competitionId+')" class="event4-1-img-box fl" title='+json[i].competitionName+' target="_blank">'+
				'<img src="/2016-06-21_usgame_competition/images/main/'+json[i].competitionPic+'" alt='+json[i].competitionName+'>'+
				'</a>'+
				'<div class="event4-1-detail-box fr">'+
				'<h3 class="tit">'+
				'<a href="javascript:toCompetitiondetails('+json[i].competitionId+')" title='+json[i].competitionName+' class="link" target="_blank">'+json[i].competitionName+' </a>'+
				'</h3>'+
				'<p class="event4-1-company event4-1-plan"><i class="common-icon-big event4-1-company-icon"></i>主办方：'+json[i].competitionSupportDesc+'</p>'+
				'<p class="event4-1-plan"><i class="common-icon-big event4-1-time-icon"></i>报名时间：'+json[i].competitionApplyStartTime+' ～ '+json[i].competitionApplyEndTime+'</p>'+
				'<p class="event4-1-plan"><i class="common-icon-big event4-1-time-icon"></i>比赛时间：'+json[i].competitionTestTimeDes+'</p>'+
				/*'<div class="event4-1-data-box">'+
				'<span class="event4-1-data-con"><i class="common-icon-big event4-1-scan-icon"></i>浏览<em>1690</em></span>'+
				'<span class="event4-1-data-con c-666">离报名结束还剩<em class="orange">0</em>天'+
				'</span>'+
				'</div>'+*/
				'<div class="event4-1-btn-box">'+
				'<a href="javascript:toCompetitiondetails('+json[i].competitionId+')" class="sk-btn sk-btn-green" target="_blank">查看详情</a>'+
				'</div>'+
				'</div>'+
				'</li>'
		)
	}
	
}

