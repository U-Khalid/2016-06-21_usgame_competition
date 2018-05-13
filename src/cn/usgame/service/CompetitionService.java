package cn.usgame.service;


import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.google.gson.JsonArray;

import cn.usgame.entity.ApplyReport;
import cn.usgame.entity.Applyorder;
import cn.usgame.entity.Competition;
import cn.usgame.entity.CompetitionGrade;
import cn.usgame.entity.News;

public interface CompetitionService {

	
	 boolean addCompetition(Competition com);

	/**
	 * 
	 * 函数名称：getCompetitionList
	 * 功能描述：获取比赛列表
	 * 参数说明：page页号，type=1选出所以比赛列表，type＝2选出有效比赛
	 * 返回值：Competition
	 * 备注：
	 * 
	 */
	List<Competition> getCompetitionList(int page,int type);

	/**
	 * 
	 * 函数名称：getCompetitionDetail
	 * 功能描述：通过比赛id获取比赛的详情
	 * 参数说明：
	 * 返回值：Competition
	 * 备注：
	 * 
	 */
	Competition getCompetitionDetail(int competitionId);

	/**
	 * 
	 * 函数名称：getCompetitionDes
	 * 功能描述：获取比赛详细描述
	 * 参数说明：
	 * 返回值：String
	 * 备注：
	 * 
	 */
	String getCompetitionDes(int competitionId);

	/**
	 * 
	 * 函数名称：applyReport
	 * 功能描述：用户报名
	 * 参数说明：
	 * 返回值：int
	 * 备注：1:首次报名2:已经支付过3:修改报名信息
	 * 
	 */
	int applyReport(ApplyReport applyReport);

	/**
	 * 
	 * 函数名称：userPay
	 * 功能描述：用户支付
	 * 参数说明：
	 * 返回值：boolean
	 * 备注：
	 * 
	 */
	boolean userPay(Applyorder applyOrder);

	/**
	 * 
	 * 函数名称：getCompetitionNum
	 * 功能描述：获得比赛个数
	 * 参数说明：
	 * 返回值：String
	 * 备注：
	 * 
	 */
	String getCompetitionNum();

	/**
	 * 
	 * 函数名称：reviseCompetitionState
	 * 功能描述：修改比赛状态
	 * 参数说明：
	 * 返回值：boolean
	 * 备注：1:未开始报名2:正在报名3:比赛结束
	 * 
	 */
	boolean reviseCompetitionState(int competitionId, int competitionState);

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

	/**
	 * 
	 * 函数名称：getAllApplyReport
	 * 功能描述：按页码获取报名表
	 * 参数说明：
	 * 返回值：List<ApplyReport>
	 * 备注：
	 * 
	 */
	List<ApplyReport> getAllApplyReport(int page);

	/**
	 * 
	 * 函数名称：getApplyReportDetail
	 * 功能描述：获取订单详细信息
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
	 * 参数说明：
	 * 返回值：List<ApplyReport>
	 * 备注：
	 * 
	 */
	List<ApplyReport> getApplyReport(String starttime , String endtime , String options , String Info , int orderState,int page);

	/**
	 * 
	 * 函数名称：getSearchNum
	 * 功能描述：获取搜索记录的总条数
	 * 参数说明：
	 * 返回值：String
	 * 备注：
	 * 
	 */
	String getSearchNum(String starttime, String endtime, String options, String Info, int orderState);
	
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
	 * 函数名称：getgradeNum
	 * 功能描述：	获取成绩条数
	 * 参数说明：
	 * 返回值：String
	 * 备注：
	 * 
	 */
	String getgradeNum();

	/**
	 * 
	 * 函数名称：getAllgradeList
	 * 功能描述：按页码获取成绩表
	 * 参数说明：
	 * 返回值：List<CompetitionGrade>
	 * 备注：
	 * 
	 */
	List<CompetitionGrade> getAllgradeList(int page);
	
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
	 * 函数名称：importGrade
	 * 功能描述：导入成绩
	 * 参数说明：
	 * 返回值：boolean
	 * 备注：
	 * 
	 */
	boolean importGrade(List<CompetitionGrade> competitiongrades);
	/**
	 * 
	 * 函数名称：querygrade
	 * 功能描述：查询成绩
	 * 参数说明：
	 * 返回值：Competition
	 * 备注：
	 * 
	 */
	CompetitionGrade querygrade(String admissionTicket,String pw);
	
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
	 boolean importstudents(List<ApplyReport> applyReports);

	/**
	 * 
	 * 函数名称：getApplyReportDetailbackground
	 * 功能描述：后台查看订单
	 * 参数说明：
	 * 返回值：ApplyReport
	 * 备注：
	 * 
	 */
	 ApplyReport getApplyReportDetailbackground(String idcard, String competitionName, String competitionSubject,
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
	 List<Competition> getMainCompetition();
	/**
	 * 
	 * 函数名称：Web_getCompetitionDetails
	 * 功能描述：网页端得到竞赛详情根据竞赛id
	 * 参数说明：
	 * 返回值：Competition
	 * 备注：
	 * 
	 */
	 Competition Web_getCompetitionDetails(int competitionId);
	/**
	 * 
	 * 函数名称：getCompetitionList
	 * 功能描述：获取比赛列表
	 * 参数说明：
	 * 返回值：Competition
	 * 备注：
	 * 
	 */
	 List<Competition> getCompetitionList();
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
	/**
	 * 函数名称：getCompetitionbyInfo 
	 * 功能描述：获得竞赛
	 * 参数说明：竞赛名，科目，报名金额
	 * 返回值：competition 备注：
	 * 
	 */
	 Competition getCompetitionbyInfo(String competitionName, String competitionSubject, int money);
	/**
	 * 
	 * 函数名称：getCompetitionListByForm
	 * 功能描述：获取比赛列表
	 * 参数说明：课程，赛事级别，报名状态
	 * 返回值：List<Competition>
	 * 备注：
	 * 
	 */
	 List<Competition> getCompetitionListByForm(int course, int rtime);
	
	/**
	 * 函数名称：AddCompetitionAttention
	 *  功能描述：添加竞赛关注 
	 *  参数说明：用户注册号，竞赛Id
	 *  返回值：boolean 
	 *  备注：
	 */
	 boolean AddCompetitionAttention( String phonenumber, String competitionId);
	 
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

	List<Competition> getCompetitionSearchInfo(String searchInfo);

	Competition getCompetitionSlides();

}
