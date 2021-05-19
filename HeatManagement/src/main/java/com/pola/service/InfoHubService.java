package com.pola.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pola.models.Battery;
import com.pola.models.InfoHub;
import com.pola.repository.BatteryRepo;
import com.pola.repository.InfoHubRepo;

@Service
public class InfoHubService {

	private InfoHubRepo infoHubRepo;
	
	public InfoHubService(InfoHubRepo infoHubRepo) 
	{
		this.infoHubRepo = infoHubRepo;
	
	}
	
	
	
public List<InfoHub> getAllBatteriesByUserName(String userName) {
		
		return infoHubRepo.findByUserName(userName);
		
	}
	
	public InfoHub addInfoHub(InfoHub infoHub) 
	{
		return infoHubRepo.save(infoHub);
	}
	
}
