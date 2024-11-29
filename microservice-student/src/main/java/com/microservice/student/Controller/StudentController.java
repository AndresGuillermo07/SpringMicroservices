package com.microservice.student.Controller;

import com.microservice.student.entity.Student;
import com.microservice.student.service.IStudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    private final IStudentService studentService;

    public StudentController(IStudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/all")
    public ResponseEntity<?> getStudents() {
        return ResponseEntity.ok(studentService.students());
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void createStudent(@RequestBody Student student) {
        studentService.saveStudent(student);
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return ResponseEntity.ok(studentService.findStudentById(id));
    }

    @GetMapping("/searchByCourse/{courseId}")
    public ResponseEntity<?> findByIdCourse(@PathVariable Long courseId){
        return ResponseEntity.ok(studentService.findByIdCourse(courseId));
    }

}