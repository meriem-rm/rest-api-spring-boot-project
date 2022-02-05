package com.example.demo.post;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, String> {
   List<Post> findByUserId(String userId); 
   List<Post> findBypostdate(String postDate);
}
