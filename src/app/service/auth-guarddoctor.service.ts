import { Injectable } from '@angular/core';
import { AuthenticationDoctorService } from '../service/authentication-doctor.service';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AuthGuarddoctorService implements CanActivate  {

  constructor(private router: Router,
    private authService: AuthenticationDoctorService) { }
    canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
      if (this.authService.isUserLoggedIn())
        return true;
  
      this.router.navigate(['loginusers']);
      return false;
  
    }
}
