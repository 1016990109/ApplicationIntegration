package com.nju.data;

import com.nju.model.Course;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DepartADataImpl implements DataService {
	Connection conn = null;
	Statement stmt = null;
	RequireService req = null;

	
	public DepartADataImpl(){
		
		try {
			
			String url = "jdbc:mysql://localhost:3306/yyjc_depart_a?"
					+ "&useUnicode=true&characterEncoding=UTF8";
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, "root", "root");
			stmt = conn.createStatement();
			req = new DepartARequireImpl();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	


	 /**
     * 获得本院系A的课程，包含学生是否选择某门课程的信息
     * @param studentId 学生id
     * @return 返回一个课程列表List、ArrayList
     */
	 @Override
    public List<Course> getCourses(int studentId) {
    	List<Course> res = new ArrayList<Course>();
    	String sql = "select 课程编号 from choosecourse where 学生编号 = "+studentId;
    	String sql2 = "select * from course";
    	ArrayList<Integer> coursechoose = new ArrayList<Integer>();
    	try {
			ResultSet rs1 = stmt.executeQuery(sql);
			while(rs1.next()){
				int id = rs1.getInt(2);
				coursechoose.add(id);
			}
			ResultSet rs = stmt.executeQuery(sql2);
			while(rs.next()){
				int id = rs.getInt(1);
				String name = rs.getString(2);
				int point = rs.getInt(3);
				String teacher = rs.getString(4);
				String place = rs.getString(5);
				int share = rs.getInt(6);
				
				Course c = new Course(id, name, point, teacher, place, share, 36);
				if(coursechoose.contains(id)){c.setIsShared(2);}
				res.add(c);
			}
			return res;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return null;
    }

    /**
     * 获得其他院系的课程，包含学生是否选择某门课程的信息
     * @param studentId 学生id
     * @return 返回map，String：院系名称，Object：课程列表
     */
	@Override
    public Map<String, List<Course>> getOtherCourses(int studentId) throws RemoteException{
    	return req.getOtherCourses(studentId);
        
    }

    /**
     * 获得我选的课程
     * @return 返回选课的列表List、ArrayList
     */
    @Override
    public List<Course> getMyCourses(int studentId) throws RemoteException{
    	List<Course> res = new ArrayList<Course>();
    	res.addAll(req.getMyOtherCourses(studentId));
    	String sql = "select course.* from course,choosecourse where course.课程编号 = chooseCourse.课程编号 and chooseCourse.学生编号 ="+studentId;
    	try {
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				int id = rs.getInt(1);
				String name = rs.getString(2);
				int point = rs.getInt(3);
				String teacher = rs.getString(4);
				String place = rs.getString(5);
				int share = rs.getInt(6);
				
				Course c = new Course(id, name, point, teacher, place, share, 36);
				c.setIsShared(2);
				res.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return res;
    }

    /**
     * 选课
     * @param studentId 学生id
     * @param courseId 课程id
     * @param department 院系：A、B、C
     * @return
     * @throws RemoteException 
     */
    @Override
    public boolean chooseCourse(int studentId, int courseId, String department) throws RemoteException {
    	if(department.equals("A")){
    		String sql = "insert into choosecourse values ("+courseId+","+studentId+",0)";
    		try {
				int state = stmt.executeUpdate(sql);
				if(state>0)return true;
				else return false;
			} catch (SQLException e) {
				
				e.printStackTrace();
				return false;
			}
    	}else{
    		return req.chooseOtherCourse(studentId, courseId, department);
    	}
    }

    /**
     * 退课
     * @param studentId 学生id
     * @param courseId 课程id
     * @param department 院系：A、B、C
     * @return
     */
    @Override
    public boolean dropCourse(int studentId, int courseId, String department) throws RemoteException {
    	if(department.equals("A")) {
    		String sql = "delete from coursechoose where 课程编号 = "+courseId+"and 学生编号 = "+studentId;
    		try {
				int state = stmt.executeUpdate(sql);
				if(state>0)return true;
				else return false;
			} catch (SQLException e) {
				
				e.printStackTrace();
				return false;
			}
    	}else{
    		return req.dropOtherCourse(studentId, courseId, department);
    	}
        
    }
    
    
    public static void main(String[] args) {
		DepartADataImpl dpa = new DepartADataImpl();
		//Boolean res;
		try {
			//res = dpa.chooseCourse(10001, 2001, "B");
			//System.out.println(res);
//			dpa.getOtherCourses(10001);
			List<Course> list = dpa.getOtherCourses(10001).get("B");
			for (int i = 0; i < list.size(); i++){
				System.out.println(list.get(i).getCourseName());
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
