package cn.usgame.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import cn.usgame.dao.DaoFactory;
import cn.usgame.dao.UserDao;
import cn.usgame.entity.Administrator;
import cn.usgame.entity.ApplyReport;
import cn.usgame.entity.Camp;
import cn.usgame.entity.CampApply;
import cn.usgame.entity.Competition;
import cn.usgame.entity.SMS;
import cn.usgame.entity.Train;
import cn.usgame.entity.TrainApply;
import cn.usgame.entity.Train_Subject;
import cn.usgame.entity.User;
import cn.usgame.service.UserService;
import cn.usgame.utils.TransactionUtil;

public class UserServiceImpl implements UserService {

	static SMS sms = new SMS();
	static Queue<SMS> smsQueue = new LinkedList<SMS>(); //定义消息队列
	private static UserServiceImpl instance = new UserServiceImpl();

	private UserServiceImpl() {
	}

	public static UserServiceImpl getInstance() {
		return instance;
	}

	UserDao udao = DaoFactory.getInstance().create("cn.usgame.dao.dbutils_impl.UserDaoImply", UserDao.class);

	@Override
	public boolean registerUser(String id, String phone, String password) {
		TransactionUtil.getConnection();
		boolean result = false;
		try {
			TransactionUtil.startTransaction();
			// ...
			result = udao.registerUser(id, phone, password);
			// ...

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
	public User login(String phone, String password) {
		boolean result = udao.login(phone, password);
		if (result) {
			return udao.getUser(phone);
		} else {
			return null;
		}
	}

	@Override
	public boolean checkVerificationCode() {
		return false;
	}

	@Override
	public boolean toUser(User user) {
		TransactionUtil.getConnection();
		boolean result = false;
		try {
			TransactionUtil.startTransaction();
			// ...
			return udao.toUser(user);
			// ...

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
	public boolean changepw(String new_pw, String phonenumber) {
		return udao.changepw(new_pw, phonenumber);
	}

	@Override
	public boolean testPhone(String phonenumber) {
		boolean result = false;
		User user = udao.getUser(phonenumber);
		try {
			if (!(user.getPhonenumber().equals(""))) {
				result = true;
			}
		} catch (Exception e) {
			result = false;
		}
		return result;
	}

	@Override
	public boolean pushSMS(SMS sms) {
		boolean result = false;
		System.out.println("pushSMS:" + sms.getNowTime());
		result = this.smsQueue.offer(sms);
		return result;
	}

	@Override
	public boolean popSMS() {
		boolean result = false;
		if (this.smsQueue.poll() != null) {
			result = true;
		}
		return result;
	}

	@Override
	public int IsQualifiedSMS(String Phone, String SMSNumber) {
		SMS sms = null;
		int flag = 0;
		// 遍历队列，将验证成功，验证超时的无效的推出队列
		while (this.smsQueue.peek() != null) {  //peek（返回队列头部的元素  ， 如果队列为空，则返回null）
			sms = this.smsQueue.peek();
			if (sms.getPhoneNumber().equals(Phone)) {
				if (IsTimeOver(sms)) {
					if (sms.getSNSNumber().equals(SMSNumber)) {
						flag = 1;// 1为验证成功
						this.smsQueue.poll(); //poll （移除并返问队列头部的元素    如果队列为空，则返回null）
					} else {
						flag = 2;// 验证码错误
					}
				} else {
					flag = 3;// 验证超时
					this.smsQueue.poll();
				}
			}
		}
		return flag;
	}

	@Override
	public boolean IsTimeOver(SMS sms2) {
		boolean flag = false;
		String startTime = sms2.getNowTime();
		int cicle = sms2.getLifeCycle();
		SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String nowTime = s.format(new Date());
		int result = 0;
		try {
			result = (int) ((s.parse(nowTime).getTime() - s.parse(startTime).getTime()) / 1000);
		} catch (ParseException e) {
			flag = false;
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (result < cicle) {
			flag = true;
		}
		return flag;
	}

	@Override
	public List<ApplyReport> getUserCompetition(String Phonenumber) {
		List<ApplyReport> applyReports = new ArrayList<>();
		applyReports = udao.getUserCompetition(Phonenumber);
		return applyReports;
	}
	
	
	@Override
	public List<CampApply> getUserCamp(String Phonenumber) {
		List<CampApply> campapply = new ArrayList<>();
		campapply = udao.getUserCamp(Phonenumber);
		return campapply;
	}
	
	@Override
	public List<TrainApply> getUserTrain(String Phonenumber) {
		List<TrainApply> trainapply = new ArrayList<>();
		trainapply = udao.getUserTrain(Phonenumber);
		return trainapply;
	}


	@Override
	public ApplyReport applyreportInfo(String Phonenumber, String applyReportId) {
		return udao.applyreportInfo(Phonenumber,applyReportId);
	}

	@Override
	public List<Administrator> getAllAdministrator(int page) {
		List<Administrator> administrators = new ArrayList<>();
		administrators = udao.getAllAdministrator(page);
		return administrators;
	}

	@Override
	public String getAdministratorNum() {
		String num = udao.getAdministratorNum();
		return num;
	}

	@Override
	public Administrator Administratorlogin(String username, String password) {
		boolean result = udao.Administratorlogin(username, password);
		if (result) {
			return udao.getAdministrator(username);
		} else {
			return null;
		}
	}

	@Override
	public boolean Setpw(String phonenumber, String password) {
		boolean result = udao.Setpw(phonenumber,password);
		return result;
	}

	@Override
	public boolean deleteapplyreport(String phonenumber, String applyReportId) {
        boolean result = udao.deleteapplyreport(phonenumber,applyReportId);
        return result;
	}
	
	@Override
	public boolean deletecampapply(String phonenumber, String applyReportId) {
		boolean result = udao.deletecampapply(phonenumber,applyReportId);
        return result;
	}
	
	@Override
	public boolean deletetrainapply(String phonenumber, String applyReportId) {
		boolean result = udao.deletetrainapply(phonenumber,applyReportId);
        return result;
	}

	@Override
	public List<Competition> getAttentionCompetitionList(String phonenumber, int type) {
		int[] competitionId;
		competitionId = udao.getAttentionContentIdList(phonenumber , type);
		if(competitionId[0]==0) {
			return null;
		}
		else {
			List<Competition> competitions = udao.getAttentionCompetitionList(competitionId);
			return competitions;
		}
	}

	@Override
	public List<Camp> getAttentionCampList(String phonenumber, int type) {
		int[] campId;
		campId = udao.getAttentionContentIdList(phonenumber , type);
		if(campId[0]==0) {
			return null;
		}
		else {
			List<Camp> camps = udao.getAttentionCampList(campId);
			return camps;
		}
	}

	@Override
	public List<Train_Subject> getAttentionTrainList(String phonenumber, int type) {
		int[] tSubject_ID;
		tSubject_ID = udao.getAttentionContentIdList(phonenumber , type);
		if(tSubject_ID[0]==0) {
			return null;
		}
		else {
			List<Train_Subject> trains = udao.getAttentionTrainList(tSubject_ID);
			return trains;
		}
	}

	

	

	
	
	
}
