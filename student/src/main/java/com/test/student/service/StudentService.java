package com.test.student.service;

import com.test.student.entity.Student;

import java.util.List;

public interface StudentService {
    Student create(Student student);
    Student get(Integer id);
    List<Student> getAll();
    void deleted(Integer id);


    List<Student> findAllStudentsBySchool(Integer schoolId);
}
