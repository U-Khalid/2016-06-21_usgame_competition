package cn.usgame.entity;

import com.google.gson.JsonObject;

public class Train_Subject {
	private Train_Info tMechanismInfo;               //培训机构ID
	
	private int tSubject_ID;						//培训科目ID
	private String tSubject_Course;					//培训科目
	private String tSubject_Start;					//培训开始时间
	private String tSubject_End;					//培训结束时间
	private String tSubject_EnrollStart;			//培训报名开始时间
	private String tSubject_EnrollEnd;				//培训报名结束时间
/*	private int tSubject_State;						//培训状态  1表示未开始 2表示进行中 3表示已结束*/
	private int tSubject_EnrollState;				//培训报名状态  1表示未开始 2表示进行中 3表示已结束
	private int tSubject_Times;						//每周培训次数
	private String tSubject_Detail;					//培训科目详细介绍
	private String tSubject_PictureUrl;				//培训科目相关图片
	private String tSubject_CourseName;				//课程名称
	private String tSubject_EnrollAddress;			//培训报名地点
	private String tSubject_Personnel;				//参与培训人员（学生）
	private String tSubject_Form;					//培训形式（几对几，小班，大班）
	private String tSubject_DetailTime;				//具体培训细节（周几几点--几点）
	private String tSubject_Grade;					//培训年级
	private String tSubject_BigPic;                 //培训课程大图
	
	
	
	
	
	public String gettSubject_Grade() {
		return tSubject_Grade;
	}
	public void settSubject_Grade(String tSubject_Grade) {
		this.tSubject_Grade = tSubject_Grade;
	}
	public String gettSubject_DetailTime() {
		return tSubject_DetailTime;
	}
	public void settSubject_DetailTime(String tSubject_DetailTime) {
		this.tSubject_DetailTime = tSubject_DetailTime;
	}
	public String gettSubject_Form() {
		return tSubject_Form;
	}
	public void settSubject_Form(String tSubject_Form) {
		this.tSubject_Form = tSubject_Form;
	}
	public String gettSubject_Personnel() {
		return tSubject_Personnel;
	}
	public void settSubject_Personnel(String tSubject_Personnel) {
		this.tSubject_Personnel = tSubject_Personnel;
	}
	public String gettSubject_EnrollAddress() {
		return tSubject_EnrollAddress;
	}
	public void settSubject_EnrollAddress(String tSubject_EnrollAddress) {
		this.tSubject_EnrollAddress = tSubject_EnrollAddress;
	}
	public String gettSubject_CourseName() {
		return tSubject_CourseName;
	}
	public void settSubject_CourseName(String tSubject_CourseName) {
		this.tSubject_CourseName = tSubject_CourseName;
	}
	public String gettSubject_PictureUrl() {
		return tSubject_PictureUrl;
	}
	public void settSubject_PictureUrl(String tSubject_PictureUrl) {
		this.tSubject_PictureUrl = tSubject_PictureUrl;
	}
	public Train_Info gettMechanismInfo() {
		return tMechanismInfo;
	}
	public void settMechanismInfo(Train_Info tMechanismInfo) {
		this.tMechanismInfo = tMechanismInfo;
	}
	public int gettSubject_ID() {
		return tSubject_ID;
	}
	public void settSubject_ID(int tSubject_ID) {
		this.tSubject_ID = tSubject_ID;
	}
	public String gettSubject_Course() {
		return tSubject_Course;
	}
	public void settSubject_Course(String tSubject_Course) {
		this.tSubject_Course = tSubject_Course;
	}
	public String gettSubject_Start() {
		return tSubject_Start;
	}
	public void settSubject_Start(String tSubject_Start) {
		this.tSubject_Start = tSubject_Start;
	}
	public String gettSubject_End() {
		return tSubject_End;
	}
	public void settSubject_End(String tSubject_End) {
		this.tSubject_End = tSubject_End;
	}
	public String gettSubject_EnrollStart() {
		return tSubject_EnrollStart;
	}
	public void settSubject_EnrollStart(String tSubject_EnrollStart) {
		this.tSubject_EnrollStart = tSubject_EnrollStart;
	}
	public String gettSubject_EnrollEnd() {
		return tSubject_EnrollEnd;
	}
	public void settSubject_EnrollEnd(String tSubject_EnrollEnd) {
		this.tSubject_EnrollEnd = tSubject_EnrollEnd;
	}
	/*public int gettSubject_State() {
		return tSubject_State;
	}
	public void settSubject_State(int tSubject_State) {
		this.tSubject_State = tSubject_State;
	}*/
	public int gettSubject_EnrollState() {
		return tSubject_EnrollState;
	}
	public void settSubject_EnrollState(int tSubject_EnrollState) {
		this.tSubject_EnrollState = tSubject_EnrollState;
	}
	public int gettSubject_Times() {
		return tSubject_Times;
	}
	public void settSubject_Times(int tSubject_Times) {
		this.tSubject_Times = tSubject_Times;
	}
	public String gettSubject_Detail() {
		return tSubject_Detail;
	}
	public void settSubject_Detail(String tSubject_Detail) {
		this.tSubject_Detail = tSubject_Detail;
	}
	
	public String gettSubject_BigPic() {
		return tSubject_BigPic;
	}
	public void settSubject_BigPic(String tSubject_BigPic) {
		this.tSubject_BigPic = tSubject_BigPic;
	}
	
	
	@Override
	public String toString() {
		return "Train_Subject [tMechanismInfo=" + tMechanismInfo + ", tSubject_ID=" + tSubject_ID + ", tSubject_Course="
				+ tSubject_Course + ", tSubject_Start=" + tSubject_Start + ", tSubject_End=" + tSubject_End
				+ ", tSubject_EnrollStart=" + tSubject_EnrollStart + ", tSubject_EnrollEnd=" + tSubject_EnrollEnd
				+ ", tSubject_EnrollState=" + tSubject_EnrollState + ", tSubject_Times=" + tSubject_Times
				+ ", tSubject_Detail=" + tSubject_Detail + ", tSubject_PictureUrl=" + tSubject_PictureUrl
				+ ", tSubject_CourseName=" + tSubject_CourseName + ", tSubject_EnrollAddress=" + tSubject_EnrollAddress
				+ ", tSubject_Personnel=" + tSubject_Personnel + ", tSubject_Form=" + tSubject_Form
				+ ", tSubject_DetailTime=" + tSubject_DetailTime + ", tSubject_Grade=" + tSubject_Grade
				+ ", tSubject_BigPic=" + tSubject_BigPic + "]";
	}
	
	public JsonObject toJSON(){
		JsonObject json= new JsonObject();
		
		json.addProperty("tSubject_ID", tSubject_ID);
		json.addProperty("tSubject_Course", tSubject_Course);
		json.addProperty("tSubject_Start", tSubject_Start);
		json.addProperty("tSubject_End", tSubject_End);
		json.addProperty("tSubject_EnrollStart", tSubject_EnrollStart);
		json.addProperty("tSubject_EnrollEnd", tSubject_EnrollEnd);
		/*json.addProperty("tSubject_State", tSubject_State);*/
		json.addProperty("tSubject_EnrollState", tSubject_EnrollState);
		json.addProperty("tSubject_Times", tSubject_Times);
		json.addProperty("tSubject_Detail", tSubject_Detail);
		json.addProperty("tSubject_PictureUrl", tSubject_PictureUrl);
		json.addProperty("tSubject_CourseName", tSubject_CourseName);
		json.addProperty("tSubject_EnrollAddress", tSubject_EnrollAddress);
		json.addProperty("tSubject_Personnel", tSubject_Personnel);
		json.addProperty("tSubject_Form", tSubject_Form);
		json.addProperty("tSubject_DetailTime", tSubject_DetailTime);
		json.addProperty("tSubject_Grade", tSubject_Grade);
		json.addProperty("tSubject_BigPic", tSubject_BigPic);
		json.addProperty("teacher", "<a onclick='teacherdetail(\""+this.tSubject_ID+"\""+")'>教师详情</a>");
		
		String temp = "<select onchange='reviseTrainState(this)'><option value='1'>未开始报名</option><option value='2'>报名中</option><option value='3'>已结束</option></select>";
		int a = temp.indexOf(String.valueOf(this.tSubject_EnrollState));
		temp = temp.substring(0,a+2)+" selected='selected'"+temp.substring(a+2, temp.length());
		json.addProperty("trainmethodWay",temp);
		
		
		return json;
	}

	public JsonObject toJSON_Add(){
		JsonObject json= new JsonObject();
		
		json.addProperty("tSubject_ID", tSubject_ID);
		json.addProperty("tSubject_Course", tSubject_Course);
		json.addProperty("tSubject_Start", tSubject_Start);
		json.addProperty("tSubject_End", tSubject_End);
		json.addProperty("tSubject_EnrollStart", tSubject_EnrollStart);
		json.addProperty("tSubject_EnrollEnd", tSubject_EnrollEnd);
		/*json.addProperty("tSubject_State", tSubject_State);*/
		json.addProperty("tSubject_EnrollState", tSubject_EnrollState);
		json.addProperty("tSubject_Times", tSubject_Times);
		json.addProperty("tSubject_Detail", tSubject_Detail);
		
		json.addProperty("tSubject_CourseName", tSubject_CourseName);
		json.addProperty("tSubject_EnrollAddress", tSubject_EnrollAddress);
		json.addProperty("tSubject_Personnel", tSubject_Personnel);
		json.addProperty("tSubject_Form", tSubject_Form);
		json.addProperty("tSubject_DetailTime", tSubject_DetailTime);
		json.addProperty("tSubject_Grade", tSubject_Grade);
		return json;
	}

}
