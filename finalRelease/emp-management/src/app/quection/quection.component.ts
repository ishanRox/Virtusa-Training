import { Component, OnInit } from '@angular/core';
import { Quection, HttpClientService, Answer } from '../service/http-client.service';

@Component({
  selector: 'app-quection',
  templateUrl: './quection.component.html',
  styleUrls: ['./quection.component.css']
})
export class QuectionComponent implements OnInit {

  quections: Quection[];
  answers: Answer[]
  constructor(
    private httpClientService: HttpClientService
  ) { }

  ngOnInit() {
    this.httpClientService.getQ().subscribe(
      response => this.handleSuccessfulResponse(response)
    );
  }

  handleSuccessfulResponse(response) {
    this.quections = response;
  }

  //methanata call eka enne 
  //service ekata kiyanawa delete karana emp kenek id eken
  //EEE emp wa filter karala api list eka update karanawa
  deleteQ(quection: Quection): void {
    this.httpClientService.deleteQ(quection)
      .subscribe(data => {
        console.log(data);
        this.quections = this.quections.filter(u => u !== quection)
      })
  };

}
