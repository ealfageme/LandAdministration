package Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import Entities.Owner;

public interface OwnerRepository extends JpaRepository<Owner,Long> {

}
