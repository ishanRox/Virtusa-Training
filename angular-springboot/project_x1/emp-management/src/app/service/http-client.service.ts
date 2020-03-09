import { Injectable } from "@angular/core";
import { HttpClient, HttpHeaders } from "@angular/common/http";

export class Employee {
  constructor(
    public empId: string,
    public name: string,
    public designation: string,
    public salary: string,
  ) {

  }
}

@Injectable({
  providedIn: "root"
})
export class HttpClientService {
  constructor(private httpClient: HttpClient) {
  }

  //create karapu httpclient instance eka aran eken request yawanawa 
  //ena response eka ethanama format karanawa

  // username = 'ishan';
  // password = 'password';



  getEmp() {
    // const headers = new HttpHeaders({ Authorization: 'Basic ' + btoa(this.username + ':' + this.password) });

    console.log("test call");
    return this.httpClient.get<Employee[]>('http://localhost:8080/emp/emp');

  }

  public deleteEmp(employee) {
    //const headers = new HttpHeaders({ Authorization: 'Basic ' + btoa(this.username + ':' + this.password) });

    return this.httpClient.delete<Employee>("http://localhost:8080/emp" + "/" + employee.empId);
  }

  public createEmp(employee) {
    // const headers = new HttpHeaders({ Authorization: 'Basic ' + btoa(this.username + ':' + this.password) });

    return this.httpClient.post<Employee>("http://localhost:8080/emp", employee);
  }
}
