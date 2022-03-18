package com.github.abarraghi;

import java.util.*;
import java.io.*;
import java.lang.reflect.Array;

public class ClockTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] testInput = {
				"addis ababa", 
				"windhoek",
				"COMODRIVADAVIA",
				"JujuY",
				"X"
		};
		
		String[] availableIds = TimeZone.getAvailableIDs();
		
		for(int i=0;i<availableIds.length;i++) {
			System.out.println(availableIds[i]);
		}
		

	}

}
