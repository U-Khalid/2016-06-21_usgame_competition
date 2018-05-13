package cn.usgame.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import cn.usgame.entity.Camp;
import cn.usgame.entity.Competition;
import cn.usgame.entity.Train_Info;
import cn.usgame.entity.Train_Subject;
import cn.usgame.service.CompetitionService;
import cn.usgame.service.ServiceFactory;
import cn.usgame.service.TrainService;

/**
 * Servlet implementation class uploadTrain
 */
@WebServlet("/uploadTrain")
public class uploadTrain extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TrainService trainservice = ServiceFactory.getInstance().getTrainManage();   
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean result=false;
		String message="";
		Train_Subject train= new Train_Subject();
		try {
			// 1.得到解析器工厂
			DiskFileItemFactory factory = new DiskFileItemFactory();

			// 2.得到解析器
			ServletFileUpload upload = new ServletFileUpload(factory);

			// 3.判断上传表单的类型
			if (!upload.isMultipartContent(request)) {
				// 上传表单为普通表单，则按照传统方式获取数据即可
				return;
			}
			// 为上传表单，则调用解析器解析上传数据
			List<FileItem> list = upload.parseRequest(request); // FileItem

			// 遍历list，得到用于封装第一个上传输入项数据fileItem对象
			for (FileItem item : list) {

				if (item.isFormField()) {
					// 得到的是普通输入项
					String name = item.getFieldName(); // 得到输入项的名称
					// String value = item.
					byte[] buf = item.get();
					String value = new String(buf, "utf-8");
					
					System.out.println(name + "=" + value);
					if(name.equals("tSubject_ID"))
					{
						if(!value.equals("")){
							train.settSubject_ID(Integer.parseInt(value));
						}
					}
					if(name.equals("tSubject_CourseName"))
					{
						train.settSubject_CourseName(value);
					}
					if(name.equals("tMechanism_ID"))
					{
						Train_Info ti = new Train_Info();
						ti.settMechanism_ID(Integer.parseInt(value));
						train.settMechanismInfo(ti);
						//System.out.println("2131===="+train.gettMechanismInfo().gettMechanism_ID());
					}
					if(name.equals("tSubject_Course"))
					{
						train.settSubject_Course(value);
					}
					if(name.equals("tSubject_Detail"))
					{
						train.settSubject_Detail(value);
					}
					if(name.equals("tSubject_EnrollStart"))
					{
						train.settSubject_EnrollStart(value);
					}
					if(name.equals("tSubject_EnrollEnd"))
					{
						train.settSubject_EnrollEnd(value);
					}
					if(name.equals("tSubject_Start"))
					{
						train.settSubject_Start(value);
					}
					if(name.equals("tSubject_End"))
					{
						train.settSubject_End(value);
					}
					if(name.equals("tSubject_Form"))
					{
						train.settSubject_Form(value);
					}
					if(name.equals("tSubject_Grade"))
					{
						train.settSubject_Grade(value);
					}
					if(name.equals("tSubject_Times"))
					{
						train.settSubject_Times(Integer.parseInt(value));
					}
					if(name.equals("tSubject_DetailTime"))
					{
						train.settSubject_DetailTime(value);
					}
					if(name.equals("tSubject_Personnel"))
					{
						train.settSubject_Personnel(value);
					}
					if(name.equals("tSubject_EnrollAddress"))
					{
						train.settSubject_EnrollAddress(value);
					}
					
				} else {
					// 得到上传输入项
					String fileformName = item.getFieldName();
					String filename = item.getName(); // 得到上传文件名
					if(filename==null || filename.trim().equals("")){
						System.out.println("文件不存在！");
						message="但是有图片未上传";
						continue;
					}
					filename = filename.substring(filename.lastIndexOf("\\") + 1);
					//得到上传文件的扩展名
					String fileExtName = filename.substring(filename.lastIndexOf(".")+1);
					String[] allowTypes = {"png","jpg","bmp","PNG","JPG","BMP","JPGE","jpge"};
					if(!isPic(fileExtName,allowTypes)){
						message="图片格式错误，不应该为"+fileExtName+"格式";
						System.out.println(message);
						break;
					}
					System.out.println("扩展名："+fileExtName);
					String time = String.valueOf(System.currentTimeMillis() / 1000);
					filename = time+"_"+filename;
					InputStream in = item.getInputStream(); // 得到上传数据
					int len = 0;
					byte buffer[] = new byte[1024];

					// 用于保存上传文件的目录应该禁止外界直接访问
					String savepath = this.getServletContext().getRealPath("/images/main");
					File f = new File(savepath);
					if(!f.exists())
					{
						f.mkdirs();
					}
					System.out.println(savepath);
					FileOutputStream out = new FileOutputStream(savepath + "\\" + filename); // 向upload目录中写入文件
					while ((len = in.read(buffer)) > 0) {
						out.write(buffer, 0, len);
					}
					if(fileformName.equals("tSubject_BigPic")){
						train.settSubject_BigPic(filename);
					}
					if(fileformName.equals("tSubject_PictureUrl")){
						train.settSubject_PictureUrl(filename);
					}
					in.close();
					out.close();
					item.delete();  //删除处理文件上传时生成的临时文件
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		result = trainservice.addTrain(train);
		String state;
		if(result) {
			state="培训创建成功";
			if(!message.equals("")){
				state = state+","+message;
			}
		}
		else {
			state="培训创建失败";
			state = state+"----"+message;
		}
		//JsonObject out_json = new JsonObject();
		//out_json.addProperty("msg", result);
		PrintWriter out = response.getWriter();
		out.println(state);
		out.flush();
		out.close();
	}
	
	private boolean isPic(String fileExtName, String[] allowTypes) {
		for(String type:allowTypes) {
			if(fileExtName.equals(type)){
				return true;
			}
		}
		return false;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
