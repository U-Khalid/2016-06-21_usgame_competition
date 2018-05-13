package cn.usgame.service.impl;

import java.util.ArrayList;
import java.util.List;

import cn.usgame.dao.CampDao;
import cn.usgame.dao.DaoFactory;
import cn.usgame.entity.ApplyReport;
import cn.usgame.entity.Camp;
import cn.usgame.entity.CampApply;
import cn.usgame.entity.Competition;
import cn.usgame.entity.camp_comment;
import cn.usgame.service.CampService;
import cn.usgame.utils.TransactionUtil;

public class CampServiceImpl implements CampService {

	private static CampServiceImpl instance = new CampServiceImpl();
	 
	 private CampServiceImpl() {}
	 
	 public static CampServiceImpl getInstance() {
		 return instance;
	 }
	 
	 
	CampDao cdao = DaoFactory.getInstance().create("cn.usgame.dao.dbutils_impl.CampDaoImply", CampDao.class);

	@Override
	public List<Camp> getCampList() {
		List<Camp> camps = cdao.getCampList();
		return camps;
	}

	@Override
	public List<Camp> getMainCamp() {
		// TODO Auto-generated method stub
		List<Camp> camps = cdao.getMainCamp();
		return camps;
	}

	@Override
	public Camp Web_getCampDetails(int campId) {
		// TODO Auto-generated method stub
		Camp camp = cdao.Web_getCampDetails(campId);
		return camp;
	}

	@Override
	public boolean AddCampAttention(String phonenumber, String campId) {
		boolean result =false;
		int attentionId = 0;
		attentionId = cdao.getattentionId(phonenumber,campId);
		if(attentionId==0){
			result = cdao.AddCampAttention(phonenumber,campId);
		}
		else {
			result = cdao.updataAttentionState(phonenumber,campId);
		}
		return result;
	}

	@Override
	public int judgeAttentionState(String phonenumber, String campId) {
		int attentionState = cdao.judgeAttentionState(phonenumber,campId);
		return attentionState;
	}

	@Override
	public boolean DelCampAttention(String phonenumber, String campId) {
		boolean result = cdao.DelCampAttention(phonenumber,campId);
		return result;
	}


	

	@Override
	public List<Camp> getCampListByForm(String destination, String theme, int suitableAge, int timeLength) {
		List<Camp> camps = cdao.getCampListByForm(destination,theme,suitableAge,timeLength);
		return camps;
	}

	@Override
	public int campapply(CampApply campapply) {
		int result = -1;
		boolean temp = false;
		TransactionUtil.getConnection(); 
		int applyReportId = cdao.getCampApply(campapply);
		try {
			TransactionUtil.startTransaction(); 
			// 首次报名
			if (applyReportId == 0) {
				// 生成报名记录
				temp = cdao.applyReport(campapply);
				
				// 生成订单记录 
				boolean res = cdao.addApplyorder(campapply.getOut_trade_no());
				result = 1;
			}
			else if(applyReportId == 1) {//用户已经支付过
				result = 2;
			}
			else { // 修改资料后报名
				campapply.setApplyReportId(applyReportId); // 
				temp = cdao.updatecampApply(campapply);
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
	public List<Camp> getCampSearchInfo(String searchInfo) {
		List<Camp> camps = cdao.getCampSearchInfo(searchInfo);
		return camps;
	}

	@Override
	public int judgeApplyState(String out_trade_no) {
		int state = cdao.judgeApplyState(out_trade_no);
		return state;
	}

	@Override
	public List<Camp> getCampList(int page) {
		List<Camp> camps = cdao.getCampList(page);
		return camps;
	}

	@Override
	public String getCampNum() {
		return cdao.countCampNum();
	}

	@Override
	public boolean reviseCampState(int campId, int campstate) {
		boolean result = false;
		TransactionUtil.getConnection(); 
		try {
			TransactionUtil.startTransaction(); 
			result = cdao.reviseCampState(campId,campstate);
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
	public Camp getCampSlides() {
		Camp camp = cdao.getCampSlides();
		return camp;
	}

	@Override
	public boolean addCamp(Camp camp) {
		TransactionUtil.getConnection(); 
		boolean result = false;

		try {
			TransactionUtil.startTransaction(); 
			// ... 
			if(camp.getCampId()!=0) {
				result = cdao.updateCamp(camp);
			} else {
				result =  cdao.addCamp(camp);
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
	public Camp getCampbyInfo(String camp_Name, String camp_Address, int money) {
		Camp camp = cdao.getCampbyInfo(camp_Name,camp_Address,money);
		return camp;
	}

	@Override
	public List<CampApply> getAllApplyReport(int page) {
		List<CampApply> campapply = new ArrayList<>();
		campapply = cdao.getAllReport(page);
		return campapply;
	}

	@Override
	public String getApplyReportNum() {
		String campapplynum = cdao.countCampApplyNum();
		return campapplynum;
	}

	@Override
	public CampApply getCampApplyDetailbackground(String idcard, String camp_Name, String camp_Address, int camp_Age) {
		CampApply campapply = cdao.getCampApplyDetailbackground(idcard,camp_Name,camp_Address,camp_Age);
		return campapply;
	}

	@Override
	public List<CampApply> getApplyReport(String starttime, String endtime, String options, String info, int orderState,
			int page) {
		List<CampApply> campapply = new ArrayList<>();
		campapply = cdao.getCampApply(starttime, endtime, options, info, orderState, page);
		return campapply;
	}

	@Override
	public String getSearchNum(String starttime, String endtime, String options, String Info, int orderState) {
		String num = cdao.countCampApplyBySearch(starttime, endtime, options, Info, orderState);
		return num;
	}

	@Override
	public List<CampApply> exportCampApply(String starttime, String endtime, String options, String Info,
			int orderState) {
		List<CampApply> campapply = new ArrayList<>();
		campapply = cdao.exportCampApply(starttime, endtime, options,Info, orderState);
		return campapply;
	}

	
	
}

	
	
	



