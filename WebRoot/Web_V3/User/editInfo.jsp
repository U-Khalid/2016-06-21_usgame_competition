<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="Shortcut Icon" href="/2016-06-21_usgame_competition/images/main/favicon.ico">
<link rel="apple-touch-icon-precomposed" href="/2016-06-21_usgame_competition/images/main/sk_mobile_icon57x57.png">
<link rel="apple-touch-icon-precomposed" sizes="72x72" href="/2016-06-21_usgame_competition/images/main/sk_mobile_icon72x72.png"><!-- ipad图标尺寸72x72-->
<link rel="apple-touch-icon-precomposed" sizes="114x114" href="/2016-06-21_usgame_competition/images/main/sk_mobile_icon114x114.png"><!-- 对应retina屏的iPhone及iTouch图标尺寸114x114 -->
<link rel="stylesheet" type="text/css" href="/2016-06-21_usgame_competition/Web_V3/css/top-4.4.min.css">
<link rel="stylesheet" type="text/css" href="/2016-06-21_usgame_competition/Web_V3/css/setting-4.5.min.css">
<link rel="stylesheet" type="text/css" href="/2016-06-21_usgame_competition/Web_V3/css/jquery-ui-1.10.4.custom.min.css">
<!-- <link rel="stylesheet" type="text/css" href="W/2016-06-21_usgame_competition/common/bootstrap/bootstrap.css"> -->
<script type="text/javascript" src="/2016-06-21_usgame_competition/common/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="/2016-06-21_usgame_competition/Web_V3/js/common.js"></script>
<script type="text/javascript" src="editInfo.js"> </script>
<title>Edit Information</title>
</head>
<body>
<!--body-wrap-->
<div class="body-wrap">
    <div class="body-main main-wrap v-4-2">
        <jsp:include page="../common/head.jsp"></jsp:include>
        <!-- content -->
        <div class="common-box sk-event-box creat-cy-box team-view por-h-p-set">
            <div class="sk-tab-box">
                <a href="javascript:;" class="tab-con active">个人信息</a>

            </div>
            <div class="sk-user-info-set-box">
                <!-- 基本资料 -->
                <div class="js_item">
                    <div class="cy-info-box">
                        <span class="public cy-info-line"></span>
                        <span class="public info-title">基本资料</span>
                        <span class="public cy-info-line"></span>
                        <!-- <span class="set-btn-box">
                            <button class="set-btn edit js_edit_btn disable" disabled="disabled">编辑</button>
                        </span> -->
                    </div>
             <!--  <div class="sk-user-basic-info-box clearfix js_user_info_show_box hide">
                        <a href="" class="fl item-img-box">
                            <img src="http://cdn3.saikr.com/img/def-user.jpg?v=201605101110" alt="1322" class="item-img">
                        </a>
                        <ul class="fl item-ul" style="margin-top: 18px;">
                            <li id="username"></li>
                            <li id="sex"></li>
                            <li id="school"></li>
                            <li id="grade"></li>
                            <li id="phonenumber"></li>
                            <li id="iDcard"></li>
                            <li id="address"></li>
                            <li id="motto"></li>
                        </ul>
                    </div> -->
                        <div class="cy-common-form-line-box clearfix">
                            <div class="basic-info-box fl">
                               
                                <div class="common-form-line" style="margin-left:350px;">
                                    <div class="common-form-label clearfix">
                                        <span class="star-tip fl" >姓名</span>
                                    </div>
                                    <div class="common-input" id="input-name">
                                        
                                    </div>
                                </div>
                                
                               
                                <div class="common-form-line" style="margin-left:350px;">
                                    <div class="common-form-label clearfix">
                                        <span class="star-tip fl">性别</span>
                                    </div>
                                    
                                   <!-- <div class="common-input"  id="input-sex">
                                   		
                                   </div> -->
                                   <div class="common-input">  
     										<span class="common-input" >  
          										<select  style="height:45px;width:355px;outline:none;border-radius:3px;border-color:#DEDEDE;" id="choice-sex" ">
													<option style="font-size:18px;" value="0">&nbsp;&nbsp;&nbsp;男</option> 
													<option style="font-size:18px;" value="1">&nbsp;&nbsp;&nbsp;女</option>
												</select>
     										</span>  
									</div>  
									
                                </div>
                                
                                
                                <div class="common-form-line" style="margin-left:350px;">
                                    <div class="common-form-label clearfix">
                                        学校
                                    </div>
                                    <div class="common-input" id="input-school">
                                        
                                    </div>
                                </div>
                                
                                 
                                <div class="common-form-line" style="margin-left:350px;">
                                    <div class="common-form-label clearfix">
                                        年级
                                    </div>
                                    <!-- <div class="common-input" id="input-grade">
                                        
                                    </div> -->
                                     <div class="common-input" >  
     										<span class="common-input" >  
          										 <select  style="height:45px;width:355px;outline:none;border-radius:3px;border-color: #DEDEDE;" id="choice-grade" "> 
					  								<option style="font-size:18px;" value="1">&nbsp;&nbsp;&nbsp;小学一年级</option>
													<option style="font-size:18px;" value="2">&nbsp;&nbsp;&nbsp;小学二年级</option>
													<option style="font-size:18px;" value="3">&nbsp;&nbsp;&nbsp;小学三年级</option>
													<option style="font-size:18px;" value="4">&nbsp;&nbsp;&nbsp;小学四年级</option>
													<option style="font-size:18px;" value="5">&nbsp;&nbsp;&nbsp;小学五年级</option>
													<option style="font-size:18px;" value="6">&nbsp;&nbsp;&nbsp;小学六年级</option>
													<option style="font-size:18px;" value="7">&nbsp;&nbsp;&nbsp;初中一年级</option>
													<option style="font-size:18px;" value="8">&nbsp;&nbsp;&nbsp;初中二年级</option>
													<option style="font-size:18px;" value="9">&nbsp;&nbsp;&nbsp;初中三年级</option>
													<option style="font-size:18px;" value="10">&nbsp;&nbsp;&nbsp;高中一年级</option>
													<option style="font-size:18px;" value="11">&nbsp;&nbsp;&nbsp;高中二年级</option>
													<option style="font-size:18px;" value="12">&nbsp;&nbsp;&nbsp;高中三年级</option>
											</select> 
     										</span>  
      
										</div> 
                                </div>
                                
                                <div class="common-form-line" style="margin-left:350px;">
                                    <div class="common-form-label clearfix" >
                                        <span class="star-tip fl">注册手机号</span>
                                    </div>
                                    <div class="common-input" id="input-phonenumber">
                                        
                                    </div>
                                </div>
                                
                                 <div class="common-form-line" style="margin-left:350px;">
                                    <div class="common-form-label clearfix">
                                        <span class="star-tip fl">身份证</span>
                                    </div>
                                    <div class="common-input" id="input-iDcard">
                                        
                                    </div>
                                </div>
                                
                                <div class="common-form-line" style="margin-left:350px;">
                                    <div class="common-form-label clearfix">
                                        地址
                                    </div>
                                    <div class="common-input" id="input-address">
                                        
                                    </div>
                                </div>
                                
                                <div class="common-form-line " style="margin-left:350px;">
                                    <div class="common-form-label">
                                        签名
                                    </div>
                                    <div class="common-input" id="input-motto">
                                        
                                    </div>
                                </div>
                            </div>
                            <!-- <div class="basic-info-box fl" style="margin-left:100px;">
                                <div class="common-form-line">
                                    <div class="common-form-label clearfix">
                                        <span class="fl">头像</span><span class="pour fr">注：仅支持JPG、GIF、PNG格式的图片文件，小于2MB</span>
                                    </div>
                                    <div class="common-input">
                                        <div class="photo-box clearfix">
                                            <div class="load-photo-box w-172 fl">
                                                <div class="load-photo-link-box">
                                                    <a href="javascript:;" class="load-photo-link img-160">
                                                        <img src="http://cdn3.saikr.com/img/def-user.jpg?v=201605101110" alt="" class="js_user_head_img">
                                                    </a>
                                                    <div class="s-160">160x160</div>
                                                </div>
                                                <div class="sk-btn show">上传头像
                                                    <input type="file" class="cropit-image-input" accept=".jpg,.gif,.png" id="J_cropitFileInput" title="">
                                                </div>
                                                <input type="hidden" name="avatar" id="userHeadImgInp" value="http://cdn3.saikr.com/img/def-user.jpg?v=201605101110">
                                                <div class="sk-btn">修改头像</div>
                                            </div>
                                            <div class="load-photo-box fl clearfix">
                                                <div class="load-photo-link-box max fl">
                                                    <a href="javascript:;" class="load-photo-link img-70">
                                                        <img src="http://cdn3.saikr.com/img/def-user.jpg?v=201605101110" alt="" class="js_user_head_img">
                                                    </a>
                                                    <div class="photo-size s-70">70x70</div>
                                                </div>
                                                <div class="load-photo-link-box max  fl">
                                                    <a href="javascript:;" class="load-photo-link img-30">
                                                        <img src="http://cdn3.saikr.com/img/def-user.jpg?v=201605101110" alt="" class="js_user_head_img">
                                                    </a>
                                                    <div class="photo-size s-30">30x30</div>
                                                </div>
                                            </div>
                                            <div class="kong fl"></div>
                                            <p class="para fl">上传的头像会自动生成头像缩略图。最终会生成以上尺寸的头像，请注意是否清晰。</p>
                                            <p class="para fl">推荐尺寸：160*160像素</p>
                                        </div>
                                      
                                       
                                    </div>
                                </div>
                            </div> -->
                        </div>
                        
                        <div class="sk-btn-box" style="margin-left:480px;">
                            <input type="button" value="保存" class="sk-btn sk-btn-green" onclick="saveUserInfo()" >
                            <div class="success-tip js_success_tip" >保存成功</div>
                        </div>
                        
                        
                        <div style="height:50px;"></div>
                </div>
                
                
                <!-- 微信端提示成功 -->
               <!--  <div class="weui_dialog_alert" id="dialog1" style="display: none;">
    <div class="weui_mask"></div>
    <div class="weui_dialog">
        <div class="weui_dialog_hd"><strong class="weui_dialog_title">修改提示框</strong></div>
        <div class="weui_dialog_bd">修改成功，点击确定跳转个人页面！</div>
        <div class="weui_dialog_ft">
            <a href="javascript:togeren();" class="weui_btn_dialog primary">确定</a>
        </div>
    </div>
</div>
                 -->
                
                

                <div class="sk-user-info-list award" id="userAwardInfoList">
                                    </div>
            </div>
        </div>
    </div>
</div>

<!-- <div class="pop-box pop-modal mtv-pop-box sk-school-pop js_pop_modal" id="selectSchoolPop">
    <span class="common-icon pop-close js_pop_close"></span>
    <div class="pop-box-tit">选择学校</div>
    <div class="mtv-pop-text-info-box">
        <div class="bs-search-box">
             <form action="" method="get" class="bs-search-form" id="searchSchoolForm" novalidate="novalidate">
                <input type="text" data-rule-islegalcharacter="true" placeholder="请输入学校名称" class="bs-search-inp pop-search-inp" id="searchSchoolInp">
                <i class="common-icon pop-search-icon"></i>
                <input type="submit" class="bs-search-btn" value="搜索">
            </form>
        </div>
        <ul class="mtv-set-scl-list" id="selectSchoolList">
            <li class="mtv-set-scl-item js_school_item">清华大学</li>
            <li class="mtv-set-scl-item js_school_item">北京大学</li>
            <li class="mtv-set-scl-item js_school_item">清华大学</li>
        </ul>
        空内容提示
        <form action="/school/rebace_school" class="none-school-tip-box" id="noneSchoolTipForm" novalidate="novalidate">
            <div class="pop-sorry-box"></div>
            <p class="sorry-para">抱歉，找不到你所在的学校~</p>
            <div class="mtv-pop-para-box">
                <p class="sorry">Sorry～点击这里向我们反馈你的学校：</p>
                <p class="sorry">（请在输入框中填写校名全称，您所填写的校名将作为报名信息提交给组委会。）</p>
            </div>
            <div class="mtv-pop-school-btn-box">
                <div class="mtv-pop-school">
                    <div class="common-input">
                        <input type="text" name="univs_name" data-rule-required="true" data-msg-required="请输入学校名称" data-rule-islegalcharacter="true" id="noneSchoolInp" aria-required="true">
                    </div>
                </div>
            </div>
            <div class="mtv-submit-btn-box">
                 <input type="submit" value="提交反馈" class="sk-btn set-ask">
                 <div class="success" id="schoolFeedBackTip">反馈成功</div>
            </div>
        </form>
    </div>
</div> -->
<!-- 信息提示 -->
<div class="lg-error-box v-4-3 js_pop_modal" id="ajaxMessageBox">
    <div class="lg-error-icon"></div>
    <div class="lg-error-header">
        信息提示
        <i class="common-icon lg-error-close js_pop_close"></i>
    </div>
    <div class="lg-error-con" id="ajaxMessage">
    </div>
</div>
<!-- 确认信息 -->
<div id="promptMessageBox" class="pop-box pop-modal prompt-box v-4-3 js_pop_modal">
    <div class="pop-box-tit" id="promptMessageTitle">
        温馨提示
    </div>
    <div class="prompt-con">
        <p class="prompt-txt" id="promptMessage"></p>
        <div class="prompt-btn-box clearfix">
            <a class="fr sk-btn sk-btn-green prompt-btn" href="javascript:;" id="promptConfirmBtn">确认</a>
            <a class="fr sk-btn sk-btn-white prompt-btn js_pop_close" href="javascript:;">取消</a>
        </div>
    </div>
</div>
<div class="lg-mask" id="popMask"></div>
<!-- 上传头像 -->
<div class="pop-modal js_pop_modal pop-modify-head-img" id="popModifyHeadImg">
    <span class="common-icon pop-close js_pop_close"></span>
    <div class="pop-modal-content" id="popModifyHeadImgContent">
    </div>
</div>
<script type="text/html" id="popModifyHeadImgTpl">
    <div class="pop-modal-title">
        修改头像
    </div>
    <form action="" id="imageEditor">
        <div class="pop-img-view-box">
            <div style="margin-left:10px">
            <div class="cropit-image-preview-container">
                <div class="cropit-image-preview"></div>
            </div>
            </div>
        </div>
        <div class="pop-change-btn-box">
            <span class="common-icon pop-change-btn smaller"></span>
            <input type="range" class="cropit-image-zoom-input" style="-webkit-appearance:slider-horizontal;margin-left:46px;width:228px;">
            <span class="common-icon pop-change-btn bigger"></span>
        </div>
        <button id="uploadSub" class="sk-btn sk-btn-green pop-img-sub-btn">提交</button>
    </form>
</script>
 

 
<jsp:include page="../common/end.jsp"></jsp:include>
</body>
</html>