package cn.usgame.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


import cn.usgame.entity.Train_Teacher;
import cn.usgame.service.ServiceFactory;
import cn.usgame.service.TrainService;

/**
 * Servlet implementation class uploadTeacher
 */
@WebServlet("/uploadTeacher")
public class uploadTeacher extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TrainService trainservice = ServiceFactory.getInstance().getTrainManage();   
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean result=false;
		String message="";
		Train_Teacher teacher= new Train_Teacher();
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
					String name = item.getFieldName(); // 得到输入项的名称
					// String value = item.
					byte[] buf = item.get();
					String value = new String(buf, "utf-8");
					
					System.out.println(name + "=" + value);
					/*if(name.equals("tTeacher_ID"))
					{
						teacher.settTeacher_ID(value);
					}*/
					if(name.equals("tSubject_ID"))
					{
						teacher.settSubject_ID(Integer.parseInt(value));
					}
					if(name.equals("tTeacher_Name"))
					{
						teacher.settTeacher_Name(value);
					}
					if(name.equals("tTeacher_Info"))
					{
						teacher.settTeacher_Info(value);
					}
					if(name.equals("tTeacher_Sex"))
					{
						teacher.settTeacher_Sex(Integer.parseInt(value));
					}
					if(name.equals("tTeahcer_Price"))
					{
						teacher.settTeacher_Price(Integer.parseInt(value));
						//System.out.println("2313=========="+teacher.gettTeacher_Price());
					}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		result = trainservice.addTeacher(teacher);
		String state;
		if(result) {
			state="教师信息创建成功";
			if(!message.equals("")){
				state = state+","+message;
			}
		}
		else {
			state="教师信息创建失败";
			state = state+"----"+message;
		}
		//JsonObject out_json = new JsonObject();
		//out_json.addProperty("msg", result);
		PrintWriter out = response.getWriter();
		out.println(state);
		out.flush();
		out.close();
	}
	


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
