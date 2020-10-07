import { GenerateOtpService } from './../services/generate-otp.service';
import { ForgotUserIdService } from './../services/forgot-user-id.service';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-forgot-user-id',
  templateUrl: './forgot-user-id.component.html',
  styleUrls: ['.././app.component.css']
})
export class ForgotUserIdComponent implements OnInit {

  model: any = {};
  accountNumber: number;
  message: string;
  error: boolean;
  accountDoesntExist: boolean;

  constructor(private forgotUserIdService: ForgotUserIdService, private router:Router, private generateOtpService: GenerateOtpService) { }

  ngOnInit(): void {
  }

  checkAccountNumber(){
    this.forgotUserIdService.verifyAccountNumberAndFetchUserId(this.model.accountNumber).subscribe(response => {
      if(response.statusCode === "SUCCESS"){
        if(response.accountExists === true){
          sessionStorage.setItem('userId',String(response.userId));
          this.router.navigate(['/enter-otp']);
        }
        else
          this.accountDoesntExist=true;
      }
      else {
        this.error = true;
        this.message = response.statusMessage;
      }
    })
  }

}
