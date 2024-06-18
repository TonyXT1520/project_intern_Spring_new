package com.example.test_JPA_relationship.repository;

import com.example.test_JPA_relationship.Entity.CourseEntity;
import com.example.test_JPA_relationship.Entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<CourseEntity, Long> {
}
