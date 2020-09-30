import { OpenAccount } from './../export-class';
import { Component, OnInit } from '@angular/core';
@Component({
  selector: 'app-open-acc',
  templateUrl: './open-acc.component.html',
  styleUrls: ['./open-acc.component.css']
})
export class OpenAccComponent implements OnInit {

  newAccount : OpenAccount = new OpenAccount();
  submitted=false;
  constructor() { }
  ngOnInit() {
    
  }
  add(e){
    console.log(e.target.checked);
    if(e.target.checked){
      this.newAccount.perAddress=this.newAccount.resAddress;
      //console.log(JSON.stringify(this.newAccount.perAddress));
    }
  }

  onSubmit(){
    //call service
  } 
}