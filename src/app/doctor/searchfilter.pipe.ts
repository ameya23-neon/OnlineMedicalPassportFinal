import { doctors } from './../service/http-client1.service';
import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'searchfilter'
})
export class SearchfilterPipe implements PipeTransform {

  transform(DemoDoctors:doctors[],searchValue:string): doctors[] {
    if(!DemoDoctors || !searchValue){
      return DemoDoctors;
    }
    return DemoDoctors.filter(doctor => 
      doctor.name.toLocaleLowerCase().includes(searchValue.toLocaleLowerCase()) ||
    doctor.email.toLocaleLowerCase().includes(searchValue.toLocaleLowerCase()) ||
    doctor.contactno.toString().toLocaleLowerCase().includes(searchValue.toLocaleLowerCase())
    );
  }

}

