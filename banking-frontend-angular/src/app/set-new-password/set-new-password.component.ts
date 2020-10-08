import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { SetNewPassword} from '../models/set-new-password';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-set-new-password',
  templateUrl: './set-new-password.component.html',
  styleUrls: ['.././app.component.css']
})
export class SetNewPasswordComponent implements OnInit {

  model: any = {};
  statusMessage:string;
  setNewPassword: SetNewPassword= new SetNewPassword();
  constructor(private userService: UserService , private router: Router) { }


  ngOnInit(): void {
  }

  onSubmit(){

    this.setNewPassword.userId=parseInt(sessionStorage.getItem('userId'));
    this.setNewPassword.newPassword=this.model.newPassword;
    this.userService.setNewPassword(this.setNewPassword).subscribe(data => {
      if(data.statusCode === "SUCCESS"){
        this.statusMessage=data.statusMessage;
        document.getElementById("openModalButton").click();
      }
      else{
        alert(data.statusMessage);
      }
    })
  }

  onClick($event:any){
    this.router.navigate(['home']);  
  }

}

