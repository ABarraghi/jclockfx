package com.github.abarraghi;

import java.util.*;
import java.io.*;
import java.time.*;

public class ClockTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int lineCount = 0;
		
		String[] testInput = {
				"Asia/Manila", 
				"Etc/UCT", //Needs to be added to the systemShortID map 
				"Asia/Lordistan",
				"Etc/LLT",
				"Cuba",
				"Pacific/Port_Moresby",
				"SystemV/MST7MDT",
				"SystemIV/MST7MDT",
				"Porygon2",
				"America/North_Dakota/Beulah",
				"SolarSystem/Earth/Australia",
				"X"
		};
		
		Set<String> availableIds = ZoneId.getAvailableZoneIds();
		
		String currString = " ";
		int i = 0;
		while(!currString.equals("X")) {
			currString = testInput[i];
			System.out.println("JClockCLI Test 1 - Iteration: " + i + ", input string: " + currString);
			matchTimeOnId(currString);
			
			i++;
		}
		
	}
	
	public static boolean matchTimeOnId(String Id) {
		
		String[] timeParams = Id.split("/");
		RegionInterpreter regionTime;
		ShortIDInterpreter shortIDTime;
		
		switch(timeParams.length) {
		
		case 1:
			if(TimeZoneCollection.getAvailableRegions().contains(timeParams[0])) {
				
				regionTime = new RegionInterpreter(timeParams[0]);
				System.out.println(regionTime.toString());
				System.out.println(regionTime.getTime());
				System.out.println("");
				return true;
				
			}
			
			else if(TimeZoneCollection.getAvailableShortIDs().contains(timeParams[0])) {
				
				shortIDTime = new ShortIDInterpreter(timeParams[0]);
				System.out.print(shortIDTime.toString());
				System.out.print(shortIDTime.getTime());
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
	
	public static boolean matchTimeOnField(String field) {
		
		boolean timeMatched;
		
		//TODO insert logic for set-field comparisons 
		
		
		 if (TimeZoneCollection.getAvailableRegions().contains(field)) {
			 
			 return true;
			 
		 }
		 else if(TimeZoneCollection.getAvailableShortIDs().contains(field)) {
			 
			 
			 return true;
		 }
		 else {
			 
			 TimeZoneCollection.getRegionCityPairings().forEach((regions,cities) -> {
				 if(cities.contains(field)) {
					 
					 //TODO insert logic for map-field comparisons 
				 }
			 });
			 
			 TimeZoneCollection.getSystemShortPairings().forEach((systemNames,shortIds) -> {
				 if(shortIds.contains(field)) {
					 
					
				 }
			 });
			 
			 TimeZoneCollection.getShortGmtPairings().forEach((shortIds,gmtOffsets) -> {
				 
				 if(gmtOffsets.contains(TimeZoneCollection.offsetOf(field))) {
					 
					
				 }
			 });
			 
			 TimeZoneCollection.getRegionSubCityPairings().forEach((regions,subregions) -> {
				 
				 subregions.forEach((subregionsInner,cities) -> {
					 if(cities.contains(field)) {
						 
						
					 }
				 });
			 });
			  
			 
		 }
		
	}
}
