package com.github.abarraghi;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public abstract class GeneralInterpreter {
	
	protected final SimpleDateFormat TIME_FORMATTER = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss");
	
	public String getTime() {
		
		return " ";
				
	}
	
	public String toString() {
		
		return " ";
		
	}
	
	
	public String formatTime(String timeString) {
		
		ZoneId zoneId = ZoneId.of(timeString);
		
		LocalDateTime date = LocalDateTime.now(zoneId);
		
		Date dateOut = Date.from(date.atZone(zoneId).toInstant()); 
		
		return TIME_FORMATTER.format(dateOut);
		
		
		
	}

}
