package cn.usgame.dao;

import java.util.List;

import cn.usgame.entity.ApplyReport;
import cn.usgame.entity.Applyorder;
import cn.usgame.entity.Competition;
import cn.usgame.entity.CompetitionGrade;
import cn.usgame.entity.News;



public interface CompetitionDao {

	
	public boolean addCompetition(Competition com);

	/**
	 * 
	 * 函数名称：getAllCompetition
	 * 功能描述：获取比赛列表
	 * 参数说明：页数
	 * 返回值：List<Competition>
	 * 备注：
	 * 
	 */
	List<Competition> getAllCompetition(int page);

	/**
	 * 
	 * 函数名称：getEffecCompetition
	 * 功能描述：获取有效的比赛列表
	 * 参数说明：
	 * 返回值：List<Competition>
	 * 备注：
	 * 
	 */
	List<Competition> getEffecCompetition();

	/**
	 * 
	 * 函数名称：getCompetitionById
	 * 功能描述：
	 * 参数说明：
	 * 返回值：Competition
	 * 备注：
	 * 
	 */
	Competition getCompetitionById(int competitionId);

	/**
	 * 
	 * 函数名称：getCompetitionDetailDes
	 * 功能描述：获取比赛详细描述
	 * 参数说明：
	 * 返回值：String
	 * 备注：
	 * 
	 */
	String getCompetitionDetailDes(int competitionId);

	/**
	 * 
	 * 函数名称：applyReport
	 * 功能描述：插入数据到报名表中
	 * 参数说明：
	 * 返回值：boolean
	 * 备注：
	 * 
	 */
	boolean applyReport(ApplyReport applyReport);

	/**
	 * 
	 * 函数名称：getApplyReport
	 * 功能描述：根据身份证，年级，大赛名取出id
	 * 参数说明：
	 * 返回值：boolean
	 * 备注：
	 * 
	 */
	int getApplyReport(ApplyReport a);

	/**
	 * 
	 * 函数名称：updateApplyReport
	 * 功能描述：修改报名表
	 * 参数说明：
	 * 返回值：boolean
	 * 备注：
	 * 
	 */
	boolean updateApplyReport(ApplyReport applyReport);

	/**
	 * 
	 * 函数名称：insertIntoApplyorder
	 * 功能描述：向Applyorder表插入数据
	 * 参数说明：
	 * 返回值：boolean
	 * 备注：
	 * 
	 */
	boolean updateApplyorder(Applyorder applyOrder);

	
	
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
	 * 函数名称：updateSateApplyReport
	 * 功能描述：修改applyreport表中applyReportState
	 * 参数说明：
	 * 返回值：boolean
	 * 备注：
	 * 
	 */
	boolean updateSateApplyReport(Applyorder applyOrder);

	/**
	 * 
	 * 函数名称：countCompetitionNum
	 * 功能描述：获取比赛个数
	 * 参数说明：
	 * 返回值：int
	 * 备注：
	 * 
	 */
	String countCompetitionNum();

	/**
	 * 
	 * 函数名称：updateCompetitionState
	 * 功能描述：修改比赛状态
	 * 参数说明：
	 * 返回值：boolean
	 * 备注：1:未开始报名2:正在报名3:比赛结束
	 * 
	 */
	boolean updateCompetitionState(int competitionId, int competitionState);

	/**
	 * 
	 * 函数名称：updateCompetition
	 * 功能描述：修改比赛表
	 * 参数说明：
	 * 返回值：boolean
	 * 备注：
	 * 
	 */
	boolean updateCompetition(Competition com);

	/**
	 * 
	 * 函数名称：getAllReport
	 * 功能描述：获取报名列表
	 * 参数说明：页数
	 * 返回值：List<ApplyReport>
	 * 备注：
	 * 
	 */
	List<ApplyReport> getAllReport(int page);

	/**
	 * 
	 * 函数名称：countApplyReportNum
	 * 功能描述：取出报名表的数据个数
	 * 参数说明：
	 * 返回值：String
	 * 备注：
	 * 
	 */
	String countApplyReportNum();

	/**
	 * 
	 * 函数名称：getApplyReportDetail
	 * 功能描述：根据手机号获取报名信息
	 * 参数说明：
	 * 返回值：ApplyReport
	 * 备注：
	 * 
	 */
	ApplyReport getApplyReportDetail(String phoneNum);

	/**
	 * 
	 * 函数名称：getApplyReport
	 * 功能描述：按条件搜索
	 * 参数说明：根据时间，注册号码，大赛名称或者支付状态查询订单
	 * 返回值：List<ApplyReport>
	 * 备注：
	 * 
	 */
	List<ApplyReport> getApplyReport(String starttime , String endtime , String options , String Info , int orderState,int page);

	/**
	 * 
	 * 函数名称：countApplyReportBySearch
	 * 功能描述：获取搜索记录总数
	 * 参数说明：
	 * 返回值：String
	 * 备注：
	 * 
	 */
	String countApplyReportBySearch(String starttime, String endtime, String options, String Info, int orderState);
	
	/**
	 * 
	 * 函数名称：getApplyReport
	 * 功能描述：按条件搜索
	 * 参数说明：
	 * 返回值：List<ApplyReport>
	 * 备注：
	 * 
	 */
	List<ApplyReport> exportApplyReport(String starttime , String endtime , String options , String Info , int orderState);
	
	/**
	 * 
	 * 函数名称：getticketAddress
	 * 功能描述：通过比赛名获取比赛的报名地点
	 * 参数说明：
	 * 返回值：Competition
	 * 备注：
	 * 
	 */
	Competition getticketAddress(String competitionName);
	
	/**
	 * 
	 * 函数名称：getAllgradeList
	 * 功能描述：获取成绩列表
	 * 参数说明：
	 * 返回值：void
	 * 备注：
	 * 
	 */
	List<CompetitionGrade> getAllgradeList(int page);

	/**
	 * 
	 * 函数名称：getgradeNum
	 * 功能描述：	获取成绩条数
	 * 参数说明：
	 * 返回值：String
	 * 备注：
	 * 
	 */
	String countgradeNum();
	/**
	 * 
	 * 函数名称：getSearchGradeNum
	 * 功能描述：获取搜索成绩条数
	 * 参数说明：
	 * 返回值：String
	 * 备注：
	 * 
	 *  */
	String getSearchGradeNum(String Info);
	
	/**
	 * 
	 * 函数名称：getGradeList
	 * 功能描述：按条件搜索
	 * 参数说明：
	 * 返回值：List<CompetitionGrade>
	 * 备注：
	 * 
	 */
	List<CompetitionGrade> getGradeList(String Info,int page);
	/**
	 * 
	 * 函数名称：exportGrade
	 * 功能描述：按条件导出成绩
	 * 参数说明：
	 * 返回值：List<CompetitionGrade>
	 * 备注：
	 * 
	 */
	List<CompetitionGrade> exportGrade(String Info);
	/**
	 * 
	 * 函数名称：exportGrade
	 * 功能描述：按条件导出成绩
	 * 参数说明：
	 * 返回值：List<CompetitionGrade>
	 * 备注：
	 * 
	 */
	boolean importGrade(List<CompetitionGrade> competitiongrades);
	/**
	 * 
	 * 函数名称：querygrade
	 * 功能描述：判断成绩是否存在
	 * 参数说明：
	 * 返回值：Competition
	 * 备注：
	 * 
	 */
	boolean querygrade(String admissionTicket,String pw);
	
	/**
	 * 
	 * 函数名称：getGrade
	 * 功能描述：查询成绩
	 * 参数说明：
	 * 返回值：Competition
	 * 备注：
	 * 
	 */
	CompetitionGrade getGrade(String admissionTicket);
	
	/**
	 * 
	 * 函数名称：getAllNewsNum
	 * 功能描述：	获取新闻数
	 * 参数说明：
	 * 返回值：String
	 * 备注：
	 * 
	 */
	String getAllNewsNum();

	/**
	 * 
	 * 函数名称：getAllNews
	 * 功能描述：按页码获取新闻列表
	 * 参数说明：
	 * 返回值：List<News>
	 * 备注：
	 * 
	 */
	List<News> getAllNews(int page);
	
	/**
	 * 
	 * 函数名称：Newsdetails
	 * 功能描述：新闻详情
	 * 参数说明：
	 * 返回值：News
	 * 备注：
	 * 
	 */
	News Newsdetails(int newId);
	
	/**
	 * 
	 * 函数名称：changeNewsdetails
	 * 功能描述：修改新闻详情
	 * 参数说明：
	 * 返回值：boolean
	 * 备注：
	 * 
	 */
	boolean changeNewsdetails(int newsId,String info,String url,int state);
	
	/**
	 * 
	 * 函数名称：addNews
	 * 功能描述：新增新闻详情
	 * 参数说明：
	 * 返回值：boolean
	 * 备注：
	 * 
	 */
	boolean addNews(String info,String url,int state);
	
	/**
	 * 
	 * 函数名称：getEnableNewsInfo
	 * 功能描述：获取有效的消息列表
	 * 参数说明：
	 * 返回值：List<News>
	 * 备注：
	 * 
	 */
	List<News> getEnableNewsInfo();

	/**
	 * 
	 * 函数名称：importstudents
	 * 功能描述：导入现场报名的学生
	 * 参数说明：List<ApplyReport>
	 * 返回值：boolean
	 * 备注：
	 * 
	 */
	public boolean importstudents(List<ApplyReport> applyReports);
	/**
	 * 
	 * 函数名称：getApplyReportDetailbackground
	 * 功能描述：后台查看订单
	 * 参数说明：
	 * 返回值：ApplyReport
	 * 备注：
	 * 
	 */
	public ApplyReport getApplyReportDetailbackground(String idcard, String competitionName, String competitionSubject,
			int competitionGrade);
	/**
	 * 
	 * 函数名称：getMainCompetition
	 * 功能描述：得到首页竞赛
	 * 参数说明：
	 * 返回值：List<Competition>
	 * 备注：
	 * 
	 */
	public List<Competition> getMainCompetition();
	/**
	 * 
	 * 函数名称：Web_getCompetitionDetails
	 * 功能描述：网页端得到竞赛详情根据竞赛id
	 * 参数说明：
	 * 返回值：Competition
	 * 备注：
	 * 
	 */
	public Competition Web_getCompetitionDetails(int competitionId);
	/**
	 * 
	 * 函数名称：getCompetitionList
	 * 功能描述：获取比赛列表
	 * 参数说明：
	 * 返回值：Competition
	 * 备注：
	 * 
	 */
	public List<Competition> getCompetitionList();
	/**
	 * 
	 * 函数名称：judgeApplyState
	 * 功能描述：订单比赛列表
	 * 参数说明：out_trade_no
	 * 返回值：int
	 * 备注：
	 * 
	 */
	public int judgeApplyState(String out_trade_no);
	/**
	 * 函数名称：getCompetitionbyInfo 
	 * 功能描述：获得竞赛
	 * 参数说明：竞赛名，科目，报名金额
	 * 返回值：competition 备注：
	 * 
	 */
	public Competition getCompetitionbyInfo(String competitionName, String competitionSubject, int money);
	/**
	 * 
	 * 函数名称：getCompetitionListByForm
	 * 功能描述：获取比赛列表
	 * 参数说明：课程，赛事级别，报名状态
	 * 返回值：List<Competition>
	 * 备注：
	 * 
	 */
	public List<Competition> getCompetitionListByForm(int course, int rtime);
	
	/**
	 * 函数名称：getattentionId
	 *  功能描述：获得关注Id 
	 *  参数说明：用户注册号，竞赛Id
	 *  返回值：int 
	 *  备注：
	 */
     int getattentionId(String phonenumber, String competitionId);
     
	/**
	 * 函数名称：AddCompetitionAttention
	 *  功能描述：添加竞赛关注 
	 *  参数说明：用户注册号，竞赛Id
	 *  返回值：boolean 
	 *  备注：
	 */
	 boolean AddCompetitionAttention(String phonenumber, String competitionId);
	 /**
		 * 函数名称：DelCompetitionAttention
		 *  功能描述：取消竞赛关注 
		 *  参数说明：用户注册号，竞赛Id
		 *  返回值：boolean 
		 *  备注：
		 */
	 boolean DelCompetitionAttention(String phonenumber, String competitionId);
	 /**
		 * 函数名称：judgeAttentionState
		 *  功能描述：判断关注状态
		 *  参数说明：用户注册号，竞赛Id
		 *  返回值：关注状态 
		 *  备注：
		 */
	 int judgeAttentionState(String phonenumber, String competitionId);
	 /**
		 * 函数名称：updataAttentionState
		 *  功能描述：修改关注状态
		 *  参数说明：用户注册号，竞赛Id
		 *  返回值：boolean 
		 *  备注：
		 */
	 boolean updataAttentionState(String phonenumber, String competitionId);

	public List<Competition> getCompetitionSearchInfo(String searchInfo);

	public Competition getCompetitionSlides();
	 
	
}
