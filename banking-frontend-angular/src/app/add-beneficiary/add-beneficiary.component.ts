import { Beneficiary } from './../models/beneficiary';
import { Component, OnInit } from '@angular/core';
import{ AddBeneficiaryService} from './../services/add-beneficiary.service'
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-beneficiary',
  templateUrl: './add-beneficiary.component.html',
  styleUrls: ['./add-beneficiary.component.css']
})
export class AddBeneficiaryComponent implements OnInit {

  beneficiary: Beneficiary = new Beneficiary();
  message:string;
  error:boolean;
  
  constructor(private service:AddBeneficiaryService,private router:Router) { }

  ngOnInit() {
   
  }

  showDetails() {
    this.beneficiary.userId=parseInt(sessionStorage.getItem('userId'));
    this.service.addBeneficiary(this.beneficiary).subscribe(data=>{
      console.log(data);
      if(data.statusCode==="SUCCESS")
        this.router.navigate(['dashboard']);  
      else{
        console.log(data.statusMessage);
        this.error=true;
        this.message=data.statusMessage;
      }
    })
    
  }
}
