import { Router } from '@angular/router';
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
  message: string;

  constructor(private adminService: AdminService, private router: Router) { }

  loginCheck() {
    this.adminService.login(this.adminLogin).subscribe(response => {
      if(response.statusCode === "TRUE"){
        alert(JSON.stringify(response));
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
