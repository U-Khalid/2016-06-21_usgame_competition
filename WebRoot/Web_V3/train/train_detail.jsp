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
	<script type="text/javascript" src="./train_detail.js"></script>

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
    <img src="http://publicqn.saikr.com/6b73f5c6767174bc1f9ecd34d33ca2340.2358450696337968.jpg" alt="2017年美国大学生数学建模竞赛（大连理工大学）" class="sk-event4-1-detail-img">
    <div class="sk-event4-1-detail-banner-con">
            <div class="sk-event4-1-detail-banner-min" id="">
            <h1 class="banner-title"  id="trainName"></h1>
            <p class="para">培训机构：<span id="trainSupportDesc"></span></p>
                    <p class="para">报名时间：<span id="date_b_e"></span></p>

        </div>
            </div>
</div>
<div class="sk-event-detail-nav" id="eventDetailNav">
    <div class="sk-event-detail-nav-main">
        <a href="javascript:;" onclick="getInfo()" class="item active"><i class="common-icon-big detail-icon"></i>培训详情</a>
        <a href="javascript:;" onclick="toblank(this)" class="item "><i class="common-icon-big discuss-icon"></i>讨论区</a>
        <a href="javascript:;" onclick="toblank(this)" class="item "><i class="common-icon-big inform-icon"></i>通知公告</a>
    </div>
</div>
<div class="sk-event4-1-box event4-1-detail clearfix" id="region">
  <div class="event4-1-detail-text-box event4-1-brief-text-box text-body" style="font-size:24px" id="others">
	<p>正在开发中，敬请期待！</p>
  </div>
  <div id="sign">
    <div class="sidebar-a fl" id="eventDetailBox">
        <div class="event4-1-detail-box event4-1-brief-box">
            <div class="title-box">
               <h3 class="title">培训简介</h3>
            </div>
            <div class="event4-1-detail-text-box event4-1-brief-text-box text-body">
            	<p class="para">培训名字：<span id="trainName1"></span></p>
            	<p class="para">培训科目：<span id="trainCourse"></span></p>
               <p class="para">参加人员描述：<span id="trainJoinerDes"></span></p>
               <p class="para">培训时间：<span id="date-start"></span></p>
               <p class="para">培训地点：<span id="trainTestAddress"></span></p>
               <p class="para">培训报名地址：<span id="trainApplyAddress"></span></p>
            </div>
        </div>
                
        <div class="event4-1-detail-box">
            <div class="title-box">
               <h3 class="title">教师详情</h3>
            </div>
            <div class="event4-1-detail-text-box text-body clearfix" id="teacher_details">
           	 <div class="event4-1-detail-text-box event4-1-brief-text-box text-body" >
            	<select id="teacher_Candidates" style="font-size:24px;width:150px;">
            	</select>
            	<p></p>
          		<p class="para">教师详情：<span id="teacherDetail"></span></p>
          		<p class="para">培训价格：<span id="teacherPrice" style="font_size:20px"></span></p>
           		 </div>
            </div>
        </div>
        
        <div class="event4-1-detail-box">
            <div class="title-box">
               <h3 class="title">培训详情</h3>
            </div>
            <div class="event4-1-detail-text-box text-body clearfix" id="train_details">
            

            </div>
        </div>
        
        <div class="event4-1-detail-box">
            <div class="title-box">
               <h3 class="title">主办方详情</h3>
            </div>
            <div class="event4-1-detail-text-box text-body clearfix" id="trainMechanical_details">
            

            </div>
        </div>
        
        
    </div>
    <!-- 右边栏位置 -->
    <div class="sidebar-b fr" id="eventSideBar">
    <div class="sidebar-b-con m-10">
        <div class="event4-1-detail-btn-box clearfix">
            <!-- <a href="javascript:;" class="sk-btn sk-btn-green fr">我要报名</a> -->
                             <!-- 如果可以报名 -->
                                        <a class="fr sk-btn sk-btn-green" href="javascript:;" onclick="toEnroll()">立即报名</a>
                                                

                            <!-- <a class="fr sk-btn sk-btn-green link-btn" href="/<?//php echo $contest['parent_url']?>"><?//php echo $contest['parent_branch_name']?>入口</a> -->
                                <a class="sk-btn sk-btn-orange js_new_event_follow_btn"  id="add" style="display:none" href="javascript:payAttention()">添加关注</a>
                                 <a class="sk-btn sk-btn-orange js_new_event_follow_btn"  id="yet" style="display:none" href="javascript:delectAttention()">已关注</a>
                </div>
    </div>
  
    <div class="sidebar-b-con">
        <div class="title-box">
           <h3 class="title">培训信息</h3>
        </div>
        <div class="new-event4-1-box">
            <ul class="new-event4-1-list">
            	
                <li class="new-event4-1-info-item clearfix">
                    <span class="info-name fl">培训科目：</span>
                    <p class="info-content fl" id="trainSubject">
                       
                    </p>
                </li>
                <li class="new-event4-1-info-item clearfix">
                    <span class="info-name fl">周培训次数：</span>
                    <p class="info-content fl" id="trainType">
                       
                    </p>
                </li>
                <li class="new-event4-1-info-item clearfix">
                    <span class="info-name fl">培训形式：</span>
                    <p class="info-content fl" id="trainForm">
                       
                    </p>
                </li>
                
                <li class="new-event4-1-info-item clearfix">
                    <span class="info-name fl">培训时间：</span>
                    <div class="info-content fl">
                       <p class="date-start" id="date-start1"> </p>
                       <p class="date-end" id="date-end1"></p>
                    </div>
                </li>
               
                <li class="new-event4-1-info-item clearfix">
                    <span class="info-name fl">培训状态：</span>
                    <p class="info-content fl" id="trainState">
                       
                    </p>
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