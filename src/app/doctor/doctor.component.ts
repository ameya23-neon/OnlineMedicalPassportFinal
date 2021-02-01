import { doctors, HttpClient1Service } from './../service/http-client1.service';
import { Component, OnInit } from '@angular/core';
import { HttpClientService } from '../service/http-client.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-doctor',
  templateUrl: './doctor.component.html',
  styleUrls: ['./doctor.component.css']
})
export class DoctorComponent implements OnInit {

  DemoDoctors:doctors[];
  doctor
  searchValue:string;
  constructor(
    private httpClientService:HttpClient1Service,
    private router:Router
  ) { }
    ngOnInit() {
      this.httpClientService.getDoctors().subscribe(
        response =>this.handleSuccessfulResponse(response),
       );
  }
  handleSuccessfulResponse(response)
{
    this.DemoDoctors=response;
    console.log(response)
    
}

deleteDoctor(doctor): void {
  this.httpClientService.deleteDoctor(doctor.doctorsId)
    .subscribe( data => {
      alert("succusfully deleted doctor")
      this.httpClientService.getDoctors().subscribe(
        response=>this.handleSuccessfulResponse(response)
      );
    })
};

}
