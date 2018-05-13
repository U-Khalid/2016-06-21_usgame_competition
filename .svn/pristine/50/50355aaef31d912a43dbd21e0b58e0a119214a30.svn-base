<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<taglib uri="http://java.sun.com /jsp/jstl/core" prefix="c" /> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>个人帐号注册-资优少年</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta http-equiv="Access-Control-Allow-Origin" content="*">
    <meta name="renderer" content="webkit">
   <!--  <link rel="Shortcut Icon" href="/2016-06-21_usgame_competition/images/main/favicon.ico">
    <link rel="apple-touch-icon-precomposed" href="/2016-06-21_usgame_competition/images/main/sk_mobile_icon57x57.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="/2016-06-21_usgame_competition/images/main/sk_mobile_icon72x72.png">ipad图标尺寸72x72
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="/2016-06-21_usgame_competition/images/main/sk_mobile_icon114x114.png">对应retina屏的iPhone及iTouch图标尺寸114x114 -->
    <link rel="stylesheet" type="text/css" href="/2016-06-21_usgame_competition/Web_V3/css/top-4.4.min.css">
    <link rel="stylesheet" type="text/css" href="/2016-06-21_usgame_competition/Web_V3/css/lgr-4.3.min.css">
    <script type="text/javascript" src="/2016-06-21_usgame_competition/Web_V3/reg/reg.js"></script>
    <script type="text/javascript" src="/2016-06-21_usgame_competition/common/jquery-1.11.1.min.js"></script>
    

</head>

<body>
<!--body-wrap-->
<div class="body-wrap">
    <div class="body-main main-wrap v-4-2">
        <jsp:include page="/Web_V3/common/head.jsp"></jsp:include>
        <div class="lgr-box clearfix">
            <div class="lgr-tab-nav">
                <div class="item active">
                    注册个人账号
                </div>
            </div>
            <form method="post" action="/2016-06-21_usgame_competition/UserServlet?method=Web_register" class="fl lgr-left-con" id="perRegForm" novalidate="novalidate">
                <div class="common-form-line">
                    <div class="common-input">
						<c:if test="${ not empty phone }">
                        <input type="text" name="regname" id="regname" placeholder="请输入注册手机号" value="${phone}">
						</c:if>
						<c:if test="${empty phone }">
                        <input type="text" name="regname" id="regname" placeholder="请输入注册手机号"  >
						</c:if>
                    </div>
                </div>
                <div class="common-form-line">
                    <div class="common-input">
						<c:if test="${ not empty pw }">
                        <input type="password" name="regpass" id="regpass"  value="${pw}" placeholder="请输入密码" class="js_view_pass"  >
						</c:if>
						<c:if test="${empty pw }">
						<input type="password" name="regpass" id="regpass"  placeholder="请输入密码" class="js_view_pass"  >						
                        </c:if>
                        <i class="common-icon lgr-view-pass-btn js_view_pass_btn" onclick="showPasswd()"></i>
                    </div>
                </div>
                <div class="common-form-line clearfix">
                    <div class="fl common-input lgr-reset-code-input">
                        <input type="text" name="regcode" id="regcode" placeholder="请输入手机短信验证码" >
                    </div>

                    <div class="fl sk-btn sk-btn-green lgr-send-code-btn" id="getCodeBtn" onclick="getTest()" style="float:left;width:85px;margin-top:-46px;margin-left:235px;">
                        &nbsp;获取验证码
                    </div>
                    <span class="lgr-code-tip-wrap js_error_wrap"></span>
                </div>
                <div class="lgr-check-box " style="color: #EE2C2C">
                   <% 
                		String message = (String)request.getAttribute("message");
						if(message==null||message.equals(null)){
							out.print("");
						}
						else{
							out.print(message);
						}
						%> 
     
                </div>
                <div class="lgr-btn-box">
                    <input type="submit" value="注册" class="sk-btn sk-btn-green" id="regSubBtn">
                </div>
                <div class="lgr-link-box">
                    已有资优账号？<span class="lgr-link"><a href="/2016-06-21_usgame_competition/Web_V3/login/login.jsp">直接登录</a><i class="common-icon"></i></span>
                </div>
            </form>
            <!-- <div class="fr lgr-right-con">
                <div class="lgr-kindly-reminder">
                    <h2 class="title common-after-icon">温馨提示</h2>
                    <dl>
                        <dt>1、竞赛报名；</dt>
                    </dl>
                    <dl>
                        <dt>2、发布/报名活动；</dt>
                    </dl>
                    <dl>
                        <dt>3、提问回答、发表/打赏文章；</dt>
                    </dl>
                    <dl>
                        <dt>4、下载APP随时随地报名！</dt>
                    </dl>
                </div>
                <div class="lgr-app-download-icon"></div>
 
            </div> -->
        </div>
 </div>
</div>

<jsp:include page="/Web_V3/common/end.jsp"></jsp:include>

</body>

</html>