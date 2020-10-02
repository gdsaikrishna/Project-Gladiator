import { RegisterIb } from './../models/register-ib';
import { Component, OnInit } from '@angular/core';
import { UserService } from '../services/user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register-ib',
  templateUrl: './register-ib.component.html',
  styleUrls: ['./register-ib.component.css']
})
export class RegisterIbComponent implements OnInit {
  register: RegisterIb = new RegisterIb();
  model: any = {};
  constructor(private userService: UserService , private router: Router) { }

  ngOnInit(){ }
  onSubmit() {
    this.register.accountNumber=this.model.accountNumber;
    this.register.userPassword=this.model.userPassword;
    this.register.transactionPassword=this.model.transactionPassword;
    //console.log(this.register);
    this.userService.register(this.register).subscribe(data => {
      console.log(data);
      if(data.statusCode === "SUCCESS"){
        this.router.navigate(['home']);
        alert("Registration for Internet Banking Successful. User your Id and password to experience our bank services");
      }
      else{
        alert("Registration for Internet Banking Failed");
      }
    })

  }

}
