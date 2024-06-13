package com.example.demoPracticeOneToOne.Model.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demoPracticeOneToOne.Model.Player;

@Repository
public interface PlayerRepository  extends JpaRepository<Player,Long>{
   
	Player findByprofile_id(Long Id);
}
