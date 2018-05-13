<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>支付页面</title>
 <link rel="stylesheet" type="text/css" href="/2016-06-21_usgame_competition/Web_V3/css/top-4.4.min.css">
    <link rel="stylesheet" type="text/css" href="/2016-06-21_usgame_competition/Web_V3/css/contest.info-4.3.min.css">
    <link rel="stylesheet" type="text/css" href="/2016-06-21_usgame_competition/Web_V3/css/contest.apply-4.4.min.css">
    <link rel="stylesheet" type="text/css" href="/2016-06-21_usgame_competition/Web_V3/css/monokai_sublime.min.css">
<script type="text/javascript" src="../../common/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="/2016-06-21_usgame_competition/common/jquery.qrcode.min.js"></script>
<script type="text/javascript" src="/2016-06-21_usgame_competition/Web_V3/js/common.js"></script>
<script type="text/javascript" src="Webpay.js"></script>
<style type="text/css">
.wetop {
	margin-top: 80px;
	background-color: #F2F2F2;
	border-top:1px solid #CCCCCC;
	border-bottom:1px solid #CCCCCC;
	min-width: 1400px;
	max-width: 1920px;
	height: 100px;
	line-height: 100px;
}
.nicai {
	margin: 0 auto;
	margin-top:30px;
	height: 40px;
	width: 1000px;
	border:1px solid #CCCCCC;
	line-height: 40px;
}
.paycenter {
	margin: 0 auto;
	margin-top:30px;
	width: 260px;
}
.pic {
	margin-left:10px;
	height: 30px;
}
.tuijian {
	margin-left:10px;
	height: 20px;
}
.moneycolor {
  color:#FF6600;
}
.dingdan{
  margin-left: 350px;
  
}
.paymoney {
  margin-left: 450px;
}

</style>
</head>
<body>
<div class="body-wrap">
    <div class="body-main main-wrap v-4-2">
       <jsp:include page="../common/head.jsp"></jsp:include>
        <div class="wetop">
       <span class="dingdan"><span style="font-size: 20px;">订单编号：</span><span id="dingdan" style="font-size: 15px;style="font-size: 20px;></span></span>
       <span class="paymoney"><span style="font-size: 20px;">应付金额 ：￥</span><span id="paymoney" style="font-size: 15px;"></span></span>
       
       </div>
       <div class="nicai">
       <span>&nbsp; &nbsp; &nbsp;支付宝、微信</span>
      <!--  <img  class="pic" alt="微信支付" src="/2016-06-21_usgame_competition/images/WePay/WePayLogo.png">  -->
       <img class= "tuijian" alt="" src="/2016-06-21_usgame_competition/images/WePay/按钮标签.png">
       <span style="margin-left: 20px;"> 亿万用户的选择，更快更安全</span>
       <span style="margin-left: 430px;"> 支付 </span><span class="moneycolor"></span> <span>元</span>
       </div>
	 <div id = "qrcodeid" class="paycenter" ></div> 
	
	<div class="paycenter" style="margin-top:20px;">
	<img alt="" src="/2016-06-21_usgame_competition/images/WePay/captions.png">
	</div>
	<div style="height:20px"></div>
	</div>
</div>
<jsp:include page="../common/end.jsp"></jsp:include>
</body>
</html>