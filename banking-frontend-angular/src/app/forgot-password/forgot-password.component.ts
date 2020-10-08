import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ForgotPassword } from '../export-class';

@Component({
  selector: 'app-forgot-password',
  templateUrl: './forgot-password.component.html',
  styleUrls: ['.././app.component.css']
})
export class ForgotPasswordComponent implements OnInit {

  forgotPassword:ForgotPassword=new ForgotPassword();
  constructor(private router:Router) { }

  ngOnInit(): void {
  }



  onSubmit(){
    this.router.navigate(['/enter-otp']);
    
  }

}
