package com.cg.farmstore.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cg.farmstore.dto.CredentialPojo;
import com.cg.farmstore.dto.ItemPojo;
import com.cg.farmstore.dto.OrdersPojo;
import com.cg.farmstore.dto.SupplierPojo;
import com.cg.farmstore.entities.Credentials;
import com.cg.farmstore.entities.Item;
import com.cg.farmstore.entities.ItemsOrdered;
import com.cg.farmstore.entities.Orders;
import com.cg.farmstore.entities.Supplier;
import com.cg.farmstore.exception.NoOrdersFoundException;
import com.cg.farmstore.exception.SupplierNotFoundException;
import com.cg.farmstore.repository.ICredentialRepository;
import com.cg.farmstore.repository.IOrdersRepository;
import com.cg.farmstore.repository.ISupplierRepository;

@Service
public class SupplierServiceImpl implements ISupplierService {

	@Autowired
	ISupplierRepository iSupplierRepo;
	@Autowired
	IOrdersRepository iOrderRepo;

	@Autowired
	ICredentialRepository iCredentialRepository;

	@Autowired
	PasswordEncoder passwordEncoder;

	@Override
	public Supplier updateSupplierDetails(Supplier supplier) {
		if (iSupplierRepo.existsById(supplier.getSupplierId())) {
			Credentials c = supplier.getCredential();
			Credentials credential_db = iCredentialRepository.findByUsername(c.getUserName());
			if (credential_db != null) {
				if (!passwordEncoder.matches(c.getPassword(), credential_db.getPassword())) {
					c.setPassword(passwordEncoder.encode(c.getPassword()));
				}
			}
			iCredentialRepository.save(c);
			iSupplierRepo.save(supplier);
			return supplier;
		} else {
			throw new SupplierNotFoundException("Supplier not found");
		}
	}

	@Override
	public List<Orders> listOrderBySupplierId(int supplierId) {
		List<Orders> orderEntityList = iOrderRepo.listOrderBySupplierId(supplierId);
		if (orderEntityList.size() != 0) {
//			List<OrdersPojo> pojoList = new ArrayList<>();
//			for (Orders orders : orderEntityList) {
////				if (orders.getDeleted() != 1) {
//				OrdersPojo orderPojo = new OrdersPojo();
//				BeanUtils.copyProperties(orders, orderPojo);
////				Supplier supplier = orders.getSupplier();
//				SupplierPojo supplierPojo = new SupplierPojo();
////				BeanUtils.copyProperties(supplier, supplierPojo);
//				supplierPojo.setOrders(null);
//				orderPojo.setSupplier(supplierPojo);
//				List<ItemsOrdered> allItems = orders.getItems();
//				List<ItemPojo> allItemPojo = new ArrayList<>();
//				for (ItemsOrdered item : allItems) {
//					ItemPojo itemPojo = new ItemPojo();
//					BeanUtils.copyProperties(item, itemPojo);
//					allItemPojo.add(itemPojo);
//				}
//				orderPojo.setItems(allItemPojo);
//
//				pojoList.add(orderPojo);
//			}
			return orderEntityList;
		} else {
			throw new NoOrdersFoundException("No orders yet");
		}
	}

	@Override
	public SupplierPojo viewSupplierDetailsByUsername(String userName) {
		Supplier s = iSupplierRepo.findByUsername(userName).get();
		int supplierId = s.getSupplierId();
		if (iSupplierRepo.existsById(supplierId)) {
			Optional<Supplier> sup = iSupplierRepo.findById(supplierId);
			SupplierPojo supplierPojo = new SupplierPojo();
			Supplier supplier = sup.get();
			BeanUtils.copyProperties(supplier, supplierPojo);
			Credentials c = supplier.getCredential();
			CredentialPojo credentialPojo = new CredentialPojo();
			BeanUtils.copyProperties(c, credentialPojo);
			supplierPojo.setCredential(credentialPojo);
			supplierPojo.setOrders(null);
			return supplierPojo;
		} else {
			throw new SupplierNotFoundException("Supplier not found");
		}
	}
}
