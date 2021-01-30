import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { UsersComponent } from './user/users.component';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { AddUserComponent } from './add-user/add-user.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { LoginComponent } from './login/login.component';
import { LogoutComponent } from './logout/logout.component';
import { FormsModule } from '@angular/forms';
import { BasicauthhttpinterceptorService } from './service/basicauthhttpinterceptor.service';
import { DoctorComponent } from './doctor/doctor.component';
import { AddDoctorComponent } from './add-doctor/add-doctor.component';
import { SearchfilterPipe } from './user/searchfilter.pipe';
import { BsDatepickerModule } from 'ngx-bootstrap/datepicker';
import { LoginUserComponent } from './login-user/login-user.component';
import { LogoutUserComponent } from './logout-user/logout-user.component';
import { LoginDoctorComponent } from './login-doctor/login-doctor.component';
import { LogoutDoctorComponent } from './logout-doctor/logout-doctor.component';
import { ProjectoverviewComponent } from './projectoverview/projectoverview.component';
import { AboutusComponent } from './aboutus/aboutus.component';
import { ContactusComponent } from './contactus/contactus.component';
@NgModule({
  declarations: [
    AppComponent,
    UsersComponent,
    AddUserComponent,
    HeaderComponent,
    FooterComponent,
    LoginComponent,
    LogoutComponent,
    DoctorComponent,
    AddDoctorComponent,
    SearchfilterPipe,
    LoginUserComponent,
    LogoutUserComponent,
    LoginDoctorComponent,
    LogoutDoctorComponent,
    ProjectoverviewComponent,
    AboutusComponent,
    ContactusComponent,

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    BsDatepickerModule.forRoot(),
  ],
  providers: [
    {  
      provide:HTTP_INTERCEPTORS, useClass:BasicauthhttpinterceptorService, multi:true 
    }
  ],
  bootstrap: [AppComponent]
})  
export class AppModule { }
