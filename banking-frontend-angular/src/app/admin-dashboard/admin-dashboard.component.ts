import { AdminSearchCustomerStatus } from './../models/admin-search-customer-status';
import { Router } from '@angular/router';
import { AdminApproval } from './../models/admin-approval';
import { AdminService } from './../services/admin.service';
import { Component, OnInit } from '@angular/core';
import { CustomerRequestStatus } from '../models/customer-request-status';
import { Customer } from '../models/customer';

@Component({
  selector: 'app-admin-dashboard',
  templateUrl: './admin-dashboard.component.html',
  styleUrls: ['./admin-dashboard.component.css', '.././app.component.css']
})
export class AdminDashboardComponent implements OnInit {

  name: string;
  message: string;
  error: boolean;
  approvalStatus: boolean;
  approvalMessage: string;
  customerRequestStatus: CustomerRequestStatus = new CustomerRequestStatus();
  adminApproval: AdminApproval = new AdminApproval();
  serviceReferenceNumber: number;
  searchError: boolean;
  generatedCustomer: AdminSearchCustomerStatus = new AdminSearchCustomerStatus();
  wrongServicerefNo: boolean;
  searched: boolean;

  constructor(private adminService: AdminService, private router: Router) { }

  ngOnInit(): void {
    this.name = sessionStorage.getItem('adminName');
    this.adminService.showPendingRequests().subscribe(response => {
      if (response.statusCode === "SUCCESS")
        this.customerRequestStatus.customers = response.customers;
      else {
        this.error = true;
        this.message = response.statusMessage;
      }
    })
  }

  approve() {
    this.adminService.approve(this.adminApproval).subscribe(response => {
      if (response.statusCode === "SUCCESS") {
        this.approvalStatus = true;
        this.approvalMessage = response.statusMessage;
      }
      else {
        this.approvalStatus = true;
        this.approvalMessage = response.statusMessage;
      }
    })
  }

  search() {
    this.adminService.searchCustomerByServRefNo(this.serviceReferenceNumber).subscribe(response => {
      if (response.statusCode === "SUCCESS") {
        this.generatedCustomer.customer = response.customer;
        if (this.generatedCustomer.customer === null)
          this.wrongServicerefNo = true;
        else
          this.searched = true;
      }
      else
        this.searchError = true;
    })
  }

}
