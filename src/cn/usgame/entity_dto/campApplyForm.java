package cn.usgame.entity_dto;

/*import java.sql.Date;*/
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import cn.usgame.entity.CampApply;
import cn.usgame.pay.WeChatCount;
import cn.usgame.utils.WebUtils;

public class campApplyForm {
	private int applyReportId;              //报名ID
	private int applyReportState;		    //报名状态
	private String name;					//报名人姓名
	private String idCard;					//身份证号
	private String school;					//学校
	private String address;					//联系地址
	private String camp_Name;				//营地名字
	private String camp_Address;			//营地目的地
	private int camp_Age;					//年龄限定
	private String contectName;				//联系人名字
	private String contectPhone;			//联系人电话
	private String out_trade_no;			//
	private String phoneNumber;				//电话号码
	private int money;						//金额
	
	
	public campApplyForm() {}
	
	public CampApply toCampApply(){
		CampApply campApply = new CampApply();
		campApply.setApplyReportId(this.applyReportId);
		campApply.setApplyReportState(this.applyReportState);
		campApply.setName(this.name);
		campApply.setIdCard(this.idCard);
		campApply.setSchool(this.school);
		campApply.setAddress(this.address);
		campApply.setCamp_Name(this.camp_Name);
		campApply.setCamp_Address(this.camp_Address);
		campApply.setCamp_Age(this.camp_Age);
		campApply.setContectName(this.contectName);
		campApply.setContectPhone(this.contectPhone);
		campApply.setOut_trade_no(this.out_trade_no);
		campApply.setPhoneNumber(this.phoneNumber);
		campApply.setMoney(this.money);
		campApply.setApplyReportTime(new Date());
		return campApply;
		
	}
	
	public campApplyForm(Map<String, String[]> map,String phoneNumber){
		this.name = map.get("name")[0];
		this.idCard = map.get("idCard")[0];
		this.school = map.get("school")[0];
		this.address = map.get("address")[0];
		this.camp_Name = map.get("camp_Name")[0];
		this.camp_Address = map.get("camp_Address")[0];
		this.camp_Age = Integer.parseInt(map.get("camp_Age")[0]);
		this.contectName = map.get("contectName")[0];
		this.contectPhone = map.get("contectPhone")[0];
		Date now = new Date();
		SimpleDateFormat outFormat = new SimpleDateFormat("HHmmss");
		String time = outFormat.format(now);
		this.applyReportId =Integer.parseInt(time)*10000+randomId();
		this.phoneNumber = phoneNumber;
		this.money = Integer.parseInt(map.get("money")[0]);
		this.out_trade_no = WebUtils.getTimeStamp()+String.valueOf(randomId()) + new WeChatCount().getAppid();
	}
	
	private int randomId(){
		Random random = new Random();
		int a = random.nextInt(10000); 
		return a;
	}
	
	public boolean  judgeIdcard() {
		boolean result = true;
		Pattern p = Pattern.compile("^[1-9]\\d{7}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}$");
		Matcher m = p.matcher(this.idCard);
		boolean flag= m.matches();
		
		Pattern p1 = Pattern.compile("^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{4}$");
		Matcher m1= p1.matcher(this.idCard);
		boolean flag1= m1.matches();
		
		if(flag||flag1) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean judgePhoneNum() {
		//电信号码格式
		Pattern p = Pattern.compile("(^1(33|53|77|8[019])\\d{8}$)|(^1700\\d{7}$)");
		Matcher m = p.matcher(this.contectPhone);
		boolean flag= m.matches();

		//联通号码格式
		Pattern p1 = Pattern.compile("(^1(3[0-2]|4[5]|5[56]|7[6]|8[56])\\d{8}$)|(^1709\\d{7}$)");
		Matcher m1 = p1.matcher(this.contectPhone);
		boolean flag1= m1.matches();

		//移动号码格式
		Pattern p2 = Pattern.compile("(^1(3[4-9]|4[7]|5[0-27-9]|7[8]|8[2-478])\\d{8}$)|(^1705\\d{7}$)");
		Matcher m2 = p2.matcher(this.contectPhone);
		boolean flag2= m2.matches();

		if(flag||flag1||flag2) {
			return true;
		}
		else {
			return false;
		}
	}
	
}
