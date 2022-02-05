package com.example.demo.user;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.location.Location;

@Service
public class UserService {

	User user1 = new User("ui",
	        "spring boot",
	        "ui", 
	        new Location("22", "kherrata"), 
	        "meriem@gmail.com"
	        );
	
	User user2 = new User("u2",
	        "spring boot",
	        "ui", 
	        new Location("19", "alger"), 
	        "meriem@gmail.com"
	        );
	 
	private List<User> users = new ArrayList<>(Arrays.asList(user1, user2));
	 public List<User> getAllUsers() {
		 return users;

	}  
	 
	public User getUser(String id) {
		// search for id in the list by filtering it 
		// stream is a method that returns a sequential data from list 
		User user = users.stream()
				.filter(t -> id.equals(t.getId()))
				.findFirst()
				.orElse(null);
		return user;
	}

	public void createUser(User user) {
		users.add(user);
		
	}

	public void updateUser(String id, User user) {
		for(int i = 0; i < users.size(); i++ ) {
			User u = users.get(i);
			if(u.getId().equals(id)) {
				users.set(i, user); 
				
			}
		}
		
	}

	public void deleteUser(String id) {
		users.removeIf(t -> t.getId().equals(id));
		
	}
	 
	
}
