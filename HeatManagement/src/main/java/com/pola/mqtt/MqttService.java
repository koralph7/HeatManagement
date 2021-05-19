package com.pola.mqtt;

import java.util.Optional;

import org.eclipse.paho.client.mqttv3.IMqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.MqttPersistenceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.pola.email.EmailSender;
import com.pola.models.Battery;
import com.pola.models.User;
import com.pola.repository.BatteryRepo;
import com.pola.repository.UserRepository;

@Service
public class MqttService {

	@Autowired
	private IMqttClient mqttClient;
	
	@Autowired
	private BatteryRepo batteryRepo;
	
	@Autowired
	private UserRepository userRepo;

	@Autowired
	private EmailSender emailSender;
	
	public void publish(final String topic, final String payload, int qos, boolean retained)
			throws MqttPersistenceException, MqttException {
		MqttMessage mqttMessage = new MqttMessage();
		mqttMessage.setPayload(payload.getBytes());
		mqttMessage.setQos(qos);
		mqttMessage.setRetained(retained);

		mqttClient.publish(topic, mqttMessage);
		
		

		mqttClient.disconnect();
	}



	public void subscribe(final String topic) throws MqttException, InterruptedException {
		System.out.println("Messages received:");

		mqttClient.subscribeWithResponse(topic, (tpic, msg) -> {
			
			String mqttMsg=msg.getPayload().toString();  
			String[] words=mqttMsg.split("\\s");  
			
			String temperature = words[0];
			long tempLong = Long.parseLong(temperature);
			String batteryId = words[1];
			
		

			Optional<Battery> battery = batteryRepo.findById(batteryId);
			if (battery.isPresent()) {
				
				if (tempLong>= battery.get().getAlarm2()) {
					Optional<User> userOptional = userRepo.findByUsername(battery.get().getUsername());
					if (userOptional.isPresent()) {
						String topicMes = "przekroczenie temperatury";
						String content = "bateria o id " + batteryId + " ma temperature " + 
						tempLong;
						emailSender.sendSimpleMessage(userOptional.get().getEmail(),
								topicMes, content);	
					}
					else {
						throw new NotFoundException();
					}
				}
			}
			
			else {
				throw new NotFoundException();
			}
			
			
			
		});
	}
	
}
