import { Component } from '@angular/core';

@Component({
  selector: 'app-track-application',
  templateUrl: './track-application.component.html',
  styleUrls: ['.././app.component.css']
})
export class TrackApplicationComponent {

  serviceRefNo: number;
  submitted: boolean;
  approved: string = 'Y';

  constructor() { }

  onSubmit() {
    // alert(this.serviceRefNo);
    this.submitted = true;
  }

}
