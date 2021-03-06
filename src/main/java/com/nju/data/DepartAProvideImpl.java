package com.nju.data;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.nju.model.Course;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

public class DepartAProvideImpl extends UnicastRemoteObject implements
		ProvideService {
	Connection conn = null;
	Statement stmt = null;

	protected DepartAProvideImpl() throws RemoteException {
		super();
		try {
			String url = "jdbc:mysql://localhost:3306/YYJC_Depart_A?"
					+ "&useUnicode=true&characterEncoding=UTF8";
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, "root", "root");
			stmt = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public String getCourse(int studentId) throws RemoteException{
		List<Course> res = new ArrayList<Course>();
		String sql = "select 课程编号 from chooseCourse where 学生编号 = " + studentId;
		String sql2 = "select * from course";
		ArrayList<Integer> coursechoose = new ArrayList<Integer>();
		try {
			ResultSet rs1 = stmt.executeQuery(sql);
			while (rs1.next()) {
				int id = rs1.getInt(1);
				coursechoose.add(id);
			}
			ResultSet rs = stmt.executeQuery(sql2);
			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				int point = rs.getInt(3);
				String teacher = rs.getString(4);
				String place = rs.getString(5);
				int share = rs.getInt(6);

				Course c = new Course(id, name, point, teacher, place, share,
						36);
				if (coursechoose.contains(id)) {
					c.setIsShared(2);
				}
				res.add(c);
			}
			Document doc = DocumentHelper.createDocument();
			Element root = doc.addElement("DepartACourses");
			for(int i = 0;i<res.size();i++){
				Element emp = root.addElement("Course");
				Element column = emp.addElement("课程编号");
				column.setText(res.get(i).getCourseId()+"");
				
				Element column1 = emp.addElement("课程名称");
				column1.setText(res.get(i).getCourseName());
				
				Element column2 = emp.addElement("学分");
				column2.setText(res.get(i).getCoursePoint()+"");
				
				Element column3 = emp.addElement("授课老师");
				column3.setText(res.get(i).getTeacherName());
				
				Element column4 = emp.addElement("授课地点");
				column4.setText(res.get(i).getCoursePlace());
				
				Element column5 = emp.addElement("共享");
				column5.setText(res.get(i).getIsShared()+"");
				
			}
			return doc.asXML();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public boolean chooseCourse(int studentId, int courseId) throws RemoteException{
		String sql = "insert into choosecourse values ("+courseId+","+studentId+",0)";
		try {
			int state = stmt.executeUpdate(sql);
			if(state>0)return true;
			else return false;
		} catch (SQLException e) {
			
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public boolean dropCourse(int studentId, int courseId) throws RemoteException{
		String sql = "delete from coursechoose where 课程编号 = "+courseId+"and 学生编号 = "+studentId;
		try {
			int state = stmt.executeUpdate(sql);
			if(state>0)return true;
			else return false;
		} catch (SQLException e) {
			
			e.printStackTrace();
			return false;
		}
	}

}
