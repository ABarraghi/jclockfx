package com.github.abarraghi;

import java.time.LocalDateTime;
import java.time.ZoneId;

//Responsible for the setting and getting of TimeZones based on the shortID field

public class ShortIDInterpreter extends GeneralInterpreter {
	
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
		if(systemName.equals("")&&gmtOffset==0) return super.formatTime(shortID);
		else if(gmtOffset==0) return super.formatTime(systemName + "/" + shortID);
		return super.formatTime(shortID + "/" + gmtOffset);
	}
		
	//Assuming we don't use default constructor
	public String toString() {
		if(systemName.equals("")&&gmtOffset==0) {
			return shortID;
		}
		else if(gmtOffset==0) {
			return systemName + "/" + shortID;
		}
		return shortID + "/" + gmtOffset;
	}
	
	

}
