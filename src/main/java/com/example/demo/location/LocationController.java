package com.example.demo.location;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LocationController {
	
	@Autowired
	private LocationService locationService;
     
	@RequestMapping(value = "/locations")
	 public String getAllLocations(Model model) 
	 {				
		model.addAttribute("locations", locationService.getAllLocation());		
		return "location";		
	 }
	 
	 @RequestMapping(value="/locations/{id}")
	 public Optional<Location> getLocation(@PathVariable String id ) {
		 return locationService.getLocation(id);
	 }
	
	 @RequestMapping(value="/locations", method=RequestMethod.POST)
	 public void addLocation(@RequestBody Location location)  {
		 locationService.addLocation(location);
	 }
	 
	 @RequestMapping(value="/locations/{id}", method = RequestMethod.PUT)
	 public void updateLocation(@RequestBody Location location, @PathVariable String id) {

	      locationService.updateLocation(id, location);
	 } 
	 
	 @RequestMapping(value="/locations/{id}", method=RequestMethod.DELETE)	 
	 public void deleteLocation(@PathVariable String id ) {
		 locationService.deleteLocation(id);
	 }
	 
	 
	 
}
