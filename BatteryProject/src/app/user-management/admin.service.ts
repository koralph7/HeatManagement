import { Injectable } from '@angular/core';
import { GlobalVariable } from '../shared/global';
import { HttpClient } from '@angular/common/http';
import { Observable, BehaviorSubject } from 'rxjs';
import { User } from '../user/user.model';
@Injectable({
    providedIn: 'root'
  })
export class AdminService {

    private idSubject = new BehaviorSubject(2);
  currentMessage = this.idSubject.asObservable();



  

    private baseApiUrl = GlobalVariable.BASE_API_URL;

    constructor(private http:HttpClient){}

    getUsers(userid: string):Observable<any>{

        return this.http.get<any>(this.baseApiUrl+"/admin/all/" +userid);
       
    }

    changeMessage(id: number) {
        this.idSubject.next(id)
      }
    

      editUser(userId: number, user:User){
        
    return this.http.put(this.baseApiUrl+"/admin/updateUser/" + userId, user);
    }



    getUser(id:number): Observable<any> {

        return this.http.get(this.baseApiUrl+"/admin/getUser/" + id );
    
    }

    deleteUser(id: number){

      return this.http.delete(this.baseApiUrl+"/admin/" + id);
  
  }

}