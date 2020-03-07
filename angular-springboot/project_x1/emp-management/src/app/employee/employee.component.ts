import { Component, OnInit } from '@angular/core';
import { HttpClientService, Employee } from "../service/http-client.service";

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css']
})
export class EmployeeComponent implements OnInit {

  employees: Employee[];

  constructor(
    private httpClientService: HttpClientService
  ) { }

  ngOnInit() {
    this.httpClientService.getEmp().subscribe(
      response => this.handleSuccessfulResponse(response)
    );
  }

  handleSuccessfulResponse(response) {
    this.employees = response;
  }

  //methanata call eka enne 
  //service ekata kiyanawa delete karana emp kenek id eken
  //EEE emp wa filter karala api list eka update karanawa
  deleteEmployee(employee: Employee): void {
    this.httpClientService.deleteEmp(employee)
      .subscribe(data => {
        console.log(data);
        this.employees = this.employees.filter(u => u !== employee);
      })
  };
}
