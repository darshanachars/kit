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
import com.kit.backend.entity.ContactUs;
import com.kit.backend.service.BlogService;
import com.kit.backend.service.ContactUsService;
@RestController
public class ContactUsController {
	@Autowired
	private ContactUsService contactUsService;
	
	@GetMapping("/allContacts")
	public ResponseEntity< List<ContactUs>> findAll(){
		List<ContactUs> list = contactUsService.findAll();
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("contact/{id}")
	public ResponseEntity<ContactUs> findById(@PathVariable String id){
		ContactUs contact=contactUsService.findById(id);
		return ResponseEntity.ok(contact);
	}
	
	@PostMapping("/saveContact")
	public ResponseEntity<ContactUs> saveContact(@RequestBody ContactUs contact){
		ContactUs con=contactUsService.saveContact(contact);
		return ResponseEntity.ok(con);
	}
	
	@PutMapping("/updateContact")
	public ResponseEntity<ContactUs> updateBlog(@RequestBody ContactUs contact){
		ContactUs con=contactUsService.update(contact);
		return ResponseEntity.ok(con);
	}
	
	@DeleteMapping("/deleteContact")
	public ResponseEntity<Map<String, String>> deleteBlog(@RequestBody ContactUs blog){
		contactUsService.delete(blog);
		Map<String, String> map=new HashMap<>();
		map.put("Message", "Delete successfull");
		map.put("Status", "successful");     
		return ResponseEntity.ok(map);
	}
}
