package cn.usgame.entity;

import com.google.gson.JsonObject;

public class Train_Teacher {
	private int tSubject_ID;				//培训科目ID
	private int tTeacher_ID;				//培训教师ID
	private String tTeacher_Info;			//培训教师详细信息
	private String tTeacher_Name;
	private int tTeacher_Sex;
	private int tTeacher_Price;
	
	public int gettTeacher_Price() {
		return tTeacher_Price;
	}
	public void settTeacher_Price(int tTeacher_Price) {
		this.tTeacher_Price = tTeacher_Price;
	}
	public String gettTeacher_Name() {
		return tTeacher_Name;
	}
	public void settTeacher_Name(String tTeacher_Name) {
		this.tTeacher_Name = tTeacher_Name;
	}
	public int gettTeacher_Sex() {
		return tTeacher_Sex;
	}
	public void settTeacher_Sex(int tTeacher_Sex) {
		this.tTeacher_Sex = tTeacher_Sex;
	}
	public int gettSubject_ID() {
		return tSubject_ID;
	}
	public void settSubject_ID(int tSubject_ID) {
		this.tSubject_ID = tSubject_ID;
	}
	public int gettTeacher_ID() {
		return tTeacher_ID;
	}
	public void settTeacher_ID(int tTeacher_ID) {
		this.tTeacher_ID = tTeacher_ID;
	}
	public String gettTeacher_Info() {
		return tTeacher_Info;
	}
	public void settTeacher_Info(String tTeacher_Info) {
		this.tTeacher_Info = tTeacher_Info;
	}
	@Override
	public String toString() {
		return "Train_Teacher [tSubject_ID=" + tSubject_ID + ", tTeacher_ID=" + tTeacher_ID + ", tTeacher_Info="
				+ tTeacher_Info + ", tTeacher_Name=" + tTeacher_Name + ", tTeacher_Sex=" + tTeacher_Sex
				+ ", tTeacher_Price=" + tTeacher_Price + "]";
	}
	
	public JsonObject toJSON(){
		JsonObject json = new JsonObject();
		json.addProperty("tSubject_ID", tSubject_ID);
		json.addProperty("tTeacher_ID", tTeacher_ID);
		json.addProperty("tTeacher_Info", tTeacher_Info);
		json.addProperty("tTeacher_Name", tTeacher_Name);
		json.addProperty("tTeacher_Sex", tTeacher_Sex);
		json.addProperty("tTeacher_Price", tTeacher_Price);
		return json;
	}
}
