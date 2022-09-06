package com.github.abarraghi;

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
}
