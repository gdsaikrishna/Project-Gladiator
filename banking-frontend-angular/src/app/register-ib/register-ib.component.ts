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
    this.userService.register(this.register).subscribe(data => {
      console.log(data);
      if(data.statusCode === "SUCCESS"){
        this.router.navigate(['home']);
        alert("Registration for Internet Banking Successful. User your Id and password to experience our bank services");
      }
      else{
        alert(data.statusMessage);
      }
    })

  }
  onClick($event:any){
    $event.preventDefault();
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
    })
  }

}
