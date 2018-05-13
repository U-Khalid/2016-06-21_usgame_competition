<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
 	<link rel="apple-touch-icon-precomposed" sizes="114x114" href="/2016-06-21_usgame_competition/images/main/sk_mobile_icon114x114.png"><!-- 对应retina屏的iPhone及iTouch图标尺寸114x114 -->
    <link rel="stylesheet" type="text/css" href="/2016-06-21_usgame_competition/Web_V3/css/top-4.4.min.css">
    <link rel="stylesheet" type="text/css" href="/2016-06-21_usgame_competition/Web_V3/css/event4.1.min.css">
    <link rel="stylesheet" type="text/css" href="/2016-06-21_usgame_competition/Web_V3/css/homepage-4.5.min.css">
    <script type="text/javascript" src="/2016-06-21_usgame_competition/common/jquery-1.11.1.min.js"></script>
    <script type="text/javascript" src="/2016-06-21_usgame_competition/Web_V3/search/search.js"></script>
    <script type="text/javascript" src="/2016-06-21_usgame_competition/Web_V3/js/common.js"></script>
<title>搜索</title>
<style type="text/css">
.top-box{
width:1080px;
height:80px;
position:relative;
margin:0 auto
}
</style>
</head>
<body>
<!--body-wrap-->
<div class="body-wrap">
    <div class="body-main main-wrap v-4-2">
        <jsp:include page="../common/head.jsp"></jsp:include>
<div class="top-box">
</div>

<!-- nav -->
<div class="sk-hp-nav clearfix">
    <a href="javascript:showCompetition()" class="item active" id="competition">
        <i class="common-icon-big contest-icon"></i>竞赛
    </a>
    <a href="javascript:showCamp()" class="item " id="camp">
        <i class="common-icon-big active-icon"></i>营地
    </a>
    <a href="javascript:showTrain()" class="item " id="train">
        <i class="common-icon-big topic-icon"></i>培训
    </a>
    
</div>

<div class="sk-compet4-1-list-box sk-hp-content-box">
    <div class="event4-1-list-box">
        <ul class="competitionList">
						
		</ul>
    </div>
    <div class="event4-1-list-box">
        <ul class="campList" style="display: none">
						
		</ul>
    </div>
    <div class="event4-1-list-box">
        <ul class="trainList" style="display: none">
						
		</ul>
    </div>
</div>
 </div>
</div>

<jsp:include page="../common/end.jsp"></jsp:include>
</body>
</html>