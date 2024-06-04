package com.test.student.controller;

import com.test.student.entity.Student;
import com.test.student.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/v1/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

@PostMapping("/")
    public ResponseEntity<Student> createStudent(@RequestBody  Student student){
        Student students = this.studentService.create(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(students);
    }


    @GetMapping("/")
    public ResponseEntity<List<Student>> getAllStudents(){
        List<Student> studentList = this.studentService.getAll();
        return  ResponseEntity.ok(studentList);
    }

    @GetMapping("/school/{schoolId}")
    public ResponseEntity<List<Student>> findAllStudents(@PathVariable Integer schoolId){
        List<Student> schoolStudentList = this.studentService.findAllStudentsBySchool(schoolId);
        return  ResponseEntity.ok(schoolStudentList);
    }

}
