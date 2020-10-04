import { UserProfileStatus } from './../models/user-profile-status';
import { UserProfileService } from '../services/user-profile.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit {

  userId: number;
  userProfileStatus: UserProfileStatus = new UserProfileStatus();
  message: string;
  error: boolean;

  constructor(private userProfileService: UserProfileService) { }

  ngOnInit(): void {
    this.userId = parseInt(sessionStorage.getItem('userId'));
    this.userProfileService.showUserProfile(this.userId).subscribe(response => {
      if (response.statusCode === "SUCCESS")
        this.userProfileStatus.customer = response.customer;
      else {
        this.error = true;
        this.message = response.statusMessage;
      }
    })
  }

}
