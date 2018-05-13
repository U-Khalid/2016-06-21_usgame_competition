<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>个人信息</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta http-equiv="Access-Control-Allow-Origin" content="*">
    <meta name="renderer" content="webkit">
   	<link rel="Shortcut Icon" href="/2016-06-21_usgame_competition/images/main/favicon.ico">
    <link rel="apple-touch-icon-precomposed" href="/2016-06-21_usgame_competition/images/main/sk_mobile_icon57x57.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="/2016-06-21_usgame_competition/images/main/sk_mobile_icon72x72.png"><!-- ipad图标尺寸72x72-->
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="/2016-06-21_usgame_competition/images/main/sk_mobile_icon114x114.png"><!-- 对应retina屏的iPhone及iTouch图标尺寸114x114 -->
    <link rel="stylesheet" type="text/css" href="/2016-06-21_usgame_competition/Web_V3/css/top-4.4.min.css">
    <link rel="stylesheet" type="text/css" href="/2016-06-21_usgame_competition/Web_V3/css/event4.1.min.css">
    <link rel="stylesheet" type="text/css" href="/2016-06-21_usgame_competition/Web_V3/css/homepage-4.5.min.css">
    <script type="text/javascript" src="/2016-06-21_usgame_competition/common/jquery-1.11.1.min.js"></script>
    <script type="text/javascript" src="/2016-06-21_usgame_competition/Web_V3/User/user.js"></script>
    <script type="text/javascript" src="/2016-06-21_usgame_competition/Web_V3/js/common.js"></script>
    <script type="text/javascript" src="userMain.js"></script>

    
</head>
<body>
<!--body-wrap-->
<div class="body-wrap">
    <div class="body-main main-wrap v-4-2">
        <jsp:include page="../common/head.jsp"></jsp:include>
<!-- 个人中心头部碎片文件 -->
<div class="sk-cp-event-banner">
    <div class="sk-cp-event-banner-box cp-per-box">
        <div class="sk-pw-fans-info-con">
            
        </div>
    </div>
</div>
<div class="cp-contain-box clearfix">
    <div class="cp-per-info-box clearfix">
                <!-- 本人可见 -->
        <div class="position-box r-t new show">
            <div class="cp-head-btn-box">
                <a href="userInfo.jsp" class="sk-btn follow">
                    <i class="common-icon edit-icon"></i>账号设置
                </a>
                <!-- <div class="sk-btn sk-btn-green hp-add-new-btn">
                    <i class="common-icon add-new-icon"></i>发布
                    <div class="list">
                        <a href="/act/publish" class="item">发布活动</a>
                        <a href="/t/publish" class="item">发起提问</a>
                        <a href="/a/publish" class="item">发表文章</a>
                    </div>
                </div> -->
            </div>
        </div>
                <!-- 用户信息 -->
        <div class="cp-head-queue-info">
            <div class="cp-head-por-card-box">
    
                   <a href="userInfo.jsp" title="" class="cp-head-por">
                        <img src="/2016-06-21_usgame_competition/images/main/15.jpg" > 
                    </a>
     
            <!-- 个人名片 END -->
            </div>
            <div class="cp-per-info-para-box new">
                <p class="para tit" id="name" ></p>     <!-- 姓名 -->
                <!-- <p class="para para mo-para" id="sex"></p>     性别 -->
                <p class="para para mo-para" id="school"></p>     		<!-- 学校 -->
                
                <!-- <p class="para para mo-para" id="grade"></p>     		年级
                <p class="para para mo-para" id="contactNumber"></p>     联系电话
                <p class="para para mo-para" id="address"></p>     		地址 -->
                </p>
                
            </div>
        </div>
    </div>
</div>
<!-- nav -->
<div class="sk-hp-nav clearfix">
    <a href="javascript:toUserCompetition()" class="item active" id="usercompetition">
        <i class="common-icon-big contest-icon"></i>竞赛
    </a>
    <a href="javascript:toUserCamp()" class="item " id="usercamp">
        <i class="common-icon-big active-icon"></i>营地
    </a>
    <a href="javascript:toUserTrain()" class="item " id="usertrain">
        <i class="common-icon-big topic-icon"></i>培训
    </a>
    
</div>
<div class="sk-hp-sub-nav" id="competitionInfo">
    <span class="item active" id="payCompetition">
        <a href="javascript:showCompetitionInfo()">我报名的竞赛</a>（<em id="comApplyCount"></em>）
    </span>
    <span class="item " id="AttentionCompetition">
        <a href="javascript:showAttentionCompetition()">我关注的竞赛</a>（<em id="comAttentionCount"></em>）
    </span>
</div>

<div class="sk-hp-sub-nav" id="campInfo">
    <span class="item active" id="payCamp">
        <a href="javascript:showCampInfo()">我报名的营地</a>（<em id="campApplyCount"></em>）
    </span>
    <span class="item " id="AttentionCamp" >
        <a href="javascript:showAttentionCamp()">我关注的营地</a>（<em id="campAttentionCount"></em>）
    </span>
</div> 

<div class="sk-hp-sub-nav" id="trainInfo" >
    <span class="item active" id="payTrain">
        <a href="javascript:showTrainInfo()">我报名的培训</a>（<em id="trainApplyCount"></em>）
    </span>
    <span class="item " id="AttentionTrain">
        <a href="javascript:showAttentionTrain()">我关注的培训</a>（<em id="trainAttentionCount"></em>）
    </span>
</div> 


<!-- 竞赛 -->
<div class="sk-compet4-1-list-box sk-hp-content-box"  id="competitionbox">
    <div class="event4-1-list-box">
        <ul class="list">
						
		</ul>
    </div>
    <div class="event4-1-list-box">
        <ul class="Attentionlist" style="display: none">
						
		</ul>
    </div>
</div>


<!-- 营地 -->
<div class="sk-compet4-1-list-box sk-hp-content-box" id="campbox" style="display: none">
    <div class="event4-1-list-box">
        <ul class="listcamp"  style="display: none">
						
		</ul>
    </div>
    <div class="event4-1-list-box">
        <ul class="Attentionlistcamp" style="display: none">
						
		</ul>
    </div>
</div>


<!-- 培训 -->
<div class="sk-compet4-1-list-box sk-hp-content-box" style="display: none" id="trainbox">
    <div class="event4-1-list-box">
        <ul class="listtrain">
						
		</ul>
    </div>
    <div class="event4-1-list-box">
        <ul class="Attentionlisttrain" style="display: none">
						
		</ul>
    </div>
</div>
 </div>
</div>

<div id="promptMessageBox" class="pop-box pop-modal prompt-box v-4-3 js_pop_modal">
    <div class="pop-box-tit" id="promptMessageTitle">
        温馨提示
    </div>
    <div class="prompt-con">
        <p class="prompt-txt" id="promptMessage">确定取消报名吗？</p>
        <div class="prompt-btn-box clearfix">
            <a class="fr sk-btn sk-btn-green prompt-btn" href="javascript:deleteorder();" id="promptConfirmBtn">确认</a>
            <a class="fr sk-btn sk-btn-white prompt-btn js_pop_close" href="javascript:hidedialog();">取消</a>
        </div>
    </div>
</div>
<div id="alertBox" class="pop-box pop-modal prompt-box v-4-3 js_pop_modal">
	<div class="pop-box-bit" id="alertMessageTitle">
	温馨提示
	</div>
	<div class="prompt-con">
		<p class="prompt-txt" id="alertMessage"></p>
		<div class="prompt-btn-box clearfix">
			<a class="fr sk-btn sk-btn-green prompt-btn" href="javascript:reload(); id="promptConfirmBtn">确认</a>
		</div>
	</div>
</div>

<div id="promptMessageBoxcamp" class="pop-box pop-modal prompt-box v-4-3 js_pop_modal">
    <div class="pop-box-tit" id="promptMessageTitle">
        温馨提示
    </div>
    <div class="prompt-con">
        <p class="prompt-txt" id="promptMessage">确定取消报名吗？</p>
        <div class="prompt-btn-box clearfix">
            <a class="fr sk-btn sk-btn-green prompt-btn" href="javascript:deleteordercamp();" id="promptConfirmBtn">确认</a>
            <a class="fr sk-btn sk-btn-white prompt-btn js_pop_close" href="javascript:hidedialogcamp();">取消</a>
        </div>
    </div>
</div>


<div id="promptMessageBoxtrain" class="pop-box pop-modal prompt-box v-4-3 js_pop_modal">
    <div class="pop-box-tit" id="promptMessageTitle">
        温馨提示
    </div>
    <div class="prompt-con">
        <p class="prompt-txt" id="promptMessage">确定取消报名吗？</p>
        <div class="prompt-btn-box clearfix">
            <a class="fr sk-btn sk-btn-green prompt-btn" href="javascript:deleteordertrain();" id="promptConfirmBtn">确认</a>
            <a class="fr sk-btn sk-btn-white prompt-btn js_pop_close" href="javascript:hidedialogtrain();">取消</a>
        </div>
    </div>
</div>


<div id="alertBox" class="pop-box pop-modal prompt-box v-4-3 js_pop_modal">
    <div class="pop-box-tit" id="alertMessageTitle">
        温馨提示
    </div>
    <div class="prompt-con">
        <p class="prompt-txt" id="alertMessage"></p>
        <div class="prompt-btn-box clearfix">
            <a class="fr sk-btn sk-btn-green prompt-btn" href="javascript:reload();" id="promptConfirmBtn">确认</a>
        </div>
    </div>
</div>
<jsp:include page="../common/end.jsp"></jsp:include>
</body>
</html>