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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id", foreignKey = @ForeignKey(name = "FKs8aqr642dup1oio7xa51t5vw5"))
    @JsonIgnore
    private StudentEntity studentEntity;
}
