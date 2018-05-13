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

import com.google.gson.JsonObject;

import cn.usgame.entity.Competition;
import cn.usgame.service.CompetitionService;
import cn.usgame.service.ServiceFactory;


@WebServlet("/uploadCompetition")
public class uploadCompetition extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CompetitionService comService = ServiceFactory.getInstance().getProgramManage();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean result=false;
		String message="";
		Competition competition= new Competition();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
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
					if(name.equals("competitionId"))
					{
						competition.setCompetitionId(value);
					}
					if(name.equals("competitionName"))
					{
						competition.setCompetitionName(value);
					}
					if(name.equals("competitionSubject"))
					{
						competition.setCompetitionSubject(value);
					}
					if(name.equals("competitionApplyStartTime"))
					{
						competition.setCompetitionApplyStartTime(sdf.parse(value));
					}
					if(name.equals("competitionApplyEndTime"))
					{
						competition.setCompetitionApplyEndTime(sdf.parse(value));
					}
					if(name.equals("competitionJoinerDes"))
					{
						competition.setCompetitionJoinerDes(value);
					}
					if(name.equals("competitionMoney"))
					{
						competition.setCompetitionMoney(value);
					}
					if(name.equals("competitionType"))
					{
						competition.setCompetitionType(Integer.parseInt(value));
					}
					if(name.equals("competitionPrizeDes"))
					{
						competition.setCompetitionPrizeDes(value);
					}
					if(name.equals("competitionTestTimeDes"))
					{
						competition.setCompetitionTestTimeDes(value);
					}
					if(name.equals("competitionApplyAddress"))
					{
						competition.setCompetitionApplyAddress(value);
					}
					if(name.equals("competitionTestAddress"))
					{
						competition.setCompetitionTestAddress(value);
					}
					if(name.equals("competitionDetail"))
					{
						competition.setCompetitionDetail(value);
					}
					if(name.equals("competitionSupportDesc"))
					{
						competition.setCompetitionSupportDesc(value);
					}
					if(name.equals("competitionForm"))
					{
						competition.setCompetitionForm(Integer.parseInt(value));
					}
					if(name.equals("competitionGrade"))
					{
						competition.setCompetitionGrade(value);
					}
					if(name.equals("state"))
					{
						competition.setState(Integer.parseInt(value));
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
					if(fileformName.equals("competitionBigPic")){
						competition.setCompetitionBigPic(filename);
					}
					if(fileformName.equals("competitionPic")){
						competition.setCompetitionPic(filename);
					}
					in.close();
					out.close();
					item.delete();  //删除处理文件上传时生成的临时文件
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		result = comService.addCompetition(competition);
		String state;
		if(result) {
			state="竞赛创建成功";
			if(!message.equals("")){
				state = state+","+message;
			}
		}
		else {
			state="竞赛创建失败";
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
