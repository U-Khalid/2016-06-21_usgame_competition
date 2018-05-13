package cn.usgame.entity;

import java.text.SimpleDateFormat;

import com.google.gson.JsonObject;

public class Attention {
	private int  attentionId;        //关注Id
	private String attentionUser;    //关注用户注册手机号
	private int attentionType;       //关注类型    (1-竞赛，2-营地，3-培训)
	private int attentionContentId;  //关注内容的Id
    private int attentionState;      //关注状态
    
	public  Attention() {}
	
	public Attention(int attentionId, String attentionUser, int attentionType, int attentionContentId,
			int attentionState) {
		super();
		this.attentionId = attentionId;
		this.attentionUser = attentionUser;
		this.attentionType = attentionType;
		this.attentionContentId = attentionContentId;
		this.attentionState = attentionState;
	}


	public int getAttentionId() {
		return attentionId;
	}

	public void setAttentionId(int attentionId) {
		this.attentionId = attentionId;
	}

	public String getAttentionUser() {
		return attentionUser;
	}

	public void setAttentionUser(String attentionUser) {
		this.attentionUser = attentionUser;
	}

	public int getAttentionType() {
		return attentionType;
	}

	public void setAttentionType(int attentionType) {
		this.attentionType = attentionType;
	}

	public int getAttentionContentId() {
		return attentionContentId;
	}

	public void setAttentionContentId(int attentionContentId) {
		this.attentionContentId = attentionContentId;
	}


	public int getAttentionState() {
		return attentionState;
	}

	public void setAttentionState(int attentionState) {
		this.attentionState = attentionState;
	}

	@Override
	public String toString() {
		return "Attention [attentionId=" + attentionId + ", attentionUser=" + attentionUser + ", attentionType="
				+ attentionType + ", attentionContentId=" + attentionContentId + ", attentionState=" + attentionState
				+ "]";
	}
	public JsonObject toJSON() {
		JsonObject jsonData = new JsonObject();
		jsonData.addProperty("attentionId", this.attentionId);
		jsonData.addProperty("attentionUser", this.attentionUser);
		jsonData.addProperty("attentionType", this.attentionType);
		jsonData.addProperty("attentionContentId", this.attentionContentId);
		jsonData.addProperty("attentionState", this.attentionState);
		
		return jsonData;
	}
	
}
