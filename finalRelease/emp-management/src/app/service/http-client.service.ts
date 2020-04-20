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


export class Quection {
  id: number;
  constructor(
    id: number,
    subject: string,
    addedBy: string,
    addedDate: string,
    quectionString: string,
    difficulty: number,
    answers: Answer[],
    topic: string
  ) {

  }
}


export class Answer {
  constructor(
    id: number,
    answerString: string
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

  //quection
  getQ() {
    // const headers = new HttpHeaders({ Authorization: 'Basic ' + btoa(this.username + ':' + this.password) });

    console.log("test call for quections");

    return this.httpClient.get<Quection[]>('http://localhost:8080/emp/all');

  }


  public deleteQ(quection: Quection) {
    //const headers = new HttpHeaders({ Authorization: 'Basic ' + btoa(this.username + ':' + this.password) });

    return this.httpClient.delete<Quection>("http://localhost:8080/emp/delete" + "/" + quection.id);
  }

  public createQ(quection) {
    // const headers = new HttpHeaders({ Authorization: 'Basic ' + btoa(this.username + ':' + this.password) });
    console.log("create quection");

    return this.httpClient.post<Quection>("http://localhost:8080/emp/save", quection);
  }

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
