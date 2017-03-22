package com.example.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Entities.Community;


public interface CommunityRepository extends JpaRepository<Community,Long>{
	Community findById(long id );
	Community findByCif(String cif);
}
