package com.example.demoPracticeOneToOne.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demoPracticeOneToOne.Model.Player;
import com.example.demoPracticeOneToOne.Model.Profile;
import com.example.demoPracticeOneToOne.Model.Repository.PlayerRepository;
import com.example.demoPracticeOneToOne.Model.Repository.ProfileRepository;

@Service
public class ProfileService {
    
	@Autowired
	ProfileRepository profileRepo;
	
	@Autowired
	PlayerRepository playerRepo;
	
	
	//CRUD
	public Profile  createProfile(Profile profile)
	{
		return profileRepo.save(profile);
	}
	
	public List<Profile> getAll()
	{  List<Profile> lst = profileRepo.findAll();
		return lst;
	}
	
	public Profile getProfile(Long id)
	{
		return profileRepo.findById(id).get();
	}
	
	public Profile updateProfile(Long id,Profile profile)
	{  
		Profile svdProfile = profileRepo.findById(id).get();
		svdProfile.setName(profile.getName());
		return profileRepo.save(svdProfile);
	}
	
	public void deleteProfile(Long id)
	{
	  // profileRepo.deleteById(id);   need to set null;
		Player player = playerRepo.findByprofile_id(id);
		
		player.setProfile(null);
		playerRepo.save(player);
		profileRepo.deleteById(id);
	}
}
