import { HttpClientService, users } from '../service/http-client.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})
export class UsersComponent implements OnInit {

  Demousers:users[]
  searchValue:string;
  constructor(
    private httpClientService:HttpClientService
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
deleteUser(Demousers:users): void {
  this.httpClientService.deleteUser(Demousers)
  .subscribe(data=>{
    this.Demousers=this.Demousers.filter(u => u !== Demousers);
  })
};
}
