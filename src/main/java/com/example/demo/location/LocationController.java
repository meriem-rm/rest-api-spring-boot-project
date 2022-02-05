package com.example.demo.location;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LocationController {
	
	@Autowired
	private LocationService locationService;
     
	 @RequestMapping(value="/location")
	 List<Location> getLocation() {
		return locationService.getAllLocation();
		 
	 } 
	 
	 @RequestMapping(value="/location/{id}")
	 public Optional<Location> getLocation(@PathVariable String id ) {
		 return locationService.getLocation(id);
	 }
	
	 @RequestMapping(value="/location", method=RequestMethod.POST)
	 public void addLocation(@RequestBody Location location)  {
		 locationService.addLocation(location);
	 }
	 
	 @RequestMapping(value="/location/{id}", method = RequestMethod.PUT)
	 public void updateLocation(@RequestBody Location location, @PathVariable String id) {

	      locationService.updateLocation(id, location);
	 } 
	 
	 @RequestMapping(value="/location/{id}", method=RequestMethod.DELETE)	 
	 public void deleteLocation(@PathVariable String id ) {
		 locationService.deleteLocation(id);
	 }
	 
	 
	 
}
