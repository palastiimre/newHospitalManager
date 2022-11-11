package com.hospitalmanager.interfaces;

import com.hospitalmanager.models.EmployeeModel;
import com.hospitalmanager.models.EmployeeRegistrationRequestModel;
import com.hospitalmanager.models.EmployeeResponseModel;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface IEmployeeService extends UserDetailsService {
    EmployeeModel create(EmployeeModel userModel);
    EmployeeResponseModel registration(EmployeeRegistrationRequestModel employeeRegistrationRequestModel) throws Exception;
    EmployeeModel getEmployee(String email) throws Exception;

    EmployeeResponseModel getEmployeeByUserID(String userID);

    EmployeeResponseModel updateEmployee(String id, EmployeeRegistrationRequestModel employee) throws Exception;
}
