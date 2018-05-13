function showPasswd() {
	if($("#regpass").attr("type")=="password"){
		$("#regpass").attr("type","text");
		$(".js_view_pass_btn").addClass("active");
	}
	else{
		$("#regpass").attr("type","password");
		$(".js_view_pass_btn").removeClass("active");
	}
}