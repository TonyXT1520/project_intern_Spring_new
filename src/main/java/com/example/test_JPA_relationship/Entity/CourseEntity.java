package com.example.test_JPA_relationship.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "course")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class CourseEntity {

    @Id
    @Column(name = "course_id")
    private Long courseId;

    @Column(name = "title")
    private String title;

    @Column(name = "student_id")
    private Long studentId;

    @ManyToOne
    @JoinColumn(name = "student_id")
    @JsonIgnore
    private StudentEntity studentEntity;
}
