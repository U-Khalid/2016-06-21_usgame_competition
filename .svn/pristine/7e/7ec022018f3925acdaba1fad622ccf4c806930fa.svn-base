package cn.usgame.entity;

import com.google.gson.JsonObject;

public class camp_comment {
	private int camp_commentId;
	private String Info;
	private int campId;

	public camp_comment(){}

	public camp_comment(int camp_commentId, String info, int campId) {
		super();
		this.camp_commentId = camp_commentId;
		Info = info;
		this.campId = campId;
	}

	public int getCamp_commentId() {
		return camp_commentId;
	}

	public void setCamp_commentId(int camp_commentId) {
		this.camp_commentId = camp_commentId;
	}

	public String getInfo() {
		return Info;
	}

	public void setInfo(String info) {
		Info = info;
	}

	public int getCampId() {
		return campId;
	}

	public void setCampId(int campId) {
		this.campId = campId;
	}

	@Override
	public String toString() {
		return "camp_comment [camp_commentId=" + camp_commentId + ", Info=" + Info + ", campId=" + campId + "]";
	}
	
	public JsonObject toJSON() {
		JsonObject jsonData = new JsonObject();
		jsonData.addProperty("camp_commentId", this.camp_commentId);
		jsonData.addProperty("Info", this.Info);
		jsonData.addProperty("campId", this.campId);
		return jsonData;
	}
	
	
}
