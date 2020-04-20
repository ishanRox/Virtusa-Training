import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { FeedbackComponent, FeedbackViewModel } from './feedback/feedback.component';
import { Quection } from './notes/model/Quection';

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  constructor(private http: HttpClient) {
  }

  public getAllSubject(): Observable<Subject[]> {
    const url = 'http://localhost:8084/api/all';
    let subjects = this.http.get<Subject[]>(url);
    console.log(subjects);
    return subjects;
  }

  sendFeedBack(feedback: FeedbackViewModel): Observable<any> {
    console.log(feedback);
    const url = 'http://localhost:8084/api/feedback';
    return this.http.post(url, feedback);
  }

  saveSubject(subject: Subject): Observable<Subject> {

    const url = 'http://localhost:8084/api/save';
    return this.http.post<Subject>(url, subject);
  }

  deleteNote(id: number): Observable<any> {

    const url = `http://localhost:8084/api/delete/${id}`;
    return this.http.get(url);
  }

  getOneQuections(): Observable<Quection[]> {

    const url = `http://localhost:8084/api/allone`;
    return this.http.get<Quection[]>(url);
  }

  getQuectionsById(id: number): Observable<Quection[]> {

    const url = `http://localhost:8084/api/allone/` + id;
    return this.http.get<Quection[]>(url);
  }

  saveQuection(note: Quection): Observable<any> {

    const url = 'http://localhost:8084/api/saveone';
    return this.http.post<Quection>(url, note);
  }

  deleteQuection(id: number): Observable<any> {

    const url = `http://localhost:8084/api/deleteone/${id}`;
    return this.http.get(url);
  }


}
