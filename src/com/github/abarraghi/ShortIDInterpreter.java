package com.github.abarraghi;

import java.time.LocalDateTime;
import java.time.ZoneId;

//Responsible for the setting and getting of TimeZones based on the shortID field

public class ShortIDInterpreter {
	
	String shortID = "", systemName = "";
	int gmtOffset = 0;
	
	public ShortIDInterpreter() {}
	
	public ShortIDInterpreter(String shortID) {
		this.shortID = shortID;
	}
	
	public ShortIDInterpreter(String systemName, String shortID) {
		this.systemName = systemName;
		this.shortID = shortID;
	}
	
	public ShortIDInterpreter(String shortID, int gmtOffset) {
		this.shortID = shortID;
		this.gmtOffset = gmtOffset;
	}
	
	//Assuming we don't use default constructor
	public String getTime() {
		if(systemName.equals("")&&gmtOffset==0) return LocalDateTime.now(ZoneId.of(shortID)).toString();
		else if(gmtOffset==0) return LocalDateTime.now(ZoneId.of(systemName + "/" + shortID)).toString();
		return LocalDateTime.now(ZoneId.of(shortID + "/" + gmtOffset)).toString();
	}
		
	//Assuming we don't use default constructor
	public String toString() {
		if(systemName.equals("")&&gmtOffset==0) {
			return "Short ID: " + shortID;
		}
		else if(gmtOffset==0) {
			return "System Name: " + systemName + ", Short ID: " + shortID;
		}
		return "Short ID: " + shortID + ", GMT Offset: " + gmtOffset;
	}
	
	

}
