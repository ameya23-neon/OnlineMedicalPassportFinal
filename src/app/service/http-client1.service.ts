import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
export class doctors{
  constructor(
    public doctorsId:number,
    public title:string,
    public specialization:string,
    public name:string,
    public email:string,
    public password:string,
    public hospitalname:string,
    public hospitalarea:string,
    public hospitalcity:string,
    public contactno:number


  ) {}
}
@Injectable({
  providedIn: 'root'
})
export class HttpClient1Service {

  constructor(
    private httpClient:HttpClient
  ) { 
     }

     getDoctors()
  {
    console.log("test call");
    return this.httpClient.get<doctors[]>('http://localhost:8080/admin/doctors');
  }
  public deleteDoctor(doctors) {
    return this.httpClient.delete<doctors>("http://localhost:8080/doctors" + "/"+ doctors.doctorsId);
  }

  public createDoctor(doctors) {
    return this.httpClient.post<doctors>("http://localhost:8080/doctors", doctors);
  }
}
