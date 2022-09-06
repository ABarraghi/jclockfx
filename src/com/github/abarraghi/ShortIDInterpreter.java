package com.github.abarraghi;

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
	
	

}
