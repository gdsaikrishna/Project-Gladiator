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
  statusMessage: string;
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
       
        this.SpinnerService.hide(); 
        this.statusMessage="Registration for Internet Banking Successful.\n User your Id and password to experience our bank services";
        document.getElementById("openModalButton").click();
        this.router.navigate(['home']);
      }
      else{
        this.SpinnerService.hide(); 
        this.statusMessage=data.statusMessage;
        document.getElementById("openModalButton").click();
      }
      this.SpinnerService.hide(); 
    })

  }
  onClick($event:any){
    $event.preventDefault();
    console.log(this.model.userId);
    if(typeof this.model.userId === "undefined" || !this.model.userId){
        this.error=true;
        this.message = "UserId required to generate OTP"
        return;

    }
    this.SpinnerService.show();
    this.otpService.generateOtpBanking(this.model.userId).subscribe(data=>{
      console.log(data);
      if(data.statusCode=="SUCCESS"){
        this.SpinnerService.hide(); 
        this.statusMessage="OTP has been sent to your registered Email ID";
        document.getElementById("openModalButton").click();
      }
      else{
        this.SpinnerService.hide(); 
        this.statusMessage=data.statusMessage;
        document.getElementById("openModalButton").click();
      }
      this.SpinnerService.hide(); 
    })
  }

}
