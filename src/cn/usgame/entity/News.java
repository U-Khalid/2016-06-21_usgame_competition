package cn.usgame.entity;

import java.text.SimpleDateFormat;

import com.google.gson.JsonObject;

public class News {
	private int newId;
	private String info;
	private String url;
	private int state;
	
	public News () {}
	
	public News(int newId, String info, String url, int state) {
		super();
		this.newId = newId;
		this.info = info;
		this.url = url;
		this.state = state;
	}


	public int getNewId() {
		return newId;
	}


	public void setNewId(int newId) {
		this.newId = newId;
	}


	public String getInfo() {
		return info;
	}


	public void setInfo(String info) {
		this.info = info;
	}


	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}


	public int getState() {
		return state;
	}


	public void setState(int state) {
		this.state = state;
	}


	@Override
	public String toString() {
		return "News [newId=" + newId + ", info=" + info + ", url=" + url + ", state=" + state + "]";
	}
	
	
	public JsonObject toJSON() {
		JsonObject jsonData = new JsonObject();
		jsonData.addProperty("newId", this.newId);
		jsonData.addProperty("info", this.info);
		jsonData.addProperty("url", this.url);
		jsonData.addProperty("state", this.state);
		jsonData.addProperty("operation", "<a onclick='Newsdetail("+this.newId+")'>修改</a>");
		return jsonData;
	}
	
	public JsonObject ToJSON() {
		JsonObject jsonData = new JsonObject();
		jsonData.addProperty("newId", this.newId);
		jsonData.addProperty("info", this.info);
		jsonData.addProperty("url", this.url);
		jsonData.addProperty("state", this.state);
		return jsonData;
	}
	

}
