package com.cg.farmstore.service;

import java.util.List;

import com.cg.farmstore.entities.Credentials;
import com.cg.farmstore.entities.Farmer;
import com.cg.farmstore.entities.Item;
import com.cg.farmstore.entities.Orders;
import com.cg.farmstore.entities.Supplier;
import com.cg.farmstore.exception.FarmerIdNotFoundException;
import com.cg.farmstore.exception.SupplierIdNotFoundException;

public interface IAdminService {

	public Credentials saveUser(Credentials credentials);
	
	public List<Farmer> viewFarmer();

	public List<Supplier> viewSupplier();

	public List<Orders> viewOrders();

	public List<Item> viewItems();

	public Farmer removeFarmer(int farmerId) throws FarmerIdNotFoundException;

	public Supplier removerSupplier(int supplierId) throws SupplierIdNotFoundException;
}
