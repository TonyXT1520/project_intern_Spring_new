package com.example.test_JPA_relationship.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.checkerframework.checker.units.qual.C;

import java.util.List;

@Entity
@Table(name = "student")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class StudentEntity {
    @Id
    @Column(name = "student_id")
    private Long studentId;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "date_of_birth")
    private String dateOfBirth;

    @Column(name = "gender")
    private String gender;

    @Column(name = "address")
    private String address;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "studentEntity", fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<CourseEntity> courseEntities;
}
