import { Router } from '@angular/router';
import { AdminStatus } from './../models/admin-status';
import { AdminService } from './../services/admin.service';
import { AdminLogin } from './../models/admin-login';
import { Component } from '@angular/core';

@Component({
  selector: 'app-admin-login',
  templateUrl: './admin-login.component.html',
  styleUrls: ['.././app.component.css']
})
export class AdminLoginComponent {

  adminLogin: AdminLogin=new AdminLogin();
  adminLoginStatus: AdminStatus=new AdminStatus();
  message: string;

  constructor(private adminService: AdminService, private router: Router) { }

  loginCheck() {
    this.adminService.login(this.adminLogin).subscribe(response => {
      alert(JSON.stringify(response));
      if(response.statusCode === "TRUE"){
        sessionStorage.setItem('adminId', String(response.adminId));
        sessionStorage.setItem('adminName', response.name);
        this.router.navigate(['admin-dashboard']);
      }
      else{
        this.message=response.statusMessage;
      }
    })
  }
}
