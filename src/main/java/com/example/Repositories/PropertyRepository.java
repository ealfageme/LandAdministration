package com.example.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Entities.Community;
import com.example.Entities.Property;

public interface PropertyRepository extends JpaRepository<Property,Long> {
	List<Property> findByNumberAndCommunity(int number,Community community);
	List<Property> findByNumberAndFloorAndCommunity(int number,int floor,Community community);
	
}
