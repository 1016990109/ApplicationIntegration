package com.nju.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 传旺 on 2016/5/23.
 */

@Controller
public class AuthController {

    @RequestMapping(value = "/login" , method = RequestMethod.GET)
    public String login(){
        return "/login";
    }

    @RequestMapping(value = "/test" , method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> postlogin(String username, String password, HttpSession session){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("test","test");
        return map;
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(){
        return "/index";
    }
}
