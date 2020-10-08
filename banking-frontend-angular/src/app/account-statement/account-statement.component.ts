import { AccountStatementService } from './../services/account-statement.service';
import { StatementTransactionDto } from './../models/account-statement';
import { Component, OnInit } from '@angular/core';
import { AccountSummaryStatus } from '../models/account-summary-status';
import { AccountService } from '../services/account.service';

@Component({
  selector: 'app-account-statement',
  templateUrl: './account-statement.component.html',
  styleUrls: ['./account-statement.component.css']
})
export class AccountStatementComponent implements OnInit {

  accountstatement: StatementTransactionDto[];
  transactions: TransactionDisplay[] =[];
  userId:number;
  message: string;
  error: boolean;
  accountSummaryStatus: AccountSummaryStatus = new AccountSummaryStatus();

  constructor(private service:AccountStatementService , private accountService: AccountService) { }

  ngOnInit(): void {
    this.userId=parseInt(sessionStorage.getItem('userId'));
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
    this.service.fetchStatement(this.userId).subscribe(data =>{
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
      }
      else
         alert(data.statusMessage);
    })
  }

}

export class TransactionDisplay{

  public accountNumber: number;
	public  amount: number;
	public  transactionType: string;
	public transactionId: number;
	public  remark: string;
  public  dateTime: number;
  public check: string;

}
