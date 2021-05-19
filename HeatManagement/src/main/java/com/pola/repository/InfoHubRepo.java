package com.pola.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.pola.models.Battery;
import com.pola.models.InfoHub;

@Repository
public interface InfoHubRepo extends MongoRepository<InfoHub, String>{
	
	 @Query("{'username': ?#{[0]} }")
	  List<InfoHub> findByUserName(String param0);

}
