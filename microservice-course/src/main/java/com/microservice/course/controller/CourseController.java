package com.microservice.course.controller;

import com.microservice.course.entity.Course;
import com.microservice.course.service.ICourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/course")
public class CourseController {

    private final ICourseService courseService;


    public CourseController(ICourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Course course) {
        courseService.saveCourse(course);
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(courseService.courses());
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return ResponseEntity.ok(courseService.findCourseById(id));
    }

    @GetMapping("/searchStudents/{courseId}")
    public ResponseEntity<?> findStudentsByCourseId(@PathVariable Long courseId) {
        return ResponseEntity.ok(courseService.findStudentByCourseId(courseId));
    }

}
