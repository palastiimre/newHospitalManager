package com.hospitalmanager.models;

import com.hospitalmanager.enums.UserRole;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeResponseModel {
    private String userId;
    private String firstName;
    private String lastName;
    private String email;
    private UserRole role;
}
