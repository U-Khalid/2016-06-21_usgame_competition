package cn.usgame.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.AlibabaAliqinFcSmsNumSendRequest;
import com.taobao.api.response.AlibabaAliqinFcSmsNumSendResponse;

import cn.usgame.entity.Administrator;
import cn.usgame.entity.ApplyReport;
import cn.usgame.entity.Camp;
import cn.usgame.entity.CampApply;
import cn.usgame.entity.Competition;
import cn.usgame.entity.SMS;
import cn.usgame.entity.Train;
import cn.usgame.entity.TrainApply;
import cn.usgame.entity.Train_Subject;
import cn.usgame.entity.User;
import cn.usgame.entity_dto.UserForm;
import cn.usgame.filter.MyResponseWrapper;
import cn.usgame.filter.MyResquestWrapper;
import cn.usgame.service.ServiceFactory;
import cn.usgame.service.UserService;
import cn.usgame.utils.MD5;

@WebServlet("/UserServlet")
public class UserServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 1. 手机号码
	 * 2. 验证码
	 * 3. 生成时间
	 */
	private static Map<String, String> map = new HashMap<String, String>();
	
	/**
	 * 用户业务层对象
	 */
	private UserService userService = ServiceFactory.getInstance().getUserManage();
    
	
	/**
	 * 函数名称：register
	 * 功能描述：用户注册
	 * 参数说明：
	 * 返回值：void
	 * 备注：
	 * 
	 * @throws SQLException 
	 * @throws IOException 
	 */
	public void register(MyResquestWrapper request, MyResponseWrapper response) throws SQLException, IOException {
		
		String phonenumber = request.getParameter("phone");
		String password = request.getParameter("password");
		String SMSNumber = request.getParameter("yanzhengma");
		MD5 md5 = new MD5();
		password = md5.MD5Encode(password,"utf-8");
		System.out.println("Servlet:"+SMSNumber);
		UUID uuid = UUID.randomUUID();
		String id = uuid.toString();
		UserForm userform = new UserForm();
		JsonObject out_json = new JsonObject();
//		Map<String, String[]> map = request.getParameterMap();
//		UserForm user = new UserForm(map);
		int judge = userService.IsQualifiedSMS(phonenumber, SMSNumber);
		if (judge==1) {
			boolean flag = userform.judgePhone(phonenumber);
			if(flag) {
				boolean result = userService.registerUser(id,phonenumber,password);
				if(result) {
					User user = userService.login(phonenumber, password);
					HttpSession session = request.getSession();
					session.setAttribute("user", user); // 设置Session
					session.setMaxInactiveInterval(24 * 60 * 60); // 设置session为24小时
					
					//设置cookie
					String userHistory = phonenumber;    //  3_2
					Cookie cookie = new Cookie("UserHistory",userHistory);
					cookie.setMaxAge(1*30*24*3600);
					response.addCookie(cookie);
					
					out_json.addProperty("msg", true);
					out_json.addProperty("other", "注册成功");
				}
				else {
					out_json.addProperty("msg", true);
					out_json.addProperty("other", "注册失败");
				}
			}
			else {
				out_json.addProperty("msg", false);
				out_json.addProperty("other", "手机号码不合法！");
			}
		}
		else if(judge == 2) {
			out_json.addProperty("msg", false);
			out_json.addProperty("other", "验证码错误！");
		}
		else if(judge == 3) {
			out_json.addProperty("msg", false);
			out_json.addProperty("other", "验证超时！");
		}
		else {
			out_json.addProperty("msg", false);
			out_json.addProperty("other", "请先获取验证码！");
		}
		out_json.add("data", null);
		PrintWriter out = response.getWriter();
		out.println(out_json);
		out.flush();
		out.close();
	}
	
	/**
	 * 函数名称：Web_register
	 * 功能描述：用户注册
	 * 参数说明：
	 * 返回值：void
	 * 备注：
	 * 
	 * @throws SQLException 
	 * @throws IOException 
	 */
	public void Web_register(MyResquestWrapper request, MyResponseWrapper response) throws SQLException, IOException ,ServletException{
		
		String phonenumber = request.getParameter("regname");
		String password = request.getParameter("regpass");
		String SMSNumber = request.getParameter("regcode");
		if(phonenumber.equals("")||phonenumber==""){
			request.setAttribute("message", "手机号码不能为空");
			request.getRequestDispatcher("/Web_V3/reg/reg.jsp").forward(request, response);
		}
		else{
			request.setAttribute("phone", phonenumber);
		}
		if(password.equals("")||password==""){
			request.setAttribute("message", "密码不能为空");
			request.getRequestDispatcher("/Web_V3/reg/reg.jsp").forward(request, response);
		}else {
			request.setAttribute("pw", password);
		}
		if(SMSNumber.equals("")||SMSNumber==""){
			request.setAttribute("message", "验证码不能为空");
			request.getRequestDispatcher("/Web_V3/reg/reg.jsp").forward(request, response);
		}
		if(!phonenumber.equals("")&&!password.equals("")&&!SMSNumber.equals("")) {
		MD5 md5 = new MD5();
		password = md5.MD5Encode(password,"utf-8");
		//System.out.println("Servlet:"+SMSNumber+"phone:"+phonenumber+"password:"+password);
		UUID uuid = UUID.randomUUID();
		String id = uuid.toString();
		UserForm userform = new UserForm();
//		Map<String, String[]> map = request.getParameterMap();
//		UserForm user = new UserForm(map);
		boolean flag = userform.judgePhone(phonenumber);
		if(flag) {
		int judge = userService.IsQualifiedSMS(phonenumber, SMSNumber);   
			if (judge==1) {
					boolean result = userService.registerUser(id,phonenumber,password);
					if(result) {
						User user = userService.login(phonenumber, password);
						HttpSession session = request.getSession();
						session.setAttribute("user", user); // 设置Session
						session.setMaxInactiveInterval(24 * 60 * 60); // 设置session为24小时
						
						//设置cookie
						String userHistory = phonenumber;    //  3_2
						Cookie cookie = new Cookie("UserHistory",userHistory);
						cookie.setMaxAge(1*30*24*3600);
						response.addCookie(cookie);
						
						request.setAttribute("msg", true);
						request.setAttribute("message", "注册成功");
						//跳转首页
						response.sendRedirect(request.getContextPath()+"/Web_V3/Main/main.jsp");
					}
					else {
						request.setAttribute("msg", false);
						request.setAttribute("message", "注册失败");
						request.getRequestDispatcher("/Web_V3/reg/reg.jsp").forward(request, response);
						//response.sendRedirect(request.getContextPath()+"/Web_V3/reg/reg.jsp");
					}
				}
			
			else if(judge == 2) {
				request.setAttribute("msg", false);
				request.setAttribute("message", "验证码错误！");
				request.getRequestDispatcher("/Web_V3/reg/reg.jsp").forward(request, response);
				//response.sendRedirect(request.getContextPath()+"/Web_V3/reg/reg.jsp");
			}
			else if(judge == 3) {
				request.setAttribute("msg", false);
				request.setAttribute("message", "验证超时！");
				request.getRequestDispatcher("/Web_V3/reg/reg.jsp").forward(request, response);
				//response.sendRedirect(request.getContextPath()+"/Web_V3/reg/reg.jsp");
			}
			else {
				request.setAttribute("msg", false);
				request.setAttribute("message", "请先获取验证码！");
				request.getRequestDispatcher("/Web_V3/reg/reg.jsp").forward(request, response);
				//response.sendRedirect(request.getContextPath()+"/Web_V3/reg/reg.jsp");
				}
		  }
		else {
			request.setAttribute("msg", false);
			request.setAttribute("message", "手机号码不合法！");
			request.getRequestDispatcher("/Web_V3/reg/reg.jsp").forward(request, response);
			//response.sendRedirect(request.getContextPath()+"/Web_V3/reg/reg.jsp");
			}
		
		}
	}
	/**
	 * 函数名称：login
	 * 功能描述：用户登录
	 * 参数说明：
	 * 返回值：void
	 * 备注：
	 * 
	 * @throws SQLException 
	 * @throws IOException 
	 */
	public void login(MyResquestWrapper request, MyResponseWrapper response) throws SQLException, IOException {
		String phonenumber = request.getParameter("phone");
		String password = request.getParameter("password");
		MD5 md5 = new MD5();
		password = md5.MD5Encode(password,"utf-8");
		JsonObject out_json = new JsonObject();
		JsonObject jsonData = new JsonObject();
		
		User user = userService.login(phonenumber,password);
		if(user!=null) {
			jsonData = user.toJSON();
			HttpSession session = request.getSession();
			session.setAttribute("user", user); // 设置Session
			session.setMaxInactiveInterval(24 * 60 * 60); // 设置session为24小时
			//设置cookie
			String userHistory = phonenumber;    //  3_2
			Cookie cookie = new Cookie("UserHistory",userHistory);
			cookie.setMaxAge(1*30*24*3600);
			response.addCookie(cookie);
			out_json.add("data", jsonData);
			out_json.addProperty("msg", true);
		}
		else {
			out_json.add("data", null);
			out_json.addProperty("msg", false);
		}
		PrintWriter out = response.getWriter();
		out.println(out_json);
		out.flush();
		out.close();
	}
	
	/**
	 * 函数名称：login
	 * 功能描述：用户登录
	 * 参数说明：
	 * 返回值：void
	 * 备注：
	 * 
	 * @throws SQLException 
	 * @throws IOException 
	 */
	public void Web_login(MyResquestWrapper request, MyResponseWrapper response) throws SQLException, IOException {
		String phonenumber = request.getParameter("name");
		String password = request.getParameter("pass");
		MD5 md5 = new MD5();
		password = md5.MD5Encode(password,"utf-8");
		User user = userService.login(phonenumber,password);
		if(user!=null) {
			HttpSession session = request.getSession();
			session.setAttribute("user", user); // 设置Session
			session.setMaxInactiveInterval(24 * 60 * 60); // 设置session为24小时
			//设置cookie
			String userHistory = phonenumber;    //  3_2
			Cookie cookie = new Cookie("UserHistory",userHistory);
			cookie.setMaxAge(1*30*24*3600);
			response.addCookie(cookie);
			//跳转首页
			//System.out.println(request.getContextPath()+"/Web_V3"+Website+location);
			//response.sendRedirect(request.getContextPath()+"/Web_V3"+Website+location);
			response.sendRedirect(request.getContextPath()+"/Web_V3/Main/main.jsp");
		}
		else {
			//跳转登录页面
			response.sendRedirect(request.getContextPath()+"/Web_V3/login/login.jsp");
		}
	}

	/**
	 * 函数名称：getUserInfo
	 * 功能描述：获取个人信息
	 * 参数说明：
	 * 返回值：void
	 * 备注：
	 * 
	 * @throws SQLException 
	 * @throws IOException 
	 */
	public void getUserInfo(MyResquestWrapper request, MyResponseWrapper response) throws SQLException, IOException {
		HttpSession session = request.getSession();
		User us = (User) session.getAttribute("user");
		
		JsonObject out_json = new JsonObject();
		JsonObject jsonData = new JsonObject();
		
		if(us!=null) {
			jsonData = us.toJSON();
			out_json.addProperty("msg", true);
			out_json.add("data", jsonData);
		}
		else {
			out_json.addProperty("msg", false);
			out_json.add("data", null);
		}
		
		PrintWriter out = response.getWriter();
		out.println(out_json);
		out.flush();
		out.close();
	}
	/**
	 * 函数名称：toUser
	 * 功能描述：保存个人信息
	 * 参数说明：
	 * 返回值：void
	 * 备注：
	 * 
	 * @throws SQLException 
	 * @throws IOException 
	 */
	public void toUser(MyResquestWrapper request, MyResponseWrapper response) throws SQLException, IOException {
		
		
//		String name = request.getParameter("name");
//		String sex = request.getParameter("sex");
//		String school = request.getParameter("school");
//		String grade = request.getParameter("grade");
//		String contactNumber = request.getParameter("contactNumber");
//		String iDcard = request.getParameter("iDcard");
//		String address = request.getParameter("address");
//		String motto = request.getParameter("motto");
//		String phonenumber = request.getParameter("phonenumber");
		
		Map<String, String[]> map = request.getParameterMap();
		UserForm userform = new UserForm(map);
		
		boolean sexflag = userform.judgeSex();
		boolean iDcardflag = userform.judgeiDcard();
		JsonObject out_json = new JsonObject();
		
		if(sexflag&&iDcardflag) {
			User user = userform.toUser();
			boolean result = userService.toUser(user);
			if(result) {
				HttpSession session = request.getSession();
				session.setAttribute("user", user); // 设置Session
				session.setMaxInactiveInterval(24 * 60 * 60); // 设置session为24小时
				
				//设置cookie
				String userHistory = user.getPhonenumber();    //  3_2
				Cookie cookie = new Cookie("UserHistory",userHistory);
				cookie.setMaxAge(1*30*24*3600);
				response.addCookie(cookie);
				
				out_json.addProperty("msg", true);
			}
			else {
				out_json.addProperty("msg", false);
			}
		}
		else {
			out_json.addProperty("msg", false);
			//未完待续
			out_json.addProperty("other", "格式不对");
		}
		PrintWriter out = response.getWriter();
		out.println(out_json);
		out.flush();
		out.close();
	}
	
	/**
	 * 函数名称：toUser
	 * 功能描述：保存个人信息
	 * 参数说明：
	 * 返回值：void
	 * 备注：
	 * 
	 * @throws SQLException 
	 * @throws IOException 
	 *//*
	public void Web_toUser(MyResquestWrapper request, MyResponseWrapper response) throws SQLException, IOException {
		System.out.println("111");
		String name = request.getParameter("name");
		String sex = request.getParameter("sex");
		String school = request.getParameter("school");
		String grade = request.getParameter("grade");
		String iDcard = request.getParameter("iDcard");
		String address = request.getParameter("address");
		String motto = request.getParameter("motto");
		String phonenumber = request.getParameter("phonenumber");
		
		UserForm userform = new UserForm(phonenumber,name,sex,school,grade,iDcard,address,motto);
		
		System.out.println("---"+userform.toUser().toJSON());
		boolean sexflag = userform.judgeSex();
		boolean iDcardflag = userform.judgeiDcard();
		JsonObject out_json = new JsonObject();
		
		if(sexflag&&iDcardflag) {
			User user = userform.toUser();
			boolean result = userService.toUser(user);
			if(result) {
				HttpSession session = request.getSession();
				session.setAttribute("user", user); // 设置Session
				session.setMaxInactiveInterval(24 * 60 * 60); // 设置session为24小时
				
				//设置cookie
				String userHistory = user.getPhonenumber();    //  3_2
				Cookie cookie = new Cookie("UserHistory",userHistory);
				cookie.setMaxAge(1*30*24*3600);
				response.addCookie(cookie);
				response.sendRedirect(request.getContextPath()+"/Web_V3/User/editInfo.jsp?msg=true");
				//out_json.addProperty("msg", true);
			}
			else {
				response.sendRedirect(request.getContextPath()+"/Web_V3/User/editInfo.jsp?msg=false");
				//out_json.addProperty("msg", false);
			}
		}
		else {
			response.sendRedirect(request.getContextPath()+"/Web_V3/User/editInfo.jsp?msg=false");
			//out_json.addProperty("msg", false);
			//未完待续
			//out_json.addProperty("other", "格式不对");
		}
		PrintWriter out = response.getWriter();
		out.println(out_json);
		out.flush();
		out.close();
	}*/
	/**
	 * 函数名称：logout
	 * 功能描述：
	 * 参数说明：
	 * 返回值：void
	 * 备注：
	 * 
	 */
	public void logout(MyResquestWrapper request, MyResponseWrapper response) throws SQLException, IOException{
		request.getSession().removeAttribute("user");
        request.getSession().invalidate();
        HttpSession session = request.getSession();
		User us = (User) session.getAttribute("user");
		JsonObject out_json = new JsonObject();
		if (us==null) {
			out_json.addProperty("msg", true);
		} else {
			out_json.addProperty("msg", false);
		}
		PrintWriter out = response.getWriter();
		out.println(out_json);
		out.flush();
		out.close();
	}
	
	/**
	 * 函数名称：changepw
	 * 功能描述：修改密码
	 * 参数说明：
	 * 返回值：void
	 * 备注：
	 * 
	 */
	public void changepw(MyResquestWrapper request, MyResponseWrapper response) throws SQLException, IOException{
		JsonObject out_json = new JsonObject();
		HttpSession session = request.getSession();
		User us = (User) session.getAttribute("user");
		String old_pw = request.getParameter("old_pw");
		String new_pw = request.getParameter("new_pw");
		MD5 md5 = new MD5();
		old_pw = md5.MD5Encode(old_pw,"utf-8");
		new_pw = md5.MD5Encode(new_pw,"utf-8");
		boolean result = false;
		if(old_pw.equals(us.getPassword())) {
			result = userService.changepw(new_pw,us.getPhonenumber());
		}else {
			out_json.addProperty("msg", false);
			out_json.addProperty("other", "原密码错误！");
		}
		if (result) {
			out_json.addProperty("msg", true);
			out_json.addProperty("other", "修改成功！");
		} else {
			out_json.addProperty("msg", false);
			out_json.addProperty("other", "修改失败！");
		}
		PrintWriter out = response.getWriter();
		out.println(out_json);
		out.flush();
		out.close();
	}
	
	/**
	 * 
	 * 函数名称：CAPTCHA
	 * 功能描述：发送验证码
	 * 参数说明：
	 * 返回值：void
	 * 备注：
	 * 
	 */
	public void RCAPTCHA(MyResquestWrapper request, MyResponseWrapper response) throws IOException {
		String phoneNumber = request.getParameter("phone");
		//System.out.println(phoneNumber);
		JsonObject out_json = new JsonObject();
		UserForm userForm = new UserForm();
		userForm.setPhonenumber(phoneNumber);
		boolean result = userForm.judgePhone(phoneNumber);
		//System.out.println("1111"+result);
		if(result==true) {
			boolean flag = userService.testPhone(phoneNumber);
			if(flag==true) {
				out_json.addProperty("other","联系号码已被使用！");
				out_json.addProperty("msg", false);
			}
			else {
				int lifecycle = 60; // 周期为60秒
				SimpleDateFormat d = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String nowtime = d.format(new Date());
				// 2. 发送短信
				String SMSNumber = SendCheckNumber(phoneNumber);

				if (!("").equals(SMSNumber)) {
					SMS sms = new SMS(phoneNumber,SMSNumber,nowtime,lifecycle);
					boolean result1 = userService.pushSMS(sms);
//					
					out_json.addProperty("other", "验证码发送成功");
					out_json.addProperty("msg", result1);

				} else {
					out_json.addProperty("other", "验证码发送失败");
				}
			}
		}
		else {
			out_json.addProperty("other","手机号码格式有误！");
			out_json.addProperty("msg", false);
		}
		out_json.add("data", null);
		PrintWriter out = response.getWriter();
		out.println(out_json);
		out.flush();
		out.close();
	}
	

	private String SendCheckNumber(String phoneNumber) {
		boolean flag = false;
		String SMSNumber = null;
		// 阿里大鱼短信服务器地址
		String url = "http://gw.api.taobao.com/router/rest";
		// 阿里大鱼应用密钥
		String appkey = "23317766";
		// 阿里大鱼...
		String secret = "793012aac1dffea9b8a4900c5eeb8c80";

		TaobaoClient client = new DefaultTaobaoClient(url, appkey, secret);

		AlibabaAliqinFcSmsNumSendRequest req = new AlibabaAliqinFcSmsNumSendRequest();
		
		req.setExtend("123456");
		req.setSmsType("normal");
		req.setSmsFreeSignName("优赛乐学");

		SMSNumber = CreateAndReturnASecurityNumber();
		// {"code":"1234","product":"alidayu"}
		req.setSmsParamString("{\"code\":" + "'" + SMSNumber + "'" + "," + "\"product\":\"优赛乐学\",\"item\":\"优赛乐学\"}");
		// 目标手机号
		req.setRecNum(phoneNumber);
		// 短信模版
		req.setSmsTemplateCode("SMS_5250341");
		AlibabaAliqinFcSmsNumSendResponse rsp;
		try {
			rsp = client.execute(req);
			flag = true;
//			System.out.println(rsp.getBody());
		} catch (ApiException e) {
			SMSNumber = null;
			e.printStackTrace();
		}
		return SMSNumber;
	}

	private String CreateAndReturnASecurityNumber() {
		String SecurityNumber = "";
		for (int i = 0; i < 6; i++) {
			java.util.Random random = new java.util.Random();	// 定义随机类
			int result = random.nextInt(10);		// 返回[0,10)集合中的整数，注意不包括10
			SecurityNumber = SecurityNumber + Integer.toString(result);
		}
		return SecurityNumber;
	}
	
	/**
	 * 
	 * 函数名称：getUserCompetition
	 * 功能描述：获得用户报名的比赛
	 * 参数说明：
	 * 返回值：void
	 * 备注：
	 * 
	 */
	public void getUserCompetition(MyResquestWrapper request, MyResponseWrapper response) throws SQLException, IOException {
		JsonObject out_json = new JsonObject();
		JsonArray jsonData = new JsonArray();
		HttpSession session = request.getSession();
		User us = (User) session.getAttribute("user");
		if(us!=null) {
			List<ApplyReport> applyreports = userService.getUserCompetition(us.getPhonenumber());
			for (int i = 0; i < applyreports.size(); i++) {
				jsonData.add(applyreports.get(i).toJSON());
			}
			out_json.add("data", jsonData);
		}
		PrintWriter out = response.getWriter();
		out.println(out_json);
		out.flush();
		out.close();
	}
	
	/**
	 * 
	 * 函数名称：getUserCompetition
	 * 功能描述：获得用户报名的营地
	 * 参数说明：
	 * 返回值：void
	 * 备注：
	 * 
	 */
	public void getUserCamp(MyResquestWrapper request, MyResponseWrapper response) throws SQLException, IOException {
		JsonObject out_json = new JsonObject();
		JsonArray jsonData = new JsonArray();
		HttpSession session = request.getSession();
		User us = (User) session.getAttribute("user");
		if(us!=null) {
			List<CampApply> campapply = userService.getUserCamp(us.getPhonenumber());
			for (int i = 0; i < campapply.size(); i++) {
				jsonData.add(campapply.get(i).toJSON());
			}
			out_json.add("data", jsonData);
		}
		PrintWriter out = response.getWriter();
		out.println(out_json);
		out.flush();
		out.close();
	}
	
	
	/**
	 * 
	 * 函数名称：getUserTrain
	 * 功能描述：获得用户报名的培训
	 * 参数说明：
	 * 返回值：void
	 * 备注：
	 */
	public void getUserTrain(MyResquestWrapper request, MyResponseWrapper response) throws SQLException, IOException {
		JsonObject out_json = new JsonObject();
		JsonArray jsonData = new JsonArray();
		HttpSession session = request.getSession();
		User us = (User) session.getAttribute("user");
		if(us!=null) {
			List<TrainApply> trainapply = userService.getUserTrain(us.getPhonenumber());
			for (int i = 0; i < trainapply.size(); i++) {
				jsonData.add(trainapply.get(i).toJSON());
			}
			out_json.add("data", jsonData);
		}
		PrintWriter out = response.getWriter();
		out.println(out_json);
		out.flush();
		out.close();
	}
	
	/**
	 * 
	 * 函数名称：applyreportInfo
	 * 功能描述：获得特定报名比赛的详情
	 * 参数说明：
	 * 返回值：void
	 * 备注：
	 * 
	 */
	public void applyreportInfo(MyResquestWrapper request, MyResponseWrapper response) throws SQLException, IOException {
		String applyReportId = request.getParameter("applyReportId");
		JsonObject jsonData = new JsonObject();
		JsonObject out_json = new JsonObject();
		HttpSession session = request.getSession();
		User us = (User) session.getAttribute("user");
		ApplyReport applyreport = userService.applyreportInfo(us.getPhonenumber(),applyReportId);
		jsonData=applyreport.toJSON();
		out_json.add("data", jsonData);
		PrintWriter out = response.getWriter();
		out.println(out_json);
		out.flush();
		out.close();
	}
	/**
	 * 
	 * 函数名称：getAdministratorList
	 * 功能描述：获得管理员列表
	 * 参数说明：
	 * 返回值：void
	 * 备注：
	 * 
	 */
	public void getAdministratorList(MyResquestWrapper request, MyResponseWrapper response) throws SQLException, IOException {
		int page = Integer.parseInt(request.getParameter("page"));
		JsonObject out_json = new JsonObject();
		JsonArray jsonData = new JsonArray();
		List<Administrator> administrators = userService.getAllAdministrator(page);
		String total = userService.getAdministratorNum();
		for (int i = 0; i < administrators.size(); i++) {
			jsonData.add(administrators.get(i).toJSON());
		}
		out_json.addProperty("total", total);
		out_json.add("rows", jsonData);
		PrintWriter out = response.getWriter();
		out.println(out_json);
		out.flush();
		out.close();
	}
	
	/**
	 * 函数名称：Administratorlogin
	 * 功能描述：管理员登录
	 * 参数说明：
	 * 返回值：void
	 * 备注：
	 * 
	 * @throws SQLException 
	 * @throws IOException 
	 */
	public void Administratorlogin(MyResquestWrapper request, MyResponseWrapper response) throws SQLException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		MD5 md5 = new MD5();
		password = md5.MD5Encode(password,"utf-8");
		JsonObject out_json = new JsonObject();
		JsonObject jsonData = new JsonObject();

		Administrator administrator = userService.Administratorlogin(username,password);
		if(administrator!=null) {
			jsonData = administrator.toJSON();
			HttpSession session = request.getSession();
			session.setAttribute("administrator", administrator); // 设置Session
			session.setMaxInactiveInterval(24 * 60 * 60); // 设置session为24小时
			//设置cookie
//			String userHistory = username;    //  3_2
//			Cookie cookie = new Cookie("UserHistory",userHistory);
//			cookie.setMaxAge(1*30*24*3600);
//			response.addCookie(cookie);
			out_json.add("data", jsonData);
			out_json.addProperty("msg", true);
		}
		else {
			out_json.add("data", null);
			out_json.addProperty("msg", false);
		}
		PrintWriter out = response.getWriter();
		out.println(out_json);
		out.flush();
		out.close();
	}
	
	/**
	 * 
	 * 函数名称：CAPTCHA
	 * 功能描述：发送验证码
	 * 参数说明：
	 * 返回值：void
	 * 备注：
	 * 
	 */
	public void sentCode(MyResquestWrapper request, MyResponseWrapper response) throws IOException {
		String phoneNumber = request.getParameter("phone");
		
		System.out.println(phoneNumber);
		UserForm userForm = new UserForm();
		JsonObject out_json = new JsonObject();
		userForm.setPhonenumber(phoneNumber);
		boolean result = userForm.judgePhone(phoneNumber);
		System.out.println(result);
		if(result==true) {
			boolean flag = userService.testPhone(phoneNumber);
			if(flag==true) {
				int lifecycle = 60; // 周期为60秒
				SimpleDateFormat d = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String nowtime = d.format(new Date());
				// 2. 发送短信
				String SMSNumber = SendPWCheckNumber(phoneNumber);
				if (!("").equals(SMSNumber)) {
					SMS sms = new SMS(phoneNumber,SMSNumber,nowtime,lifecycle);
					boolean result1 = userService.pushSMS(sms);
					out_json.addProperty("other", "验证码发送成功");
					out_json.addProperty("msg", result1);
					
				} else {
					out_json.addProperty("other", "验证码发送失败");
				}
			}
			else {
				out_json.addProperty("other","该号码尚未注册，请先注册！");
				out_json.addProperty("msg", false);
			}
		}
		else {
			out_json.addProperty("other","联系号码格式有误！");
			out_json.addProperty("msg", false);
		}
		out_json.add("data", null);
		PrintWriter out = response.getWriter();
		out.println(out_json);
		out.flush();
		out.close();
	}
	
	private String SendPWCheckNumber(String phoneNumber) {
		boolean flag = false;
		String SMSNumber = null;
		// 阿里大鱼短信服务器地址
		String url = "http://gw.api.taobao.com/router/rest";
		// 阿里大鱼应用密钥
		String appkey = "23317766";
		// 阿里大鱼...
		String secret = "793012aac1dffea9b8a4900c5eeb8c80";

		TaobaoClient client = new DefaultTaobaoClient(url, appkey, secret);

		AlibabaAliqinFcSmsNumSendRequest req = new AlibabaAliqinFcSmsNumSendRequest();

		req.setExtend("123456");
		req.setSmsType("normal");
		req.setSmsFreeSignName("优赛乐学");

		SMSNumber = CreateAndReturnASecurityNumber();
		// {"code":"1234","product":"alidayu"}
		req.setSmsParamString("{\"code\":" + "'" + SMSNumber + "'" + "," + "\"product\":\"优赛乐学\"}");
		// 目标手机号
		req.setRecNum(phoneNumber);
		// 短信模版
		req.setSmsTemplateCode("SMS_25370239");

		AlibabaAliqinFcSmsNumSendResponse rsp;
		try {
			rsp = client.execute(req);
			flag = true;
//			System.out.println(rsp.getBody());
		} catch (ApiException e) {
			SMSNumber = null;
			e.printStackTrace();
		}
		return SMSNumber;
	}
	
	public void Setpw(MyResquestWrapper request, MyResponseWrapper response) throws SQLException, IOException {
			
			String phonenumber = request.getParameter("phone");
			String password = request.getParameter("password");
			MD5 md5 = new MD5();
			password = md5.MD5Encode(password,"utf-8");
			String SMSNumber = request.getParameter("yanzhengma");
			UserForm userform = new UserForm();
			JsonObject out_json = new JsonObject();
	//		Map<String, String[]> map = request.getParameterMap();
	//		UserForm user = new UserForm(map);
			int judge = userService.IsQualifiedSMS(phonenumber, SMSNumber);
			if (judge==1) {//验证成功
				boolean flag = userform.judgePhone(phonenumber);
				if(flag) {
					boolean result = userService.Setpw(phonenumber,password);
					if(result) {
						out_json.addProperty("msg", true);
						out_json.addProperty("other", "重置成功");
					}
					else {
						out_json.addProperty("msg", true);
						out_json.addProperty("other", "重置失败");
					}
				}
				else {
					out_json.addProperty("msg", false);
					out_json.addProperty("other", "手机号码不合法！");
				}
			}
			else if(judge == 2) {
				out_json.addProperty("msg", false);
				out_json.addProperty("other", "验证码错误！");
			}
			else if(judge == 3) {
				out_json.addProperty("msg", false);
				out_json.addProperty("other", "验证超时！");
			}
			else {
				out_json.addProperty("msg", false);
				out_json.addProperty("other", "请先获取验证码！");
			}
			out_json.add("data", null);
			PrintWriter out = response.getWriter();
			out.println(out_json);
			out.flush();
			out.close();
		}
	
	/**
	 * 
	 * 函数名称：applyreportInfo
	 * 功能描述：获得特定报名比赛的详情
	 * 参数说明：
	 * 返回值：void
	 * 备注：
	 * 
	 */
	public void deleteapplyreport(MyResquestWrapper request, MyResponseWrapper response) throws SQLException, IOException {
		String applyReportId = request.getParameter("applyReportId");
		JsonObject out_json = new JsonObject();
		HttpSession session = request.getSession();
		User us = (User) session.getAttribute("user");
		boolean result = userService.deleteapplyreport(us.getPhonenumber(),applyReportId);
		out_json.addProperty("msg", result);
		PrintWriter out = response.getWriter();
		out.println(out_json);
		out.flush();
		out.close();
	}
	
	public void deletecampapply(MyResquestWrapper request, MyResponseWrapper response) throws SQLException, IOException {
		String applyReportId = request.getParameter("applyReportId");
		JsonObject out_json = new JsonObject();
		HttpSession session = request.getSession();
		User us = (User) session.getAttribute("user");
		boolean result = userService.deletecampapply(us.getPhonenumber(),applyReportId);
		out_json.addProperty("msg", result);
		PrintWriter out = response.getWriter();
		out.println(out_json);
		out.flush();
		out.close();
	}
	
	public void deletetrainapply(MyResquestWrapper request, MyResponseWrapper response) throws SQLException, IOException {
		String applyReportId = request.getParameter("applyReportId");
		JsonObject out_json = new JsonObject();
		HttpSession session = request.getSession();
		User us = (User) session.getAttribute("user");
		boolean result = userService.deletetrainapply(us.getPhonenumber(),applyReportId);
		out_json.addProperty("msg", result);
		PrintWriter out = response.getWriter();
		out.println(out_json);
		out.flush();
		out.close();
	}
	
	
	
	
	public void adminloginstate(MyResquestWrapper request, MyResponseWrapper response) throws SQLException, IOException {
		HttpSession session = request.getSession();
		Administrator administrator = (Administrator) session.getAttribute("administrator");
		
		JsonObject out_json = new JsonObject();
		JsonObject jsonData = new JsonObject();
		
		if(administrator!=null) {
			out_json.addProperty("msg", true);
			out_json.add("data", jsonData);
		}
		else {
			out_json.addProperty("msg", false);
			out_json.add("data", null);
		}
		
		PrintWriter out = response.getWriter();
		out.println(out_json);
		out.flush();
		out.close();
	}
	
	public void getUserAttention(MyResquestWrapper request, MyResponseWrapper response) throws SQLException, IOException {
		
		int type = Integer.parseInt(request.getParameter("type"));
		JsonObject out_json = new JsonObject();
		JsonArray jsonData = new JsonArray(); 
		HttpSession session = request.getSession();
		User us = (User) session.getAttribute("user");
		if(us!=null) {
			if(type==1) {
				List<Competition> competitions = userService.getAttentionCompetitionList(us.getPhonenumber(),type);
				if(competitions!=null){
					
					for (int i = 0; i < competitions.size(); i++) {
						jsonData.add(competitions.get(i).toJSON());
					}
				}
				
			}
			if(type==2) {
				List<Camp> camps = userService.getAttentionCampList(us.getPhonenumber(),type);
				if(camps!=null){
					
					for (int i = 0; i < camps.size(); i++) {
						jsonData.add(camps.get(i).toJSON());
					}
				}
			}
			
			if(type==3) {
				List<Train_Subject> trains = userService.getAttentionTrainList(us.getPhonenumber(),type);
				if(trains!=null){
					
					for (int i = 0; i < trains.size(); i++) {
						jsonData.add(trains.get(i).toJSON());
					}
				}
			}
		}
		out_json.add("data", jsonData);
		PrintWriter out = response.getWriter();
		out.println(out_json);
		out.flush();
		out.close();
	}
	
	
}
