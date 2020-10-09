import { AccountSummaryStatus } from './../models/account-summary-status';
import { AccountService } from './../services/account.service';
import { Account } from './../models/account';
import { Component, OnInit } from '@angular/core';
import { UserProfileStatus } from '../models/user-profile-status';
import { BnNgIdleService } from 'bn-ng-idle';
import { Router } from '@angular/router';

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

  constructor(private accountService: AccountService , private bnIdle: BnNgIdleService ,private router: Router) { 
    this.bnIdle.startWatching(1500).subscribe((res) => {
      if(res) {
        console.log("Session Expired");
        this.router.navigate(['session-expired']);
      }
    })
  }

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
