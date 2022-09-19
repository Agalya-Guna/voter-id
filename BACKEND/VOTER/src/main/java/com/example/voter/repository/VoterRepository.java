package com.example.voter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.voter.entity.Voter;

@Repository
public interface VoterRepository extends JpaRepository<Voter, Integer>{

}
