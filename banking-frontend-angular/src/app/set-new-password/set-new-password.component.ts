import { Component, OnInit } from '@angular/core';
import {  FormBuilder, Validators} from '@angular/forms';

@Component({
  selector: 'app-set-new-password',
  templateUrl: './set-new-password.component.html',
  styleUrls: ['.././app.component.css']
})
export class SetNewPasswordComponent implements OnInit {

  constructor(private fb:FormBuilder) { }

  ngOnInit(): void {
  }
}

