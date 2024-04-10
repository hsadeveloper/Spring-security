package com.example.sabonchi.demoSecurity.entity;

import org.springframework.data.annotation.Id;

import lombok.Data;


public class Card{

	@Id
    private long id; 
    private String name; 
    private String password;
    private String note;
    
	public Card() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Card(String name, String password, String note) {
		super();
	
		this.name = name;
		this.password = password;
		this.note = note;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
    
    
    
    

}
