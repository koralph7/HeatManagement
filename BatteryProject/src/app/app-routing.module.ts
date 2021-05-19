import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';

import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';

// import { WorkingSchedNameComponent } from './working-sched-name/working-sched-name.component';

import { UserManagementComponent } from './user-management/user-management.component';
import { AuthGuardService } from './auth/auth-guard.service';
import { UserDetailsComponent } from './user-details/user-details.component';

import { BatteryComponent } from './battery/battery.component';
import { InfoHubComponent } from './info-hub/info-hub.component';

const routes: Routes = [

  { path: '', redirectTo: 'auth/login', pathMatch: 'full' },
  { path: 'home', component: HomeComponent },
 
  { path: 'battery', component: BatteryComponent },
  { path: 'infoHub', component: InfoHubComponent },

 
  { path: 'userManagement', component: UserManagementComponent, canActivate: [AuthGuardService]},

  { path: 'userManagement/:id', component: UserDetailsComponent, canActivate: [AuthGuardService]},
  
  {
    path: 'auth/login',
    component: LoginComponent
},
{
    path: 'signup',
    component: RegisterComponent, canActivate: [AuthGuardService]
},
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
