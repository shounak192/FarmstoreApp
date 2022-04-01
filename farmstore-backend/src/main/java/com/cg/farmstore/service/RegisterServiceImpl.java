package com.cg.farmstore.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.cg.farmstore.entities.Credentials;
import com.cg.farmstore.entities.Farmer;
import com.cg.farmstore.entities.Supplier;
import com.cg.farmstore.repository.IFarmerRepository;
import com.cg.farmstore.repository.ISupplierRepository;

@Service
public class RegisterServiceImpl implements IRegisterService {

	@Autowired
	private IFarmerRepository farmerRepo;

	@Autowired
	private ISupplierRepository supplierRepo;

	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Override
	public boolean registerFarmer(Farmer f) {
		Optional<Farmer> findFarmerByUsername = farmerRepo.findByUsername(f.getCredential().getUserName());
		Optional<Supplier> findSupplierByUsername = supplierRepo.findByUsername(f.getCredential().getUserName());
		Credentials credentials = f.getCredential();
		if (!findFarmerByUsername.isPresent() && !findSupplierByUsername.isPresent()) {
			credentials.setPassword(bcryptEncoder.encode(credentials.getPassword()));
			farmerRepo.save(f);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean registerSupplier(Supplier s) {
		Optional<Farmer> findFarmerByUsername = farmerRepo.findByUsername(s.getCredential().getUserName());
		Optional<Supplier> findSupplierByUsername = supplierRepo.findByUsername(s.getCredential().getUserName());
		Credentials credentials = s.getCredential();
		if (!findSupplierByUsername.isPresent() && !findFarmerByUsername.isPresent()) {
			credentials.setPassword(bcryptEncoder.encode(credentials.getPassword()));
			supplierRepo.save(s);
			return true;
		} else {
			return false;
		}
	}
}
