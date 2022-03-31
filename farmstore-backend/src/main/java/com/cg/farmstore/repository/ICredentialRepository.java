package com.cg.farmstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.cg.farmstore.entities.Credentials;

@Repository
public interface ICredentialRepository extends JpaRepository<Credentials, String> {

	@Query(value = "Select * from credentialstable where username = ?1", nativeQuery = true)
	public Credentials findByUsername(String userName);

}

