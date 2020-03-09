import { Component, OnInit } from '@angular/core';
import { HttpClientService, Quection } from '../service/http-client.service';

@Component({
  selector: 'app-add-q',
  templateUrl: './add-q.component.html',
  styleUrls: ['./add-q.component.css']
})
export class AddQComponent implements OnInit {
  //template to send quections for spring endpoint
  q: Quection = new Quection(1, "", "", "", "", 1, null, "");
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
