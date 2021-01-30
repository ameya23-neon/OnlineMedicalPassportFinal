import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

export class users{
  constructor(
    public user_id:number,
    public firstname:string,
    public middlename:string,
    public lastname:string,
    public dateofbirth:string,
    public bloodgroup:string,
    public gender:string,
    public contactno:string,
    public email:string,
    public password:string,
    public doctorsid:number
    
  ){}
}
@Injectable({
  providedIn: 'root'
})
export class HttpClientService {

  constructor(
    private httpClient:HttpClient
  ) { }
    ListAllUsers()
    {
      
      return this.httpClient.get<users[]>('http://localhost:8080/admin/users');
    }
    public deleteUser(User) {
     
      return this.httpClient.delete<users>("http://localhost:8080/admin/users" + "/"+ User.user_id);
    }
  
    public createUser(User) {
      
      return this.httpClient.post<users>("http://localhost:8080/admin", User);
    }
  }

  