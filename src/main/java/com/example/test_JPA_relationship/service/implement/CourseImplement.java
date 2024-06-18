package com.example.test_JPA_relationship.service.implement;

import com.example.test_JPA_relationship.repository.CourseRepository;
import com.example.test_JPA_relationship.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseImplement implements CourseService {
    @Autowired
    private CourseRepository courseRepository;

    @Override
    public void deleteCourse(Long courseId) {
        courseRepository.deleteById(courseId);
    }
}
