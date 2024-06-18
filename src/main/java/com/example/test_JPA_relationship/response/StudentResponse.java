package com.example.test_JPA_relationship.response;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentResponse {
    private Long studentId;
    private String fullName;
    private String address;
    private String phone;
    private String email;
    private List<CourseResponse> courseResponses;
}
