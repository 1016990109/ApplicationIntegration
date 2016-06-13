package com.nju.data;

import java.io.*;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.nju.model.Course;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.dom4j.util.XMLErrorHandler;
import org.xml.sax.SAXException;

public class DepartARequireImpl implements RequireService {

	private CenterService  centerservice = null;
	public DepartARequireImpl(){
		try {
			centerservice = (CenterService) Naming.lookup("rmi://10.0.0.13:8010/centerMain");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public Map<String, List<Course>> getOtherCourses(int studentId) {
		List<Course> blist = getBShareCourses(studentId,true);
		List<Course> clist = getCShareCourses(studentId,true);
		Map<String, List<Course>> m = new HashMap<String, List<Course>>();
		m.put("B",blist);
		m.put("C", clist);
		return m;
	}

	@Override
	public List<Course> getMyOtherCourses(int studentId) {
		List<Course> blistAll = getBShareCourses(studentId,false);
		List<Course> clistAll = getCShareCourses(studentId,false);
		ArrayList<Course> res = new ArrayList<Course>();
		res.addAll(blistAll);
		res.addAll(clistAll);
		return res;
	}

	@Override
	public boolean chooseOtherCourse(int studentId, int courseId,
			String department) throws RemoteException {
		if(department.equals("B")){
			return centerservice.chooseBCourse(studentId, courseId);
		}else{
			return centerservice.chooseCCourse(studentId, courseId);
		}
	}

	@Override
	public boolean dropOtherCourse(int studentId, int courseId,
			String department) throws RemoteException {
		if(department.equals("B")){
			return centerservice.dropBCourse(studentId, courseId);
		}else{
			return centerservice.dropCCourse(studentId, courseId);
		}
	}
	
	
	
	
	
	private List<Course> getBShareCourses(int studentId,boolean all){
		try {
			List<Course> res = new ArrayList<Course>();
			Document doc = null;
			String xml = centerservice.AgetBSharedCourse(studentId);
			//System.out.println(xml);
			doc = DocumentHelper.parseText(xml);
			Writer w = new FileWriter("departAGetBShareCourse.xml");
			OutputFormat opf = OutputFormat.createPrettyPrint();
			opf.setEncoding("UTF-8");
			XMLWriter xw = new XMLWriter(w, opf);
			xw.write(doc);
			xw.close();
			w.close();
			SAXReader saxReader = new SAXReader();
			saxReader.setValidation(true);
			saxReader.setFeature("http://xml.org/sax/features/validation", true);
			saxReader.setFeature("http://apache.org/xml/features/validation/schema",true);
			saxReader.setProperty("http://apache.org/xml/properties/schema/external-noNamespaceSchemaLocation", "departACourse.xsd");
			XMLErrorHandler errorHandler = new XMLErrorHandler();
			saxReader.setErrorHandler(errorHandler);
			Document document = saxReader.read(new File("departAGetBShareCourse.xml"));
			XMLWriter writer = new XMLWriter(OutputFormat.createPrettyPrint());
			if(errorHandler.getErrors().hasContent()){
				writer.write(errorHandler.getErrors());
				return null;
			}
			Element root = doc.getRootElement();
			for(Iterator i = root.elementIterator();i.hasNext();){
				Element foo = (Element) i.next();
				ArrayList<String> list = new ArrayList<String>();
				for(Iterator j = foo.elementIterator();j.hasNext();){
					Element tmp = (Element) j.next();
					list.add(tmp.getStringValue());
				}
				int id  =Integer.parseInt(list.get(0));
				String name = list.get(1);
				int point = Integer.parseInt(list.get(2));
				String teacher = list.get(3);
				String place = list.get(4);
				int share = Integer.parseInt(list.get(5));
				
				Course co = new Course(id,name,point,teacher,place,share,36);
				if(all||(share == 2)){
					res.add(co);
				}
			}
			return res;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		}
		return null;
	
	}
	
	
	
	
	private List<Course> getCShareCourses(int studentId,boolean all){
		try {
			List<Course> res = new ArrayList<Course>();
			Document doc = DocumentHelper.parseText(centerservice.AgetCSharedCourse(studentId));
			FileOutputStream w = new FileOutputStream("departAGetCShareCourse.xml");
			OutputFormat opf = OutputFormat.createPrettyPrint();
			opf.setEncoding("UTF-8");
			XMLWriter xw = new XMLWriter(w, opf);
			xw.write(doc);
			xw.close();
			w.close();
			SAXReader saxReader = new SAXReader();
			saxReader.setValidation(true);
			saxReader.setFeature("http://xml.org/sax/features/validation", true);
			saxReader.setFeature("http://apache.org/xml/features/validation/schema",true);
			saxReader.setProperty("http://apache.org/xml/properties/schema/external-noNamespaceSchemaLocation", "departACourse.xsd");
			XMLErrorHandler errorHandler = new XMLErrorHandler();
			saxReader.setErrorHandler(errorHandler);
			saxReader.setEncoding("UTF-8");
			Document document = saxReader.read(new FileInputStream(new File("departAGetCShareCourse.xml")));
			XMLWriter writer = new XMLWriter(OutputFormat.createPrettyPrint());
			if(errorHandler.getErrors().hasContent()){
				writer.write(errorHandler.getErrors());
				return null;
			}
			Element root = document.getRootElement();
			for(Iterator i = root.elementIterator();i.hasNext();){
				Element foo = (Element) i.next();
				ArrayList<String> list = new ArrayList<String>();
				for(Iterator j = foo.elementIterator();j.hasNext();){
					Element tmp = (Element) j.next();
					list.add(tmp.getStringValue());
				}
				int id  =Integer.parseInt(list.get(0));
				String name = list.get(1);
				int point = Integer.parseInt(list.get(2));
				String teacher = list.get(3);
				String place = list.get(4);
				int share = Integer.parseInt(list.get(5));
				Course co = new Course(id,name,point,teacher,place,share,36);
				if(all||(share == 2)){
					res.add(co);
				}
			}
			return res;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	
	}

}
