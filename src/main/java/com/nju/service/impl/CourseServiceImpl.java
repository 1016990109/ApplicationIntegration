package com.nju.service.impl;

import com.nju.dao.TestDao;
import com.nju.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by 传旺 on 2016/6/5.
 */
@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private TestDao testDao;

    public Map<String, Object> getCourses() {
        return testDao.test();
    }
}
