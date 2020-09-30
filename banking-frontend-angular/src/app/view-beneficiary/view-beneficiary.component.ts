import { Beneficiary } from './../export-class';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-view-beneficiary',
  templateUrl: './view-beneficiary.component.html',
  styleUrls: ['./view-beneficiary.component.css']
})
export class ViewBeneficiaryComponent implements OnInit {

  beneficiaries: Beneficiary[] = [
    { name: "Joey Tribbiani", accountNumber: 4545454, nickName: "Joe" },
    { name: "Michael Scott", accountNumber: 7895454, nickName: "Mike" },
    { name: "Alexandra Daddario", accountNumber: 7845478, nickName: "" }
  ];

  constructor() { }

  ngOnInit(): void {
  }

}
