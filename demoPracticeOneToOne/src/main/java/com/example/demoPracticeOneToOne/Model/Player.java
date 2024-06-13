package com.example.demoPracticeOneToOne.Model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class Player {
    
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String email;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "profile_id",referencedColumnName  = "id")
	private Profile profile;
	
	public Profile getProfile() {
		return profile;
	}
	
	

	



	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Player(String name, String email) {
		super();
		this.name = name;
		this.email = email;
	}
	
	public Player() {
		super();
		// TODO Auto-generated constructor stub
	}

	public  Long getId()
	{
		return id;
	}
	
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	
}
