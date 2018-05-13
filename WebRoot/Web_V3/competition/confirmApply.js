var out_trade_no ;
var money ;
var competitionName;
var competitionId;
var competitionSubject;
var allcompetitionGrade;
$(document).ready(function() {
	competitionName = decodeURI(getUrlParam("competitionName"));
	competitionId = getUrlParam("competitionId");
	competitionSubject = decodeURIComponent(getUrlParam("competitionSubject"))
	allcompetitionGrade = decodeURIComponent(getUrlParam("allcompetitionGrade"));
	$('#comName').append(
			'<h1 class="first-title" title="'+competitionName+'"><a href="competition_details.jsp?CompetitionId='+competitionId+'" target="_blank" id="competitionName">'+competitionName+'</a></h1>'
	)
	$('#name').html(decodeURIComponent(getUrlParam("name")));
	$('#idCard').html(getUrlParam("idCard"));
	$('#school').html(decodeURI(getUrlParam("school")));
	$('#grade').html(showgrade(getUrlParam("grade")));
	$('#competitionSubject').html(competitionSubject);
	$('#competitionGrade').html(showgrade(getUrlParam("competitionGrade")));
	$('#contectName').html(decodeURIComponent(getUrlParam("contectName")));
	$('#contectPhone').html(getUrlParam("contectPhone"));
	out_trade_no = getUrlParam("out_trade_no");
	money = getUrlParam("money")
	$('#out_trade_no').html(out_trade_no);
	$('.count').html("￥ "+money);
	
});
function backapplyInfo(){
	window.location.href="applyInfo.jsp?competitionName="+encodeURI(encodeURI(competitionName))+"&&competitionSubject="+encodeURI(encodeURI(competitionSubject))+"&&competitionGrade="+encodeURI(encodeURI(allcompetitionGrade))+"&&CompetitionId="+encodeURI(encodeURI(competitionId))+"&&money="+money;
}
function topay() {
	window.location.href = "Webpay.jsp?out_trade_no=" + out_trade_no + "&money="+money;
}
