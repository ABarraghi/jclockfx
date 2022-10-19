package com.github.abarraghi;

import java.time.*;

//Responsible for the setting and getting of TimeZones based on the regionName field

public class RegionInterpreter {
	
	String regionName = "", subregionName = "", cityName = "";
	
	public RegionInterpreter() {}
	
	public RegionInterpreter(String regionName) {
		this.regionName = regionName;
	}
	
	public RegionInterpreter(String regionName, String cityName) {
		this.regionName = regionName;
		this.cityName = cityName;
	}
	
	public RegionInterpreter(String regionName, String subregionName, String cityName) {
		this.regionName = regionName;
		this.subregionName = subregionName;
		this.cityName = cityName;
	}
	
	//Assuming we don't use default constructor
	public String getTime() {
		if(cityName.equals("")) return LocalDateTime.now(ZoneId.of(regionName)).toString();
		else if(subregionName.equals("")) return LocalDateTime.now(ZoneId.of(regionName + "/" + cityName)).toString();
		return LocalDateTime.now(ZoneId.of(regionName + "/" + subregionName + "/" + cityName)).toString();
	}
	
	//Assuming we don't use default constructor
	public String toString() {
		if(cityName.equals("")) {
			return "Region Name: " + regionName;
		}
		else if(subregionName.equals("")) {
			return "Region Name: " + regionName + ", City Name: " + cityName;
		}
		return "Region Name: " + regionName + ", Sub-Region Name: " + subregionName + ", City Name: " + cityName;
	}
}