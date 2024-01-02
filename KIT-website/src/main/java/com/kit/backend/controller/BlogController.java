package com.kit.backend.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kit.backend.entity.Blog;
import com.kit.backend.service.BlogService;

@RestController
public class BlogController {
	@Autowired
	private BlogService blogService;
	
	@GetMapping("/allBlog")
	public ResponseEntity< List<Blog>> findAll(){
		List<Blog> list = blogService.findAll();
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("blog/{id}")
	public ResponseEntity<Blog> findById(@PathVariable String id){
		Blog blog=blogService.findById(id);
		return ResponseEntity.ok(blog);
	}
	
	@PostMapping("/saveBlog")
	public ResponseEntity<Blog> saveBlog(@RequestBody Blog blog){
		Blog newBlog=blogService.saveBlog(blog);
		return ResponseEntity.ok(newBlog);
	}
	
	@PutMapping("/updateBlog")
	public ResponseEntity<Blog> updateBlog(@RequestBody Blog blog){
		Blog newBlog=blogService.update(blog);
		return ResponseEntity.ok(newBlog);
	}
	
	@DeleteMapping("/deleteBlog")
	public ResponseEntity<Map<String, String>> deleteBlog(@RequestBody Blog blog){
		blogService.delete(blog);
		Map<String, String> map=new HashMap<>();
		map.put("Message", "Delete successfull");
		map.put("Status", "successful");     
		return ResponseEntity.ok(map);
	}
}
