import { Component, OnInit } from '@angular/core';
import { ViewBeneficiaryService} from './../services/view-beneficiary.service'
import { BeneficiaryDetails} from './../models/show-beneficiary';

@Component({
  selector: 'app-view-beneficiary',
  templateUrl: './view-beneficiary.component.html',
  styleUrls: ['./view-beneficiary.component.css']
})
export class ViewBeneficiaryComponent implements OnInit {

  beneficiaries: BeneficiaryDetails[];
  userId:number;

  constructor(private service:ViewBeneficiaryService) { }

  ngOnInit(): void {
    this.userId=parseInt(sessionStorage.getItem('userId'));
    this.showBeneficiary();
    
  }

  showBeneficiary(){
    this.service.showBeneficiary(this.userId).subscribe(data =>{
      if(data.statusCode==="SUCCESS")
        this.beneficiaries=data.beneficiaryDto;
      else
        alert(data.statusMessage);
    })
  }

}
