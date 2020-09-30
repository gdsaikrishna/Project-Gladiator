import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Customer } from '../models/customer';


@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  constructor(private http: HttpClient) { }

  openAcc(customer: Customer) :Observable<any>{
    return this.http.post<any>('http://localhost:9191/openAccount',customer);
  }

  
}
