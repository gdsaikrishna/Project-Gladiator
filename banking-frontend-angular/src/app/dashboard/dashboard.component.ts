import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css', '.././app.component.css']
})
export class DashboardComponent implements OnInit {

  name: string ;
  
  constructor() { }

  ngOnInit(): void {
    this.name=sessionStorage.getItem('userName');
  }

}
