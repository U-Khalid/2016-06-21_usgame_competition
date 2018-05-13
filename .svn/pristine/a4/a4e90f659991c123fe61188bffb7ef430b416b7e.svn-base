package cn.usgame.entity;

import com.google.gson.JsonObject;

public class Administrator {
	private int administratorId;      //编号
	private String username;           //用户名
	private String name;             //姓名
	private String password;         //密码
	private int state;            //状态
	
	public Administrator () {}
	
	

	public Administrator(int administratorId, String username, String name, String password, int state) {
		super();
		this.administratorId = administratorId;
		this.username = username;
		this.name = name;
		this.password = password;
		this.state = state;
	}



	public int getAdministratorId() {
		return administratorId;
	}



	public void setAdministratorId(int administratorId) {
		this.administratorId = administratorId;
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public int getState() {
		return state;
	}



	public void setState(int state) {
		this.state = state;
	}



	@Override
	public String toString() {
		return "Administrator [administratorId=" + administratorId + ", username=" + username + ", name=" + name
				+ ", password=" + password + ", state=" + state + "]";
	}
	
	public JsonObject toJSON() {
		JsonObject jsonData = new JsonObject();
		
		jsonData.addProperty("administratorId", this.administratorId);
		jsonData.addProperty("username", this.username);
		jsonData.addProperty("name", this.name);
		jsonData.addProperty("password",this.password );
		jsonData.addProperty("state", this.state);
		return jsonData;
	}
}
