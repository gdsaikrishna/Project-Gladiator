import { Beneficiary } from './../export-class';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-add-beneficiary',
  templateUrl: './add-beneficiary.component.html',
  styleUrls: ['./add-beneficiary.component.css']
})
export class AddBeneficiaryComponent implements OnInit {

  beneficiary: Beneficiary=new Beneficiary();
  constructor() { }

  ngOnInit(): void {
  }

  showDetails(){
    alert(JSON.stringify(this.beneficiary));
  }
}
