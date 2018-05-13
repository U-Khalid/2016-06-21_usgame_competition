package cn.usgame.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.google.gson.JsonObject;

public class TrainApply {
	private int applyReportId;//报名Id
	private int applyReportState;//报名状态
	private String name;//报名人姓名
	private String idCard;//身份证号
	private String school;//学校
	private int grade;//年级
	private String trainName;//比赛名字
	private String trainSubject;//比赛科目
	private int trainGrade;//比赛年级
	private String contectName;//联系人名字
	private String contectPhone;//联系电话
	private String out_trade_no;// 
	private String phoneNumber;//电话号码
	private int money;//金额
	private Date applyReportTime;//报名时间
	private int state;//订单状态（是否被删除	1-没有，0-已删除）
	
	public Date getApplyReportTime() {
		return applyReportTime;
	}
	public void setApplyReportTime(Date applyReportTime) {
		this.applyReportTime = applyReportTime;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
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
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public String gettrainName() {
		return trainName;
	}
	public void settrainName(String trainName) {
		this.trainName = trainName;
	}
	public String gettrainSubject() {
		return trainSubject;
	}
	public void settrainSubject(String trainSubject) {
		this.trainSubject = trainSubject;
	}
	public int gettrainGrade() {
		return trainGrade;
	}
	public void settrainGrade(int trainGrade) {
		this.trainGrade = trainGrade;
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
	
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public TrainApply(){}
	
	
	
	public TrainApply(int applyReportId, int applyReportState, String name, String idCard, String school, int grade,
			String trainName, String trainSubject, int trainGrade, String contectName,
			String contectPhone, String out_trade_no, String phoneNumber, int money, Date applyReportTime, int state) {
		super();
		this.applyReportId = applyReportId;
		this.applyReportState = applyReportState;
		this.name = name;
		this.idCard = idCard;
		this.school = school;
		this.grade = grade;
		this.trainName = trainName;
		this.trainSubject = trainSubject;
		this.trainGrade = trainGrade;
		this.contectName = contectName;
		this.contectPhone = contectPhone;
		this.out_trade_no = out_trade_no;
		this.phoneNumber = phoneNumber;
		this.money = money;
		this.applyReportTime = applyReportTime;
		this.state = state;
	}
	
	@Override
	public String toString() {
		return "ApplyReport [applyReportId=" + applyReportId + ", applyReportState=" + applyReportState + ", name="
				+ name + ", idCard=" + idCard + ", school=" + school + ", grade=" + grade + ", trainName="
				+ trainName + ", trainSubject=" + trainSubject + ", trainGrade="
				+ trainGrade + ", contectName=" + contectName + ", contectPhone=" + contectPhone
				+ ", out_trade_no=" + out_trade_no + ", phoneNumber=" + phoneNumber + ", money=" + money
				+ ", applyReportTime=" + applyReportTime + ", state=" + state + "]";
	}
	public JsonObject toJSON() {
		SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		JsonObject jsonData = new JsonObject();
		jsonData.addProperty("applyReportId", this.applyReportId);
		jsonData.addProperty("applyReportState", this.applyReportState);
		jsonData.addProperty("name", this.name);
		jsonData.addProperty("idCard", this.idCard);
		jsonData.addProperty("school", this.school);
		jsonData.addProperty("grade", this.grade);
		jsonData.addProperty("trainName", this.trainName);
		jsonData.addProperty("trainSubject", this.trainSubject);
		jsonData.addProperty("trainGrade", this.trainGrade);
		jsonData.addProperty("contectName", this.contectName);
		jsonData.addProperty("contectPhone", this.contectPhone);
		jsonData.addProperty("out_trade_no", this.out_trade_no);
		jsonData.addProperty("phoneNumber", this.phoneNumber);
		jsonData.addProperty("money", this.money);
		jsonData.addProperty("applyReportTime", s.format(this.applyReportTime));
		jsonData.addProperty("state", this.state);
		jsonData.addProperty("methodWay", "<a onclick='detail(\""+this.idCard+"\""+","+"\""+this.trainName+"\""+","+"\""+this.trainSubject+"\""+","+"\""+this.trainGrade+"\""+")'>查看详情</a>");
		//jsonData.addProperty("methodWay", "<a onclick='detail("+this.idCard+","+this.trainName+","+this.trainSubject+","+this.trainGrade+")'>查看详情</a>");
		
		return jsonData;
	}
	
	public StringBuffer returnsql(String starttime, String endtime, String options, String Info,int orderState) {
		int type = Integer.parseInt(options);
		StringBuffer sql = new StringBuffer(); 
		sql.append("from trainapply where ");
		if(!starttime.equals("")&&!endtime.equals("")) {
			sql.append(" applyReportTime Between '"+starttime+"' and '"+endtime+"' ");
			if(!Info.equals("")) {
				if(type==1) {
					sql.append("and  phoneNumber='"+Info+"' ");
				}
				else {
					sql.append("and  trainName like '%"+Info+"%' ");
				}
			}
		} 
		else {
			if(!Info.equals("")) {
				if(type==1) {
					sql.append(" phoneNumber='"+Info+"' ");
				}
				else {
					sql.append(" trainName like '%"+Info+"%' ");
				}
			}
		}
		
		if(orderState==2) {
			if((!starttime.equals("")&&!endtime.equals(""))||(!Info.equals(""))) {
				return sql;
			}
			else {
				sql=new StringBuffer().append("from trainapply ");
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



