<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>报名信息</title>
    <link rel="stylesheet" type="text/css" href="/2016-06-21_usgame_competition/Web_V3/css/top-4.4.min.css">
    <link rel="stylesheet" type="text/css" href="/2016-06-21_usgame_competition/Web_V3/css/contest.info-4.3.min.css">
    <link rel="stylesheet" type="text/css" href="/2016-06-21_usgame_competition/Web_V3/css/contest.apply-4.4.min.css">
    <link rel="stylesheet" type="text/css" href="/2016-06-21_usgame_competition/Web_V3/css/monokai_sublime.min.css">
<script type="text/javascript" src="../../common/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="enroll_info.js"></script>
<style type="text/css">
.select-option{
  width:392px;
  height:46px;
}
</style>
</head>
<body>
<!--body-wrap-->
<div class="body-wrap">
    <div class="body-main main-wrap v-4-2">
       <jsp:include page="../common/head.jsp"></jsp:include>
<style type="text/css">
    .c-v-spe .upload-ok{left:0;width:100%;height:100%}
    .c-v-spe.disable,.up-thumb-add.disable{background:#eee!important;color:inherit!important;}
    .c-v-spe.disable input[type=file],.up-thumb-add.disable input[type=file]{cursor:default}
    .c-v-spe .upload-ok .para{padding:0 20px 0 40px}
    .neccs-tip-box{
        font-size:12px;
        margin-top:7px;
    }
    .neccs-tip-box .item{
        min-width:300px;
    }
</style>
<!-- content -->
        <div class="first-title-box" id="comName">
        </div>

			<form class="common-box sk-event-box creat-cy-box  team-view"
				id="skEventBuildTeamForm" action=""
				novalidate="novalidate">
				<input type="hidden" name="team_id" value="119266">

				<div class="cy-common-form-line-box clearfix">
					<div class="common-form-line fl">
						<div class="common-form-label star-tip">姓名</div>
						<div class="common-input fl">
							<input type="text" name="name" id="name" placeholder="你的名字" value=""
								data-rule-required="true" data-msg-required="内容不能为空"
								data-rule-islegalcharacter="true" aria-required="true">
							
						</div>
					</div>
					<div class="common-form-line fl">
						<div class="common-form-label star-tip">学校</div>
						<div class="common-input fl">
							<input type="text" name="school" id="school" placeholder="例：镇海中学"
								value="" data-rule-required="true"
								data-msg-required="内容不能为空" data-rule-islegalcharacter="true"
								aria-required="true">
						</div>
					</div>
					
					
					<div class="common-form-line fl">
						<div class="common-form-label star-tip">所在年级</div>
						<div class="common-input fl">
							<!-- <input type="text" name="" placeholder="例：初中一年级"
								value="" data-rule-required="true"
								data-msg-required="内容不能为空" data-rule-islegalcharacter="true"
								aria-required="true"> -->
						<select class="select-option" id="grade" name="select_grade">
			                <option value="1">小学一年级</option>
			                <option value="2">小学二年级</option>
			                <option value="3">小学三年级</option>
			                <option value="4">小学四年级</option>
			                <option value="5">小学五年级</option>
			                <option value="6">小学六年级</option>
			                <option value="7">初中一年级</option>
			                <option value="8">初中二年级</option>
			                <option value="9">初中三年级</option>
			                <option value="10">高中一年级</option>
			                <option value="11">高中二年级</option>
			                <option value="12">高中三年级</option>
	                	</select>
	                	</div>
						
					</div>
					
					<div class="common-form-line fl">
						<div class="common-form-label star-tip">身份证号</div>
						<div class="common-input fl">
							<input type="text" name="iDcard" id="iDcard" placeholder="报名学生身份证号"
								value="" data-rule-required="true"
								data-msg-required="内容不能为空" data-rule-idcard="true"
								aria-required="true">
						</div>
					</div>
					
					<div class="common-form-line fl">
						<div class="common-form-label star-tip">培训年级</div>
						<div class="common-input fl">
							<!-- <input type="text" name="" placeholder="例：初中一年级"
								value="" data-rule-required="true"
								data-msg-required="内容不能为空" data-rule-email="true"
								aria-required="true"> -->
						<select class="select-option" id="trainGrade" name="select_competitiongrade">
	                	</select>
						</div>
					</div>
					<div class="common-form-line fl">
						<div class="common-form-label star-tip">培训科目</div>
						<div class="common-input fl">
							<input type="text" name="subject" id="subject" placeholder="培训科目"
								value="" data-rule-required="true"
								data-msg-required="内容不能为空" readonly="readonly"
								aria-required="true">
						</div>
					</div>
					
					<div class="common-form-line fl">
						<div class="common-form-label star-tip">联系人</div>
						<div class="common-input fl">
							<input type="text" name="" id="contectName" placeholder="联系人姓名"
								value="" data-rule-required="true"
								data-msg-required="内容不能为空" data-rule-email="true"
								aria-required="true">
						</div>
					</div>
					<div class="common-form-line fl">
						<div class="common-form-label star-tip">联系电话 </div>
						<div class="common-input fl">
							<input type="text" name="" id="contectPhone" placeholder="联系人电话"
								value="" data-rule-required="true"
								data-msg-required="内容不能为空" data-rule-idcard="true"
								aria-required="true">
						</div>
					</div>
				</div>
				<div class="c-v-btn-box v-4-4 tac clearfix">
					<input type="button" onclick="toconfirm()" class="sk-btn-green sk-btn v-4-4" value="下一步">
				</div>

			</form>

		</div>
</div>
 <jsp:include page="../common/end.jsp"></jsp:include>
   
</body>
</html>