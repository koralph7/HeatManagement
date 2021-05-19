import { Component, OnInit } from '@angular/core';
import { TokenStorageService } from '../auth/token-storage.service';
import { InfoHub } from './infoHub.model';
import { InfoHubService } from './infoHub.service';

@Component({
  selector: 'app-info-hub',
  templateUrl: './info-hub.component.html',
  styleUrls: ['./info-hub.component.css']
})
export class InfoHubComponent implements OnInit {

 
  infoHubs: InfoHub[];
  info: any;

  constructor(private infoHubService:InfoHubService, private token: TokenStorageService) { 

  }

  ngOnInit() {
    this.info = {
      token: this.token.getToken(),
      username: this.token.getUsername(),
      authorities: this.token.getAuthorities(),
      email: this.token.getEmail(),
      
      id: this.token.getId(),
        }
    this.getAll();
  }


  getAll() {

   

    this.infoHubService.getInfoHubs(this.info.username)
          .subscribe((beaconsbec) => {
        this.infoHubs = beaconsbec
      });

  }

}


