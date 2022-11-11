package com.hospitalmanager.models;

import com.hospitalmanager.enums.UserRole;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class BasedEmployeeModel implements Serializable {

    private static final long serialVersionUID = 4932715387289896978L;
    private Integer id;
    private String userId;
    private String userName;
    private String firstName;
    private String lastName;
    private String email;
    private String encryptedPassword;
    private String emailVerificationToken;
    private Boolean emailVerificationStatus = false;
    private UserRole role;

}
