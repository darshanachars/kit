package com.kit.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kit.backend.entity.Blog;
import com.kit.backend.repo.BlogRepo;

@Service
public class BlogService {
	@Autowired
	private BlogRepo blogRepo;
	
	public List<Blog> findAll(){
		List<Blog> list = blogRepo.findAll();
		return list;
	}
	
	public Blog findById(String id) {
		Blog blog = blogRepo.findById(id).orElseThrow(null);
		return blog;
	}
	
	public Blog saveBlog(Blog blog) {
		Blog blog1=blogRepo.save(blog);
		return blog1;
	}

	public Blog update(Blog blog) {
		String id = blog.getId();
		Blog blog1 = blogRepo.findById(id).orElseThrow(null);
		blog1.setCategory(blog.getCategory());
		blog1.setPost(blog.getPost());
		
		Blog updatedBlog = blogRepo.save(blog1);
		return updatedBlog;
	}
	
	public void delete(Blog blog) {
		blogRepo.delete(blog);
		
	}

}
