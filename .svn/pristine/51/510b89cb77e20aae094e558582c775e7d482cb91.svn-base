$(document).ready(function(){
	getInfo();
});

function getInfo() {
	$.post("../CompetitionServlet", {
		method : "getEnableNewsInfo"
	}, function(json) {
		
		var data = JSON.parse(json);
		//console.log(data);
		var json = data.data;
        if(json==null) {
        	showdialog1();
        }
        else {
        	showInfo(json);
        }
		
		
	});
}

function showInfo(json) {
	for(var i=0;i<json.length;i++) {
		$("#list").append(
				"<div class='weui_panel weui_panel_access'>"+
				"<a href="+json[i].url+">"+
					"<div class='weui_media_box weui_media_text weui_panel_ft'>"+
						"<label class='weui_label'>"+json[i].info+"</label>"+
					"</div>"+
				"</a>"+
			  "</div>"

		
		)
		
	}
}

function showdialog1 () {
	$("#dialog1").show();
}

function togeren () {
	$("#dialog1").hide();
	window.location.href = "geren.html";
}