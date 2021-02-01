import { Component, OnInit } from '@angular/core';
import { description, HttpClient2Service } from '../service/httpclient2.service';

@Component({
  selector: 'app-add-description',
  templateUrl: './add-description.component.html',
  styleUrls: ['./add-description.component.css']
})
export class AddDescriptionComponent implements OnInit {
  
  constructor(private httpClientService: HttpClient2Service) { }

  age:number
  height:number
  oxygenLevel
  heartRate
  bloodPressure
  allergies
  medicalhistory
  lastcheckupdate
  upcomingcheckupdate
  usersId
  doctorsId
  ngOnInit(): void {
  }
  
  createDescription(): void{
    const description= 
    {
   
              "age":this.age,
              "height": this.height,
              "oxygenLevel": this.oxygenLevel,
              "heartRate": this.heartRate,
              "bloodPressure": this.bloodPressure,
              "allergies": this.allergies,
              "medicalhistory": this.medicalhistory,
              "lastcheckupdate": this.lastcheckupdate,
              "upcomingcheckupdate": this.upcomingcheckupdate,
    "userdetails":{
      "usersId":this.usersId
    },
      "selectdoctor": {
              "doctorsId": this.doctorsId
           }
    
  
  }


  console.log(description)


    this.httpClientService.createDescription(description)
    .subscribe(response=>
      {
        console.log(response)
        alert("description created successfully.");
      });
  };


  }


