package com.test.school.entity;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
@Builder
public class FullSchoolWithStudents {
    private String name;
    List<Student> students;
}
