import { doctors, HttpClient1Service } from './../service/http-client1.service';
import { Component, OnInit } from '@angular/core';
import { HttpClientService } from '../service/http-client.service';

@Component({
  selector: 'app-doctor',
  templateUrl: './doctor.component.html',
  styleUrls: ['./doctor.component.css']
})
export class DoctorComponent implements OnInit {

  DemoDoctors:doctors[];
  searchValue:string;
  constructor(
    private httpClientService:HttpClient1Service
  ) { }
    ngOnInit() {
      this.httpClientService.getDoctors().subscribe(
        response =>this.handleSuccessfulResponse(response),
       );
  }
  handleSuccessfulResponse(response)
{
    this.DemoDoctors=response;
}
deleteDoctor(DemoDoctors:doctors): any {
  this.httpClientService.deleteDoctor(DemoDoctors)
    .subscribe( data => {
      this.DemoDoctors = this.DemoDoctors.filter(u => u !== DemoDoctors);
    })
};

}
