import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { GlobalVariable } from '../shared/global';

@Injectable()
export class BatteryService{


    private baseApiUrl = GlobalVariable.BASE_API_URL;
    
constructor(private http:HttpClient){}


getBatteries(username:string):Observable<any>{

    return this.http.get<any>(this.baseApiUrl+"/battery/all/"+username);
   
}

}