import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-enter-otp',
  templateUrl: './enter-otp.component.html',
  styleUrls: ['.././app.component.css']
})
export class EnterOtpComponent implements OnInit {

  otp:number;

  constructor() { }

  ngOnInit(): void {
  }

}
