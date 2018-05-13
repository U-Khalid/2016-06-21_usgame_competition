package cn.usgame.service.impl;

import java.util.ArrayList;
import java.util.List;

import cn.usgame.dao.DaoFactory;
import cn.usgame.dao.TrainDao;
import cn.usgame.entity.ApplyReport;
import cn.usgame.entity.Competition;
import cn.usgame.entity.TrainApply;
import cn.usgame.entity.Train_Info;
import cn.usgame.entity.Train_Subject;
import cn.usgame.entity.Train_Teacher;
import cn.usgame.service.TrainService;
import cn.usgame.utils.TransactionUtil;

public class TrainServiceImpl implements TrainService {

	private static TrainServiceImpl instance=null;
	private TrainServiceImpl() {};
	
	public static TrainServiceImpl getInstance(){
		if(instance==null){
			synchronized (TrainServiceImpl.class) {
				if(instance==null){
					instance=new TrainServiceImpl();
				}
			}
		}
		return instance;
	}
	
	TrainDao tdao=DaoFactory.getInstance().create("cn.usgame.dao.dbutils_impl.TrainDaoImply", TrainDao.class);
	@Override
	public List<Train_Subject> getTrainDetail(String course, String enroll, int page) {
		// TODO Auto-generated method stub
		List<Train_Subject> subject=tdao.getDetailedInfo(course, enroll, page);
		return subject;
	}

	@Override
	public String getTotalNum(String course, String enroll) {
		// TODO Auto-generated method stub
		String num=tdao.getTotalPage(course, enroll);
		return num;
	}
	
	@Override
	public List<Train_Subject> getTrainList(){
		List<Train_Subject> subject = tdao.getTrainList();
		return subject;
	}
	
	@Override
	public Train_Subject getTrainDetailByID(int trainSubjectID){
		
		Train_Subject tSubject = tdao.getTrainDetailByID(trainSubjectID);
		return tSubject;
	}
	
	/*@Override
	public Train_Info getMechanismDetailByID(int trainID) {
		Train_Info ttrain = tdao.getMechanismDetailByID(trainID);
		System.out.println(ttrain);
		return ttrain;
	}*/

	@Override
	public List<Train_Teacher> getTeacher(int trainSubjectID){
		
		List<Train_Teacher> teacher = tdao.getTeacher(trainSubjectID);
		return teacher;
	}
	
	@Override
	public Train_Teacher getTeacherByID(int trainTeacherID){
		
		Train_Teacher teacher = tdao.getTeacherByID(trainTeacherID);
		return teacher;
	}
	
	@Override
	public int trainApply(TrainApply trainApply){
		
		int result = -1;
		boolean tmp = false;
		TransactionUtil.getConnection(); 
		int trainApplyId = tdao.gettrainApplyID(trainApply);
		try{
		TransactionUtil.startTransaction(); 
		if(trainApplyId == 0){ //用户未报名
			tmp = tdao.addtrainApply(trainApply);
			boolean res = tdao.addApplyorder(trainApply.getOut_trade_no());
			result = 1;
		}
		else if(trainApplyId == 1){
			result = 2;
		}
		else{
			trainApply.setApplyReportId(trainApplyId);
			tmp = tdao.updateTrainApply(trainApply);
			result = 3;
		}
		}
		catch (Exception e){
			TransactionUtil.roolback();
			e.printStackTrace();

		} finally {
			TransactionUtil.commit();
			TransactionUtil.release(); 
		}
		return result;
	}

	@Override
	public List<Train_Subject> getTrainSearchInfo(String searchInfo) {
		List<Train_Subject> subjects = tdao.getTrainSearchInfo(searchInfo);
		return subjects;
	}

	@Override
	public Train_Subject getTrainSlides() {
		Train_Subject subjects = tdao.getTrainSlides();
		return subjects;
	}

	@Override
	public int judgeAttentionState(String phonenumber, String Id) {
		int attentionState = tdao.judgeAttentionState(phonenumber,Id);
		return attentionState;
	}

	@Override
	public boolean AddTrainAttention(String phonenumber, String Id) {
		TransactionUtil.getConnection();
		boolean result = false;
		int attentionId = 0;
		attentionId = tdao.getattentionId(phonenumber,Id);
		try {
			TransactionUtil.startTransaction(); 
			if(attentionId==0){
				result = tdao.AddTrainAttention(phonenumber,Id);
			}
			else {
				result = tdao.updataAttentionState(phonenumber,Id);
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
	public boolean DelTrainAttention(String phonenumber, String id) {
		TransactionUtil.getConnection();
		boolean result = false;
		try {
			TransactionUtil.startTransaction(); 
			result = tdao.DelTrainAttention(phonenumber,id);

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
	public Train_Subject getTrainbyInfo(String trainName, String trainSubject, int money) {
		Train_Subject train = tdao.getTrainbyInfo(trainName,trainSubject,money);
		return train;
	}

	@Override
	public List<TrainApply> getAllTrainApply(int page) {
		List<TrainApply> trainapply = new ArrayList<>();
		trainapply = tdao.getAllReport(page);
		return trainapply;
	}

	@Override
	public String getTrainApplyNum() {
		String trainapplyNum = tdao.countTrainApplyNum();
		return trainapplyNum;
	}

	@Override
	public TrainApply getTrainApplyDetailbackground(String idcard, String trainName, String trainSubject,
			int trainGrade) {
		TrainApply trainapply = tdao.getTrainApplyDetailbackground(idcard, trainName, trainSubject, trainGrade);
		return trainapply;
	}

	@Override
	public List<TrainApply> getTrainApply(String starttime, String endtime, String options, String Info, int orderState,
			int page) {
		List<TrainApply> trainapply = new ArrayList<>();
		trainapply = tdao.getTrainApply(starttime, endtime, options,Info, orderState,page);
		return trainapply;
	}

	@Override
	public String getSearchNum(String starttime, String endtime, String options, String Info, int orderState) {
		String num = tdao.countTrainApplyBySearch(starttime, endtime, options, Info, orderState);
		return num;
	}

	@Override
	public List<TrainApply> exportTrainApply(String starttime, String endtime, String options, String info,
			int orderState) {
		List<TrainApply> trainapply = new ArrayList<>();
		trainapply = tdao.exportTrainApply(starttime, endtime, options,info, orderState);
		return trainapply;
	}

	@Override
	public List<Train_Subject> getTrainList(int page, int type) {
		List<Train_Subject> train = new ArrayList<>();
		if(type==1) {
			train = tdao.getAllTrain(page);
		}
		else if(type==2) {
			train = tdao.getEffecTrain();
		}
		return train;
	}

	@Override
	public String getTrainNum() {
		return tdao.countTrainNum();
	}

	@Override
	public List<Train_Teacher> getteacherDetail(int tSubject_ID) {
		List<Train_Teacher> teacher = new ArrayList<>();
		teacher = tdao.getteacherDetail(tSubject_ID);
		return teacher;
	}

	@Override
	public boolean reviseTrainState(int id, int tSubject_EnrollState) {
		boolean result = false;
		TransactionUtil.getConnection(); 
		try {
			TransactionUtil.startTransaction(); 
			result = tdao.reviseTrainState(id, tSubject_EnrollState);
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
	public boolean addMechanism(Train_Info info) {
		TransactionUtil.getConnection(); 
		boolean result = false;

		try {
			TransactionUtil.startTransaction(); 
			// ... 
			
			result =  tdao.addMechanism(info);
			
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
	public Train_Subject getTrainDetail(int tSubject_ID) {
		Train_Subject train = tdao.getTrainById(tSubject_ID);
		return train;
	}

	@Override
	public List<Train_Info> getAllMechanism() {
		List<Train_Info> train = new ArrayList<>();
		train = tdao.getAllMechanism();
		return train;
	}

	@Override
	public boolean addTrain(Train_Subject train) {
		TransactionUtil.getConnection(); 
		boolean result = false;

		try {
			TransactionUtil.startTransaction(); 
			// ... 
			if(train.gettSubject_ID()!=0) {
				result = tdao.updateTrain(train);
			} else {
				result =  tdao.addTrain(train);
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
	public List<Train_Subject> getAllTrain() {
		List<Train_Subject> train = new ArrayList<>();
		train = tdao.getAlltrain();
		return train;
	}

	@Override
	public boolean addTeacher(Train_Teacher teacher) {
		TransactionUtil.getConnection(); 
		boolean result = false;

		try {
			TransactionUtil.startTransaction(); 
			// ... 
			
			result =  tdao.addTeacher(teacher);
			
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

	

	
}
