import { Component } from '@angular/core';

@Component({
  selector: 'app-admin-login',
  templateUrl: './admin-login.component.html',
  styleUrls: ['.././app.component.css']
})
export class AdminLoginComponent {

  adminLoginId: number;
  password: string = '';
  constructor() { }

  showDetails() {
    alert(this.adminLoginId + this.password);
  }
}
