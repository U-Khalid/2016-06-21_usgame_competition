$(document).ready(function() {
	judgelogin();
});
function judgelogin() {
	$.post("../../UserServlet",{
		method : "getUserInfo"
	}, function(json) {
		var json = JSON.parse(json);
		//console.log(json);
		if(json.msg==false) {
			/*alert(123);*/
			$(".nav-r").append(
					"<div class='nav-con nav-r-2 fr' style='margin-right:-30px;'>"+
					"<a href='../reg/reg.jsp' class='register' rel='nofollow'>注册</a>"+
            "<a href='../login/login.jsp' class='register' rel='nofollow'>登录</a></div>"+
            "</div>"
            )
			 
		}
		else {
			$(".nav-r").append(
					'<div class="nav-con nav-r-2 fr" >'+
					'<div class="fr n-hover n-user-pn clearfix">'+
                    '<a href="../User/userMain.jsp" title='+json.data.name+'>'+
                     '   <img src="/2016-06-21_usgame_competition/images/main/15.jpg" alt='+json.data.name+' class="fl n-user-pic">'+
                      '  <span title='+json.data.name+' class="fl n-user-name">'+json.data.name+'</span>'+
                    '</a>'+
                    '<ul class="n-user-pn-tip">'+
                                                        '<li>'+
                                '<a href="../User/userMain.jsp"><i class="common-icon n-user-home"></i>个人主页</a>'+
                            '</li>'+
                                                    '<li>'+
                            '<a href="../User/userInfo.jsp" rel="nofollow"><i class="common-icon n-user-set"></i>账号设置</a>'+
                       ' </li>'+
                        '<li class="no-b">'+
                           ' <a href="" rel="nofollow"><i class="common-icon n-user-help"></i>帮助中心</a>'+
                       ' </li>'+
                         '<li class="no-b" rel="nofollow">'+
                           ' <a href="javascript:logout();" rel="nofollow"><i class="common-icon n-user-quit"></i>退出账号</a>'+
                        '</li>'+
                    '</ul>'+
                '</div>'+
                '</div>'
            )
		}
	})
}

function logout() {
	$.post('../../UserServlet', {
		method : 'logout' 
	}, function(json) {
		var data = JSON.parse(json);
		if(data.msg) {
			alert("退出成功！");
			
		}
		else {
			alert("退出失败！");
		}
		window.location.href="../Main/main.jsp";
	});
}

function toMain() {
	window.location.href="../Main/main.jsp";
}
function toCompetition() {
	window.location.href="../competition/competition_list.jsp";
}
function toCamp() {
	window.location.href="../camp/camp_list.jsp";
}
function toTrain() {
	window.location.href="../train/train_list.jsp";
}
function toQuery() {
	window.location.href="../querygrade/querygrade.jsp";
}

function search() {
  var searchInfo = $("#search").val();
  window.location.href="/2016-06-21_usgame_competition/Web_V3/search/search.jsp?searchInfo="+encodeURI(encodeURI(searchInfo));
}

function toElite(){
	alert("本功能正在发开中！");
}
