package cn.usgame.dao;

import java.util.List;

import cn.usgame.entity.ApplyReport;
import cn.usgame.entity.TrainApply;
import cn.usgame.entity.Train_Info;
import cn.usgame.entity.Train_Subject;
import cn.usgame.entity.Train_Teacher;


public interface TrainDao {

	
	/**
	 * 函数名称：getDetailedInfo(String course,String enroll,String state,int page)
	 * 函数功能：按相关信息查询培训列表
	 * 参数说明：course比赛的类别，enroll报名的状态，state培训的状态，page当前页码
	 * 作者：zero
	 */
	public List<Train_Subject> getDetailedInfo(String course,String enroll,int page);
	
	/**
	 * 函数名称：getTotalPage(String course, String enroll, String state)
	 * 函数功能：获取培训总数
	 * 参数说明：course比赛的类别，enroll报名的状态，state培训的状态
	 * 作者：zero
	 */
	public String getTotalPage(String course, String enroll);
	
	/**
	 * 函数名称：getTrainList()
	 * 函数功能：获取所有培训信息
	 * 参数说明：
	 * 作者：zero
	 */
	public List<Train_Subject> getTrainList();
	
	/**
	 * 函数名称：getTrainDetailByID(int trainSubjectID)
	 * 函数功能：获取培训详细信息
	 * 参数说明：trainSubjectID培训科目ID
	 */
	public Train_Subject getTrainDetailByID(int trainSubjectID);
	
	/**
	 * 函数名称：getTeacher(int trainSubjectID)
	 * 函数功能：通过培训课程ID获取教师相关信息
	 * 参数说明：trainSubjectID培训科目ID
	 */
	public List<Train_Teacher> getTeacher(int trainSubjectID);
	
	/**
	 * 函数名称：getTeacherByID(int trainTeacherID)
	 * 函数功能：通过培训教师ID获取教师相关信息
	 * 参数说明：trainTeacherID 教师ID
	 */
	public Train_Teacher getTeacherByID(int trainTeacherID);
	
	/**
	 * 函数名称：getapplyReportID(ApplyReport apply)
	 * 函数功能：通过学生姓名，学生学校，学生年级，学生身份证号，培训名称，培训科目，联系人姓名，联系方式查找订单ID
	 * 参数说明：apply 订单详细信息
	 */
	public int gettrainApplyID(TrainApply trainApply);
	
	/**
	 * 函数名称：addapplyReport(ApplyReport apply)
	 * 函数功能：通过学生姓名，学生学校，学生年级，学生身份证号，培训名称，培训科目，联系人姓名，联系方式天假订单
	 * 参数说明：apply 订单详细信息
	 */
	public boolean addtrainApply(TrainApply apply);
	
	/**
	 * 函数名称：addApplyorder(String out_trade_no)
	 * 函数功能：添加商家订单
	 * 参数说明：out_trade_no 序列号
	 */
	public boolean addApplyorder(String out_trade_no);
	
	/**
	 * 函数名称：updateApplyReport(ApplyReport applyReport)
	 * 函数功能：修改订单
	 * 参数说明：applyReport 
	 */
	public boolean updateTrainApply(TrainApply trainApply);

	public List<Train_Subject> getTrainSearchInfo(String searchInfo);

	public Train_Subject getTrainSlides();

	public int judgeAttentionState(String phonenumber, String id);

	public int getattentionId(String phonenumber, String id);

	public boolean AddTrainAttention(String phonenumber, String id);

	public boolean updataAttentionState(String phonenumber, String id);

	public boolean DelTrainAttention(String phonenumber, String id);

	public Train_Subject getTrainbyInfo(String tSubject_CourseName, String tSubject_Course, int money);

	public List<TrainApply> getAllReport(int page);

	public String countTrainApplyNum();

	public TrainApply getTrainApplyDetailbackground(String idcard, String trainName, String trainSubject,
			int trainGrade);

	public List<TrainApply> getTrainApply(String starttime, String endtime, String options, String info, int orderState,
			int page);

	public String countTrainApplyBySearch(String starttime, String endtime, String options, String info,
			int orderState);

	public List<TrainApply> exportTrainApply(String starttime, String endtime, String options, String info,
			int orderState);

	public List<Train_Subject> getAllTrain(int page);

	public List<Train_Subject> getEffecTrain();

	public String countTrainNum();

	public List<Train_Teacher> getteacherDetail(int tSubject_ID);

	public boolean reviseTrainState(int id, int tSubject_EnrollState);

	public boolean addMechanism(Train_Info info);

	public Train_Subject getTrainById(int tSubject_ID);

	public List<Train_Info> getAllMechanism();

	public boolean updateTrain(Train_Subject train);

	public boolean addTrain(Train_Subject train);

	public List<Train_Subject> getAlltrain();

	public boolean addTeacher(Train_Teacher teacher);

	/*public Train_Info getMechanismDetailByID(int trainID);*/
}
