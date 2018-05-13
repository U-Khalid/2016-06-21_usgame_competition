package cn.usgame.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jdt.internal.compiler.batch.Main;

import cn.usgame.entity.ApplyReport;
import cn.usgame.entity.CampApply;
import cn.usgame.entity.CompetitionGrade;
import cn.usgame.entity.TrainApply;
import jxl.Cell;
import jxl.CellType;
import jxl.DateCell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.format.UnderlineStyle;
import jxl.format.VerticalAlignment;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class Excel {

	public Excel() {
	}

	public String exportExcel(String starttime, String endtime, String options, String Info, int orderState,
			List<ApplyReport> applyReports) {
		StringBuffer fileurl = new StringBuffer("C:\\\\exportfile\\\\");
		File f = new File(fileurl.toString());
		if(!f.exists())
		{
			f.mkdirs();
		}
		int type = Integer.parseInt(options);
		if (!starttime.equals("") && !endtime.equals("")) {
			fileurl.append(starttime + "至" + endtime);
		}
		if (!Info.equals("")) {
			if (type == 1) {
				fileurl.append("注册号码为" + Info);
			} else {
				fileurl.append(Info);
			}
		}
		if (orderState == 2) {
			fileurl.append("全部订单");
		}
		if (orderState == 1) {
			fileurl.append("已付款订单");
		}
		if (orderState == 0) {
			fileurl.append("未付款订单");
		}
		fileurl.append(".xls");
		System.out.println(fileurl.toString());
		WritableWorkbook wwb = null;
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(fileurl.toString());
			wwb = Workbook.createWorkbook(fos);
			WritableSheet ws = wwb.createSheet("资优少年报名表单", 0); // 创建一个工作表

			// 设置单元格的文字格式
			WritableFont wf = new WritableFont(WritableFont.ARIAL, 12, WritableFont.NO_BOLD, false,
					UnderlineStyle.NO_UNDERLINE);
			WritableCellFormat wcf = new WritableCellFormat(wf);
			wcf.setVerticalAlignment(VerticalAlignment.CENTRE);
			// wcf.setAlignment(Alignment.CENTRE);
			for (int j = 0; j <= 12; j++) {
				ws.setColumnView(j, 25);
			}
			ws.setRowView(1, 500);

			ws.addCell(new Label(0, 0, "编号", wcf));
			ws.addCell(new Label(1, 0, "姓名", wcf));
			ws.addCell(new Label(2, 0, "学校", wcf));
			ws.addCell(new Label(3, 0, "比赛名称", wcf));
			ws.addCell(new Label(4, 0, "比赛年级", wcf));
			ws.addCell(new Label(5, 0, "科目", wcf));
			ws.addCell(new Label(6, 0, "报名时间", wcf));
			ws.addCell(new Label(7, 0, "付款状态(1:已付，0:未付)", wcf));
			ws.addCell(new Label(8, 0, "金额", wcf));
			ws.addCell(new Label(9, 0, "注册号码", wcf));
			ws.addCell(new Label(10, 0, "联系人", wcf));
			ws.addCell(new Label(11, 0, "联系电话", wcf));
			ws.addCell(new Label(12, 0, "身份证号", wcf));

			for (int i = 0; i < applyReports.size(); i++) {
				ws.addCell(new Label(0, i + 1, applyReports.get(i).getOut_trade_no(), wcf));
				ws.addCell(new Label(1, i + 1, applyReports.get(i).getName(), wcf));
				ws.addCell(new Label(2, i + 1, applyReports.get(i).getSchool(), wcf));
				ws.addCell(new Label(3, i + 1, applyReports.get(i).getCompetitionName(), wcf));
				ws.addCell(new Label(4, i + 1, String.valueOf(applyReports.get(i).getCompetitionGrade()), wcf));
				ws.addCell(new Label(5, i + 1, applyReports.get(i).getCompetitionSubject(), wcf));
				ws.addCell(new Label(6, i + 1, String.valueOf(applyReports.get(i).getApplyReportTime()), wcf));
				ws.addCell(new Label(7, i + 1, String.valueOf(applyReports.get(i).getApplyReportState()), wcf));
				ws.addCell(new Label(8, i + 1, String.valueOf(applyReports.get(i).getMoney()), wcf));
				ws.addCell(new Label(9, i + 1, applyReports.get(i).getPhoneNumber(), wcf));
				ws.addCell(new Label(10, i + 1, applyReports.get(i).getContectName(), wcf));
				ws.addCell(new Label(11, i + 1, applyReports.get(i).getContectPhone(), wcf));
				ws.addCell(new Label(12, i + 1, applyReports.get(i).getIdCard(), wcf));
			}
			wwb.write();
		} catch (Exception e) {
		} finally {
			try {
				wwb.close();
				fos.close();
				return fileurl.toString();
			} catch (Exception e) {
				return null;
			}
		}
	}
	
	
	public String exportGradeExcel(String Info,List<CompetitionGrade> competitiongrades) {
		StringBuffer fileurl = new StringBuffer("C:\\\\exportfile\\\\");
		File f = new File(fileurl.toString());
		if(!f.exists())
		{
			f.mkdirs();
		}
		if (!Info.equals("")) {
			fileurl.append(Info);
		}
		else {
			fileurl.append("所有成绩列表");
		}
		fileurl.append(".xls");
		System.out.println(fileurl.toString());
		WritableWorkbook wwb = null;
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(fileurl.toString());
			wwb = Workbook.createWorkbook(fos);
			WritableSheet ws = wwb.createSheet("资优少年成绩表单", 0); // 创建一个工作表

			// 设置单元格的文字格式
			WritableFont wf = new WritableFont(WritableFont.ARIAL, 12, WritableFont.NO_BOLD, false,
					UnderlineStyle.NO_UNDERLINE);
			WritableCellFormat wcf = new WritableCellFormat(wf);
			wcf.setVerticalAlignment(VerticalAlignment.CENTRE);
			// wcf.setAlignment(Alignment.CENTRE);
			for (int j = 0; j <= 9; j++) {
				ws.setColumnView(j, 25);
			}
			ws.setRowView(1, 500);

			ws.addCell(new Label(0, 0, "竞赛名称", wcf));
			ws.addCell(new Label(1, 0, "准考证号", wcf));
			ws.addCell(new Label(2, 0, "科目", wcf));
			ws.addCell(new Label(3, 0, "姓名", wcf));
			ws.addCell(new Label(4, 0, "年级", wcf));
			ws.addCell(new Label(5, 0, "密码", wcf));
			ws.addCell(new Label(6, 0, "成绩", wcf));
			ws.addCell(new Label(7, 0, "晋级情况", wcf));
			ws.addCell(new Label(8, 0, "奖项", wcf));
			ws.addCell(new Label(9, 0, "备注", wcf));

			for (int i = 0; i < competitiongrades.size(); i++) {
				ws.addCell(new Label(0, i + 1, competitiongrades.get(i).getCompetitionName(), wcf));
				ws.addCell(new Label(1, i + 1, competitiongrades.get(i).getAdmissionTicket(), wcf));
				ws.addCell(new Label(2, i + 1, competitiongrades.get(i).getCompetitionSubject(), wcf));
				ws.addCell(new Label(3, i + 1, competitiongrades.get(i).getUserName(), wcf));
				ws.addCell(new Label(4, i + 1, competitiongrades.get(i).getUserGrade(), wcf));
				ws.addCell(new Label(5, i + 1, competitiongrades.get(i).getPassword(), wcf));
				ws.addCell(new Label(6, i + 1, competitiongrades.get(i).getCompetitionGrade(), wcf));
				ws.addCell(new Label(7, i + 1, competitiongrades.get(i).getPromotion(), wcf));
				ws.addCell(new Label(8, i + 1, competitiongrades.get(i).getAward(), wcf));
				ws.addCell(new Label(9, i + 1, competitiongrades.get(i).getNote(), wcf));
				
			}
			wwb.write();
		} catch (Exception e) {
		} finally {
			try {
				wwb.close();
				fos.close();
				return fileurl.toString();
			} catch (Exception e) {
				return null;
			}
		}
	}
	
	
		
	public List<CompetitionGrade> importGradeExcel(String fileName) {
        Sheet sheet;
        Workbook book;
        Cell cell1,cell2,cell3,cell4,cell5,cell6,cell7,cell8,cell9,cell10;
        
        try { 
            //t.xls为要读取的excel文件名
            book = Workbook.getWorkbook(new File(fileName));
             
            //获得第一个工作表对象(ecxel中sheet的编号从0开始,0,1,2,3,....)
            sheet = book.getSheet(0); 
            //获取左上角的单元格
            //cell1 = sheet.getCell(0,0);
            // System.out.println("标题："+cell1.getContents()); 
             
            List<CompetitionGrade> competitionGrades = new ArrayList<CompetitionGrade>();
//            int rowNum=sheet.getRows();
            
           for(int i=1;;i++)
            {
            	CompetitionGrade competitionGrade = new CompetitionGrade();
                cell1=sheet.getCell(0,i);//（列，行）
                competitionGrade.setCompetitionName(cell1.getContents());
                
                if(cell1.getContents().equals("")||cell1.getContents().equals(null)){
                	break;
                }
                cell2=sheet.getCell(1,i);
                competitionGrade.setAdmissionTicket(cell2.getContents());
                
                cell3=sheet.getCell(2,i);
                competitionGrade.setCompetitionSubject(cell3.getContents());
                
                cell4=sheet.getCell(3,i);
                competitionGrade.setUserName(cell4.getContents());;
                
                cell5=sheet.getCell(4,i);//（列，行）
                competitionGrade.setUserGrade(cell5.getContents());
                
                cell6=sheet.getCell(5,i);//（列，行）
                competitionGrade.setPassword(cell6.getContents());
                
                cell7=sheet.getCell(6,i);//（列，行）
                competitionGrade.setCompetitionGrade(cell7.getContents());
                
                cell8=sheet.getCell(7,i);//（列，行）
                competitionGrade.setPromotion(cell8.getContents());
                
                cell9=sheet.getCell(8,i);//（列，行）
                competitionGrade.setAward(cell9.getContents());
                
                cell10=sheet.getCell(9,i);//（列，行）
                competitionGrade.setNote(cell10.getContents());
                
                competitionGrades.add(competitionGrade);
               
            }
            book.close(); 
            return competitionGrades;
        }
        catch(Exception e)  { 
        	return null;
        }
	}

	public List<ApplyReport> importstudentsExcel(String fileName) {
		Sheet sheet;
        Workbook book;
        Cell cell1,cell2,cell3,cell4,cell5,cell6,cell7,cell8,cell9,cell10,cell11;
        try { 
            //t.xls为要读取的excel文件名
            book = Workbook.getWorkbook(new File(fileName));
             
            //获得第一个工作表对象(ecxel中sheet的编号从0开始,0,1,2,3,....)
            sheet = book.getSheet(0); 
            //获取左上角的单元格
            //cell1 = sheet.getCell(0,0);
            // System.out.println("标题："+cell1.getContents()); 
             
            List<ApplyReport> applyReports = new ArrayList<ApplyReport>();
//            int rowNum=sheet.getRows();
            
           for(int i=1;;i++)
            {
        	   ApplyReport applyReport = new ApplyReport();
        	   
        	   Date now = new Date();
        	   SimpleDateFormat outFormat = new SimpleDateFormat("HHmmss");
        	   String time = outFormat.format(now);
        	   int temp = Integer.parseInt(time)*10000+randomId();
        	   applyReport.setApplyReportId(temp); 
        	   cell1=sheet.getCell(0,i);//（列，行）
        	   applyReport.setName(cell1.getContents());
                if(cell1.getContents().equals("")||cell1.getContents().equals(null)){
                	break;
                }
                cell2=sheet.getCell(1,i);
                applyReport.setSchool(cell2.getContents());
                
                cell3=sheet.getCell(2,i);
                applyReport.setCompetitionName(cell3.getContents());
                
                cell4=sheet.getCell(3,i);
                applyReport.setCompetitionGrade(Integer.parseInt(cell4.getContents()));
                
                cell5=sheet.getCell(4,i);//（列，行）
                applyReport.setCompetitionSubject(cell5.getContents());
                cell6=sheet.getCell(5,i);//（列，行）
                
                if(cell6.getType() == CellType.DATE){
           		 DateCell dc = (DateCell)cell6;
           		 Date date = dc.getDate();	//获取单元格的date类型
           		 applyReport.setApplyReportTime(date);
           	    }
//                String str=cell6.getContents();
//                System.out.println("str--------"+str);
//                SimpleDateFormat sim=new SimpleDateFormat("dd-MM-yy");
//                Date d=sim.parse(str);
//               applyReport.setApplyReportTime(date);
                cell7=sheet.getCell(6,i);//（列，行）
                applyReport.setMoney(Integer.parseInt(cell7.getContents()));
                
                cell8=sheet.getCell(7,i);//（列，行）
                applyReport.setPhoneNumber(cell8.getContents());
                
                cell9=sheet.getCell(8,i);//（列，行）
                applyReport.setContectName(cell9.getContents());
                
                cell10=sheet.getCell(9,i);//（列，行）
                applyReport.setContectPhone(cell10.getContents());
                
                cell11=sheet.getCell(10,i);//（列，行）
                applyReport.setIdCard(cell11.getContents());
                
                applyReports.add(applyReport);
                
               
            }
            book.close(); 
            return applyReports;
        }
        catch(Exception e)  { 
        	return null;
        }
	}
	private int randomId(){
		Random random = new Random();
		int a = random.nextInt(10000); 
		return a;
	}

	public String exportcampExcel(String starttime, String endtime, String options, String Info, int orderState,
			List<CampApply> campapply) {
		StringBuffer fileurl = new StringBuffer("C:\\\\exportfile\\\\");
		File f = new File(fileurl.toString());
		if(!f.exists())
		{
			f.mkdirs();
		}
		int type = Integer.parseInt(options);
		if (!starttime.equals("") && !endtime.equals("")) {
			fileurl.append(starttime + "至" + endtime);
		}
		if (!Info.equals("")) {
			if (type == 1) {
				fileurl.append("注册号码为" + Info);
			} else {
				fileurl.append(Info);
			}
		}
		if (orderState == 2) {
			fileurl.append("全部订单");
		}
		if (orderState == 1) {
			fileurl.append("已付款订单");
		}
		if (orderState == 0) {
			fileurl.append("未付款订单");
		}
		fileurl.append(".xls");
		System.out.println(fileurl.toString());
		WritableWorkbook wwb = null;
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(fileurl.toString());
			wwb = Workbook.createWorkbook(fos);
			WritableSheet ws = wwb.createSheet("资优少年报名表单", 0); // 创建一个工作表

			// 设置单元格的文字格式
			WritableFont wf = new WritableFont(WritableFont.ARIAL, 12, WritableFont.NO_BOLD, false,
					UnderlineStyle.NO_UNDERLINE);
			WritableCellFormat wcf = new WritableCellFormat(wf);
			wcf.setVerticalAlignment(VerticalAlignment.CENTRE);
			// wcf.setAlignment(Alignment.CENTRE);
			for (int j = 0; j <= 11; j++) {
				ws.setColumnView(j, 25);
			}
			ws.setRowView(1, 500);

			ws.addCell(new Label(0, 0, "编号", wcf));
			ws.addCell(new Label(1, 0, "姓名", wcf));
			ws.addCell(new Label(2, 0, "学校", wcf));
			ws.addCell(new Label(3, 0, "营地名称", wcf));
			ws.addCell(new Label(4, 0, "营地目的地", wcf));
/*			ws.addCell(new Label(5, 0, "科目", wcf));*/
			ws.addCell(new Label(5, 0, "报名时间", wcf));
			ws.addCell(new Label(6, 0, "付款状态(1:已付，0:未付)", wcf));
			ws.addCell(new Label(7, 0, "金额", wcf));
			ws.addCell(new Label(8, 0, "注册号码", wcf));
			ws.addCell(new Label(9, 0, "联系人", wcf));
			ws.addCell(new Label(10, 0, "联系电话", wcf));
			ws.addCell(new Label(11, 0, "身份证号", wcf));

			for (int i = 0; i < campapply.size(); i++) {
				ws.addCell(new Label(0, i + 1, campapply.get(i).getOut_trade_no(), wcf));
				ws.addCell(new Label(1, i + 1, campapply.get(i).getName(), wcf));
				ws.addCell(new Label(2, i + 1, campapply.get(i).getSchool(), wcf));
				ws.addCell(new Label(3, i + 1, campapply.get(i).getCamp_Name(), wcf));
				/*ws.addCell(new Label(4, i + 1, String.valueOf(campapply.get(i).getCompetitionGrade()), wcf));*/
				ws.addCell(new Label(4, i + 1, campapply.get(i).getCamp_Address(), wcf));
				ws.addCell(new Label(5, i + 1, String.valueOf(campapply.get(i).getApplyReportTime()), wcf));
				ws.addCell(new Label(6, i + 1, String.valueOf(campapply.get(i).getApplyReportState()), wcf));
				ws.addCell(new Label(7, i + 1, String.valueOf(campapply.get(i).getMoney()), wcf));
				ws.addCell(new Label(8, i + 1, campapply.get(i).getPhoneNumber(), wcf));
				ws.addCell(new Label(9, i + 1, campapply.get(i).getContectName(), wcf));
				ws.addCell(new Label(10, i + 1, campapply.get(i).getContectPhone(), wcf));
				ws.addCell(new Label(11, i + 1, campapply.get(i).getIdCard(), wcf));
			}
			wwb.write();
		} catch (Exception e) {
		} finally {
			try {
				wwb.close();
				fos.close();
				return fileurl.toString();
			} catch (Exception e) {
				return null;
			}
		}
	}

	public String exportTrainExcel(String starttime, String endtime, String options, String Info, int orderState,
			List<TrainApply> trainapply) {
		StringBuffer fileurl = new StringBuffer("C:\\\\exportfile\\\\");
		File f = new File(fileurl.toString());
		if(!f.exists())
		{
			f.mkdirs();
		}
		int type = Integer.parseInt(options);
		if (!starttime.equals("") && !endtime.equals("")) {
			fileurl.append(starttime + "至" + endtime);
		}
		if (!Info.equals("")) {
			if (type == 1) {
				fileurl.append("注册号码为" + Info);
			} else {
				fileurl.append(Info);
			}
		}
		if (orderState == 2) {
			fileurl.append("全部订单");
		}
		if (orderState == 1) {
			fileurl.append("已付款订单");
		}
		if (orderState == 0) {
			fileurl.append("未付款订单");
		}
		fileurl.append(".xls");
		System.out.println(fileurl.toString());
		WritableWorkbook wwb = null;
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(fileurl.toString());
			wwb = Workbook.createWorkbook(fos);
			WritableSheet ws = wwb.createSheet("资优少年报名表单", 0); // 创建一个工作表

			// 设置单元格的文字格式
			WritableFont wf = new WritableFont(WritableFont.ARIAL, 12, WritableFont.NO_BOLD, false,
					UnderlineStyle.NO_UNDERLINE);
			WritableCellFormat wcf = new WritableCellFormat(wf);
			wcf.setVerticalAlignment(VerticalAlignment.CENTRE);
			// wcf.setAlignment(Alignment.CENTRE);
			for (int j = 0; j <= 12; j++) {
				ws.setColumnView(j, 25);
			}
			ws.setRowView(1, 500);

			ws.addCell(new Label(0, 0, "编号", wcf));
			ws.addCell(new Label(1, 0, "姓名", wcf));
			ws.addCell(new Label(2, 0, "学校", wcf));
			ws.addCell(new Label(3, 0, "培训名称", wcf));
			ws.addCell(new Label(4, 0, "培训年级", wcf));
			ws.addCell(new Label(5, 0, "科目", wcf));
			ws.addCell(new Label(6, 0, "报名时间", wcf));
			ws.addCell(new Label(7, 0, "付款状态(1:已付，0:未付)", wcf));
			ws.addCell(new Label(8, 0, "金额", wcf));
			ws.addCell(new Label(9, 0, "注册号码", wcf));
			ws.addCell(new Label(10, 0, "联系人", wcf));
			ws.addCell(new Label(11, 0, "联系电话", wcf));
			ws.addCell(new Label(12, 0, "身份证号", wcf));

			for (int i = 0; i < trainapply.size(); i++) {
				ws.addCell(new Label(0, i + 1, trainapply.get(i).getOut_trade_no(), wcf));
				ws.addCell(new Label(1, i + 1, trainapply.get(i).getName(), wcf));
				ws.addCell(new Label(2, i + 1, trainapply.get(i).getSchool(), wcf));
				ws.addCell(new Label(3, i + 1, trainapply.get(i).gettrainName(), wcf));
				ws.addCell(new Label(4, i + 1, String.valueOf(trainapply.get(i).gettrainGrade()), wcf));
				ws.addCell(new Label(5, i + 1, trainapply.get(i).gettrainSubject(), wcf));
				ws.addCell(new Label(6, i + 1, String.valueOf(trainapply.get(i).getApplyReportTime()), wcf));
				ws.addCell(new Label(7, i + 1, String.valueOf(trainapply.get(i).getApplyReportState()), wcf));
				ws.addCell(new Label(8, i + 1, String.valueOf(trainapply.get(i).getMoney()), wcf));
				ws.addCell(new Label(9, i + 1, trainapply.get(i).getPhoneNumber(), wcf));
				ws.addCell(new Label(10, i + 1, trainapply.get(i).getContectName(), wcf));
				ws.addCell(new Label(11, i + 1, trainapply.get(i).getContectPhone(), wcf));
				ws.addCell(new Label(12, i + 1, trainapply.get(i).getIdCard(), wcf));
			}
			wwb.write();
		} catch (Exception e) {
		} finally {
			try {
				wwb.close();
				fos.close();
				return fileurl.toString();
			} catch (Exception e) {
				return null;
			}
		}
	}

	
}
