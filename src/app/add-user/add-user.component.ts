import { HttpClientService,users } from './../service/http-client.service';
import { Component, OnInit } from '@angular/core';
import { doctors } from '../service/http-client1.service';

@Component({
  selector: 'app-add-user',
  templateUrl: './add-user.component.html',
  styleUrls: ['./add-user.component.css']
})
export class AddUserComponent implements OnInit {
  User: users=new users(1,"","","","","","","","","",1);

  constructor(private httpClientService: HttpClientService)
   
  { }

  ngOnInit() {
  }
  createUser(): void{
    this.httpClientService.createUser(this.User)
    .subscribe(response=>
      {
        console.log(response)
        alert("Users created successfully.");
      });
  };

}
