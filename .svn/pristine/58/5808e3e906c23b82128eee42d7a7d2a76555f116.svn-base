<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>竞赛</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/2016-06-21_usgame_competition/Web_V3/css/flexslider.css">
<link rel="stylesheet" type="text/css" href="/2016-06-21_usgame_competition/Web_V3/css/contest.info-4.3.min.css">
<link rel="stylesheet" type="text/css" href="/2016-06-21_usgame_competition/Web_V3/css/top-4.4.min.css">
<link rel="stylesheet" type="text/css" href="/2016-06-21_usgame_competition/Web_V3/css/index-4.1.1.min.css">
<script type="text/javascript" src="/2016-06-21_usgame_competition/common/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="../js/jquery.flexslider-min.js"></script>
<script type="text/javascript" src="competition_list.js" ></script>
<script type="text/javascript">
/* 动态加载 */
setInterval(function () {  
	$('.flexslider').flexslider({
	    animation: "slide",
	    prevText: "",//设置箭头旁的字符为"",初始为previous
	    nextText: "" //设置箭头旁的字符为"",初始为Next
	  });
}, 0);  
	/* 静态加载 */
	/* $(window).load(function() {
		  $('.flexslider').flexslider({
		    animation: "slide",
		    prevText: "",//设置箭头旁的字符为"",初始为previous
		    nextText: "" //设置箭头旁的字符为"",初始为Next
		  });
		}); */
</script>
</head>	
<body>
<!--body-wrap-->

<div class="body-wrap">
	
	<div class="body-main main-wrap v-4-2">
        <jsp:include page="../common/head.jsp"></jsp:include>

    <!-- slider -->
    <div class="sk-index-slider-box" id="skSlider" style="min-width: 1600px;max-width: 1920px;">

				<div class="flexslider">
					<ul class="slides" style="height: 350px;">
						<!-- <li>
							<a href="" target= _blank>
						    <img src="/2016-06-21_usgame_competition/images/main/27.jpg" />
							</a>
						</li>
						<li>
							<a href="" target= _blank>
							<img src="/2016-06-21_usgame_competition/images/main/21.png" />
							</a>
						</li>
						<li>
							<a href="" target= _blank>
							<img src="/2016-06-21_usgame_competition/images/main/22.png" />
							</a>
							</li>
						<li>
							<a href="" target= _blank>
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
                    <div class="tab-nav clearfix">
                                            <a href="" class="tab-item js_subject_item active">竞赛分类</a>
                                        </div>
                    <div class="tab-wrap v-4-1 clearfix">
                        <div class="tit fl">类别：</div>
                        <div class="fl clearfix list-box js_subject_wrap active" id="course">
                            <a  onclick="formoption(this)" class="item  active" action-data="0">全部</a>
                             <a  onclick="formoption(this)" class="item  " action-data="1">数学</a>
                              <a  onclick="formoption(this)" class="item  " action-data="2">语文</a>
                               <a  onclick="formoption(this)" class="item  " action-data="3">英语</a>
                                <a  onclick="formoption(this)" class="item  " action-data="4">计算机</a>
                                                    </div>
                    </div>
                    <input type="hidden" name="class" class="js_screen_class" value="all">
                </div>
               <!--  <div class="list clearfix js_screen_list" action-target="level">
                    <div class="tit fl">级别：</div>
                    <div class="clearfix fl list-box" id="level">
                        <a  onclick="formoption(this)" class="item  active" action-data="0">全部</a>
                         <a  onclick="formoption(this)" class="item  " action-data="1">市级</a>
                          <a  onclick="formoption(this)" class="item  " action-data="2">省级</a>
                           <a  onclick="formoption(this)" class="item  " action-data="3">国家级</a>
                            <a  onclick="formoption(this)" class="item  " action-data="4">国际级</a>
                                            </div>
                    <input type="hidden" name="level" class="js_screen_level" value="0">
                </div> -->
                <div class="list clearfix js_screen_list" action-target="rtime">
                    <div class="tit fl">报名：</div>
                    <div class="fl clearfix list-box" id="rtime">
                        <a  onclick="formoption(this)" class="item  active" action-data="0">全部</a>
                         <a  onclick="formoption(this)" class="item  " action-data="1">未开始</a>
                          <a  onclick="formoption(this)" class="item  " action-data="2">进行中</a>
                           <a  onclick="formoption(this)" class="item  " action-data="3">已结束</a>
                                            </div>
                    <input type="hidden" name="rtime" class="js_screen_rtime" value="0">
                </div>
            </div>
            <!-- <input type="submit" id="eventScreenSub" style="display:none"> -->
            
        </form>
        <div class="event4-1-list-box" id="event4-1LoadContentBox">
            <ul class="competitionlist" >
                            
                           
                        </ul>
        </div>
        <!-- <div class="pagination-box">
            <ul class="pagination">
                <li><a class="active">1</a></li><li><a href="/vs?page=2" data-ci-pagination-page="2" rel="start">2</a></li><li><a href="/vs?page=3" data-ci-pagination-page="3">3</a></li><li><a href="/vs?page=4" data-ci-pagination-page="4">4</a></li><li><a href="/vs?page=5" data-ci-pagination-page="5">5</a></li><li class="next"><a href="/vs?page=2" data-ci-pagination-page="2" rel="next">→</a></li><li class="last"><a href="/vs?page=59" data-ci-pagination-page="59">尾页</a></li>            </ul>
        </div> -->
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