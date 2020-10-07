import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Status } from '../models/status';

@Injectable({
  providedIn: 'root'
})
export class GenerateOtpService {

  userId:number;

  constructor(private http:HttpClient) { }

  generateOtp():Observable<Status>{
    this.userId=parseInt(sessionStorage.getItem('userId'));
   return this.http.get<Status>("http://localhost:9090/generate-otp?userId="+this.userId);
  }

  generateOtpBanking(userId: number):Observable<Status>{
   return this.http.get<Status>("http://localhost:9090/generate-otp?userId="+userId);
  }
}
