import { RegisterIbComponent } from './register-ib/register-ib.component';
import { AccountSummaryComponent } from './account-summary/account-summary.component';
import { Component, NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AdminLoginComponent } from './admin-login/admin-login.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { ForgotPasswordComponent } from './forgot-password/forgot-password.component';
import { ForgotUserIdComponent } from './forgot-user-id/forgot-user-id.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { LogoutComponent } from './logout/logout.component';
import { SessionExpiredComponent } from './session-expired/session-expired.component';
import { SetNewPasswordComponent } from './set-new-password/set-new-password.component';
import { AccountStatementComponent } from './account-statement/account-statement.component';
import { OpenAccComponent } from './open-acc/open-acc.component';
import { TrackApplicationComponent } from './track-application/track-application.component';
// import { UserProfileComponent } from './user-profile/user-profile.component';
// import { ChangePasswordComponent } from './change-password/change-password.component';

const routes: Routes = [
  { path: '', redirectTo: 'home', pathMatch: 'full' },
  { path: 'home', component: HomeComponent },
  { path: 'login', component: LoginComponent },
  { path: 'admin-login', component: AdminLoginComponent },
  { path: 'logout', component: LogoutComponent },
  { path: 'session-expired', component: SessionExpiredComponent },
  { path: 'forgot-user-id', component: ForgotUserIdComponent },
  { path: 'forgot-password', component: ForgotPasswordComponent },
  { path: 'set-new-password', component: SetNewPasswordComponent },
  { path: 'dashboard', component: DashboardComponent },
  { path: 'account-summary', component: AccountSummaryComponent },
  { path: 'account-statement', component: AccountStatementComponent },
  { path: 'register-ib', component: RegisterIbComponent },
  { path: 'open-acc', component: OpenAccComponent },
  { path: 'track-application', component: TrackApplicationComponent }
  // { path: 'user-profile', component: UserProfileComponent },
  // { path: 'change-password', component: ChangePasswordComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
