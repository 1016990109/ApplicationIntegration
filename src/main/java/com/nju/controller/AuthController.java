package com.nju.controller;

import com.nju.model.Course;
import com.nju.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

/**
 * Created by 传旺 on 2016/5/23.
 */

@Controller
public class AuthController {

    @Autowired
    private CourseService courseService;

    @RequestMapping(value = "/login" , method = RequestMethod.GET)
    public String login(){
        courseService.getCourses(1);
        return "/login";
    }

    @RequestMapping(value = "/login" , method = RequestMethod.POST)
    public String postlogin(String username, String password, HttpSession session){
        System.out.println(username);
        System.out.println(password);
        return "redirect:/index";
    }

    @RequestMapping(value = "/logout" , method = RequestMethod.GET)
    public String logout(HttpSession session){
        Enumeration<String> em = session.getAttributeNames();
        while (em.hasMoreElements()) {
            session.removeAttribute(em.nextElement().toString());
        }
        return "/login";
    }

    @RequestMapping(value = "/getCourse", method = RequestMethod.POST)
    @ResponseBody
    public List<Course> getCourse(@RequestParam int studentId){
        return courseService.getCourses(studentId);
    }

    @RequestMapping(value = "/getOtherCourse", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, List<Course>> getOtherCourse(@RequestParam int studentId){
        return courseService.getOtherCourses(studentId);
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(){
        return "/index";
    }

    @RequestMapping(value = "/course", method = RequestMethod.GET)
    public String course(){
        return "/course";
    }

    @RequestMapping(value = "/students", method = RequestMethod.GET)
    public String students(){
        return "/students";
    }
}
