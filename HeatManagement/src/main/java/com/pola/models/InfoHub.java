package com.pola.models;



import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "infoHubs")
public class InfoHub {

	@Id
	private String id;
	private long roomTemp;
	private String bateryName;
	private long bateryTemp;
	private String usb;
	private String username;
	
	public InfoHub() {}
	
	

	public InfoHub(String id, long roomTemp, String bateryName, String username,long bateryTemp, String usb) {
		super();
		this.id = id;
		this.roomTemp = roomTemp;
		this.bateryName = bateryName;
		this.bateryTemp = bateryTemp;
		this.usb = usb;
		this.username = username;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public long getRoomTemp() {
		return roomTemp;
	}

	public void setRoomTemp(long roomTemp) {
		this.roomTemp = roomTemp;
	}

	public long getBateryTemp() {
		return bateryTemp;
	}

	public void setBateryTemp(long bateryTemp) {
		this.bateryTemp = bateryTemp;
	}

	public String getUsb() {
		return usb;
	}

	public void setUsb(String usb) {
		this.usb = usb;
	}

	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getBateryName() {
		return bateryName;
	}



	public void setBateryName(String bateryName) {
		this.bateryName = bateryName;
	}



	
	
	
	
	
	
}
