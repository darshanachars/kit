package com.kit.backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class ContactUs {
	@Id
	private String id;
	private String email;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
