import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ForgotUserId } from '../export-class';

@Component({
  selector: 'app-forgot-user-id',
  templateUrl: './forgot-user-id.component.html',
  styleUrls: ['.././app.component.css']
})
export class ForgotUserIdComponent implements OnInit {

  forgotUserId:ForgotUserId=new ForgotUserId();

  constructor(private router:Router) { }

  ngOnInit(): void {
  }

  onSubmit(){
    this.router.navigate(['/enter-otp']);
  }
/*  forgotUserIdForm=this.fb.group({
    accountNo:['',[Validators.required]],
    otp:['',[Validators.required,Validators.minLength(6),Validators.maxLength]]
  })

*/

}
