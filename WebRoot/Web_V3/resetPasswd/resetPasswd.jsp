<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>resetPasswd</title>
<link rel="stylesheet" type="text/css" href="/2016-06-21_usgame_competition/Web_V3/css/top-4.4.min.css">
<link rel="stylesheet" type="text/css" href="/2016-06-21_usgame_competition/Web_V3/css/lgr-4.3.min.css">
<script type="text/javascript" src="/2016-06-21_usgame_competition/common/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="/2016-06-21_usgame_competition/Web_V3/resetPasswd/resetPasswd.js""></script>
</head>
<body>
<!--body-wrap-->
<div class="body-wrap">
    <div class="body-main main-wrap v-4-2">
        <jsp:include page="../common/head.jsp"></jsp:include>
        <div class="lgr-box clearfix">
            <div class="lgr-tab-nav">
                <div class="item active">找回密码</div>
            </div>
            <form action="/resetPasswd" class="fl lgr-left-con" id="findPwForm" novalidate="novalidate">
                <div class="common-form-line">
                    <div class="common-input">
                        <input type="text" name="regname" id="regname" placeholder="请输入注册手机号" data-rule-required="true"  data-rule-contact="true" aria-required="true">
                    </div>
                </div>
               
                <div class="common-form-line clearfix">
                    <div class="fl common-input lgr-reset-code-input">
                        <input type="text" name="regcode" id="regcode" placeholder="请输入手机短信验证码" data-rule-required="true"  data-rule-islegalcharacter="true" aria-required="true">
                    </div>
                    <div class="fl sk-btn sk-btn-green lgr-send-code-btn" id="getCodeBtn" action-url="/user/reset_rand_code" style="float:left;width:80px;margin-top:-46px;margin-left:230px;">
                        获取验证码
                    </div>
                    <span class="lgr-code-tip-wrap js_error_wrap"></span>
                </div>
                <div class="common-form-line">
                    <div class="common-input">
                        <input type="password" name="regpass" id="regpass" placeholder="请输入新密码" class="js_view_pass" data-rule-required="true" data-msg-required="请输入新密码" data-rule-islegalcharacter="true" data-rule-regexpassword="true" data-msg-regexpassword="密码至少包含数字和字母" data-rule-minlength="6" data-msg-minlength="密码长度至少为6位" aria-required="true">
                        <i class="common-icon lgr-view-pass-btn js_view_pass_btn"  onclick="showPasswd()" ></i>
                    </div>
                </div>
                <div class="lgr-check-box"></div>
                <div class="lgr-btn-box">
                    <input type="submit" value="完 成" class="sk-btn sk-btn-green">
                </div>
                <div class="lgr-link-box">
                    还没有账号？<span class="lgr-link"><a href="../reg/reg.jsp">立即注册</a><i class="common-icon"></i></span>
                </div>
            </form>
           <!--  <div class="fr lgr-right-con">
                <div class="lgr-kindly-reminder">
                    <h2 class="title common-after-icon">温馨提示</h2>
                    <dl>
                        <dt>1、组织者账号</dt>
                        <dd>创建、编辑竞赛；</dd>
                        <dd>审核、管理参赛者；</dd>
                    </dl>
                    <dl>
                        <dt>2、个人账号</dt>
                        <dd>报名竞赛；</dd>
                        <dd>报名、发布及管理活动；</dd>
                        <dd>发起及管理话题；</dd>
                        <dd>发布及管理文章。</dd>
                    </dl>
                </div>
                <div class="lgr-app-download-icon"></div>
                
            </div> -->
        </div>

 </div>
</div>
<jsp:include page="../common/end.jsp"></jsp:include>
</body>
</html>