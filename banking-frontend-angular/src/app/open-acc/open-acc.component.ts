import { CustomerService } from './../services/customer.service';
import { Customer } from './../models/customer';
import { Component, OnInit } from '@angular/core';
import { Address } from '../models/address';
import { Router } from '@angular/router';

@Component({
  selector: 'app-open-acc',
  templateUrl: './open-acc.component.html',
  styleUrls: ['./open-acc.component.css']
})
export class OpenAccComponent implements OnInit {

  newAccount : Customer= new Customer();
  constructor(private customerService: CustomerService , private router: Router) { }
  ngOnInit() {
    this.newAccount.netBankingRequirement="N";
    this.newAccount.debitCardRequirement="N";
    this.newAccount.isApproved="W";
    
  }
  add(e){
    //console.log(e.target.checked);
    if(e.target.checked){
      this.newAccount.perAddress=this.newAccount.resAddress;
      //console.log(JSON.stringify(this.newAccount.perAddress));
      //console.log(this.newAccount.netBankingRequirement);
    }
    else{
      this.newAccount.perAddress=new Address();
    }
  }
  netBanking(e){
    if(e.target.checked){
      this.newAccount.netBankingRequirement="Y";
    }
    else{
      this.newAccount.netBankingRequirement="N";
    }
  }
  debitCard(e){
    if(e.target.checked){
      this.newAccount.debitCardRequirement="Y";
    }
    else{
      this.newAccount.debitCardRequirement="N";
    }
  }

  onSubmit(){
    //call service
    //console.log(JSON.stringify(this.newAccount));
    this.customerService.openAcc(this.newAccount).subscribe(data => {
      console.log(data);
      if(data.statusCode === "SUCCESS"){
        this.router.navigate(['home']);
        alert("Registration Successful and your Service Reference Number is "+data.serviceRefNo);
      }
      else{
        alert("Registration Failed");
      }
    })


  } 
}