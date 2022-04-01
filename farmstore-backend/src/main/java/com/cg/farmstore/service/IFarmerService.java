package com.cg.farmstore.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cg.farmstore.entities.Farmer;
import com.cg.farmstore.entities.Item;

@Service
public interface IFarmerService {

	public ResponseEntity<String> addFarmer(Farmer f);

	public List<Farmer> viewAllFarmers();

	public Farmer viewFarmerByUsername(String username);

	public Farmer updateFarmer(Farmer f);

	public List<Item> viewItemsByFarmerId(int id);

}
