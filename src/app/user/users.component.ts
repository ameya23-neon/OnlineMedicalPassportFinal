import { HttpClientService, users } from '../service/http-client.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})
export class UsersComponent implements OnInit {

  Demousers:users[]
  user
  searchValue:string;
  constructor(
    private httpClientService:HttpClientService,
    private router:Router
  ) { }

  ngOnInit() {
    this.httpClientService.ListAllUsers().subscribe(
      response=>this.handleSuccessfulResponse(response)
    );
  }
  handleSuccessfulResponse(response)
{
  this.Demousers=response;
}
deleteUser(user): void {
  this.httpClientService.deleteUser(user.usersId)
  .subscribe(data=>{
    alert("Successfully Deleted")
    this.httpClientService.ListAllUsers().subscribe(
      response=>this.handleSuccessfulResponse(response)
    );
  })


  
};
}
