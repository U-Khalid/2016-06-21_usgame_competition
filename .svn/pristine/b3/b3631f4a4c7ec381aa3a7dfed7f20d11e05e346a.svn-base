package cn.usgame.dao.dbutils_impl;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;

import cn.usgame.dao.TrainDao;
import cn.usgame.entity.ApplyReport;
import cn.usgame.entity.Attention;
import cn.usgame.entity.Camp;
import cn.usgame.entity.Competition;
import cn.usgame.entity.TrainApply;
import cn.usgame.entity.Train_Info;
import cn.usgame.entity.Train_Subject;
import cn.usgame.entity.Train_Teacher;
import cn.usgame.utils.JdbcUtils_DBCP;
import cn.usgame.utils.TransactionUtil;

public class TrainDaoImply implements TrainDao {

	private static QueryRunner runerUpdate = new QueryRunner();
	private static QueryRunner runerQuery = new QueryRunner(JdbcUtils_DBCP.getDataSource());
	@Override
	public List<Train_Subject> getDetailedInfo(String course, String enroll, int page) {
		int i=0,j=0;
		page = page*30;
		List<Train_Subject> subject=null;
		StringBuffer sql=new StringBuffer();
		sql.append("select * from train_info as a,train_subject as b where (a.tMechanism_ID=b.tMechanism_ID");
		Object[ ] params = new Object[3];
		if(!course.equals("null")){
			sql.append(" && b.tSubject_Course=?");
			params[i++]=course;
		}
		if(!enroll.equals("null")){
			sql.append(" && b.tSubject_EnrollState=?");
			params[i++]=enroll;
		}
		/*if(!state.equals("null")){
			sql.append(" && b.tSubject_State=?");
			params[i++]=state;
		}*/
		sql.append(") order by b.tSubject_ID desc limit ?,20");
		params[i++]=page;
		for(i=0;i<params.length;i++){
			if(params[i]!=null){
				j++;
			}
		}
		Object[ ] param=new Object[j];
		j=-1;
		for(i=0;i<3;i++){
			if(params[i]!=null){
				param[++j]=params[i];
			//	System.out.println("param["+j+"]="+param[j]);
			}
		}
		String s=sql.toString();
		//System.out.println("sql=="+s);
		try{
			subject = runerQuery.query(s, param, new MyBeanHandler());
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return subject;
	}
	@Override
	public String getTotalPage(String course, String enroll) {
		// TODO Auto-generated method stub
		int i=0;
		String num=null;
		Map a;
		StringBuffer sql = new StringBuffer("select count(*) from train_info as a,train_subject as b where "
				+ "(a.tMechanism_ID=b.tMechanism_ID");
		if(!course.equals("null")){
			sql.append(" && b.tSubject_Course='"+course+"'");
		}
		if(!enroll.equals("null")){
			sql.append(" && b.tSubject_EnrollState="+enroll);
		}
		/*if(!state.equals("null")){
			sql.append(" && b.tSubject_State="+state);
		}*/
		sql.append(")");
		String s=sql.toString();
		try {
			a =  runerQuery.query(s,  new MapHandler());
			num = a.get("count(*)").toString();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return num;
	}

	@Override
	public List<Train_Subject> getTrainList(){
		String sql = "select * from train_info as a,train_subject as b where a.tMechanism_ID=b.tMechanism_ID"
				+ " order by tSubject_ID desc";
		List<Train_Subject> subject = new ArrayList<Train_Subject>();
		try{
			subject=runerQuery.query(sql,new MyBeanHandler());
		}catch(SQLException e){
			e.printStackTrace();
		}
		return subject;
	}
	
	@Override
	public Train_Subject getTrainDetailByID(int trainSubjectID){
		
		Train_Subject tSubject = null;
		/*String sql = "select * from train_info as a,train_subject as b where (a.tMechanism_ID=b.tMechanism_ID"
				+ " && b.tSubject_ID=? )";*/
		String sql = "select * from train_info a, train_subject b where a.tMechanism_ID = b.tMechanism_ID and b.tSubject_ID = ?";
		Object[] param = {trainSubjectID};
		/*System.out.println("sql="+sql );*/
		try{
			tSubject =  runerQuery.query(sql, param, new MyClassBean());
			/*System.out.println(tSubject);*/
		}catch(SQLException e){
			e.printStackTrace();
		}
		return tSubject;
	}
	
	/*@Override
	public Train_Info getMechanismDetailByID(int trainID) {
		Train_Info ttrain = null;
		String sql = "select * from train_info where tMechanism_ID = ?";
		Object[] param = {trainID};
		try {
			ttrain = runerQuery.query(sql, param, new BeanHandler<>(Train_Info.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ttrain;
	}*/
	
	@Override
	public List<Train_Teacher> getTeacher(int trainSubjectID){
		
		List<Train_Teacher> teacher = null;
		String sql = "select * from train_teacher where tSubject_ID=? order by tTeacher_Price desc";
		Object[] params = {trainSubjectID};
		try{
			teacher = runerQuery.query(sql, params, new BeanListHandler<>(Train_Teacher.class));
		}catch(SQLException e){
			e.printStackTrace();
		}
		return teacher;
	}
	
	@Override
	public Train_Teacher getTeacherByID(int trainTeacherID){
		
		Train_Teacher teacher = new Train_Teacher();
		String sql = "select * from train_teacher where tTeacher_ID=?";
		Object[] params = {trainTeacherID};
		try{
			teacher = runerQuery.query(sql, params, new BeanHandler<>(Train_Teacher.class));
		}catch(SQLException e){
			e.printStackTrace();
		}
		return teacher;
	}
	
	@Override
	public int gettrainApplyID(TrainApply trainApply){
		
		int applyReportId = 0;
		TrainApply apply = new TrainApply();
		String sql = "select applyReportId,applyReportState from trainapply where ("+
		      "idCard=? &&  trainName=? && trainSubject=?&&"+
			  "trainGrade=? && state=?)";
		Object[] params ={
				trainApply.getIdCard(),trainApply.gettrainName(),trainApply.gettrainSubject(),trainApply.gettrainGrade(),1
		};
		try{
			apply = runerQuery.query(sql, params, new BeanHandler<>(TrainApply.class));
		}catch(SQLException e){
			e.printStackTrace();
		}
		try{ 
			applyReportId = apply.getApplyReportId();
			if(apply.getApplyReportState() == 1){
				applyReportId = 1;
			}
			return applyReportId;
		}catch(Exception e){
			return 0;
		}
	}
	@Override
	public boolean addtrainApply(TrainApply apply){
		
		boolean result = true;
		String sql = "insert into trainapply (`applyReportId`,`name`,`idCard`,"
				+ "`school`,`grade`,`trainName`,`trainSubject`,`trainGrade`,`contectName`"
				+ ",`contectPhone`,`phoneNumber`, `out_trade_no`,`money`,`applyReportTime`,`state`)"
				+ " values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		SimpleDateFormat s = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
		Object[] params = {
				apply.getApplyReportId(),apply.getName(),apply.getIdCard(),apply.getSchool(),apply.getGrade(),
				apply.gettrainName(),apply.gettrainSubject(),apply.gettrainGrade(),apply.getContectName(),
				apply.getContectPhone(),apply.getPhoneNumber(),apply.getOut_trade_no(),apply.getMoney(),
				s.format(apply.getApplyReportTime()),1
		};
		try {
			int res = runerUpdate.update(TransactionUtil.getConnection(), sql, params);
		} catch(SQLException e) {
			result=false;
			e.printStackTrace();
		}
		return result;
	}
	@Override
	public boolean addApplyorder(String out_trade_no){
		
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
	public boolean updateTrainApply(TrainApply trainApply){
		boolean result = true;
		String sql = "update trainapply set name=?,idCard=?,school=?,grade=?,trainName=?,"
				+ "trainSubject=?,trainGrade=?,contectName=?,contectPhone=? where applyReportId=?";
		Object[] param = {
				trainApply.getName(),trainApply.getIdCard(),trainApply.getSchool(),trainApply.getGrade(),trainApply.gettrainName(),
				trainApply.gettrainSubject(),trainApply.gettrainGrade(),trainApply.getContectName(),trainApply.getContectPhone(),
				trainApply.getApplyReportId()
		};
		try{
			int res = runerUpdate.update(TransactionUtil.getConnection(), sql, param);
		}catch(SQLException e){
			result = false;
			e.printStackTrace();
		}
		return result;
	}
	@Override
	public List<Train_Subject> getTrainSearchInfo(String searchInfo) {
		List<Train_Subject> subject = new ArrayList<Train_Subject>();
		String sql = "select * from train_info as a,train_subject as b where a.tMechanism_ID=b.tMechanism_ID and (a.tMechanism_Name like '%"+searchInfo+"%' or a.tMechanism_Address like '%"+searchInfo+"%' or a.tMechanism_Detail like '%"+searchInfo+"%' or b.tSubject_Course like '%"+searchInfo+"%' or b.tSubject_Detail like '%"+searchInfo+"%' or b.tSubject_CourseName like '%"+searchInfo+"%' or b.tSubject_Personnel like '%"+searchInfo+"%' or b.tSubject_Form like '%"+searchInfo+"%' or b.tSubject_DetailTime like '%"+searchInfo+"%')"
				+ " order by tSubject_ID desc";
		try{
			subject=runerQuery.query(sql,new MyBeanHandler());
		}catch(SQLException e){
			e.printStackTrace();
		}
		return subject;
	}
	@Override
	public Train_Subject getTrainSlides() {
		Train_Subject tsubject = null;
		String sql="select * from train_info as a,train_subject as b where a.tMechanism_ID=b.tMechanism_ID order by tSubject_ID desc limit 1";
		try {
			tsubject=runerQuery.query(sql,new MyClassBean());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tsubject;
	}
	
	
	@Override
	public int judgeAttentionState(String phonenumber, String Id) {
		Attention attention = null;
		int attentionState = 0;
		String sql = "select attentionState from attention where attentionUser=? and attentionContentId=? and attentionType=3";
		Object[] param = {phonenumber,Id};
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
	public int getattentionId(String phonenumber, String id) {
		Attention attention = null;
		int attentionId = 0;
		String sql = "select attentionId from attention where attentionUser=? and attentionContentId=? and attentionType=3";
		Object[] param = {phonenumber,id};
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
	public boolean AddTrainAttention(String phonenumber, String id) {
		boolean result = false;
		
		String sql = "INSERT INTO `bsjw`.`attention` (`attentionUser`, `attentionType`, `attentionContentId`, `attentionState`) VALUES (?,?,?,?)";
		Object[] param = {phonenumber,3,id,1};
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
	public boolean updataAttentionState(String phonenumber, String id) {
		boolean result = false;
		String  sql = "UPDATE `bsjw`.`attention` SET attentionState=1 WHERE attentionUser=? and attentionContentId=? and attentionType=3";
		Object[] param = {phonenumber,id};
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
	public boolean DelTrainAttention(String phonenumber, String id) {
		boolean result = false;
		String  sql = "UPDATE `bsjw`.`attention` SET attentionState=0 WHERE attentionUser=? and attentionContentId=? and attentionType=3";
		Object[] param = {phonenumber,id};
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
	public Train_Subject getTrainbyInfo(String tSubject_CourseName, String tSubject_Course, int money) {
		Train_Subject train = new Train_Subject();
		String sql = "select * from train_subject where tSubject_CourseName=? and tSubject_Course=?";
		Object[] param = {tSubject_CourseName,tSubject_Course}; 
		try {
			train = runerQuery.query(sql, new BeanHandler<>(Train_Subject.class), param);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return train;
	}
	@Override
	public List<TrainApply> getAllReport(int page) {
		//获取30条数据
		int startPos = (page - 1) * 30;
		List<TrainApply> trainapply = null;
		String sql = "select * from trainapply limit ?,?"; 
		Object[] param = {startPos,30};
				
		try {
			trainapply = runerQuery.query(sql, param, new BeanListHandler<TrainApply>(TrainApply.class));
					
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return trainapply;
	}
	
	
	@Override
	public String countTrainApplyNum() {
		String number = null;
		Map a;
		String sql = "select count(*) from trainapply";
		try {
			a =  runerQuery.query(sql, new MapHandler());
			number = a.get("count(*)").toString();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return number;
	}
	@Override
	public TrainApply getTrainApplyDetailbackground(String idcard, String trainName, String trainSubject,
			int trainGrade) {
		TrainApply trainapply = null;
		String sql = "select * from trainapply where idcard=? and trainName=? and trainSubject=? and trainGrade=? and state=?";
		Object[] param= {idcard,trainName,trainSubject,trainGrade,1};
		try {
			trainapply = runerQuery.query(sql, param , new BeanHandler<TrainApply>(TrainApply.class));
		} catch(SQLException e){
			e.printStackTrace();
		}
		return trainapply;
	}
	
	
	
	@Override
	public List<TrainApply> getTrainApply(String starttime, String endtime, String options, String Info, int orderState,
			int page) {
		int startPos = (page - 1) * 30;
		List<TrainApply> trainapply = null;
		StringBuffer sql =new StringBuffer();
		sql.append("select * "); 
		sql.append(new TrainApply().returnsql(starttime, endtime, options, Info, orderState));
		sql.append(" limit "+startPos+",30");
		try {
			trainapply = runerQuery.query(sql.toString(),new BeanListHandler<TrainApply>(TrainApply.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return trainapply;
	}
	
	
	
	@Override
	public String countTrainApplyBySearch(String starttime, String endtime, String options, String Info,
			int orderState) {
		String number = null;
		Map a;
		StringBuffer sql =new StringBuffer();
		sql.append("select count(*) "); 
		sql.append(new TrainApply().returnsql(starttime, endtime, options, Info, orderState));
		try {
			a =  runerQuery.query(sql.toString(),new MapHandler());
			number = a.get("count(*)").toString();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return number;
	}
	
	
	@Override
	public List<TrainApply> exportTrainApply(String starttime, String endtime, String options, String info,
			int orderState) {
		List<TrainApply> trainapply = null;
		StringBuffer sql =new StringBuffer();
		sql.append("select * "); 
		sql.append(new TrainApply().returnsql(starttime, endtime, options, info, orderState));
		try {
			trainapply = runerQuery.query(sql.toString(),new BeanListHandler<TrainApply>(TrainApply.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return trainapply;
	}
	@Override
	public List<Train_Subject> getAllTrain(int page) {
		int startPos = (page - 1) * 30;
		List<Train_Subject> train = null;
		String sql = "select * from train_subject order by tSubject_ID DESC limit ?,?"; 
		Object[] param = {startPos,30};
		
		try {
			train = runerQuery.query(sql, param, new BeanListHandler<Train_Subject>(Train_Subject.class));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return train;
	}
	@Override
	public List<Train_Subject> getEffecTrain() {
		List<Train_Subject> train = null;
		//competitionState=1为有限比赛，=0为无效比赛
		String sql = "select * from train_subject where tSubject_EnrollState=2";
		try {
			train = runerQuery.query(sql, new BeanListHandler<Train_Subject>(Train_Subject.class));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return train;
	}
	@Override
	public String countTrainNum() {
		String number = null;
		Map a;
		String sql = "select count(*) from train_subject";
		try {
			a =  runerQuery.query(sql, new MapHandler());
			number = a.get("count(*)").toString();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return number;
	}
	@Override
	public List<Train_Teacher> getteacherDetail(int tSubject_ID) {
		List<Train_Teacher> teacher = null;
		String sql = "select * from train_teacher where tSubject_ID=?";
		Object[] param = {tSubject_ID};
		try {
			teacher = runerQuery.query(sql, param, new BeanListHandler<Train_Teacher>(Train_Teacher.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return teacher;
	}
	
	
	@Override
	public boolean reviseTrainState(int id, int tSubject_EnrollState) {
		boolean result = true;
		String sql = "update train_subject set tSubject_EnrollState=? where tSubject_ID=?";
		Object[] param = {
				tSubject_EnrollState,id
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
	public boolean addMechanism(Train_Info info) {
		boolean flag = false;
		String sql = "INSERT INTO `bsjw`.`train_info` (`tMechanism_ID`, `tMechanism_Name`, `tMechanism_Address`, `tMechanism_Phone`, `tMechanism_Detail`, `tMechanism_PictureUrl`) VALUES (?, ?, ?, ?, ?, ?);";
		Object[] param = {
			info.gettMechanism_ID(), info.gettMechanism_Name(),
			info.gettMechanism_Address(), info.gettMechanism_Phone(),
			info.gettMechanism_Detail(), info.gettMechanism_PictureUrl(),
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
	public Train_Subject getTrainById(int tSubject_ID) {
		Train_Subject train = new Train_Subject();
		String sql = "select * from train_subject where tSubject_ID=?";
		Object[] param = {tSubject_ID};
		try {
			train = runerQuery.query(sql, param, new BeanHandler<>(Train_Subject.class));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return train;
	}
	
	@Override
	public List<Train_Info> getAllMechanism() {
		List<Train_Info> teacher = null;
		String sql = "select * from train_info ";
		try {
			teacher = runerQuery.query(sql, new BeanListHandler<Train_Info>(Train_Info.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return teacher;
	}
	
	
	@Override
	public boolean updateTrain(Train_Subject train) {
		boolean flag = false;
		String sql = "UPDATE `bsjw`.`train_subject` SET `tMechanism_ID`=?, `tSubject_Course`=?, `tSubject_Start`=?, `tSubject_End`=?, `tSubject_EnrollStart`=?, `tSubject_EnrollEnd`=?, `tSubject_Times`=?, `tSubject_Detail`=?, `tSubject_EnrollState`=?, `tSubject_PictureUrl`=?, `tSubject_CourseName`=?, `tSubject_EnrollAddress`=?, `tSubject_Personnel`=?, `tSubject_Form`=?, `tSubject_DetailTime`=?, `tSubject_Grade`=?, `tSubject_BigPic`=? WHERE(`tSubject_ID`=?);";
		Object[] param ={
				train.gettMechanismInfo().gettMechanism_ID(), train.gettSubject_Course(),
				train.gettSubject_Start(), train.gettSubject_End(), train.gettSubject_EnrollStart(),
				train.gettSubject_EnrollEnd(), train.gettSubject_Times(), train.gettSubject_Detail(),
				1, train.gettSubject_PictureUrl(), train.gettSubject_CourseName(),
				train.gettSubject_EnrollAddress(), train.gettSubject_Personnel(), train.gettSubject_Form(),
				train.gettSubject_DetailTime(), train.gettSubject_Grade(), train.gettSubject_BigPic(), 
				train.gettSubject_ID()
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
	public boolean addTrain(Train_Subject train) {
		boolean flag = false;
		String sql = "INSERT INTO `bsjw`.`train_subject` (`tMechanism_ID`, `tSubject_Course`, `tSubject_Start`, `tSubject_End`, `tSubject_EnrollStart`, `tSubject_EnrollEnd`, `tSubject_Times`, `tSubject_Detail`, `tSubject_EnrollState`, `tSubject_PictureUrl`, `tSubject_CourseName`, `tSubject_EnrollAddress`, `tSubject_Personnel`, `tSubject_Form`, `tSubject_DetailTime`, `tSubject_Grade`, `tSubject_BigPic`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
		Object[] param ={
				train.gettMechanismInfo().gettMechanism_ID(), train.gettSubject_Course(),
				train.gettSubject_Start(), train.gettSubject_End(), train.gettSubject_EnrollStart(),
				train.gettSubject_EnrollEnd(), train.gettSubject_Times(), train.gettSubject_Detail(),
				1, train.gettSubject_PictureUrl(), train.gettSubject_CourseName(),
				train.gettSubject_EnrollAddress(), train.gettSubject_Personnel(), train.gettSubject_Form(),
				train.gettSubject_DetailTime(), train.gettSubject_Grade(), train.gettSubject_BigPic()
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
	public List<Train_Subject> getAlltrain() {
		List<Train_Subject> teacher = null;
		String sql = "select * from train_subject ";
		try {
			teacher = runerQuery.query(sql, new BeanListHandler<Train_Subject>(Train_Subject.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return teacher;
	}
	@Override
	public boolean addTeacher(Train_Teacher teacher) {
		//System.out.println("23==="+teacher.gettTeacher_Price());
		boolean flag = false;
		String sql = "INSERT INTO `bsjw`.`train_teacher` (`tSubject_ID`, `tTeacher_Info`, `tTeacher_Name`, `tTeacher_Sex`, `tTeacher_Price`) VALUES (?, ?, ?, ?, ?)";
		Object[] param={
				teacher.gettSubject_ID(),teacher.gettTeacher_Info(), teacher.gettTeacher_Name(),
				teacher.gettTeacher_Sex(), teacher.gettTeacher_Price()
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
	
}
