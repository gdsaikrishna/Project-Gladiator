import { Address, OpenAccount } from './../export-class';
import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
@Component({
  selector: 'app-open-acc',
  templateUrl: './open-acc.component.html',
  styleUrls: ['./open-acc.component.css']
})
export class OpenAccComponent implements OnInit {

  newAccount : OpenAccount = new OpenAccount();
  constructor() { }
  ngOnInit() {
    /*
    this.openAccForm = this.formBuilder.group({
      title: ['', Validators.required],
      firstName: ['', Validators.required],
      //middleName: ['', Validators.required],
      lastName: ['', Validators.required],
      fatherName: ['', Validators.required],
      mobileNo: ['', [Validators.required, Validators.minLength(10), Validators.maxLength(10)]],
      emailId: ['', [Validators.required, Validators.email]],
      aadhaarNo: ['', Validators.required],
      dateOfBirth: ['', Validators.required],
      resAddressLine1: ['', Validators.required],
      resAddressLine2: ['', Validators.required],
      //resLandmark: ['', Validators.required],
      resState: ['', Validators.required],
      resCity: ['', Validators.required],
      resPincode: ['', [Validators.required, Validators.minLength(6), Validators.maxLength(6)]],
      perAddressLine1: ['', Validators.required],
      perAddressLine2: ['', Validators.required],
      //perLandmark: ['', Validators.required],
      perState: ['', Validators.required],
      perCity: ['', Validators.required],
      perPincode: ['', [Validators.required, Validators.minLength(6), Validators.maxLength(6)]],
      occupationType: ['', Validators.required],
      sourceOfIncome: ['', Validators.required],
      //grossAnnualIncome: ['', Validators.required],
      acceptTerms: [false, Validators.requiredTrue]
    });*/
  }


  onSubmit() {
/*
    if (this.openAccForm.invalid) {
      return;
    }

    //this.http.post

*/
  }
}
