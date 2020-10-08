import { Beneficiary } from './../models/beneficiary';
import { Component, OnInit } from '@angular/core';
import{ AddBeneficiaryService} from './../services/add-beneficiary.service'
import { Router } from '@angular/router';
import { BnNgIdleService } from 'bn-ng-idle';

@Component({
  selector: 'app-add-beneficiary',
  templateUrl: './add-beneficiary.component.html',
  styleUrls: ['./add-beneficiary.component.css']
})
export class AddBeneficiaryComponent implements OnInit {

  beneficiary: Beneficiary = new Beneficiary();
  message:string;
  error:boolean;
  statusMessage:string;

  
  constructor(private service:AddBeneficiaryService,private router:Router , private bnIdle: BnNgIdleService ) {
    this.bnIdle.startWatching(300).subscribe((res) => {
      if(res) {
        console.log("Session Expired");
        this.router.navigate(['session-expired']);
      }
    })
   }

  ngOnInit() {
   
  }

  showDetails() {
    this.beneficiary.userId=parseInt(sessionStorage.getItem('userId'));
    this.service.addBeneficiary(this.beneficiary).subscribe(data=>{
      if(data.statusCode==="SUCCESS"){
        this.statusMessage=data.statusMessage;
        document.getElementById("openModalButton").click();
        this.router.navigate(['dashboard']);  
      }
      else{
        this.error=true;
        this.statusMessage=data.statusMessage;
        document.getElementById("openModalButton").click();
      }
    })
    
  }

  
}
