$(document).ready(function(){
	$(".cp-head").removeClass("active");
	$("#head_main").addClass(" active");
	getCompetition();
	getCamp();
	getTrain();
	getMainslides();
});
//得到主页轮播图片
function getMainslides() {
	//竞赛
	$.post('../../CompetitionServlet', {
		method : 'getCompetitionSlides' 
	}, function(json) {
		var data = JSON.parse(json);
		if(data.msg){
		var json = data.competition;
			$('.slides').append(
					'<li>'+
					'<a href="javascript:toCompetitiondetails('+json.competitionId+')" target=_blank>'+
					'<img src="/2016-06-21_usgame_competition/images/main/'+ json.competitionBigPic+'" />'+
					'</a>'+
					'</li>'
			);
		}
	});
	//营地
	$.post('../../CampServlet', {
		method : 'getCampSlides' 
	}, function(json) {
		var data = JSON.parse(json);
		if(data.msg) {
		var json = data.camp;
			$('.slides').append(
					'<li>'+
					'<a href="javascript:toCampdetails('+json.campId+')" target=_blank>'+
					'<img src="/2016-06-21_usgame_competition/images/main/'+ json.camp_BigPic+'" />'+
					'</a>'+
					'</li>'
			);
		}
	});
	//培训
	$.post('../../TrainServlet', {
		method : 'getTrainSlides' 
	}, function(json) {
		var data = JSON.parse(json);
		if(data.msg) {
			var json = data.train;
			$('.slides').append(
					'<li>'+
					'<a href="javascript:todetail('+json.tSubject_ID+')" target=_blank>'+
					'<img src="/2016-06-21_usgame_competition/images/main/'+ json.tSubject_BigPic+'" />'+
					'</a>'+
					'</li>'
			);
		} 
	});
	
}
//竞赛开始
function getCompetition() {

	$.post('../../CompetitionServlet', {
		method : 'getMainCompetition' 
	}, function(json) {
		var data = JSON.parse(json);
		//console.log(data);
		var json = data.data;
//		console.log(json);
		showCompetitionInfo(json);
	});
}

function showCompetitionInfo(json) {
	for(var i=0;i<4;i++) {
		$('#Competition_list').append(
				"<a href='javascript:toCompetitiondetails("+json[i].competitionId+")' class='item' target='_blank'>"+
	            "<span class='item-img-box'>"+
	                "<img src='/2016-06-21_usgame_competition/images/main/"+json[i].competitionPic+"' alt="+json[i].competitionName+">"+
	            "</span>"+
	            "<span class='item-title' title="+json[i].competitionName+">"+json[i].competitionName +"</span>"+
	           " <span class='item-sponsor' title="+json[i].competitionSubject+">竞赛科目："+ json[i].competitionSubject+" </span>"+
	       " </a>	"	
		)
	}
	
}

function toCompetitiondetails(id) {
	window.location.href = "../competition/competition_details.jsp?CompetitionId="+id;
}


//竞赛结束


function getCamp(){
	$.post('../../CampServlet',{
		method : 'getMainCamp'
	},function(json){
		var data = JSON.parse(json);
		/*console.log(data);*/
		var json = data.data;
		showCampInfo(json);
	});
}



//获取营地信息
function showCampInfo(json){
	for(var i=0;i<4;i++){
		$('#Camp_list').append(
				"<a href='javascript:toCampdetails("+json[i].campId+")' class='item' target='_blank'>"+
	            "<span class='item-img-box'>"+
	                "<img src='/2016-06-21_usgame_competition/images/main/"+json[i].camp_Pic+"' alt="+json[i].camp_Name+">"+
	            "</span>"+
	            "<span class='item-title' title="+json[i].camp_Name+">"+json[i].camp_Name +"</span>"+
	           " <span class='item-sponsor' title="+json[i].camp_Address+">营地地点："+ json[i].camp_Address+" </span>"+
	       " </a>	"	
		)
	}
}

function toCampdetails(id){
	window.location.href ="../camp/camp_details.jsp?CampId="+id;
}

//营地信息获取结束



//获取培训信息
function getTrain(){
	$.post("../../TrainServlet",{
		method:"getTrainList",
	},function(json){
		var json = JSON.parse(json);
		json = json.data;
		showTrainList(json);
	})
}
function showTrainList(json){
	$("#trainList").html('');
	for(var i=0;i<4;i++){
		/*console.log(json[i]);*/
		$("#trainList").append('<a href="javascript:;" onclick="todetail('+json[i].tSubject_ID+')" title="'+json[i].tSubject_CourseName+'" class="item" target="_blank">'+
					'<span class="item-img-box">'+
					'<img src="/2016-06-21_usgame_competition/images/main/'+json[i].tSubject_PictureUrl+'" alt="'+json[i].tSubject_CourseName+'">'+
					'</span>'+
					'<span class="item-title" title="'+json[i].tSubject_CourseName+'">'+ json[i].tSubject_CourseName+
					'</span>'+
					'<span class="item-sponsor" title="'+json[i].tSubject_Course+'">'+
					' 培训科目：'+json[i].tSubject_Course+'</span>'+
					
					'</a>');
	}
}
function todetail(json){
	window.location.href = "../train/train_detail.jsp?tSubject_ID="+json;
}
//培训信息获取结束