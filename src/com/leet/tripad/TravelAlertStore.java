package com.leet.tripad;

import java.util.HashMap;
import java.util.List;

public class TravelAlertStore {
	class TravelAlert {
	      int id;
	      String message;
	      int locationId;
	 }

	 static class Location {
	      int locationId;
	      int parentLocationId; // -1 if no parent, location is hierarchy
	      String name;

	      public static Location findLocation(int locationId) { return null; }
	 }
	 
	 private List<TravelAlert> lAlerts; // already populated, static

     // Return null if no alert
     public TravelAlert findBestTravelAlert(int locationId) {
     // implement this
    	 TravelAlert result = null;
    	 // Convert list to map
    	 HashMap<Integer,TravelAlert> alertMap = new HashMap<Integer,TravelAlert>();
    	 for (TravelAlert a : lAlerts) {
    	     alertMap.put(a.locationId, a);
    	 }

    	 // search the map with the given locationId as well as parentIds of the locationId
    	 while (result == null && locationId > 0) {
    	     result = alertMap.get(locationId);
    	     locationId = Location.findLocation(locationId).parentLocationId;
    	 }

    	 // TravelAlert returned
    	 // if there are no more parentIds, result will still be null
    	 return result;
     }
}
