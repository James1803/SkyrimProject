package com.qa.skyrim.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.skyrim.dto.NewPostDTO;
import com.qa.skyrim.dto.PostDTO;
import com.qa.skyrim.dto.UpdatePostDTO;
import com.qa.skyrim.service.PostService;



@RestController
@RequestMapping(path = "/post")
@CrossOrigin("*")
public class PostController {
	
	// TODO: 8. Convert this class to use the post DTOs

	private PostService postService;
	
	@Autowired
	public PostController(PostService postService) {
		this.postService = postService;
	}
	
	@GetMapping
	public ResponseEntity<List<PostDTO>> getPosts() {
		return ResponseEntity.ok(postService.getPosts());
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<PostDTO> getPost(@PathVariable(name = "id") int id) {
		return ResponseEntity.ok(postService.getPost(id));
	}
	
	@PostMapping
	public ResponseEntity<PostDTO> createPost(@Valid @RequestBody NewPostDTO post) {
		PostDTO newPost = postService.createPost(post);
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Location", "http://localhost:8080/post/" + newPost.getId());

		return new ResponseEntity<>(newPost, headers, HttpStatus.CREATED);
	}
	
	@PutMapping(path = "/{id}")
	public ResponseEntity<PostDTO> updatePost(@Valid @RequestBody UpdatePostDTO post, @PathVariable(name = "id") int id) {
		return ResponseEntity.ok(postService.updatePost(post, id));
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<?> deletePost(@PathVariable(name = "id") int id) {
		PostDTO deletedPost = postService.getPost(id);
		postService.deletePost(id);
		return ResponseEntity.ok(deletedPost);
	}
}