package cn.usgame.service;

import java.util.List;

import cn.usgame.entity.ApplyReport;
import cn.usgame.entity.CampApply;
import cn.usgame.entity.Competition;
import cn.usgame.entity.TrainApply;
import cn.usgame.entity.Train_Info;
import cn.usgame.entity.Train_Subject;
import cn.usgame.entity.Train_Teacher;

public interface TrainService {
	
	List<Train_Subject> getTrainDetail(String course,String enroll,int page);
	
	String getTotalNum(String course,String enroll);
	
	List<Train_Subject> getTrainList();
	
	Train_Subject getTrainDetailByID(int trainSubjectID);
	
	List<Train_Teacher> getTeacher(int trainSubjectID);
	
	Train_Teacher getTeacherByID(int trainSubjectID);
	
	int trainApply(TrainApply trainApply);

	List<Train_Subject> getTrainSearchInfo(String searchInfo);

	Train_Subject getTrainSlides();

	int judgeAttentionState(String phonenumber, String Id);

	boolean AddTrainAttention(String phonenumber, String id);

	boolean DelTrainAttention(String phonenumber, String id);

	Train_Subject getTrainbyInfo(String trainName, String trainSubject, int money);

	List<TrainApply> getAllTrainApply(int page);

	String getTrainApplyNum();

	TrainApply getTrainApplyDetailbackground(String idcard, String trainName, String trainSubject, int trainGrade);

	List<TrainApply> getTrainApply(String starttime, String endtime, String options, String info, int orderState,
			int page);

	String getSearchNum(String starttime, String endtime, String options, String info, int orderState);

	List<TrainApply> exportTrainApply(String starttime, String endtime, String options, String info, int orderState);

	List<Train_Subject> getTrainList(int page, int type);

	String getTrainNum();

	List<Train_Teacher> getteacherDetail(int tSubject_ID);

	boolean reviseTrainState(int id, int tSubject_EnrollState);

	boolean addMechanism(Train_Info info);

	Train_Subject getTrainDetail(int tSubject_ID);

	List<Train_Info> getAllMechanism();

	boolean addTrain(Train_Subject train);

	List<Train_Subject> getAllTrain();

	boolean addTeacher(Train_Teacher teacher);

	

}
