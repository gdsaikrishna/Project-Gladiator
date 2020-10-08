import { StatementTransactionDto } from './../models/account-statement';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import {AccountStatementStatus} from './../models/account-statement-status';



@Injectable({
  providedIn: 'root'
})
export class AccountStatementService {

  constructor(private http: HttpClient) { }

  fetchStatement(userId:number):Observable<AccountStatementStatus>{
    return this.http.get<AccountStatementStatus>("http://localhost:9090/account-statement?userId="+userId);
  }
    

  
  
}