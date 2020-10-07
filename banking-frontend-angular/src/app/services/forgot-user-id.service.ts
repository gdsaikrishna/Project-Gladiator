import { CheckOtpStatus } from './../models/check-otp-status';
import { ForgotUserId } from './../models/forgot-user-id';
import { ForgotUserIdStatus } from './../models/forgot-user-id-status';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ForgotUserIdService {

  constructor(private http: HttpClient) { }

  verifyAccountNumberAndFetchUserId(accountNumber: number): Observable<ForgotUserIdStatus> {
    return this.http.get<ForgotUserIdStatus>("http://localhost:9090/account-verification?accountNumber=" + accountNumber);
  }

  verifyOtp(forgotUserId: ForgotUserId): Observable<CheckOtpStatus> {
    let url = "http://localhost:9090/check-otp";
    return this.http.post<CheckOtpStatus>(url, forgotUserId);
  }
}
