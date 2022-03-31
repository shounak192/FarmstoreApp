package com.cg.farmstore.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.cg.farmstore.entities.Supplier;

@Repository
public interface ISupplierRepository extends JpaRepository<Supplier, Integer> {

	@Query(value = "select supplier_id from supplier where username =?1)", nativeQuery = true)
	int findByName(String userName);

	@Query(value = "Select * from supplier where username IN (select username from credentialstable where username= ?1)", nativeQuery = true)
	Optional<Supplier> findByUsername(String username);
	

	
}
