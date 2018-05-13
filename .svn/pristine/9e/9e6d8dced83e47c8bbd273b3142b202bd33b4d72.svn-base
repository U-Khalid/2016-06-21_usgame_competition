package cn.usgame.entity;

import java.util.Date;
import java.text.SimpleDateFormat;

import com.google.gson.JsonObject;

public class CampApply {
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
	private String out_trade_no;			//订单编号
	private String phoneNumber;				//电话号码
	private int money;						//金额
	private Date applyReportTime;			//报名时间
	private int state;						//订单状态（是否被删除	1-没有，0-已删除）
	
	public CampApply() {}
	
	
	
	
	public CampApply(int applyReportId, int applyReportState, String name, String idCard, String school, String address,
			String camp_Name, String camp_Address, int camp_Age, String contectName, String contectPhone,
			String out_trade_no, String phoneNumber, int money, Date applyReportTime, int state) {
		super();
		this.applyReportId = applyReportId;
		this.applyReportState = applyReportState;
		this.name = name;
		this.idCard = idCard;
		this.school = school;
		this.address = address;
		this.camp_Name = camp_Name;
		this.camp_Address = camp_Address;
		this.camp_Age = camp_Age;
		this.contectName = contectName;
		this.contectPhone = contectPhone;
		this.out_trade_no = out_trade_no;
		this.phoneNumber = phoneNumber;
		this.money = money;
		this.applyReportTime = applyReportTime;
		this.state = state;
	}



	public int getApplyReportId() {
		return applyReportId;
	}
	public void setApplyReportId(int applyReportId) {
		this.applyReportId = applyReportId;
	}
	public int getApplyReportState() {
		return applyReportState;
	}
	public void setApplyReportState(int applyReportState) {
		this.applyReportState = applyReportState;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCamp_Name() {
		return camp_Name;
	}
	public void setCamp_Name(String camp_Name) {
		this.camp_Name = camp_Name;
	}
	public String getCamp_Address() {
		return camp_Address;
	}
	public void setCamp_Address(String camp_Address) {
		this.camp_Address = camp_Address;
	}
	public int getCamp_Age() {
		return camp_Age;
	}
	public void setCamp_Age(int camp_Age) {
		this.camp_Age = camp_Age;
	}
	public String getContectName() {
		return contectName;
	}
	public void setContectName(String contectName) {
		this.contectName = contectName;
	}
	public String getContectPhone() {
		return contectPhone;
	}
	public void setContectPhone(String contectPhone) {
		this.contectPhone = contectPhone;
	}
	public String getOut_trade_no() {
		return out_trade_no;
	}
	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public Date getApplyReportTime() {
		return applyReportTime;
	}
	public void setApplyReportTime(Date applyReportTime) {
		this.applyReportTime = applyReportTime;
	}

	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	
	
	@Override
	public String toString() {
		return "CampApply [applyReportId=" + applyReportId + ", applyReportState=" + applyReportState + ", name=" + name
				+ ", idCard=" + idCard + ", school=" + school + ", address=" + address + ", camp_Name=" + camp_Name
				+ ", camp_Address=" + camp_Address + ", camp_Age=" + camp_Age + ", contectName=" + contectName
				+ ", contectPhone=" + contectPhone + ", out_trade_no=" + out_trade_no + ", phoneNumber=" + phoneNumber
				+ ", money=" + money + ", applyReportTime=" + applyReportTime + ", state=" + state + "]";
	}
	
	
	public JsonObject toJSON() {
		JsonObject jsonData = new JsonObject();
		SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		jsonData.addProperty("applyReportId",this.applyReportId );
		jsonData.addProperty("applyReportState", this.applyReportState);
		jsonData.addProperty("name", this.name);
		jsonData.addProperty("idCard", this.idCard);
		jsonData.addProperty("school", this.school);
		jsonData.addProperty("address", this.address);
		jsonData.addProperty("camp_Name", this.camp_Name);
		jsonData.addProperty("camp_Address", this.camp_Address);
		jsonData.addProperty("camp_Age", this.camp_Age);
		jsonData.addProperty("contectName", this.contectName);
		jsonData.addProperty("contectPhone", this.contectPhone);
		jsonData.addProperty("out_trade_no", this.out_trade_no);
		jsonData.addProperty("phoneNumber", this.phoneNumber);
		jsonData.addProperty("money", this.money);
		jsonData.addProperty("applyReportTime", s.format(this.applyReportTime));
		jsonData.addProperty("state", this.state);
		jsonData.addProperty("methodWay", "<a onclick='detail(\""+this.idCard+"\""+","+"\""+this.camp_Name+"\""+","+"\""+this.camp_Address+"\""+","+"\""+this.camp_Age+"\""+")'>查看详情</a>");
		return jsonData;
	}




	public StringBuffer returnsql(String starttime, String endtime, String options, String Info, int orderState) {
		int type = Integer.parseInt(options);
		StringBuffer sql = new StringBuffer(); 
		sql.append("from campapply where ");
		if(!starttime.equals("")&&!endtime.equals("")) {
			sql.append(" applyReportTime Between '"+starttime+"' and '"+endtime+"' ");
			if(!Info.equals("")) {
				if(type==1) {
					sql.append("and  phoneNumber='"+Info+"' ");
				}
				else {
					sql.append("and  camp_Name like '%"+Info+"%' ");
				}
			}
		} 
		else {
			if(!Info.equals("")) {
				if(type==1) {
					sql.append(" phoneNumber='"+Info+"' ");
				}
				else {
					sql.append(" camp_Name like '%"+Info+"%' ");
				}
			}
		}
		
		if(orderState==2) {
			if((!starttime.equals("")&&!endtime.equals(""))||(!Info.equals(""))) {
				return sql;
			}
			else {
				sql=new StringBuffer().append("from campapply ");
				return sql;
			}
		}
		else {
			if((!starttime.equals("")&&!endtime.equals(""))||(!Info.equals(""))) {
				sql.append(" and applyReportState="+orderState);
			}
			else {
				sql.append(" applyReportState="+orderState);
			}
			return sql;
		}
	}   
		
}
