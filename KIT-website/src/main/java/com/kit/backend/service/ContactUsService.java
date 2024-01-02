package com.kit.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kit.backend.entity.ContactUs;

import com.kit.backend.repo.ContactUsRepo;
@Service
public class ContactUsService {
	@Autowired
	private ContactUsRepo contactUsRepo;
	
	public List<ContactUs> findAll(){
		List<ContactUs> list = contactUsRepo.findAll();
		return list;
	}
	
	public ContactUs findById(String id) {
		ContactUs contacts = contactUsRepo.findById(id).orElseThrow(null);
		return contacts;
	}
	
	public ContactUs saveContact(ContactUs contact) {
		ContactUs con=contactUsRepo.save(contact);
		return con;
	}

	public ContactUs update(ContactUs contact) {
		String id = contact.getId();
		ContactUs con = contactUsRepo.findById(id).orElseThrow(null);
		con.setEmail(contact.getEmail());
		
		
		ContactUs updatedContact= contactUsRepo.save(con);
		return updatedContact;
	}
	
	public void delete(ContactUs contact) {
		contactUsRepo.delete(contact);
		
	}
}
