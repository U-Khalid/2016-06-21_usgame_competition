package cn.usgame.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.google.gson.JsonObject;

public class CompetitionGrade {
	private String competitionName;// 比赛名字
	private String admissionTicket;// 准考证号
	private String competitionSubject;// 比赛科目
	private String userName;// 用户名字
	private String userGrade; // 用户年级
	private String password;// 查询密码
	private String competitionGrade;// 用户成绩
	private String promotion;// 晋级情况
	private String award; // 奖项
	private String note;// 备注
	
	
	public CompetitionGrade() {}


	public CompetitionGrade(String competitionName, String admissionTicket, String competitionSubject, String userName,
			String userGrade, String password, String competitionGrade, String promotion, String award, String note) {
		super();
		this.competitionName = competitionName;
		this.admissionTicket = admissionTicket;
		this.competitionSubject = competitionSubject;
		this.userName = userName;
		this.userGrade = userGrade;
		this.password = password;
		this.competitionGrade = competitionGrade;
		this.promotion = promotion;
		this.award = award;
		this.note = note;
	}


	public String getCompetitionName() {
		return competitionName;
	}


	public void setCompetitionName(String competitionName) {
		this.competitionName = competitionName;
	}


	public String getAdmissionTicket() {
		return admissionTicket;
	}


	public void setAdmissionTicket(String admissionTicket) {
		this.admissionTicket = admissionTicket;
	}


	public String getCompetitionSubject() {
		return competitionSubject;
	}


	public void setCompetitionSubject(String competitionSubject) {
		this.competitionSubject = competitionSubject;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getUserGrade() {
		return userGrade;
	}


	public void setUserGrade(String userGrade) {
		this.userGrade = userGrade;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getCompetitionGrade() {
		return competitionGrade;
	}


	public void setCompetitionGrade(String competitionGrade) {
		this.competitionGrade = competitionGrade;
	}


	public String getPromotion() {
		return promotion;
	}


	public void setPromotion(String promotion) {
		this.promotion = promotion;
	}


	public String getAward() {
		return award;
	}


	public void setAward(String award) {
		this.award = award;
	}


	public String getNote() {
		return note;
	}


	public void setNote(String note) {
		this.note = note;
	}


	@Override
	public String toString() {
		return "CompetitionGrade [competitionName=" + competitionName + ", admissionTicket=" + admissionTicket
				+ ", competitionSubject=" + competitionSubject + ", userName=" + userName + ", userGrade=" + userGrade
				+ ", password=" + password + ", competitionGrade=" + competitionGrade + ", promotion=" + promotion
				+ ", award=" + award + ", note=" + note + "]";
	}
	
	public JsonObject toJSON() {
		
		JsonObject jsonData = new JsonObject();
		jsonData.addProperty("competitionName", this.competitionName);
		jsonData.addProperty("admissionTicket", this.admissionTicket);
		jsonData.addProperty("competitionSubject", this.competitionSubject);
		jsonData.addProperty("userName", this.userName);
		jsonData.addProperty("userGrade", this.userGrade);
		jsonData.addProperty("password", this.password);
		jsonData.addProperty("competitionGrade", this.competitionGrade);
		jsonData.addProperty("promotion", this.promotion);
		jsonData.addProperty("award", this.award);
		jsonData.addProperty("note", this.note);
		return jsonData;
	}
	
}
