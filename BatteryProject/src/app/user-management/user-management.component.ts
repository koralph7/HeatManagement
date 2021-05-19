import { Component, OnInit } from '@angular/core';
import { User } from '../user/user.model';
import { AdminService } from './admin.service';
import { TokenStorageService } from '../auth/token-storage.service';
import { Subscription } from 'rxjs';
import { Router } from '@angular/router';
import { subscribeOn } from 'rxjs/operators';

@Component({
  selector: 'app-user-management',
  templateUrl: './user-management.component.html',
  styleUrls: ['./user-management.component.css']
})
export class UserManagementComponent implements OnInit {


  user = new User();
  users:User[];
  info: any;
  id:number;
  showform=false;
  showformPas=false;
  userId = this.token.getId();
  constructor(private token: TokenStorageService, private router:Router, private adminService:AdminService) { }

  ngOnInit() {

    this.info = {
      token: this.token.getToken(),
      username: this.token.getUsername(),
      authorities: this.token.getAuthorities(),
      email: this.token.getEmail(),
      
      id: this.token.getId(),
    
      
    // this.getAll();
  }
  this.getAllUsers();
  
 }



 updateUser(id: number) {

  this.showform = true;
  this.adminService.getUser(id)
    .subscribe((user) => { this.user = user});

  // this.editMode = true;

}

changePass(id: number){
  this.showformPas = true;
  this.adminService.getUser(id)
    .subscribe((user) => { this.user = user});
}

submitChanges(id: number){
  

  this.adminService.editUser(id, this.user)
  .subscribe((response) => {
    console.log(response);
  });

window.location.reload();



}


  getDateils(id:number){
    console.log(id);
    // this.adminService.currentMessage.subscribe((id) => {
    //   this.id = id
    // });
    this.router.navigate(['userManagement/'+id]);
      


  }


  
 deleteUser(id: number){

  this.adminService.deleteUser(id)
  .subscribe((response) => {
    console.log(response);
  });

  window.location.reload();
 }



  getAllUsers(){


    this.adminService.getUsers(this.userId)
    .subscribe((beaconsbec) => {
      this.users = beaconsbec
    });


  }

}
