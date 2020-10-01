import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Beneficiary } from '../models/beneficiary';
import { AddBeneficiaryStatus} from '../models/add-beneficiary-status'

@Injectable({
  providedIn: 'root'
})
export class AddBeneficiaryService {

  constructor(private http:HttpClient) { }

  addBeneficiary(beneficiary:Beneficiary):Observable<AddBeneficiaryStatus>{
    return this.http.post<AddBeneficiaryStatus>('http://localhost:9090/add-beneficiary',beneficiary);
  }


}
