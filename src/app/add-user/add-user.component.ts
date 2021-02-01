import { HttpClientService,users } from './../service/http-client.service';
import { Component, OnInit } from '@angular/core';
import { doctors } from '../service/http-client1.service';

@Component({
  selector: 'app-add-user',
  templateUrl: './add-user.component.html',
  styleUrls: ['./add-user.component.css']
})
export class AddUserComponent implements OnInit {


  firstname:string
  middlename:string
  lastname:string
  dateofbirth:string
  bloodgroup:string
  gender:string
  contactno:string
  email:string
  password:string
  doctorsId:number


  //User: users=new users(1,"","","","","","","","","",1);

  constructor(private httpClientService: HttpClientService)
   
  { }

  ngOnInit() {
  }
  createUser(): void{
    const User=
    {
           "firstname": this.firstname,
           "middlename": this.middlename,
           "lastname": this.lastname,
           "email": this.email,
           "password": this.password,
           "contactno": this.contactno,
           "gender": this.gender,
           "bloodgroup": this.bloodgroup,
           "dateofbirth": this.dateofbirth,
               "selecteddoctor": {
               "doctorsId": this.doctorsId
            }
             
     }
    console.log(User)
    this.httpClientService.createUser(User)
    .subscribe(response=>
      {
        console.log(response)
        alert("Users created successfully.");
      });
  };

}
