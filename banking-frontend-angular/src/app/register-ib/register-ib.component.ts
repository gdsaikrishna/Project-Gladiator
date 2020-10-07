import { RegisterIb } from './../models/register-ib';
import { Component, OnInit } from '@angular/core';
import { UserService } from '../services/user.service';
import { Router } from '@angular/router';
import { NgxSpinnerService } from 'ngx-spinner';
import { GenerateOtpService } from '../services/generate-otp.service';

@Component({
  selector: 'app-register-ib',
  templateUrl: './register-ib.component.html',
  styleUrls: ['./register-ib.component.css']
})
export class RegisterIbComponent implements OnInit {
  register: RegisterIb = new RegisterIb();
  message: string;
  error: boolean;
  model: any = {};
  constructor(private userService: UserService , private router: Router ,private SpinnerService: NgxSpinnerService,
    private otpService:GenerateOtpService) { }

  ngOnInit(){ }
  onSubmit() {
    this.register.userId=this.model.userId;
    this.register.userPassword=this.model.userPassword;
    this.register.transactionPassword=this.model.transactionPassword;
    this.register.otp=this.model.otp;
    //console.log(this.register);
    this.SpinnerService.show();
    this.userService.register(this.register).subscribe(data => {
      console.log(data);
      if(data.statusCode === "SUCCESS"){
        this.router.navigate(['home']);
        this.SpinnerService.hide(); 
        alert("Registration for Internet Banking Successful. User your Id and password to experience our bank services");
      }
      else{
        this.SpinnerService.hide(); 
        alert(data.statusMessage);
      }
      this.SpinnerService.hide(); 
    })

  }
  onClick($event:any){
    $event.preventDefault();
    if(typeof this.model.userId!='undefined' && this.model.userId){
        this.error=true;
        this.message = "UserId required to generate OTP"

    }
    this.SpinnerService.show();
    this.otpService.generateOtpBanking(this.model.userId).subscribe(data=>{
      console.log(data);
      if(data.statusCode=="SUCCESS"){
        this.SpinnerService.hide(); 
        alert("OTP has been sent to your registered Email ID");
      }
      else{
        this.SpinnerService.hide(); 
        alert("OTP Generation Failed!!Click to try again");
      }
      this.SpinnerService.hide(); 
    })
  }

}
