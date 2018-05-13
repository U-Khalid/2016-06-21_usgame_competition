package cn.usgame.dao;

import java.util.List;

import cn.usgame.entity.Administrator;
import cn.usgame.entity.ApplyReport;
import cn.usgame.entity.Camp;
import cn.usgame.entity.CampApply;
import cn.usgame.entity.Competition;
import cn.usgame.entity.Train;
import cn.usgame.entity.TrainApply;
import cn.usgame.entity.Train_Subject;
import cn.usgame.entity.User;

public interface UserDao {
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
	 boolean login(String phone,String password);
	/**
	 * 
	 * 函数名称：getUser
	 * 功能描述：获取用户
	 * 参数说明：注册号码
	 * 返回值：boolean
	 * 备注：
	 * 
	 */
	 User getUser(String phone);
	
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
	 boolean changepw(String new_pw,String phonenumber);
	
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
	 * 函数名称：login
	 * 功能描述：登录
	 * 参数说明：注册号码，密码
	 * 返回值：boolean
	 * 备注：
	 * 
	 */
	 boolean Administratorlogin(String username,String password);
	/**
	 * 
	 * 函数名称：getUser
	 * 功能描述：获取用户
	 * 参数说明：注册号码
	 * 返回值：boolean
	 * 备注：
	 * 
	 */
	 Administrator getAdministrator(String username);
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
	 * 函数名称：getAttentionContentIdList
	 * 功能描述：获取关注内容Id数组
	 * 参数说明：注册号码，类型
	 * 返回值：int[]
	 * 备注：
	 * 
	 */
	 int[] getAttentionContentIdList(String phonenumber, int type);
	 
	 /**
		 * 
		 * 函数名称：getAttentionCompetitionList
		 * 功能描述：获取关注的竞赛通过竞赛id
		 * 参数说明：竞赛id
		 * 返回值：List<Competition>
		 * 备注：
		 * 
		 */
	 List<Competition> getAttentionCompetitionList(int[] competitionId);
	 List<Camp> getAttentionCampList(int[] campId);
	 List<CampApply> getUserCamp(String phonenumber);
	 List<Train_Subject> getAttentionTrainList(int[] tSubject_ID);
	 List<TrainApply> getUserTrain(String phonenumber);
	 boolean deletecampapply(String phonenumber, String applyReportId);
	 boolean deletetrainapply(String phonenumber, String applyReportId);
	
}
