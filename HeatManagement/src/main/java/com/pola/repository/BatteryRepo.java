package com.pola.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.pola.models.Battery;

@Repository
public interface BatteryRepo extends MongoRepository<Battery, String>{
	
	 @Query("{'username': ?#{[0]} }")
	  List<Battery> findByUserName(String param0);
	
}
