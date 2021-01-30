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
    if (this.loginservice.authenticate(this.username, this.password)
    ) {
      this.router.navigate([''])
      this.invalidLogin = false
    } else
      this.invalidLogin = true
  }


}
