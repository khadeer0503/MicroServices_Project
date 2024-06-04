package com.test.school.service;

import com.test.school.entity.FullSchoolWithStudents;
import com.test.school.entity.School;

import java.util.List;

public interface SchoolService {
    School create(School student);
    School get(Integer id);
    List<School> getAll();
    void deleted(Integer id);

    FullSchoolWithStudents getListOfStudentsFromSchool(Integer schoolId);

}
