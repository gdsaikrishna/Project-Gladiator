import { Status } from './../models/status';
import { CustomerRequestStatus } from './../models/customer-request-status';
import { AdminStatus } from '../models/admin-status';
import { AdminLogin } from '../models/admin-login';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AdminApproval } from '../models/admin-approval';

@Injectable({
  providedIn: 'root'
})
export class AdminService {
  adminStatus: Observable<AdminStatus>;

  constructor(private http: HttpClient) { }

  login(adminLogin: AdminLogin): Observable<AdminStatus>{
    let url = "http://localhost:9090/admin-login";
    return this.http.post<AdminStatus>(url, adminLogin);
  }

  showPendingRequests(): Observable<CustomerRequestStatus>{
    let url = "http://localhost:9090/pending-requests";
    return this.http.get<CustomerRequestStatus>(url);
  }

  approve(adminApproval: AdminApproval): Observable<Status>{
    let url = "http://localhost:9090/approve";
    return this.http.put<Status>(url, adminApproval);
  }
}
