package com.example.demo.post;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.location.Location;
import com.example.demo.user.User;

@Service
public class PostService {

	User user1 = new User("ui",
	        "spring boot",
	        "ui", new Location("22", "kherrata"), "meriem@gmail.com");
	User user2 = new User("u2",
	        "spring boot",
	        "ui", new Location("19", "alger"), "meriem@gmail.com");
	 
	Post post1 = new Post("1", "22-02-2022", user1, "smart person");
	Post post2 = new Post("2", "22-02-2022", user2, "smart person 2");
	List<Post> posts = new ArrayList<>( Arrays.asList(post1, post2)); 
	
	public List<Post> getAllPosts() {
		return posts;
	} 
	
	public Post getPost(String id) {
		Post post = posts.stream()
				.filter(p -> id.equals(p.getId()))
				.findFirst()
				.orElse(null);
		return post;
	}

	public void createPost(Post post) {
       posts.add(post)		;
	}

	public void updatePost(String id, Post post) {
		for(int i = 0; i < posts.size(); i++) {
			Post p = posts.get(i);
			if(p.getId().equals(id)) {
				posts.set(i, post);
			}
		}
		
	}

	public void deletePost(String id) {
		posts.removeIf(t -> t.getId().equals(id));
		
	} 
}
