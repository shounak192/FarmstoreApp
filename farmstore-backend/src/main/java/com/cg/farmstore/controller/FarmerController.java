package com.cg.farmstore.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.farmstore.entities.Farmer;
import com.cg.farmstore.entities.Item;
import com.cg.farmstore.service.IFarmerService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/farmer")
public class FarmerController {

	@Autowired
	private IFarmerService farmerService;

	@PostMapping("/addfarmer")
	public ResponseEntity<String> addFarmer(@RequestBody Farmer farmer) {
		ResponseEntity<String> f = farmerService.addFarmer(farmer);
		return f;
	}

	@GetMapping("/viewallfarmers")
	public List<Farmer> viewAllFarmers() {
		return farmerService.viewAllFarmers();
	}

	@GetMapping("/viewfarmerbyusername/{username}")
	public Farmer viewFarmerByUsername(@PathVariable("username") String username) {
		return farmerService.viewFarmerByUsername(username);
	}

	@PutMapping("/updatefarmer")
	public Farmer updateFarmer(@RequestBody Farmer farmer) {
		return farmerService.updateFarmer(farmer);
	}

	@GetMapping("/viewitemsbyfarmerid/{id}")
	public List<Item> viewItemsByFarmerId(@PathVariable int id) {
		return farmerService.viewItemsByFarmerId(id);
	}

}
