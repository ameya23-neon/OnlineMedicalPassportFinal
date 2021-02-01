import { ActivatedRoute } from '@angular/router';
import { HttpClientService,users } from './../service/http-client.service';
import { Component, OnInit } from '@angular/core';
@Component({
  selector: 'app-updateuser',
  templateUrl: './updateuser.component.html',
  styleUrls: ['./updateuser.component.css']
})
export class UpdateuserComponent implements OnInit {

  user
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
  userId:number


  User: users

  constructor(private httpClientService: HttpClientService,
    private activatedRoute:ActivatedRoute)
   
  { }

  ngOnInit() {
    this.activatedRoute.params.subscribe(params => {
      this.userId=params.id}
    )
      this.httpClientService.getUser(this.userId)
      .subscribe(response=>
        {
          this.user=response[0]
  this.firstname=this.user["firstname"]
  this.middlename=this.user["middlename"]
  this.lastname=this.user["lastname"]
  this.dateofbirth=this.user["dateofbirth"]
  this.bloodgroup=this.user["bloodgroup"]
  this.gender=this.user["gender"]
  this.contactno=this.user["contactno"]
  this.email=this.user["email"]
  this.password=this.user["password"]
  this.doctorsId=this.user["selecteddoctor"]["doctorsId"]
        });
    
  }
  updateUser(): void{
    console.log(this.userId)
    this.User=new users(this.userId,this.firstname, this.middlename,this.lastname,this.dateofbirth,this.bloodgroup,this.gender,this.contactno,this.email, this.password,this.doctorsId);
    console.log(users)
    this.httpClientService.updateUser(this.userId,this.User)
    .subscribe(response=>
      {
        alert("Users updated successfully.");
      });
  };





}
