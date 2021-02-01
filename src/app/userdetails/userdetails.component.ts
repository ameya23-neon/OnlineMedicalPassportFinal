import { Component, OnInit } from '@angular/core';
import { HttpClientService } from '../service/http-client.service';

@Component({
  selector: 'app-userdetails',
  templateUrl: './userdetails.component.html',
  styleUrls: ['./userdetails.component.css']
})
export class UserdetailsComponent implements OnInit {
userid
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
userId
userdescription
age
  constructor(private httpclient:HttpClientService) { }

  ngOnInit(): void {
    this.userid=sessionStorage.getItem("userdetails")
    this.httpclient.getUser(this.userid).subscribe(data=>
      {
      console.log(data)
      this.user=data[0]
  this.firstname=this.user["firstname"]
  this.middlename=this.user["middlename"]
  this.lastname=this.user["lastname"]
  this.dateofbirth=this.user["dateofbirth"]
  this.bloodgroup=this.user["bloodgroup"]
  this.gender=this.user["gender"]
  this.contactno=this.user["contactno"]
  this.email=this.user["email"]
  this.password=this.user["password"]
  this.doctorsId=this.user["doctorsId"]
  this.userdescription=this.user["userdescription"]
  this.age=this.userdescription["age"]
  console.log(this.user["age"])

    }
      )
  }

}
 