package com.kit.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kit.backend.entity.Blog;
import com.kit.backend.entity.NewsLetter;
import com.kit.backend.repo.NewsLetterRepo;

@Service
public class NewsLetterService {
	@Autowired
	private NewsLetterRepo letterRepo;
	
	public List<NewsLetter> findAll(){
		List<NewsLetter> list = letterRepo.findAll();
		return list;
	}
	
	public NewsLetter findById(String id) {
		NewsLetter letter = letterRepo.findById(id).orElseThrow(null);
		return letter ;
	}
	
	public NewsLetter save(NewsLetter le) {
		NewsLetter letter=letterRepo.save(le);
		return letter;
	}

	public NewsLetter update(NewsLetter blog) {
		String id = blog.getId();
		NewsLetter blog1 = letterRepo.findById(id).orElseThrow(null);
		blog1.setEmail(blog.getEmail());
		
		
		NewsLetter updated = letterRepo.save(blog1);
		return updated;
	}
	
	public void delete(NewsLetter blog) {
		letterRepo.delete(blog);
		
	}
}
