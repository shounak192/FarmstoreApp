package com.cg.farmstore.service;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.cg.farmstore.dto.CredentialPojo;
import com.cg.farmstore.entities.Credentials;
import com.cg.farmstore.entities.UserType;
import com.cg.farmstore.repository.ICredentialRepository;

@Service
public class JwtUserDetailsService implements UserDetailsService {
	private UserType userType;

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	@Autowired
	private ICredentialRepository iCredentialRepository;

	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User userData = null;
		Credentials credential = iCredentialRepository.findByUsername(username);
		if (credential == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		} else if ((credential.getUserType() == UserType.SUPPLIER) || (credential.getUserType() == UserType.FARMER)
				|| (credential.getUserType() == UserType.ADMIN)) {

			userData = new User(credential.getUserName(), credential.getPassword(), new ArrayList<>());
		}
		return userData;
	}

	public Credentials save(CredentialPojo credential) {
		Credentials newUser = new Credentials();
		newUser.setUserName(credential.getUserName());
		newUser.setPassword(bcryptEncoder.encode(credential.getPassword()));
		System.out.println(newUser.getPassword());
		newUser.setUserType(credential.getUserType());
		return iCredentialRepository.save(newUser);
	}
}
