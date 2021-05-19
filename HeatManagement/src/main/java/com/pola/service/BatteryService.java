package com.pola.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pola.models.Battery;
import com.pola.repository.BatteryRepo;

@Service
public class BatteryService {

	private BatteryRepo batteryRepo;
	
	public BatteryService(BatteryRepo batteryRepo) 
	{
		this.batteryRepo = batteryRepo;
	
	}
	
	public List<Battery> getAllBatteries() {
		
		return batteryRepo.findAll();
		
	}
	
public List<Battery> getAllBatteriesByUserName(String userName) {
		
		return batteryRepo.findByUserName(userName);
		
	}
	
	public Battery addBattery(Battery battery) 
	{
		return batteryRepo.save(battery);
	}
	
}
