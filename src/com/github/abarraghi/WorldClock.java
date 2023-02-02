package com.github.abarraghi;

public class WorldClock {
	
	String currTime = "", cityName = "", regionName = "", currDate = "";
	String shortID = "", systemName = "";
	int gmtOffset = 0;
	
	public WorldClock() {}
	
	public WorldClock(String currTime, String cityName, String regionName, String shortID, String systemName, int gmtOffset, String currDate) {
		this.currTime = currTime;
		this.cityName = cityName;
		this.regionName = regionName;
		this.shortID = shortID;
		this.systemName = systemName;
		this.currDate = currDate;
	}

	public String getCurrTime() {
		return currTime;
	}

	public String getCityName() {
		return cityName;
	}

	public String getRegionName() {
		return regionName;
	}

	public String getCurrDate() {
		return currDate;
	}

	public void setCurrTime(String currTime) {
		this.currTime = currTime;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	public void setCurrDate(String currDate) {
		this.currDate = currDate;
	}

	@Override
	public String toString() {
		return "WorldClock [currTime=" + currTime + ", cityName=" + cityName + ", regionName=" + regionName
				+ ", currDate=" + currDate + "]";
	}
	

}
