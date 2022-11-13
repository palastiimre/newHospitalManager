import {Component, OnInit} from '@angular/core';
import {EmployeeService} from "../services/employee.service";
import {FormBuilder, Validators} from "@angular/forms";
import {Router} from "@angular/router";

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {

  registrationForm = this.formBuilder.group({
    userName: [null, [Validators.required]],
    firstName: [null, [Validators.required]],
    lastName: [null, [Validators.required]],
    email: [null, [Validators.required]],
    role: [null, [Validators.required]],
    position: [null, [Validators.required]],
    password: [null, [Validators.required]],
    confirmPassword: [null, [Validators.required]],
  });

  constructor(private formBuilder: FormBuilder, private employeeService: EmployeeService,private router: Router) {
  }

  ngOnInit(): void {
  }


  submitRegistration() {
    let employeeFormModel: Partial<any> = this.registrationForm.value;

    console.log(employeeFormModel)

    this.employeeService.registerEmployee(employeeFormModel)
      .subscribe({
        next: (response) => {
          console.log(response)
        },
        error: (error) => {
          console.log(error)
        },
        complete: () => {
          console.log('completed')
          this.router.navigate(['/login'])
        }

      })
  }

}
