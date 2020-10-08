import { AccountStatementService } from './../services/account-statement.service';
import { StatementTransactionDto } from './../models/account-statement';
import { Component, OnInit } from '@angular/core';
import { AccountSummaryStatus } from '../models/account-summary-status';
import { AccountService } from '../services/account.service';
import { jsPDF } from 'jspdf';  
import html2canvas from 'html2canvas'; 

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
  public captureScreen()  
  {  
    var data = document.getElementById('contentToConvert');  
    html2canvas(data).then(canvas => {  
      // Few necessary setting options  
      var imgWidth = 208;   
      var pageHeight = 295;    
      var imgHeight = canvas.height * imgWidth / canvas.width;  
      var heightLeft = imgHeight;  
  
      const contentDataURL = canvas.toDataURL('image/png')  
      let pdf = new jsPDF('p', 'mm', 'a4'); // A4 size page of PDF  
      var position = 0;  
      pdf.addImage(contentDataURL, 'PNG', 0, position, imgWidth, imgHeight)  
      pdf.save('beneficiary.pdf'); // Generated PDF   
    });  
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
