import { Component, OnInit } from '@angular/core';
import { HttpClient1Service } from '../service/http-client1.service';

@Component({
  selector: 'app-doctordetails',
  templateUrl: './doctordetails.component.html',
  styleUrls: ['./doctordetails.component.css']
})
export class DoctordetailsComponent implements OnInit {
  doctorsId   
  doctor  
  title:string
  name:string
  email:string
  password: string
  specialization: string
  hospitalarea: string
  hospitalcity: string
  hospitalname: string
  contactno: string

  constructor(private httpclient:HttpClient1Service) { }

  ngOnInit(): void {

    this.doctorsId=sessionStorage.getItem("doctordetails")
    this.httpclient.getDoctor(this.doctorsId).subscribe(data=>
      {
      console.log(data)
      this.doctor=data[0]
  this.name=this.doctor["name"]
  this.title=this.doctor["title"]
  this.email=this.doctor["email"]
  this.password=this.doctor["password"]
  this.specialization=this.doctor["specialization"]
  this.hospitalcity=this.doctor["hospitalcity"]
  this.hospitalarea=this.doctor["Pune"]
  this.hospitalname=this.doctor["hospitalname"]
  this.contactno=this.doctor["contactno"]
  }

    )
}
}
