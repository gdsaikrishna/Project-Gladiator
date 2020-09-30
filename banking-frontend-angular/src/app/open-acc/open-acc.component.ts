import { CustomerService } from './../services/customer.service';
import { Customer } from './../models/customer';
import { Component, OnInit } from '@angular/core';
import { Address } from '../models/address';

@Component({
  selector: 'app-open-acc',
  templateUrl: './open-acc.component.html',
  styleUrls: ['./open-acc.component.css']
})
export class OpenAccComponent implements OnInit {

  newAccount : Customer= new Customer();
  constructor(private customerService: CustomerService) { }
  ngOnInit() {
    this.newAccount.netBankingRequirement="N";
    this.newAccount.debitCardRequirement="N";
    
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
      this.newAccount.netBankingRequirement="Y";
    }
    else{
      this.newAccount.netBankingRequirement="N";
    }
  }

  onSubmit(){
    //call service
    //console.log(JSON.stringify(this.newAccount));
    this.customerService.openAcc(this.newAccount).subscribe(response =>{
      alert(JSON.stringify(response));
    })


  } 
}