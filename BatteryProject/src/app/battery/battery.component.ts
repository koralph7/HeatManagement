import { Component, OnInit } from '@angular/core';
import { TokenStorageService } from '../auth/token-storage.service';
import { Battery } from './battery.model';
import { BatteryService } from './battery.service';

@Component({
  selector: 'app-battery',
  templateUrl: './battery.component.html',
  styleUrls: ['./battery.component.css']
})
export class BatteryComponent implements OnInit {

  batteries: Battery[];
  info: any;

  constructor(private batteryService:BatteryService, private token: TokenStorageService) { 

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

   

    this.batteryService.getBatteries(this.info.username)
          .subscribe((beaconsbec) => {
        this.batteries = beaconsbec
      });

  }

}
