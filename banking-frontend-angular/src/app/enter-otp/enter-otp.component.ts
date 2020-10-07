import { NgxSpinnerService } from 'ngx-spinner';
import { ForgotUserIdService } from './../services/forgot-user-id.service';
import { ForgotUserId } from './../models/forgot-user-id';
import { Component } from '@angular/core';

@Component({
  selector: 'app-enter-otp',
  templateUrl: './enter-otp.component.html',
  styleUrls: ['.././app.component.css']
})
export class EnterOtpComponent {

  forgotUserId: ForgotUserId = new ForgotUserId();
  otpIsCorrect: boolean;
  flag: boolean;
  error: boolean;
  message: string;

  constructor(private forgotUserIdService: ForgotUserIdService, private spinnerService: NgxSpinnerService) { }

  verifyOtp() {
    this.forgotUserId.userId = parseInt(sessionStorage.getItem('userId'));
    this.spinnerService.show();
    this.forgotUserIdService.verifyOtp(this.forgotUserId).subscribe(response => {
      if (response.statusCode) {
        this.spinnerService.hide();
        if (response.otp) {
          this.flag = true;
          this.otpIsCorrect = true;
        }
        else {
          this.flag = true;
          this.otpIsCorrect = false;
        }
      }
      else {
        this.spinnerService.hide();
        this.message = response.statusMessage;
        this.error = true;
      }
    })
  }

}
