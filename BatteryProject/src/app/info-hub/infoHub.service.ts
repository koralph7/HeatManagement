import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { GlobalVariable } from '../shared/global';

@Injectable()
export class InfoHubService{


    private baseApiUrl = GlobalVariable.BASE_API_URL;
    
constructor(private http:HttpClient){}


getInfoHubs(username:string):Observable<any>{

    return this.http.get<any>(this.baseApiUrl+"/infoHub/all/"+username);
   
}

}