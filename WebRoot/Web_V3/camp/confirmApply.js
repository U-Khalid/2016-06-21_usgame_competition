var out_trade_no ;
var money ;
var camp_Name;
var campId;
var camp_Address;
var camp_Age;
$(document).ready(function() {
	camp_Name = decodeURI(getUrlParam("camp_Name"));
	campId = getUrlParam("campId");
	camp_Address = decodeURIComponent(getUrlParam("camp_Address"));
	$('#campName').append(
			'<h1 class="first-title" title="'+camp_Name+'"><a href="camp_details.jsp?CampId='+campId+'" target="_blank" id="camp_Name">'+camp_Name+'</a></h1>'
	)
	$('#name').html(decodeURIComponent(getUrlParam("name")));
	$('#idCard').html(getUrlParam("idCard"));
	$('#school').html(decodeURI(getUrlParam("school")));
	$('#camp_Age').html(getUrlParam("camp_Age")+" 岁");
	$('#camp_Address').html(camp_Address);
	$('#address').html(decodeURIComponent(getUrlParam("address")));
	$('#contectName').html(decodeURIComponent(getUrlParam("contectName")));
	$('#contectPhone').html(getUrlParam("contectPhone"));
	out_trade_no = getUrlParam("out_trade_no");
	money = getUrlParam("money")
	$('#out_trade_no').html(out_trade_no);
	$('.count').html("￥ "+money);
	
});
function backapplyInfo(){
	window.location.href="applyInfo.jsp?camp_Name="+encodeURI(encodeURI(camp_Name))+"&&camp_Address="+encodeURI(encodeURI(camp_Address))+"&&CampId="+encodeURI(encodeURI(campId))+"&&money="+money;
}
function topay() {
	window.location.href = "Webpay.jsp?out_trade_no=" + out_trade_no + "&money="+money;
}
