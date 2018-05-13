package cn.usgame.entity;

import com.google.gson.JsonObject;

public class Camp {
	private int campId;                         /*营地编号*/
	private String camp_Name;					/*营地名字*/
	private String camp_Address;				/*营地目的地*/
	private int camp_Age;					    /*报名学生年龄*/
	private String camp_Money;					/*营地报名费用*/
	private String camp_startTime;				/*报名开始时间*/
	private String camp_endTime;				/*报名结束时间*/
	private String camp_goTime;					/*出发时间*/
	private String camp_Features;				/*营地特色*/
	private String camp_Info;					/*营地介绍*/
	private String camp_Schedule;				/*日程安排*/
	private String money_Info;					/*费用说明*/
	private String apply_Info;					/*报名须知*/
	private String attention_Info;				/*注意事项*/
	private int state;						    /*首页置顶状态*/
	private String camp_Pic;					/*首页营地图片*/
	private String camp_BigPic;					/*营地详情大图片*/
	private int campstate;					    /*营地状态 1-未开始报名，2-报名中，3-已结束*/
	private int camp_theme;						/*营地主题*/
	private int camp_TimeLength;				/*时间长度*/
 
    public Camp() {}

	public Camp(int campId, String camp_Name, String camp_Address, int camp_Age, String camp_Money,
			String camp_startTime, String camp_endTime, String camp_goTime, String camp_Features, String camp_Info,
			String camp_Schedule, String money_Info, String apply_Info, String attention_Info, int state,
			String camp_Pic, String camp_BigPic, int campstate, int camp_theme, int camp_TimeLength) {
		super();
		this.campId = campId;
		this.camp_Name = camp_Name;
		this.camp_Address = camp_Address;
		this.camp_Age = camp_Age;
		this.camp_Money = camp_Money;
		this.camp_startTime = camp_startTime;
		this.camp_endTime = camp_endTime;
		this.camp_goTime = camp_goTime;
		this.camp_Features = camp_Features;
		this.camp_Info = camp_Info;
		this.camp_Schedule = camp_Schedule;
		this.money_Info = money_Info;
		this.apply_Info = apply_Info;
		this.attention_Info = attention_Info;
		this.state = state;
		this.camp_Pic = camp_Pic;
		this.camp_BigPic = camp_BigPic;
		this.campstate = campstate;
		this.camp_theme = camp_theme;
		this.camp_TimeLength = camp_TimeLength;
	}


	public int getCampId() {
		return campId;
	}

	public void setCampId(int campId) {
		this.campId = campId;
	}

	public String getCamp_Name() {
		return camp_Name;
	}

	public void setCamp_Name(String camp_Name) {
		this.camp_Name = camp_Name;
	}

	public String getCamp_Address() {
		return camp_Address;
	}

	public void setCamp_Address(String camp_Address) {
		this.camp_Address = camp_Address;
	}

	public int getCamp_Age() {
		return camp_Age;
	}

	public void setCamp_Age(int camp_Age) {
		this.camp_Age = camp_Age;
	}

	public String getCamp_Money() {
		return camp_Money;
	}

	public void setCamp_Money(String camp_Money) {
		this.camp_Money = camp_Money;
	}

	public String getCamp_startTime() {
		return camp_startTime;
	}

	public void setCamp_startTime(String camp_startTime) {
		this.camp_startTime = camp_startTime;
	}

	public String getCamp_endTime() {
		return camp_endTime;
	}

	public void setCamp_endTime(String camp_endTime) {
		this.camp_endTime = camp_endTime;
	}

	public String getCamp_goTime() {
		return camp_goTime;
	}

	public void setCamp_goTime(String camp_goTime) {
		this.camp_goTime = camp_goTime;
	}

	public String getCamp_Features() {
		return camp_Features;
	}

	public void setCamp_Features(String camp_Features) {
		this.camp_Features = camp_Features;
	}

	public String getCamp_Info() {
		return camp_Info;
	}

	public void setCamp_Info(String camp_Info) {
		this.camp_Info = camp_Info;
	}

	public String getCamp_Schedule() {
		return camp_Schedule;
	}

	public void setCamp_Schedule(String camp_Schedule) {
		this.camp_Schedule = camp_Schedule;
	}

	public String getMoney_Info() {
		return money_Info;
	}

	public void setMoney_Info(String money_Info) {
		this.money_Info = money_Info;
	}

	public String getApply_Info() {
		return apply_Info;
	}

	public void setApply_Info(String apply_Info) {
		this.apply_Info = apply_Info;
	}

	public String getAttention_Info() {
		return attention_Info;
	}

	public void setAttention_Info(String attention_Info) {
		this.attention_Info = attention_Info;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getCamp_Pic() {
		return camp_Pic;
	}

	public void setCamp_Pic(String camp_Pic) {
		this.camp_Pic = camp_Pic;
	}

	public String getCamp_BigPic() {
		return camp_BigPic;
	}

	public void setCamp_BigPic(String camp_BigPic) {
		this.camp_BigPic = camp_BigPic;
	}

	public int getCampstate() {
		return campstate;
	}

	public void setCampstate(int campstate) {
		this.campstate = campstate;
	}

	public int getCamp_theme() {
		return camp_theme;
	}

	public void setCamp_theme(int camp_theme) {
		this.camp_theme = camp_theme;
	}

	public int getCamp_TimeLength() {
		return camp_TimeLength;
	}

	public void setCamp_TimeLength(int camp_TimeLength) {
		this.camp_TimeLength = camp_TimeLength;
	}


	@Override
	public String toString() {
		return "Camp [campId=" + campId + ", camp_Name=" + camp_Name + ", camp_Address=" + camp_Address + ", camp_Age="
				+ camp_Age + ", camp_Money=" + camp_Money + ", camp_startTime=" + camp_startTime + ", camp_endTime="
				+ camp_endTime + ", camp_goTime=" + camp_goTime + ", camp_Features=" + camp_Features + ", camp_Info="
				+ camp_Info + ", camp_Schedule=" + camp_Schedule + ", money_Info=" + money_Info + ", apply_Info="
				+ apply_Info + ", attention_Info=" + attention_Info + ", state=" + state + ", camp_Pic=" + camp_Pic
				+ ", camp_BigPic=" + camp_BigPic + ", campstate=" + campstate + ", camp_theme=" + camp_theme
				+ ", camp_TimeLength=" + camp_TimeLength + "]";
	}





	public JsonObject toJSON() {
		JsonObject jsonData = new JsonObject();
		jsonData.addProperty("campId", this.campId);
		jsonData.addProperty("camp_Name", this.camp_Name);
		jsonData.addProperty("camp_Address", this.camp_Address);
		jsonData.addProperty("camp_Age",this.camp_Age );
		jsonData.addProperty("camp_Money", this.camp_Money);
		jsonData.addProperty("camp_startTime", this.camp_startTime);
		jsonData.addProperty("camp_endTime", this.camp_endTime);
		jsonData.addProperty("camp_goTime", this.camp_goTime);
		jsonData.addProperty("camp_Features", this.camp_Features);
		jsonData.addProperty("camp_Info", this.camp_Info);
		jsonData.addProperty("camp_Schedule", this.camp_Schedule);
		jsonData.addProperty("money_Info", this.money_Info);
		jsonData.addProperty("apply_Info", this.apply_Info);
		jsonData.addProperty("attention_Info", this.attention_Info);
		jsonData.addProperty("state", this.state);
		jsonData.addProperty("camp_Pic", this.camp_Pic);
		jsonData.addProperty("camp_BigPic", this.camp_BigPic);
		jsonData.addProperty("campstate", this.campstate);
		jsonData.addProperty("camp_theme", this.camp_theme);
		jsonData.addProperty("camp_TimeLength", this.camp_TimeLength);
		return jsonData;
	}
	
	public JsonObject toJSON_add() {
		JsonObject jsonData = new JsonObject();
		jsonData.addProperty("campId", this.campId);
		jsonData.addProperty("camp_Name", this.camp_Name);
		jsonData.addProperty("camp_Address", this.camp_Address);
		jsonData.addProperty("camp_Age",this.camp_Age );
		jsonData.addProperty("camp_Money", this.camp_Money);
		jsonData.addProperty("camp_startTime", this.camp_startTime);
		jsonData.addProperty("camp_endTime", this.camp_endTime);
		jsonData.addProperty("camp_goTime", this.camp_goTime);
		jsonData.addProperty("camp_Features", this.camp_Features);
		jsonData.addProperty("camp_Info", this.camp_Info);
		jsonData.addProperty("camp_Schedule", this.camp_Schedule);
		jsonData.addProperty("money_Info", this.money_Info);
		jsonData.addProperty("apply_Info", this.apply_Info);
		jsonData.addProperty("attention_Info", this.attention_Info);
		jsonData.addProperty("state", this.state);
		
		jsonData.addProperty("campstate", this.campstate);
		jsonData.addProperty("camp_theme", this.camp_theme);
		jsonData.addProperty("camp_TimeLength", this.camp_TimeLength);
		return jsonData;
	}
	public JsonObject admin_toJSON() {
		JsonObject jsonData = new JsonObject();
		jsonData.addProperty("campId", this.campId);
		jsonData.addProperty("camp_Name", this.camp_Name);
		jsonData.addProperty("camp_Address", this.camp_Address);
		jsonData.addProperty("camp_Age",this.camp_Age );
		jsonData.addProperty("camp_Money", this.camp_Money);
		jsonData.addProperty("camp_startTime", this.camp_startTime);
		jsonData.addProperty("camp_endTime", this.camp_endTime);
		jsonData.addProperty("camp_goTime", this.camp_goTime);
		jsonData.addProperty("camp_Features", this.camp_Features);
		jsonData.addProperty("camp_Info", this.camp_Info);
		jsonData.addProperty("camp_Schedule", this.camp_Schedule);
		jsonData.addProperty("money_Info", this.money_Info);
		jsonData.addProperty("apply_Info", this.apply_Info);
		jsonData.addProperty("attention_Info", this.attention_Info);
		jsonData.addProperty("state", this.state);
		jsonData.addProperty("camp_Pic", this.camp_Pic);
		jsonData.addProperty("camp_BigPic", this.camp_BigPic);
		//jsonData.addProperty("campstate", this.campstate);
		jsonData.addProperty("camp_theme", turnTheme(this.camp_theme));
		jsonData.addProperty("camp_TimeLength", turnTimeLength(this.camp_TimeLength));
		String temp = "<select onchange='reviseCampState(this)'><option value='1'>未开始报名</option><option value='2'>报名中</option><option value='3'>已结束</option></select>";
		int a = temp.indexOf(String.valueOf(this.campstate));
		temp = temp.substring(0,a+2)+" selected='selected'"+temp.substring(a+2, temp.length());
		jsonData.addProperty("campmethodWay",temp);
		return jsonData;
	}
	
	private String turnTimeLength(int a) {
		if(a==1) {
			return "1天";
		}
		if(a==2) {
			return "2天";
		}
		if(a==3) {
			return "3~5天";
		}
		if(a==4) {
			return "6~8天";
		}
		if(a==5) {
			return "9~14天";
		}
		if(a==6) {
			return "15天及以上";
		}
		return "";
	}
	
	public String turnTheme(int a){
		if(a==1){
			return  "户外扩展";
		}
		if(a==2){
			return  "自然探索";
		}			
		if(a==3){
			return  "体育运动";
		}
		if(a==4){
			return "艺术人文";
		}
		if(a==5){
			return "科学技术";
		}
		if(a==6){
			return "军旅主题";
		}
		if(a==7){	
			return "语言提升";
		}
		if(a==8){
			return "国际综合";
		}
		return "";
	}
	
	public StringBuffer returnsql(String destination, String theme, int suitableAge, int timeLength) {
		StringBuffer sql= new StringBuffer(); 
		sql.append("");
		if(!destination.equals("全部")||!theme.equals("全部")||suitableAge!=0||timeLength!=0){
			sql.append(" where ");
			if(!destination.equals("全部")) {
				sql.append(" camp_Address='"+destination+"' ");
				if(!theme.equals("全部")) {
					sql.append(" and camp_theme='"+ theme+"' " );
					if(suitableAge!=0) {
						sql.append(" and camp_Age="+ suitableAge );
						if(timeLength!=0){
							sql.append(" and camp_TimeLength="+ timeLength );
						}
						return sql;
				    }
					else{
						if(timeLength!=0){
							sql.append(" and camp_TimeLength="+ timeLength );
						}
						return sql;
					}
				}
				else {
					if(suitableAge!=0) {
						sql.append(" and camp_Age="+ suitableAge );
						if(timeLength!=0){
							sql.append(" and camp_TimeLength="+ timeLength );
						}
						return sql;
				    }
					else{
						if(timeLength!=0){
							sql.append(" and camp_TimeLength="+ timeLength );
						}
						return sql;
					}
				}
			}
			else {
				if(!theme.equals("全部")) {
					sql.append("  camp_theme='"+ theme+"' " );
					if(suitableAge!=0) {
						sql.append(" and camp_Age="+ suitableAge );
						if(timeLength!=0){
							sql.append(" and camp_TimeLength="+ timeLength );
						}
						return sql;
				    }
					else{
						if(timeLength!=0){
							sql.append(" and camp_TimeLength="+ timeLength );
						}
						return sql;
					}
				}
				else {
					if(suitableAge!=0) {
						sql.append("  camp_Age="+ suitableAge );
						if(timeLength!=0){
							sql.append(" and camp_TimeLength="+ timeLength );
						}
						return sql;
				    }
					else{
						if(timeLength!=0){
							sql.append("  camp_TimeLength="+ timeLength );
						}
						return sql;
					}
				}
			}
		}
		else {
			return sql;
		}
	} 
	
	
}
