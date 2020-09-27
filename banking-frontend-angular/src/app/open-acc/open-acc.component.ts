import { Address, OpenAccount } from './../export-class';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, FormBuilder, Validators } from '@angular/forms';
@Component({
  selector: 'app-open-acc',
  templateUrl: './open-acc.component.html',
  styleUrls: ['./open-acc.component.css']
})
export class OpenAccComponent implements OnInit {

  newAccount : OpenAccount = new OpenAccount();
  resAdd : Address =new Address();
  perAdd : Address =new Address();

  constructor() { }
  openAccForm: FormGroup;

  ngOnInit(): void {
  }

}
