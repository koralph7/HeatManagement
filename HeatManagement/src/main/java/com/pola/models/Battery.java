package com.pola.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "batteries")
public class Battery {
	
	@Id
	private String id;
	private String name;
	private  long numOfCell2v;
	private long alarm1;
	private long alarm2;
	private String username;
	
	
	public Battery() 
	{
		
	}
	
	
	public Battery(String id, String name, long numOfCell2v, String username, long alarm1, long alarm2) {
		super();
		this.id = id;
		this.name = name;
		this.numOfCell2v = numOfCell2v;
		this.alarm1 = alarm1;
		this.alarm2 = alarm2;
		this.username = username;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getNumOfCell2v() {
		return numOfCell2v;
	}
	public void setNumOfCell2v(long numOfCell2v) {
		this.numOfCell2v = numOfCell2v;
	}
	public long getAlarm1() {
		return alarm1;
	}
	public void setAlarm1(long alarm1) {
		this.alarm1 = alarm1;
	}
	public long getAlarm2() {
		return alarm2;
	}
	public void setAlarm2(long alarm2) {
		this.alarm2 = alarm2;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	
	
	
	
	

}
