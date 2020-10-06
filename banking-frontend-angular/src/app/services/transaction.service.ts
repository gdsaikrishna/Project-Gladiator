import { TransactionDto } from './../models/transaction-dto';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Status } from '../models/status';
import {TransactionStatus} from '../models/transaction-status'

@Injectable({
  providedIn: 'root'
})
export class TransactionService {

  constructor(private http: HttpClient) { }

  transfer(transactionDto: TransactionDto): Observable<TransactionStatus>{
    return this.http.post<TransactionStatus>('http://localhost:9090/fund-transfer',transactionDto);
  }
}
