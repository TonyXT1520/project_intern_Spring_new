package com.example.test_JPA_relationship.controller;

import com.example.test_JPA_relationship.Entity.CourseEntity;
import com.example.test_JPA_relationship.Entity.StudentEntity;
import com.example.test_JPA_relationship.request.StudentRequest;
import com.example.test_JPA_relationship.response.StudentResponse;
import com.example.test_JPA_relationship.service.CourseService;
import com.example.test_JPA_relationship.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private CourseService courseService;

    @GetMapping("/{id}")
    private StudentEntity findStudentById(@PathVariable("id")Long studentId){
        return studentService.findStudentById(studentId);
    }

    @GetMapping
    private List<StudentEntity> getAllStudent(){
        return studentService.getAllStudents();
    }

    @DeleteMapping("/deleteStudent/{id}")
    private String deteteStudent(@PathVariable("id") Long studentId){
        studentService.deleteStudent(studentId);
        return "Delete successfully";
    }

    @PutMapping("/{id}/course")
    private void updateCourse(@PathVariable("id") Long studentId,@RequestBody List<CourseEntity> courseEntities){
        studentService.updateCourse(studentId, courseEntities);
    }

    @PostMapping("/addStudent")
    public StudentEntity addStudent(@RequestBody StudentEntity studentEntity){
        return studentService.addStudent(studentEntity);
    }

    @PutMapping("/{id}")
    public StudentResponse updateStudent(@PathVariable("id") Long studentId, @RequestBody StudentRequest studentRequest){
        return studentService.updateStudent(studentId, studentRequest);
    }

    @DeleteMapping("/delete/{id}/course")
    public String deleteCourse(@PathVariable("id") Long courseId){
        courseService.deleteCourse(courseId);
        return "Delete Course successfully";
    }
}
