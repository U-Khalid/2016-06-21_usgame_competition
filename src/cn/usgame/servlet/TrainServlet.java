package cn.usgame.servlet;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpSession;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import cn.usgame.entity.ApplyReport;
import cn.usgame.entity.Camp;
import cn.usgame.entity.CampApply;
import cn.usgame.entity.Competition;
import cn.usgame.entity.TrainApply;
import cn.usgame.entity.Train_Info;
import cn.usgame.entity.Train_Subject;
import cn.usgame.entity.Train_Teacher;
import cn.usgame.entity.User;
import cn.usgame.entity_dto.ApplyReportForm;
import cn.usgame.entity_dto.trainApplyForm;
import cn.usgame.filter.MyResponseWrapper;
import cn.usgame.filter.MyResquestWrapper;
import cn.usgame.service.ServiceFactory;
import cn.usgame.service.TrainService;
import cn.usgame.utils.Excel;


@WebServlet("/TrainServlet")
public class TrainServlet extends BaseServlet{

	private static final long serialVersionUID = 1L;
	private TrainService trainService = ServiceFactory.getInstance().getTrainManage();
	
	public void getTrainDetail(MyResquestWrapper request, MyResponseWrapper response) throws IOException {
		String course=request.getParameter("course");
		String enroll=request.getParameter("enrollState");
		/*String state=request.getParameter("trainState");*/
		int page = Integer.parseInt(request.getParameter("page"))-1;
//		String course="";
//		String sort="";
//		String enroll="";
//		String state="";
//		int page=Integer.parseInt("");
		JsonObject out_json=new JsonObject();
		JsonArray jsonData=new JsonArray(); 
		List<Train_Subject> tSubject = trainService.getTrainDetail(course, enroll, page);
		for (int i = 0; i < tSubject.size(); i++) {
			jsonData.add(tSubject.get(i).toJSON());
		}
		PrintWriter out = response.getWriter();
		out_json.add("rows", jsonData);
		out.println(out_json);
		out.flush();
		out.close();
	}
	
	
	public void getTrainList(MyResquestWrapper request, MyResponseWrapper response) throws IOException{
		
		JsonObject out_json=new JsonObject();
		JsonArray jsonData=new JsonArray(); 
		JsonArray json2 = new JsonArray();
		List<Train_Subject> tSubject=trainService.getTrainList();
		for (int i = 0; i < tSubject.size(); i++) {
			jsonData.add(tSubject.get(i).toJSON());
			json2.add(tSubject.get(i).gettMechanismInfo().toJSON());
		}
		PrintWriter out = response.getWriter();
		out_json.add("data", jsonData);
		out_json.add("data2",json2);
		out.println(out_json);
		/*System.out.println(out_json);*/
		out.flush();
		out.close();
	}
	
	public void getTrainCount(MyResquestWrapper request, MyResponseWrapper response) throws IOException{
		String course = request.getParameter("course");
		String enroll = request.getParameter("enrollState");
		/*String state = request.getParameter("trainState");*/
		JsonObject out_json = new JsonObject();
		int num = Integer.parseInt(trainService.getTotalNum(course, enroll));
		PrintWriter out = response.getWriter();
		out_json.addProperty("num", num);
		out.println(out_json);
		out.flush();
		out.close();
	}
	
	public void getDetailByID(MyResquestWrapper request, MyResponseWrapper response) throws IOException{
		
//		String subjectID = request.getParameter("ID");
		int subjectID = Integer.parseInt(request.getParameter("ID"));
		JsonObject out_json = new JsonObject();
		Train_Subject tSubject = trainService.getTrainDetailByID(subjectID);
		
		PrintWriter out = response.getWriter();
		out_json.add("json", tSubject.toJSON());
		out_json.add("jsona", tSubject.gettMechanismInfo().toJSON());	
		/*System.out.println(out_json);*/
		out.println(out_json);
		out.flush();
		out.close();
	}
	
/*public void getMechanismDetailByID(MyResquestWrapper request, MyResponseWrapper response) throws IOException{
		
//		String subjectID = request.getParameter("ID");
		int trainID = Integer.parseInt(request.getParameter("ID"));
		JsonObject out_json = new JsonObject();
		Train_Info ttrain = trainService.getMechanismDetailByID(trainID);
		PrintWriter out = response.getWriter();
		out_json.add("json", ttrain.toJSON());
		System.out.println(ttrain.toJSON());
		out.println(out_json);
		out.flush();
		out.close();
	}*/
	
	public void getTeacherDetail(MyResquestWrapper request, MyResponseWrapper response) throws IOException{
		
		int subjectID = Integer.parseInt(request.getParameter("ID"));
		JsonObject out_json = new JsonObject();
		JsonArray jsonData=new JsonArray(); 
		List<Train_Teacher> teacher = trainService.getTeacher(subjectID);
		for(int i = 0;i < teacher.size();i++){
			jsonData.add(teacher.get(i).toJSON());
		}
		PrintWriter out = response.getWriter();
		out_json.add("data", jsonData);
		out.println(out_json);
		out.flush();
		out.close();
	}
	
	public void getTeacherByID(MyResquestWrapper request, MyResponseWrapper response) throws IOException{
		
		int trainTeacherID = Integer.parseInt(request.getParameter("ID"));
		JsonObject out_json = new JsonObject();
		Train_Teacher teacher = trainService.getTeacherByID(trainTeacherID);
		PrintWriter out = response.getWriter();
		out_json.add("data", teacher.toJSON());
		out.println(out_json);
		out.flush();
		out.close();
	}
	
	public void apply(MyResquestWrapper request, MyResponseWrapper response) throws IOException{
		
		Map<String,String[]> map = request.getParameterMap();
		JsonObject out_json = new JsonObject();
		HttpSession http = request.getSession();
		User user = (User)http.getAttribute("user");
		if(user != null){
			trainApplyForm applyFrom = new trainApplyForm(map, user.getPhonenumber()); 
			boolean isIdcard = applyFrom.judgeIdcard();
			boolean isPhone = applyFrom.judgePhoneNum();
			if(isIdcard == true && isPhone == true){
				TrainApply apply = applyFrom.toTrainApply();
				int result = trainService.trainApply(apply);
				out_json.addProperty("msg", result);
				out_json.addProperty("data", apply.getOut_trade_no());
				out_json.add("other", null); //储存错误信息
			}
			else {
				if (isIdcard == false && isPhone == true) {
					out_json.addProperty("other", "身份证号码有误！");
				} else if (isPhone == false && isIdcard == true) {
					out_json.addProperty("other", "电话号码有误！");
				} else if (isPhone == false && isIdcard == false) {
					out_json.addProperty("other", "电话号码,身份证有误！");
				}
				out_json.addProperty("msg", 4);
				out_json.add("data", null);
			 }
	    } 
		else {
			out_json.addProperty("msg", 0);
			out_json.add("data", null);
			out_json.addProperty("other", "请先登陆!");  //用户未登录
		}
		PrintWriter out = response.getWriter();
		out.println(out_json);
		out.flush();
		out.close();
	}
	
	
	/**
	 * 函数名称：getTrainSearchInfo
	 *  功能描述：
	 *  参数说明：搜索内容
	 *  返回值： 
	 *  备注：
	 * 
	 * 
	 * @throws SQLException
	 * @throws IOException
	 */
	public void getTrainSearchInfo(MyResquestWrapper request, MyResponseWrapper response) throws SQLException,IOException {
		String searchInfo = request.getParameter("searchInfo");
		JsonArray jsonData = new JsonArray();
		JsonObject out_json = new JsonObject();
		List<Train_Subject> tSubjects= trainService.getTrainSearchInfo(searchInfo);
		if(tSubjects.size()>0){
			for(int i=0;i<tSubjects.size();i++){
				jsonData.add(tSubjects.get(i).toJSON());
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
	 * 函数名称：getTrainSlides
	 *  功能描述：首页轮播
	 *  参数说明：
	 *  返回值： 
	 *  备注：
	 * 
	 * 
	 * @throws SQLException
	 * @throws IOException
	 */
	public void getTrainSlides(MyResquestWrapper request, MyResponseWrapper response) throws SQLException,IOException {
		JsonObject out_json = new JsonObject();
		Train_Subject  tSubjects= trainService.getTrainSlides();
		if(tSubjects!=null) {
			out_json.addProperty("msg",true);
			out_json.add("train", tSubjects.toJSON());
		}
		else {
			out_json.addProperty("msg",false);
			out_json.add("train", null);
		}
		PrintWriter out = response.getWriter();
		out.println(out_json);
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
		String Id = request.getParameter("Id");
		int result;
		result = trainService.judgeAttentionState(phonenumber,Id);
		//System.out.println(result);
		PrintWriter out = response.getWriter();
		out.println(result);
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
		String Id = request.getParameter("Id");
		boolean result = false;
		result = trainService.AddTrainAttention(phonenumber,Id);
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
		String Id = request.getParameter("Id");
		boolean result = false;
		result = trainService.DelTrainAttention(phonenumber,Id);
		PrintWriter out = response.getWriter();
		out.println(result);
		out.flush();
		out.close();
	}
	
	
	/**
	 * 函数名称：getTrainbyInfo 
	 * 功能描述：获得培训
	 * 参数说明：培训名，科目，报名金额
	 * 返回值：train 备注：
	 * 
	 */
	public void getTrainbyInfo(MyResquestWrapper request, MyResponseWrapper response) throws SQLException, IOException {
		String trainName = request.getParameter("trainName");
		String trainSubject = request.getParameter("trainSubject");
		int money = Integer.parseInt(request.getParameter("money"));
		String applyReport = request.getParameter("applyorder");
		/*System.out.println(trainName);
		System.out.println(trainSubject);
		System.out.println(money);
		System.out.println(applyReport);*/
		JsonObject out_json = new JsonObject();
		JsonObject jsonData = new JsonObject();

		Train_Subject train = trainService.getTrainbyInfo(trainName, trainSubject,money);
		/*System.out.println("1234"+train);*/
		if (train != null) {
			
			jsonData = train.toJSON();
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
	 * 
	 * 函数名称：getApplyList 功能描述：获取报名列表 参数说明： 返回值：void 备注：
	 * 
	 */
	public void getApplyList(MyResquestWrapper request, MyResponseWrapper response) throws IOException {
		int page = Integer.parseInt(request.getParameter("page"));
		JsonObject out_json = new JsonObject();
		JsonArray jsonData = new JsonArray();
		List<TrainApply> trainapply = trainService.getAllTrainApply(page);
		String total = trainService.getTrainApplyNum();
		for (int i = 0; i < trainapply.size(); i++) {
			jsonData.add(trainapply.get(i).toJSON());
		}
		out_json.addProperty("total", total);
		out_json.add("rows", jsonData);
		PrintWriter out = response.getWriter();
		out.println(out_json);
		
		out.flush();
		out.close();
	}
	
	public void getTrainApplyDetailbackground(MyResquestWrapper request, MyResponseWrapper response) throws IOException {
		String idcard = request.getParameter("idcard");
		String trainName = URLDecoder.decode(request.getParameter("trainName"), "UTF-8");
		String trainSubject = URLDecoder.decode(request.getParameter("trainSubject"), "UTF-8");
		int trainGrade = Integer.parseInt(request.getParameter("trainGrade"));
		JsonObject jsonData = new JsonObject();
		TrainApply trainapply = trainService.getTrainApplyDetailbackground(idcard,trainName,trainSubject,trainGrade);
		jsonData = trainapply.toJSON();
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
		List<TrainApply> trainapply = trainService.getTrainApply(starttime, endtime, options, Info, orderState, page);
		String total = trainService.getSearchNum(starttime, endtime, options, Info, orderState);
		for (int i = 0; i < trainapply.size(); i++) {
			jsonData.add(trainapply.get(i).toJSON());
		}
		out_json.addProperty("total", total);
		out_json.add("rows", jsonData);
		PrintWriter out = response.getWriter();
		out.println(jsonData);
		out.flush();
		out.close();
	}
	
	
	public void exportTrainApply(MyResquestWrapper request, MyResponseWrapper response) throws IOException {
		String starttime = request.getParameter("from");
		String endtime = request.getParameter("to");
		String options = request.getParameter("options");
		String Info =request.getParameter("info");
		int orderState = Integer.parseInt(request.getParameter("orderState"));
		JsonObject out_json = new JsonObject();
		JsonArray jsonData = new JsonArray();
		List<TrainApply> trainapply = trainService.exportTrainApply(starttime, endtime, options, Info, orderState);
		Excel excel = new Excel();
		String str = excel.exportTrainExcel(starttime, endtime, options, Info, orderState, trainapply);

		
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
	
	/**
	 * 函数名称：List 功能描述：获取比赛列表 参数说明： 返回值：void 备注：
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
		List<Train_Subject> train = trainService.getTrainList(page, type);
		
		for (int i = 0; i < train.size(); i++) {
			jsonData.add(train.get(i).toJSON());
			
		}
		String num = trainService.getTrainNum();
		// EasyUI json格式
		PrintWriter out = response.getWriter();
		if (type == 1) {
			out_json.addProperty("total", num);
			out_json.add("rows", jsonData);
		} else {
			out_json.addProperty("total", train.size());
			out_json.add("data", jsonData);
		}
		out.println(out_json);
		out.flush();
		out.close();
	}

	public void getteacherDetail(MyResquestWrapper request, MyResponseWrapper response) throws IOException {
		int tSubject_ID = Integer.parseInt(request.getParameter("tSubject_ID"));
		JsonArray jsonData = new JsonArray();
		JsonObject out_json = new JsonObject();
		List<Train_Teacher> teacher = trainService.getteacherDetail(tSubject_ID);
		for(int i=0;i<teacher.size();i++){
			jsonData.add(teacher.get(i).toJSON());
		}
		/*System.out.println(jsonData);*/
		PrintWriter out = response.getWriter();
		out_json.addProperty("total", teacher.size());
		out_json.add("rows", jsonData);
		/*System.out.println(out_json);*/
		out.println(out_json);
		out.flush();
		out.close();
	}

	/**
	 * 
	 * 函数名称：reviseTrainState 功能描述：修改比赛状态 参数说明： * 返回值：void 备注：
	 * 
	 * 
	 * @throws IOException
	 */
	public void reviseTrainState(MyResquestWrapper request, MyResponseWrapper response) throws IOException {
		int Id = Integer.parseInt(request.getParameter("ID"));
		int tSubject_EnrollState = Integer.parseInt(request.getParameter("tSubject_EnrollState"));
		System.out.println(tSubject_EnrollState);
		JsonObject out_json = new JsonObject();
		boolean result = false;
		result = trainService.reviseTrainState(Id, tSubject_EnrollState);
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
	 * 函数名称：detail 功能描述：获取培训详情 参数说明： 返回值：void 备注：
	 * 
	 */
	public void detail(MyResquestWrapper request, MyResponseWrapper response) throws IOException {
		int tSubject_ID = Integer.parseInt(request.getParameter("tSubject_ID"));
		int type = Integer.parseInt(request.getParameter("type"));
		JsonObject out_json = new JsonObject();
		JsonObject jsonData = new JsonObject();
		
		if (type == 3) {
			Train_Subject train = trainService.getTrainDetail(tSubject_ID);
			jsonData = train.toJSON_Add();
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
	
	
	public void getAllMechanism(MyResquestWrapper request, MyResponseWrapper response) throws IOException{
		
		JsonObject out_json = new JsonObject();
		JsonArray jsonData=new JsonArray(); 
		List<Train_Info> train = trainService.getAllMechanism();
		for(int i = 0;i < train.size();i++){
			jsonData.add(train.get(i).toJSON());
		}
		PrintWriter out = response.getWriter();
		out_json.addProperty("total", train.size());
		out_json.add("rows", jsonData);
		out.println(out_json);
		out.flush();
		out.close();
	}
	
public void getAllTrain(MyResquestWrapper request, MyResponseWrapper response) throws IOException{
		
		JsonObject out_json = new JsonObject();
		JsonArray jsonData=new JsonArray(); 
		List<Train_Subject> train = trainService.getAllTrain();
		for(int i = 0;i < train.size();i++){
			jsonData.add(train.get(i).toJSON());
		}
		PrintWriter out = response.getWriter();
		out_json.addProperty("total", train.size());
		out_json.add("rows", jsonData);
		out.println(out_json);
		out.flush();
		out.close();
	}
}

