package com.hospitalmanager.services;

import com.hospitalmanager.entities.Employee;
import com.hospitalmanager.enums.errormessages.ErrorMessage;
import com.hospitalmanager.exceptions.EmployeeServiceException;
import com.hospitalmanager.interfaces.IEmployeeService;
import com.hospitalmanager.models.BasedEmployeeModel;
import com.hospitalmanager.models.EmployeeModel;
import com.hospitalmanager.models.EmployeeRegistrationRequestModel;
import com.hospitalmanager.models.EmployeeResponseModel;
import com.hospitalmanager.repositories.EmployeeRepository;
import com.hospitalmanager.utils.Utils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class EmployeeService implements IEmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    Utils utils;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public EmployeeModel create(EmployeeModel userModel) {
        return null;
    }

    @Override
    public EmployeeResponseModel registration(EmployeeRegistrationRequestModel newEmployee) throws Exception {
        EmployeeResponseModel returnValue = new EmployeeResponseModel();

        if (newEmployee.getFirstName().isEmpty() || newEmployee.getLastName().isEmpty() || newEmployee.getUserName().isEmpty())
            throw new EmployeeServiceException(ErrorMessage.MISSING_REQUIRED_FIELDS.getErrorMessage());

        checkEmployeeByEmailInDatabase(newEmployee);

        EmployeeModel userDto = mapFromRequestModelToUsedDto(newEmployee);

        Employee employee = mapFromUserModelToUser(userDto);

        generatePublicEmployeeID(employee);
        encodeUserPassword(newEmployee, employee);

        Employee storedEmployee = employeeRepository.save(employee);

        BeanUtils.copyProperties(storedEmployee, returnValue);

        return returnValue;
    }

    @Override
    public EmployeeModel getEmployee(String email) throws Exception {
        Employee employee = employeeRepository.findByEmail(email);

        if (employee == null)
            throw new Exception(ErrorMessage.MISSING_REQUIRED_FIELDS.getErrorMessage());

        EmployeeModel userDto = new EmployeeModel();

        BeanUtils.copyProperties(employee, userDto);
        return userDto;
    }

    @Override
    public EmployeeResponseModel getEmployeeByUserID(String userID) {
        EmployeeResponseModel returnValue = new EmployeeResponseModel();
        EmployeeModel userDto = new EmployeeModel();

        Employee entityFromDB = employeeRepository.findEmployeeByUserId(userID);

        if (entityFromDB == null) {
            throw new UsernameNotFoundException(userID);
        }

        BeanUtils.copyProperties(entityFromDB, userDto);
        BeanUtils.copyProperties(userDto, returnValue);

        return returnValue;

    }

    @Override
    public EmployeeResponseModel updateEmployee(String userID, EmployeeRegistrationRequestModel employee) throws Exception {
        EmployeeResponseModel returnValue = new EmployeeResponseModel();
        BasedEmployeeModel employeeDTO = new BasedEmployeeModel();

        BeanUtils.copyProperties(employee,employeeDTO);

        Employee entityFromDB = employeeRepository.findEmployeeByUserId(userID);

        if (entityFromDB == null) {
            throw new EmployeeServiceException(ErrorMessage.NO_RECORD_FOUND.getErrorMessage());
        }
        //for testing:
        entityFromDB.setFirstName(employee.getFirstName());
        entityFromDB.setLastName(employee.getLastName());

        Employee updatedEmployee = employeeRepository.save(entityFromDB);
        BasedEmployeeModel employeeDTO2 = new BasedEmployeeModel();

        BeanUtils.copyProperties(updatedEmployee,employeeDTO2);
        BeanUtils.copyProperties(employeeDTO2,returnValue);

        return returnValue;
    }

    private void generatePublicEmployeeID(Employee employee) {
        String publicUserId = utils.generateUserId(40);
        employee.setUserId(publicUserId);
    }

    private void encodeUserPassword(EmployeeRegistrationRequestModel newEmployee, Employee employee) {
        employee.setEncryptedPassword(bCryptPasswordEncoder.encode(newEmployee.getPassword()));
    }

    private void checkEmployeeByEmailInDatabase(EmployeeRegistrationRequestModel newEmployee) {
        Employee employeeByEmail = employeeRepository.findByEmail(newEmployee.getEmail());
        if (employeeByEmail != null) throw new RuntimeException("Employee already exists!");
    }

    private Employee mapFromUserModelToUser(EmployeeModel newEmployee) {
        Employee employee = new Employee();
        BeanUtils.copyProperties(newEmployee, employee);
        return employee;
    }

    private EmployeeModel mapFromRequestModelToUsedDto(EmployeeRegistrationRequestModel newEmployee) {
        EmployeeModel userDto = new EmployeeModel();
        BeanUtils.copyProperties(newEmployee, userDto);
        return userDto;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Employee employee = employeeRepository.findByEmail(email);

        if (employee == null) throw new UsernameNotFoundException(email);

        return new User(employee.getEmail(), employee.getEncryptedPassword(), new ArrayList<>());
    }


}
