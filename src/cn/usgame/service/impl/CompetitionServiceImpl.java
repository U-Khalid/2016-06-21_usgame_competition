package cn.usgame.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.jsp.tagext.TryCatchFinally;

import cn.usgame.dao.CompetitionDao;
import cn.usgame.dao.DaoFactory;
import cn.usgame.entity.ApplyReport;
import cn.usgame.entity.Applyorder;
import cn.usgame.entity.Competition;
import cn.usgame.entity.CompetitionGrade;
import cn.usgame.entity.News;
import cn.usgame.service.CompetitionService;
import cn.usgame.utils.TransactionUtil;


public class CompetitionServiceImpl implements CompetitionService {
	
	 private static CompetitionServiceImpl instance = new CompetitionServiceImpl();
	 
	 private CompetitionServiceImpl() {}
	 
	 public static CompetitionServiceImpl getInstance() {
		 return instance;
	 }
	 
	 
	CompetitionDao ddao = DaoFactory.getInstance().create("cn.usgame.dao.dbutils_impl.CompetitionDaoImply", CompetitionDao.class);
	
	@Override
	public boolean addCompetition(Competition com) {
		TransactionUtil.getConnection(); 
		boolean result = false;

		try {
			TransactionUtil.startTransaction(); 
			// ... 
			if(com.getCompetitionId().equals("")) {
				result =  ddao.addCompetition(com);
			} else {
				result = ddao.updateCompetition(com);
			}
			// ...

		} catch (Exception e){
			TransactionUtil.roolback();
			e.printStackTrace();
			result = false;
			
		} finally {
			TransactionUtil.commit();
			TransactionUtil.release(); 
		}
		return result;
	}
	
	@Override
	public List<Competition> getCompetitionList(int page,int type) {
		List<Competition> competitions = new ArrayList<>();
		if(type==1) {
			competitions = ddao.getAllCompetition(page);
		}
		else if(type==2) {
			competitions = ddao.getEffecCompetition();
		}
		return competitions;
	}

	
	@Override
	public Competition getCompetitionDetail(int competitionId) {
		Competition competition = ddao.getCompetitionById(competitionId);
		return competition;
	}
	
	@Override
	public String getCompetitionDes(int competitionId) {
		String competitionDes = ddao.getCompetitionDetailDes(competitionId);
		return competitionDes;
	}
	
	@Override
	public int applyReport(ApplyReport applyReport) {
		int result = -1;
		boolean temp = false;
		TransactionUtil.getConnection(); 
		int applyReportId = ddao.getApplyReport(applyReport);
		try {
			TransactionUtil.startTransaction(); 
			// 首次报名
			if (applyReportId == 0) {
				// 生成报名记录
				temp = ddao.applyReport(applyReport);
				
				// 生成订单记录 
				boolean res = ddao.addApplyorder(applyReport.getOut_trade_no());
				result = 1;
			}
			else if(applyReportId == 1) {//用户已经支付过
				result = 2;
			}
			else { // 修改资料后报名
				applyReport.setApplyReportId(applyReportId); // 
				temp = ddao.updateApplyReport(applyReport);
				result = 3;
			}
			// ...
		} catch (Exception e){
			TransactionUtil.roolback();
			e.printStackTrace();
		} finally {
			TransactionUtil.commit();
			TransactionUtil.release(); 
		}
		return result;
	}
	
	@Override
	public boolean userPay(Applyorder applyOrder) {
		boolean temp = false;
		boolean result = false;
		TransactionUtil.getConnection(); 

		try {
			TransactionUtil.startTransaction(); 
			temp = ddao.updateApplyorder(applyOrder);
			result = ddao.updateSateApplyReport(applyOrder);
			if(result&&temp) {
				result = true;
			}
			else {
				result = false;
			}
		} catch (Exception e) {
			TransactionUtil.roolback();
			e.printStackTrace();

		} finally {
			TransactionUtil.commit();
			TransactionUtil.release(); 
		}
		return result;
	}
	
	@Override
	public String getCompetitionNum() {
		return ddao.countCompetitionNum();
	}
	@Override
	public boolean reviseCompetitionState(int competitionId,int competitionState) {
		boolean result = false;
		TransactionUtil.getConnection(); 
		try {
			TransactionUtil.startTransaction(); 
			result = ddao.updateCompetitionState(competitionId, competitionState);
		} catch (Exception e) {
			TransactionUtil.roolback();
			e.printStackTrace();

		} finally {
			TransactionUtil.commit();
			TransactionUtil.release(); 
		}
		return result;
	}
	
	@Override
	public List<ApplyReport> getAllApplyReport(int page) {
		List<ApplyReport> applyReports = new ArrayList<>();
		applyReports = ddao.getAllReport(page);
		return applyReports;
	}
	
	@Override
	public String getApplyReportNum() {
		String applyReportNum = ddao.countApplyReportNum();
		return applyReportNum;
	}
	
	@Override
	public ApplyReport getApplyReportDetail(String phoneNum) {
		ApplyReport applyReport = ddao.getApplyReportDetail(phoneNum);
		return applyReport;
	}

	@Override
	public List<ApplyReport> getApplyReport(String starttime, String endtime, String options, String Info,
			int orderState,int page) {
		
		List<ApplyReport> applyReports = new ArrayList<>();
		applyReports = ddao.getApplyReport(starttime, endtime, options,Info, orderState,page);
		return applyReports;
	}
	
	@Override
	public String getSearchNum(String starttime, String endtime, String options, String Info,
			int orderState) {
		String num = ddao.countApplyReportBySearch(starttime, endtime, options, Info, orderState);
		return num;
	}

	@Override
	public List<ApplyReport> exportApplyReport(String starttime, String endtime, String options, String Info,
			int orderState) {
		List<ApplyReport> applyReports = new ArrayList<>();
		applyReports = ddao.exportApplyReport(starttime, endtime, options,Info, orderState);
		return applyReports;
	}

	@Override
	public Competition getticketAddress(String competitionName) {
		Competition competiton =ddao.getticketAddress(competitionName);
		return competiton;
	}

	@Override
	public String getgradeNum() {
		String gradeNum = ddao.countgradeNum();
		return gradeNum;
	}

	@Override
	public List<CompetitionGrade> getAllgradeList(int page) {
		List<CompetitionGrade> competitionGrades = new ArrayList<>();
		competitionGrades = ddao.getAllgradeList(page);
		return competitionGrades;
	}

	@Override
	public String getSearchGradeNum(String Info) {
		String num = ddao.getSearchGradeNum(Info);
		return num;
	}

	@Override
	public List<CompetitionGrade> getGradeList(String Info, int page) {
		List<CompetitionGrade> competitionGrades = new ArrayList<>();
		competitionGrades = ddao.getGradeList(Info,page);
		return competitionGrades;
	}

	@Override
	public List<CompetitionGrade> exportGrade(String Info) {
		List<CompetitionGrade> competitionGrades = new ArrayList<>();
		competitionGrades = ddao.exportGrade(Info);
		return competitionGrades;
	}

	@Override
	public CompetitionGrade querygrade(String admissionTicket, String pw) {
		boolean result = ddao.querygrade(admissionTicket, pw);
		if (result) {
			return ddao.getGrade(admissionTicket);
		} else {
			return null;
		}
	}

	@Override
	public boolean importGrade(List<CompetitionGrade> competitiongrades) {
		TransactionUtil.getConnection();
		boolean result = false;
		try {
			TransactionUtil.startTransaction(); 
			result = ddao.importGrade(competitiongrades);

		} catch (Exception e){
			TransactionUtil.roolback();
			e.printStackTrace();
			result = false;
			
		} finally {
			TransactionUtil.commit();
			TransactionUtil.release(); 
		}
		return result;
	}

	@Override
	public String getAllNewsNum() {
       String  num = ddao.getAllNewsNum();
		return num;
	}

	@Override
	public List<News> getAllNews(int page) {
		List<News> news = new ArrayList<>();
		news = ddao.getAllNews(page);
		return news;
	}
	
	@Override
	public News Newsdetails(int newId) {
		  News  news = ddao.Newsdetails(newId);
		return news;
		}

	@Override
	public boolean changeNewsdetails(int newsId,String info,String url,int state) {
		TransactionUtil.getConnection();
		boolean result = false;
		try {
			TransactionUtil.startTransaction(); 
			result = ddao.changeNewsdetails(newsId,info,url,state);

		} catch (Exception e){
			TransactionUtil.roolback();
			e.printStackTrace();
			result = false;
			
		} finally {
			TransactionUtil.commit();
			TransactionUtil.release(); 
		}
		return result;
	}

	@Override
	public boolean addNews(String info, String url, int state) {
		TransactionUtil.getConnection();
		boolean result = false;
		try {
			TransactionUtil.startTransaction(); 
			result = ddao.addNews(info,url,state);

		} catch (Exception e){
			TransactionUtil.roolback();
			e.printStackTrace();
			result = false;
			
		} finally {
			TransactionUtil.commit();
			TransactionUtil.release(); 
		}
		return result;
	}

	@Override
	public List<News> getEnableNewsInfo() {
		List<News> news = new ArrayList<>();
		news = ddao.getEnableNewsInfo();
		return news;
	}

	@Override
	public boolean importstudents(List<ApplyReport> applyReports) {
		TransactionUtil.getConnection();
		boolean result = false;
		try {
			TransactionUtil.startTransaction(); 
			result = ddao.importstudents(applyReports);

		} catch (Exception e){
			TransactionUtil.roolback();
			e.printStackTrace();
			result = false;
			
		} finally {
			TransactionUtil.commit();
			TransactionUtil.release(); 
		}
		return result;
	}

	@Override
	public ApplyReport getApplyReportDetailbackground(String idcard, String competitionName, String competitionSubject,
			int competitionGrade) {
		ApplyReport applyReport = ddao.getApplyReportDetailbackground(idcard,competitionName,competitionSubject,competitionGrade);
		return applyReport;
	}

	@Override
	public List<Competition> getMainCompetition() {
		List<Competition> competitions = ddao.getMainCompetition();
		return competitions;
	}

	@Override
	public Competition Web_getCompetitionDetails(int competitionId) {
		Competition competition  = ddao.Web_getCompetitionDetails(competitionId);
		return competition;
	}

	@Override
	public List<Competition> getCompetitionList() {
		List<Competition> competitions = ddao.getCompetitionList();
		return competitions;
	}

	@Override
	public int judgeApplyState(String out_trade_no) {
		int state = ddao.judgeApplyState(out_trade_no);
		return state;
	}

	@Override
	public Competition getCompetitionbyInfo(String competitionName, String competitionSubject, int money) {
		Competition competition = ddao.getCompetitionbyInfo(competitionName,competitionSubject,money);
		return competition;
	}

	@Override
	public List<Competition> getCompetitionListByForm(int course,int rtime) {
		List<Competition> competitions = ddao.getCompetitionListByForm(course,rtime);
		return competitions;
	}

	@Override
	public boolean AddCompetitionAttention(String phonenumber, String competitionId) {
		TransactionUtil.getConnection();
		boolean result = false;
		int attentionId = 0;
		attentionId = ddao.getattentionId(phonenumber,competitionId);
		try {
			TransactionUtil.startTransaction(); 
			if(attentionId==0){
				result = ddao.AddCompetitionAttention(phonenumber,competitionId);
			}
			else {
				result = ddao.updataAttentionState(phonenumber,competitionId);
			}

		} catch (Exception e){
			TransactionUtil.roolback();
			e.printStackTrace();
			result = false;
			
		} finally {
			TransactionUtil.commit();
			TransactionUtil.release(); 
		}
		return result;
		
	}

	@Override
	public boolean DelCompetitionAttention(String phonenumber, String competitionId) {
		TransactionUtil.getConnection();
		boolean result = false;
		try {
			TransactionUtil.startTransaction(); 
			result = ddao.DelCompetitionAttention(phonenumber,competitionId);

		} catch (Exception e){
			TransactionUtil.roolback();
			e.printStackTrace();
			result = false;
			
		} finally {
			TransactionUtil.commit();
			TransactionUtil.release(); 
		}
		return result;
	}

	@Override
	public int judgeAttentionState(String phonenumber, String competitionId) {
		int attentionState = ddao.judgeAttentionState(phonenumber,competitionId);
		return attentionState;
	}

	@Override
	public List<Competition> getCompetitionSearchInfo(String searchInfo) {
		List<Competition> competitions = ddao.getCompetitionSearchInfo(searchInfo);
		return competitions;
	}

	@Override
	public Competition getCompetitionSlides() {
		Competition competition = ddao.getCompetitionSlides();
		return competition;
	}
	
}
