package com.example.test_JPA_relationship.service;

import com.example.test_JPA_relationship.Entity.CourseEntity;
import com.example.test_JPA_relationship.Entity.StudentEntity;
import com.example.test_JPA_relationship.request.StudentRequest;
import com.example.test_JPA_relationship.response.CourseResponse;
import com.example.test_JPA_relationship.response.StudentResponse;

import java.util.List;

public interface StudentService {
    StudentEntity addStudent(StudentEntity studentEntity);
    StudentResponse updateStudent(Long studentId, StudentRequest studentRequest);
    StudentEntity findStudentById(Long studentId);
    List<StudentEntity> getAllStudents();
    void deleteStudent(Long studentId);
    void updateCourse(Long studentId, List<CourseEntity> courseEntities);
    void deleteCourse(Long courseId);
}
