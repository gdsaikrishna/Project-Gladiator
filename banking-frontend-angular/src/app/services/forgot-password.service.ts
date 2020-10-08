import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ForgotPasswordStatus } from '../models/forgot-password-status';
import { ForgotPassword } from '../export-class';
import { CheckOtpStatus } from '../models/check-otp-status';

@Injectable({
  providedIn: 'root'
})
export class ForgotPasswordService {

  constructor(private http: HttpClient) { }

  verifyUserIdAndSendOtp(userId: number): Observable<ForgotPasswordStatus> {
    return this.http.get<ForgotPasswordStatus>("http://localhost:9090/forgot-password?userId=" + userId);
  }

  verifyOtp(forgotPassword: ForgotPassword): Observable<CheckOtpStatus> {
    let url = "http://localhost:9090/verify-otp";
    return this.http.post<CheckOtpStatus>(url, forgotPassword);
  }
}
