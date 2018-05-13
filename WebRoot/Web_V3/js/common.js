//camptition_details.js
function conversioncompetitionForm(a) {
	switch(a) {
	case 1:
		return  "笔试";
		break;
	case 2:
		return  "听力";
		break;
	case 3:
		return "笔试，听力";
		break;
	}/*比赛形式*/
}
function conversionstate(a) {
	switch(a) {
	case 1:
		return  "未开始报名";
		break;
	case 2:
		return  "火热报名中";
		break;
	case 3:
		return "比赛已结束";
		break;
	}
}


//competition -- applyInfo.js
function showgrade(a) {
	switch (a) {
	case "1" :
		return "小学一年级";
		break;
	case "2" :
		return "小学二年级";
		break;
	case "3" :
		return "小学三年级";
		break;
	case "4" :
		return "小学四年级";
		break;
	case "5" :
		return "小学五年级";
		break;
	case "6" :
		return "小学六年级";
		break;
	case "7" :
		return "初中一年级";
		break;
	case "8" :
		return "初中二年级";
		break;
	case "9" :
		return "初中三年级";
		break;
	case "10" :
		return "高中一年级";
		break;
	case "11" :
		return "高中二年级";
		break;
	case "12" :
		return "高中三年级";
		break;
	}
}


function conversiongrade(a) {
	switch (a) {
	case "1" :
		return "小学一年级";
		break;
	case "2" :
		return "小学二年级";
		break;
	case "3" :
		return "小学三年级";
		break;
	case "4" :
		return "小学四年级";
		break;
	case "5" :
		return "小学五年级";
		break;
	case "6" :
		return "小学六年级";
		break;
	case "7" :
		return "初中一年级";
		break;
	case "8" :
		return "初中二年级";
		break;
	case "9" :
		return "初中三年级";
		break;
	case "10" :
		return "高中一年级";
		break;
	case "11" :
		return "高中二年级";
		break;
	case "12" :
		return "高中三年级";
		break;
			
	}
}


function turnage(a) {
	switch(a) {
	case 1:
		return  "4~6岁";
		break;
	case 2:
		return  "7~12岁";
		break;
	case 3:
		return "13~18岁";
		break;
	}
}
function turnTimeLength(a) {
	switch(a) {
	case 1:
		return  "1天";
		break;
	case 2:
		return  "2天";
		break;
	case 3:
		return  "3~5天";
		break;
	case 4:
		return "6~8天";
		break;
	case 5:
		return "9~14天";
		break;
	case 6:
		return "15天及以上";
		break;
		
	}
}

function turnTheme(a){
	switch(a) {
	case 1:
		return  "户外扩展";
		break;
	case 2:
		return  "自然探索";
		break;
	case 3:
		return  "体育运动";
		break;
	case 4:
		return "艺术人文";
		break;
	case 5:
		return "科学技术";
		break;
	case 6:
		return "军旅主题";
		break;
	case 7:
		return "语言提升";
		break;
	case 8:
		return "国际综合";
		break;
	}
}

//时间转换函数   yyyy-MM-dd HH:mm:ss  转到   yyyy-MM-dd
function changeTime(time){
	var t = time.slice(0,10);
	return t;
	
}


//获取url里面的值
function getUrlParam(name) {
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); // 构造一个含有目标参数的正则表达式对象
	var r = window.location.search.substr(1).match(reg);
	if (r != null)
		return unescape(r[2]);
	return null; // 返回参数值
}