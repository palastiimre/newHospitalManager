import {Injectable} from '@angular/core';
import {environment} from "../../environments/environment";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {EmployeeRegistrationRequestModel} from "../models/EmployeeRegistrationRequestModel";

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {
  private REGISTRATION_URL = environment.apiUrl + 'api/registration';
  private LOGIN_URL = environment.apiUrl + 'login';

  constructor(private http:HttpClient) {
  }

  registerEmployee(employeeFormModel:EmployeeRegistrationRequestModel):Observable<any>{
    return this.http.post(this.REGISTRATION_URL,employeeFormModel);
  }


  loginEmployee(){

  }
}
