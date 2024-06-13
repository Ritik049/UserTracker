package com.example.demoPracticeOneToOne.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demoPracticeOneToOne.Model.Player;
import com.example.demoPracticeOneToOne.Model.Profile;
import com.example.demoPracticeOneToOne.Model.Repository.PlayerRepository;

@Service
public class PlayerService {
     
	
	//CRUD
	@Autowired
	PlayerRepository playerRepo;
	
	
	public Player createPlayer(Player player)
	{
	  
		return playerRepo.save(player);
	
	}
	
	public List<Player>getAll()
	{ 
		List<Player> lst = playerRepo.findAll();
		return playerRepo.findAll();
	}
	
	public Player getPlayer(Long id)
	{
		return playerRepo.findById(id).get();
	}
	
	public Player updatePlayer(Long id, Player player)
	{
		Player svdPlayer = playerRepo.findById(id).get();
		svdPlayer.setEmail(player.getEmail());
		svdPlayer.setName(player.getName());
		svdPlayer.setProfile(player.getProfile());
		
		return playerRepo.save(svdPlayer);
	}
	
	public void deletePlayer(Long id)
	{
		playerRepo.deleteById(id);
	}
	
	//Assigining profile
	
	public Player assignProfile(Profile profile,Long id)
	{
		Player player = playerRepo.findById(id).get();
		player.setProfile(profile);
		
	  return playerRepo.save(player);
	}
	

	
	
}
