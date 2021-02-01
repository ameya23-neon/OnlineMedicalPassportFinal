import { Component, OnInit } from '@angular/core';
import { AuthenticationUserService } from '../service/authentication-user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login-user',
  templateUrl: './login-user.component.html',
  styleUrls: ['./login-user.component.css']
})
export class LoginUserComponent implements OnInit {

  
  username = 'javainuse'
  password = ''
  invalidLogin = false
  constructor(private router: Router,
    private loginservice: AuthenticationUserService) { }

  ngOnInit(): void {
  }
  checkLogin() {
     (this.loginservice.authenticate(this.username, this.password)
     .subscribe( data => {
       console.log(data["usersId"])
      sessionStorage.setItem("userdetails",data["usersId"]);
       this.router.navigate(['/userdetails'])
      this.invalidLogin = false
    })

      
    ) 
  } 
}
{}