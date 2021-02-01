import { Component, OnInit } from '@angular/core';
import { AuthenticationDoctorService } from '../service/authentication-doctor.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login-doctor',
  templateUrl: './login-doctor.component.html',
  styleUrls: ['./login-doctor.component.css']
})
export class LoginDoctorComponent implements OnInit {

  username = 'javainuse'
  password = ''
  invalidLogin = false
  constructor(private router: Router,
    private loginservice: AuthenticationDoctorService) { }

  ngOnInit(): void {
  }
  checkLogin() {
     (this.loginservice.authenticate(this.username, this.password)
     .subscribe( data => {
      console.log(data["doctorsId"])
     sessionStorage.setItem("doctordeatails",data["doctorsId"]);
      this.router.navigate(['/doctordeatails'])
     this.invalidLogin = false
   })

     
   ) 
  }
}
{}