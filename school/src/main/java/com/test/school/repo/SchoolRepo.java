package com.test.school.repo;

import com.test.school.entity.School;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolRepo extends JpaRepository<School,Integer> {
}
