<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>确认报名信息</title>
 <link rel="stylesheet" type="text/css" href="/2016-06-21_usgame_competition/Web_V3/css/top-4.4.min.css">
    <link rel="stylesheet" type="text/css" href="/2016-06-21_usgame_competition/Web_V3/css/contest.info-4.3.min.css">
    <link rel="stylesheet" type="text/css" href="/2016-06-21_usgame_competition/Web_V3/css/contest.apply-4.4.min.css">
    <link rel="stylesheet" type="text/css" href="/2016-06-21_usgame_competition/Web_V3/css/monokai_sublime.min.css">
<script type="text/javascript" src="../../common/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="/2016-06-21_usgame_competition/Web_V3/js/common.js"></script>
<script src="http://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>
<script type="text/javascript" src="confirmApply.js"></script>
</head>
<body>
<!--body-wrap-->
<div class="body-wrap">
    <div class="body-main main-wrap v-4-2">
       <jsp:include page="../common/head.jsp"></jsp:include>
<!-- content -->
<!-- content -->
        <div class="first-title-box" id="comName">
           <!-- <h1 class="first-title" title="2017年全国大学生英语竞赛天津赛区天津科技大学分赛区"><a href="http://www.saikr.com/neccs/tust/2017" target="_blank">2017年全国大学生英语竞赛天津赛区天津科技大学分赛区</a></h1>
         --></div>
        <div class="common-box sk-event-box">
            <div class="sk-contest-apply-title">报名信息</div>
            <div class="team-view-tb-box m-0 clearfix">
					<div class="fl list-table">
						报名编号：<span id="out_trade_no"></span>
					</div>

					<div class="fl list-table">
						姓名： <span id="name">  </span>
					</div>
					<div class="fl list-table">
						学校： <span id="school"> </span>
					</div>
					<div class="fl list-table">
						年级： <span id="grade"> </span>
					</div>
					<div class="fl list-table">
						身份证号： <span id="idCard">  </span>
					</div>
					
					<div class="fl list-table">
						参赛年级： <span id="competitionGrade">  </span>
					</div>
					<div class="fl list-table">
						参赛科目： <span id="competitionSubject">  </span>
					</div>
					<div class="fl list-table">
						联系人： <span id="contectName">  </span>
					</div>
					<div class="fl list-table">
						联系电话： <span id="contectPhone">  </span>
					</div>
					
					

				</div>
                        <div class="sk-contest-pay-info-box">
                需要交纳报名费：<span class="count">¥30.00</span><span class="tip">注：目前支付方式仅支持<span class="pay-way">微信</span>付款</span>
            </div>
                                    
            <div class="c-v-btn-box v-4-4 tac clearfix">
                <div class="c-v-btn-tip">
                    注：请认真核对以上报名信息，如有错误，<a href="javascript:backapplyInfo();">请点击此处</a>返回修改
                </div>

                <a href="javascript:backapplyInfo();" class="sk-btn v-4-4">返回上一步</a>
                <span class="sk-btn sk-btn-green v-4-4" id="confirmApplyBtn" onclick="topay()">
                    立即支付                </span>
                <!-- <span class="sk-btn sk-btn-grey fr v-4-4" id="cancelApplyBtn" action-url="/ce/ajaxce" action-data='{"team_id":"119266"}'>
                    取消报名
                </span> -->
            </div>
            <!-- 确认报名提示 -->
            <div id="confirmApplyMessage" style="display:none">确认后所有报名信息都将无法修改，确认要提交吗？</div>
                
                        <div class="tac" style="margin-top:-100px; margin-bottom: 100px;">
               <!--  <div style="margin-top:30px">
                    本竞赛最终解释权归全国大学生英语竞赛组委会所有<br>
                    咨询竞赛报名相关事宜请联系刘军老师<br>
                    电 话：010-88375225；88375849<br>
                    电子信箱：neccs@tefl-china.net
                </div> -->
            </div>
        </div>
<!-- 支付提示弹窗 -->
<div id="payMessageBox" class="pop-box pop-modal prompt-box v-4-3 js_pop_modal">
    <div class="pop-box-tit">
        温馨提示
    </div>
    <div class="prompt-con">
        <p class="prompt-txt">请在新打开的页面完成支付！</p>
        <div class="prompt-btn-box clearfix">
            <a class="fr sk-btn sk-btn-green prompt-btn" href="javascript:location.reload();">支付成功</a>
            <a class="fr sk-btn sk-btn-white prompt-btn" href="http://dev.saikr.com/feedback">遇到问题</a>
        </div>
    </div>
</div>
<div class="lg-mask" id="popMask"></div>
<div class="lg-error-box v-4-3 js_pop_modal" id="ajaxMessageBox">
    <div class="lg-error-icon"></div>
    <div class="lg-error-header">
        信息提示
        <i class="common-icon lg-error-close js_pop_close"></i>
    </div>
    <div class="lg-error-con" id="ajaxMessage">
    </div>
</div>
<div id="promptMessageBox" class="pop-box pop-modal prompt-box v-4-3 js_pop_modal">
    <div class="pop-box-tit" id="promptMessageTitle">
        温馨提示
    </div>
    <div class="prompt-con">
        <p class="prompt-txt" id="promptMessage"></p>
        <div class="prompt-btn-box clearfix">
            <a class="fr sk-btn sk-btn-green prompt-btn" href="javascript:;" id="promptConfirmBtn">确认</a>
            <a class="fr sk-btn sk-btn-white prompt-btn js_pop_close" href="javascript:;">取消</a>
        </div>
    </div>
</div>
 </div>
</div>





<div class="lg-mask" id="popMask"></div>
<div class="lg-error-box v-4-3 v-4-6 js_pop_modal" id="ajaxMessageBox">
    <div class="lg-error-icon"></div>
    <div class="lg-error-header">
        信息提示
        <i class="common-icon lg-error-close js_pop_close"></i>
    </div>
    <div class="lg-error-con" id="ajaxMessage">
    </div>
</div>
<div id="promptMessageBox" class="pop-box pop-modal prompt-box v-4-3 js_pop_modal">
    <div class="pop-box-tit" id="promptMessageTitle">
        温馨提示
    </div>
    <div class="prompt-con">
        <p class="prompt-txt" id="promptMessage"></p>
        <div class="prompt-btn-box clearfix">
            <a class="fr common-before-icon v-4-6 sk-btn-arrow right big" href="javascript:queren();" id="promptConfirmBtn">确认</a>
            <a class="fr common-before-icon v-4-6 sk-btn-arrow left js_pop_close" href="javascript:;">取消</a>
        </div>
    </div>
</div>

 <jsp:include page="../common/end.jsp"></jsp:include>
</body>
</html>