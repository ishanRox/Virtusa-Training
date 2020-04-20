import {Component, OnInit} from '@angular/core';
import {ApiService} from '../api.service';

@Component({
  selector: 'app-feedback',
  templateUrl: './feedback.component.html',
  styleUrls: ['./feedback.component.css']
})
export class FeedbackComponent implements OnInit {

  model: FeedbackViewModel = {
    name: '',
    email: '',
    feedback: '',

  };

  constructor(private api: ApiService) {
  }

  ngOnInit() {
  }

// feedback component eke thiyena form eken data yawanawa
  sendFeedBack(): void {

    console.log(this.model);
// this.api.sendFeedBack(this.model).subscribe(res => {
//       // location.reload();
//     }, err => {
//       alert('An error has occured');
//     });
  }

}


// for the form
export interface FeedbackViewModel {
  name: string;
  email: string;
  feedback: string;
}
