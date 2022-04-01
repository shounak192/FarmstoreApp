package com.cg.farmstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.farmstore.dto.Response;
import com.cg.farmstore.entities.Farmer;
import com.cg.farmstore.entities.Supplier;
import com.cg.farmstore.service.IRegisterService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/register")
public class RegistrationController {

	@Autowired
	private IRegisterService registerService;

	@PostMapping("/farmer")
	public ResponseEntity<Response> registerFarmer(@RequestBody Farmer farmer) {
		if (registerService.registerFarmer(farmer))
			return new ResponseEntity<Response>(new Response("Farmer Registered!"), HttpStatus.OK);
		else {
			return new ResponseEntity<Response>(new Response("User Name already exists! Pick a new one for you"),
					HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/supplier")
	public ResponseEntity<Response> registerSupplier(@RequestBody Supplier supplier) {
		if (registerService.registerSupplier(supplier))
			return new ResponseEntity<Response>(new Response("Supplier Registered!"), HttpStatus.OK);
		else {
			return new ResponseEntity<Response>(new Response("User Name already exists! Pick a new one for you"),
					HttpStatus.BAD_REQUEST);
		}
	}

}
