package cn.usgame.dao.dbutils_impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.ResultSetHandler;

import cn.usgame.entity.Train_Info;
import cn.usgame.entity.Train_Subject;

public class MyBeanHandler implements ResultSetHandler<List<Train_Subject>> {
	
	@Override
	public  List<Train_Subject> handle(ResultSet resSet) throws SQLException {
		
		List<Train_Subject> list=new ArrayList<>();
		while (resSet.next()) {
			Train_Subject subject = new Train_Subject();
			Train_Info info = new Train_Info();
			info.settMechanism_ID(resSet.getInt("tMechanism_ID"));
			info.settMechanism_Name(resSet.getString("tMechanism_Name"));
			info.settMechanism_Address(resSet.getString("tMechanism_Address"));
			info.settMechanism_Phone(resSet.getString("tMechanism_Phone"));
			info.settMechanism_Detail(resSet.getString("tMechanism_Detail"));
			info.settMechanism_PictureUrl(resSet.getString("tMechanism_PictureUrl"));// tMechanism_PictureUrl
			subject.settMechanismInfo(info);
			subject.settSubject_ID(resSet.getInt("tSubject_ID"));
			subject.settSubject_Course(resSet.getString("tSubject_Course"));
			subject.settSubject_Start(resSet.getString("tSubject_Start"));
			subject.settSubject_End(resSet.getString("tSubject_End"));
			subject.settSubject_EnrollStart(resSet.getString("tSubject_EnrollStart"));
			subject.settSubject_EnrollEnd(resSet.getString("tSubject_EnrollEnd"));
			/*subject.settSubject_State(resSet.getInt("tSubject_State"));*/
			subject.settSubject_EnrollState(resSet.getInt("tSubject_EnrollState"));
			subject.settSubject_Times(resSet.getInt("tSubject_Times"));
			subject.settSubject_Detail(resSet.getString("tSubject_Detail"));
			subject.settSubject_PictureUrl(resSet.getString("tSubject_PictureUrl")); // tSubject_PictureUrl
			subject.settSubject_CourseName(resSet.getString("tSubject_CourseName"));
			subject.settSubject_EnrollAddress(resSet.getString("tSubject_EnrollAddress"));
			subject.settSubject_Personnel(resSet.getString("tSubject_Personnel"));
			subject.settSubject_Form(resSet.getString("tSubject_Form"));
			subject.settSubject_DetailTime(resSet.getString("tSubject_DetailTime"));
			subject.settSubject_Grade(resSet.getString("tSubject_Grade"));
			subject.settSubject_BigPic(resSet.getString("tSubject_BigPic"));
			list.add(subject);
		}
		return list;
	}
}
