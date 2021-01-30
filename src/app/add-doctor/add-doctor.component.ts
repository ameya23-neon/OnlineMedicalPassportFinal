import { Component, OnInit } from '@angular/core';
import { doctors, HttpClient1Service } from '../service/http-client1.service';

@Component({
  selector: 'app-add-doctor',
  templateUrl: './add-doctor.component.html',
  styleUrls: ['./add-doctor.component.css']
})
export class AddDoctorComponent implements OnInit {
  Doctor: doctors = new doctors(1,"","","","","","","","",1);
  constructor(
    private httpClientService: HttpClient1Service
  ) { }

  ngOnInit(): void {
  }
  createDoctor(): void {
    this.httpClientService.createDoctor(this.Doctor)
        .subscribe( data => {
          alert("Doctor created successfully.");
        });
      };
    }

