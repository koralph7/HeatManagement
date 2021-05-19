import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { AuthLoginInfo } from './login-info';
import { SignUpInfo } from './sign-up.info';
import { JwtResponse } from './jwt-response';
import { GlobalVariable } from '../shared/global';

const httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

@Injectable({
    providedIn: 'root'
  })
export class AuthService {

  private baseApiUrl = GlobalVariable.BASE_API_URL;
 
    private loginUrl = this.baseApiUrl+"/api/auth/signin";
    // private loginUrl = "http://localhost:8080/springbootapp/api/auth/signin";
    private signupUrl = this.baseApiUrl+"/api/auth/signup/";

    constructor(private http: HttpClient) {}


    attemptAuth(credentials: AuthLoginInfo): Observable<JwtResponse> {
        return this.http.post<JwtResponse>(this.loginUrl, credentials, httpOptions);
      }
    
      signUp(info: SignUpInfo, userId: string): Observable<string> {
        return this.http.post<string>(this.signupUrl + userId, info, httpOptions);
      }
}