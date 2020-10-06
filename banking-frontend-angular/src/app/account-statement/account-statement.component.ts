import { Transaction } from './../models/transaction';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-account-statement',
  templateUrl: './account-statement.component.html',
  styleUrls: ['./account-statement.component.css']
})
export class AccountStatementComponent implements OnInit {

  transactions = []
  count: number = 0;

  constructor() { }

  ngOnInit(): void {
  }

}
