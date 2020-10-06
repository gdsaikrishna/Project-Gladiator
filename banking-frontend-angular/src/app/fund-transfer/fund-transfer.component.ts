import { Router } from '@angular/router';
import { TransactionService } from './../services/transaction.service';
import { TransactionDto } from './../models/transaction-dto';
import { Component, OnInit } from '@angular/core';
import { ViewBeneficiaryService } from '../services/view-beneficiary.service';
import { BeneficiaryDetails } from '../models/show-beneficiary';
import { AccountService } from '../services/account.service';
import { AccountSummaryStatus } from '../models/account-summary-status';

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
  userId:number;
  message: string;
  error: boolean;


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
    this.transaction.userId=parseInt(sessionStorage.getItem('userId'));
    this.transactionService.transfer(this.transaction).subscribe( data =>{
      console.log(data);
      if(data.statusCode === "SUCCESS"){
        alert(data.statusMessage);
        this.router.navigate(['account-summary']);
        
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
