import { Router } from '@angular/router';
import { TransactionService } from './../services/transaction.service';
import { TransactionDto } from './../models/transaction-dto';
import { Component, OnInit } from '@angular/core';
import { ViewBeneficiaryService } from '../services/view-beneficiary.service';
import { BeneficiaryDetails } from '../models/show-beneficiary';
import { AccountService } from '../services/account.service';
import { AccountSummaryStatus } from '../models/account-summary-status';
import { Transaction } from '../models/transaction';

@Component({
  selector: 'app-fund-transfer',
  templateUrl: './fund-transfer.component.html',
  styleUrls: ['./fund-transfer.component.css']
})
export class FundTransferComponent implements OnInit {

  transaction: TransactionDto = new TransactionDto();
  accountSummaryStatus: AccountSummaryStatus = new AccountSummaryStatus();
  beneficiaries: BeneficiaryDetails[];
  constructor(private service:ViewBeneficiaryService , private transactionService:TransactionService  ,
     private router : Router, private accountService: AccountService) { };
  message: string;
  error: boolean;
  transactionDetails:Transaction=new Transaction();
  userId:number;


  ngOnInit(): void {
    this.userId=parseInt(sessionStorage.getItem('userId'));
    this.showBeneficiary();
    this.accountService.showAccountSummary(this.userId).subscribe(response => {
      if (response.statusCode === "SUCCESS") {
        this.accountSummaryStatus.accountNumber = response.accountNumber;
      }
      else {
        this.error = true;
        this.message = response.statusMessage;
      }
    })
    
  }
  onSubmit(){
    console.log(this.transaction);
    this.transactionService.transfer(this.transaction).subscribe( data =>{
      console.log(data);
      if(data.statusCode === "SUCCESS"){
       
        this.transactionDetails=data.transactionSuccessDto;
        alert(data.statusMessage);
        sessionStorage.setItem('transactionId',String(this.transactionDetails.id));
        sessionStorage.setItem('fromAccountNumber',String(this.transactionDetails.fromAccountNumber));
        sessionStorage.setItem('toAccountNumber',String(this.transactionDetails.toAccountNumber));
        sessionStorage.setItem('remarks',this.transactionDetails.remarks);
        sessionStorage.setItem('transactionAmount',String(this.transactionDetails.amount));
        sessionStorage.setItem('transactionType',this.transactionDetails.transactionType);
        this.router.navigate(['fund-transfer-status']);
        
        
      }
      else{
        alert(data.statusMessage);
      }
    })
  }
  showBeneficiary(){
    this.service.showBeneficiary(this.userId).subscribe(data =>{
      if(data.statusCode==="SUCCESS"){
        this.beneficiaries=data.beneficiaryDto;
        console.log(this.beneficiaries)
      }
      else
        alert(data.statusMessage);
    })
  }

}
