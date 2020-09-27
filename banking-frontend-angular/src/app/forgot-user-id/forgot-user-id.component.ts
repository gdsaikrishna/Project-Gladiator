import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-forgot-user-id',
  templateUrl: './forgot-user-id.component.html',
  styleUrls: ['.././app.component.css']
})
export class ForgotUserIdComponent implements OnInit {

  constructor(private fb:FormBuilder) { }

  ngOnInit(): void {
  }

  forgotUserIdForm=this.fb.group({
    accountNo:['',[Validators.required]],
    otp:['',[Validators.required,Validators.minLength(6),Validators.maxLength]]
  })

}
