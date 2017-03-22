package com.example.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Entities.Owner;

public interface OwnerRepository extends JpaRepository<Owner,Long> {
	Owner findByName(String ownerName);
}
