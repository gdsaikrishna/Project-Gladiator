import { UserLogin } from './../models/user-login';
import { UserService } from './../services/user.service';
import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { NgxSpinnerService } from 'ngx-spinner';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  userLogin:UserLogin = new UserLogin();
  message: string;
  error: boolean;

  constructor(private userService: UserService, private router: Router ,private SpinnerService: NgxSpinnerService) { }

  loginCheck(){
    this.SpinnerService.show();
    this.userService.login(this.userLogin).subscribe(data => {
      console.log(data);
      if(data.statusCode === "SUCCESS"){
        sessionStorage.setItem('userId', String(data.userId));
        sessionStorage.setItem('userName',data.userName);
        this.SpinnerService.hide();  
        this.router.navigate(['account-summary']);
      }
      else{
        this.SpinnerService.hide(); 
        this.error = true;
        this.message = data.statusMessage;

      }
    })
  }
}
