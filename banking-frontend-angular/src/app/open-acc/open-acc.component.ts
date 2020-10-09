import { CustomerService } from './../services/customer.service';
import { Customer } from './../models/customer';
import { Component, OnInit } from '@angular/core';
import { Address } from '../models/address';
import { Router } from '@angular/router';
declare var $: any;
@Component({
  selector: 'app-open-acc',
  templateUrl: './open-acc.component.html',
  styleUrls: ['./open-acc.component.css']
})
export class OpenAccComponent implements OnInit {

  newAccount : Customer= new Customer();
  statusMessage: string;
  statusCode:string;
  constructor(
    private customerService: CustomerService , private router: Router) { }
  ngOnInit() {
    this.newAccount.netBankingRequirement="N";
    this.newAccount.debitCardRequirement="N";
    this.newAccount.isApproved="W";
    
  }
  add(e){
    if(e.target.checked){
      this.newAccount.perAddress=this.newAccount.resAddress;
  
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
    this.customerService.openAcc(this.newAccount).subscribe(data => {
      if(data.statusCode === "SUCCESS"){
        this.statusCode=data.statusCode;
        this.statusMessage ="Registration Successful ,Service Reference Number is "+data.serviceRefNo;
        document.getElementById("openModalButton").click();
        
        
      }
      else{
        this.statusMessage=data.statusMessage;
        document.getElementById("openModalButton").click();
      }
    })


  } 
  onClick($event:any){
    this.router.navigate(['home']);
  }
}