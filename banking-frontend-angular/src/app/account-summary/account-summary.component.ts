import { Account } from './../models/account';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-account-summary',
  templateUrl: './account-summary.component.html',
  styleUrls: ['./account-summary.component.css']
})
export class AccountSummaryComponent implements OnInit {

  account = 
    new Account(123456, 4567.25, "SAVINGS");

  constructor() { }

  ngOnInit(): void {
  }

}
