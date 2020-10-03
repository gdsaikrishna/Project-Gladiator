import { TrackApplicationService } from './../services/track-application.service';
import { Component } from '@angular/core';

@Component({
  selector: 'app-track-application',
  templateUrl: './track-application.component.html',
  styleUrls: ['.././app.component.css']
})
export class TrackApplicationComponent {

  serviceRefNo: number;
  status: string;
  submitted: boolean;
  statusMessage: string;
  error: boolean;

  constructor(private trackApplicationService: TrackApplicationService) { }

  checkApplicationStatus() {
    this.trackApplicationService.getApplicationStatus(this.serviceRefNo).subscribe(response => {
      if (response.statusCode === "SUCCESS") {
        this.submitted = true;
        this.status = response.currentStatus;
      }
      else {
        this.error = true;
        this.statusMessage = response.statusMessage;
      }
    })

  }
}