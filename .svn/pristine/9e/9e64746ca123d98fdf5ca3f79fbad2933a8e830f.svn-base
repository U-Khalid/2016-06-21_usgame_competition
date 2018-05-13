$(document).ready(function(){
	$(".cp-head").removeClass("active");
	$("#head_camp").addClass(" active");
	getCamplist();
	getCampSlides();
});
function getCampSlides() {
	$.post('../../CampServlet', {
		method : 'getMainCamp' 
	}, function(json) {
		var data = JSON.parse(json);
		//console.log(data);
		var json = data.data;
		showCampSlides(json);
	});
}
function showCampSlides(json) {
	for(var i=0;i<4;i++) {
		$('.slides').append(
				'<li>'+
				'<a href="javascript:to_campdetails('+json[i].campId+')" target=_blank>'+
			    '<img src="/2016-06-21_usgame_competition/images/main/'+ json[i].camp_BigPic+'" />'+
				'</a>'+
			'</li>'
		);
		}
}
function formoption(obj){
	var id=$(obj).parent().attr('id');
	var s="#"+id+" .item";
	$(s).removeClass("active");
	$(obj).addClass("active");
	
	$.post("../../CampServlet",{
		method:"getCampListByForm",
		destination:$("#destination .active").attr('action-data'),
		theme:$("#theme .active").attr('action-data'),
		suitableAge:$("#suitableAge .active").attr('action-data'),
		timeLength:$("#timeLength .active").attr('action-data'),
	},function(json){
		$('.camplist').empty();
		var data = JSON.parse(json);
		//console.log(data);
		var json = data.data;
		showCamplist(json);
		
	});
}

function getCamplist() {
	$.post("../../CampServlet",
			{
			method : 'getCampList' 
			},
			function(json) {
				var data = JSON.parse(json);
				var json = data.data;
				console.log(json)
				showCamplist(json)
			});
}
function showCamplist(json) {
	for(var i=0;i<json.length;i++) {
		$(".camplist").append(
		'<li class="item clearfix">'+
                     '<a href="javascript:to_campdetails('+json[i].campId+')" class="event4-1-img-box fl" title='+json[i].camp_Name+' target="_blank">'+
                         '<img src="/2016-06-21_usgame_competition/images/main/'+json[i].camp_Pic+'" alt="'+json[i].camp_Name+'">'+
                     '</a>'+
                     '<div class="event4-1-detail-box fr" >'+
                         '<h3 class="tit" >'+
                             '<a href="javascript:to_campdetails('+json[i].campId+')" title='+json[i].camp_Name+' class="link" target="_blank">'+json[i].camp_Name+'</a>'+
                         '</h3>'+
                         '<p class="event4-1-company event4-1-plan"><i class="common-icon-big event4-1-company-icon"></i>目的地：'+json[i].camp_Address+'</p>'+
                         '<p class="event4-1-plan"><i class="common-icon-big event4-1-time-icon"></i>主题：'+turnTheme(json[i].camp_theme)+'</p>'+
                         '<p class="event4-1-plan"><i class="common-icon-big event4-1-time-icon "></i>时长：'+turnTimeLength(json[i].camp_TimeLength)+'</p>'+
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
	window.location.href="camp_details.jsp?CampId="+id;
}

