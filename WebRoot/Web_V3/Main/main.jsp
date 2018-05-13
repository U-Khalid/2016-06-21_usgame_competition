<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>资优少年</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta http-equiv="Access-Control-Allow-Origin" content="*">
<meta name="renderer" content="webkit">
<!--  <link rel="Shortcut Icon" href="/2016-06-21_usgame_competition/images/main/favicon.ico">
    <link rel="apple-touch-icon-precomposed" href="/2016-06-21_usgame_competition/images/main/sk_mobile_icon57x57.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="/2016-06-21_usgame_competition/images/main/sk_mobile_icon72x72.png">ipad图标尺寸72x72
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="/2016-06-21_usgame_competition/images/main/sk_mobile_icon114x114.png">对应retina屏的iPhone及iTouch图标尺寸114x114-->
<link rel="stylesheet" type="text/css" href="/2016-06-21_usgame_competition/Web_V3/css/flexslider.css">
<link rel="stylesheet" type="text/css" href="/2016-06-21_usgame_competition/Web_V3/css/index-4.1.1.min.css">
<script type="text/javascript" src="/2016-06-21_usgame_competition/common/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="../js/jquery.flexslider-min.js"></script>
<script type="text/javascript" src="main.js"></script>
<script type="text/javascript">
	setInterval(function() {
		$('.flexslider').flexslider({
			animation : "slide",
			prevText : "",//设置箭头旁的字符为"",初始为previous
			nextText : "" //设置箭头旁的字符为"",初始为Next
		});
	}, 0);
</script>
</head>
<body>
	<!--body-wrap-->

	<div class="body-wrap">
		<div class="body-main main-wrap v-4-2">

			<jsp:include page="../common/head.jsp" flush="true"></jsp:include>
			<style type="text/css">
.sk-index-recommend-con .item-img-box {
	background-size: 35%
}

.sk-index-title h3 {
	font-size: 20px;
	font-weight: 600
}

.sk-index-partners-con .item {
	margin-bottom: 30px
}
</style>
			<!-- slider -->
			<div class="sk-index-slider-box" id="skSlider"
				style="min-width: 1600px; max-width: 1920px;">

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
						</li>  -->
					</ul>
				</div>
			</div>
			<!-- content-->
			<div style="height: 50px;"></div>
			<div class="common-box sk-index-box clearfix">
				<!-- 竞赛 -->
				<div class="sk-index-recommend-box contest">
					<div class="sk-index-title contest">
						<h3 title="竞赛活动">竞赛活动</h3>
						<a href="../competition/competition_list.jsp" class="link"
							title="更多竞赛" target="_blank">更多竞赛&gt;&gt;</a>
					</div>
					<div class="sk-index-recommend-con event clearfix "
						id="Competition_list"></div>
				</div>

				<!-- 营地教育 -->

				<div class="sk-index-recommend-box">
					<div class="sk-index-title contest">
						<h3 title="营地教育">营地教育</h3>

						<a href="../camp/camp_list.jsp" class="link" title="更多营地"
							target="_blank">更多营地&gt;&gt;</a>
					</div>
					<div class="sk-index-recommend-con event clearfix " id="Camp_list">
					</div>
				</div>


				<!-- 培训活动 -->
				<div class="sk-index-recommend-box contest">
					<div class="sk-index-title contest">
						<h3 title="培训活动">培训活动</h3>
						<a href="../train/train_list.jsp" class="link" title="更多培训"
							target="_blank">更多培训&gt;&gt;</a>
					</div>
					<div class="sk-index-recommend-con event clearfix" id="trainList">
					</div>
				</div>

				<div style="height: 50px"></div>
			</div>
		</div>
	</div>
	<jsp:include page="../suspension/suspension.jsp" flush="true"></jsp:include>

	<jsp:include page="../common/end.jsp" flush="true"></jsp:include>


</body>
</html>