package cn.usgame.servlet;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import cn.usgame.entity.ApplyReport;
import cn.usgame.entity.Camp;
import cn.usgame.entity.Competition;
import cn.usgame.entity.CompetitionGrade;
import cn.usgame.entity.News;
import cn.usgame.entity.Train_Subject;
import cn.usgame.entity.User;
import cn.usgame.entity_dto.ApplyReportForm;
import cn.usgame.entity_dto.CompetitionForm;
import cn.usgame.entity_dto.UserForm;
import cn.usgame.filter.MyResponseWrapper;
import cn.usgame.filter.MyResquestWrapper;
import cn.usgame.service.CompetitionService;
import cn.usgame.service.ServiceFactory;
import cn.usgame.utils.Excel;

@WebServlet("/CompetitionServlet")
public class CompetitionServlet extends BaseServlet {

	private static final long serialVersionUID = 1L;
	private CompetitionService comService = ServiceFactory.getInstance().getProgramManage();

	/**
	 * 函数名称：add 功能描述： 参数说明： 返回值：void 备注：
	 * 
	 */
	public void addCompetition(MyResquestWrapper request, MyResponseWrapper response) throws SQLException, IOException {

		
		Map<String, String[]> map = request.getParameterMap();
		CompetitionForm competitionForm = new CompetitionForm(map);
		Competition competition = competitionForm.toCompetition();
		boolean result = comService.addCompetition(competition);
		JsonObject out_json = new JsonObject();
		out_json.addProperty("msg", result);
		PrintWriter out = response.getWriter();
		out.println(out_json);
		out.flush();
		out.close();
	}

	/**
	 * 函数名称：getList 功能描述：获取比赛列表 参数说明： 返回值：void 备注：
	 * 
	 * 
	 * @throws SQLException
	 * @throws IOException
	 */
	public void list(MyResquestWrapper request, MyResponseWrapper response) throws SQLException, IOException {
		int type = Integer.parseInt(request.getParameter("type"));
		int page = 0;
		if (type == 1) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		JsonArray jsonData = new JsonArray();
		JsonObject out_json = new JsonObject();
		List<Competition> competitions = comService.getCompetitionList(page, type);
		
		for (int i = 0; i < competitions.size(); i++) {
			jsonData.add(competitions.get(i).toJSON());
			
		}
		String num = comService.getCompetitionNum();
		// EasyUI json格式
		PrintWriter out = response.getWriter();
		if (type == 1) {
			out_json.addProperty("total", num);
			out_json.add("rows", jsonData);
		} else {
			out_json.addProperty("total", competitions.size());
			out_json.add("data", jsonData);
		}
		out.println(out_json);
		out.flush();
		out.close();
	}

	/**
	 * 
	 * 函数名称：detail 功能描述：获取比赛详情 参数说明： 返回值：void 备注：
	 * 
	 */
	public void detail(MyResquestWrapper request, MyResponseWrapper response) throws IOException {
		int competitionId = Integer.parseInt(request.getParameter("competitionId"));
		int type = Integer.parseInt(request.getParameter("type"));
		JsonObject out_json = new JsonObject();
		JsonObject jsonData = new JsonObject();
		if (type == 1) {
			Competition competition = comService.getCompetitionDetail(competitionId);
			jsonData = competition.toJSON();
			if (competition != null) {
				out_json.add("data", jsonData);
				out_json.addProperty("msg", true);
			} else {
				out_json.add("data", null);
				out_json.addProperty("msg", false);
			}
			out_json.add("other", null);
		} else if (type == 2) {
			String competitionDes = comService.getCompetitionDes(competitionId);
			if (competitionDes != null) {
				out_json.addProperty("data", competitionDes);
				out_json.addProperty("msg", true);
			} else {
				out_json.add("data", null);
				out_json.addProperty("msg", false);
			}
			out_json.add("other", null);
		}
		if (type == 3) {
			Competition competition = comService.getCompetitionDetail(competitionId);
			jsonData = competition.toJSON();
			PrintWriter out = response.getWriter();
			out.println(jsonData);
			out.flush();
			out.close();
		} else {
			PrintWriter out = response.getWriter();
			out.println(out_json);
			out.flush();
			out.close();
		}
	}

	/**
	 * 
	 * 函数名称：detail 功能描述：获取比赛详情 参数说明： 返回值：void 备注：
	 * 
	 */
	public void Web_getCompetitionDetails(MyResquestWrapper request, MyResponseWrapper response) throws IOException {
		int competitionId = Integer.parseInt(request.getParameter("CompetitionId"));
		JsonObject out_json = new JsonObject();
			Competition competition = comService.Web_getCompetitionDetails(competitionId);
			if (competition != null) {
				JsonObject jsonData = new JsonObject();
				jsonData = competition.toJSON();
				out_json.add("data", jsonData);
				out_json.addProperty("msg", true);
			} else {
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
	 * 函数名称：apply 功能描述：提交报名申请 参数说明： 返回值：void 备注：msg 1:报名成功 2:用户已经支付过 3:修改报名成功
	 * 4:身份证或手机号错误
	 * 
	 * 
	 */
	public void apply(MyResquestWrapper request, MyResponseWrapper response) throws IOException {
		Map<String, String[]> map = request.getParameterMap();
		JsonObject out_json = new JsonObject();
		HttpSession session = request.getSession();
		User us = (User) session.getAttribute("user");
		if (us != null) {
			ApplyReportForm applyReportForm = new ApplyReportForm(map, us.getPhonenumber());
			boolean flagForIdcard = applyReportForm.judgeIdcard();
			boolean flagForPhoneNum = applyReportForm.judgePhoneNum();
			if (flagForIdcard == true && flagForPhoneNum == true) {
				ApplyReport applyReport = applyReportForm.toApplyReport();
				int result = comService.applyReport(applyReport);
				out_json.addProperty("msg", result);
				out_json.addProperty("data", applyReport.getOut_trade_no());
				out_json.add("other", null);
			} else {
				if (flagForIdcard == false && flagForPhoneNum == true) {
					out_json.addProperty("other", "身份证号码有误！");
				} else if (flagForPhoneNum == false && flagForIdcard == true) {
					out_json.addProperty("other", "电话号码有误！");
				} else if (flagForPhoneNum == false && flagForIdcard == false) {
					out_json.addProperty("other", "电话号码,身份证有误！");
				}
				out_json.addProperty("msg", 4);
				out_json.add("data", null);
			}
		} else {
			out_json.addProperty("msg", 0);
			out_json.add("data", null);
			out_json.addProperty("other", "请先登陆!");
		}
		PrintWriter out = response.getWriter();
		out.println(out_json);
		out.flush();
		out.close();
	}

	/**
	 * 
	 * 函数名称：reviseState 功能描述：修改比赛状态 参数说明： * 返回值：void 备注：
	 * 
	 * 
	 * @throws IOException
	 */
	public void reviseState(MyResquestWrapper request, MyResponseWrapper response) throws IOException {
		int competitionId = Integer.parseInt(request.getParameter("competitionId"));
		int competitionState = Integer.parseInt(request.getParameter("competitionState"));
		System.out.println(competitionState);
		JsonObject out_json = new JsonObject();
		boolean result = false;
		result = comService.reviseCompetitionState(competitionId, competitionState);
		out_json.addProperty("msg", result);
		out_json.add("data", null);
		if (result == false) {
			out_json.addProperty("other", "修改状态失败！");
		} else {
			out_json.addProperty("other", "修改状态成功！");
		}
		PrintWriter out = response.getWriter();
		out.println(out_json);
		out.flush();
		out.close();
	}

	/**
	 * 
	 * 函数名称：getApplyList 功能描述：获取报名列表 参数说明： 返回值：void 备注：
	 * 
	 */
	public void getApplyList(MyResquestWrapper request, MyResponseWrapper response) throws IOException {
		int page = Integer.parseInt(request.getParameter("page"));
		JsonObject out_json = new JsonObject();
		JsonArray jsonData = new JsonArray();
		List<ApplyReport> applyReports = comService.getAllApplyReport(page);
		String total = comService.getApplyReportNum();
		for (int i = 0; i < applyReports.size(); i++) {
			jsonData.add(applyReports.get(i).toJSON());
		}
		out_json.addProperty("total", total);
		out_json.add("rows", jsonData);
		PrintWriter out = response.getWriter();
		out.println(out_json);
		
		out.flush();
		out.close();
	}

	public void getApplyDetail(MyResquestWrapper request, MyResponseWrapper response) throws IOException {
		String phoneNum = request.getParameter("phoneNum");
		JsonObject jsonData = new JsonObject();
		ApplyReport applyReport = comService.getApplyReportDetail(phoneNum);
		jsonData = applyReport.toJSON();
		PrintWriter out = response.getWriter();
		out.println(jsonData);
		out.flush();
		out.close();
	}
	
	public void getApplyReportDetailbackground(MyResquestWrapper request, MyResponseWrapper response) throws IOException {
		String idcard = request.getParameter("idcard");
		String competitionName = URLDecoder.decode(request.getParameter("competitionName"), "UTF-8");
		String competitionSubject = URLDecoder.decode(request.getParameter("competitionSubject"), "UTF-8");
		int competitionGrade = Integer.parseInt(request.getParameter("competitionGrade"));
		JsonObject jsonData = new JsonObject();
		ApplyReport applyReport = comService.getApplyReportDetailbackground(idcard,competitionName,competitionSubject,competitionGrade);
		jsonData = applyReport.toJSON();
		PrintWriter out = response.getWriter();
		out.println(jsonData);
		out.flush();
		out.close();
	}

	public void search(MyResquestWrapper request, MyResponseWrapper response) throws IOException {
		int page = Integer.parseInt(request.getParameter("page"));
		String starttime = request.getParameter("starttime");
		String endtime = request.getParameter("endtime");
		String options = request.getParameter("options");
		String Info = URLDecoder.decode(request.getParameter("Info"), "UTF-8");
		int orderState = Integer.parseInt(request.getParameter("orderState"));
		JsonObject out_json = new JsonObject();
		JsonArray jsonData = new JsonArray();
		List<ApplyReport> applyReports = comService.getApplyReport(starttime, endtime, options, Info, orderState, page);
		String total = comService.getSearchNum(starttime, endtime, options, Info, orderState);
		for (int i = 0; i < applyReports.size(); i++) {
			jsonData.add(applyReports.get(i).toJSON());
		}
		out_json.addProperty("total", total);
		out_json.add("rows", jsonData);
		PrintWriter out = response.getWriter();
		out.println(jsonData);
		out.flush();
		out.close();
	}

	public void exportApplyReport(MyResquestWrapper request, MyResponseWrapper response) throws IOException {
		String starttime = request.getParameter("from");
		String endtime = request.getParameter("to");
		String options = request.getParameter("options");
		String Info =request.getParameter("info");
		int orderState = Integer.parseInt(request.getParameter("orderState"));
		JsonObject out_json = new JsonObject();
		JsonArray jsonData = new JsonArray();
		List<ApplyReport> applyReports = comService.exportApplyReport(starttime, endtime, options, Info, orderState);
		Excel excel = new Excel();
		String str = excel.exportExcel(starttime, endtime, options, Info, orderState, applyReports);

		
		String ENCODING="utf-8";  
		  
		  
		 //内容类型  
		  
		 String CONTENT_TYPE="text/html;charset=utf-8";  
		  
		  
		 //要下载的文件存放的路径  
		  
		String downloadfiledir="C:/exportfile/";  
		  
		  
		  
		  
		 //设置request对象的字符编码  
		  
		 request.setCharacterEncoding(ENCODING);  
		  
		  
		 //从request中取出要下载文件的名字  
		  
		 String filename = str.substring(str.lastIndexOf("\\") + 1);  
		 if(filename==null||filename.trim().equals("")){  
		  
		 //设置response对象的ContentType  
		  
		 response.setContentType(CONTENT_TYPE);  
		  
		  
		 //输出错误信息  
		  
		 PrintWriter out=response.getWriter();  
		  
		 out.println("<font color=red>文件下载失败！</font>");  
		  
		 out.close();  
		  
		 }else{  
		  
		 //下载文件的完整路径名  
		  
		 String fullfilename=downloadfiledir+filename;  
		  
		 System.out.println("下载文件："+fullfilename);  
		  
		  
		 //根据文件的类型设置response对象的ContentType  
		  
		 String contentType=getServletContext().getMimeType(fullfilename);  
		  
		 if(contentType==null)  {
		 contentType="application/octet-stream";  
		 }
		 response.setContentType(contentType);  
		  
		 //设置response的头信息  
		 //filename="+URLEncoder.encode(fileName, "UTF-8")
		 response.setHeader("Content-disposition","attachment;filename="+URLEncoder.encode(filename, "utf-8"));  
		  
		 InputStream is=null;  
		  
		 OutputStream os=null;  
		  
		  
		 try{  
		  
		 is=new BufferedInputStream(new FileInputStream(fullfilename));  
		  
		  
		 //定义输出字节流  
		  
		 ByteArrayOutputStream baos=new ByteArrayOutputStream();  
		  
		  
		 //定义response的输出流  
		  
		 os=new BufferedOutputStream(response.getOutputStream());  
		  
		  
		 //定义buffer  
		  
		 byte[] buffer=new byte[4*1024]; //4k Buffer  
		  
		 int read=0;  
		  
		  
		 //从文件中读入数据并写到输出字节流中  
		  
		 while((read=is.read(buffer))!=-1){  
		  
		 baos.write(buffer,0,read);  
		  
		 }  
		  
		  
		 //将输出字节流写到response的输出流中  
		  
		 os.write(baos.toByteArray());  
		  
		 }catch(IOException e){  
		  
		 e.printStackTrace();  
		  
		 }finally{  
		  
		 //关闭输出字节流和response输出流  
		  
		 os.close();  
		  
		 is.close();  
		  
		 }  
		 }
	}

	public void getticketAddress(MyResquestWrapper request, MyResponseWrapper response) throws IOException {
		String competitionName = request.getParameter("competitionName");
		Competition competition = comService.getticketAddress(competitionName);
		JsonObject out_json = new JsonObject();
		if (competition != null) {
			JsonObject jsonData = new JsonObject();
			jsonData = competition.toJSON();
			out_json.addProperty("msg", true);
			out_json.add("data", jsonData);
		} else {
			out_json.addProperty("msg", false);
			out_json.add("data", null);
		}
		PrintWriter out = response.getWriter();
		out.println(out_json);
		out.flush();
		out.close();
	}

	/**
	 * 
	 * 函数名称：getgradeList 功能描述：获取成绩列表 参数说明： 返回值：void 备注：
	 * 
	 */
	public void getgradeList(MyResquestWrapper request, MyResponseWrapper response) throws IOException {
		int page = Integer.parseInt(request.getParameter("page"));
		JsonObject out_json = new JsonObject();
		JsonArray jsonData = new JsonArray();
		List<CompetitionGrade> competitiongrades = comService.getAllgradeList(page);
		String total = comService.getgradeNum();
		for (int i = 0; i < competitiongrades.size(); i++) {
			jsonData.add(competitiongrades.get(i).toJSON());
		}
		out_json.addProperty("total", total);
		out_json.add("rows", jsonData);
		PrintWriter out = response.getWriter();
		out.println(out_json);
		out.flush();
		out.close();
	}

	public void searchGrade(MyResquestWrapper request, MyResponseWrapper response) throws IOException {
		int page = Integer.parseInt(request.getParameter("page"));
		String Info = URLDecoder.decode(request.getParameter("Info"), "UTF-8");
		System.out.println(Info);
		JsonObject out_json = new JsonObject();
		JsonArray jsonData = new JsonArray();
		List<CompetitionGrade> competitiongrades = comService.getGradeList(Info, page);
		String total = comService.getSearchGradeNum(Info);
		for (int i = 0; i < competitiongrades.size(); i++) {
			jsonData.add(competitiongrades.get(i).toJSON());
		}
		out_json.addProperty("total", total);
		out_json.add("rows", jsonData);
		PrintWriter out = response.getWriter();
		out.println(jsonData);
		out.flush();
		out.close();
	}

	public void exportGrade(MyResquestWrapper request, MyResponseWrapper response) throws IOException {
		String Info = request.getParameter("Info");
		JsonObject out_json = new JsonObject();
		JsonArray jsonData = new JsonArray();
		List<CompetitionGrade> competitiongrades = comService.exportGrade(Info);
		Excel excel = new Excel();
		String str = excel.exportGradeExcel(Info, competitiongrades);

		String ENCODING="utf-8";  
		  
		  
		 //内容类型  
		  
		 String CONTENT_TYPE="text/html;charset=utf-8";  
		  
		  
		 //要下载的文件存放的路径  
		  
		String downloadfiledir="C:/exportfile/";  
		  
		  
		  
		  
		 //设置request对象的字符编码  
		  
		 request.setCharacterEncoding(ENCODING);  
		  
		  
		 //从request中取出要下载文件的名字  
		  
		 String filename = str.substring(str.lastIndexOf("\\") + 1);  
		 if(filename==null||filename.trim().equals("")){  
		  
		 //设置response对象的ContentType  
		  
		 response.setContentType(CONTENT_TYPE);  
		  
		  
		 //输出错误信息  
		  
		 PrintWriter out=response.getWriter();  
		  
		 out.println("<font color=red>文件下载失败！</font>");  
		  
		 out.close();  
		  
		 }else{  
		  
		 //下载文件的完整路径名  
		  
		 String fullfilename=downloadfiledir+filename;  
		  
		 System.out.println("下载文件："+fullfilename);  
		  
		  
		 //根据文件的类型设置response对象的ContentType  
		  
		 String contentType=getServletContext().getMimeType(fullfilename);  
		  
		 if(contentType==null)  
		  
		 contentType="application/octet-stream";  
		  
		 response.setContentType(contentType);  
		  
		  
		 //设置response的头信息  
		 //filename="+URLEncoder.encode(filename, "GBK")
		 
		 response.setHeader("Content-disposition","attachment;filename=\""+URLEncoder.encode(filename, "utf-8")+"\"");  
		  
		 InputStream is=null;  
		  
		 OutputStream os=null;  
		  
		  
		 try{  
		  
		 is=new BufferedInputStream(new FileInputStream(fullfilename));  
		  
		  
		 //定义输出字节流  
		  
		 ByteArrayOutputStream baos=new ByteArrayOutputStream();  
		  
		  
		 //定义response的输出流  
		  
		 os=new BufferedOutputStream(response.getOutputStream());  
		  
		  
		 //定义buffer  
		  
		 byte[] buffer=new byte[4*1024]; //4k Buffer  
		  
		 int read=0;  
		  
		  
		 //从文件中读入数据并写到输出字节流中  
		  
		 while((read=is.read(buffer))!=-1){  
		  
		 baos.write(buffer,0,read);  
		  
		 }  
		  
		  
		 //将输出字节流写到response的输出流中  
		  
		 os.write(baos.toByteArray());  
		  
		 }catch(IOException e){  
		  
		 e.printStackTrace();  
		  
		 }finally{  
		  
		 //关闭输出字节流和response输出流  
		  
		 os.close();  
		  
		 is.close();  
		  
		 }  
		 }
		 

	}

	public static void setFileDownloadHeader(HttpServletRequest request, HttpServletResponse response,
			String fileName) {
		try {
			// 中文文件名支持
			String encodedfileName = null;
			String agent = request.getHeader("USER-AGENT");

			if (null != agent && -1 != agent.indexOf("MSIE")) {// IE
				encodedfileName = java.net.URLEncoder.encode(fileName, "UTF-8");
			} else if (null != agent && -1 != agent.indexOf("Mozilla")) {
				encodedfileName = new String(fileName.getBytes("UTF-8"), "iso-8859-1");
			} else {
				encodedfileName = java.net.URLEncoder.encode(fileName, "UTF-8");
			}
			response.setHeader("Content-Disposition", "attachment; filename=\"" + encodedfileName + "\"");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

	// 构造类
	class Position {

		int begin;
		int end;

		public Position(int begin, int end) {
			this.begin = begin;
			this.end = end;
		}
	}

	private byte[] readBody(MyResquestWrapper request) throws IOException {
		// 获取请求文本字节长度
		int formDataLength = request.getContentLength();
		// 取得ServletInputStream输入流对象
		DataInputStream dataStream = new DataInputStream(request.getInputStream());
		byte body[] = new byte[formDataLength];
		int totalBytes = 0;
		while (totalBytes < formDataLength) {
			int bytes = dataStream.read(body, totalBytes, formDataLength);
			totalBytes += bytes;
		}
		return body;
	}

	private Position getFilePosition(MyResquestWrapper request, String textBody) throws IOException {
		// 取得文件区段边界信息
		String contentType = request.getContentType();
		String boundaryText = contentType.substring(contentType.lastIndexOf("=") + 1, contentType.length());
		// 取得实际上传文件的气势与结束位置
		int pos = textBody.indexOf("filename=\"");
		pos = textBody.indexOf("\n", pos) + 1;
		pos = textBody.indexOf("\n", pos) + 1;
		pos = textBody.indexOf("\n", pos) + 1;
		int boundaryLoc = textBody.indexOf(boundaryText, pos) - 4;
		int begin = ((textBody.substring(0, pos)).getBytes("GBK")).length;
		// int begin = ((textBody.substring(0, pos)).getBytes("UTF-8")).length;
		int end = ((textBody.substring(0, boundaryLoc)).getBytes("GBK")).length;
		// int end = ((textBody.substring(0,
		// boundaryLoc)).getBytes("UTF-8")).length;

		return new Position(begin, end);
	}

	private String getFileName(String requestBody) {
		String fileName = requestBody.substring(requestBody.indexOf("filename=\"") + 10);
		fileName = fileName.substring(0, fileName.indexOf("\n"));
		fileName = fileName.substring(fileName.indexOf("\n") + 1, fileName.indexOf("\""));

		return fileName;
	}

	private void writeTo(String fileName, byte[] body, Position p) throws IOException {
		FileOutputStream fileOutputStream = new FileOutputStream("c:/importfile/" + fileName);
		fileOutputStream.write(body, p.begin, (p.end - p.begin));
		fileOutputStream.flush();
		fileOutputStream.close();
	}

	public void importGrade(MyResquestWrapper request, MyResponseWrapper response) throws IOException {

		// 读取请求Body
		byte[] body = readBody(request);
		// 取得所有Body内容的字符串表示
		System.out.println("body-----"+body);
		String textBody = new String(body, "GBK");
		// String textBody = new String(body, "UTF-8");
		// 取得上传的文件名称
		System.out.println("textBody--------"+textBody+"---end");
		String fileName = getFileName(textBody);
		fileName = new String(fileName.getBytes("gbk"), "utf-8");
		// 取得文件开始与结束位置
		Position p = getFilePosition(request, textBody);
		// 输出至文件
		writeTo(fileName, body, p);

		Excel excel = new Excel();
		List<CompetitionGrade> competitiongrades = excel.importGradeExcel(fileName);
		boolean result = comService.importGrade(competitiongrades);
		JsonObject out_json = new JsonObject();
		out_json.addProperty("导入结果", result);
		PrintWriter out = response.getWriter();
		out.println(out_json);
		out.flush();
		out.close();
	}

	/**
	 * 函数名称：changepw 功能描述：修改密码 参数说明： 返回值：void 备注：
	 * 
	 */
	public void querygrade(MyResquestWrapper request, MyResponseWrapper response) throws SQLException, IOException {
		String admissionTicket = request.getParameter("admissionTicket");
		String pw = request.getParameter("pw");

		JsonObject out_json = new JsonObject();
		JsonObject jsonData = new JsonObject();

		CompetitionGrade competitiongrade = comService.querygrade(admissionTicket, pw);
		if (competitiongrade != null) {
			jsonData = competitiongrade.toJSON();
			out_json.add("data", jsonData);
			out_json.addProperty("msg", true);
		} else {
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
	 * 函数名称：getNewsList 功能描述：获取新闻列表 参数说明： 返回值：void 备注：
	 * 
	 */
	public void getNewsList(MyResquestWrapper request, MyResponseWrapper response) throws IOException {
		int page = Integer.parseInt(request.getParameter("page"));
		JsonObject out_json = new JsonObject();
		JsonArray jsonData = new JsonArray();
		List<News> news = comService.getAllNews(page);
		String total = comService.getAllNewsNum();
		for (int i = 0; i < news.size(); i++) {
			jsonData.add(news.get(i).toJSON());
		}
		out_json.addProperty("total", total);
		out_json.add("rows", jsonData);
		PrintWriter out = response.getWriter();
		out.println(out_json);
		out.flush();
		out.close();
	}
	
	/**
	 * 
	 * 函数名称：Newsdetails 功能描述：获取新闻详情 参数说明： 返回值：void 备注：
	 * 
	 */
	public void Newsdetails(MyResquestWrapper request, MyResponseWrapper response) throws IOException {
		int newId = Integer.parseInt(request.getParameter("newId"));
		JsonObject jsonData = new JsonObject();
		News news = comService.Newsdetails(newId);
		if(news!=null) {
			jsonData = news.toJSON();
		}
		PrintWriter out = response.getWriter();
		out.println(jsonData);
		out.flush();
		out.close();
	}
	
	/**
	 * 
	 * 函数名称：changeNewsdetails 功能描述：修改新闻详情 参数说明： 返回值：void 备注：
	 * 
	 */
	public void changeNewsdetails(MyResquestWrapper request, MyResponseWrapper response) throws IOException {
		int newsId = Integer.parseInt(request.getParameter("newsId"));
		
		String info = URLDecoder.decode(request.getParameter("info"), "UTF-8");
		String url = URLDecoder.decode(request.getParameter("url"), "UTF-8");
		int state = Integer.parseInt(request.getParameter("state"));
		boolean result = comService.changeNewsdetails(newsId,info,url,state);
		PrintWriter out = response.getWriter();
		out.println(result);
		out.flush();
		out.close();
	}
	
	/**
	 * 
	 * 函数名称：addNews 功能描述：新增新闻详情 参数说明： 返回值：void 备注：
	 * 
	 */
	public void addNews(MyResquestWrapper request, MyResponseWrapper response) throws IOException {
		String info = URLDecoder.decode(request.getParameter("info"), "UTF-8");
		String url = URLDecoder.decode(request.getParameter("url"), "UTF-8");
		int state = Integer.parseInt(request.getParameter("state"));
		boolean result = comService.addNews(info,url,state);
		PrintWriter out = response.getWriter();
		out.println(result);
		out.flush();
		out.close();
	}
	
	/**
	 * 
	 * 函数名称：getNewsList 功能描述：获取新闻列表 参数说明： 返回值：void 备注：
	 * 
	 */
	public void getEnableNewsInfo(MyResquestWrapper request, MyResponseWrapper response) throws IOException {
		JsonObject out_json = new JsonObject();
		JsonArray jsonData = new JsonArray();
		List<News> news = comService.getEnableNewsInfo();
		for (int i = 0; i < news.size(); i++) {
			jsonData.add(news.get(i).ToJSON());
		}
		out_json.add("data", jsonData);
		PrintWriter out = response.getWriter();
		out.println(out_json);
		out.flush();
		out.close();
	}
	/**
	 * 
	 * 函数名称：getMainCompetition 功能描述：得到首页的竞赛   参数说明： 返回值：void 备注：
	 * 
	 */
	public void getMainCompetition(MyResquestWrapper request, MyResponseWrapper response) throws IOException {
		JsonObject out_json = new JsonObject();
		JsonArray jsonData = new JsonArray();
		List<Competition> competitions = comService.getMainCompetition();
		for (int i = 0; i < 4; i++) {
			jsonData.add(competitions.get(i).toJSON());
		}
		out_json.add("data", jsonData);
		PrintWriter out = response.getWriter();
		out.println(out_json);
		out.flush();
		out.close();
	}
	
	/**
	 * 函数名称：getCompetitionList 功能描述：获取比赛列表 参数说明： 返回值：void 备注：
	 * 
	 * 
	 * @throws SQLException
	 * @throws IOException
	 */
	public void getCompetitionList(MyResquestWrapper request, MyResponseWrapper response) throws SQLException, IOException {
		JsonArray jsonData = new JsonArray();
		JsonObject out_json = new JsonObject();
		List<Competition> competitions = comService.getCompetitionList();
		for (int i = 0; i < competitions.size(); i++) {
			jsonData.add(competitions.get(i).toJSON());
		}
		//String num = comService.getCompetitionNum();
		PrintWriter out = response.getWriter();
			//out_json.addProperty("total", competitions.size());
			out_json.add("data", jsonData);
		out.println(out_json);
		out.flush();
		out.close();
	}
	
	/**
	 * 函数名称：judgeApplyState 功能描述：判断订单状态   参数说明： out_trade_no 订单号 返回值：订单状态  备注：
	 * 
	 * 
	 * @throws SQLException
	 * @throws IOException
	 */
	public void judgeApplyState(MyResquestWrapper request, MyResponseWrapper response) throws SQLException, IOException {
		String out_trade_no = request.getParameter("out_trade_no");
		JsonObject out_json = new JsonObject();
		int state = comService.judgeApplyState(out_trade_no);
		PrintWriter out = response.getWriter();
		out_json.addProperty("state", state);
		out.println(out_json);
		out.flush();
		out.close();
	}
	
	
	
	/**
	 * 函数名称：getCompetitionbyInfo 
	 * 功能描述：获得竞赛
	 * 参数说明：竞赛名，科目，报名金额
	 * 返回值：competition 备注：
	 * 
	 */
	public void getCompetitionbyInfo(MyResquestWrapper request, MyResponseWrapper response) throws SQLException, IOException {
		String competitionName = request.getParameter("competitionName");
		String competitionSubject = request.getParameter("competitionSubject");
		int money = Integer.parseInt(request.getParameter("money"));
		String applyReport = request.getParameter("applyorder");
		
		JsonObject out_json = new JsonObject();
		JsonObject jsonData = new JsonObject();

		Competition competition = comService.getCompetitionbyInfo(competitionName, competitionSubject,money);
		if (competition != null) {
			jsonData = competition.toJSON();
			out_json.addProperty("msg", true);
			out_json.add("data", jsonData);
			out_json.addProperty("applyReport",applyReport );
			//out_json.addProperty("state", applyReportState);
		} else {
			out_json.addProperty("msg", false);
			out_json.add("data", null);
		}
		PrintWriter out = response.getWriter();
		out.println(out_json);
		out.flush();
		out.close();
	}
	
	/**
	 * 函数名称：getCompetitionListByForm
	 *  功能描述：获取比赛列表 
	 *  参数说明： 
	 *  返回值：void 
	 *  备注：
	 * 
	 * 
	 * @throws SQLException
	 * @throws IOException
	 */
	public void getCompetitionListByForm(MyResquestWrapper request, MyResponseWrapper response) throws SQLException, IOException {
		int course = Integer.parseInt(request.getParameter("course"));
		/*int level = Integer.parseInt(request.getParameter("level"));*/
		int rtime = Integer.parseInt(request.getParameter("rtime"));
		JsonArray jsonData = new JsonArray();
		JsonObject out_json = new JsonObject();
		List<Competition> competitions = comService.getCompetitionListByForm(course,rtime);
		for (int i = 0; i < competitions.size(); i++) {
			jsonData.add(competitions.get(i).toJSON());
		}
		//String num = comService.getCompetitionNum();
		PrintWriter out = response.getWriter();
			//out_json.addProperty("total", competitions.size());
			out_json.add("data", jsonData);
		out.println(out_json);
		out.flush();
		out.close();
	}
	/**
	 * 函数名称：payAttention
	 *  功能描述：添加竞赛关注 
	 *  参数说明：用户注册号，竞赛Id
	 *  返回值：boolean 
	 *  备注：
	 * 
	 * 
	 * @throws SQLException
	 * @throws IOException
	 */
	public void payAttention(MyResquestWrapper request, MyResponseWrapper response) throws SQLException,IOException {
		String phonenumber = request.getParameter("phonenumber");
		String CompetitionId = request.getParameter("CompetitionId");
		boolean result = false;
		result = comService.AddCompetitionAttention(phonenumber,CompetitionId);
		PrintWriter out = response.getWriter();
		out.println(result);
		out.flush();
		out.close();
	}
	
	/**
	 * 函数名称：DelAttention
	 *  功能描述：取消竞赛关注 
	 *  参数说明：用户注册号，竞赛Id
	 *  返回值：boolean 
	 *  备注：
	 * 
	 * 
	 * @throws SQLException
	 * @throws IOException
	 */
	public void DelAttention(MyResquestWrapper request, MyResponseWrapper response) throws SQLException,IOException {
		String phonenumber = request.getParameter("phonenumber");
		String CompetitionId = request.getParameter("CompetitionId");
		boolean result = false;
		result = comService.DelCompetitionAttention(phonenumber,CompetitionId);
		PrintWriter out = response.getWriter();
		out.println(result);
		out.flush();
		out.close();
	}
	
	/**
	 * 函数名称：judgeAttentionState
	 *  功能描述：判断竞赛关注状态 
	 *  参数说明：用户注册号，竞赛Id
	 *  返回值：boolean 
	 *  备注：
	 * 
	 * 
	 * @throws SQLException
	 * @throws IOException
	 */
	public void judgeAttentionState(MyResquestWrapper request, MyResponseWrapper response) throws SQLException,IOException {
		String phonenumber = request.getParameter("phonenumber");
		String CompetitionId = request.getParameter("CompetitionId");
		int result;
		result = comService.judgeAttentionState(phonenumber,CompetitionId);
		//System.out.println(result);
		PrintWriter out = response.getWriter();
		out.println(result);
		out.flush();
		out.close();
	}
	/**
	 * 函数名称：getCompetitionSearchInfo
	 *  功能描述：
	 *  参数说明：搜索内容
	 *  返回值： 
	 *  备注：
	 * 
	 * 
	 * @throws SQLException
	 * @throws IOException
	 */
	public void getCompetitionSearchInfo(MyResquestWrapper request, MyResponseWrapper response) throws SQLException,IOException {
		String searchInfo = request.getParameter("searchInfo");
		JsonArray jsonData = new JsonArray();
		JsonObject out_json = new JsonObject();
		List<Competition> competitions= comService.getCompetitionSearchInfo(searchInfo);
		if(competitions.size()>0){
			for(int i=0;i<competitions.size();i++){
				jsonData.add(competitions.get(i).toJSON());
			}
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
	 * 函数名称：getCompetitionSlides
	 *  功能描述：首页轮播
	 *  参数说明：
	 *  返回值： 
	 *  备注：
	 * 
	 * 
	 * @throws SQLException
	 * @throws IOException
	 */
	public void getCompetitionSlides(MyResquestWrapper request, MyResponseWrapper response) throws SQLException,IOException {
		JsonObject out_json = new JsonObject();
		Competition competition = comService.getCompetitionSlides();
		if(competition!=null) {
			out_json.addProperty("msg",true);
			out_json.add("competition", competition.toJSON());
		}
		else {
			out_json.addProperty("msg",false);
			out_json.add("competition", null);
		}
		PrintWriter out = response.getWriter();
		out.println(out_json);
		out.flush();
		out.close();
	}
	
}
