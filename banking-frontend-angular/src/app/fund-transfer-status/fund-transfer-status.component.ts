import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-fund-transfer-status',
  templateUrl: './fund-transfer-status.component.html',
  styleUrls: ['.././app.component.css']
})
export class FundTransferStatusComponent implements OnInit {

  transactionStatus: string;
  transactionId: number;
  fromAccountNumber: number;
  toAccountNumber: number;
  transactionAmount: number;
  transactiontype: string;
  remarks: string;

  constructor() { }

  ngOnInit(): void {
    this.transactionStatus=sessionStorage.getItem('transactionStatus');
    if(this.transactionStatus === "SUCCESS"){
      this.fromAccountNumber=parseInt(sessionStorage.getItem('fromAccountNumber'));
      this.toAccountNumber=parseInt(sessionStorage.getItem('toAccountNumber'));
      this.transactionAmount=parseFloat(sessionStorage.getItem('transactionAmount'));
      this.transactiontype=sessionStorage.getItem('transactionType');
      this.remarks=sessionStorage.getItem('remarks');
    }
  }



}
