import { Component, OnInit, ElementRef, ViewChild } from '@angular/core';
import { ViewBeneficiaryService } from './../services/view-beneficiary.service'
import { BeneficiaryDetails } from './../models/show-beneficiary';
import { jsPDF } from 'jspdf';
import html2canvas from 'html2canvas';
import { Router } from '@angular/router';
//declare var jsPDF: any;
@Component({
  selector: 'app-view-beneficiary',
  templateUrl: './view-beneficiary.component.html',
  styleUrls: ['./view-beneficiary.component.css']
})
export class ViewBeneficiaryComponent implements OnInit {

  beneficiaries: BeneficiaryDetails[];
  userId: number;
  statusMessage: string;

  constructor(private service: ViewBeneficiaryService, private router: Router) { }

  ngOnInit(): void {
    this.userId = parseInt(sessionStorage.getItem('userId'));
    this.showBeneficiary();

  }

  showBeneficiary() {
    this.service.showBeneficiary(this.userId).subscribe(data => {
      if (data.statusCode === "SUCCESS")
        this.beneficiaries = data.beneficiaryDto;
      else {
        this.statusMessage = "No beneficiary exists.Add new beneficiary to enjoy the effortless transfer of money";
        document.getElementById("openModalButton").click();
      }
    })
  }
  public captureScreen() {
    var data = document.getElementById('contentToConvert');
    html2canvas(data).then(canvas => {
      var imgWidth = 208;
      var pageHeight = 295;
      var imgHeight = canvas.height * imgWidth / canvas.width;
      var heightLeft = imgHeight;

      const contentDataURL = canvas.toDataURL('image/png')
      let pdf = new jsPDF('p', 'mm', 'a4'); // A4 size page of PDF  
      var position = 0;
      pdf.addImage(contentDataURL, 'PNG', 0, position, imgWidth, imgHeight)
      pdf.save('beneficiary.pdf'); // Generated PDF   
    });
  }

  onClick($event: any) {
    this.router.navigate(['add-new-beneficiary']);
  }

}
