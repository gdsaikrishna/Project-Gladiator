import { UserProfileStatus } from '../models/user-profile-status';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UserProfileService {

  constructor(private http: HttpClient) { }

  showUserProfile(userId: number): Observable<UserProfileStatus>{
    let url="http://localhost:9090/user-profile?userId="+userId;
    return this.http.get<UserProfileStatus>(url);
  }
}
