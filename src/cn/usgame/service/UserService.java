package cn.usgame.service;

import java.util.List;

import cn.usgame.entity.Administrator;
import cn.usgame.entity.ApplyReport;
import cn.usgame.entity.Camp;
import cn.usgame.entity.CampApply;
import cn.usgame.entity.Competition;
import cn.usgame.entity.SMS;
import cn.usgame.entity.Train;
import cn.usgame.entity.TrainApply;
import cn.usgame.entity.Train_Subject;
import cn.usgame.entity.User;
import cn.usgame.filter.MyResponseWrapper;
import cn.usgame.filter.MyResquestWrapper;

public interface UserService {
	/**
	 * 
	 * 函数名称：RegisterUser
	 * 功能描述：注册用户
	 * 参数说明：注册号码，密码
	 * 返回值：boolean
	 * 备注：
	 * 
	 */
	 boolean registerUser(String id,String phone,String password);
	/**
	 * 
	 * 函数名称：login
	 * 功能描述：登录
	 * 参数说明：注册号码，密码
	 * 返回值：boolean
	 * 备注：
	 * 
	 */
	 User login(String phone,String password);
	
	
	/**
	 * 函数名称：checkVerificationCode
	 * 功能描述：验证内存中手机号码和验证码
	 * 参数说明：
	 * 返回值：void
	 * 备注：
	 * 
	 */
	 boolean checkVerificationCode();
	
	/**
	 * 函数名称：toUser
	 * 功能描述：保存个人信息
	 * 参数说明：
	 * 返回值：void
	 * 备注：
	 * 
	 */
	 boolean toUser(User user);
	
	/**
	 * 函数名称：changepw
	 * 功能描述：修改密码
	 * 参数说明：
	 * 返回值：void
	 * 备注：
	 * 
	 */
	 boolean changepw(String new_old,String phonenumber);
	
	/**
	 * 
	 * 函数名称：testUser
	 * 功能描述：验证手机号码是否已被使用
	 * 参数说明：
	 * 返回值：boolean
	 * 备注：
	 * 
	 */
	boolean testPhone(String phonenumber);
	
	/**
	 * 
	 * 函数名称：pushSMS
	 * 功能描述：将SMS放入栈内
	 * 参数说明：
	 * 返回值：boolean
	 * 备注：
	 * 
	 */
	boolean pushSMS(SMS sms);
	
	/**
	 * 
	 * 函数名称：popSMS
	 * 功能描述：出队列
	 * 参数说明：
	 * 返回值：boolean
	 * 备注：
	 * 
	 */
	boolean popSMS();
	
	/**
	 * 
	 * 函数名称：IsTimeOver
	 * 功能描述:验证是否超过时间周期
	 * 参数说明：
	 * 返回值：boolean 1成功验证2:验证码错误3；验证超时
	 * 备注：
	 * 
	 */
	boolean IsTimeOver(SMS sms2);
	
	/**
	 * 
	 * 函数名称：IsQualifiedSMS
	 * 功能描述：验证验证码是否有效
	 * 参数说明：
	 * 返回值：int
	 * 备注：未超时true超时false
	 * 
	 */
	int IsQualifiedSMS(String Phone, String SMSNumber);
	
	/**
	 * 
	 * 函数名称：getUserComptietion
	 * 功能描述：获取用户报名的比赛
	 * 参数说明：Phonenumber  注册手机号
	 * 返回值：<List>ApplyReport
	 * 备注：
	 * 
	 */
	List<ApplyReport> getUserCompetition(String Phonenumber);
	/**
	 * 
	 * 函数名称：applyreportInfo
	 * 功能描述：获得特定报名比赛的详情
	 * 参数说明：
	 * 返回值：void
	 * 备注：
	 * 
	 */
	ApplyReport applyreportInfo(String Phonenumber,String applyReportId);
	
	/**
	 * 
	 * 函数名称：getAllAdministrator
	 * 功能描述：获取管理员列表
	 * 参数说明：page  页数
	 * 返回值：<List>Administrator
	 * 备注：
	 * 
	 */
	List<Administrator> getAllAdministrator(int page);
	
	/**
	 * 
	 * 函数名称：getAdministratorNum
	 * 功能描述：获取管理员人数
	 * 参数说明：
	 * 返回值：String
	 * 备注：
	 * 
	 */
	String getAdministratorNum();
	
	/**
	 * 
	 * 函数名称：Administratorlogin
	 * 功能描述：登录
	 * 参数说明：注册号码，密码
	 * 返回值：
	 * 备注：
	 * 
	 */
	 Administrator Administratorlogin(String username,String password);
	/**
	 * 
	 * 函数名称：Setpw
	 * 功能描述：重置密码
	 * 参数说明：注册号码，密码
	 * 返回值：
	 * 备注：
	 * 
	 */
	 boolean Setpw(String phonenumber, String password);
	
	/**
	 * 
	 * 函数名称：deleteapplyreport
	 * 功能描述：删除订单
	 * 参数说明：注册号码，密码
	 * 返回值：
	 * 备注：
	 * 
	 */
	 boolean deleteapplyreport(String phonenumber, String applyReportId);
	
	/**
	 * 
	 * 函数名称：getAttentionCompetitionList
	 * 功能描述：获取关注竞赛
	 * 参数说明：注册号码，类型
	 * 返回值：List<Competition>
	 * 备注：
	 * 
	 */
	 List<Competition> getAttentionCompetitionList(String phonenumber, int type);
	 List<Camp> getAttentionCampList(String phonenumber, int type);
	 List<CampApply> getUserCamp(String Phonenumber);
	 List<Train_Subject> getAttentionTrainList(String phonenumber, int type);
	 List<TrainApply> getUserTrain(String phonenumber);
	 boolean deletecampapply(String phonenumber, String applyReportId);
	 boolean deletetrainapply(String phonenumber, String applyReportId);
	 
}
