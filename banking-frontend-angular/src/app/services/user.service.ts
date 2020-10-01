import { UserLoginStatus } from './../models/user-login-status';
import { UserLogin } from './../models/user-login';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) { }

  login(login: UserLogin): Observable<UserLoginStatus>{
    return this.http.post<any>('http://localhost:9191/user-login',login);
  }
}
