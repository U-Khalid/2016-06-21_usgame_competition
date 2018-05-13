<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="Shortcut Icon" href="/2016-06-21_usgame_competition/images/main/favicon.ico">
<link rel="apple-touch-icon-precomposed" href="/2016-06-21_usgame_competition/images/main/sk_mobile_icon57x57.png">
<link rel="apple-touch-icon-precomposed" sizes="72x72" href="/2016-06-21_usgame_competition/images/main/sk_mobile_icon72x72.png"><!-- ipad图标尺寸72x72-->
<link rel="apple-touch-icon-precomposed" sizes="114x114" href="/2016-06-21_usgame_competition/images/main/sk_mobile_icon114x114.png"><!-- 对应retina屏的iPhone及iTouch图标尺寸114x114 -->
<link rel="stylesheet" type="text/css" href="/2016-06-21_usgame_competition/Web_V3/css/top-4.4.min.css">
<link rel="stylesheet" type="text/css" href="/2016-06-21_usgame_competition/Web_V3/css/jquery-ui-1.10.4.custom.min.css">
<link rel="stylesheet" type="text/css" href="/2016-06-21_usgame_competition/Web_V3/css/setting-4.5.min.css">
<script type="text/javascript" src="/2016-06-21_usgame_competition/common/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="user.js"></script>
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
                        <span class="set-btn-box">
                            <a href="editInfo.jsp"><button class="set-btn edit js_edit_btn">编辑</button></a>
                        </span>
                    </div>
                    <div class="sk-user-basic-info-box clearfix js_user_info_show_box">
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
                    </div>
                    
                    
                    
                    
                    
                    
                    <!-- 貌似没什么用   -->
                    <form action="/s/u" id="userBasicInfoForm" class="sk-user-info-set-form hide js_user_info_set_form" novalidate="novalidate">
                        <div class="cy-common-form-line-box clearfix">
                            <div class="basic-info-box fl">
                                <div class="common-form-line">
                                    <div class="common-form-label clearfix">
                                       <span class="star-tip fl">昵称</span>
                                    </div>
                                    <div class="common-input">
                                        <input type="text" name="nick_name" data-rule-required="true" data-msg-required="请填写昵称" data-rule-isLegalCharacter = "true" value="1322">
                                    </div>
                                </div>
                                <div class="common-form-line">
                                    <div class="common-form-label clearfix">
                                        <span class="star-tip fl" id="name"></span>
                                        <span class="fl lock-tip">
                                            <span class="lock-tip-pop">不对外公开<span>
                                        </span>
                                    </div>
                                    <div class="common-input">
                                        <input type="text" name="real_name" data-rule-required="true" data-msg-required="请填写真实姓名" data-rule-islegalcharacter="true" value="1322" aria-required="true">
                                    </div>
                                </div>
                                <div class="common-form-line">
                                    <div class="common-form-label clearfix">
                                        <span class="star-tip fl">性别</span>  <span class="star-tip fl" id="sex"></span>
                                    </div>
                                    <div class="common-input c-v-spe">
                                        <div class="fl radio need">
                                            <div class="fl need-radio js_rc_input">
                                                <div class="iradio checked" style="position: relative;"><input type="radio" name="sex" id="male" checked="checked" value="1" style="position: absolute; top: -20%; left: -20%; display: block; width: 140%; height: 140%; margin: 0px; padding: 0px; background: rgb(255, 255, 255); border: 0px; opacity: 0;"><ins class="iCheck-helper" style="position: absolute; top: -20%; left: -20%; display: block; width: 140%; height: 140%; margin: 0px; padding: 0px; background: rgb(255, 255, 255); border: 0px; opacity: 0;"></ins></div>
                                            </div>
                                            <label class="fl need-label" for="male">
                                                男
                                            </label>
                                        </div>
                                        <div class="fl radio">
                                            <div class="fl no-need-radio js_rc_input">
                                                <div class="iradio" style="position: relative;"><input type="radio" name="sex" id="female" value="2" style="position: absolute; top: -20%; left: -20%; display: block; width: 140%; height: 140%; margin: 0px; padding: 0px; background: rgb(255, 255, 255); border: 0px; opacity: 0;"><ins class="iCheck-helper" style="position: absolute; top: -20%; left: -20%; display: block; width: 140%; height: 140%; margin: 0px; padding: 0px; background: rgb(255, 255, 255); border: 0px; opacity: 0;"></ins></div>
                                            </div>
                                            <label class="fl no-need-label" for="female">
                                             女
                                            </label>
                                        </div>
                                    </div>
                                </div>
                                <div class="common-form-line ">
                                    <div class="common-form-label">
                                        签名
                                    </div>
                                    <div class="common-input ">
                                        <input type="text" name="signature" placeholder="可以是职业或教育经历介绍，也可以是个性宣言~" data-rule-islegalcharacter="true" value="">
                                    </div>
                                </div>
                            </div>
                            <div class="basic-info-box fl">
                                <div class="common-form-line">
                                    <div class="common-form-label clearfix">
                                        <span class="fl">头像</span><span class="pour fr">注：仅支持JPG、GIF、PNG格式的图片文件，小于2MB</span>
                                    </div>
                                    <div class="common-input">
                                        <div class="photo-box clearfix">
                                            <div class="load-photo-box w-172 fl">
                                                <div class="load-photo-link-box">
                                                    <a href="" class="load-photo-link img-160">
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
                                                    <a href="" class="load-photo-link img-70">
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
                                        <input type="hidden" id="userHeadImgInp">
                                        <input type="hidden" id="key" value="avatar/201612/12/sk584e4e00bc18d6.00420280">
                                        <input type="hidden" id="token" value="46x3OhwgfdjmtwaNFhPiQEvs948gtMKKJbjXlvKr:cduMD_FQw-QlaEnnetolF5EuQ58=:eyJkZWFkbGluZSI6MTQ4MTUzMDM4NCwic2NvcGUiOiJzYWlrci1wdWJsaWMifQ==">
                                        <input type="hidden" id="qn_url" name="qn_url" value="http://publicqn.saikr.com/">
                                    </div>
                                </div>
                            </div>
                        </div>
                        
                        <div class="sk-btn-box">
                            <input type="submit" value="保存" class="sk-btn sk-btn-green">
                            <input type="reset" value="取消" class="sk-btn cancle">
                            <div class="success-tip js_success_tip">保存成功</div>
                        </div>
                    </form> 
                </div>
                
                
                <!-- 教育经历 -->
                
                <div class="sk-user-info-list" id="userEduInfoList">

                                        <div class="item js_item">
                        <div class="item-con js_user_info_show_box">
                            <div class="item-info">
                               
                                <div class="item-title">
                                </div>
                                <div class="item-sub-title clearfix">
                                    
                                    <div class="fr">-</div>
                                </div>
                            </div>
                        </div>
                        <form action="/s/e" method="post" id="userEduInfoForm_0" class="sk-user-info-set-form js_user_info_set_form hide" novalidate="novalidate">
                            <input type="hidden" name="edu_id" value="0">
                            <div class="cy-common-form-line-box clearfix">
                                <div class="common-form-line fl">
                                    <div class="common-form-label clearfix">
                                        <span class="star-tip fl">学校</span>
                                    </div>
                                    <div class="common-input">
                                        <input type="text" class="js_school_pop_open" id="eduSchool_0" name="school" readonly="readonly" data-rule-required="true" data-msg-required="请输入学校或教育机构" data-rule-islegalcharacter="true" placeholder="学校或教育机构" value="宁波工程学院" aria-required="true">
                                    </div>
                                </div>
                                <div class="common-form-line fl">
                                    <div class="common-form-label clearfix">
                                        <span class="star-tip fl">专业</span>
                                    </div>
                                    <div class="common-input">
                                        <input type="text" name="major" data-rule-required="true" data-msg-required="请输入专业方向" data-rule-islegalcharacter="true" placeholder="专业方向" value="" aria-required="true">
                                    </div>
                                </div>
                                <div class="common-form-line fl datetime js_datetimepicker_box">
                                    <div class="common-form-label clearfix">
                                        <span class="star-tip fl">起止时间</span>
                                        <label class="fr clearfix common-checkbox-box">
                                            <div class="fl js_rc_input">
                                                <div class="icheckbox" style="position: relative;"><input type="checkbox" name="is_at_school" class="js_at_school_checkbox" style="position: absolute; top: -20%; left: -20%; display: block; width: 140%; height: 140%; margin: 0px; padding: 0px; background: rgb(255, 255, 255); border: 0px; opacity: 0;"><ins class="iCheck-helper" style="position: absolute; top: -20%; left: -20%; display: block; width: 140%; height: 140%; margin: 0px; padding: 0px; background: rgb(255, 255, 255); border: 0px; opacity: 0;"></ins></div>
                                            </div>
                                            <div class="fl common-checkbox-label">目前仍然在读</div>
                                        </label>
                                    </div>
                                    <div class="fl common-input">
                                        <input type="text" name="start_time" data-rule-required="true" data-msg-required="请输入开始时间" data-rule-islegalcharacter="true" placeholder="开始时间" readonly="readonly" class="js_startTime hasDatepicker" value="" aria-required="true" id="dp1481526784110">
                                    </div>
                                    <div class="fr common-input">
                                        <input type="text" name="end_time" data-rule-required="true" data-msg-required="请输入结束时间" data-rule-islegalcharacter="true" placeholder="结束时间" readonly="readonly" class="js_endTime hasDatepicker" value="" aria-required="true" id="dp1481526784108">
                                    </div>
                                </div>
                                <div class="common-form-line fl">
                                    <div class="common-form-label clearfix">
                                        <span class="star-tip fl">学历</span>
                                    </div>
                                    <div class="dropdown">
                                        <div class="common-select dropdown-toggle" data-toggle="dropdown">
                                            <em class="select-value">未设置</em>
                                            <input type="hidden" name="degree" value="0">
                                            <span class="common-icon arrow-icon"></span>
                                        </div>
                                        <ul class="dropdown-menu" role="menu">
                                                                                        <li role="presentation">
                                                <a href="javascript:;" role="menuitem" value="5" class="dropdown-option">
                                                    专科                                                </a>
                                            </li>
                                                                                        <li role="presentation">
                                                <a href="javascript:;" role="menuitem" value="6" class="dropdown-option">
                                                    本科                                                </a>
                                            </li>
                                                                                        <li role="presentation">
                                                <a href="javascript:;" role="menuitem" value="7" class="dropdown-option">
                                                    硕士                                                </a>
                                            </li>
                                                                                        <li role="presentation">
                                                <a href="javascript:;" role="menuitem" value="8" class="dropdown-option">
                                                    博士                                                </a>
                                            </li>
                                                                                        <li role="presentation">
                                                <a href="javascript:;" role="menuitem" value="9" class="dropdown-option">
                                                    其他                                                </a>
                                            </li>
                                                                                    </ul>
                                    </div>
                                </div>
                            </div>
                            <div class="sk-btn-box">
                                <input type="submit" value="保存" class="sk-btn sk-btn-green">
                                <input type="reset" value="取消" class="sk-btn cancle">
                                                                <div class="success-tip js_success_tip">保存成功</div>
                            </div>
                        </form>
                    </div>
                                    </div>
                
                <div class="sk-user-info-list award" id="userAwardInfoList">
                                    </div>
            </div>
        </div>
    </div>
</div>

<div class="pop-box pop-modal mtv-pop-box sk-school-pop js_pop_modal" id="selectSchoolPop">
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
            <!--<li class="mtv-set-scl-item js_school_item">清华大学</li>
            <li class="mtv-set-scl-item js_school_item">北京大学</li>
            <li class="mtv-set-scl-item js_school_item">清华大学</li>-->
        </ul>
        <!-- 空内容提示 -->
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
</div>
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


<!-- 底部 -->
 <div style="margin-top:60px;">
<jsp:include page="../common/end.jsp"></jsp:include>
</div>
</body>
</html>