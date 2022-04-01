package com.cg.farmstore.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cg.farmstore.dto.CredentialPojo;
import com.cg.farmstore.entities.Credentials;
import com.cg.farmstore.entities.Farmer;
import com.cg.farmstore.entities.Item;
import com.cg.farmstore.exception.CustomException;
import com.cg.farmstore.repository.ICredentialRepository;
import com.cg.farmstore.repository.IFarmerRepository;
import com.cg.farmstore.repository.IItemRepository;

@Service
public class FarmerServiceImpl implements IFarmerService {

	@Autowired
	public IFarmerRepository farmerRepo;

	@Autowired
	private IItemRepository itemRepo;
	
	@Autowired
	ICredentialRepository iCredentialRepository;
	
	@Autowired
	PasswordEncoder passwordEncoder;

	@Override
	public ResponseEntity<String> addFarmer(Farmer f) {
		try {
			Optional<Farmer> findFarmerByUsername = farmerRepo.findByUsername(f.getCredential().getUserName());
			if (!findFarmerByUsername.isPresent())
				farmerRepo.save(f);
			else {
				return new ResponseEntity<>("Account already exists!", HttpStatus.NOT_FOUND);
			}
		} catch (IllegalArgumentException e) {
			return new ResponseEntity<>("Account not created.", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>("Farmer Created!", HttpStatus.OK);
	}

	@Override
	public List<Farmer> viewAllFarmers() {
		return farmerRepo.findAll();
	}

	@Override
	public Farmer viewFarmerByUsername(String username) {
		Optional<Farmer> findFarmerByUsername = farmerRepo.findByUsername(username);
		if (findFarmerByUsername.isPresent()) {
			Farmer farmerToView = findFarmerByUsername.get();
			return farmerToView;
		} else {
			throw new CustomException("Farmer not found.");
		}
	}

	@Override
	public Farmer updateFarmer(Farmer f) {
		Optional<Farmer> findFarmerById = farmerRepo.findById(f.getFarmerId());
		if (findFarmerById.isPresent()) {
			Credentials c= f.getCredential();
			Credentials credential_db = iCredentialRepository.findByUsername(c.getUserName());
			if (credential_db != null) {
				if (!passwordEncoder.matches(c.getPassword(), credential_db.getPassword())) {
					c.setPassword(passwordEncoder.encode(c.getPassword()));
				}
			}
			iCredentialRepository.save(c);
			farmerRepo.save(f);
			return f;
		} else
			throw new CustomException("Farmer does not exist.");
	}

	@Override
	public List<Item> viewItemsByFarmerId(int id) {
		List<Item> itemList = new ArrayList<Item>();
		itemList = itemRepo.findItemsByFarmerId(id);
//		for(Item item: itemList) {
//			item.setOrders(null);
//		}
		return itemList;
	}

}
