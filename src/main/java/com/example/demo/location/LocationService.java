package com.example.demo.location;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class LocationService {
	 Location location1 = new Location("22", "kherrata");
	 Location location2 = new Location("24", "bejaia");
	 Location location3 = new Location("l2", "oran");
	 
	List<Location> locations = new ArrayList<>(Arrays.asList(location1, location2, location3));	 
	
	List<Location> getLocation() {
        return locations; 
	 }  
	
	Location getoneLocation(String id) {
		Location location = locations.stream()
				       .filter(t -> id.equals(t.getId()))
				       .findFirst()
				       .orElse(null);
		return location;
	}

	public void addLocation(Location location) {
		 locations.add(location);
	}

	public void updateLocation(String id, Location location) {

		   for(int i = 0; i < locations.size(); i++) {

			Location l = locations.get(i);

			if (l.getId().equals(id)) {
			    locations.set(i, location);
			    return ;
			}
		   }		
		}

	public void deleteLocation(String id) {
		locations.removeIf(t -> t.getId().equals(id));
		
	}
}
