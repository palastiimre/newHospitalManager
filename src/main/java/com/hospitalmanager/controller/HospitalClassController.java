package com.hospitalmanager.controller;

import com.hospitalmanager.models.BasedEmployeeModel;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("hospital-class")
public class HospitalClassController {

    @GetMapping()
    public String getHospitalClass() {
        return "get Hospital class was called";
    }

    @PostMapping()
    public String createHospitalClass(@RequestBody BasedEmployeeModel doctorModel) {
        return "create Hospital class";
    }

    @PutMapping()
    public String updateHospitalClass() {
        return "update Hospital class was called";
    }

    @DeleteMapping()
    public String deleteHospitalClass() {
        return "delete Hospital class was called";
    }
}
