package com.cg.farmstore.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.cg.farmstore.entities.Farmer;

@Repository
public interface IFarmerRepository extends JpaRepository<Farmer, Integer> {

	@Query(value = "Select * from farmertable where username IN (select username from credentialstable where username= ?1)", nativeQuery = true)
	Optional<Farmer> findByUsername(String username);

}
