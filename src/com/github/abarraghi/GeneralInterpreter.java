package com.github.abarraghi;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public abstract class GeneralInterpreter {
	
	protected final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("EEE, d MMM yyyy HH:mm:ss");
	
	public String getTime() {
		
		return " ";
				
	}
	
	public String toString() {
		
		return " ";
		
	}
	
	
	public String formatTime(String timeString) {
		
		ZoneId zoneId = ZoneId.of(timeString);
		
		LocalDateTime date = LocalDateTime.now(zoneId);
		
		return date.format(TIME_FORMATTER);
		
	}

}
