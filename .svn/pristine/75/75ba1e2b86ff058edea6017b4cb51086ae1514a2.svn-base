package cn.usgame.entity;

import java.util.Map;

public class Applyorder {
	private String openid;  //用户标识
	private int total_fee;  //总金额
	private String transaction_id; //微信支付订单号
	private String out_trade_no; //商户订单号
	private String time_end;  //支付完成时间
	private String attach;  //商家数据包
	

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public int getTotal_fee() {
		return total_fee;
	}

	public void setTotal_fee(int total_fee) {
		this.total_fee = total_fee;
	}

	public String getTransaction_id() {
		return transaction_id;
	}

	public void setTransaction_id(String transaction_id) {
		this.transaction_id = transaction_id;
	}

	public String getOut_trade_no() {
		return out_trade_no;
	}

	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}

	public String getTime_end() {
		return time_end;
	}

	public void setTime_end(String time_end) {
		this.time_end = time_end;
	}

	public String getAttach() {
		return attach;
	}

	public void setAttach(String attach) {
		this.attach = attach;
	}

	public Applyorder() {}
	
	public Applyorder(Map<String, String> hashMap) {
		this.openid = hashMap.get("openid").toString();
		this.total_fee = Integer.parseInt(hashMap.get("total_fee").toString());
		this.transaction_id = hashMap.get("transaction_id").toString();
		this.out_trade_no = hashMap.get("out_trade_no").toString();
		
		System.out.println("Applyorder--out_trade_no--" + out_trade_no);
		
		
		this.time_end = hashMap.get("time_end").toString();
	}
}
