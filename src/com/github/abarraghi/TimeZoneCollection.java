package com.github.abarraghi;

import java.util.*;
import java.io.*;
import java.time.*;

public abstract class TimeZoneCollection {
	
	private static HashSet<String> shortIDSet = new HashSet<String>();
	private static HashSet<String> regionSet = new HashSet<String>();
	private static HashMap<String, LinkedList<String>> regionCityMap = new HashMap<String, LinkedList<String>>();
	private static HashMap<String, LinkedList<String>> systemShortMap = new HashMap<String, LinkedList<String>>();
	private static HashMap<String, LinkedList<Integer>> shortGmtMap = new HashMap<String, LinkedList<Integer>>();
//	TODO Implement logic for regionName/subRegionName/cityName pairing map
//	HashMap<String, <String, String> > regionSubregionCityMap = new HashMap<String, <String, String> >;
	
	public static HashSet<String> getAvailableShortIDs(){
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
	
	public static HashSet<String> getAvailableRegions(){
		regionSet.add("Cuba");
		regionSet.add("Egypt");
		regionSet.add("Eire");
		regionSet.add("GB");
		regionSet.add("GB-Eire");
		regionSet.add("Greenwich");
		regionSet.add("Hongkong");
		regionSet.add("Iceland");
		regionSet.add("Iran");
		regionSet.add("Israel");
		regionSet.add("Jamaica");
		regionSet.add("Japan");
		regionSet.add("Kwajalein");
		regionSet.add("Libya");
		regionSet.add("NZ");
		regionSet.add("NZ-CHAT");
		regionSet.add("Navajo");
		regionSet.add("PRC");
		regionSet.add("Poland");
		regionSet.add("Portugal");
		regionSet.add("ROK");
		regionSet.add("Singapore");
		regionSet.add("Turkey");
		regionSet.add("Universal");
		regionSet.add("Zulu");

		
		return regionSet;
	}
	
	public static HashMap<String, LinkedList<String>> getRegionCityPairings(){
		regionalCityInsertion("Africa","Abidjan");
		regionalCityInsertion("Africa","Accra");
		regionalCityInsertion("Africa","Addis_Ababa");
		regionalCityInsertion("Africa","Algiers");
		regionalCityInsertion("Africa","Asmara");
		regionalCityInsertion("Africa","Asmera");
		regionalCityInsertion("Africa","Bamako");
		regionalCityInsertion("Africa","Bangui");
		regionalCityInsertion("Africa","Banjul");
		regionalCityInsertion("Africa","Bissau");
		regionalCityInsertion("Africa","Blantyre");
		regionalCityInsertion("Africa","Brazzaville");
		regionalCityInsertion("Africa","Bujumbura");
		regionalCityInsertion("Africa","Cairo");
		regionalCityInsertion("Africa","Casablanca");
		regionalCityInsertion("Africa","Ceuta");
		regionalCityInsertion("Africa","Conakry");
		regionalCityInsertion("Africa","Dakar");
		regionalCityInsertion("Africa","Dar_es_Salaam");
		regionalCityInsertion("Africa","Djibouti");
		regionalCityInsertion("Africa","Douala");
		regionalCityInsertion("Africa","El_Aaiun");
		regionalCityInsertion("Africa","Freetown");
		regionalCityInsertion("Africa","Gaborone");
		regionalCityInsertion("Africa","Harare");
		regionalCityInsertion("Africa","Johannesburg");
		regionalCityInsertion("Africa","Juba");
		regionalCityInsertion("Africa","Kampala");
		regionalCityInsertion("Africa","Khartoum");
		regionalCityInsertion("Africa","Kigali");
		regionalCityInsertion("Africa","Kinshasa");
		regionalCityInsertion("Africa","Lagos");
		regionalCityInsertion("Africa","Libreville");
		regionalCityInsertion("Africa","Lome");
		regionalCityInsertion("Africa","Luanda");
		regionalCityInsertion("Africa","Lubumbashi");
		regionalCityInsertion("Africa","Lusaka");
		regionalCityInsertion("Africa","Malabo");
		regionalCityInsertion("Africa","Maputo");
		regionalCityInsertion("Africa","Maseru");
		regionalCityInsertion("Africa","Mbabane");
		regionalCityInsertion("Africa","Mogadishu");
		regionalCityInsertion("Africa","Monrovia");
		regionalCityInsertion("Africa","Nairobi");
		regionalCityInsertion("Africa","Ndjamena");
		regionalCityInsertion("Africa","Niamey");
		regionalCityInsertion("Africa","Nouakchott");
		regionalCityInsertion("Africa","Ouagadougou");
		regionalCityInsertion("Africa","Porto-Novo");
		regionalCityInsertion("Africa","Sao_Tome");
		regionalCityInsertion("Africa","Timbuktu");
		regionalCityInsertion("Africa","Tripoli");
		regionalCityInsertion("Africa","Tunis");
		regionalCityInsertion("Africa","Windhoek");
		regionalCityInsertion("America","Adak");
		regionalCityInsertion("America","Anchorage");
		regionalCityInsertion("America","Anguilla");
		regionalCityInsertion("America","Antigua");
		regionalCityInsertion("America","Araguaina");
		regionalCityInsertion("America","Aruba");
		regionalCityInsertion("America","Asuncion");
		regionalCityInsertion("America","Atikokan");
		regionalCityInsertion("America","Atka");
		regionalCityInsertion("America","Bahia");
		regionalCityInsertion("America","Bahia_Banderas");
		regionalCityInsertion("America","Barbados");
		regionalCityInsertion("America","Belem");
		regionalCityInsertion("America","Belize");
		regionalCityInsertion("America","Blanc-Sablon");
		regionalCityInsertion("America","Boa_Vista");
		regionalCityInsertion("America","Bogota");
		regionalCityInsertion("America","Boise");
		regionalCityInsertion("America","Buenos_Aires");
		regionalCityInsertion("America","Cambridge_Bay");
		regionalCityInsertion("America","Campo_Grande");
		regionalCityInsertion("America","Cancun");
		regionalCityInsertion("America","Caracas");
		regionalCityInsertion("America","Catamarca");
		regionalCityInsertion("America","Cayenne");
		regionalCityInsertion("America","Cayman");
		regionalCityInsertion("America","Chicago");
		regionalCityInsertion("America","Chihuahua");
		regionalCityInsertion("America","Coral_Harbour");
		regionalCityInsertion("America","Cordoba");
		regionalCityInsertion("America","Costa_Rica");
		regionalCityInsertion("America","Creston");
		regionalCityInsertion("America","Cuiaba");
		regionalCityInsertion("America","Curacao");
		regionalCityInsertion("America","Danmarkshavn");
		regionalCityInsertion("America","Dawson");
		regionalCityInsertion("America","Dawson_Creek");
		regionalCityInsertion("America","Denver");
		regionalCityInsertion("America","Detroit");
		regionalCityInsertion("America","Dominica");
		regionalCityInsertion("America","Edmonton");
		regionalCityInsertion("America","Eirunepe");
		regionalCityInsertion("America","El_Salvador");
		regionalCityInsertion("America","Ensenada");
		regionalCityInsertion("America","Fort_Nelson");
		regionalCityInsertion("America","Fort_Wayne");
		regionalCityInsertion("America","Fortaleza");
		regionalCityInsertion("America","Glace_Bay");
		regionalCityInsertion("America","Godthab");
		regionalCityInsertion("America","Goose_Bay");
		regionalCityInsertion("America","Grand_Turk");
		regionalCityInsertion("America","Grenada");
		regionalCityInsertion("America","Guadeloupe");
		regionalCityInsertion("America","Guatemala");
		regionalCityInsertion("America","Guayaquil");
		regionalCityInsertion("America","Guyana");
		regionalCityInsertion("America","Halifax");
		regionalCityInsertion("America","Havana");
		regionalCityInsertion("America","Hermosillo");
		regionalCityInsertion("America","Inuvik");
		regionalCityInsertion("America","Iqaluit");
		regionalCityInsertion("America","Jamaica");
		regionalCityInsertion("America","Jujuy");
		regionalCityInsertion("America","Juneau");
		regionalCityInsertion("America","Kralendijk");
		regionalCityInsertion("America","La_Paz");
		regionalCityInsertion("America","Lima");
		regionalCityInsertion("America","Los_Angeles");
		regionalCityInsertion("America","Louisville");
		regionalCityInsertion("America","Lower_Princes");
		regionalCityInsertion("America","Maceio");
		regionalCityInsertion("America","Managua");
		regionalCityInsertion("America","Manaus");
		regionalCityInsertion("America","Marigot");
		regionalCityInsertion("America","Martinique");
		regionalCityInsertion("America","Matamoros");
		regionalCityInsertion("America","Mazatlan");
		regionalCityInsertion("America","Mendoza");
		regionalCityInsertion("America","Menominee");
		regionalCityInsertion("America","Merida");
		regionalCityInsertion("America","Metlakatla");
		regionalCityInsertion("America","Mexico_City");
		regionalCityInsertion("America","Miquelon");
		regionalCityInsertion("America","Moncton");
		regionalCityInsertion("America","Monterrey");
		regionalCityInsertion("America","Montevideo");
		regionalCityInsertion("America","Montreal");
		regionalCityInsertion("America","Montserrat");
		regionalCityInsertion("America","Nassau");
		regionalCityInsertion("America","New_York");
		regionalCityInsertion("America","Nipigon");
		regionalCityInsertion("America","Nome");
		regionalCityInsertion("America","Noronha");
		regionalCityInsertion("America","Ojinaga");
		regionalCityInsertion("America","Panama");
		regionalCityInsertion("America","Pangnirtung");
		regionalCityInsertion("America","Paramaribo");
		regionalCityInsertion("America","Phoenix");
		regionalCityInsertion("America","Port-au-Prince");
		regionalCityInsertion("America","Port_of_Spain");
		regionalCityInsertion("America","Porto_Acre");
		regionalCityInsertion("America","Porto_Velho");
		regionalCityInsertion("America","Puerto_Rico");
		regionalCityInsertion("America","Punta_Arenas");
		regionalCityInsertion("America","Rainy_River");
		regionalCityInsertion("America","Rankin_Inlet");
		regionalCityInsertion("America","Recife");
		regionalCityInsertion("America","Regina");
		regionalCityInsertion("America","Resolute");
		regionalCityInsertion("America","Rio_Branco");
		regionalCityInsertion("America","Rosario");
		regionalCityInsertion("America","Santa_Isabel");
		regionalCityInsertion("America","Santarem");
		regionalCityInsertion("America","Santiago");
		regionalCityInsertion("America","Santo_Domingo");
		regionalCityInsertion("America","Sao_Paulo");
		regionalCityInsertion("America","Scoresbysund");
		regionalCityInsertion("America","Shiprock");
		regionalCityInsertion("America","Sitka");
		regionalCityInsertion("America","St_Barthelemy");
		regionalCityInsertion("America","St_Johns");
		regionalCityInsertion("America","St_Kitts");
		regionalCityInsertion("America","St_Lucia");
		regionalCityInsertion("America","St_Thomas");
		regionalCityInsertion("America","St_Vincent");
		regionalCityInsertion("America","Swift_Current");
		regionalCityInsertion("America","Tegucigalpa");
		regionalCityInsertion("America","Thule");
		regionalCityInsertion("America","Thunder_Bay");
		regionalCityInsertion("America","Tijuana");
		regionalCityInsertion("America","Toronto");
		regionalCityInsertion("America","Tortola");
		regionalCityInsertion("America","Vancouver");
		regionalCityInsertion("America","Virgin");
		regionalCityInsertion("America","Whitehorse");
		regionalCityInsertion("America","Winnipeg");
		regionalCityInsertion("America","Yakutat");
		regionalCityInsertion("America","Yellowknife");
		regionalCityInsertion("Antarctica","Casey");
		regionalCityInsertion("Antarctica","Davis");
		regionalCityInsertion("Antarctica","DumontDUrville");
		regionalCityInsertion("Antarctica","Macquarie");
		regionalCityInsertion("Antarctica","Mawson");
		regionalCityInsertion("Antarctica","McMurdo");
		regionalCityInsertion("Antarctica","Palmer");
		regionalCityInsertion("Antarctica","Rothera");
		regionalCityInsertion("Antarctica","South_Pole");
		regionalCityInsertion("Antarctica","Syowa");
		regionalCityInsertion("Antarctica","Troll");
		regionalCityInsertion("Antarctica","Vostok");
		regionalCityInsertion("Arctic","Longyearbyen");
		regionalCityInsertion("Asia","Aden");
		regionalCityInsertion("Asia","Almaty");
		regionalCityInsertion("Asia","Amman");
		regionalCityInsertion("Asia","Anadyr");
		regionalCityInsertion("Asia","Aqtau");
		regionalCityInsertion("Asia","Aqtobe");
		regionalCityInsertion("Asia","Ashgabat");
		regionalCityInsertion("Asia","Ashkhabad");
		regionalCityInsertion("Asia","Atyrau");
		regionalCityInsertion("Asia","Baghdad");
		regionalCityInsertion("Asia","Bahrain");
		regionalCityInsertion("Asia","Baku");
		regionalCityInsertion("Asia","Bangkok");
		regionalCityInsertion("Asia","Barnaul");
		regionalCityInsertion("Asia","Beirut");
		regionalCityInsertion("Asia","Bishkek");
		regionalCityInsertion("Asia","Brunei");
		regionalCityInsertion("Asia","Calcutta");
		regionalCityInsertion("Asia","Chita");
		regionalCityInsertion("Asia","Choibalsan");
		regionalCityInsertion("Asia","Chongqing");
		regionalCityInsertion("Asia","Chungking");
		regionalCityInsertion("Asia","Colombo");
		regionalCityInsertion("Asia","Dacca");
		regionalCityInsertion("Asia","Damascus");
		regionalCityInsertion("Asia","Dhaka");
		regionalCityInsertion("Asia","Dili");
		regionalCityInsertion("Asia","Dubai");
		regionalCityInsertion("Asia","Dushanbe");
		regionalCityInsertion("Asia","Famagusta");
		regionalCityInsertion("Asia","Gaza");
		regionalCityInsertion("Asia","Harbin");
		regionalCityInsertion("Asia","Hebron");
		regionalCityInsertion("Asia","Ho_Chi_Minh");
		regionalCityInsertion("Asia","Hong_Kong");
		regionalCityInsertion("Asia","Hovd");
		regionalCityInsertion("Asia","Irkutsk");
		regionalCityInsertion("Asia","Istanbul");
		regionalCityInsertion("Asia","Jakarta");
		regionalCityInsertion("Asia","Jayapura");
		regionalCityInsertion("Asia","Jerusalem");
		regionalCityInsertion("Asia","Kabul");
		regionalCityInsertion("Asia","Kamchatka");
		regionalCityInsertion("Asia","Karachi");
		regionalCityInsertion("Asia","Kashgar");
		regionalCityInsertion("Asia","Kathmandu");
		regionalCityInsertion("Asia","Katmandu");
		regionalCityInsertion("Asia","Khandyga");
		regionalCityInsertion("Asia","Kolkata");
		regionalCityInsertion("Asia","Krasnoyarsk");
		regionalCityInsertion("Asia","Kuala_Lumpur");
		regionalCityInsertion("Asia","Kuching");
		regionalCityInsertion("Asia","Kuwait");
		regionalCityInsertion("Asia","Macao");
		regionalCityInsertion("Asia","Macau");
		regionalCityInsertion("Asia","Magadan");
		regionalCityInsertion("Asia","Makassar");
		regionalCityInsertion("Asia","Manila");
		regionalCityInsertion("Asia","Muscat");
		regionalCityInsertion("Asia","Nicosia");
		regionalCityInsertion("Asia","Novokuznetsk");
		regionalCityInsertion("Asia","Novosibirsk");
		regionalCityInsertion("Asia","Omsk");
		regionalCityInsertion("Asia","Oral");
		regionalCityInsertion("Asia","Phnom_Penh");
		regionalCityInsertion("Asia","Pontianak");
		regionalCityInsertion("Asia","Pyongyang");
		regionalCityInsertion("Asia","Qatar");
		regionalCityInsertion("Asia","Qyzylorda");
		regionalCityInsertion("Asia","Rangoon");
		regionalCityInsertion("Asia","Riyadh");
		regionalCityInsertion("Asia","Saigon");
		regionalCityInsertion("Asia","Sakhalin");
		regionalCityInsertion("Asia","Samarkand");
		regionalCityInsertion("Asia","Seoul");
		regionalCityInsertion("Asia","Shanghai");
		regionalCityInsertion("Asia","Singapore");
		regionalCityInsertion("Asia","Srednekolymsk");
		regionalCityInsertion("Asia","Taipei");
		regionalCityInsertion("Asia","Tashkent");
		regionalCityInsertion("Asia","Tbilisi");
		regionalCityInsertion("Asia","Tehran");
		regionalCityInsertion("Asia","Tel_Aviv");
		regionalCityInsertion("Asia","Thimbu");
		regionalCityInsertion("Asia","Thimphu");
		regionalCityInsertion("Asia","Tokyo");
		regionalCityInsertion("Asia","Tomsk");
		regionalCityInsertion("Asia","Ujung_Pandang");
		regionalCityInsertion("Asia","Ulaanbaatar");
		regionalCityInsertion("Asia","Ulan_Bator");
		regionalCityInsertion("Asia","Urumqi");
		regionalCityInsertion("Asia","Ust-Nera");
		regionalCityInsertion("Asia","Vientiane");
		regionalCityInsertion("Asia","Vladivostok");
		regionalCityInsertion("Asia","Yakutsk");
		regionalCityInsertion("Asia","Yangon");
		regionalCityInsertion("Asia","Yekaterinburg");
		regionalCityInsertion("Asia","Yerevan");
		regionalCityInsertion("Atlantic","Azores");
		regionalCityInsertion("Atlantic","Bermuda");
		regionalCityInsertion("Atlantic","Canary");
		regionalCityInsertion("Atlantic","Cape_Verde");
		regionalCityInsertion("Atlantic","Faeroe");
		regionalCityInsertion("Atlantic","Faroe");
		regionalCityInsertion("Atlantic","Jan_Mayen");
		regionalCityInsertion("Atlantic","Madeira");
		regionalCityInsertion("Atlantic","Reykjavik");
		regionalCityInsertion("Atlantic","South_Georgia");
		regionalCityInsertion("Atlantic","St_Helena");
		regionalCityInsertion("Atlantic","Stanley");
		regionalCityInsertion("Australia","ACT");
		regionalCityInsertion("Australia","Adelaide");
		regionalCityInsertion("Australia","Brisbane");
		regionalCityInsertion("Australia","Broken_Hill");
		regionalCityInsertion("Australia","Canberra");
		regionalCityInsertion("Australia","Currie");
		regionalCityInsertion("Australia","Darwin");
		regionalCityInsertion("Australia","Eucla");
		regionalCityInsertion("Australia","Hobart");
		regionalCityInsertion("Australia","LHI");
		regionalCityInsertion("Australia","Lindeman");
		regionalCityInsertion("Australia","Lord_Howe");
		regionalCityInsertion("Australia","Melbourne");
		regionalCityInsertion("Australia","NSW");
		regionalCityInsertion("Australia","North");
		regionalCityInsertion("Australia","Perth");
		regionalCityInsertion("Australia","Queensland");
		regionalCityInsertion("Australia","South");
		regionalCityInsertion("Australia","Sydney");
		regionalCityInsertion("Australia","Tasmania");
		regionalCityInsertion("Australia","Victoria");
		regionalCityInsertion("Australia","West");
		regionalCityInsertion("Australia","Yancowinna");
		regionalCityInsertion("Brazil","Acre");
		regionalCityInsertion("Brazil","DeNoronha");
		regionalCityInsertion("Brazil","East");
		regionalCityInsertion("Brazil","West");
		regionalCityInsertion("Canada","Atlantic");
		regionalCityInsertion("Canada","Central");
		regionalCityInsertion("Canada","Eastern");
		regionalCityInsertion("Canada","Mountain");
		regionalCityInsertion("Canada","Newfoundland");
		regionalCityInsertion("Canada","Pacific");
		regionalCityInsertion("Canada","Saskatchewan");
		regionalCityInsertion("Canada","Yukon");
		regionalCityInsertion("Chile","Continental");
		regionalCityInsertion("Chile","EasterIsland");
		regionalCityInsertion("Europe","Amsterdam");
		regionalCityInsertion("Europe","Andorra");
		regionalCityInsertion("Europe","Astrakhan");
		regionalCityInsertion("Europe","Athens");
		regionalCityInsertion("Europe","Belfast");
		regionalCityInsertion("Europe","Belgrade");
		regionalCityInsertion("Europe","Berlin");
		regionalCityInsertion("Europe","Bratislava");
		regionalCityInsertion("Europe","Brussels");
		regionalCityInsertion("Europe","Bucharest");
		regionalCityInsertion("Europe","Budapest");
		regionalCityInsertion("Europe","Busingen");
		regionalCityInsertion("Europe","Chisinau");
		regionalCityInsertion("Europe","Copenhagen");
		regionalCityInsertion("Europe","Dublin");
		regionalCityInsertion("Europe","Gibraltar");
		regionalCityInsertion("Europe","Guernsey");
		regionalCityInsertion("Europe","Helsinki");
		regionalCityInsertion("Europe","Isle_of_Man");
		regionalCityInsertion("Europe","Istanbul");
		regionalCityInsertion("Europe","Jersey");
		regionalCityInsertion("Europe","Kaliningrad");
		regionalCityInsertion("Europe","Kiev");
		regionalCityInsertion("Europe","Kirov");
		regionalCityInsertion("Europe","Lisbon");
		regionalCityInsertion("Europe","Ljubljana");
		regionalCityInsertion("Europe","London");
		regionalCityInsertion("Europe","Luxembourg");
		regionalCityInsertion("Europe","Madrid");
		regionalCityInsertion("Europe","Malta");
		regionalCityInsertion("Europe","Mariehamn");
		regionalCityInsertion("Europe","Minsk");
		regionalCityInsertion("Europe","Monaco");
		regionalCityInsertion("Europe","Moscow");
		regionalCityInsertion("Europe","Nicosia");
		regionalCityInsertion("Europe","Oslo");
		regionalCityInsertion("Europe","Paris");
		regionalCityInsertion("Europe","Podgorica");
		regionalCityInsertion("Europe","Prague");
		regionalCityInsertion("Europe","Riga");
		regionalCityInsertion("Europe","Rome");
		regionalCityInsertion("Europe","Samara");
		regionalCityInsertion("Europe","San_Marino");
		regionalCityInsertion("Europe","Sarajevo");
		regionalCityInsertion("Europe","Saratov");
		regionalCityInsertion("Europe","Simferopol");
		regionalCityInsertion("Europe","Skopje");
		regionalCityInsertion("Europe","Sofia");
		regionalCityInsertion("Europe","Stockholm");
		regionalCityInsertion("Europe","Tallinn");
		regionalCityInsertion("Europe","Tirane");
		regionalCityInsertion("Europe","Tiraspol");
		regionalCityInsertion("Europe","Ulyanovsk");
		regionalCityInsertion("Europe","Uzhgorod");
		regionalCityInsertion("Europe","Vaduz");
		regionalCityInsertion("Europe","Vatican");
		regionalCityInsertion("Europe","Vienna");
		regionalCityInsertion("Europe","Vilnius");
		regionalCityInsertion("Europe","Volgograd");
		regionalCityInsertion("Europe","Warsaw");
		regionalCityInsertion("Europe","Zagreb");
		regionalCityInsertion("Europe","Zaporozhye");
		regionalCityInsertion("Europe","Zurich");
		regionalCityInsertion("Indian","Antananarivo");
		regionalCityInsertion("Indian","Chagos");
		regionalCityInsertion("Indian","Christmas");
		regionalCityInsertion("Indian","Cocos");
		regionalCityInsertion("Indian","Comoro");
		regionalCityInsertion("Indian","Kerguelen");
		regionalCityInsertion("Indian","Mahe");
		regionalCityInsertion("Indian","Maldives");
		regionalCityInsertion("Indian","Mauritius");
		regionalCityInsertion("Indian","Mayotte");
		regionalCityInsertion("Indian","Reunion");
		regionalCityInsertion("Pacific","Apia");
		regionalCityInsertion("Pacific","Auckland");
		regionalCityInsertion("Pacific","Bougainville");
		regionalCityInsertion("Pacific","Chatham");
		regionalCityInsertion("Pacific","Chuuk");
		regionalCityInsertion("Pacific","Easter");
		regionalCityInsertion("Pacific","Efate");
		regionalCityInsertion("Pacific","Enderbury");
		regionalCityInsertion("Pacific","Fakaofo");
		regionalCityInsertion("Pacific","Fiji");
		regionalCityInsertion("Pacific","Funafuti");
		regionalCityInsertion("Pacific","Galapagos");
		regionalCityInsertion("Pacific","Gambier");
		regionalCityInsertion("Pacific","Guadalcanal");
		regionalCityInsertion("Pacific","Guam");
		regionalCityInsertion("Pacific","Honolulu");
		regionalCityInsertion("Pacific","Johnston");
		regionalCityInsertion("Pacific","Kiritimati");
		regionalCityInsertion("Pacific","Kosrae");
		regionalCityInsertion("Pacific","Kwajalein");
		regionalCityInsertion("Pacific","Majuro");
		regionalCityInsertion("Pacific","Marquesas");
		regionalCityInsertion("Pacific","Midway");
		regionalCityInsertion("Pacific","Nauru");
		regionalCityInsertion("Pacific","Niue");
		regionalCityInsertion("Pacific","Norfolk");
		regionalCityInsertion("Pacific","Noumea");
		regionalCityInsertion("Pacific","Pago_Pago");
		regionalCityInsertion("Pacific","Palau");
		regionalCityInsertion("Pacific","Pitcairn");
		regionalCityInsertion("Pacific","Pohnpei");
		regionalCityInsertion("Pacific","Ponape");
		regionalCityInsertion("Pacific","Port_Moresby");
		regionalCityInsertion("Pacific","Rarotonga");
		regionalCityInsertion("Pacific","Saipan");
		regionalCityInsertion("Pacific","Samoa");
		regionalCityInsertion("Pacific","Tahiti");
		regionalCityInsertion("Pacific","Tarawa");
		regionalCityInsertion("Pacific","Tongatapu");
		regionalCityInsertion("Pacific","Truk");
		regionalCityInsertion("Pacific","Wake");
		regionalCityInsertion("Pacific","Wallis");
		regionalCityInsertion("Pacific","Yap");
		regionalCityInsertion("US","Alaska");
		regionalCityInsertion("US","Aleutian");
		regionalCityInsertion("US","Arizona");
		regionalCityInsertion("US","Central");
		regionalCityInsertion("US","East-Indiana");
		regionalCityInsertion("US","Eastern");
		regionalCityInsertion("US","Hawaii");
		regionalCityInsertion("US","Indiana-Starke");
		regionalCityInsertion("US","Michigan");
		regionalCityInsertion("US","Mountain");
		regionalCityInsertion("US","Pacific");
		regionalCityInsertion("US","Pacific-New");
		regionalCityInsertion("US","Samoa");
		
		return regionCityMap;
	}
	
	public static HashMap<String, LinkedList<String>> getSystemShortPairings(){
		systemShortInsertion("SystemV","AST4");
		systemShortInsertion("SystemV","AST4ADT");
		systemShortInsertion("SystemV","CST6");
		systemShortInsertion("SystemV","CST6CDT");
		systemShortInsertion("SystemV","EST5");
		systemShortInsertion("SystemV","EST5EDT");
		systemShortInsertion("SystemV","HST10");
		systemShortInsertion("SystemV","MST7");
		systemShortInsertion("SystemV","MST7MDT");
		systemShortInsertion("SystemV","PST8");
		systemShortInsertion("SystemV","PST8PDT");
		systemShortInsertion("SystemV","YST9");
		systemShortInsertion("SystemV","YST9YDT");
		systemShortInsertion("Etc","GMT");
		systemShortInsertion("Etc","GMT0");
		systemShortInsertion("Etc","Greenwich");
		systemShortInsertion("Etc","UCT");
		systemShortInsertion("Etc","UTC");
		systemShortInsertion("Etc","Universal");
		systemShortInsertion("Etc","Zulu");


		return systemShortMap;
	}
	
	public static HashMap<String, LinkedList<Integer>> getShortGmtPairings(){
		
		//Method still in progress - need to figure out a way to extract only the int gmt offset
		//from the whole gmt string
		
		return shortGmtMap;
	}
	
	private static void regionalCityInsertion(String region, String city) {
		
		LinkedList<String> regionalCities;
		
		if(regionCityMap.containsKey(region)) {
			regionCityMap.get(region).add(city);
		}
		else {
			regionalCities = new LinkedList<String>();
			regionalCities.add(city);
			regionCityMap.put(region, regionalCities);
		}
		
	}
	
	private static void systemShortInsertion(String systemName, String shortID) {
		
		LinkedList<String> systemShorts;
		
		if(systemShortMap.containsKey(systemName)) {
			systemShortMap.get(systemName).add(shortID);
		}
		else {
			systemShorts = new LinkedList<String>();
			systemShorts.add(shortID);
			systemShortMap.put(systemName, systemShorts);
		}
		
	}
	
	//assumes region exists
	public static LinkedList<String> getRegionalCities(String region) { 
		
		return regionCityMap.get(region);
		
	}
	
	//assumes system name exists
	public static LinkedList<String> getSystemShorts(String systemName) {
		
		return systemShortMap.get(systemName);
		
	}
	
	
	
	
	

}
