package com.cg.farmstore.service;

import org.springframework.stereotype.Service;
import com.cg.farmstore.entities.Farmer;
import com.cg.farmstore.entities.Supplier;

@Service
public interface IRegisterService {
	
	public boolean registerFarmer(Farmer f);

	public boolean registerSupplier(Supplier s);

}
