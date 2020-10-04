import { AccountSummaryStatus } from './../models/account-summary-status';
import { AccountService } from './../services/account.service';
import { Account } from './../models/account';
import { Component, OnInit } from '@angular/core';
import { UserProfileStatus } from '../models/user-profile-status';

@Component({
  selector: 'app-account-summary',
  templateUrl: './account-summary.component.html',
  styleUrls: ['./account-summary.component.css']
})
export class AccountSummaryComponent implements OnInit {

  userId: number;
  accountSummaryStatus: AccountSummaryStatus = new AccountSummaryStatus();
  message: string;
  error: boolean;

  constructor(private accountService: AccountService) { }

  ngOnInit(): void {
    this.userId = parseInt(sessionStorage.getItem('userId'));
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
  }

}
