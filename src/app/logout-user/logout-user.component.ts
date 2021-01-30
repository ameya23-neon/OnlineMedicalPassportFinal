import { Component, OnInit } from '@angular/core';
import { AuthenticationUserService } from '../service/authentication-user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-logout-user',
  templateUrl: './logout-user.component.html',
  styleUrls: ['./logout-user.component.css']
})
export class LogoutUserComponent implements OnInit {

  constructor(private authentocationService: AuthenticationUserService,
    private router: Router) { }

  ngOnInit(): void {
    this.authentocationService.logOut();
    this.router.navigate(['login']);
  }

}
