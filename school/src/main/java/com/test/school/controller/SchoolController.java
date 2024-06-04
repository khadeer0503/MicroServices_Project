package com.test.school.controller;

import com.test.school.entity.FullSchoolWithStudents;
import com.test.school.entity.School;
import com.test.school.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/v1/school")
public class SchoolController {
    @Autowired
    private SchoolService schoolService;

@PostMapping("/")
    public ResponseEntity<School> createSchool(@RequestBody  School school){
        School schools = this.schoolService.create(school);
        return ResponseEntity.status(HttpStatus.CREATED).body(schools);
    }

    @GetMapping("/")
    public ResponseEntity<List<School>> getAllSchool() {
        List<School> schoolList = this.schoolService.getAll();
        return ResponseEntity.ok(schoolList);
    }

/*getting all student from a school
we cannot directly map the student entity of (student microservice). so, we can create a class of student without @Entity,@Id etc...just using attributes og student class
If we use this ResponseEntity<List<School>> then the School should have a attribute private List<Student>, it would be difficult for us when we are create a only school,
so we can do one thing is that creating an-another Class which same attributes of school and adding extra what we need.
*/
    @GetMapping("/getStudentsFromSchool/{schoolId}")
    public ResponseEntity<FullSchoolWithStudents> getAllStudentsFromSchool(@PathVariable("schoolId") Integer schoolId){
        FullSchoolWithStudents schoolListWithStudents = this.schoolService.getListOfStudentsFromSchool(schoolId);
        return ResponseEntity.ok(schoolListWithStudents);
    }


}
