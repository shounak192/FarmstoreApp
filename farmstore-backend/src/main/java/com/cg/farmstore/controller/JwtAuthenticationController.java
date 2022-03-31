package com.cg.farmstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.cg.farmstore.config.JwtTokenUtil;
import com.cg.farmstore.dto.Response;
import com.cg.farmstore.entities.Credentials;
import com.cg.farmstore.entities.JwtRequest;
import com.cg.farmstore.entities.JwtResponse;
import com.cg.farmstore.service.JwtUserDetailsService;
import com.cg.farmstore.service.LoginServiceImpl;

@RestController
@CrossOrigin(origins = "*")
public class JwtAuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private JwtUserDetailsService userDetailsService;

	@Autowired
	private LoginServiceImpl loginServiceImpl;

	@PostMapping(value = "/login")
	public ResponseEntity<JwtResponse> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest)
			throws Exception {
		System.out.println(authenticationRequest);
		userDetailsService.setUserType(authenticationRequest.getUserType());
		Credentials user = new Credentials(authenticationRequest.getUserName(), authenticationRequest.getPassword(),
				authenticationRequest.getUserType());
		Response r = loginServiceImpl.validateLogin(user);
		System.out.println(r.getMsg());
		if (r.getMsg() == "Farmer" || r.getMsg() == "Supplier" || r.getMsg() == "Admin") {
			final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUserName());
			final String token = jwtTokenUtil.generateToken(userDetails);
			return new ResponseEntity<JwtResponse>(new JwtResponse(token, user, r), HttpStatus.OK);
		} else {
			throw new Exception("INVALID CREDENTIALS!");
		}
	}

	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALs", e);
		}
	}
}