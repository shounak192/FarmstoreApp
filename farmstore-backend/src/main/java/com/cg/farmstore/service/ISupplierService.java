package com.cg.farmstore.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.cg.farmstore.dto.OrdersPojo;
import com.cg.farmstore.dto.SupplierPojo;
import com.cg.farmstore.entities.Orders;
import com.cg.farmstore.entities.Supplier;

@Service
public interface ISupplierService {

	public SupplierPojo viewSupplierDetailsByUsername(String userName);
	public List<Orders> listOrderBySupplierId(int SupplierId);
	public Supplier updateSupplierDetails(Supplier supplier);
	
}
