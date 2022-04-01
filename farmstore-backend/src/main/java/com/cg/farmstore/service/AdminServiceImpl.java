package com.cg.farmstore.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.cg.farmstore.entities.Credentials;
import com.cg.farmstore.entities.Farmer;
import com.cg.farmstore.entities.Item;
import com.cg.farmstore.entities.Orders;
import com.cg.farmstore.entities.Supplier;
import com.cg.farmstore.exception.FarmerIdNotFoundException;
import com.cg.farmstore.exception.SupplierIdNotFoundException;
import com.cg.farmstore.repository.ICredentialRepository;
import com.cg.farmstore.repository.IFarmerRepository;
import com.cg.farmstore.repository.IItemRepository;
import com.cg.farmstore.repository.IOrdersRepository;
import com.cg.farmstore.repository.ISupplierRepository;

@Service
public class AdminServiceImpl implements IAdminService {

	@Autowired
	IFarmerRepository farmerRepository;

	@Autowired
	IOrdersRepository orderRepository;

	@Autowired
	IItemRepository itemRepository;

	@Autowired
	ISupplierRepository supplierRepository;

	@Autowired
	ICredentialRepository credentialRepository;

	@Autowired
	PasswordEncoder bCryptEncoder;

	@Override
	public Credentials saveUser(Credentials credentials) {
		credentials.setPassword(bCryptEncoder.encode(credentials.getPassword()));
		return credentialRepository.save(credentials);
	}

	@Override
	public List<Farmer> viewFarmer() {
		List<Farmer> farmerList = new ArrayList<Farmer>();
		farmerList = farmerRepository.findAll();
		return farmerList;
	}

	@Override
	public List<Supplier> viewSupplier() {
		List<Supplier> supplierList = new ArrayList<Supplier>();
		supplierList = supplierRepository.findAll();
		return supplierList;
	}

	@Override
	public List<Orders> viewOrders() {
		List<Orders> orderList = new ArrayList<Orders>();
		orderList = orderRepository.findAll();
		return orderList;
	}

	@Override
	public List<Item> viewItems() {
		List<Item> itemList = new ArrayList<Item>();
		itemList = itemRepository.findAll();
//		for(Item item: itemList) {
//			item.setOrders(null);
//		}
		return itemList;
	}

	@Override
	public Farmer removeFarmer(int farmerId) throws FarmerIdNotFoundException {

		Optional<Farmer> optional = farmerRepository.findById(farmerId);
		if (optional.isPresent()) {
			farmerRepository.deleteById(farmerId);
		} else {
			throw new FarmerIdNotFoundException("Farmer Id not found");
		}
		return optional.get();
	}

	@Override
	public Supplier removerSupplier(int supplierId) throws SupplierIdNotFoundException {

		Optional<Supplier> optional = supplierRepository.findById(supplierId);
		if (optional.isPresent()) {
			supplierRepository.deleteById(supplierId);
		} else {
			throw new SupplierIdNotFoundException("Supplier Id not found");
		}
		return optional.get();
	}

}
