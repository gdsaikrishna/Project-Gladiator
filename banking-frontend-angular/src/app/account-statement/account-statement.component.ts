import { Transaction } from './../models/transaction';
import { Component, OnInit, ElementRef ,ViewChild } from '@angular/core';
import * as jspdf from 'jspdf';  
import html2canvas from 'html2canvas';
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
