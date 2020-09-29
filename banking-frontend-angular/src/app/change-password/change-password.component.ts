import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-change-password',
  templateUrl: './change-password.component.html',
  styleUrls: ['./change-password.component.css']
})
export class ChangePasswordComponent implements OnInit {

  constructor(private fb:FormBuilder) { }

  ngOnInit(): void {
  }

  changePasswordForm=this.fb.group({
    oldPassword:['',Validators.required],
   password:['',Validators.required],
   confirmPassword:['',Validators.required]
 });

}
