package com.hospitalmanager.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeLoginRequestModel {
    private String email;
    private String password;
}
