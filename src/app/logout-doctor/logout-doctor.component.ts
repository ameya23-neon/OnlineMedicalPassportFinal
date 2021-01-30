import { Component, OnInit } from '@angular/core';
import { AuthenticationDoctorService } from '../service/authentication-doctor.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-logout-doctor',
  templateUrl: './logout-doctor.component.html',
  styleUrls: ['./logout-doctor.component.css']
})
export class LogoutDoctorComponent implements OnInit {

  constructor(private authentocationService: AuthenticationDoctorService,
    private router: Router) { }

  ngOnInit(): void {
    this.authentocationService.logOut();
    this.router.navigate(['logindoctors']);
  }

}
