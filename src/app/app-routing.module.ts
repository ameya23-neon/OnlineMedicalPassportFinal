import { ContactusComponent } from './contactus/contactus.component';
import { AboutusComponent } from './aboutus/aboutus.component';
import { ProjectoverviewComponent } from './projectoverview/projectoverview.component';
import { LogoutDoctorComponent } from './logout-doctor/logout-doctor.component';
import { LoginDoctorComponent } from './login-doctor/login-doctor.component';
import { LoginUserComponent } from './login-user/login-user.component';
 import { UsersComponent } from './user/users.component';
import { NgModule, Component } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AddUserComponent } from './add-user/add-user.component';
import { LoginComponent } from './login/login.component';
import { LogoutComponent } from './logout/logout.component';
import { AuthGaurdService } from './service/auth-gaurd.service';
import { DoctorComponent } from './doctor/doctor.component';
import { AddDoctorComponent } from './add-doctor/add-doctor.component';
import { LogoutUserComponent } from './logout-user/logout-user.component';
import { AuthGuarduserService } from './service/auth-guarduser.service';
import { AuthGuarddoctorService } from './service/auth-guarddoctor.service';
const routes: Routes = [
  {path:'users',component: UsersComponent},
  {path:'addusers',component: AddUserComponent},
  { path: 'login', component: LoginComponent },
  { path: 'logout', component: LogoutComponent },
  { path: 'logout', component: LogoutComponent,canActivate:[AuthGaurdService] },
  {path:'doctors',component: DoctorComponent},
  { path:'adddoctors', component: AddDoctorComponent},
  { path:'loginusers',component: LoginUserComponent },
  { path:'logoutusers',component: LogoutUserComponent ,canActivate:[AuthGuarduserService]},
  { path:'logindoctors',component: LoginDoctorComponent },
  { path:'logoutusers',component:LogoutDoctorComponent,canActivate:[AuthGuarddoctorService] },
  { path:'projectoverview',component:ProjectoverviewComponent},
  { path:'aboutus',component:AboutusComponent},
  { path:'contactus',component:ContactusComponent}

];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
