var total;
$(document).ready(function(){
	$(".cp-head").removeClass("active");
	$("#head_train").addClass(" active");
//	alert($("#pagination .active").html);
//	console.log("当前页码："+$("#pagination .active").text());
	showtrainlist();
	calculation();
//	$(".item").click(function(){
//		var id=$(this).parent().attr("id");
//		var s="#"+id+" .item";
//		$(s).removeClass("active");
//		$(".item").each(function(index,domEle){
//			$(domEle).removeClass("active");
//		});
//		$(this).addClass("active");
//		
//	});  
	getTrainSlides();
});


function getTrainSlides(){
	$.post('../../TrainServlet', {
		method : 'getTrainList' 
	}, function(json) {
		var data = JSON.parse(json);
		//console.log(data);
		var json = data.data;
		showTrainSlides(json);
	});
}


function showTrainSlides(json){
	for(var i=0;i<4;i++) {
		$('.slides').append(
				'<li>'+
				'<a href="javascript:to_details('+json[i].tSubject_ID+')" target=_blank>'+
				'<img src="/2016-06-21_usgame_competition/images/main/'+ json[i].tSubject_BigPic+'" />'+
				'</a>'+
				'</li>'
		);
	}
}



function showtrainlist(){
	$.post("../../TrainServlet",{
		method:"getTrainList"
	},function(json){
		var json = JSON.parse(json);
		var json1 = json.data;
		var json2 = json.data2;
		console.log(json1);
		console.log(json2);
		showlist(json1,json2);
	})
}
function js_option(obj){
	var id=$(obj).parent().attr('id');
	var s="#"+id+" .item";
	$(s).removeClass("active");
	$(obj).addClass("active");
	
	$.post("../../TrainServlet",{
		method:"getTrainDetail",
		course:$("#course .active").attr('action-data'),
		enrollState:$("#sign_up .active").attr('action-data'),
		/*trainState:$("#train .active").attr('action-data'),*/
		page:1
	},function(json){
		var json = JSON.parse(json);
		json=eval(json.rows);
		console.log(json);
		showlist(json);
	});
	calculation();
}

function showlist(json1,json2){
	$("#trainlist").html('');
	for(var i=0;i<json1.length;i++){

		var now = new Date();
		var ersta = new Date(json1[i].tSubject_EnrollStart);
		var erend = new Date(json1[i].tSubject_EnrollEnd);
		var day;
		
		/*console.log("现在的时间是"+now.getTime()+"报名开始的时间是"+ersta.getTime()+"报名结束的时间是"+erend.getTime());*/
		if(now.getTime() < ersta.getTime()){
			day = parseInt((ersta.getTime()-now.getTime())/(1000*60*60*24));
			
			$("#trainlist").append(
				'<li class="item clearfix">'+
	             	'<a href="javascript:to_details('+json1[i].tSubject_ID +')" class="event4-1-img-box fl" title="'+json2[i].tMechanism_Name+json1[i].tSubject_CourseName+'" target="_blank">'+
	                   '<img src="/2016-06-21_usgame_competition/images/main/'+json1[i].tSubject_PictureUrl+'" alt="'+json2[i].tMechanism_Name+json1[i].tSubject_CourseName+'">'+
	                 '</a>'+
	            '<div class="event4-1-detail-box fr">'+
	                '<h3 class="tit">'+
	                    '<a href="javascript:to_details('+json1[i].tSubject_ID +')" title="'+json2[i].tMechanism_Name+json1[i].tSubject_CourseName+'" class="link" target="_blank">'+json1[i].tSubject_CourseName+'</a>'+
	                '</h3>'+
	                '<p class="event4-1-company event4-1-plan"><i class="common-icon-big event4-1-company-icon"></i>主办方：'+json2[i].tMechanism_Name+'</p>'+
	                '<p class="event4-1-plan"><i class="common-icon-big event4-1-time-icon"></i>报名时间：'+changeTime(json1[i].tSubject_EnrollStart)+'～' + changeTime(json1[i].tSubject_EnrollEnd)+'</p>'+
	                '<p class="event4-1-plan"><i class="common-icon-big event4-1-time-icon"></i>比赛时间：'+changeTime(json1[i].tSubject_Start)+' ～'+ changeTime(json1[i].tSubject_End)+'</p>'+
	                '<div class="event4-1-data-box">'+
	                   '<span class="event4-1-data-con c-666">'+
	                   	'报名未开始，离报名开始还有<em class="orange">'+(day+1)+'</em>天'+
	                   '</span>'+
	            '</div>'+
	           '<div class="event4-1-btn-box">'+
	            '<!-- <span class="sk-btn sk-btn-orange">添加关注</span> -->'+
	           '<a href="javascript:to_details('+json1[i].tSubject_ID+')" class="sk-btn sk-btn-green" target="_blank">查看详情</a>'+
	                '</div>'+
	               '</div>'+
	              '</li>');
		}
		else if(now.getTime() >= ersta.getTime() && now.getTime() <= erend.getTime()){
			day = parseInt((erend.getTime()-now.getTime())/(1000*60*60*24));
			
			$("#trainlist").append(
					'<li class="item clearfix">'+
	             	'<a href="javascript:to_details('+json1[i].tSubject_ID +')" class="event4-1-img-box fl" title="'+json2[i].tMechanism_Name+json1[i].tSubject_CourseName+'" target="_blank">'+
	                   '<img src="/2016-06-21_usgame_competition/images/main/'+json1[i].tSubject_PictureUrl+'" alt="'+json2[i].tMechanism_Name+json1[i].tSubject_CourseName+'">'+
	                 '</a>'+
	            '<div class="event4-1-detail-box fr">'+
	                '<h3 class="tit">'+
	                    '<a href="javascript:to_details('+json1[i].tSubject_ID +')" title="'+json2[i].tMechanism_Name+json1[i].tSubject_CourseName+'" class="link" target="_blank">'+json1[i].tSubject_CourseName+'</a>'+
	                '</h3>'+
	                '<p class="event4-1-company event4-1-plan"><i class="common-icon-big event4-1-company-icon"></i>主办方：'+json2[i].tMechanism_Name+'</p>'+
	                '<p class="event4-1-plan"><i class="common-icon-big event4-1-time-icon"></i>报名时间：'+json1[i].tSubject_EnrollStart+'～' + json1[i].tSubject_EnrollEnd+'</p>'+
	                '<p class="event4-1-plan"><i class="common-icon-big event4-1-time-icon"></i>比赛时间：'+json1[i].tSubject_Start+' ～'+ json1[i].tSubject_End+'</p>'+
	                '<div class="event4-1-data-box">'+
	                   '<span class="event4-1-data-con c-666">'+
	                   	'离报名结束还剩<em class="orange">'+(day+1)+'</em>天'+
	                   '</span>'+
	            '</div>'+
	           '<div class="event4-1-btn-box">'+
	            '<!-- <span class="sk-btn sk-btn-orange">添加关注</span> -->'+
	           '<a href="javascript:to_details('+json1[i].tSubject_ID+')" class="sk-btn sk-btn-green" target="_blank">查看详情</a>'+
	                '</div>'+
	               '</div>'+
	              '</li>');
		}
		else{
			$("#trainlist").append(
					'<li class="item clearfix">'+
		             	'<a href="javascript:to_details('+json1[i].tSubject_ID +')" class="event4-1-img-box fl" title="'+json2[i].tMechanism_Name+json1[i].tSubject_CourseName+'" target="_blank">'+
		                   '<img src="/2016-06-21_usgame_competition/images/main/'+json1[i].tSubject_PictureUrl+'" alt="'+json2[i].tMechanism_Name+json1[i].tSubject_CourseName+'">'+
		                 '</a>'+
		            '<div class="event4-1-detail-box fr">'+
		                '<h3 class="tit">'+
		                    '<a href="javascript:to_details('+json1[i].tSubject_ID +')" title="'+json2[i].tMechanism_Name+json1[i].tSubject_CourseName+'" class="link" target="_blank">'+json1[i].tSubject_CourseName+'</a>'+
		                '</h3>'+
		                '<p class="event4-1-company event4-1-plan"><i class="common-icon-big event4-1-company-icon"></i>主办方：'+json2[i].tMechanism_Name+'</p>'+
		                '<p class="event4-1-plan"><i class="common-icon-big event4-1-time-icon"></i>报名时间：'+json1[i].tSubject_EnrollStart+'～' + json1[i].tSubject_EnrollEnd+'</p>'+
		                '<p class="event4-1-plan"><i class="common-icon-big event4-1-time-icon"></i>比赛时间：'+json1[i].tSubject_Start+' ～'+ json1[i].tSubject_End+'</p>'+
		                '<div class="event4-1-data-box">'+
		                   '<span class="event4-1-data-con c-666">'+
		                      '报名已<em class="orange">结束</em>'+
		                   '</span>'+
		            '</div>'+
		           '<div class="event4-1-btn-box">'+
		            '<!-- <span class="sk-btn sk-btn-orange">添加关注</span> -->'+
		           '<a href="javascript:to_details('+json1[i].tSubject_ID+')" class="sk-btn sk-btn-green" target="_blank">查看详情</a>'+
		                '</div>'+
		               '</div>'+
		              '</li>');
		}
		
	}
}

function to_details(data){
	window.location.href="train_detail.jsp?tSubject_ID="+data;
}

function calculation(){
	$.post("../../TrainServlet",{
		method:"getTrainCount",
		course:$("#course .active").attr('action-data'),
		enrollState:$("#sign_up .active").attr('action-data'),
		/*trainState:$("#train .active").attr('action-data')*/
	},function(json){
		json = JSON.parse(json);
		var page = parseInt(json.num/30);
		total = page;
		paging(page);
	})
}

function paging(json){
	$("#pagination").html('');
	$("#pagination").append('<li class="last"><a class="paging index"  data-ci-pagination-page="index" value="1">首页</a></li>'+
				'<li class="previous"><a class="paging index"  data-ci-pagination-page="previous" rel="previous">上一页</a></li>'+
				'<li><a class="active paging" value="1" data-ci-pagination-page="1">1</a></li>');
	if(json>=2){
		for(var i=0;i<json-1;i++){
			$("#pagination").append('<li><a value="'+(i+2)+'" class="paging" href="javascript:;" onclick="to_page('+(i+2)+',this)" data-ci-pagination-page="'+(i+2)+'">'+(i+2)+'</a></li>');
		}
		$("#pagination").append('<li class="next"><a value="2" class="paging Shadowe" href="javascript:;" onclick="to_page(2,this)" data-ci-pagination-page="next" rel="next" value="2">下一页</a></li>'+
	            '<li class="last"><a value="'+json+'" class="paging Shadowe" href="javascript:;" onclick="to_page('+json+',this)" data-ci-pagination-page="last">尾页</a></li> ');
	}
	else{
		$("#pagination").append('<li class="next"><a value="2" class="paging Shadowe" data-ci-pagination-page="next" rel="next" value="2">下一页</a></li>'+
	            '<li class="last"><a value="'+json+'" class="paging Shadowe" data-ci-pagination-page="last">尾页</a></li> ');
	}
		
}

function to_page(json,obj){
//	var noclick = $("#pagination .active").text();
//	alert(noclick);
//	var clicked = $(obj).attr("value");
//	$("#pagination .active").attr({onclick:"to_page(1,this)",href:"javascript:;"});
//	$("#pagination .paging").removeClass("active");
//	$(obj).addClass("active");
//	$("#pagination a[data-ci-pagination-page='previous']").attr("value",""+page-1);
//	$(obj).attr("onclick")
//	console.log("page="+page+"\t total="+total);
//	if(page==1){
//		$("#pagination .index").removeAttr("href onclick");
//	}
//	else if(page==total){
//		$("#pagination a[data-ci-pagination-page='index']").attr({href:"javascript:;",onclick:"to_page(1,this)"});
//		$("#pagination a[data-ci-pagination-page='previous']").attr({href:"javascript:;",onclick:"to_page("+(page-1)+",this)"});
//	}
	var clicked = parseInt($(obj).attr("value"));
	var noclick = parseInt($("#pagination .active").text());
	console.log("当前页码为"+noclick+"\t被点击的页码为"+clicked);
	$("#pagination .active").attr({href:"javascript:;",onclick:"to_page("+noclick+",this)"});
	$("#pagination .active").removeClass("active");
	$("#pagination a[data-ci-pagination-page='"+clicked+"']").addClass("active");
	$("#pagination a[data-ci-pagination-page='"+clicked+"']").removeAttr("href  onclick");
	$("#pagination a[data-ci-pagination-page='index']").attr({href:"javascript:;",onclick:"to_page(1,this)"});
	$("#pagination a[data-ci-pagination-page='previous']").attr({href:"javascript:;",onclick:"to_page("+(clicked-1)+",this)",value:""+(clicked-1)});
	$("#pagination a[data-ci-pagination-page='next']").attr({href:"javascript:;",onclick:"to_page("+(clicked+1)+",this)",value:""+(clicked+1)});
	$("#pagination a[data-ci-pagination-page='last']").attr({href:"javascript:;",onclick:"to_page("+total+",this)"});
	if(clicked==1){
		$("#pagination a[data-ci-pagination-page='index']").removeAttr("href  onclick");
		$("#pagination a[data-ci-pagination-page='previous']").removeAttr("href  onclick");
	}
	else if(clicked==total){
		$("#pagination a[data-ci-pagination-page='next']").removeAttr("href  onclick");
		$("#pagination a[data-ci-pagination-page='last']").removeAttr("href  onclick");
	}
	$.post("../../TrainServlet",{
		method:"getTrainDetail",
		course:$("#course .active").attr('action-data'),
		enrollState:$("#sign_up .active").attr('action-data'),
		trainState:$("#train .active").attr('action-data'),
		page:clicked
	},function(json){
		var json = JSON.parse(json);
		console.log(json); 
		var data = json.rows;
		showlist(data);
	})
}





