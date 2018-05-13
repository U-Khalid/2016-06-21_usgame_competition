package cn.usgame.entity;

public class SMS {
	private String phoneNumber; //手机号
	private String SNSNumber;   //验证码
	private String nowTime;     //现在的时间
	private int lifeCycle;      //生命周期
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getSNSNumber() {
		return SNSNumber;
	}
	public void setSNSNumber(String sNSNumber) {
		SNSNumber = sNSNumber;
	}
	public String getNowTime() {
		return nowTime;
	}
	public void setNowTime(String nowTime) {
		this.nowTime = nowTime;
	}
	
	public int getLifeCycle() {
		return lifeCycle;
	}
	public void setLifeCycle(int lifeCycle) {
		this.lifeCycle = lifeCycle;
	}
	public SMS(String phoneNumber, String sNSNumber, String nowTime, int lifeCycle) {
		super();
		this.phoneNumber = phoneNumber;
		SNSNumber = sNSNumber;
		this.nowTime = nowTime;
		this.lifeCycle = lifeCycle;
	}
	
	public SMS(){}
	
	
}
