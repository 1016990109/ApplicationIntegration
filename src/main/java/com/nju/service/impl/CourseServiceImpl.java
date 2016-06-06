package com.nju.service.impl;

import com.nju.dao.TestDao;
import com.nju.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by 传旺 on 2016/6/5.
 */
@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private TestDao testDao;

    /**
     * 获得本院系A的课程
     * @return 返回一个课程列表List、ArrayList
     */
    @Override
    public List<Object> getCourses() {
        return testDao.test();
    }

    /**
     * 获得其他院系的课程
     * @return 返回map，String：院系名称，Object：课程列表
     */
    @Override
    public Map<String, Object> getOtherCourses() {
        return null;
    }

    /**
     * 获得我选的课程
     * @return 返回选课的列表List、ArrayList
     */
    @Override
    public List<Object> getMyCourses() {
        return null;
    }
}
