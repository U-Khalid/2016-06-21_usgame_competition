package cn.usgame.dao.dbutils_impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;

import cn.usgame.dao.UserDao;
import cn.usgame.entity.Administrator;
import cn.usgame.entity.ApplyReport;
import cn.usgame.entity.Attention;
import cn.usgame.entity.Camp;
import cn.usgame.entity.CampApply;
import cn.usgame.entity.Competition;
import cn.usgame.entity.Train;
import cn.usgame.entity.TrainApply;
import cn.usgame.entity.Train_Subject;
import cn.usgame.entity.User;
import cn.usgame.utils.JdbcUtils_DBCP;
import cn.usgame.utils.TransactionUtil;

public class UserDaoImply implements UserDao{
	
	private static QueryRunner runerUpdate = new QueryRunner();
	private static QueryRunner runerQuery = new QueryRunner(JdbcUtils_DBCP.getDataSource());
	
	
	@Override
	public boolean registerUser(String id,String phone, String password) {
		boolean result = false;
		String sql = "INSERT INTO `bsjw`.`user` ( `userId`,`phonenumber`, `password`) VALUES (? , ? , ?)";
		
		Object[ ] param = {
				id,phone,password
			};
		try {
			int res = runerUpdate.update(TransactionUtil.getConnection(), sql, param);
			result = true;
			
		} catch (SQLException e) {
			result = false;
			e.printStackTrace();
		}
		return result;
	}
	@Override
	public boolean login(String phone, String password) {
		boolean result = false;
		String sql = "select * from User where phonenumber= ? ";
		Object[ ] param = {
				phone
		};
		try {	
			User user = runerQuery.query(sql, param, new BeanHandler<>(User.class));
			if(user!=null) {
				String pw = user.getPassword();
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
	public User getUser(String phone) {
		User user = null;
		
		String sql = "select * from User where phonenumber= ? ";
		Object[ ] param = {
				phone
		};
		try {
			user = runerQuery.query(sql, param, new BeanHandler<>(User.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	@Override
	public boolean toUser(User user) {
		boolean result = false;
		String sql = "update User set name = ?,sex=?,school=?,grade=?,contactNumber=?,iDcard=?,address=?,motto=? where phonenumber=?";
		Object[ ] param = {
				user.getName(),user.getSex(),user.getSchool(),user.getGrade(),user.getContactNumber(),user.getiDcard(),user.getAddress(),user.getMotto(),user.getPhonenumber()
		};
		try {
			int res = runerUpdate.update(TransactionUtil.getConnection(), sql, param);
			if(res>=1) {
				result = true;
			}
			
		} catch (SQLException e) {
			result = false;
			e.printStackTrace();
		}
		return result;
	}
	@Override
	public boolean changepw(String new_pw, String phonenumber) {
		boolean result = false;
		String sql = "update User set password = ? where phonenumber=?";
		Object[ ] param = {
				new_pw,phonenumber
		};
		try {
			int res = runerUpdate.update(TransactionUtil.getConnection(), sql, param);
			if(res>=1) {
				result = true;
			}
			
		} catch (SQLException e) {
			result = false;
			e.printStackTrace();
		}
		return result;
	}
	@Override
	public List<ApplyReport> getUserCompetition(String Phonenumber) {
		List<ApplyReport> applyreports = null;
		String sql = "select * from applyreport  where phoneNumber = ? and state=?"; 
		Object[] param = {Phonenumber,1};
		try {
			applyreports = runerQuery.query(sql, param, new BeanListHandler<ApplyReport>(ApplyReport.class));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return applyreports;
	}
	@Override
	public ApplyReport applyreportInfo(String Phonenumber, String applyReportId) {
		ApplyReport  applyreport = null;
		String sql = "select * from applyreport  where phoneNumber = ? and applyReportId= ?"; 
		Object[] param = {Phonenumber,applyReportId};
		try {
			applyreport = runerQuery.query(sql, param, new BeanHandler<>(ApplyReport.class));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return applyreport;
	}
	@Override
	public List<Administrator> getAllAdministrator(int page) {
		//获取30条数据
				int startPos = (page - 1) * 30;
				List<Administrator> administrators = null;
				String sql = "select * from administrator limit ?,?"; 
				Object[] param = {startPos,30};
				
				try {
					administrators = runerQuery.query(sql, param, new BeanListHandler<Administrator>(Administrator.class));
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return administrators;
	}
	@Override
	public String getAdministratorNum() {
		String number = null;
		Map a;
		String sql = "select count(*) from administrator";
		try {
			a =  runerQuery.query(sql, new MapHandler());
			number = a.get("count(*)").toString();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return number;
	}
	@Override
	public boolean Administratorlogin(String username, String password) {
		boolean result = false;
		String sql = "select * from administrator where state>0 and username= ? ";
		Object[ ] param = {
				username
		};
		try {	
			Administrator administrator = runerQuery.query(sql, param, new BeanHandler<>(Administrator.class));
			if(administrator != null) {
				String pw = administrator.getPassword();
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
	public Administrator getAdministrator(String username) {
		Administrator administrator = null;
		
		String sql = "select * from Administrator where  state>0 and username= ? ";
		Object[ ] param = {
				username
		};
		try {
			administrator = runerQuery.query(sql, param, new BeanHandler<>(Administrator.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return administrator;
	}
	@Override
	public boolean Setpw(String phonenumber, String password) {
		boolean result = false;
		String sql = "update User set password = ? where phonenumber=?";
		Object[ ] param = {
				password,phonenumber
		};
		try {
			int res = runerUpdate.update(TransactionUtil.getConnection(), sql, param);
			if(res>=1) {
				result = true;
			}
			
		} catch (SQLException e) {
			result = false;
			e.printStackTrace();
		}
		return result;
	}
	@Override
	public boolean deleteapplyreport(String phonenumber, String applyReportId) {
        boolean result =false;
        String sql="update applyreport set state = 0 where phoneNumber=? and applyReportId=?";
        Object[] param = {
        		phonenumber,applyReportId
        };
        try {
        	int res = runerUpdate.update(TransactionUtil.getConnection(), sql, param);
			if(res>=1) {
				result = true;
			}
		} catch (SQLException e) {
			result = false;
			e.printStackTrace();
		}
        return result;
	}
	
	@Override
	public boolean deletecampapply(String phonenumber, String applyReportId) {
		boolean result =false;
        String sql="update campapply set state = 0 where phoneNumber=? and applyReportId=?";
        Object[] param = {
        		phonenumber,applyReportId
        };
        try {
        	int res = runerUpdate.update(TransactionUtil.getConnection(), sql, param);
			if(res>=1) {
				result = true;
			}
		} catch (SQLException e) {
			result = false;
			e.printStackTrace();
		}
        return result;
	}
	
	@Override
	public boolean deletetrainapply(String phonenumber, String applyReportId) {
		boolean result =false;
        String sql="update trainapply set state = 0 where phoneNumber=? and applyReportId=?";
        Object[] param = {
        		phonenumber,applyReportId
        };
        try {
        	int res = runerUpdate.update(TransactionUtil.getConnection(), sql, param);
			if(res>=1) {
				result = true;
			}
		} catch (SQLException e) {
			result = false;
			e.printStackTrace();
		}
        return result;
	}
	
	
	
	@Override
	public int[] getAttentionContentIdList(String phonenumber, int type) {
		int[] attentionContentId =new int []{0};
		List<Attention> attentions = new ArrayList<Attention>();
		String sql = "select attentionContentId from attention where attentionUser=? and attentionType=? and attentionState=1";
		Object[] param = {
        		phonenumber,type
        };
		try {
			attentions = runerQuery.query(sql, param, new BeanListHandler<Attention>(Attention.class));
			
			if(attentions.size()>0) {
				attentionContentId = new int [attentions.size()];
				for(int i=0;i<attentions.size();i++) {
					attentionContentId[i] = attentions.get(i).getAttentionContentId();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return attentionContentId;
	}
	@Override
	public List<Competition> getAttentionCompetitionList(int[] competitionId) {
		List<Competition> competitions = new ArrayList<Competition>();
		Competition competition = null;
		String sql = "select * from competition where competitionId=?";
				for(int i =0;i<competitionId.length;i++) {
					try {
						competition = runerQuery.query(sql, competitionId[i], new BeanHandler<>(Competition.class));
						
					} catch (SQLException e) {
						e.printStackTrace();
					}
					competitions.add(competition);
				}
		return competitions;
	}
	@Override
	public List<Camp> getAttentionCampList(int[] campId) {
		List<Camp> camps = new ArrayList<Camp>();
		Camp camp = null;
		String sql = "select * from camp where campId=?";
				for(int i =0;i<campId.length;i++) {
					try {
						camp = runerQuery.query(sql, campId[i], new BeanHandler<>(Camp.class));
						
					} catch (SQLException e) {
						e.printStackTrace();
					}
					camps.add(camp);
				}
		return camps;
	}
	@Override
	public List<Train_Subject> getAttentionTrainList(int[] tSubject_ID) {
		List<Train_Subject> trains = new ArrayList<Train_Subject>();
		Train_Subject train = null;
		String sql = "select * from train_subject where tSubject_ID=?";
				for(int i =0;i<tSubject_ID.length;i++) {
					try {
						train = runerQuery.query(sql, tSubject_ID[i], new BeanHandler<>(Train_Subject.class));
						
					} catch (SQLException e) {
						e.printStackTrace();
					}
					trains.add(train);
				}
		return trains;
	}
	
	@Override
	public List<CampApply> getUserCamp(String phonenumber) {
		List<CampApply> campapply = null;
		String sql = "select * from campapply  where phoneNumber = ? and state=?"; 
		Object[] param = {phonenumber,1};
		try {
			campapply = runerQuery.query(sql, param, new BeanListHandler<CampApply>(CampApply.class));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return campapply;
	}
	@Override
	public List<TrainApply> getUserTrain(String phonenumber) {
		List<TrainApply> trainapply = null;
		String sql = "select * from trainapply  where phoneNumber = ? and state=?"; 
		Object[] param = {phonenumber,1};
		try {
			trainapply = runerQuery.query(sql, param, new BeanListHandler<TrainApply>(TrainApply.class));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return trainapply;
	}
	
	
	
	
	
	
}
