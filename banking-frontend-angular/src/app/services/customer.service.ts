import { OpenAccStatus } from './../models/open-acc-status';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Customer } from '../models/customer';


@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  constructor(private http: HttpClient) { }

  openAcc(customer: Customer) :Observable<OpenAccStatus>{
    return this.http.post<any>('http://localhost:9090/openAccount',customer);
  }

  
}
