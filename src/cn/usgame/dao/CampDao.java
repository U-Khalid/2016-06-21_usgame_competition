package cn.usgame.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import cn.usgame.entity.ApplyReport;
import cn.usgame.entity.Camp;
import cn.usgame.entity.CampApply;



public interface CampDao {
	
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

	public Camp Web_getCampDetails(int campId);

	
	/**
	 * 函数名称：getattentionId
	 *  功能描述：获得关注Id 
	 *  参数说明：用户注册号，竞赛Id
	 *  返回值：int 
	 *  备注：
	 */
	int getattentionId(String phonenumber, String campId);

	/**
	 * 函数名称：AddCompetitionAttention
	 *  功能描述：添加营地关注 
	 *  参数说明：用户注册号，竞赛Id
	 *  返回值：boolean 
	 *  备注：
	 */
	boolean AddCampAttention(String phonenumber, String campId);

	
	/**
	 * 函数名称：updataAttentionState
	 *  功能描述：修改关注状态
	 *  参数说明：用户注册号，竞赛Id
	 *  返回值：boolean 
	 *  备注：
	 */
	boolean updataAttentionState(String phonenumber, String campId);

	
	int judgeAttentionState(String phonenumber, String campId);

	/**
	 * 函数名称：DelAttention
	 *  功能描述：取消竞赛关注 
	 *  参数说明：用户注册号，竞赛Id
	 *  返回值：boolean 
	 *  备注：
	 * 
	 * 
	 * @throws SQLException
	 * @throws IOException
	 */
	boolean DelCampAttention(String phonenumber, String campId);


	
	/**
	 * 函数名称：getCampListByForm
	 *  功能描述：获取营地列表 
	 *  参数说明： 
	 *  返回值：void 
	 *  备注：
	 * 
	 * 
	 * @throws SQLException
	 * @throws IOException
	 */
	List<Camp> getCampListByForm(String destination, String theme, int suitableAge, int timeLength);


	
	/**
	 * 
	 * 函数名称：getcampApply
	 * 功能描述：根据身份证，年级，大赛名取出id
	 * 参数说明：
	 * 返回值：boolean
	 * 备注：
	 * 
	 */
	int getCampApply(CampApply c);

	List<Camp> getCampSearchInfo(String searchInfo);

	/**
	 * 
	 * 函数名称：applyReport
	 * 功能描述：插入数据到报名表中
	 * 参数说明：
	 * 返回值：boolean
	 * 备注：
	 * 
	 */
	boolean applyReport(CampApply campapply);

	
	/**
	 * 函数名称：addApplyorder
	 * 功能描述：生成一条订单记录
	 * 参数说明：
	 * 返回值：boolean
	 * 备注：
	 * 
	 */
	boolean addApplyorder(String out_trade_no);

	/**
	 * 
	 * 函数名称：updatecampApply
	 * 功能描述：修改报名表
	 * 参数说明：
	 * 返回值：boolean
	 * 备注：
	 * 
	 */
	boolean updatecampApply(CampApply campapply);

	
	/**
	 * 
	 * 函数名称：judgeApplyState
	 * 功能描述：订单比赛列表
	 * 参数说明：out_trade_no
	 * 返回值：int
	 * 备注：
	 * 
	 */
	int judgeApplyState(String out_trade_no);

	List<Camp> getCampList(int page);

	String countCampNum();

	boolean reviseCampState(int campId, int campstate);

	Camp getCampSlides();

	boolean addCamp(Camp camp);

	boolean updateCamp(Camp camp);

	Camp getCampbyInfo(String camp_Name, String camp_Address, int money);

	List<CampApply> getAllReport(int page);

	String countCampApplyNum();

	CampApply getCampApplyDetailbackground(String idcard, String camp_Name, String camp_Address, int camp_Age);

	List<CampApply> getCampApply(String starttime, String endtime, String options, String info, int orderState,
			int page);

	String countCampApplyBySearch(String starttime, String endtime, String options, String info, int orderState);

	List<CampApply> exportCampApply(String starttime, String endtime, String options, String info, int orderState);



}
