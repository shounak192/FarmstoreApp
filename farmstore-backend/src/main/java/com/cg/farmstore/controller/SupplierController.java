package com.cg.farmstore.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.farmstore.dto.OrdersPojo;
import com.cg.farmstore.dto.SupplierPojo;
import com.cg.farmstore.entities.Orders;
import com.cg.farmstore.entities.Supplier;
import com.cg.farmstore.exception.NoOrdersFoundException;
import com.cg.farmstore.exception.SupplierNotFoundException;
import com.cg.farmstore.service.ISupplierService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/supplier")
public class SupplierController {

	@Autowired
	ISupplierService iSupplierService;

	@GetMapping(value = "/viewDetails/{username}")
	public ResponseEntity<SupplierPojo> viewSupplierDetailsById(@PathVariable String username) {
		try {
			return new ResponseEntity<SupplierPojo>(iSupplierService.viewSupplierDetailsByUsername(username),
					HttpStatus.OK);
		} catch (SupplierNotFoundException s) {
			throw new SupplierNotFoundException(s.getMessage());
		}
	}

	@GetMapping(value = "/viewOrders/{supplierId}")
	public List<Orders> viewOrdersBySupplierId(@PathVariable int supplierId) {
		try {
			return iSupplierService.listOrderBySupplierId(supplierId);
		} catch (NoOrdersFoundException n) {
			throw new NoOrdersFoundException(n.getMessage());
		}
	}

	@PutMapping(value = "/updateDetails")
	public ResponseEntity<Supplier> updateSupplierDetails(@RequestBody Supplier supplier) {
		try {
			return new ResponseEntity<Supplier>(iSupplierService.updateSupplierDetails(supplier), HttpStatus.OK);
		} catch (SupplierNotFoundException s) {
			throw new SupplierNotFoundException(s.getMessage());
		}
	}

}
