package cn.usgame.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import cn.usgame.entity.ApplyReport;
import cn.usgame.entity.Camp;
import cn.usgame.entity.CampApply;
import cn.usgame.entity.Competition;


public interface CampService {

	/**
	 * 
	 * 函数名称：getCampList 功能描述：获取营地列表 参数说明： 返回值：void 备注：
	 * 
	 * 
	 * @throws SQLException
	 * @throws IOException
	*/
	
	List<Camp> getCampList();

	
	/**
	 * 
	 * 函数名称：getMainCamp 功能描述：得到首页的营地   参数说明： 返回值：void 备注：
	 * 
	 * 
	 */
	
	List<Camp> getMainCamp();

	/**
	 * 
	 * 函数名称：Web_getCampDetails 功能描述：获取营地详情 参数说明： 返回值：void 备注：
	 * 
	 */

	Camp Web_getCampDetails(int campId);

	/**
	 * 函数名称：payAttention
	 *  功能描述：添加营地关注 
	 *  参数说明：用户注册号，竞赛Id
	 *  返回值：boolean 
	 *  备注：
	 * 
	 * 
	 * @throws SQLException
	 * @throws IOException
	 */
	boolean AddCampAttention(String phonenumber, String campId);


	int judgeAttentionState(String phonenumber, String campId);


	boolean DelCampAttention(String phonenumber, String campId);


	List<Camp> getCampListByForm(String destination, String theme, int suitableAge, int timeLength);

	/**
	 * 
	 * 函数名称：campapply
	 * 功能描述：用户报名
	 * 参数说明：
	 * 返回值：int
	 * 备注：1:首次报名2:已经支付过3:修改报名信息
	 * 
	 */
	int campapply(CampApply campapply);



	List<Camp> getCampSearchInfo(String searchInfo);


	/**
	 * 函数名称：judgeApplyState 功能描述：判断订单状态   参数说明： out_trade_no 订单号 返回值：订单状态  备注：
	 * 
	 * 
	 * @throws SQLException
	 * @throws IOException
	 */
	int judgeApplyState(String out_trade_no);


	List<Camp> getCampList(int page);


	String getCampNum();


	boolean reviseCampState(int campId, int campstate);


	Camp getCampSlides();


	boolean addCamp(Camp camp);


	Camp getCampbyInfo(String camp_Name, String camp_Address, int money);

	/**
	 * 
	 * 函数名称：getAllApplyReport
	 * 功能描述：按页码获取报名表
	 * 参数说明：
	 * 返回值：List<CampApply>
	 * 备注：
	 * 
	 */
	List<CampApply> getAllApplyReport(int page);

	/**
	 * 
	 * 函数名称：getApplyReportNum
	 * 功能描述：	获取报名人数
	 * 参数说明：
	 * 返回值：String
	 * 备注：
	 * 
	 */
	String getApplyReportNum();


	CampApply getCampApplyDetailbackground(String idcard, String camp_Name, String camp_Address, int camp_Age);


	List<CampApply> getApplyReport(String starttime, String endtime, String options, String info, int orderState,
			int page);


	String getSearchNum(String starttime, String endtime, String options, String info, int orderState);


	List<CampApply> exportCampApply(String starttime, String endtime, String options, String info, int orderState);



}
