import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';

import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
// import { VirtualScrollModule } from 'angular2-virtual-scroll';

import { FullCalendarModule} from '@fullcalendar/angular';

import { DatePipe } from '@angular/common'
import { JwtHelperService, JWT_OPTIONS  } from '@auth0/angular-jwt';
import { httpInterceptorProviders } from './auth/auth-interceptor';
import { UserComponent } from './user/user.component';
import { AdminComponent } from './admin/admin.component';
import { PmComponent } from './pm/pm.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { IdSenderService } from './home/idSender.service';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import {LocationStrategy, HashLocationStrategy} from '@angular/common';
import { MatAutocompleteModule } from '@angular/material/autocomplete';
import { MatButtonModule } from '@angular/material/button';
import { MatButtonToggleModule } from '@angular/material/button-toggle';
import { MatCardModule } from '@angular/material/card';
import { MatCheckboxModule } from '@angular/material/checkbox';
import { MatChipsModule } from '@angular/material/chips';
import { MatRippleModule, MatNativeDateModule } from '@angular/material/core';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatDialogModule } from '@angular/material/dialog';
import { MatExpansionModule } from '@angular/material/expansion';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatGridListModule } from '@angular/material/grid-list';
import { MatIconModule } from '@angular/material/icon';
import { MatInputModule } from '@angular/material/input';
import { MatListModule } from '@angular/material/list';
import { MatMenuModule } from '@angular/material/menu';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatProgressBarModule } from '@angular/material/progress-bar';
import { MatProgressSpinnerModule } from '@angular/material/progress-spinner';
import { MatRadioModule } from '@angular/material/radio';
import { MatSelectModule } from '@angular/material/select';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatSlideToggleModule } from '@angular/material/slide-toggle';
import { MatSliderModule } from '@angular/material/slider';
import { MatSnackBarModule } from '@angular/material/snack-bar';
import { MatSortModule } from '@angular/material/sort';
import { MatStepperModule } from '@angular/material/stepper';
import { MatTableModule } from '@angular/material/table';
import { MatTabsModule } from '@angular/material/tabs';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatTooltipModule } from '@angular/material/tooltip';

import { AuthComponent } from './auth/auth.component';
import { ScrollingModule } from '@angular/cdk/scrolling';
import { UserManagementComponent } from './user-management/user-management.component';
import { AdminService } from './user-management/admin.service';
import { UserDetailsComponent } from './user-details/user-details.component';
import { NgxSpinnerModule, NgxSpinnerService } from 'ngx-spinner';
import { LanguageService } from './shared/language.service';

import { BatteryService } from './battery/battery.service';
import { BatteryComponent } from './battery/battery.component';
import { InfoHubComponent } from './info-hub/info-hub.component';
import { InfoHubService } from './info-hub/infoHub.service';
// import { NgxSpinnerModule } from 'ngx-spinner';

// import {MatDatepickerModule,MatNativeDateModule} from '@angular/material';


@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    UserComponent,
    AdminComponent,
    PmComponent,
    LoginComponent,
    RegisterComponent,
    AuthComponent,
   BatteryComponent,
    UserManagementComponent,
    UserDetailsComponent,
    InfoHubComponent
    
  ],
  
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ScrollingModule,
    FullCalendarModule,
    // VirtualScrollModule,
    BrowserAnimationsModule,
    MatDatepickerModule,
    MatNativeDateModule,
    MatFormFieldModule,
    MatInputModule,
    MatIconModule,
    MatAutocompleteModule,
  MatButtonModule,
  MatButtonToggleModule,
  MatCardModule,
  MatCheckboxModule,
  MatChipsModule,
  MatDatepickerModule,
  MatDialogModule,
  MatExpansionModule,
  MatGridListModule,
  MatIconModule,
  MatInputModule,
  MatListModule,
  MatMenuModule,
  BrowserAnimationsModule,
  MatNativeDateModule,
  MatPaginatorModule,
  MatProgressBarModule,
  MatProgressSpinnerModule,
  MatRadioModule,
  MatRippleModule,
  MatSelectModule,
  MatSidenavModule,
  MatSliderModule,
  MatSlideToggleModule,
  MatSnackBarModule,
  MatSortModule,
  MatTableModule,
  MatTabsModule,
  MatToolbarModule,
  MatTooltipModule,
  MatStepperModule,
  NgxSpinnerModule,
   
    
  ],
  
  providers: [InfoHubService, BatteryService, AdminService, NgxSpinnerService,  DatePipe,  httpInterceptorProviders, { provide: JWT_OPTIONS, useValue: JWT_OPTIONS },
    JwtHelperService, IdSenderService, LanguageService,  {provide: LocationStrategy, useClass: HashLocationStrategy}],
  bootstrap: [AppComponent]
})
export class AppModule { }
