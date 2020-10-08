import { AccountStatementService } from './../services/account-statement.service';
import { StatementTransactionDto,TransactionDisplay } from './../models/account-statement';
import { Component, OnInit } from '@angular/core';
import { AccountSummaryStatus } from '../models/account-summary-status';
import { AccountService } from '../services/account.service';
import {StatementDuration} from '../models/statement-duration';
@Component({
  selector: 'app-account-statement',
  templateUrl: './account-statement.component.html',
  styleUrls: ['./account-statement.component.css']
})
export class AccountStatementComponent implements OnInit {

  statementDuration:StatementDuration=new StatementDuration()

  accountstatement: StatementTransactionDto[];
  transactions: TransactionDisplay[] =[];
  userId:number;
  message: string;
  error: boolean;
  searched:boolean;
  accountSummaryStatus: AccountSummaryStatus = new AccountSummaryStatus();

  constructor(private service:AccountStatementService , private accountService: AccountService) { }

  ngOnInit(): void {
    this.statementDuration.userId=parseInt(sessionStorage.getItem('userId'));
    this.accountService.showAccountSummary(this.userId).subscribe(response => {
      if (response.statusCode === "SUCCESS") {
        this.accountSummaryStatus.accountNumber = response.accountNumber;
        this.accountSummaryStatus.balance = response.balance;
      }
      else {
        this.error = true;
        this.message = response.statusMessage;
      }
    })
    this.accountStatement();

    
  }
  accountStatement(){
    this.service.fetchStatement(this.statementDuration).subscribe(data =>{
      if(data.statusCode==="SUCCESS"){
        console.log(data);
        this.accountstatement=data.statementTransactionDto;
        for(let s of this.accountstatement){
          var t= new TransactionDisplay();
          t.accountNumber = s.fromAccountNumber^s.toAccountNumber^this.accountSummaryStatus.accountNumber;
          t.amount=s.amount;
          if(s.fromAccountNumber === this.accountSummaryStatus.accountNumber)
            t.check="Debit"
          else 
            t.check="Credit"
          t.dateTime=s.dateTime;
          t.remark=s.remark;
          t.transactionId=s.transactionId;
          t.transactionType=s.transactionType;
          this.transactions.push(t);
        }
        this.transactions = this.transactions.sort((a : TransactionDisplay,b: TransactionDisplay) => (a.dateTime > b.dateTime ? -1 : 1));
        this.searched=true;
      }
      else
         alert(data.statusMessage);
    })
  }

}

