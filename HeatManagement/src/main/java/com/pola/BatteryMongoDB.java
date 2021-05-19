package com.pola;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.pola.mqtt.MqttService;

@SpringBootApplication
public class BatteryMongoDB implements CommandLineRunner{

	@Autowired
	private MqttService mqttService;
	
	public static void main(String[] args) {
		SpringApplication.run(BatteryMongoDB.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		final String topic = "test";

		mqttService.subscribe(topic);


		
	}

}
