package com.example.test_JPA_relationship.controller;

import com.example.test_JPA_relationship.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @DeleteMapping("/{id}")
    public String deleteCourse(@PathVariable("id") Long courseId){
        courseService.deleteCourse(courseId);
        return "Delete Successfully";
    }
}
