<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>营地详情--资优少年</title>
    <link rel="stylesheet" type="text/css" href="/2016-06-21_usgame_competition/Web_V3/css/top-4.4.min.css">
    <link rel="stylesheet" type="text/css" href="/2016-06-21_usgame_competition/Web_V3/css/contest.info-4.3.min.css">
    <link rel="stylesheet" type="text/css" href="/2016-06-21_usgame_competition/Web_V3/css/monokai_sublime.min.css">
     <script type="text/javascript" src="/2016-06-21_usgame_competition/common/jquery-1.11.1.min.js"></script>
    <script type="text/javascript" src="/2016-06-21_usgame_competition/Web_V3/js/common.js"></script>
    <script type="text/javascript" src="camp_details.js"></script>
</head>
<body>
<!--body-wrap-->
<div class="body-wrap">
    <div class="body-main main-wrap v-4-2" >
    	<jsp:include page="../common/head.jsp"></jsp:include>
        
<style type="text/css">.text-body p a{color:#22bfa7;}.text-body h1,.text-body h2,.text-body h3{padding:0}</style>
<!-- publicTop位置 -->
<style>
    .nav{position:static;}
    .mtv-pop-box .item:nth-child(even){padding-left:0}
    .sk-event4-1-detail-banner-con .para{max-width:90%;margin:0 auto}
</style>
<div class="sk-event4-1-detail-banner" style="margin-top:50px;">
    <!-- <img src="http://publicqn.saikr.com/6b73f5c6767174bc1f9ecd34d33ca2340.2358450696337968.jpg" alt="2017年美国大学生数学建模竞赛（大连理工大学）" class="sk-event4-1-detail-img">
    <div class="sk-event4-1-detail-banner-con">
            <div class="sk-event4-1-detail-banner-min">
            <h1 class="banner-title" title="2017年美国大学生数学建模竞赛（大连理工大学）">2017年美国大学生数学建模竞赛（大连理工大学）</h1>
            <p class="para">主办方：<span>美国数学及其应用联合会</span></p>
                    <p class="para">报名时间：<span>2016.11.20 07:00——2016.12.15 22:00</span></p>
            <p class="para">比赛时间：<span>2017.01.20 06:00——2017.01.24 09:00</span></p>
        </div>
            </div> -->
</div>
<div class="sk-event-detail-nav" id="eventDetailNav">
    <div class="sk-event-detail-nav-main">
        <a href="" class="item active"><i class="common-icon-big detail-icon"></i>营地详情</a>
        <!-- <a href="/c/comment/33953" class="item "><i class="common-icon-big discuss-icon"></i>讨论区</a> -->
        <a href="" class="item "><i class="common-icon-big inform-icon"></i>通知公告</a>
    </div>
</div>
<script src="http://cdn3.saikr.com/MathJax-master/MathJax.js?config=TeX-AMS_HTML"></script>
<div class="sk-event4-1-box event4-1-detail clearfix">
    <div class="sidebar-a fl" id="eventDetailBox">
        <div class="event4-1-detail-box event4-1-brief-box">
            <div class="title-box">
               <h3 class="title">营地简介</h3>
            </div>
            <div class="event4-1-detail-text-box event4-1-brief-text-box text-body">
                <p class="para">营地名字：<span id="campName"></span></p>
                <p class="para">营地地址：<span id="campAddress"></span></p>
                <p class="para">参加人员年龄限定：<span id="campAge"></span></p>
                <p class="para">营地特色：<span id="campFeatures"></span></p>
                <p class="para">营地介绍：<span id="campInfo"></span></p>
                
            </div>
        </div>
        
        
        <div class="event4-1-detail-box event4-1-brief-box">
            <div class="title-box">
               <h3 class="title">营地费用</h3>
            </div>
            <div class="event4-1-detail-text-box text-body clearfix">
            <p class="para">报名费用：<span id="campMoney"></span></p>
            <p class="para">费用说明：<span id="moneyInfo"></span></p>
            </div>
        </div>
        
        
        <div class="event4-1-detail-box">
            <div class="title-box">
               <h3 class="title">报名须知</h3>
            </div>
            <div class="event4-1-detail-text-box text-body clearfix">
            <p class="para">日程安排：<span id="campSchedule"></span></p>
            <p class="para">报名须知：<span id="applyInfo"></span></p>
            <p class="para">注意事项：<span id="attentionInfo"></span></p>
            </div>
        </div>
            
    </div>
    <!-- 右边栏位置 -->
    <div class="sidebar-b fr" id="eventSideBar">
    <div class="sidebar-b-con m-10">
        <div class="event4-1-detail-btn-box clearfix">
            <!-- <a href="javascript:;" class="sk-btn sk-btn-green fr">我要报名</a> -->
                             <!-- 如果可以报名 -->
                                        <a class="fr sk-btn sk-btn-green" href="javascript:camp_apply()">立即报名</a>
                                                

                            <!-- <a class="fr sk-btn sk-btn-green link-btn" href="/<?//php echo $contest['parent_url']?>"><?//php echo $contest['parent_branch_name']?>入口</a> -->
                                <a class="sk-btn sk-btn-orange js_new_event_follow_btn"  id="add" style="display:none" href="javascript:payAttention()">添加关注</a>
                                <a class="sk-btn sk-btn-orange js_new_event_follow_btn"  id="yet" style="display:none" href="javascript:delectAttention()">已关注</a>
                </div>
    </div>
    
    <div class="sidebar-b-con">
        <div class="title-box">
           <h3 class="title">报名信息</h3>
        </div>
        <div class="new-event4-1-box">
            <ul class="new-event4-1-list">
                <li class="new-event4-1-info-item clearfix">
                    <span class="info-name fl">营地名称：</span>
                    <span class="info-content fl" id="campName1"></span> 
                </li>
                 <li class="new-event4-1-info-item clearfix">
                    <span class="info-name fl">报名时间：</span>
                    <div class="info-content fl">
                       <p class="date-start" id="date-start"></p>
                       <p class="date-end" id="date-end"></p>
                    </div>
                </li>
                <li class="new-event4-1-info-item clearfix">
                    <span class="info-name fl">出发时间：</span>
                    <div class="info-content fl">
                       <p class="date-start" id="camp_goTime"></p>
                    </div>
                </li>
                <li class="new-event4-1-info-item clearfix">
                    <span class="info-name fl">报名状态：</span>
                    <div class="info-content fl">
                       <p class="date-start" id="campstate"></p>
                       <p class="date-end" id="date-end"></p>
                    </div>
                </li>
            </ul>
        </div>
    </div>
</div>


</div>
 </div>
</div>	
<jsp:include page="../common/end.jsp"></jsp:include>
</body>
</html>