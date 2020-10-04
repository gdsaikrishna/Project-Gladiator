import { AccountSummaryStatus } from './../models/account-summary-status';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AccountService {

  constructor(private http: HttpClient) { }

  showAccountSummary(userId: number): Observable<AccountSummaryStatus>{
    let url="http://localhost:9090/account-summary?userId="+userId;
    return this.http.get<AccountSummaryStatus>(url);
  }
}
