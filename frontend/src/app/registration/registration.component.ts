import { Component, OnInit } from '@angular/core';
import {EmployeeService} from "../services/employee.service";
import {FormGroup} from "@angular/forms";

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {

  constructor(private employeeService: EmployeeService) { }

  ngOnInit(): void {
  }

  submitRegistration(){

  }

}
