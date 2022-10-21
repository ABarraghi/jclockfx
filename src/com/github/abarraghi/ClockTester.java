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
				"X"
		};
		
		Set<String> availableIds = ZoneId.getAvailableZoneIds();
		RegionInterpreter regionTime;
		ShortIDInterpreter shortIDTime;
		
		String currString = " ";
		int i = 0;
		while(!currString.equals("X")) {
			currString = testInput[i];
			String[] timeParams = currString.split("/"); 
			System.out.println("JClockCLI Test 1 - Iteration: " + i + ", input string: " + currString);
			
			switch(timeParams.length) {
			
				case 1:
					if(TimeZoneCollection.getAvailableRegions().contains(timeParams[0])) {
						
						regionTime = new RegionInterpreter(timeParams[0]);
						System.out.println(regionTime.toString());
						System.out.println(regionTime.getTime());
						System.out.println("");
						
					}
					
					else if(TimeZoneCollection.getAvailableShortIDs().contains(timeParams[0])) {
						
						shortIDTime = new ShortIDInterpreter(timeParams[0]);
						System.out.print(shortIDTime.toString());
						System.out.print(shortIDTime.getTime());
						System.out.println("");
						
						
					}
					
					else {
						
						System.out.println("Entered field does not exist!");
						System.out.println("");
					}
					
					break;
				
				case 2:
					
					if(TimeZoneCollection.getRegionCityPairings().containsKey(timeParams[0])) {
						
//						System.out.println(TimeZoneCollection.getRegionCityPairings().get(timeParams[0]));
						
							if(TimeZoneCollection.getRegionCityPairings().get(timeParams[0]).contains(timeParams[1])) {
								
								regionTime = new RegionInterpreter(timeParams[0],timeParams[1]);
								System.out.println(regionTime.toString());
								System.out.println(regionTime.getTime());
								System.out.println("");
								
							}
							
							else {
								
								System.out.println("Entered city does not exist for this region!");
								System.out.println("");
								
							}
						
					}
					
					else if(TimeZoneCollection.getSystemShortPairings().containsKey(timeParams[0])) {
							
							if(TimeZoneCollection.getSystemShortPairings().get(timeParams[0]).contains(timeParams[1])) {
								
								shortIDTime = new ShortIDInterpreter(timeParams[0],timeParams[1]);
								System.out.println(shortIDTime.toString());
								System.out.println(shortIDTime.getTime());
								System.out.println("");
								
							}
							
							else {
								
								System.out.println("Entered short id does not exist for this system!");
								System.out.println("");
								
							}
						
					}
					
					else {
						
						System.out.println("Entered field does not exist!");
						System.out.println("");
					}
					break;
					
				case 3:
					
					//TODO Implement logic for regionName/subRegionName/cityName pairing map
					
					break;
				
				default :
					
					//TODO Implement exception handling
					
					break;
			}
			
			i++;
		}
		
		System.out.println(TimeZoneCollection.offsetOf("GMT+12"));
	}
}
