import { NgxSpinnerService } from 'ngx-spinner';
import { Router } from '@angular/router';
import { ForgotPasswordService } from './../services/forgot-password.service';
import { ForgotPassword } from './../export-class';
import { Component } from '@angular/core';

@Component({
  selector: 'app-forgot-password-otp',
  templateUrl: './forgot-password-otp.component.html',
  styleUrls: ['.././app.component.css']
})
export class ForgotPasswordOtpComponent {

  forgotPassword: ForgotPassword = new ForgotPassword();
  otpIsCorrect: boolean;
  flag: boolean;
  error: boolean;
  message: string;

  constructor(private forgotPasswordService: ForgotPasswordService, private router: Router, private spinnerService: NgxSpinnerService) { }

  verifyOtp() {
    this.forgotPassword.userId = parseInt(sessionStorage.getItem('userId'));
    this.spinnerService.show();
    this.forgotPasswordService.verifyOtp(this.forgotPassword).subscribe(response => {
      this.flag = true;
      if (response.statusCode) {
        this.spinnerService.hide();
        if (response.otp) {
          this.otpIsCorrect = true;
          this.router.navigate(['/set-new-password']);
        }
        else
          this.otpIsCorrect = false;
      }
      else {
        this.spinnerService.hide();
        this.message = response.statusMessage;
        this.error = true;
      }
    })
  }
}
