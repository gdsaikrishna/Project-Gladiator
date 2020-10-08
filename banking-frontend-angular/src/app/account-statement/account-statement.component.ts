import { AccountStatementService } from './../services/account-statement.service';
import { StatementTransactionDto } from './../models/account-statement';
import { Transaction } from './../models/transaction';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-account-statement',
  templateUrl: './account-statement.component.html',
  styleUrls: ['./account-statement.component.css']
})
export class AccountStatementComponent implements OnInit {

  accountstatement: StatementTransactionDto[];
  userId:number;

  constructor(private service:AccountStatementService) { }

  ngOnInit(): void {
    this.userId=parseInt(sessionStorage.getItem('userId'));
    this.accountStatement();

    
  }
  accountStatement(){
    this.service.fetchStatement(this.userId).subscribe(data =>{
      if(data.statusCode==="SUCCESS")
      this.accountstatement=data.statementTransaction;
      else
         alert(data.statusMessage);
    })
  }

}
