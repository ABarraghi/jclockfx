package com.github.abarraghi;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public abstract class GeneralInterpreter {
	
	protected String currTime = "", cityName = "", regionName = "", subregionName = "";
	protected String shortID = "", systemName = "";
	protected int gmtOffset = 100;
	
	public enum Mode {
		DIGITAL,
		ANALOG
	}
	
	protected Mode currentMode = Mode.DIGITAL; //Mode is set to digital by default 
	
	protected DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("EEE, d MMM yyyy HH:mm:ss");
	
	public String getTime() {
		
		return " ";
				
	}
	
	public String toString() {
		
		return " ";
		
	}
	
	
	public String formatTime(String timeString) {
		
		if(currentMode == Mode.DIGITAL) 
			timeFormatter = DateTimeFormatter.ofPattern("EEE, d MMM yyyy HH:mm:ss");
		
		else if(currentMode == Mode.ANALOG) 
			timeFormatter = DateTimeFormatter.ofPattern("EEE, d MMM yyyy h:mm:ss a");
		
		
		ZoneId zoneId = ZoneId.of(timeString);
		
		LocalDateTime date = LocalDateTime.now(zoneId);
		
		return date.format(timeFormatter);
		
	}
	
	//Accessors and Mutators for the Mode enum variable
	public void setMode(Mode mode) {
		currentMode = mode;
	}
	
	public Mode getMode() {
		return currentMode;
	}

}
