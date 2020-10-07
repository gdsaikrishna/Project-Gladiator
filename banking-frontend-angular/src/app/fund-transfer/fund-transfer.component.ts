import { Router } from '@angular/router';
import { TransactionService } from './../services/transaction.service';
import { TransactionDto } from './../models/transaction-dto';
import { Component, OnInit } from '@angular/core';
import { ViewBeneficiaryService } from '../services/view-beneficiary.service';
import { BeneficiaryDetails } from '../models/show-beneficiary';
import { AccountService } from '../services/account.service';
import { AccountSummaryStatus } from '../models/account-summary-status';
import { Transaction } from '../models/transaction';
import { GenerateOtpService } from '../services/generate-otp.service';
import { BnNgIdleService } from 'bn-ng-idle';
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
     private router : Router, private accountService: AccountService,private otpService:GenerateOtpService ,
     private bnIdle: BnNgIdleService) {
      
      this.bnIdle.startWatching(300).subscribe((res) => {
        if(res) {
          console.log("Session Expired");
          this.router.navigate(['session-expired']);
        }
      })
    };
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
        
        sessionStorage.setItem("accountNumber",String(response.accountNumber));
        this.transaction.fromAccountNumber=parseInt(sessionStorage.getItem('accountNumber'));
      }
      else {
        this.error = true;
        this.message = response.statusMessage;
      }
    })
    
  }
  onSubmit(){
    this.transaction.fromAccountNumber=parseInt(sessionStorage.getItem('accountNumber'));
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
        sessionStorage.setItem('transactionStatus',data.statusCode);
        this.router.navigate(['fund-transfer-status']);
        
        
      }
      else{
        sessionStorage.setItem('transactionStatus',data.statusCode);
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

  onClick($event:any){
    $event.preventDefault();
    this.otpService.generateOtp().subscribe(data=>{
      console.log(data);
      if(data.statusCode=="SUCCESS")
      alert("OTP has been sent to your registered Email ID");
      else
      alert("OTP Generation Failed!!Click to try again");
    })
  }

  goToAddBeneficiary($event:any){
    $event.preventDefault();
    this.router.navigate(['add-beneficiary']);
  }


}
