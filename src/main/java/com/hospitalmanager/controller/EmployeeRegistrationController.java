package com.hospitalmanager.controller;

import com.hospitalmanager.models.EmployeeRegistrationRequestModel;
import com.hospitalmanager.models.EmployeeResponseModel;
import com.hospitalmanager.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/registration")
public class EmployeeRegistrationController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces =MediaType.APPLICATION_JSON_VALUE )
    public EmployeeResponseModel employeeRegistration(@RequestBody EmployeeRegistrationRequestModel newEmployee) throws Exception {
        return employeeService.registration(newEmployee);
    }
}
