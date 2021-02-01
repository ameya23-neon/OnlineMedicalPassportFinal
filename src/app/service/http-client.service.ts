import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

export class users{
  constructor(
    public usersId:number,
    public firstname:string,
    public middlename:string,
    public lastname:string,
    public dateofbirth:string,
    public bloodgroup:string,
    public gender:string,
    public contactno:string,
    public email:string,
    public password:string,
    public doctorsId:number
    
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
    public deleteUser(usersId) {
     
      return this.httpClient.delete("http://localhost:8080/users/"+ usersId);
    }
  
    public createUser(User) {
      
      return this.httpClient.post<users>("http://localhost:8080/admin", User);
    }
    public updateUser(userId,user) {
      
      return this.httpClient.put<users>("http://localhost:8080/users/updateusers/"+ userId,user);
    }

    getUser(userId)
    {    
      return this.httpClient.get('http://localhost:8080/users/'+userId);
    }
  }

  