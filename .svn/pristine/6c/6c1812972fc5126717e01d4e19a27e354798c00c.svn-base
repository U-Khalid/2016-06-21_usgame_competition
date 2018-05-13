package cn.usgame.entity;

import com.google.gson.JsonObject;

public class Train_Info {
	private int tMechanism_ID;						//培训机构ID
	private String tMechanism_Name;					//培训机构名称
	private String tMechanism_Address;				//培训机构地址
	private String tMechanism_Phone;				//培训机构联系方式
	private String tMechanism_Detail;				//培训机构详细介绍
	private String tMechanism_PictureUrl;			//培训机构的图片
	
	public String gettMechanism_PictureUrl() {
		return tMechanism_PictureUrl;
	}
	public void settMechanism_PictureUrl(String tMechanism_PictureUrl) {
		this.tMechanism_PictureUrl = tMechanism_PictureUrl;
	}
	public int gettMechanism_ID() {
		return tMechanism_ID;
	}
	public void settMechanism_ID(int tMechanism_ID) {
		this.tMechanism_ID = tMechanism_ID;
	}
	public String gettMechanism_Name() {
		return tMechanism_Name;
	}
	public void settMechanism_Name(String tMechanism_Name) {
		this.tMechanism_Name = tMechanism_Name;
	}
	public String gettMechanism_Address() {
		return tMechanism_Address;
	}
	public void settMechanism_Address(String tMechanism_Address) {
		this.tMechanism_Address = tMechanism_Address;
	}
	public String gettMechanism_Phone() {
		return tMechanism_Phone;
	}
	public void settMechanism_Phone(String tMechanism_Phone) {
		this.tMechanism_Phone = tMechanism_Phone;
	}
	public String gettMechanism_Detail() {
		return tMechanism_Detail;
	}
	public void settMechanism_Detail(String tMechanism_Detail) {
		this.tMechanism_Detail = tMechanism_Detail;
	}
	
	@Override
	public String toString() {
		return "Train_Info [tMechanism_ID=" + tMechanism_ID + ", tMechanism_Name=" + tMechanism_Name
				+ ", tMechanism_Address=" + tMechanism_Address + ", tMechanism_Phone=" + tMechanism_Phone
				+ ", tMechanism_Detail=" + tMechanism_Detail + ", tMechanism_PictureUrl=" + tMechanism_PictureUrl + "]";
	}
	
	public JsonObject toJSON(){
		JsonObject json=new JsonObject();
		json.addProperty("tMechanism_ID", tMechanism_ID);
		json.addProperty("tMechanism_Name", tMechanism_Name);
		json.addProperty("tMechanism_Address", tMechanism_Address);
		json.addProperty("tMechanism_Phone", tMechanism_Phone);
		json.addProperty("tMechanism_Detail", tMechanism_Detail);
		json.addProperty("tMechanism_PictureUrl", tMechanism_PictureUrl);
		return json;
	}
	 
}
