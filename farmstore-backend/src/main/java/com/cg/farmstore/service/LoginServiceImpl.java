package com.cg.farmstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.cg.farmstore.dto.Response;
import com.cg.farmstore.entities.Credentials;
import com.cg.farmstore.entities.UserType;
import com.cg.farmstore.repository.ICredentialRepository;

@Service
public class LoginServiceImpl implements ILoginService {

	@Autowired
	private ICredentialRepository credentialRepo;

	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Override
	public Response validateLogin(Credentials credentials) {
		Credentials credential_db = credentialRepo.findByUsername(credentials.getUserName());
		if (credential_db != null) {
			if (bcryptEncoder.matches(credentials.getPassword(), credential_db.getPassword())) {
				if (credential_db.getUserType() == credentials.getUserType()
						&& UserType.FARMER == credential_db.getUserType())
					return new Response("Farmer");
				else if (credential_db.getUserType() == credentials.getUserType()
						&& UserType.SUPPLIER == credential_db.getUserType())
					return new Response("Supplier");
				else if (credential_db.getUserType() == credentials.getUserType()
						&& UserType.ADMIN == credential_db.getUserType())
					return new Response("Admin");
			}
		}
		return new Response("Invalid Credentials!");
	}
}
