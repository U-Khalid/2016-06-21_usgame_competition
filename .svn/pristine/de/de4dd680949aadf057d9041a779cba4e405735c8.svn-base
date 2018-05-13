<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>培训</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/2016-06-21_usgame_competition/Web_V3/css/flexslider.css">
<link rel="stylesheet" type="text/css" href="/2016-06-21_usgame_competition/Web_V3/css/contest.info-4.3.min.css">
<link rel="stylesheet" type="text/css" href="/2016-06-21_usgame_competition/Web_V3/css/top-4.4.min.css">
<link rel="stylesheet" type="text/css" href="/2016-06-21_usgame_competition/Web_V3/css/index-4.1.1.min.css">
<script type="text/javascript" src="/2016-06-21_usgame_competition/common/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="../js/jquery.flexslider-min.js"></script>
<script type="text/javascript" src="/2016-06-21_usgame_competition/Web_V3/js/common.js"></script>
<script type="text/javascript">
	$(window).load(function() {
		  $('.flexslider').flexslider({
		    animation: "slide",
		    prevText: "",//设置箭头旁的字符为"",初始为previous
		    nextText: "" //设置箭头旁的字符为"",初始为Next
		  });
	});
</script>
<script type="text/javascript" src="train_list.js"></script>
<style type="text/css">

</style>
</head>	
<body>
<!--body-wrap-->

<div class="body-wrap">
	
	<div class="body-main main-wrap v-4-2">
        <jsp:include page="../common/head.jsp"></jsp:include>
<!-- <style type="text/css">
    .sk-index-recommend-con .item-img-box{background-size:35%}
    .sk-index-title h3{font-size:20px;font-weight:600}
    .sk-index-partners-con .item{margin-bottom:30px}
</style> -->
    <!-- slider -->
    <div class="sk-index-slider-box" id="skSlider" style="min-width: 1600px;max-width: 1920px;">

				<div class="flexslider">
					<ul class="slides" style="height: 350px;">
						<!-- <li>
							<a href="#" target= _blank>
						    <img src="/2016-06-21_usgame_competition/images/main/27.jpg" />
							</a>
						</li>
						<li>
							<a href="#" target= _blank>
							<img src="/2016-06-21_usgame_competition/images/main/21.png" />
							</a>
						</li>
						<li>
							<a href="#" target= _blank>
							<img src="/2016-06-21_usgame_competition/images/main/22.png" />
							</a>
							</li>
						<li>
							<a href="#" target= _blank>
							<img src="/2016-06-21_usgame_competition/images/main/17.jpg" />
							</a>
						</li> -->
					</ul>
				</div>
		</div>
<div class="sk-event4-1-box sk-compet4-1-list-box clearfix">
    <div class="sidebar-a fl">
        <form action="">
            <div class="event4-1-column-box">
                <div class="list tab-box clearfix js_screen_list" action-target="class">
                    <div class="tab-wrap v-4-1 clearfix">
                        <div class="tit fl" >课程：</div>
                        <div class="fl clearfix list-box js_subject_wrap active" id="course" >
                            <a href="javascript:;"  onclick="js_option(this)" class="item  active" action-data="null" id="exm1">全&nbsp;部</a>
                            <a href="javascript:;"  onclick="js_option(this)" class="item" action-data="数学" id="exm2">奥数</a>
                            <a href="javascript:;"  onclick="js_option(this)" class="item" action-data="语文">语文</a>
                            <a href="javascript:;"  onclick="js_option(this)" class="item" action-data="英语">英语</a>
                            <a href="javascript:;"  onclick="js_option(this)" class="item" action-data="机器人">机器人</a>
                            <a href="javascript:;"  onclick="js_option(this)" class="item" action-data="计算机编程">计算机编程</a>                                        
                       </div>
                    </div>
                    <input type="hidden" name="class" class="js_screen_class" value="all">
                </div>
               
                <div class="list clearfix js_screen_list" action-target="rtime">
                    <div class="tit fl">报名：</div>
                    <div class="fl clearfix list-box" id="sign_up">
                        <a href="javascript:;"  onclick="js_option(this)" class="item  active" action-data="null">全部</a>
                        <a href="javascript:;"  onclick="js_option(this)" class="item  " action-data="0">未开始</a>
                        <a href="javascript:;"  onclick="js_option(this)" class="item  " action-data="1">进行中</a>
                        <a href="javascript:;"  onclick="js_option(this)" class="item  " action-data="2">已结束</a>
                    </div>
                    <input type="hidden" name="rtime" class="js_screen_rtime" value="0">
                </div>
                <!-- <div class="list clearfix js_screen_list" action-target="ctime">
                    <div class="tit fl" >培训：</div>
                    <div class="clearfix fl list-box" id="train">
                        <a href="javascript:;"  onclick="js_option(this)" class="item  active" action-data="null">全部</a>
                        <a href="javascript:;"  onclick="js_option(this)" class="item  " action-data="0">未开始</a>
                        <a href="javascript:;"  onclick="js_option(this)" class="item  " action-data="1">进行中</a>
                        <a href="javascript:;"  onclick="js_option(this)" class="item  " action-data="2">已结束</a>
                     </div>
                    <input type="hidden" name="ctime" class="js_screen_ctime" value="0">
                </div> -->
            </div>
            <input type="submit" id="eventScreenSub" style="display:none">
        </form>
        <div class="event4-1-list-box" id="event4-1LoadContentBox">
            <ul class="list" id="trainlist">
                 
            </ul>
        </div>
        <div class="pagination-box">
            <ul class="pagination" id="pagination">
               <li><a class="active">1</a></li>
               <li><a href="/vs?page=2" data-ci-pagination-page="2" rel="start">2</a></li>
               <li><a href="/vs?page=3" data-ci-pagination-page="3">3</a></li>
               <li><a href="/vs?page=4" data-ci-pagination-page="4">4</a></li>
               <li><a href="/vs?page=5" data-ci-pagination-page="5">5</a></li>
               <li class="next"><a href="/vs?page=2" data-ci-pagination-page="2" rel="next">→</a></li>
               <li class="last"><a href="/vs?page=59" data-ci-pagination-page="59">尾页</a></li>   
            </ul>
        </div>
    </div>
    <div class="sidebar-b fr">
        <div class="sidebar-b-con">
                    
                </div>
    </div>
</div>
 </div>
</div>
<jsp:include page="../common/end.jsp"></jsp:include>
</body>
</html>