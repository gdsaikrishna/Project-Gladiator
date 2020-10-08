import { AdminSearchCustomerStatus } from './../models/admin-search-customer-status';
import { Router } from '@angular/router';
import { AdminApproval } from './../models/admin-approval';
import { AdminService } from './../services/admin.service';
import { Component, OnInit } from '@angular/core';
import { CustomerRequestStatus } from '../models/customer-request-status';
import { BnNgIdleService } from 'bn-ng-idle';

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
  requestsToggle: boolean;
  showApprovalToggle: boolean;
  showSearchToggle: boolean;

  constructor(private adminService: AdminService, private router: Router, private bnIdle: BnNgIdleService) {
    this.bnIdle.startWatching(600).subscribe((res) => {
      if(res) {
        console.log("Session Expired");
        this.router.navigate(['session-expired']);
      }
    })
  }

  ngOnInit(): void {
    this.name = sessionStorage.getItem('adminName');
  }

  showPendingRequests() {
    this.requestsToggle = !this.requestsToggle;
    this.adminService.showPendingRequests().subscribe(response => {
      if (response.statusCode === "SUCCESS")
        this.customerRequestStatus.customers = response.customers;
      else {
        this.error = true;
        this.message = response.statusMessage;
      }
    })
  }

  showApprovalForm() {
    this.showApprovalToggle = !this.showApprovalToggle;
  }

  showSearchForm() {
    this.showSearchToggle = !this.showSearchToggle;
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
