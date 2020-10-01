import { AdminStatus } from '../models/admin-status';
import { AdminLogin } from '../models/admin-login';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AdminService {
  adminStatus: Observable<AdminStatus>;

  constructor(private http: HttpClient) { }

  login(adminLogin: AdminLogin): Observable<AdminStatus>{
    console.log(adminLogin.adminId+adminLogin.password);
    let url = "http://localhost:9090/admin-login";
    return this.http.post<AdminStatus>(url, adminLogin);
  }
}
