import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-paper',
  templateUrl: './paper.component.html',
  styleUrls: ['./paper.component.css']
})
export class PaperComponent implements OnInit {
  public hideSearch = true;
  public test1 = [1, 2, 3, 4];

  constructor() {
  }

  ngOnInit() {
  }


  toggle() {
    this.hideSearch = !this.hideSearch;
  }
}
