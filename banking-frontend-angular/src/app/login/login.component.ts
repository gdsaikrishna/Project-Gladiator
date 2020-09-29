import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  // loginForm: FormGroup;

  userId: number;
  password: string = '';

  constructor(
    private formBuilder: FormBuilder
  ) { }

  // buildLoginForm(): void {
  //   this.loginForm=this.formBuilder.group({
  //     userId: ['', [Validators.required, Validators.pattern('^\d{6}$')]],
  //     password: ['', Validators.required]
  //   })
  // }

  showDetails(){
    alert(this.userId + this.password);
  }

}
