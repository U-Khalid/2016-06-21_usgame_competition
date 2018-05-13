<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="/2016-06-21_usgame_competition/Web_V3/css/top-4.4.min.css">
<link rel="stylesheet" type="text/css" href="/2016-06-21_usgame_competition/Web_V3/css/setting-4.5.min.css">
<link rel="stylesheet" type="text/css" href="/2016-06-21_usgame_competition/Web_V3/css/jquery-ui-1.10.4.custom.min.css">
<script type="text/javascript" src="/2016-06-21_usgame_competition/common/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="/2016-06-21_usgame_competition/Web_V3/js/common.js"></script>
<script type="text/javascript" src="showgrade.js"> </script>

<title>成绩</title>
</head>
<body>
<!--body-wrap-->
<div class="body-wrap">
    <div class="body-main main-wrap v-4-2">
        <jsp:include page="../common/head.jsp"></jsp:include>
        <!-- content -->
        <div class="common-box sk-event-box creat-cy-box team-view por-h-p-set">
            <div class="sk-tab-box">

            </div>
            <div class="sk-user-info-set-box">
                <!-- 基本资料 -->
                <div class="js_item">
                    <div class="cy-info-box">
                        <span class="public cy-info-line"></span>
                        <span class="public info-title">考试结果</span>
                        <span class="public cy-info-line"></span>
                   
                    </div>
   
                        <div class="cy-common-form-line-box clearfix">
                            <div class="basic-info-box fl">
                               
                                <div class="common-form-line fl" style="margin-left:350px;">
									<div class="common-form-label " id="competitionName">竞赛名称:&nbsp;&nbsp;&nbsp;</div>
									<!-- <div class="common-input fl">
										<input type="text" id="competitionName" >
										readonly="readonly"
									</div> -->
								</div>
								
								<div class="common-form-line fl" style="margin-left:350px;">
									<div class="common-form-label " id="admissionTicket">准考证号:&nbsp;&nbsp;&nbsp;</div>
									<!-- <div class="common-input fl">
										<input type="text" id="admissionTicket" readonly="readonly">
									</div> -->
								</div>

								<div class="common-form-line fl" style="margin-left:40px;">
									<div class="common-form-label " id="competitionSubject">科目:&nbsp;&nbsp;&nbsp;</div>
								</div>
								
								<div class="common-form-line fl" style="margin-top:85px;margin-left:-325px;">
									<div class="common-form-label " id="userName">姓名:&nbsp;&nbsp;&nbsp;</div>
									
								</div>
								
								<div class="common-form-line fl" style="margin-top:85px;margin-left:-110px;">
									<div class="common-form-label " id="userGrade">年级:&nbsp;&nbsp;&nbsp;</div>
									<!-- <div class="common-input fl">
										<input type="text" id="userGrade" readonly="readonly">
									</div> -->
								</div>
								
								
								<div class="common-form-line fl" style="margin-left:350px;">
									<div class="common-form-label " id="password">查询密码:&nbsp;&nbsp;&nbsp;</div>
									<!-- <div class="common-input fl">
										<input type="text" id="password" readonly="readonly">
									</div> -->
								</div>
								
								
								<div class="common-form-line fl" style="margin-left:55px;">
									<div class="common-form-label " id="competitionGrade">成绩:&nbsp;&nbsp;&nbsp;</div>
									<!-- <div class="common-input fl">
										<input type="text" id="competitionGrade" readonly="readonly">
									</div> -->
								</div>
								
								
								<div class="common-form-line fl" style="margin-left:350px;">
									<div class="common-form-label " id="promotion">晋级情况:&nbsp;&nbsp;&nbsp;</div>
								</div>
								
								
								<div class="common-form-line fl" style="margin-left:350px;">
									<div class="common-form-label " id="award">奖项:&nbsp;&nbsp;&nbsp;</div>
									
								</div>
								
								
								<div class="common-form-line fl" style="margin-top:85px;margin-left:-80px;">
									<div class="common-form-label " id="note">备注:&nbsp;&nbsp;&nbsp;</div>
									<!-- <div class="common-input fl">
										<input type="password" id="note" readonly="readonly">
									</div> -->
								</div>
								
								
								
                        	</div>
                        </div>
    
                        
                        
                        
                        
                        <div class="sk-btn-box" style="margin-left:480px;">
                            <input type="button" value="返回" class="sk-btn sk-btn-green" onclick="javascript:backquery()">
                        </div>
                        
                     
                        
                        
                        <div style="height:50px;"></div>
                </div>

              <!--   <div class="sk-user-info-list award" id="userAwardInfoList">
                                    </div> -->
            </div>
        </div>
    </div>
</div>
<div style="height:80px"></div>
<jsp:include page="../common/end.jsp"></jsp:include>
</body>
</html>