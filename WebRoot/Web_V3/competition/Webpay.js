var out_trade_no = getUrlParam("out_trade_no");
var money = getUrlParam("money");
var url = "http://www.usgame.cn/2016-06-21_usgame_competition/WeChatPayIndex?money="+money+"&out_trade_no="+out_trade_no;

jQuery(function(){
	jQuery('#qrcodeid').qrcode({
			width:260,
			height:260,
			render:"canvas", //设置渲染方式 table canvas
			typeNumber : -1,  //计算模式 
			correctLevel  : 0,//纠错等级 
			background   : "#ffffff",//背景颜色 
			foreground   : "#000000",//前景颜色 
			text : url

	}); 
})


$(document).ready(function () {
	$("#dingdan").html(out_trade_no);
	$("#paymoney").html(money);
	$(".moneycolor").html(money);
	    setInterval("judgeState()", 3000);    
	});
	
	function judgeState() {
	    if ( out_trade_no!= 0) {
	    	$.post("../../CampServlet", {
	    		method : "judgeApplyState",
	    		out_trade_no:out_trade_no
	    	}, function(json) {
	    		var data = JSON.parse(json);
	    		//console.log(data);
	    		if(data.state==1) {
	    			alert("支付成功")
	    			window.location.href="../User/userMain.jsp";
	    		}
	    	});
	    }
	
	} 