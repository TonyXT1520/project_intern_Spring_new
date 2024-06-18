package com.example.test_JPA_relationship.service.implement;

import com.example.test_JPA_relationship.Entity.CourseEntity;
import com.example.test_JPA_relationship.Entity.StudentEntity;
import com.example.test_JPA_relationship.repository.StudentRepository;
import com.example.test_JPA_relationship.request.StudentRequest;
import com.example.test_JPA_relationship.response.CourseResponse;
import com.example.test_JPA_relationship.response.StudentResponse;
import com.example.test_JPA_relationship.service.StudentService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
public class StudentImplement implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    private static final Logger logger = Logger.getLogger(StudentService.class.getName());

    @Transactional
    public StudentEntity addStudent(StudentEntity studentEntity) {
        for (CourseEntity courseEntity: studentEntity.getCourseEntities()){
            courseEntity.setStudentEntity(studentEntity);
        }

        return studentRepository.save(studentEntity);
    }

    @Override
    @Transactional
    public StudentResponse updateStudent(Long studentId, StudentRequest studentRequest) {
        StudentEntity studentEntity1 = studentRepository.findById(studentId).orElseThrow(()->new RuntimeException("student not found"));

        logger.info("Existing student fetched: " + studentEntity1);

        studentEntity1.setFullName(studentRequest.getFullName());
        studentEntity1.setAddress(studentRequest.getAddress());
        studentEntity1.setPhone(studentRequest.getPhone());
        studentEntity1.setEmail(studentRequest.getEmail());

        logger.info("Updated student details set: " + studentRequest);

        studentEntity1.getCourseEntities().clear();
        logger.info("Existing courses cleared");
//        for(CourseEntity courseEntity: studentEntity.getCourseEntities()){
//            courseEntity.setStudentEntity(studentEntity1);
//            studentEntity1.getCourseEntities().add(courseEntity);
//        }

//        List<CourseEntity> courseEntities = studentRequest.getCourseRequests().stream().map(courseRequest -> {
//            CourseEntity courseEntity = new CourseEntity();
//            courseEntity.setTitle(courseRequest.getTitle());
//            courseEntity.setStudentEntity(studentEntity1);
//            return courseEntity;
//        }).collect(Collectors.toList());

        //studentEntity1.setCourseEntities(courseEntities);
        //logger.info("New course entities set: " + courseEntities);

        StudentEntity studentEntity = studentRepository.save(studentEntity1);
        logger.info("Update student saved: " + studentEntity);

        return mapToStudentResponse(studentEntity);
    }

    @Override
    public StudentEntity findStudentById(Long studentId) {
        return studentRepository.findById(studentId).orElse(null);
    }

    @Override
    public List<StudentEntity> getAllStudents() {
        return (List<StudentEntity>) studentRepository.findAll();
    }

    @Override
    public void deleteStudent(Long studentId) {
        studentRepository.deleteById(studentId);
    }

    @Transactional
    public void updateCourse(Long studentId, List<CourseEntity> courseEntities) {
        StudentEntity studentEntity = studentRepository.findById(studentId).orElseThrow(()-> new RuntimeException("student not found"));
        studentEntity.getCourseEntities().clear();

        for(CourseEntity courseEntity: courseEntities){
            courseEntity.setStudentEntity(studentEntity);
            studentEntity.getCourseEntities().add(courseEntity);
        }
        studentRepository.save(studentEntity);
    }

    private StudentResponse mapToStudentResponse(StudentEntity studentEntity){

        List<CourseResponse> courseResponses = studentEntity.getCourseEntities().stream()
                .map(courseEntity -> new CourseResponse(courseEntity.getCourseId(),courseEntity.getTitle()))
                .collect(Collectors.toList());
        StudentResponse studentResponse = new StudentResponse();
        studentResponse.setStudentId(studentEntity.getStudentId());
        studentResponse.setFullName(studentEntity.getFullName());
        studentResponse.setAddress(studentEntity.getAddress());
        studentResponse.setPhone(studentEntity.getPhone());
        studentResponse.setEmail(studentEntity.getEmail());
        //studentResponse.setCourseResponses(courseResponses);

        return studentResponse;
    }

    @Override
    public void deleteCourse(Long courseId){
        studentRepository.deleteById(courseId);
    }

}
