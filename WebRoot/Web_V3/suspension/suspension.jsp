<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body><head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>返回顶部</title>


<style type="text/css">

*{margin:0;padding:0;list-style-type:none;}
a,img{border:0;}

/* leftsead */
#leftsead{width:131px;height:143px;position:fixed;bottom:68px;right:0px;}
*html #leftsead{margin-top:258px;position:absolute;top:expression(eval(document.documentElement.scrollTop));}
#leftsead li{width:131px;height:53px;}
#leftsead li img{float:right;border-bottom-left-radius:5px;border-top-left-radius:5px;}
#leftsead li a{height:49px;float:right;display:block;min-width:47px;max-width:131px;}
#leftsead li a .shows{display:block;}
#leftsead li a .hides{margin-right:-166px;cursor:pointer;cursor:hand;}
#leftsead li a.youhui .hides{display:none;position:absolute;right:216px;top:2px;}
</style>

<body style="height:1600px;">

<div id="leftsead">
	<ul>
	     <li>
			<a id="top_btn">
				<img src="/2016-06-21_usgame_competition/images/main/51.png" width="47" height="49" class="hides" style="margin-right: -143px; display: none;">
				<img src="/2016-06-21_usgame_competition/images/main/50.png" width="47" height="49" class="shows" style="display: block;">
			</a>
		</li>

		<li>
			<a class="youhui">
				<img src="/2016-06-21_usgame_competition/images/main/48.jpg" width="47" height="49" class="shows">
				<img src="/2016-06-21_usgame_competition/images/main/49.jpg" width="196" height="205" class="hides" usemap="#taklhtml" style="display: none;">
			</a>
		</li>
	
	
	
	</ul>
</div><!--leftsead end-->


<script type="text/javascript">
$(document).ready(function(){

	$("#leftsead a").hover(function(){
		if($(this).prop("className")=="youhui"){
			$(this).children("img.hides").show();
		}else{
			$(this).children("img.hides").show();
			$(this).children("img.shows").hide();
			$(this).children("img.hides").animate({marginRight:'0px'},'fast'); 
		}
	},function(){ 
		if($(this).prop("className")=="youhui"){
			$(this).children("img.hides").hide('fast');
		}else{
			$(this).children("img.hides").animate({marginRight:'-143px'},'fast',function(){$(this).hide();$(this).next("img.shows").show();});
		}
	});

	$("#top_btn").click(function(){if(scroll=="off") return;$("html,body").animate({scrollTop: 0}, 600);});

});
</script>


</body>
</html>