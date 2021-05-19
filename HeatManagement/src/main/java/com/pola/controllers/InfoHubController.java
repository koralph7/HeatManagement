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
import com.pola.models.InfoHub;
import com.pola.service.BatteryService;
import com.pola.service.InfoHubService;



@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/infoHub")
public class InfoHubController {

	private InfoHubService infoHubService;
	
	public  InfoHubController(InfoHubService infoHubService) {
		this.infoHubService = infoHubService;
	}
	

	
	@GetMapping("/all/{username}")
	public ResponseEntity<List<InfoHub>> getThemAllByUserName(@PathVariable("username") String username ){
		
		return ResponseEntity.ok().body(infoHubService.getAllBatteriesByUserName(username));
		
		
	}
	
	@PostMapping("/add/")
	public ResponseEntity<?> addBeacon(@RequestBody InfoHub infoHub){
		
	
			infoHubService.addInfoHub(infoHub);	
		
		return ResponseEntity.ok().build();
	}
	
	
	
	
	
	
	
	
}
