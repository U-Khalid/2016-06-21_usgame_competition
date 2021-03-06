package cn.usgame.dao.dbutils_impl;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;

import cn.usgame.dao.CampDao;
import cn.usgame.entity.ApplyReport;
import cn.usgame.entity.Attention;
import cn.usgame.entity.Camp;
import cn.usgame.entity.CampApply;
import cn.usgame.entity.Competition;
import cn.usgame.entity_dto.campApplyForm;
import cn.usgame.utils.JdbcUtils_DBCP;
import cn.usgame.utils.TransactionUtil;

public class CampDaoImply implements CampDao{
	private static QueryRunner runerUpdate = new QueryRunner();
	private static QueryRunner runerQuery = new QueryRunner(JdbcUtils_DBCP.getDataSource());
	
	
	/**
	 * 
	 * 函数名称：getCampList 功能描述：获取营地列表 参数说明： 返回值：void 备注：
	 * 
	 * 
	 * @throws SQLException
	 * @throws IOException
	*/
	
	@Override
	public List<Camp> getCampList() {
		List<Camp> camps = new ArrayList<Camp>();
		String sql="select * from camp order by campId";
		try {
			camps = runerQuery.query(sql, new BeanListHandler<Camp>(Camp.class));
		} catch (SQLException e) {
            e.printStackTrace();
		}
		
		return camps;
	}

	/**
	 * 
	 * 函数名称：getMainCamp 功能描述：得到首页的营地   参数说明： 返回值：void 备注：
	 * 
	 * 
	 */
	@Override
	public List<Camp> getMainCamp() {
		// TODO Auto-generated method stub
		List<Camp> camps = null;
		String sql = "select * from camp where state=? order by campId desc limit 4"; 
		Object[] param = {1};
		
		try {
			camps = runerQuery.query(sql, param, new BeanListHandler<Camp>(Camp.class));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return camps;
	}

	/**
	 * 
	 * 函数名称：Web_getCampDetails 功能描述：获取营地详情 参数说明： 返回值：void 备注：
	 * 
	 */
	
	@Override
	public Camp Web_getCampDetails(int campId) {
		Camp camp = new Camp();
		String sql = "select * from camp where campId=?";
		Object[] param = {campId};
		try {
			camp = runerQuery.query(sql, param, new BeanHandler<>(Camp.class));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return camp;
	}

	@Override
	public int getattentionId(String phonenumber, String campId) {
		Attention attention = null;
		int attentionId = 0;
		String sql = "select attentionId from attention where attentionUser=? and attentionContentId=? and attentionType=2";
		Object[] param = {phonenumber,campId};
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
	public boolean AddCampAttention(String phonenumber, String campId) {
		boolean result = false;
		
		String sql = "INSERT INTO `bsjw`.`attention` (`attentionUser`, `attentionType`, `attentionContentId`, `attentionState`) VALUES (?,?,?,?)";
		Object[] param = {phonenumber,2,campId,1};
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
	public boolean updataAttentionState(String phonenumber, String campId) {
		boolean result = false;
		String  sql = "UPDATE `bsjw`.`attention` SET attentionState=1 WHERE attentionUser=? and attentionContentId=? and attentionType=2";
		Object[] param = {phonenumber,campId};
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
	public int judgeAttentionState(String phonenumber, String campId) {
		Attention attention = null;
		int attentionState = 0;
		String sql = "select attentionState from attention where attentionUser=? and attentionContentId=? and attentionType=2";
		Object[] param = {phonenumber,campId};
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
	public boolean DelCampAttention(String phonenumber, String campId) {
		boolean result = false;
		String  sql = "UPDATE `bsjw`.`attention` SET attentionState=0 WHERE attentionUser=? and attentionContentId=? and attentionType=2";
		Object[] param = {phonenumber,campId};
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
	public List<Camp> getCampListByForm(String destination, String theme, int suitableAge, int timeLength) {
		List<Camp> camps = null;
		StringBuffer sql =new StringBuffer();
		sql.append("select * from camp "); 
		sql.append(new Camp().returnsql(destination,theme,suitableAge,timeLength));
		sql.append(" order by campId");
		//System.out.println("===="+sql.toString());
		try {
			camps = runerQuery.query(sql.toString(),new BeanListHandler<Camp>(Camp.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return camps;
	}

	@Override
	public List<Camp> getCampSearchInfo(String searchInfo) {
		List<Camp> camps = null;
		String sql = "select * from camp where camp_Name like '%"+searchInfo+"%' or camp_Address like '%"+searchInfo+"%' or camp_Info like '%"+searchInfo+"%' or camp_Features like '%"+searchInfo+"%' or camp_Schedule like '%"+searchInfo+"%' or money_Info like '%"+searchInfo+"%' or apply_Info like '%"+searchInfo+"%' or attention_Info like '%"+searchInfo+"%' or camp_theme like '%"+searchInfo+"%' order by campId desc";
		try {
			camps = runerQuery.query(sql,new BeanListHandler<Camp>(Camp.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return camps;
	}

	
	/**
	 * 
	 * 函数名称：getApplyReport
	 * 功能描述：根据身份证，年级，大赛名取出id
	 * 参数说明：
	 * 返回值：boolean
	 * 备注：
	 * 
	 */
	@Override
	public int getCampApply(CampApply c) {
		CampApply campapply = new CampApply();
		String sql = "select applyReportId,applyReportState from campapply where idCard=? and camp_Name=? and camp_Address=? and camp_Age=? and state=?";
		int applyReportId = 0;
		Object[] param = {
				c.getIdCard(),c.getCamp_Name(),c.getCamp_Address(),c.getCamp_Age(),1
		};
		try {
			campapply =  runerQuery.query(sql, param, new BeanHandler<>(CampApply.class));
		} catch(SQLException e) {
			e.printStackTrace();
		}
		try {
			applyReportId = campapply.getApplyReportId();
			if(campapply.getApplyReportState()==1) {
				applyReportId = 1;
			}
			return applyReportId;
		} catch (Exception e) {
			return 0;
		}
	}

	@Override
	public boolean applyReport(CampApply campapply) {
		boolean result = true;
		String sql = "insert into campapply (`applyReportId`,`name`,`idCard`,`school`,`address`,`camp_Name`,`camp_Address`,`camp_Age`,`contectName`,`contectPhone`,`phoneNumber`, out_trade_no,money,applyReportTime,state) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		SimpleDateFormat s = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
		Object[] param = {
				campapply.getApplyReportId(),campapply.getName(),campapply.getIdCard(),campapply.getSchool(),
				campapply.getAddress(),campapply.getCamp_Name(),campapply.getCamp_Address(),campapply.getCamp_Age(),
				campapply.getContectName(),campapply.getContectPhone(),campapply.getPhoneNumber(),campapply.getOut_trade_no(),campapply.getMoney(),s.format(campapply.getApplyReportTime()),1
		};
		try {
			int res = runerUpdate.update(TransactionUtil.getConnection(), sql, param);
		} catch(SQLException e) {
			result=false;
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 
	 * 函数名称：updatecampApply
	 * 功能描述：修改报名表
	 * 参数说明：
	 * 返回值：boolean
	 * 备注：
	 * 
	 */
	@Override
	public boolean updatecampApply(CampApply campapply) {
		boolean result = true;
		String sql = "update applyreport set name=?,idCard=?,school=?,grade=?,competitionName=?,competitionSubject=?,competitionGrade=?,contectName=?,contectPhone=? where applyReportId=?";
		Object[] param = {
				campapply.getName(),campapply.getIdCard(),campapply.getSchool(),campapply.getAddress(),campapply.getCamp_Name(),campapply.getCamp_Address(),
				campapply.getCamp_Age(),campapply.getContectName(),campapply.getContectPhone(),campapply.getApplyReportId()
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

	
	
	/**
	 * 
	 * 函数名称：judgeApplyState
	 * 功能描述：订单比赛列表
	 * 参数说明：out_trade_no
	 * 返回值：int
	 * 备注：
	 * 
	 */
	@Override
	public int judgeApplyState(String out_trade_no) {
		CampApply campapply = new CampApply();
		String sql = "select applyReportState from applyreport where out_trade_no =?";
		Object[] param = {out_trade_no};
		try {
			campapply =  runerQuery.query(sql, new BeanHandler<>(CampApply.class), param);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			int state = campapply.getApplyReportState();
			return state;
		} catch (Exception e) {
			return -1;
		}
	}

	@Override
	public List<Camp> getCampList(int page) {
				//获取30条数据
				int startPos = (page - 1) * 30;
				List<Camp> camps = null;
				String sql = "select * from camp order by campId DESC limit ?,?"; 
				Object[] param = {startPos,30};
				
				try {
					camps = runerQuery.query(sql, param, new BeanListHandler<Camp>(Camp.class));
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return camps;
	}

	@Override
	public String countCampNum() {
		String number = null;
		Map a;
		String sql = "select count(*) from camp";
		try {
			a =  runerQuery.query(sql, new MapHandler());
			number = a.get("count(*)").toString();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return number;
	}

	@Override
	public boolean reviseCampState(int campId, int campstate) {
		boolean result = false;
		String sql = "update camp set campstate=? where campId=?";
		Object[] param = {
				campstate,campId
		};
		try {
			int res = runerUpdate.update(TransactionUtil.getConnection(), sql, param);
			if(res>0) {
				result = true;
			}
		} catch(SQLException e) {
			result = false;
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Camp getCampSlides() {
		Camp camp = null;
		String sql = "select * from camp where state =? order by campId desc limit 1";
		Object[] param={1};
		try {
			camp = runerQuery.query(sql, param, new BeanHandler<>(Camp.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return camp;
	}

	@Override
	public boolean addCamp(Camp camp) {
		boolean flag = false;
		String sql = "INSERT INTO `bsjw`.`camp` (`camp_Name`, `camp_Address`, `camp_Age`, `camp_Money`, `camp_startTime`, `camp_endTime`, `camp_goTime`, `camp_Features`, `camp_Info`, `camp_Schedule`, `money_Info`, `apply_Info`, `attention_Info`, `state`, `camp_Pic`, `camp_BigPic`, `campstate`, `camp_theme`, `camp_TimeLength`) VALUES (?,?,?,?,?,?,?,?,?, ?, ?, ?,?, ?, ?, ?, ?, ?, ?);";
		Object[ ] param = {
				camp.getCamp_Name(),camp.getCamp_Address(),camp.getCamp_Age(),
				camp.getCamp_Money(),camp.getCamp_startTime(),camp.getCamp_endTime(),
				camp.getCamp_goTime(),camp.getCamp_Features(),camp.getCamp_Info(),
				camp.getCamp_Schedule(),camp.getMoney_Info(),camp.getApply_Info(),
				camp.getAttention_Info(),camp.getState(),camp.getCamp_Pic(),
				camp.getCamp_BigPic(),1,camp.getCamp_theme(),camp.getCamp_TimeLength()
		};
		
		try {
			int res = runerUpdate.update(TransactionUtil.getConnection(), sql, param);
			flag = true;
		} catch (SQLException e) {
			flag = false;
			e.printStackTrace();
		}
		return flag;
		
	}

	@Override
	public boolean updateCamp(Camp camp) {
		boolean flag = false;
		String sql = "UPDATE `bsjw`.`camp` SET  `camp_Name`=?, `camp_Address`=?, `camp_Age`=?, `camp_Money`=?, `camp_startTime`=?, `camp_endTime`=?, `camp_goTime`=?, `camp_Features`=?, `camp_Info`=?, `camp_Schedule`=?, `money_Info`=?, `apply_Info`=?, `attention_Info`=?, `state`=?, `camp_Pic`=?, `camp_BigPic`=?, `campstate`=?, `camp_theme`=?, `camp_TimeLength`=? WHERE (`campId`=?);";
		Object[ ] param = {
				camp.getCamp_Name(),camp.getCamp_Address(),camp.getCamp_Age(),
				camp.getCamp_Money(),camp.getCamp_startTime(),camp.getCamp_endTime(),
				camp.getCamp_goTime(),camp.getCamp_Features(),camp.getCamp_Info(),
				camp.getCamp_Schedule(),camp.getMoney_Info(),camp.getApply_Info(),
				camp.getAttention_Info(),camp.getState(),camp.getCamp_Pic(),
				camp.getCamp_BigPic(),1,camp.getCamp_theme(),camp.getCamp_TimeLength(),
				camp.getCampId()
		};
		
		try {
			int res = runerUpdate.update(TransactionUtil.getConnection(), sql, param);
			flag = true;
		} catch (SQLException e) {
			flag = false;
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public Camp getCampbyInfo(String camp_Name, String camp_Address, int money) {
		Camp camp = new Camp();
		String sql = "select * from camp where camp_Name=? and camp_Address=? and camp_Money=?";
		Object[] param = {camp_Name,camp_Address,money}; 
		try {
			camp = runerQuery.query(sql, new BeanHandler<>(Camp.class), param);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return camp;
	}

	@Override
	public List<CampApply> getAllReport(int page) {
		//获取30条数据
		int startPos = (page - 1) *30;
		List<CampApply> campapply = null;
		String sql = "select * from campapply limit ?,?";
		Object[] param = {startPos,30};
		try {
			campapply = runerQuery.query(sql, param, new BeanListHandler<CampApply>(CampApply.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return campapply;
	}

	@Override
	public String countCampApplyNum() {
		String number = null;
		Map a;
		String sql = "select count(*) from campapply";
		try {
			a = runerQuery.query(sql, new MapHandler());
			number = a.get("count(*)").toString();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return number;
	}

	@Override
	public CampApply getCampApplyDetailbackground(String idcard, String camp_Name, String camp_Address, int camp_Age) {
		CampApply campapply = null;
		String sql = "select * from campapply where idcard=? and camp_Name=? and camp_Address=? and camp_Age=?";
		Object[] param = {idcard,camp_Name,camp_Address,camp_Age};
		try {
			campapply = runerQuery.query(sql, param, new BeanHandler<CampApply>(CampApply.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return campapply;
	}

	@Override
	public List<CampApply> getCampApply(String starttime, String endtime, String options, String info, int orderState,
			int page) {
		int startPos = (page - 1) * 30;
		List<CampApply> campapply = null;
		StringBuffer sql = new StringBuffer();
		sql.append("select * ");
		sql.append(new CampApply().returnsql(starttime,endtime,options,info,orderState));
		sql.append(" limit " + startPos + ",30");
		try {
			campapply = runerQuery.query(sql.toString(), new BeanListHandler<CampApply>(CampApply.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return campapply;
	}

	@Override
	public String countCampApplyBySearch(String starttime, String endtime, String options, String info,
			int orderState) {
		String number = null;
		Map a;
		StringBuffer sql =new StringBuffer();
		sql.append("select count(*) "); 
		sql.append(new CampApply().returnsql(starttime, endtime, options, info, orderState));
		try {
			a =  runerQuery.query(sql.toString(),new MapHandler());
			number = a.get("count(*)").toString();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return number;
	}

	@Override
	public List<CampApply> exportCampApply(String starttime, String endtime, String options, String info,
			int orderState) {
		List<CampApply> campapply = null;
		StringBuffer sql =new StringBuffer();
		sql.append("select * "); 
		sql.append(new CampApply().returnsql(starttime, endtime, options, info, orderState));
		try {
			campapply = runerQuery.query(sql.toString(),new BeanListHandler<CampApply>(CampApply.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return campapply;
	}

	
	
}



