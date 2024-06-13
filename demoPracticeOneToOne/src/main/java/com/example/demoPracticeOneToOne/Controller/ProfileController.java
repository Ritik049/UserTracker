package com.example.demoPracticeOneToOne.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demoPracticeOneToOne.Model.Player;
import com.example.demoPracticeOneToOne.Model.Profile;
import com.example.demoPracticeOneToOne.Service.PlayerService;
import com.example.demoPracticeOneToOne.Service.ProfileService;
@RestController
@RequestMapping("/profile")
public class ProfileController {

	
	 @Autowired
	 ProfileService service;
	 
	 //CRUD
	 @GetMapping("/")
	 public List<Profile> getAll()
	 {
		 return service.getAll();
	 }
	 
	 @GetMapping("/{id}")
	 public Profile getPlayer(@PathVariable Long id)
	 {
		 return service.getProfile(id);
	 }
	 
	 @PostMapping("/create")
	 public Profile create(@RequestBody Profile profile)
	 {
		 return service.createProfile(profile);
	 }
	 
	 @PutMapping("/update/{id}")
	 public Profile update(@PathVariable Long id,@RequestBody Profile profile)
	 {
		 return service.updateProfile(id,profile);
	 }
	 
	 @DeleteMapping("/delete/{id}")
	 public String delete(@PathVariable Long id)
	 {
		 service.deleteProfile(id);
		 
		return "Successfully deleted";
	 }
	 
	 
}
