import { Component, OnInit } from '@angular/core';
import { HttpClientService, Quection, Answer } from '../service/http-client.service';

@Component({
  selector: 'app-add-q',
  templateUrl: './add-q.component.html',
  styleUrls: ['./add-q.component.css']
})
export class AddQComponent implements OnInit {
  //template to send quections for spring endpoint
  ans: Answer[] = [
    {

      "answerString": "hello how are you"
    },
    {

      "answerString": "hello how are you"
    },
    {

      "answerString": "hello"
    }
  ];

  q: Quection = new Quection(1, "", "", "", "", 1, this.ans, "");
  constructor(
    private httpClientService: HttpClientService
  ) { }

  ngOnInit() {
  }

  createQ(): void {
    this.httpClientService.createQ(this.q)
      .subscribe(data => {
        alert("Quection created successfully.");
      });

  };


}
