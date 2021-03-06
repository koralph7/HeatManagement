import { Injectable } from '@angular/core';
import { JwtHelperService } from '@auth0/angular-jwt';

const TOKEN_KEY = 'AuthToken';
const USERNAME_KEY = 'AuthUsername';
const AUTHORITIES_KEY = 'AuthAuthorities';
const EMAIL_KEY = 'AuthEmail';
const ID_KEY = 'AuthId';

@Injectable({
    providedIn: 'root'
  })
export class TokenStorageService {

    private roles: Array<string> = [];
    constructor(public jwtHelp: JwtHelperService) { }

    signOut() {
        window.sessionStorage.clear();
      }
    
      public saveToken(token: string) {
        window.sessionStorage.removeItem(TOKEN_KEY);
        window.sessionStorage.setItem(TOKEN_KEY, token);
      }
    
      public getToken(): string {
        return sessionStorage.getItem(TOKEN_KEY);
      }

      public saveEmail(email: string) {
        window.sessionStorage.removeItem(EMAIL_KEY);
        window.sessionStorage.setItem(EMAIL_KEY, email);
      }
    
      public getEmail(): string {
        return sessionStorage.getItem(EMAIL_KEY);
      }

      public saveId(id: string) {
        window.sessionStorage.removeItem(ID_KEY);
        window.sessionStorage.setItem(ID_KEY, id);
      }
    
      public getId(): string {
        return sessionStorage.getItem(ID_KEY);
      }

      public isAuthenticated(): boolean{
        const token = sessionStorage.getItem(TOKEN_KEY);

        return !this.jwtHelp.isTokenExpired(token);
      }
    
      public saveUsername(username: string) {
        window.sessionStorage.removeItem(USERNAME_KEY);
        window.sessionStorage.setItem(USERNAME_KEY, username);
      }
    
      public getUsername(): string {
        return sessionStorage.getItem(USERNAME_KEY);
      }

      
    
      public saveAuthorities(authorities: string[]) {
        window.sessionStorage.removeItem(AUTHORITIES_KEY);
        window.sessionStorage.setItem(AUTHORITIES_KEY, JSON.stringify(authorities));
      }
    
      public getAuthorities(): string[] {
        this.roles = [];
    
        if (sessionStorage.getItem(TOKEN_KEY)) {
          JSON.parse(sessionStorage.getItem(AUTHORITIES_KEY)).forEach(authority => {
            this.roles.push(authority.authority);
          });
        }
    
        return this.roles;
      }

    

}