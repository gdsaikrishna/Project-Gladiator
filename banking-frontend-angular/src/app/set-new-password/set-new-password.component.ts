import { Component, OnInit } from '@angular/core';
import { FormBuilder} from '@angular/forms';
import { passwordValidator} from '../shared/password.validator';


@Component({
  selector: 'app-set-new-password',
  templateUrl: './set-new-password.component.html',
  styleUrls: ['.././app.component.css']
})
export class SetNewPasswordComponent implements OnInit {

  constructor(private fb:FormBuilder) { }

  ngOnInit(): void {
  }

  setNewPasswordForm=this.fb.group({
    password:[''],
    confirmPassword:['']
  },{Validators:passwordValidator});
}
