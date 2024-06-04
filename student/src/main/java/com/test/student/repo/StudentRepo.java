package com.test.student.repo;

import com.test.student.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepo extends JpaRepository<Student,Integer> {


    List<Student> findAllBySchoolId(Integer schoolId);
}
