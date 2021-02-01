import { users } from './../service/http-client.service';
import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'searchfilter'
})
export class SearchfilterPipe implements PipeTransform {

  transform(Demousers:users[],searchValue:string): users[] {
    if(!Demousers || !searchValue){
      return Demousers;
    }
    return Demousers.filter(user => 
      user.usersId.toString().toLocaleLowerCase().includes(searchValue.toLocaleLowerCase()) ||
       user.firstname.toLocaleLowerCase().includes(searchValue.toLocaleLowerCase()) ||
    user.lastname.toLocaleLowerCase().includes(searchValue.toLocaleLowerCase()) ||
    user.contactno.toString().toLocaleLowerCase().includes(searchValue.toLocaleLowerCase())
    );
  }

}
