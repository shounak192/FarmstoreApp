package com.cg.farmstore.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.farmstore.entities.Farmer;
import com.cg.farmstore.entities.Item;
import com.cg.farmstore.entities.Orders;
import com.cg.farmstore.entities.Supplier;
import com.cg.farmstore.exception.FarmerIdNotFoundException;
import com.cg.farmstore.exception.SupplierIdNotFoundException;
import com.cg.farmstore.service.IAdminService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	IAdminService adminService;

	@GetMapping("/farmer/list")
	public ResponseEntity<List<Farmer>> viewAllFarmers() {
		return new ResponseEntity<List<Farmer>>(adminService.viewFarmer(), HttpStatus.OK);
	}

	@GetMapping("/supplier/list")
	public ResponseEntity<List<Supplier>> viewAllSuppliers() {
		return new ResponseEntity<List<Supplier>>(adminService.viewSupplier(), HttpStatus.OK);
	}

	@GetMapping("/order/list")
	public ResponseEntity<List<Orders>> viewAllOrders() {
		return new ResponseEntity<List<Orders>>(adminService.viewOrders(), HttpStatus.OK);
	}

	@GetMapping("/item/list")
	public ResponseEntity<List<Item>> viewAllItems() {
		return new ResponseEntity<List<Item>>(adminService.viewItems(), HttpStatus.OK);
	}

	@DeleteMapping("/supplier/remove/{id}")
	public ResponseEntity<Supplier> removeSuppliers(@PathVariable("id") int id) throws SupplierIdNotFoundException {
		return new ResponseEntity<Supplier>(adminService.removerSupplier(id), HttpStatus.OK);
	}

	@DeleteMapping("/farmer/remove/{id}")
	public ResponseEntity<Farmer> removeFarmers(@PathVariable("id") int id) throws FarmerIdNotFoundException {
		return new ResponseEntity<Farmer>(adminService.removeFarmer(id), HttpStatus.OK);
	}

}
