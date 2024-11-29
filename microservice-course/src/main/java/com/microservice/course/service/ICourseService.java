package com.microservice.course.service;

import com.microservice.course.entity.Course;
import com.microservice.course.http.response.StudentByCourseResponse;

import java.util.List;

public interface ICourseService {

    List<Course> courses();

    Course findCourseById(Long id);

    void saveCourse(Course course);

    void deleteCourse(Long id);

    StudentByCourseResponse findStudentByCourseId(Long courseId);


}
