package com.hospitalmanager.controller;


import com.hospitalmanager.interfaces.IEmployeeService;
import com.hospitalmanager.models.EmployeeRegistrationRequestModel;
import com.hospitalmanager.models.EmployeeResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("employees")
public class EmployeeController {

    @Autowired
    IEmployeeService employeeService;

    @GetMapping(value = "/{userId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public EmployeeResponseModel getEmployee(@PathVariable String userId){
        return employeeService.getEmployeeByUserID(userId);
    }

    @PutMapping(value = "/{userId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public EmployeeResponseModel updateEmployee(@PathVariable String userId,@RequestBody EmployeeRegistrationRequestModel employee) throws Exception {
        return employeeService.updateEmployee(userId,employee);
    }

    @DeleteMapping()
    public String deleteEmployee() {
        return "delete Employee was called";
    }
}
