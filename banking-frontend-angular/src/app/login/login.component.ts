import { UserLogin } from './../models/user-login';
import { UserService } from './../services/user.service';
import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  userLogin:UserLogin = new UserLogin();

  constructor(private userService: UserService, private router: Router) { }

  // buildLoginForm(): void {
  //   this.loginForm=this.formBuilder.group({
  //     userId: ['', [Validators.required, Validators.pattern('^\d{6}$')]],
  //     password: ['', Validators.required]
  //   })
  // }

  loginCheck(){
    console.log(this.userLogin);
    this.userService.login(this.userLogin).subscribe(data => {
      console.log(data);
      if(data.statusCode === "SUCCESS"){
        sessionStorage.setItem('userId', String(data.userId));
        sessionStorage.setItem('userName',data.userName);
        this.router.navigate(['dashboard']);
      }
      else{
        alert(data.statusMessage);

      }
    })
  }
}
