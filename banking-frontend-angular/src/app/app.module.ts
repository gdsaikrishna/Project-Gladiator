import { HttpClientModule } from '@angular/common/http';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { BnNgIdleService } from 'bn-ng-idle'; 
import { NgxSpinnerModule } from "ngx-spinner";  
import { AppRoutingModule } from './app-routing.module';
import { FormsModule } from '@angular/forms';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { AdminLoginComponent } from './admin-login/admin-login.component';
import { LogoutComponent } from './logout/logout.component';
import { SessionExpiredComponent } from './session-expired/session-expired.component';
import { HomeComponent } from './home/home.component';
import { ForgotUserIdComponent } from './forgot-user-id/forgot-user-id.component';
import { ForgotPasswordComponent } from './forgot-password/forgot-password.component';
import { SetNewPasswordComponent } from './set-new-password/set-new-password.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { FooterComponent } from './footer/footer.component';
import { OpenAccComponent } from './open-acc/open-acc.component';
import { RegisterIbComponent } from './register-ib/register-ib.component';
import { FundTransferComponent } from './fund-transfer/fund-transfer.component';
import { AccountSummaryComponent } from './account-summary/account-summary.component';
import { AccountStatementComponent } from './account-statement/account-statement.component';
import { TrackApplicationComponent } from './track-application/track-application.component';
import { UserProfileComponent } from './user-profile/user-profile.component';
import { ChangePasswordComponent } from './change-password/change-password.component';
import { AddBeneficiaryComponent } from './add-beneficiary/add-beneficiary.component';
import { ViewBeneficiaryComponent } from './view-beneficiary/view-beneficiary.component';
import { EnterOtpComponent } from './enter-otp/enter-otp.component';
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';
import { MustMatchDirective } from './must-match.directive';
import { FundTransferStatusComponent } from './fund-transfer-status/fund-transfer-status.component';
import { BackButtonDisableModule } from 'angular-disable-browser-back-button';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    AdminLoginComponent,
    LogoutComponent,
    SessionExpiredComponent,
    HomeComponent,
    ForgotUserIdComponent,
    ForgotPasswordComponent,
    SetNewPasswordComponent,
    DashboardComponent,
    FooterComponent,
    OpenAccComponent,
    RegisterIbComponent,
    FundTransferComponent,
    AccountSummaryComponent,
    AccountStatementComponent,
    TrackApplicationComponent,
    UserProfileComponent,
    ChangePasswordComponent,
    AddBeneficiaryComponent,
    ViewBeneficiaryComponent,
    EnterOtpComponent,
    AdminDashboardComponent,
    MustMatchDirective,
    FundTransferStatusComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    NgxSpinnerModule,
    BackButtonDisableModule.forRoot({
      preserveScrollPosition: true
    })
  ],
  providers: [BnNgIdleService],
  bootstrap: [AppComponent]
})
export class AppModule { }
