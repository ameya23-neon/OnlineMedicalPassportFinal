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
  post(arg0: string, body: { email: string; password: string; }) {
    throw new Error('Method not implemented.');
  }

  constructor(
    private httpClient:HttpClient
  ) { 
     }

     getDoctors()
  {
    console.log("test call");
    return this.httpClient.get<doctors[]>('http://localhost:8080/admin/doctors');
  }
  public deleteDoctor(doctorsId) {
    console.log(doctorsId)
    return this.httpClient.delete("http://localhost:8080/doctors/" +doctorsId);
  }

  public createDoctor(doctors) {
    return this.httpClient.post<doctors>("http://localhost:8080/doctors", doctors);
  }
  getDoctor(doctorsId)
  {    
    return this.httpClient.get('http://localhost:8080/doctors/'+doctorsId);
  }
}
