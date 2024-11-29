package com.microservice.student.service;

import com.microservice.student.entity.Student;

import java.util.List;

public interface IStudentService {

    List<Student> students();

    Student findStudentById(Long id);

    List<Student> findByIdCourse(Long courseId);

    void saveStudent(Student student);

    void deleteStudent(Long id);

}
