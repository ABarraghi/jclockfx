package com.github.abarraghi;

import java.util.*;
import java.io.*;
import java.time.*;

public class ClockTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int lineCount = 0;
		
		String[] testInput = {
				"addis ababa", 
				"windhoek",
				"COMODRIVADAVIA",
				"JujuY",
				"X"
		};
		
		Set<String> availableIds = ZoneId.getAvailableZoneIds();
		
		availableIds.forEach(timeZoneId -> {
			final String[] splitTimeZone = timeZoneId.split("/");
			for(int i=0;i<splitTimeZone.length;i++) {
				System.out.print(splitTimeZone[i] + " ");
			}
			System.out.println();
		});
		
//		Idea of format to follow for processing of clock times
//		System.out.println(LocalDateTime.now(ZoneId.of("GMT")));
		

	}

}
