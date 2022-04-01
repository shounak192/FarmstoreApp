package com.cg.farmstore.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.farmstore.dto.OrdersPojo;
import com.cg.farmstore.entities.Orders;
import com.cg.farmstore.exception.ItemNotFoundException;
import com.cg.farmstore.service.OrderServiceImpl;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/order")
public class OrderController {
	@Autowired
	OrderServiceImpl orderservice;

	@PostMapping("/add")
	public Orders addNewOrder(@RequestBody Orders order) throws ItemNotFoundException {
		System.out.println(order.getSupplier());
		return orderservice.addOrder(order);
	}

	@DeleteMapping("/deleteorders/{id}")
	public boolean deleteOrderById(@PathVariable("id") int od) {
		return orderservice.cancelOrder(od);

	}

	@PutMapping("/deleteorder")
	public List<Orders> deleteOrder(@RequestBody Orders od) {
		return orderservice.deleteOrder(od);

	}

	@GetMapping("/get")
	public List<OrdersPojo> listAllOrders() {
		return orderservice.listAllOrders();
	}

	@GetMapping("/ItemId/{itemId}")
	public List<Orders> listOrderByItemId(@PathVariable("itemId") int itemId) {
		return orderservice.listOrderByItemId(itemId);
	}

	@GetMapping("/orderId/{orderId}")
	public Orders listOrderByOrderId(@PathVariable("orderId") int orderId) {
		return orderservice.listOrderByOrderId(orderId);
	}

	@GetMapping("/{supplierName}")
	public List<OrdersPojo> listOrderBySupplierName(@PathVariable("supplierName") String supplierName) {
		return orderservice.listOrderBySupplierName(supplierName);

	}
}
