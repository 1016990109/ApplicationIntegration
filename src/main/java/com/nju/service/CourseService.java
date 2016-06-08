package com.nju.service;

import java.util.List;
import java.util.Map;

/**
 * Created by 传旺 on 2016/6/5.
 */
public interface CourseService {
    List<Object> getCourses(int studentId);

    Map<String, Object> getOtherCourses(int studentId);

    List<Object> getMyCourses(int studentId);

    boolean chooseCourse(int studentId, int courseId, String department);

    boolean dropCourse(int studentId, int courseId, String department);
}
