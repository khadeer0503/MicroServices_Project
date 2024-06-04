package com.test.school.service.Impl;

import com.test.school.client.StudentClient;
import com.test.school.entity.FullSchoolWithStudents;
import com.test.school.entity.School;
import com.test.school.repo.SchoolRepo;
import com.test.school.service.SchoolService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SchoolServiceImpl implements SchoolService {
    @Autowired
    private SchoolRepo schoolRepo;
    @Autowired
    private StudentClient studentClient;
    @Override
    public School create(School school) {
        return this.schoolRepo.save(school);
    }

    @Override
    public School get(Integer id) {
        return this.schoolRepo.findById(id).get();
    }

    @Override
    public List<School> getAll() {
        return this.schoolRepo.findAll();
    }

    @Override
    public void deleted(Integer id) {
        this.schoolRepo.deleteById(id);
    }

    @Override
    public FullSchoolWithStudents getListOfStudentsFromSchool(Integer schoolId) {
        School school = this.schoolRepo.findById(schoolId).orElse(School.builder()
                .name("NOT_FOUND").build());

        //Now need the List<Student> from student microservice...we need to link them together
        //1. creating an endpoint in controller of student microservice findAllStudents-controller,findAllStudentsBySchool-service,findAllBySchoolId-Repo
       // @GetMapping("/school/{schoolId}")

        /* 2. Add dependency "openFeign" in School microservice--for communicating API external or third party or distant
        * for that create a package and interface StudentClient
        *  */
        var students= studentClient.findAllStudentsBySchool(schoolId);
        return FullSchoolWithStudents.builder()
                .name(school.getName())
                .students(students)
                .build();
    }
}
