import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';


@Injectable({
  providedIn: 'root'
})
export class AuthenticationDoctorService {

  constructor(private httpClient:HttpClient) { }
  isUserLoggedIn() {
    let user = sessionStorage.getItem('username')
  console.log(!(user === null))
  return !(user === null)
  }
  logOut() {
    sessionStorage.removeItem('username')

    }
  authenticate(username: string, password: string) {
    const body={"email":username,"password":password}
    return this.httpClient.post("http://localhost:8080/doctors/login",body)
  }

}
