<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>竞赛详情--资优少年</title>
    <link rel="stylesheet" type="text/css" href="/2016-06-21_usgame_competition/Web_V3/css/top-4.4.min.css">
    <link rel="stylesheet" type="text/css" href="/2016-06-21_usgame_competition/Web_V3/css/contest.info-4.3.min.css">
    <link rel="stylesheet" type="text/css" href="/2016-06-21_usgame_competition/Web_V3/css/monokai_sublime.min.css">
<script type="text/javascript" src="../../common/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="/2016-06-21_usgame_competition/Web_V3/js/common.js"></script>
<script type="text/javascript" src="competition_details.js"></script>

</head>
<body>
<!--body-wrap-->
<div class="body-wrap">
    <div class="body-main main-wrap v-4-2">
        <jsp:include page="../common/head.jsp"></jsp:include>
        
<style type="text/css">.text-body p a{color:#22bfa7;}.text-body h1,.text-body h2,.text-body h3{padding:0}</style>
<!-- publicTop位置 -->
<style>
    .nav{position:static;}
    .mtv-pop-box .item:nth-child(even){padding-left:0}
    .sk-event4-1-detail-banner-con .para{max-width:90%;margin:0 auto}
</style>
<div class="sk-event4-1-detail-banner" style="margin-top:50px;">
   <!--  <img src="/2016-06-21_usgame_competition/images/main/14838620323b2cb848ef4a8c877772a6e1fdcc4b79.jpg"  class="sk-event4-1-detail-img">
    <div class="sk-event4-1-detail-banner-con">
            <div class="sk-event4-1-detail-banner-min" id="">
            <h1 class="banner-title"  id="competitionName"></h1>
            <p class="para">主办方：<span id="competitionSupportDesc"></span></p>
                    <p class="para">报名时间：<span id="date_b_e"></span></p>

        </div>
            </div> -->
</div>
<div class="sk-event-detail-nav" id="eventDetailNav">
    <div class="sk-event-detail-nav-main">
        <a href="#" class="item active"><i class="common-icon-big detail-icon"></i>赛事详情</a>
    </div>
</div>
<div class="sk-event4-1-box event4-1-detail clearfix">
    <div class="sidebar-a fl" id="eventDetailBox">
                <div class="event4-1-detail-box event4-1-brief-box">
            <div class="title-box">
               <h3 class="title">竞赛简介</h3>
            </div>
            <div class="event4-1-detail-text-box event4-1-brief-text-box text-body">
            	<p class="para">竞赛名字：<span id="competitionName1"></span></p>
            	<p class="para">竞赛形式：<span id="competitionForm"></span></p>
               <p class="para">主办方：<span id="competitionSupportDesc"></span></p>
               <p class="para">参加人员描述：<span id="competitionJoinerDes"></span></p>
               <p class="para">竞赛时间：<span id="test-start"></span></p>
               <p class="para">竞赛奖项描述：<span id="competitionPrizeDes"></span></p>
               <p class="para">竞赛地点：<span id="competitionTestAddress"></span></p>
               <p class="para">竞赛报名费用：<span id="competitionMoney"></span></p>
               <p class="para">竞赛报名地址：<span id="competitionApplyAddress"></span></p>
            </div>
        </div>
                
                <div class="event4-1-detail-box">
            <div class="title-box">
               <h3 class="title">竞赛详情</h3>
            </div>
            <div class="event4-1-detail-text-box text-body clearfix" id="competition_details">
            

            </div>
        </div>
            
    </div>
    <!-- 右边栏位置 -->
    <div class="sidebar-b fr" id="eventSideBar">
    <div class="sidebar-b-con m-10">
        <div class="event4-1-detail-btn-box clearfix">
            <!-- <a href="javascript:;" class="sk-btn sk-btn-green fr">我要报名</a> -->
                             <!-- 如果可以报名 -->
                                        <a class="fr sk-btn sk-btn-green" href="javascript:apply()">立即报名</a>
                                                

                            <!-- <a class="fr sk-btn sk-btn-green link-btn" href="/<?//php echo $contest['parent_url']?>"><?//php echo $contest['parent_branch_name']?>入口</a> -->
                                <a class="sk-btn sk-btn-orange js_new_event_follow_btn"  id="add" style="display:none" href="javascript:payAttention()">添加关注</a>
                                <a class="sk-btn sk-btn-orange js_new_event_follow_btn"  id="yet" style="display:none" href="javascript:delectAttention()">已关注</a>
                </div>
    </div>
  
    <div class="sidebar-b-con">
        <div class="title-box">
           <h3 class="title">竞赛信息</h3>
        </div>
        <div class="new-event4-1-box">
            <ul class="new-event4-1-list">
            	
                <li class="new-event4-1-info-item clearfix">
                    <span class="info-name fl">竞赛科目：</span>
                    <p class="info-content fl" id="competitionSubject">
                       
                    </p>
                </li>
                <li class="new-event4-1-info-item clearfix">
                    <span class="info-name fl">竞赛类型：</span>
                    <p class="info-content fl" id="competitionType">
                       
                    </p>
                </li>
                <li class="new-event4-1-info-item clearfix">
                    <span class="info-name fl">竞赛形式：</span>
                    <p class="info-content fl" id="competitionForm1">
                       
                    </p>
                </li>
                
                <li class="new-event4-1-info-item clearfix">
                    <span class="info-name fl">报名时间：</span>
                    <div class="info-content fl">
                       <p class="date-start" id="date-start"> </p>
                       <p class="date-end" id="date-end"></p>
                    </div>
                </li>
               
                <li class="new-event4-1-info-item clearfix">
                    <span class="info-name fl">比赛状态：</span>
                    <p class="info-content fl" id="competitionState">
                       
                    </p>
                </li>
            </ul>
        </div>
    </div>
</div>

 </div>
</div>
<jsp:include page="../common/end.jsp"></jsp:include>
</body>
</html>