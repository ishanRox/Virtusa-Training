import { Component, OnInit } from '@angular/core';
import { Employee, HttpClientService } from '../service/http-client.service';

@Component({
  selector: 'app-add-employee',
  templateUrl: './add-employee.component.html',
  styleUrls: ['./add-employee.component.css']
})
export class AddEmployeeComponent implements OnInit {
  //template to send employee for spring endpoint
  user: Employee = new Employee("", "", "", "");

  constructor(
    private httpClientService: HttpClientService
  ) { }

  ngOnInit() {
  }

  createEmployee(): void {
    this.httpClientService.createEmp(this.user)
      .subscribe(data => {
        alert("Employee created successfully.");
      });

  };



}
