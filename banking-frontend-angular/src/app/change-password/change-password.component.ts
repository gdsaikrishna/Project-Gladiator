import { ChangePassword } from './../models/changePassword';
import { Component, OnInit } from '@angular/core';
import { UserService } from '../services/user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-change-password',
  templateUrl: './change-password.component.html',
  styleUrls: ['./change-password.component.css']
})
export class ChangePasswordComponent implements OnInit {
  model: any = {};
  changePassword: ChangePassword= new ChangePassword();
  constructor(private userService: UserService , private router: Router) { }

  ngOnInit(): void {

    
  }
  onSubmit(){
    this.changePassword.userId=parseInt(sessionStorage.getItem('userId'));
    this.changePassword.userPassword=this.model.userPassword;
    this.changePassword.transactionPassword=this.model.transactionPassword;
    this.userService.changePassword(this.changePassword).subscribe(data => {
      console.log(data);
      if(data.statusCode === "SUCCESS"){
        this.router.navigate(['account-summary']);
        alert("Passwords changed successfully");
      }
      else{
        alert(data.statusMessage);
      }
    })
  }

  

}
