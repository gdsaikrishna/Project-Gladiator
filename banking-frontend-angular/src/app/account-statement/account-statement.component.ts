import { Transaction } from './../export-class';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-account-statement',
  templateUrl: './account-statement.component.html',
  styleUrls: ['./account-statement.component.css']
})
export class AccountStatementComponent implements OnInit {

  transactions = [
    new Transaction(1234, 399, "debit", "28-02-2020",4601, "Airtel Recharge"),
    new Transaction(4321, 1237, "debit", "28-02-2020",3364, "Electricity Bill"),
    new Transaction(7894, 456.25, "credit", "28-02-2020",3820.25, "Paytm Refund")
  ]
  count: number = 0;

  constructor() { }

  ngOnInit(): void {
  }

}
