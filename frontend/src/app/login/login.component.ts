import { Component, OnInit } from '@angular/core';
import {FormBuilder, Validators} from "@angular/forms";
import {EmployeeService} from "../services/employee.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginForm = this.formBuilder.group({
    email: [null, [Validators.required]],
    password: [null, [Validators.required]],
  });

  constructor(private formBuilder: FormBuilder, private employeeService: EmployeeService,private router: Router) { }

  ngOnInit(): void {  }

  login(){
    let employeeLoginModel: Partial<any> = this.loginForm.value;

    console.log(employeeLoginModel)

    this.employeeService.loginEmployee(employeeLoginModel)
      .subscribe({
        next: (response) => {
          console.log(response)
        },
        error: (error) => {
          console.log(error)
        },
        complete: () => {
          console.log('completed')
          this.router.navigate(['/'])
        }

      })
  }


}
