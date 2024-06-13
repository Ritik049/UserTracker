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
@RequestMapping("/player")
public class PlayerController {
	
	@Autowired
	PlayerService service;
	
	@Autowired 
	ProfileService profService;
    
	
	@GetMapping("/")
	public List<Player> getAll()
	{
		return service.getAll();
	}
	
	@GetMapping("/{id}")
	public Player getPlayer(@PathVariable Long id)
	{
		return service.getPlayer(id);
	}
	
	@PostMapping("/create")
	public Player create(@RequestBody Player player)
	{
		return service.createPlayer(player);
	}
	
	@PutMapping("/update/{id}")
	public Player update(@PathVariable Long id,@ RequestBody Player player)
	{
		return service.updatePlayer(id,player);
	}
	
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable Long id)
	{
		service.deletePlayer(id);
		return "Successfully deleted";
	}
	
	@PutMapping("/{id}/assignProfile/{profId}")
	public Player assignProfile(@PathVariable Long id, @PathVariable Long profId)
	{
		Player player = service.getPlayer(id);
		
		Profile profile = profService.getProfile(profId);
		
		return service.assignProfile(profile, id);
		
	}
	
	
	
	

}
