package com.microservice.course.service;

import com.microservice.course.client.IStudentClient;
import com.microservice.course.dto.StudentDTO;
import com.microservice.course.entity.Course;
import com.microservice.course.http.response.StudentByCourseResponse;
import com.microservice.course.persistence.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements ICourseService{

    private final CourseRepository courseRepository;
    private final IStudentClient studentClient;

    public CourseServiceImpl(CourseRepository courseRepository, IStudentClient studentClient) {
        this.courseRepository = courseRepository;
        this.studentClient = studentClient;
    }

    @Override
    public List<Course> courses() {
        return courseRepository.findAll();
    }

    @Override
    public Course findCourseById(Long id) {
        return courseRepository.findById(id).orElse(null);
    }

    @Override
    public void saveCourse(Course course) {
        courseRepository.save(course);
    }

    @Override
    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }

    @Override
    public StudentByCourseResponse findStudentByCourseId(Long courseId) {

        // Consultar el curso
        Course course = courseRepository.findById(courseId).orElse(new Course());

        // obtener los estudiantes

        List<StudentDTO> studentDTOList = studentClient.findAllStudentsByCourse(courseId);

        return StudentByCourseResponse.builder()
                .courseName(course.getName())
                .teacher(course.getTeacher())
                .studentDTOList(studentDTOList)
                .build();
    }
}
