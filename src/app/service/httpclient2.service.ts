
  import { DescriptionComponent } from './../description/description.component';
  import { Injectable } from '@angular/core';
  import { HttpClient } from '@angular/common/http';

  export class description{
    constructor(
      public descriptionid:number,
      public age:string,
      public height:string,
      public oxygenLevel:string,
      public heartRate:string,
      public bloodPressure:string,
      public allergies:string,
      public medicalhistory:string,
      public lastcheckupdate:string,
      public upcomingcheckupdate:string,
      public usersId:number,
      public doctorsId:number
    ) {}
  }

  @Injectable({
    providedIn: 'root'
  })
  export class HttpClient2Service {

    constructor(
      private httpClient:HttpClient
    ) { 
      }

      getDescription()
    {
      console.log("test call");
      return this.httpClient.get<description[]>('http://localhost:8080/description');
    }
    public deleteDescription(Description) {
      return this.httpClient.delete<description>("http://localhost:8080/description" + "/"+ Description.userId);
    }
  
    public createDescription(Description) {
      return this.httpClient.post<description>("http://localhost:8080/admin/users/desccription", Description);
    }
  }
  