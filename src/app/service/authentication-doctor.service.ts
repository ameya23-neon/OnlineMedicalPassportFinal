import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationDoctorService {

  constructor() { }
  isUserLoggedIn() {
    let user = sessionStorage.getItem('username')
  console.log(!(user === null))
  return !(user === null)
  }
  logOut() {
    sessionStorage.removeItem('username')

    }
  authenticate(username: string, password: string) {
    if (username === "user" && password === "user") {
      sessionStorage.setItem('username', username)
      return true;
    } else {
      return false;
    }
  }

}
