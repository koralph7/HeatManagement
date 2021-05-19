package com.pola.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pola.models.Battery;
import com.pola.service.BatteryService;



@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/battery")
public class BatteryController {

	private BatteryService batteryService;
	
	public  BatteryController(BatteryService batteryService) {
		this.batteryService = batteryService;
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Battery>> getThemAll(){
		
		return ResponseEntity.ok().body(batteryService.getAllBatteries());
		
		
	}
	
	@GetMapping("/all/{username}")
	public ResponseEntity<List<Battery>> getThemAllByUserName(@PathVariable("username") String username ){
		
		return ResponseEntity.ok().body(batteryService.getAllBatteriesByUserName(username));
		
		
	}
	
	@PostMapping("/add/")
	public ResponseEntity<?> addBeacon(@RequestBody Battery battery){
		
	
			batteryService.addBattery(battery);	
		
		return ResponseEntity.ok().build();
	}
	
	
	
	
	
	
	
	
}
