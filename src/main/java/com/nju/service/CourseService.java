package com.nju.service;

import java.util.List;
import java.util.Map;

/**
 * Created by 传旺 on 2016/6/5.
 */
public interface CourseService {
    List<Object> getCourses();

    Map<String, Object> getOtherCourses();

    List<Object> getMyCourses();
}
