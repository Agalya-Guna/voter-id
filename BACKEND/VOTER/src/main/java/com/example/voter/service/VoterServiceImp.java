package com.example.voter.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.voter.entity.Voter;
import com.example.voter.exception.AlreadyFoundException;
import com.example.voter.repository.VoterRepository;
@Service
public class VoterServiceImp implements VoterService{

	@Autowired
	VoterRepository repo;
	
	@Override
	public Voter add(Voter vote) {
		Voter exist=repo.findById(vote.getId()).orElse(null);
		if(exist== null) {
			String name=vote.getName();
			if(vote.getGender().equalsIgnoreCase("Male")) {
				vote.setName("Mr. "+name);
			}else if(vote.getGender().equalsIgnoreCase("Female")) {
				vote.setName("Ms. "+name);
			}
			else {
				vote.setName("Mx. "+name);
			}
			
			repo.save(vote);
			return vote;
		}
		else {
			throw new AlreadyFoundException();
		}
	}

}
