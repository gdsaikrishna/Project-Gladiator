import { Transaction } from './../export-class';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-account-statement',
  templateUrl: './account-statement.component.html',
  styleUrls: ['./account-statement.component.css']
})
export class AccountStatementComponent implements OnInit {

  transactions=[
    new Transaction(1234, 399, "DEBIT", "28-02-2020", "Airtel Recharge"),
    new Transaction(4321, 1237, "DEBIT", "28-02-2020", "Electricity Bill"),
    new Transaction(7894, 456.25, "CREDIT", "28-02-2020", "Paytm Refund")
  ]
  constructor() { }

  ngOnInit(): void {
  }

}
