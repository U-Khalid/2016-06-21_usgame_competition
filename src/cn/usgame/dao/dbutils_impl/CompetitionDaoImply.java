package cn.usgame.dao.dbutils_impl;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;

import cn.usgame.dao.CompetitionDao;
import cn.usgame.entity.ApplyReport;
import cn.usgame.entity.Applyorder;
import cn.usgame.entity.Attention;
import cn.usgame.entity.Competition;
import cn.usgame.entity.CompetitionGrade;
import cn.usgame.entity.News;
import cn.usgame.utils.JdbcUtils_DBCP;
import cn.usgame.utils.TransactionUtil;


public class CompetitionDaoImply implements CompetitionDao {

	private static QueryRunner runerUpdate = new QueryRunner();
	private static QueryRunner runerQuery = new QueryRunner(JdbcUtils_DBCP.getDataSource());
	
	@Override
	public boolean addCompetition(Competition com) {
		boolean flag = true;
		String sql = "INSERT INTO competition (`competitionName`, `competitionSubject`, `competitionApplyStartTime`, `competitionApplyEndTime`, `competitionJoinerDes`, `competitionMoney`, `competitionType`, `competitionPrizeDes`, `competitionTestTimeDes`, `competitionApplyAddress`, `competitionTestAddress`, `competitionDetail`, `competitionSupportDesc`,`competitionForm`,`competitionState`,competitionGrade,state,competitionPic,competitionBigPic) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		Object[ ] param = {
			com.getCompetitionName(),com.getCompetitionSubject(),com.getCompetitionApplyStartTime(),
			com.getCompetitionApplyEndTime(),com.getCompetitionJoinerDes(),com.getCompetitionMoney(),com.getCompetitionType(),
			com.getCompetitionPrizeDes(),com.getCompetitionTestTimeDes(),com.getCompetitionApplyAddress(),com.getCompetitionTestAddress(),
			com.getCompetitionDetail(),com.getCompetitionSupportDesc(),com.getCompetitionForm(),1,com.getCompetitionGrade(),
			com.getState(),com.getCompetitionPic(),com.getCompetitionBigPic()
		};
		
		try {
			int res = runerUpdate.update(TransactionUtil.getConnection(), sql, param);
			
		} catch (SQLException e) {
			flag = false;
			e.printStackTrace();
		}
		return flag;
	}
	
	@Override
	public List<Competition>  getAllCompetition(int page)  {
		//获取30条数据
		int startPos = (page - 1) * 30;
		List<Competition> competitions = null;
		String sql = "select * from competition order by competitionid DESC limit ?,?"; 
		Object[] param = {startPos,30};
		
		try {
			competitions = runerQuery.query(sql, param, new BeanListHandler<Competition>(Competition.class));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return competitions;
	}
	
	@Override
	public List<Competition> getEffecCompetition() {
		List<Competition> competitions = null;
		//competitionState=1为有限比赛，=0为无效比赛
		String sql = "select * from competition where competitionState=2";
		try {
			competitions = runerQuery.query(sql, new BeanListHandler<Competition>(Competition.class));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return competitions;
	}
	
	@Override
	public Competition getCompetitionById(int competitionId) {
		Competition competition = new Competition();
		String sql = "select * from competition where competitionId=?";
		Object[] param = {competitionId};
		try {
			competition = runerQuery.query(sql, param, new BeanHandler<>(Competition.class));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return competition;
	}
	
	@Override
	public String getCompetitionDetailDes(int competitionId) {
		Competition competitionDetDes = null;
		String sql = "select competitionDetail from competition where competitionId=?";
		Object[] param = {competitionId};
		try {
			competitionDetDes = runerQuery.query(sql, param,new BeanHandler<>(Competition.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return competitionDetDes.getCompetitionDetail();
	}
	
	@Override
	public boolean applyReport(ApplyReport applyReport) {
		boolean result = true;
		String sql = "insert into applyreport (`applyReportId`,`name`,`idCard`,`school`,`grade`,`competitionName`,`competitionSubject`,`competitionGrade`,`contectName`,`contectPhone`,`phoneNumber`, out_trade_no,money,applyReportTime,state) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		SimpleDateFormat s = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
		Object[] param = {
				applyReport.getApplyReportId(),applyReport.getName(),applyReport.getIdCard(),applyReport.getSchool(),
				applyReport.getGrade(),applyReport.getCompetitionName(),applyReport.getCompetitionSubject(),applyReport.getCompetitionGrade(),
				applyReport.getContectName(),applyReport.getContectPhone(),applyReport.getPhoneNumber(),applyReport.getOut_trade_no(),applyReport.getMoney(),s.format(applyReport.getApplyReportTime()),1
		};
		try {
			int res = runerUpdate.update(TransactionUtil.getConnection(), sql, param);
		} catch(SQLException e) {
			result=false;
			e.printStackTrace();
		}
		return result;
	}
	
	@Override
	public int getApplyReport(ApplyReport a) {
		ApplyReport applyReport = new ApplyReport();
		String sql = "select applyReportId,applyReportState from applyreport where idCard=? and competitionName=? and competitionGrade=? and competitionSubject=? and state=?";
		int applyReportId = 0;
		Object[] param = {
				a.getIdCard(),a.getCompetitionName(),a.getCompetitionGrade(),a.getCompetitionSubject(),1
		};
		try {
			applyReport =  runerQuery.query(sql, param, new BeanHandler<>(ApplyReport.class));
		} catch(SQLException e) {
			e.printStackTrace();
		}
		try {
			applyReportId = applyReport.getApplyReportId();
			if(applyReport.getApplyReportState()==1) {
				applyReportId = 1;
			}
			return applyReportId;
		} catch (Exception e) {
			return 0;
		}
	}
	
	@Override
	public boolean updateApplyReport(ApplyReport applyReport) {
		boolean result = true;
		String sql = "update applyreport set name=?,idCard=?,school=?,grade=?,competitionName=?,competitionSubject=?,competitionGrade=?,contectName=?,contectPhone=? where applyReportId=?";
		Object[] param = {
				applyReport.getName(),applyReport.getIdCard(),applyReport.getSchool(),applyReport.getGrade(),applyReport.getCompetitionName(),applyReport.getCompetitionSubject(),
				applyReport.getCompetitionGrade(),applyReport.getContectName(),applyReport.getContectPhone(),applyReport.getApplyReportId()
		};
		try {
			int res = runerUpdate.update(TransactionUtil.getConnection(), sql, param);
		} catch(SQLException e) {
			result=false;
			e.printStackTrace();
		}
		return result;
	}
	
	
	
	@Override
	public boolean updateApplyorder(Applyorder applyOrder) {
		boolean result = true;
		String sql = "update applyorder set openid=?,total_fee=?,transaction_id=?,time_end=? where out_trade_no=?";
		Object[] param = {
				applyOrder.getOpenid(),applyOrder.getTotal_fee(),
				applyOrder.getTransaction_id(), applyOrder.getTime_end(),applyOrder.getOut_trade_no()
		};
		try {
			int res = runerUpdate.update(TransactionUtil.getConnection(), sql, param);
		} catch(SQLException e) {
			result = false;
			e.printStackTrace();
		}
		return result;
	}
	
	@Override
	public boolean updateSateApplyReport(Applyorder applyOrder) {
		boolean result = true;
		String sql = "update applyreport set applyReportState=? where out_trade_no=?";
		Object[] param = {
				1,applyOrder.getOut_trade_no()
		};
		try {
			int res = runerUpdate.update(TransactionUtil.getConnection(), sql, param);
		} catch(SQLException e) {
			result=false;
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public boolean addApplyorder(String out_trade_no) {
		boolean result = true;
		String sql = "insert into applyorder (out_trade_no) values (?)";
		Object[] param = {
				out_trade_no
		};
		try {
			int res = runerUpdate.update(TransactionUtil.getConnection(), sql, param);
		} catch(SQLException e) {
			result = false;
			e.printStackTrace();
		}
		return result;
	}
	@Override
	public String countCompetitionNum() {
		String number = null;
		Map a;
		String sql = "select count(*) from competition";
		try {
			a =  runerQuery.query(sql, new MapHandler());
			number = a.get("count(*)").toString();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return number;
	}
	@Override
	public boolean updateCompetitionState(int competitionId,int competitionState) {
		boolean result = true;
		String sql = "update competition set competitionState=? where competitionId=?";
		Object[] param = {
				competitionState,competitionId
		};
		try {
			int res = runerUpdate.update(TransactionUtil.getConnection(), sql, param);
		} catch(SQLException e) {
			result = false;
			e.printStackTrace();
		}
		return result;
	}
	
	@Override
	public boolean updateCompetition(Competition com) {
		boolean result = true;
		String sql = "update competition set competitionName=?,competitionSubject=?,competitionApplyStartTime=?,competitionApplyEndTime=?,competitionJoinerDes=?,competitionMoney=?,competitionType=?,competitionPrizeDes=?,competitionTestTimeDes=?,competitionApplyAddress=?,competitionTestAddress=?,competitionDetail=?,competitionSupportDesc=?,competitionForm=? ,competitionGrade=?,state=? ,competitionPic=?  ,competitionBigPic=? where competitionId=?";
		Object[] param = {
				com.getCompetitionName(),com.getCompetitionSubject(),com.getCompetitionApplyStartTime(),
				com.getCompetitionApplyEndTime(),com.getCompetitionJoinerDes(),com.getCompetitionMoney(),com.getCompetitionType(),
				com.getCompetitionPrizeDes(),com.getCompetitionTestTimeDes(),com.getCompetitionApplyAddress(),com.getCompetitionTestAddress(),
				com.getCompetitionDetail(),com.getCompetitionSupportDesc(),com.getCompetitionForm(),com.getCompetitionGrade(),
				com.getState(),com.getCompetitionPic(),com.getCompetitionBigPic(),
				com.getCompetitionId()
		};
		try {
			int res = runerUpdate.update(TransactionUtil.getConnection(), sql, param);
		} catch(SQLException e) {
			result = false;
			e.printStackTrace();
		}
		return result;
	}
	
	@Override
	public List<ApplyReport>  getAllReport(int page)  {
		//获取30条数据
		int startPos = (page - 1) * 30;
		List<ApplyReport> applyReport = null;
		String sql = "select * from applyreport limit ?,?"; 
		Object[] param = {startPos,30};
		
		try {
			applyReport = runerQuery.query(sql, param, new BeanListHandler<ApplyReport>(ApplyReport.class));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return applyReport;
	}
	
	@Override
	public String countApplyReportNum() {
		String number = null;
		Map a;
		String sql = "select count(*) from applyreport";
		try {
			a =  runerQuery.query(sql, new MapHandler());
			number = a.get("count(*)").toString();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return number;
	}
	
	@Override
	public ApplyReport getApplyReportDetail(String phoneNum) {
		ApplyReport applyReport = null;
		String sql = "select * from applyreport where phoneNumber=? and state=?";
		Object[] param= {phoneNum,1};
		try {
		applyReport = runerQuery.query(sql, param , new BeanHandler<ApplyReport>(ApplyReport.class));
		} catch(SQLException e){
			e.printStackTrace();
		}
		return applyReport;
	}

	@Override
	public List<ApplyReport> getApplyReport(String starttime, String endtime, String options, String Info,int orderState,int page) {
		int startPos = (page - 1) * 30;
		List<ApplyReport> applyReports = null;
		StringBuffer sql =new StringBuffer();
		sql.append("select * "); 
		sql.append(new ApplyReport().returnsql(starttime, endtime, options, Info, orderState));
		sql.append(" limit "+startPos+",30");
		try {
			applyReports = runerQuery.query(sql.toString(),new BeanListHandler<ApplyReport>(ApplyReport.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return applyReports;
	}
	
	@Override
	public String countApplyReportBySearch(String starttime, String endtime, String options, String Info,int orderState) {
		String number = null;
		Map a;
		StringBuffer sql =new StringBuffer();
		sql.append("select count(*) "); 
		sql.append(new ApplyReport().returnsql(starttime, endtime, options, Info, orderState));
		try {
			a =  runerQuery.query(sql.toString(),new MapHandler());
			number = a.get("count(*)").toString();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return number;
	}

	@Override
	public List<ApplyReport> exportApplyReport(String starttime, String endtime, String options, String Info,
			int orderState) {
		List<ApplyReport> applyReports = null;
		StringBuffer sql =new StringBuffer();
		sql.append("select * "); 
		sql.append(new ApplyReport().returnsql(starttime, endtime, options, Info, orderState));
		try {
			applyReports = runerQuery.query(sql.toString(),new BeanListHandler<ApplyReport>(ApplyReport.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return applyReports;
	}

	@Override
	public Competition getticketAddress(String competitionName) {
		Competition competitions = null;
		String sql = "select * from competition where competitionName=?";
		Object[] param = {competitionName};
		try {
			competitions = runerQuery.query(sql, param,new BeanHandler<>(Competition.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return competitions;
	}

	@Override
	public List<CompetitionGrade> getAllgradeList(int page) {
		  //获取30条数据
				int startPos = (page - 1) * 30;
				List<CompetitionGrade> competitionGrades = null;
				String sql = "select * from competitionGrade limit ?,?"; 
				Object[] param = {startPos,30};
				
				try {
					competitionGrades = runerQuery.query(sql, param, new BeanListHandler<CompetitionGrade>(CompetitionGrade.class));
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return competitionGrades;
	}

	@Override
	public String countgradeNum() {
		String number = null;
		Map a;
		String sql = "select count(*) from competitionGrade";
		try {
			a =  runerQuery.query(sql, new MapHandler());
			number = a.get("count(*)").toString();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return number;
	}

	@Override
	public String getSearchGradeNum(String Info) {
		String number = null;
		Map a;
		StringBuffer sql =new StringBuffer();
		sql.append("select count(*) from competitionGrade "); 
		if(!Info.equals("")) {
			sql.append(" where competitionName like '%"+Info+"%' ");
		}
		try {
			a =  runerQuery.query(sql.toString(),new MapHandler());
			number = a.get("count(*)").toString();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return number;
	}

	@Override
	public List<CompetitionGrade> getGradeList(String Info, int page) {
		int startPos = (page - 1) * 30;
		List<CompetitionGrade> competitionGrades = null;
		StringBuffer sql =new StringBuffer();
		sql.append("select * from competitionGrade "); 
		if(!Info.equals("")) {
			sql.append(" where competitionName like '%"+Info+"%' ");
		}
		sql.append(" limit "+startPos+",30");
		try {
			competitionGrades = runerQuery.query(sql.toString(),new BeanListHandler<CompetitionGrade>(CompetitionGrade.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return competitionGrades;
	}

	@Override
	public List<CompetitionGrade> exportGrade(String Info) {
		List<CompetitionGrade> competitionGrades = null;
		StringBuffer sql =new StringBuffer();
		sql.append("select * from competitionGrade "); 
		if(!Info.equals("")) {
			sql.append(" where competitionName like '%"+Info+"%' ");
		}
		try {
			competitionGrades = runerQuery.query(sql.toString(),new BeanListHandler<CompetitionGrade>(CompetitionGrade.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return competitionGrades;
	}

	@Override
	public boolean importGrade(List<CompetitionGrade> competitiongrades) {
		boolean result=false;
		for(int i=0;i<competitiongrades.size();i++) {
			String sql="INSERT INTO competitiongrade (competitionName, admissionTicket, competitionSubject, userName, userGrade, password, competitionGrade, promotion, award, note) VALUES (?,?,?,?,?,?,?,?,?,?)";
			Object[] param = {
					competitiongrades.get(i).getCompetitionName(),competitiongrades.get(i).getAdmissionTicket(),
					competitiongrades.get(i).getCompetitionSubject(),competitiongrades.get(i).getUserName(),
					competitiongrades.get(i).getUserGrade(),competitiongrades.get(i).getPassword(),
					competitiongrades.get(i).getCompetitionGrade(),competitiongrades.get(i).getPromotion(),
					competitiongrades.get(i).getAward(),competitiongrades.get(i).getNote()
			};
			try {
				int res = runerUpdate.update(TransactionUtil.getConnection(), sql, param);
				result=true;
			} catch(SQLException e) {
				result = false;
				e.printStackTrace();
			}
		}
		return result;
	}
	
	
	@Override
	public boolean querygrade(String admissionTicket, String pw) {
		boolean result = false;
		String sql = "select * from competitionGrade where admissionTicket= ? ";
		Object[ ] param = {
				admissionTicket
		};
		try {	
			CompetitionGrade competitionGrade = runerQuery.query(sql, param, new BeanHandler<>(CompetitionGrade.class));
			if(competitionGrade!=null) {
				String password = competitionGrade.getPassword();
	            if(pw.equals(password)) {
	            	result = true;
	            }
	            else {
	            	result =false;
	            }
			}
			else {
				result=false;
			}
			
		} catch (SQLException e) {
			result = false;
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public CompetitionGrade getGrade(String admissionTicket) {
		
		CompetitionGrade competitiongrade = null;
		String sql = "select * from competitionGrade where admissionTicket= ? ";
		Object[ ] param = {
				admissionTicket
		};
		try {
			competitiongrade = runerQuery.query(sql, param, new BeanHandler<>(CompetitionGrade.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return competitiongrade;
	}

	@Override
	public String getAllNewsNum() {
		String number = null;
		Map a;
		String sql = "select count(*) from news";
		try {
			a =  runerQuery.query(sql, new MapHandler());
			number = a.get("count(*)").toString();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return number;
	}

	@Override
	public List<News> getAllNews(int page) {
		//获取30条数据
				int startPos = (page - 1) * 30;
				List<News> news = null;
				String sql = "select * from news order by newId desc limit ?,?"; 
				Object[] param = {startPos,30};
				
				try {
					news = runerQuery.query(sql, param, new BeanListHandler<News>(News.class));
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return news;
	}
	
	@Override
	public News Newsdetails(int newId) {
		News news =null;
		String sql = "select * from news where newId= ?";
		Object[] param = {newId};
		try {
			news = runerQuery.query(sql, param, new BeanHandler<>(News.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return news;
		}

	@Override
	public boolean changeNewsdetails(int newsId,String info,String url,int state) {
		boolean result = false;
		String  sql = "update news set info=?,url=?,state=? where newId=?";
		Object[] param = {info,url,state,newsId};
		try {
			int res = runerUpdate.update(TransactionUtil.getConnection(), sql, param);
			result = true;
		} catch(SQLException e) {
			result = false;
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public boolean addNews(String info, String url, int state) {
		boolean result = false;
		String sql = "insert into news (info,url,state) values (?,?,?)";
		Object[] param = {
				info,url,state
		};
		try {
			int res = runerUpdate.update(TransactionUtil.getConnection(), sql, param);
			result = true;
		} catch(SQLException e) {
			result = false;
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<News> getEnableNewsInfo() {
		List<News> news = null;
		String sql = "select * from news where state=? order by newId desc "; 
		Object[] param = {1};
		
		try {
			news = runerQuery.query(sql, param, new BeanListHandler<News>(News.class));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return news;
	}

	@Override
	public boolean importstudents(List<ApplyReport> applyReports) {
		boolean result=false;
		for(int i=0;i<applyReports.size();i++){
			String sql="INSERT INTO `bsjw`.`applyreport` (`applyReportId`, `applyReportState`, `name`, `idCard`, `school`, `grade`, `competitionName`, `competitionSubject`, `competitionGrade`, `contectName`, `contectPhone`, `out_trade_no`, `phoneNumber`, `money`, `applyReportTime`, `state`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
			Object[] param = {
					applyReports.get(i).getApplyReportId(),1,applyReports.get(i).getName(),
					applyReports.get(i).getIdCard(),applyReports.get(i).getSchool(),
					applyReports.get(i).getGrade(),applyReports.get(i).getCompetitionName(),
					applyReports.get(i).getCompetitionSubject(),applyReports.get(i).getCompetitionGrade(),
					applyReports.get(i).getContectName(),applyReports.get(i).getContectPhone(),
					"OfflineRegistration",applyReports.get(i).getPhoneNumber(),applyReports.get(i).getMoney(),
					applyReports.get(i).getApplyReportTime(),1
			};
			try {
				int res = runerUpdate.update(TransactionUtil.getConnection(), sql, param);
				if(res>0) {
					result=true;
				}
				else {
					result=false;
				}
			} catch(SQLException e) {
				result = false;
				e.printStackTrace();
			}
		}
		return result;
	}

	@Override
	public ApplyReport getApplyReportDetailbackground(String idcard, String competitionName, String competitionSubject,
			int competitionGrade) {
		ApplyReport applyReport = null;
		String sql = "select * from applyreport where idcard=? and competitionName=? and competitionSubject=? and competitionGrade=? and state=?";
		Object[] param= {idcard,competitionName,competitionSubject,competitionGrade,1};
		try {
		applyReport = runerQuery.query(sql, param , new BeanHandler<ApplyReport>(ApplyReport.class));
		} catch(SQLException e){
			e.printStackTrace();
		}
		return applyReport;
	}

	@Override
	public List<Competition> getMainCompetition() {
		List<Competition> competitions = null;
		String sql = "select * from competition where state=? order by competitionId desc limit 4"; 
		Object[] param = {1};
		
		try {
			competitions = runerQuery.query(sql, param, new BeanListHandler<Competition>(Competition.class));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return competitions;
	}

	@Override
	public Competition Web_getCompetitionDetails(int competitionId) {
		Competition competition = new Competition();
		String sql = "select * from competition where competitionId=?";
		Object[] param = {competitionId};
		try {
			competition = runerQuery.query(sql, param, new BeanHandler<>(Competition.class));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return competition;
	}

	@Override
	public List<Competition> getCompetitionList() {
				List<Competition> competitions = null;
				String sql = "select * from competition order by competitionId "; 
				
				try {
					competitions = runerQuery.query(sql, new BeanListHandler<Competition>(Competition.class));
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return competitions;
	}

	@Override
	public int judgeApplyState(String out_trade_no) {
		
		ApplyReport applyReport = new ApplyReport();
		String sql = "select applyReportState from applyreport where out_trade_no =?";
		Object[] param = {out_trade_no};
		try {
			applyReport =  runerQuery.query(sql, new BeanHandler<>(ApplyReport.class), param);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			int state = applyReport.getApplyReportState();
			return state;
		} catch (Exception e) {
			return -1;
		}
	}

	@Override
	public Competition getCompetitionbyInfo(String competitionName, String competitionSubject, int money) {
		Competition competition = new Competition();
		String sql = "select * from competition where competitionName=? and competitionSubject=? and competitionMoney=?";
		Object[] param = {competitionName,competitionSubject,money}; 
		try {
			competition = runerQuery.query(sql, new BeanHandler<>(Competition.class), param);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return competition;
	}

	@Override
	public List<Competition> getCompetitionListByForm(int course, int rtime) {
		List<Competition> competitions = null;
		StringBuffer sql =new StringBuffer();
		sql.append("select * from competition "); 
		sql.append(new Competition().returnsql(course, rtime));
		sql.append(" order by competitionId");
		//System.out.println("===="+sql.toString());
		try {
			competitions = runerQuery.query(sql.toString(),new BeanListHandler<Competition>(Competition.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return competitions;
	}
	
	@Override
	public int getattentionId(String phonenumber, String competitionId) {
		Attention attention = null;
		int attentionId = 0;
		String sql = "select attentionId from attention where attentionUser=? and attentionContentId=? and attentionType=1";
		Object[] param = {phonenumber,competitionId};
		try {
			attention = runerQuery.query(sql, param,new BeanHandler<>(Attention.class));
			//System.out.println("attention--"+attention);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(attention==null) {
			attentionId = 0;
		}
		else {
			attentionId = attention.getAttentionId();
		}
		return attentionId;
	}
	
	@Override
	public boolean AddCompetitionAttention(String phonenumber, String competitionId) {
		boolean result = false;
		
		String sql = "INSERT INTO `bsjw`.`attention` (`attentionUser`, `attentionType`, `attentionContentId`, `attentionState`) VALUES (?,?,?,?)";
		Object[] param = {phonenumber,1,competitionId,1};
		try {
			int res = runerUpdate.update(TransactionUtil.getConnection(), sql, param);
			
			if(res>0) {
				result=true;
			}
			else {
				result=false;
			}
		} catch(SQLException e) {
			result = false;
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public boolean DelCompetitionAttention(String phonenumber, String competitionId) {
		boolean result = false;
		String  sql = "UPDATE `bsjw`.`attention` SET attentionState=0 WHERE attentionUser=? and attentionContentId=? and attentionType=1";
		Object[] param = {phonenumber,competitionId};
		try {
			int res = runerUpdate.update(TransactionUtil.getConnection(), sql, param);
			if(res>0) {
				result=true;
			}
			else {
				result=false;
			}
		} catch(SQLException e) {
			result = false;
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int judgeAttentionState(String phonenumber, String competitionId) {
		Attention attention = null;
		int attentionState = 0;
		String sql = "select attentionState from attention where attentionUser=? and attentionContentId=? and attentionType=1";
		Object[] param = {phonenumber,competitionId};
		try {
			attention = runerQuery.query(sql, param,new BeanHandler<>(Attention.class));
			if(attention==null) {
				attentionState = 0;
			}
			else {
				attentionState = attention.getAttentionState();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return attentionState;
	}

	@Override
	public boolean updataAttentionState(String phonenumber, String competitionId) {
		boolean result = false;
		String  sql = "UPDATE `bsjw`.`attention` SET attentionState=1 WHERE attentionUser=? and attentionContentId=? and attentionType=1";
		Object[] param = {phonenumber,competitionId};
		try {
			int res = runerUpdate.update(TransactionUtil.getConnection(), sql, param);
			if(res>0) {
				result=true;
			}
			else {
				result=false;
			}
		} catch(SQLException e) {
			result = false;
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<Competition> getCompetitionSearchInfo(String searchInfo) {
		List<Competition> competitions = null;
		String sql = "select * from competition where competitionName like '%"+searchInfo+"%' or competitionSubject like '%"+searchInfo+"%' or competitionJoinerDes like '%"+searchInfo+"%' or competitionPrizeDes like '%"+searchInfo+"%' or competitionDetail like '%"+searchInfo+"%' or competitionSupportDesc like '%"+searchInfo+"%' order by competitionId desc";
		try {
			competitions = runerQuery.query(sql,new BeanListHandler<Competition>(Competition.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return competitions;
	}

	@Override
	public Competition getCompetitionSlides() {
		Competition competition = null;
		String sql = "select  * from competition where  state=?   order by competitionId desc  limit 1"; 
		Object[] param = {1};
		
		try {
			competition = runerQuery.query(sql, new BeanHandler<>(Competition.class), param);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return competition;
	}

	
	
	
	
	
	
	

	

	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
