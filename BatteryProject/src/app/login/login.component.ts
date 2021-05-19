import { Component, OnInit } from '@angular/core';
import { AuthLoginInfo } from '../auth/login-info';
import { AuthService } from '../auth/auth.service';
import { TokenStorageService } from '../auth/token-storage.service';
import { Router } from '@angular/router';
import { LanguageService } from '../shared/language.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  lang: string;
  form: any = {};
  isLoggedIn = false;
  isLoginFailed = false;
  errorMessage = '';
  roles: string[] = [];
  private loginInfo: AuthLoginInfo;
  ifEnglish = false;
  constructor(private langServ: LanguageService, private authService: AuthService, private tokenStorage: TokenStorageService, private router: Router) { }

  ngOnInit() {      

    this.lang = "polish"
    console.log(this.lang);
    // if(this.isLoggedIn = true){
    //   this.router.navigate(['home']);
    // }

    //console.log(this.lang);

    if (this.tokenStorage.isAuthenticated()) {
      this.router.navigate(['home']);
    }

    if (this.tokenStorage.getToken()) {
      this.isLoggedIn = true;
      this.roles = this.tokenStorage.getAuthorities();
    }
  
  
  }

  goHome(){

    this.router.navigate(['home']);


  }

  onEnglish(){

    this.lang = "english"
    console.log("english");
    this.langServ.changeMessage("english")
    this.ifEnglish = true;
  }


  onPolish(){

    this.lang = "polish"
    console.log("polish");
    this.langServ.changeMessage("polish")
    this.ifEnglish = false;
  
  }


    onSubmit() {
      // console.log(this.form);
  
      this.loginInfo = new AuthLoginInfo(
        this.form.username,
        this.form.password);
        
  
      this.authService.attemptAuth(this.loginInfo).subscribe(
        data => {
          this.tokenStorage.saveToken(data.accessToken);
          this.tokenStorage.saveUsername(data.username);
          this.tokenStorage.saveAuthorities(data.authorities);
          this.tokenStorage.saveEmail(data.email);
          this.tokenStorage.saveId(data.id);
  
          this.isLoginFailed = false;
          this.isLoggedIn = true;
          this.roles = this.tokenStorage.getAuthorities();
          this.reloadPage();
        },
        error => {
          console.log(error);
          this.errorMessage = error.error.message;
          this.isLoginFailed = true;
        },

        

      );
      
    }


    gotolist(){

      

    }
  
    reloadPage() {
      // window.location.reload();

      this.router.navigate["/home"];

    }

  

}
