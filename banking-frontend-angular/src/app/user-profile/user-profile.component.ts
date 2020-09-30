import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
<<<<<<< HEAD
import { FormBuilder } from '@angular/forms';
import { Customer } from '../models/customer';

=======

import { Customer } from './../models/customer';
>>>>>>> abd01a1fe15303ae883e886e69adc9474a84e1fe

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit {

  user=new Customer();

  constructor() { }

  ngOnInit(): void {
  }

}
