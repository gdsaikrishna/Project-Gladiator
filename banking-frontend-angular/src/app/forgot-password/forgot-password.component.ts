import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
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

  /*forgotPasswordForm=this.fb.group({
    userId:['',[Validators.required]],
    otp:['',[Validators.required,Validators.minLength(6),Validators.maxLength(6)]]
  })*/

  onSubmit(){
    this.router.navigate(['/enter-otp']);
    
  }

}
