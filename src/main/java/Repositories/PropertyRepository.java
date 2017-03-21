package Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import Entities.Property;

public interface PropertyRepository extends JpaRepository<Property,Long> {

}
