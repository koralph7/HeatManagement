import { Component, OnInit } from '@angular/core';
import { TokenStorageService } from '../auth/token-storage.service';
import { IdSenderService } from './idSender.service';
import { Router } from '@angular/router';
import { LanguageService } from '../shared/language.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  lang:string;
  adminMode = false;
  userMode = false;
  info: any;
  ifEnglish = false;
  userId = this.token.getId()
  constructor(private langServ: LanguageService, private token: TokenStorageService, private idSender: IdSenderService, private router: Router) { }

  ngOnInit() {

    this.langServ.currentMessage.subscribe(message => this.lang = message)

    if(this.lang.startsWith("e")){
      this.ifEnglish = true;
    }

    this.info = {
      token: this.token.getToken(),
      username: this.token.getUsername(),
      authorities: this.token.getAuthorities(),
      email: this.token.getEmail(),
      id: this.token.getId(),
      
    };
    


    this.idSender.changeMessage(this.userId);
    this.idSender.currentId.subscribe(userId => this.userId = userId);

    console.log(this.info.authorities);
   console.log(typeof(this.info.role));
console.log(this.info.role);
    // this.e.sp
    this.splitter();

    if(this.token.getAuthorities().toString().endsWith("N"))
{
    console.log("jestem adminę");
  
  }


    console.log(this.lang);


  }




  splitter(){
    let rr = JSON.stringify(this.info.authorities);
    let a =rr.replace('[', '');
    let b =a.replace(']', '');
    let c =b.replace('"', '');
    let d=c.replace('"', '');
    if(d === "ROLE_ADMIN"){
      console.log("jest dobrze");
      this.adminMode = true;
    }
    else if(d === "ROLE_USER"){
      this.userMode = true;
    }
    console.log(d);
    

    
  }
  logout() {
    this.token.signOut();
    localStorage.clear();

    this.router.navigate(['/auth/login']);
    // window.location.reload();
  }


  goToUserManPanel(){

    this.router.navigate(['/userManagement']);

  }

}


