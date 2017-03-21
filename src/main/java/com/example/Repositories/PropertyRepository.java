package com.example.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Entities.Property;

public interface PropertyRepository extends JpaRepository<Property,Long> {

}
