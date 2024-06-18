package com.example.test_JPA_relationship.request;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentRequest {
    private String fullName;
    private String address;
    private String phone;
    private String email;
    private List<CourseRequest> courseRequests;
}
