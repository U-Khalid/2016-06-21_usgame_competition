package cn.usgame.entity;

import org.apache.el.parser.JJTELParserState;

import com.google.gson.JsonObject;

public class Train {
	private int train_ID;      				 //培训ID
	private String train_Picture; 				 //培训图片地址
	private String train_MechanismName; 		 //培训机构名称
	private String train_Subject; 				 //培训科目
	private String train_Price;      		 	 //培训价格
	private String train_Teacher; 				 //培训教师
	private String train_TeacherInfo;     		 //培训教师详细信息
	private String train_Address; 				 //培训地址
	private int train_Phone;      				 //培训联系方式
	private String train_Start; 				 //培训开始时间
	private String train_End;      				 //培训结束时间
	private String train_IenrollStart; 			 //培训报名开始时间
	private String train_IenrollEnd;      		 //培训报名截止时间
	private String train_Times; 				 //培训次数详细情况
	private String train_Detail;      			 //培训机构相信信息
	private int train_state; 					 //培训状态
	public int getTrain_ID() {
		return train_ID;
	}
	public void setTrain_ID(int train_ID) {
		this.train_ID = train_ID;
	}
	public String getTrain_Picture() {
		return train_Picture;
	}
	public void setTrain_Picture(String train_Picture) {
		this.train_Picture = train_Picture;
	}
	public String getTrain_MechanismName() {
		return train_MechanismName;
	}
	public void setTrain_MechanismName(String train_MechanismName) {
		this.train_MechanismName = train_MechanismName;
	}
	public String getTrain_Subject() {
		return train_Subject;
	}
	public void setTrain_Subject(String train_Subject) {
		this.train_Subject = train_Subject;
	}
	public String getTrain_Price() {
		return train_Price;
	}
	public void setTrain_Price(String train_Price) {
		this.train_Price = train_Price;
	}
	public String getTrain_Teacher() {
		return train_Teacher;
	}
	public void setTrain_Teacher(String train_Teacher) {
		this.train_Teacher = train_Teacher;
	}
	public String getTrain_TeacherInfo() {
		return train_TeacherInfo;
	}
	public void setTrain_TeacherInfo(String train_TeacherInfo) {
		this.train_TeacherInfo = train_TeacherInfo;
	}
	public String getTrain_Address() {
		return train_Address;
	}
	public void setTrain_Address(String train_Address) {
		this.train_Address = train_Address;
	}
	public int getTrain_Phone() {
		return train_Phone;
	}
	public void setTrain_Phone(int train_Phone) {
		this.train_Phone = train_Phone;
	}
	public String getTrain_Start() {
		return train_Start;
	}
	public void setTrain_Start(String train_Start) {
		this.train_Start = train_Start;
	}
	public String getTrain_End() {
		return train_End;
	}
	public void setTrain_End(String train_End) {
		this.train_End = train_End;
	}
	public String getTrain_IenrollStart() {
		return train_IenrollStart;
	}
	public void setTrain_IenrollStart(String train_IenrollStart) {
		this.train_IenrollStart = train_IenrollStart;
	}
	public String getTrain_IenrollEnd() {
		return train_IenrollEnd;
	}
	public void setTrain_IenrollEnd(String train_IenrollEnd) {
		this.train_IenrollEnd = train_IenrollEnd;
	}
	public String getTrain_Times() {
		return train_Times;
	}
	public void setTrain_Times(String train_Times) {
		this.train_Times = train_Times;
	}
	public String getTrain_Detail() {
		return train_Detail;
	}
	public void setTrain_Detail(String train_Detail) {
		this.train_Detail = train_Detail;
	}
	public int getTrain_state() {
		return train_state;
	}
	public void setTrain_state(int train_state) {
		this.train_state = train_state;
	}
	@Override
	public String toString(){
		return "Train:[train_ID:"+train_ID+",train_Picture:"+train_Picture+",train_MechanismName:"+train_MechanismName+
				",train_Subject:"+train_Subject+",train_Price:"+train_Price+",train_Teacher:"+train_Teacher+",train_TeacherInfo:"
				+train_TeacherInfo+",train_Address:"+train_Address+",train_Phone:"+train_Phone+",train_Start:"+train_Start
				+",train_End:"+train_End+",train_IenrollStart:"+train_IenrollStart+",train_IenrollEnd:"+train_IenrollEnd+
				",train_Times:"+train_Times+",train_Detail:"+train_Detail+",train_state:"+train_state+"]";	
	}
	public JsonObject toJson(){
		JsonObject json=new JsonObject();
		json.addProperty("train_ID", train_ID);
		json.addProperty("train_Picture", train_Picture);
		json.addProperty("train_MechanismName", train_MechanismName);
		json.addProperty("train_Subject", train_Subject);
		json.addProperty("train_Price", train_Price);
		json.addProperty("train_Teacher", train_Teacher);
		json.addProperty("train_TeacherInfo", train_TeacherInfo);
		json.addProperty("train_Address", train_Address);
		json.addProperty("train_Phone", train_Phone);
		json.addProperty("train_Start", train_Start);
		json.addProperty("train_End", train_End);
		json.addProperty("train_IenrollStart", train_IenrollStart);
		json.addProperty("train_IenrollEnd", train_IenrollEnd);
		json.addProperty("train_Times", train_Times);
		json.addProperty("train_Detail", train_Detail);
		json.addProperty("train_state", train_state);
		return json;
	}
}
