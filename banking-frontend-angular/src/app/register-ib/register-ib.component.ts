import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-register-ib',
  templateUrl: './register-ib.component.html',
  styleUrls: ['./register-ib.component.css']
})
export class RegisterIbComponent implements OnInit {
  //register object
  registerForm : FormGroup;
  submitted = false;
  constructor(private formBuilder: FormBuilder) { }

  ngOnInit(){
    this.registerForm = this.formBuilder.group({
      acNo: ['', Validators.required],
      loginPassword: ['', Validators.required],
      confirmLoginPassword: ['', Validators.required],
      txPassword: ['', Validators.required],
      confirmTxPassword: ['', Validators.required],
      otp: ['', Validators.required]
    })
  }
  get f() { return this.registerForm.controls; }
  onSubmit() {

    this.submitted = true;

    if (this.registerForm.invalid) {
      return;
    }

    //this.http.post


  }

}
