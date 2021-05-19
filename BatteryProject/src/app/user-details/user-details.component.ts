import { Component, OnInit, Input } from '@angular/core';
import { User } from '../user/user.model';
import { AdminService } from '../user-management/admin.service';
import { ActivatedRoute } from '@angular/router';
import { Beacon } from '../beacons/beacon.model';
import { BeaconService } from '../beacons/beacon.service';
import { stringify } from 'querystring';
import { Device } from '../device/device.model';
import { DeviceService } from '../device/device.service';

@Component({
  selector: 'app-user-details',
  templateUrl: './user-details.component.html',
  styleUrls: ['./user-details.component.css']
})
export class UserDetailsComponent implements OnInit {

  @Input() user:User;

id:number;
beacons:Beacon[];
devices: Device[];

  constructor(private service:AdminService,private deviceService: DeviceService, private beaconService:BeaconService, private route: ActivatedRoute) { }

  ngOnInit() {
    // this.service.currentMessage.subscribe((id) => {
    //   this.id = id
    // });
    const id = +this.route.snapshot.paramMap.get('id');

    console.log(this.id);
    this.getById();
    this.getAllByUserId(id);
    this.getAllDeviceByUserId(id);
  }

  getAllByUserId(id:number){
        this.beaconService.getBeaconsByUserId(id.toString())
    .subscribe((beaconsbec) => {
      this.beacons = beaconsbec
    });

  }

  getAllDeviceByUserId(id:number):void{

    this.deviceService.getGuardsByUserId(id.toString())
            .subscribe((guardsList) =>{
              this.devices = guardsList
            });

  }

  // getPet(): void {
  //   const id = +this.route.snapshot.paramMap.get('id');
  //   this.petService.getPetById(id)
  //     .subscribe(pet => this.pet = pet);
  // }

  getById(){

    const id = +this.route.snapshot.paramMap.get('id');
    
    this.service.getUser(id)
    .subscribe((user) => {
      this.user = user
    });

  }

}
