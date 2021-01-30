import { Injectable } from '@angular/core';
import { AuthenticationUserService } from '../service/authentication-user.service';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AuthGuarduserService implements CanActivate {

  constructor(private router: Router,
    private authService: AuthenticationUserService) { }
    canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
      if (this.authService.isUserLoggedIn())
        return true;
  
      this.router.navigate(['loginusers']);
      return false;
  
    }
  
  }
