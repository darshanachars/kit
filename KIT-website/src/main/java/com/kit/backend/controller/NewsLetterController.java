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
import com.kit.backend.entity.NewsLetter;
import com.kit.backend.service.NewsLetterService;

@RestController
public class NewsLetterController {
	@Autowired
	private NewsLetterService letterService;
	
	@GetMapping("/allBlog")
	public ResponseEntity< List<NewsLetter>> findAll(){
		List<NewsLetter> list = letterService.findAll();
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("blog/{id}")
	public ResponseEntity<NewsLetter> findById(@PathVariable String id){
		NewsLetter blog=letterService.findById(id);
		return ResponseEntity.ok(blog);
	}
	
	@PostMapping("/saveBlog")
	public ResponseEntity<NewsLetter> saveBlog(@RequestBody NewsLetter blog){
		NewsLetter newBlog=letterService.save(blog);
		return ResponseEntity.ok(newBlog);
	}
	
	@PutMapping("/updateBlog")
	public ResponseEntity<NewsLetter> updateBlog(@RequestBody NewsLetter blog){
		NewsLetter newBlog=letterService.update(blog);
		return ResponseEntity.ok(newBlog);
	}
	
	@DeleteMapping("/deleteBlog")
	public ResponseEntity<Map<String, String>> delete(@RequestBody NewsLetter blog){
		letterService.delete(blog);
		Map<String, String> map=new HashMap<>();
		map.put("Message", "Delete successfull");
		map.put("Status", "successful");     
		return ResponseEntity.ok(map);
	}          
}
