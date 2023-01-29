package com.github.abarraghi;

import java.util.*;
import java.util.concurrent.*;
import java.io.*;
import java.time.*;

public class ClockTester {
	
	static ShortIDInterpreter shortIDTime = new ShortIDInterpreter();
	static RegionInterpreter regionTime = new RegionInterpreter();
	
	static enum Mode {
		DIGITAL,
		ANALOG
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int lineCount = 0;
		
		String[] testInput = {
				"Asia/Manila", 
				"Etc/UCT", 
				"Asia/Lordistan",
				"Etc/LLT",
				"Cuba",
				"Pacific/Port_Moresby",
				"SystemV/MST7MDT",
				"SystemIV/MST7MDT",
				"Porygon2",
				"America/North_Dakota/Beulah",
				"SolarSystem/Earth/Australia",
				"Europe/Vienna",
				"X"
		};
		
		Set<String> availableIds = ZoneId.getAvailableZoneIds();
		
//		final ScheduledExecutorService updatingClock = Executors.newSingleThreadScheduledExecutor();
//		updatingClock.scheduleAtFixedRate(ClockTester::matchTimeOnField("EST",Mode.DIGITAL), 0, 1, TimeUnit.SECONDS);
		
		while(true) {
			matchTimeOnId("WET", Mode.DIGITAL);
			try {
				Thread.sleep(1000);
			}
			catch(Exception e) {}
		}
		
		
//		String currString = " ";
//		int i = 0;
//		
//		System.out.println("Time Mode set to Digital \n");
//		
//		while(!currString.equals("X")) {
//			currString = testInput[i];
//			System.out.println("JClockCLI Test 1 - Iteration: " + (i+1) + ", input string: " + currString);
//			matchTimeOnId(currString, Mode.DIGITAL);
//			String field = currString.split("/")[currString.split("/").length - 1];
//			matchTimeOnField(field, Mode.DIGITAL);
//			
//			i++;
//		}
//		
//		currString = " ";
//		i = 0;
//		
//		System.out.println("Time Mode set to Analog \n");
//		
//		while(!currString.equals("X")) {
//			currString = testInput[i];
//			System.out.println("JClockCLI Test 1 - Iteration: " + i+1 + ", input string: " + currString);
//			matchTimeOnId(currString, Mode.ANALOG);
//			String field = currString.split("/")[currString.split("/").length - 1];
//			matchTimeOnField(field, Mode.ANALOG);
//			
//			i++;
//		}
		
		
	}
	
	/**
	 * Finds an appropriate String TimeZone representation, based on the TimeZoneId entered
	 * @param field terminating String of the TimeZoneId
	 * @param mode Digital or Analog mode 
	 * @return a "toString" of the TimeZone from its Id
	 */
	
	public static boolean matchTimeOnId(String Id, Mode mode) {
		
		String[] timeParams = Id.split("/");
		
		switch(timeParams.length) {
		
		case 1:
			if(TimeZoneCollection.getAvailableRegions().contains(timeParams[0])) {
				
				regionTime = new RegionInterpreter(timeParams[0]);
				
				if(mode == Mode.DIGITAL) 
					regionTime.setMode(GeneralInterpreter.Mode.DIGITAL);
				
				else if(mode == Mode.ANALOG) 
					regionTime.setMode(GeneralInterpreter.Mode.ANALOG);
				
				System.out.println(regionTime.toString());
				System.out.println(regionTime.getTime());
				System.out.println("");
				return true;
				
			}
			
			else if(TimeZoneCollection.getAvailableShortIDs().contains(timeParams[0])) {
				
				shortIDTime = new ShortIDInterpreter(timeParams[0]);
				
				if(mode == Mode.DIGITAL) 
					shortIDTime.setMode(GeneralInterpreter.Mode.DIGITAL);
				
				else if(mode == Mode.ANALOG) 
					shortIDTime.setMode(GeneralInterpreter.Mode.ANALOG);
				
				System.out.println(shortIDTime.toString());
				System.out.println(shortIDTime.getTime());
				System.out.println("");
				return true;
				
			}
			
			else {
				
				System.out.println("Entered field does not exist!");
				System.out.println("");
				return false;
			}
		
		case 2:
			
			if(TimeZoneCollection.getRegionCityPairings().containsKey(timeParams[0])) {
				
					if(TimeZoneCollection.getRegionCityPairings().get(timeParams[0]).contains(timeParams[1])) {
						
						regionTime = new RegionInterpreter(timeParams[0],timeParams[1]);
						
						if(mode == Mode.DIGITAL) 
							regionTime.setMode(GeneralInterpreter.Mode.DIGITAL);
						
						else if(mode == Mode.ANALOG) 
							regionTime.setMode(GeneralInterpreter.Mode.ANALOG);
						
						System.out.println(regionTime.toString());
						System.out.println(regionTime.getTime());
						System.out.println("");
						return true;
						
					}
					
					else {
						
						System.out.println("Entered city does not exist for this region!");
						System.out.println("");
						return false;
						
					}
				
			}
			
			else if(TimeZoneCollection.getSystemShortPairings().containsKey(timeParams[0])) {
					
					if(TimeZoneCollection.getSystemShortPairings().get(timeParams[0]).contains(timeParams[1])) {
						
						shortIDTime = new ShortIDInterpreter(timeParams[0],timeParams[1]);
						
						if(mode == Mode.DIGITAL) 
							shortIDTime.setMode(GeneralInterpreter.Mode.DIGITAL);
						
						else if(mode == Mode.ANALOG) 
							shortIDTime.setMode(GeneralInterpreter.Mode.ANALOG);
						
						System.out.println(shortIDTime.toString());
						System.out.println(shortIDTime.getTime());
						System.out.println("");
						return true;
						
					}
					
					else {
						
						System.out.println("Entered short id does not exist for this system!");
						System.out.println("");
						return false;
						
					}
				
			}
			
			else {
				
				System.out.println("Entered field does not exist!");
				System.out.println("");
				return false;
			}
			
		case 3:
			
			if(TimeZoneCollection.getRegionSubCityPairings().containsKey(timeParams[0])) {
				
				if(TimeZoneCollection.getRegionSubCityPairings().get(timeParams[0]).containsKey(timeParams[1])) {
					
					if(TimeZoneCollection.getRegionSubCityPairings().get(timeParams[0]).get(timeParams[1]).contains(timeParams[2])) {
						
						regionTime = new RegionInterpreter(timeParams[0],timeParams[1],timeParams[2]);
						
						if(mode == Mode.DIGITAL) 
							regionTime.setMode(GeneralInterpreter.Mode.DIGITAL);
						
						else if(mode == Mode.ANALOG) 
							regionTime.setMode(GeneralInterpreter.Mode.ANALOG);
						
						System.out.println(regionTime.toString());
						System.out.println(regionTime.getTime());
						System.out.println("");
						return true;
						
					}
					
					else {
						
						System.out.println("Entered city does not exist!");
						System.out.println("");
						return false;
						
					}
					
				}
				
				else {
					
					System.out.println("Entered sub region does not exist!");
					System.out.println("");
					return false;
					
				}
				
			}
			
			else {
				
				System.out.println("Entered region does not exist!");
				System.out.println("");
				return false;
				
			}
		
		default :
			
			System.out.println("Enter a time zone id that contains 1 to 3 fields!");
			System.out.println("");
			return false;
	}
		
		
		
	}
	
	/**
	 * Finds an appropriate String TimeZone representation, based on the parameter entered
	 * @param field terminating String of the TimeZoneId 
	 * @param mode Digital or Analog mode
	 * @return a "toString" of the TimeZone from its field
	 */
	
	public static boolean matchTimeOnField(String field, Mode mode) {
		
		Map.Entry<String, LinkedList<String>> filteredStringEntry;
		Map.Entry<String, LinkedList<Integer>> filteredIntegerEntry;
		Map.Entry<String, HashMap<String,LinkedList<String>>> filteredTripleStringEntry;
		
		String region, subRegion, city, shortId, systemName;
		int gmtOffset = TimeZoneCollection.offsetOf(field);
		
		 if (TimeZoneCollection.getAvailableRegions().contains(field)) {
			 
			 region = field;
			 
			 regionTime = new RegionInterpreter(region);
			 
			 if(mode == Mode.DIGITAL) 
					regionTime.setMode(GeneralInterpreter.Mode.DIGITAL);
				
			else if(mode == Mode.ANALOG) 
				regionTime.setMode(GeneralInterpreter.Mode.ANALOG);
			 
			 System.out.println(regionTime.toString());
			 System.out.println(regionTime.getTime());
			 System.out.println("");
			 
			 return true;
			 
		 }
		 else if(TimeZoneCollection.getAvailableShortIDs().contains(field)) {
			 
			 shortId = field;
			 
			 shortIDTime = new ShortIDInterpreter(shortId);
			 
			 if(mode == Mode.DIGITAL) 
					shortIDTime.setMode(GeneralInterpreter.Mode.DIGITAL);
				
			else if(mode == Mode.ANALOG) 
				shortIDTime.setMode(GeneralInterpreter.Mode.ANALOG);
			 
			 System.out.println(shortIDTime.toString());
			 System.out.println(shortIDTime.getTime());
			 System.out.println("");
			 
			 return true;
			 
		 }
		 else {
			 
			 filteredStringEntry = TimeZoneCollection.getRegionCityPairings().entrySet().stream()
				 .filter(regionKey -> regionKey.getValue().contains(field))
				 .findFirst()
				 .orElse(null);
			 
			 if(filteredStringEntry != null) {
				 
				 region = filteredStringEntry.getKey();
				 city = field;
				 
				 regionTime = new RegionInterpreter(region, city);
				 
				 if(mode == Mode.DIGITAL) 
						regionTime.setMode(GeneralInterpreter.Mode.DIGITAL);
					
				else if(mode == Mode.ANALOG) 
					regionTime.setMode(GeneralInterpreter.Mode.ANALOG);
				 
				 System.out.println(regionTime.toString());
				 System.out.println(regionTime.getTime());
				 System.out.println("");
				 
				 return true;
				 
			 }
			 
			 filteredStringEntry = TimeZoneCollection.getSystemShortPairings().entrySet().stream()
					 .filter(systemNameKey -> systemNameKey.getValue().contains(field))
					 .findFirst()
					 .orElse(null);
					 
			 if(filteredStringEntry != null) {
				 
				 systemName = filteredStringEntry.getKey();
				 shortId = field;
						 
				 shortIDTime = new ShortIDInterpreter(systemName, shortId);
				 
				 if(mode == Mode.DIGITAL)
					 shortIDTime.setMode(GeneralInterpreter.Mode.DIGITAL);
				 
				 else if(mode == Mode.ANALOG)
					 shortIDTime.setMode(GeneralInterpreter.Mode.ANALOG);
				 
				 System.out.println(shortIDTime.toString());
				 System.out.println(shortIDTime.getTime());
				 System.out.println("");
						 
				 return true;
				 
			 }
			 
			 filteredIntegerEntry = TimeZoneCollection.getShortGmtPairings().entrySet().stream()
					 .filter(shortIdKey -> shortIdKey.getValue().contains(TimeZoneCollection.offsetOf(field)))
					 .findFirst()
					 .orElse(null);
			 
			 if(filteredIntegerEntry != null && gmtOffset != -100) {
				 
				 shortId = filteredIntegerEntry.getKey();
				 
				 shortIDTime = new ShortIDInterpreter(shortId, gmtOffset);
				 
				 if(mode == Mode.DIGITAL)
					 shortIDTime.setMode(GeneralInterpreter.Mode.DIGITAL);
				 
				 else if(mode == Mode.ANALOG)
					 shortIDTime.setMode(GeneralInterpreter.Mode.ANALOG);
				 
				 System.out.println(shortIDTime.toString());
				 System.out.println(shortIDTime.getTime());
				 System.out.println("");
						 
				 return true;
				 
			 }
			 
			 //Logic
			 //Go through regions first,
			 //See if any of the subregion-city maps contains the city field
			 //Return the region-entry, containing the subregion-city mapping that contains the field
			 //Then filter the subregion-city mapping such that the subregion-city entry that contains the field is the only entry returned
			 //Obtain the parameters for the timezone by referencing the fields found from this filtering procedure 
			 
			 filteredTripleStringEntry = TimeZoneCollection.getRegionSubCityPairings().entrySet().stream()
					 .filter(regionKey -> regionKey.getValue().entrySet().stream()
							 .anyMatch(subRegionKey -> subRegionKey.getValue().contains(field)))
					 .findFirst()
					 .orElse(null);
			 
			 if(filteredTripleStringEntry != null) {
				 
				 region = filteredTripleStringEntry.getKey();
				 subRegion = filteredTripleStringEntry.getValue().entrySet().stream()
				 .filter(subRegionKey -> subRegionKey.getValue().contains(field))
				 .findFirst()
				 .orElse(null)
				 .getKey();
				 
				 
				 city = field;
				 
				 regionTime = new RegionInterpreter(region,subRegion,city);
				 
				 if(mode == Mode.DIGITAL) 
						regionTime.setMode(GeneralInterpreter.Mode.DIGITAL);
					
				else if(mode == Mode.ANALOG) 
					regionTime.setMode(GeneralInterpreter.Mode.ANALOG);
				 
				 System.out.println(regionTime.toString());
				 System.out.println(regionTime.getTime());
				 System.out.println("");
				 
				 return true;
				
			 }
			  
			 
		 }
		 
		 System.out.println("Entered field does not exist!");
		 System.out.println("");
		 
		 return false;
		
	}
}
