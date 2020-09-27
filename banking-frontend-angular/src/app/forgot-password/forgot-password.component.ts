import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-forgot-password',
  templateUrl: './forgot-password.component.html',
  styleUrls: ['.././app.component.css']
})
export class ForgotPasswordComponent implements OnInit {

  constructor(private fb:FormBuilder) { }

  ngOnInit(): void {
  }

  forgotPasswordForm=this.fb.group({
    userId:['',[Validators.required]],
    otp:['',[Validators.required,Validators.minLength(6),Validators.maxLength(6)]]
  })

}
