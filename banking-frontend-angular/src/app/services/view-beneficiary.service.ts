import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { BeneficiaryStatus } from './../models/show-beneficiary-status';
import { BeneficiaryDetails} from './../models/show-beneficiary';
@Injectable({
  providedIn: 'root'
})
export class ViewBeneficiaryService {


  constructor(private http:HttpClient) { }


  showBeneficiary(userId:number):Observable<BeneficiaryStatus>{
     return this.http.get<BeneficiaryStatus>('http://localhost:9090/show-beneficiary?userId='+userId);
  }
}

