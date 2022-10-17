package com.github.abarraghi;

import java.util.*;
import java.io.*;
import java.time.*;

public abstract class TimeZoneIdentifier {
	
	HashSet<String> shortIDSet = new HashSet<String>();
	HashSet<String> regionSet = new HashSet<String>();
	HashMap<String, String> regionCityMap = new HashMap<String, String>();
	HashMap<String, String> systemShortMap = new HashMap<String, String>();
	HashMap<String, Integer> shortGmtMap = new HashMap<String, Integer>();
	
	public HashSet<String> getAvailableShortID(){
		shortIDSet.add("CET");
		shortIDSet.add("CST6CDT");
		shortIDSet.add("EET");
		shortIDSet.add("EST5EDT");
		shortIDSet.add("GMT");
		shortIDSet.add("GMT0");
		shortIDSet.add("MET");
		shortIDSet.add("MST7MDT");
		shortIDSet.add("PST8PDT");
		shortIDSet.add("UCT");
		shortIDSet.add("UTC");
		shortIDSet.add("W-SU");
		shortIDSet.add("WET");
		shortIDSet.add("EST");
		shortIDSet.add("HST");
		shortIDSet.add("MST");
		shortIDSet.add("ACT");
		shortIDSet.add("AET");
		shortIDSet.add("AGT");
		shortIDSet.add("ART");
		shortIDSet.add("AST");
		shortIDSet.add("BET");
		shortIDSet.add("BST");
		shortIDSet.add("CAT");
		shortIDSet.add("CNT");
		shortIDSet.add("CST");
		shortIDSet.add("CTT");
		shortIDSet.add("EAT");
		shortIDSet.add("ECT");
		shortIDSet.add("IET");
		shortIDSet.add("IST");
		shortIDSet.add("JST");
		shortIDSet.add("MIT");
		shortIDSet.add("NET");
		shortIDSet.add("NST");
		shortIDSet.add("PLT");
		shortIDSet.add("PNT");
		shortIDSet.add("PRT");
		shortIDSet.add("PST");
		shortIDSet.add("SST");
		shortIDSet.add("VST");

		return shortIDSet;
	}
	

}
