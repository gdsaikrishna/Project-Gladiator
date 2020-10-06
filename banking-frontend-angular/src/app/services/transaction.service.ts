import { TransactionDto } from './../models/transaction-dto';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Status } from '../models/status';
import {TransactionSuccessfulDto} from '../models/transaction-status'

@Injectable({
  providedIn: 'root'
})
export class TransactionService {

  constructor(private http: HttpClient) { }

  transfer(transactionDto: TransactionDto): Observable<TransactionSuccessfulDto>{
    return this.http.post<TransactionSuccessfulDto>('http://localhost:9090/fund-transfer',transactionDto);
  }
}
