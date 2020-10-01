import { Beneficiary } from './../models/beneficiary';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-view-beneficiary',
  templateUrl: './view-beneficiary.component.html',
  styleUrls: ['./view-beneficiary.component.css']
})
export class ViewBeneficiaryComponent implements OnInit {

  beneficiaries: Beneficiary[] = [
  ];

  constructor() { }

  ngOnInit(): void {
  }

}
