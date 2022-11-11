package com.hospitalmanager.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "classes_employees")
public class ClassesEmployees {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne(targetEntity = Employee.class,fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id",insertable = false,updatable = false,nullable = false)
    private Employee employee;

    @NotNull
    @Column(name = "employee_id")
    private Integer employeeId;

    @ManyToOne(targetEntity = HospitalClass.class,fetch = FetchType.LAZY)
    @JoinColumn(name ="hospital_class_id", insertable = false,updatable = false,nullable = false )
    private HospitalClass hospitalClass;

    @NotNull
    @Column(name = "hospital_class_id")
    private Integer hospitalClassId;


    public void setEmployee(Employee employee) {
        this.employee = employee;
        this.employeeId = employee.getId();
    }

    public void setHospitalClass(HospitalClass hospitalClass) {
        this.hospitalClass = hospitalClass;
        this.hospitalClassId = hospitalClass.getId();
    }
}
