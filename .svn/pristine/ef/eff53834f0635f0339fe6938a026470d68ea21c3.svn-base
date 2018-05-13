package cn.usgame.entity;

import com.google.gson.JsonObject;

public class camp_picture {
	private int camp_PictureId;
	private String imageUrl;
	private int campId;
	
	public camp_picture() {}
	
	
	public camp_picture(int camp_PictureId, String imageUrl, int campId) {
		super();
		this.camp_PictureId = camp_PictureId;
		this.imageUrl = imageUrl;
		this.campId = campId;
	}


	public int getCamp_PictureId() {
		return camp_PictureId;
	}


	public void setCamp_PictureId(int camp_PictureId) {
		this.camp_PictureId = camp_PictureId;
	}


	public String getImageUrl() {
		return imageUrl;
	}


	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}


	public int getCampId() {
		return campId;
	}


	public void setCampId(int campId) {
		this.campId = campId;
	}


	@Override
	public String toString() {
		return "camp_picture [camp_PictureId=" + camp_PictureId + ", imageUrl=" + imageUrl + ", campId=" + campId + "]";
	}
	
	public JsonObject toJSON() {
		JsonObject jsonData = new JsonObject();
		jsonData.addProperty("camp_PictureId", this.camp_PictureId);
		jsonData.addProperty("imageUrl", this.imageUrl);
		jsonData.addProperty("campId", this.campId);
		return jsonData;
	}
	
	
}
