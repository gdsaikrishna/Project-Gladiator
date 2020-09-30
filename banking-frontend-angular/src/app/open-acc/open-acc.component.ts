import {Address, OpenAccount } from './../export-class';
import { Component, OnInit } from '@angular/core';
@Component({
  selector: 'app-open-acc',
  templateUrl: './open-acc.component.html',
  styleUrls: ['./open-acc.component.css']
})
export class OpenAccComponent implements OnInit {

  newAccount : OpenAccount = new OpenAccount();
  constructor() { }
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
    //console.log(this.newAccount.netBankingRequirement);
  } 
}