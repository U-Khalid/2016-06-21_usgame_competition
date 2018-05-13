package cn.usgame.entity;

import java.text.SimpleDateFormat;
import java.util.Date;
import com.google.gson.JsonObject;


public class Competition {
	
	private String competitionId;// 比赛ID
	private String competitionName;// 比赛名字
	private String competitionSubject;// 比赛科目
	private Date competitionApplyStartTime;// 比赛开始报名时间
	private Date competitionApplyEndTime; // 比赛结束报名时间
	private String competitionJoinerDes;// 参加人员描述
	private String competitionMoney;// 比赛报名费用
	private int competitionType;// 比赛类型--初赛，决赛
	private String competitionPrizeDes; // 比赛奖项描述
	
	private String competitionTestTimeDes;// 比赛开始时间
	private String competitionApplyAddress;// 比赛报名地址
	private String competitionTestAddress;// 比赛地址
	private String competitionDetail;// 比赛详细信息
	private int competitionState; // 比赛状态 ，结束，正在报名
	private String competitionSupportDesc; //比赛主办方描述
	private int competitionForm;//比赛形式 1：笔试 2:听力 3:笔试加听力
	private String competitionGrade;//比赛年级
	private int state;  // state为1表示该竞赛放置在首页，为0无操作，首页只显示4个竞赛，按照竞赛id降序，即越迟添加的竞赛排位越靠前。
	private String competitionBigPic;  //大图图片地址 width：1920px，height:382px
	private String competitionPic;	  //小图图片地址width：510px，height:420px
	//private int level; //赛事级别
	
	public Competition() {};
	
	public String getCompetitionGrade() {
		return competitionGrade;
	}
	public void setCompetitionGrade(String competitionGrade) {
		this.competitionGrade = competitionGrade;
	}
	public int getCompetitionForm() {
		return competitionForm;
	}
	public void setCompetitionForm(int competitionForm) {
		this.competitionForm = competitionForm;
	}
	public String getCompetitionSupportDesc() {
		return competitionSupportDesc;
	}
	public void setCompetitionSupportDesc(String competitionSupportDesc) {
		this.competitionSupportDesc = competitionSupportDesc;
	}
	public int getCompetitionState() {
		return competitionState;
	}
	public void setCompetitionState(int competitionState) {
		this.competitionState = competitionState;
	}
	public String getCompetitionId() {
		return competitionId;
	}
	public void setCompetitionId(String competitionId) {
		this.competitionId = competitionId;
	}
	public String getCompetitionName() {
		return competitionName;
	}
	public void setCompetitionName(String competitionName) {
		this.competitionName = competitionName;
	}
	public String getCompetitionSubject() {
		return competitionSubject;
	}
	public void setCompetitionSubject(String competitionSubject) {
		this.competitionSubject = competitionSubject;
	}
	public Date getCompetitionApplyStartTime() {
		return competitionApplyStartTime;
	}
	public void setCompetitionApplyStartTime(Date competitionApplyStartTime) {
		this.competitionApplyStartTime = competitionApplyStartTime;
	}
	public Date getCompetitionApplyEndTime() {
		return competitionApplyEndTime;
	}
	public void setCompetitionApplyEndTime(Date competitionApplyEndTime) {
		this.competitionApplyEndTime = competitionApplyEndTime;
	}
	public String getCompetitionJoinerDes() {
		return competitionJoinerDes;
	}
	public void setCompetitionJoinerDes(String competitionJoinerDes) {
		this.competitionJoinerDes = competitionJoinerDes;
	}
	public String getCompetitionMoney() {
		return competitionMoney;
	}
	public void setCompetitionMoney(String competitionMoney) {
		this.competitionMoney = competitionMoney;
	}
	public int getCompetitionType() {
		return competitionType;
	}
	public void setCompetitionType(int competitionType) {
		this.competitionType = competitionType;
	}
	public String getCompetitionPrizeDes() {
		return competitionPrizeDes;
	}
	public void setCompetitionPrizeDes(String competitionPrizeDes) {
		this.competitionPrizeDes = competitionPrizeDes;
	}
	public String getCompetitionTestTimeDes() {
		return competitionTestTimeDes;
	}
	public void setCompetitionTestTimeDes(String competitionTestTimeDes) {
		this.competitionTestTimeDes = competitionTestTimeDes;
	}
	public String getCompetitionApplyAddress() {
		return competitionApplyAddress;
	}
	public void setCompetitionApplyAddress(String competitionApplyAddress) {
		this.competitionApplyAddress = competitionApplyAddress;
	}
	public String getCompetitionTestAddress() {
		return competitionTestAddress;
	}
	public void setCompetitionTestAddress(String competitionTestAddress) {
		this.competitionTestAddress = competitionTestAddress;
	}
	public String getCompetitionDetail() {
		return competitionDetail;
	}
	public void setCompetitionDetail(String competitionDetail) {
		this.competitionDetail = competitionDetail;
	}
	
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	
	
	public String getCompetitionBigPic() {
		return competitionBigPic;
	}

	public void setCompetitionBigPic(String competitionBigPic) {
		this.competitionBigPic = competitionBigPic;
	}

	public String getCompetitionPic() {
		return competitionPic;
	}

	public void setCompetitionPic(String competitionPic) {
		this.competitionPic = competitionPic;
	}

	
	
	/*public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}*/

	

	
	

	

	public Competition(String competitionId, String competitionName, String competitionSubject,
			Date competitionApplyStartTime, Date competitionApplyEndTime, String competitionJoinerDes,
			String competitionMoney, int competitionType, String competitionPrizeDes, String competitionTestTimeDes,
			String competitionApplyAddress, String competitionTestAddress, String competitionDetail,
			int competitionState, String competitionSupportDesc, int competitionForm, String competitionGrade,
			int state, String competitionBigPic, String competitionPic, int level) {
		super();
		this.competitionId = competitionId;
		this.competitionName = competitionName;
		this.competitionSubject = competitionSubject;
		this.competitionApplyStartTime = competitionApplyStartTime;
		this.competitionApplyEndTime = competitionApplyEndTime;
		this.competitionJoinerDes = competitionJoinerDes;
		this.competitionMoney = competitionMoney;
		this.competitionType = competitionType;
		this.competitionPrizeDes = competitionPrizeDes;
		this.competitionTestTimeDes = competitionTestTimeDes;
		this.competitionApplyAddress = competitionApplyAddress;
		this.competitionTestAddress = competitionTestAddress;
		this.competitionDetail = competitionDetail;
		this.competitionState = competitionState;
		this.competitionSupportDesc = competitionSupportDesc;
		this.competitionForm = competitionForm;
		this.competitionGrade = competitionGrade;
		this.state = state;
		this.competitionBigPic = competitionBigPic;
		this.competitionPic = competitionPic;
	/*	this.level = level;*/
	}

	

	
	@Override
	public String toString() {
		return "Competition [competitionId=" + competitionId + ", competitionName=" + competitionName
				+ ", competitionSubject=" + competitionSubject + ", competitionApplyStartTime="
				+ competitionApplyStartTime + ", competitionApplyEndTime=" + competitionApplyEndTime
				+ ", competitionJoinerDes=" + competitionJoinerDes + ", competitionMoney=" + competitionMoney
				+ ", competitionType=" + competitionType + ", competitionPrizeDes=" + competitionPrizeDes
				+ ", competitionTestTimeDes=" + competitionTestTimeDes + ", competitionApplyAddress="
				+ competitionApplyAddress + ", competitionTestAddress=" + competitionTestAddress
				+ ", competitionDetail=" + competitionDetail + ", competitionState=" + competitionState
				+ ", competitionSupportDesc=" + competitionSupportDesc + ", competitionForm=" + competitionForm
				+ ", competitionGrade=" + competitionGrade + ", state=" + state + ", competitionBigPic="
				+ competitionBigPic + ", competitionPic=" + competitionPic + "]";
	}

	public JsonObject toJSON() {
		SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		JsonObject jsonData = new JsonObject();
		jsonData.addProperty("competitionId", this.competitionId);
		jsonData.addProperty("competitionName", this.competitionName);
		jsonData.addProperty("competitionSubject", this.competitionSubject);
		jsonData.addProperty("competitionApplyStartTime", s.format(this.competitionApplyStartTime));
		jsonData.addProperty("competitionApplyEndTime", s.format(this.competitionApplyEndTime));
		jsonData.addProperty("competitionJoinerDes", this.competitionJoinerDes);
		jsonData.addProperty("competitionMoney", this.competitionMoney);
		jsonData.addProperty("competitionType", this.competitionType);
		jsonData.addProperty("competitionPrizeDes", this.competitionPrizeDes);
		jsonData.addProperty("competitionApplyAddress", this.competitionApplyAddress);
		jsonData.addProperty("competitionTestAddress", this.competitionTestAddress);
		jsonData.addProperty("competitionApplyAddress", this.competitionApplyAddress);
		if(this.competitionDetail!=null) {
			jsonData.addProperty("competitionDetail", this.competitionDetail);
		}
		jsonData.addProperty("competitionState", this.competitionState);
		jsonData.addProperty("competitionSupportDesc", this.competitionSupportDesc);
		jsonData.addProperty("competitionForm", this.competitionForm);
		jsonData.addProperty("competitionTestTimeDes", this.competitionTestTimeDes);
		jsonData.addProperty("competitionGrade", this.competitionGrade);
		jsonData.addProperty("state", this.state);
		jsonData.addProperty("competitionBigPic", this.competitionBigPic);
		jsonData.addProperty("competitionPic", this.competitionPic);
		/*jsonData.addProperty("level", this.level);*/
		String temp = "<select onchange='revise(this)'><option value='1'>未开始报名</option><option value='2'>报名中</option><option value='3'>结束</option></select>";
		int a = temp.indexOf(String.valueOf(this.competitionState));
		temp = temp.substring(0,a+2)+" selected='selected'"+temp.substring(a+2, temp.length());
		jsonData.addProperty("methodWay",temp);
		return jsonData;
	}

	public StringBuffer returnsql(int course, int rtime) {
		StringBuffer sql= new StringBuffer(); 
		sql.append("");
		String coursename=null;
		if(course!=0||rtime!=0){
			sql.append(" where ");
			if(course!=0) {
				coursename = turn(course);
				sql.append(" competitionSubject='"+coursename+"' ");
				if(rtime!=0) {
					sql.append(" and competitionState="+ rtime );
					return sql;
					}
				else {
					return sql;
				}
			}
			else {
				sql.append(" competitionState="+ rtime );
				return sql;
			}
		}
		else {
			return sql;
		}
	}
	private String turn(int a) {
		if(a==1) {
			return "数学";
		}
		if(a==2) {
			return "语文";
		}
		if(a==3) {
			return "英语";
		}
		if(a==4) {
			return "计算机";
		}
		return null;
}
	
	

	
	
	
	
}
