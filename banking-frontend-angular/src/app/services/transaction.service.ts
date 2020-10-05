import { TransactionDto } from './../models/transaction-dto';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Status } from '../models/status';

@Injectable({
  providedIn: 'root'
})
export class TransactionService {

  constructor(private http: HttpClient) { }

  transfer(transactionDto: TransactionDto): Observable<Status>{
    return this.http.post<any>('http://localhost:9090/fund-transfer',transactionDto);
  }
}
