package com.test.student.service.Impl;

import com.test.student.entity.Student;
import com.test.student.repo.StudentRepo;
import com.test.student.service.StudentService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepo studentRepo;
    @Override
    public Student create(Student student) {
        return this.studentRepo.save(student);
    }

    @Override
    public Student get(Integer id) {
        return this.studentRepo.findById(id).get();
    }

    @Override
    public List<Student> getAll() {
        return this.studentRepo.findAll();
    }

    @Override
    public void deleted(Integer id) {
        this.studentRepo.deleteById(id);
    }

    @Override
    public List<Student> findAllStudentsBySchool(Integer schoolId) {
        return this.studentRepo.findAllBySchoolId(schoolId);
    }
}
