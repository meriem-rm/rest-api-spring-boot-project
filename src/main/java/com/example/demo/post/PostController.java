package com.example.demo.post;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PostController {

	@Autowired 
	private PostService postService;
	
	@RequestMapping(value="/posts")
	List<Post> getAllPost() {
		return postService.getAllPosts();
	} 
	
	@RequestMapping(value="posts/{id}")
	Post getPost(@PathVariable String id) {
		return postService.getPost(id);
	} 
	
	@RequestMapping(value="/posts", method=RequestMethod.POST)
	public void createPost(@RequestBody  Post post) {
		postService.createPost(post);
	} 
	
	@RequestMapping(value="/posts/{id}", method=RequestMethod.PUT)
	public void updatePost(@PathVariable String id, @RequestBody Post post) {
		postService.updatePost(id, post);
	}
	
	@RequestMapping(value="/posts/{id}", method=RequestMethod.DELETE)	
	public void deletePost(@PathVariable  String id) {
		postService.deletePost(id);
	}
	
	
}
