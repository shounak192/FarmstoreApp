package com.cg.farmstore.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.farmstore.dto.CredentialPojo;
import com.cg.farmstore.dto.FarmerPojo;
import com.cg.farmstore.dto.ItemPojo;
import com.cg.farmstore.dto.OrdersPojo;
import com.cg.farmstore.dto.SupplierPojo;
import com.cg.farmstore.entities.Category;
import com.cg.farmstore.entities.Credentials;
import com.cg.farmstore.entities.Farmer;
import com.cg.farmstore.entities.Item;
import com.cg.farmstore.entities.Orders;
import com.cg.farmstore.entities.Supplier;
import com.cg.farmstore.exception.CategoryNotFoundException;
import com.cg.farmstore.exception.ItemNotFoundException;
import com.cg.farmstore.repository.IItemRepository;

@Service
public class ItemServiceImpl implements IItemService {

	@Autowired
	private IItemRepository itemRepository;

	@Override
	public ItemPojo addItem(ItemPojo itemPojo) {
		Item item = new Item();
		Farmer farmer = new Farmer();
		Credentials credential = new Credentials();
		FarmerPojo farmerPojo = itemPojo.getFarmer();
		CredentialPojo credentialPojo = itemPojo.getFarmer().getCredential();
		BeanUtils.copyProperties(farmerPojo, farmer);
		BeanUtils.copyProperties(credentialPojo, credential);
		farmer.setCredential(credential);
		BeanUtils.copyProperties(itemPojo, item);
		item.setVerified(false);
//		item.setOrders(null);
		System.out.println(farmer);
		item.setFarmer(farmer);
		Item addedItem = itemRepository.save(item);
		ItemPojo addedItemPojo = new ItemPojo();
		BeanUtils.copyProperties(addedItem, addedItemPojo);
		BeanUtils.copyProperties(addedItem.getFarmer(), farmerPojo);
		addedItemPojo.setFarmer(farmerPojo);
		return addedItemPojo;
	}

	@Override
	public List<ItemPojo> removeItem(int itemId) throws ItemNotFoundException {

		itemRepository.deleteById(itemId);
		List<Item> allOrders = itemRepository.findAll();
		List<ItemPojo> allItemPojo = new ArrayList<>();
		for (Item items : allOrders) {
//			if (items.getDeleted() != 1) {
				ItemPojo itemPojo = new ItemPojo();
				BeanUtils.copyProperties(items, itemPojo);
				Farmer farmer = items.getFarmer();
				FarmerPojo farmerPojo = new FarmerPojo();
				BeanUtils.copyProperties(farmer, farmerPojo);
				itemPojo.setFarmer(farmerPojo);
				allItemPojo.add(itemPojo);
				System.out.println(allItemPojo);
				return allItemPojo;
//			}
		}
		return allItemPojo;

	}

	@Override
	public ItemPojo updateItem(ItemPojo itemPojo) throws ItemNotFoundException {
		if (itemRepository.existsById(itemPojo.getItemId())) {
			Item item = itemRepository.findById(itemPojo.getItemId()).get();
			item.setItemName(itemPojo.getItemName());
			item.setItemPrice(itemPojo.getItemPrice());
			item.setItemQuantity(itemPojo.getItemQuantity());
			item.setVerified(itemPojo.isVerified());
			Item updatedItem = itemRepository.save(item);
			System.out.print(updatedItem.getItemCategory());
			ItemPojo updatedItemPojo = new ItemPojo();
			BeanUtils.copyProperties(updatedItem, updatedItemPojo);
			FarmerPojo farmerPojo = new FarmerPojo();
			BeanUtils.copyProperties(updatedItem.getFarmer(), farmerPojo);
			updatedItemPojo.setFarmer(farmerPojo);
			return updatedItemPojo;
		} else {
			throw new ItemNotFoundException("Item not found!");
		}
	}

	@Override
	public ItemPojo getItem(int itemId) throws ItemNotFoundException {
		if (itemRepository.findById(itemId).isPresent()) {
			Item item = itemRepository.getById(itemId);
			if (item.isVerified()) {
				ItemPojo itemPojo = new ItemPojo();
				BeanUtils.copyProperties(item, itemPojo);
				Farmer f = item.getFarmer();
				FarmerPojo farmerPojo = new FarmerPojo();
				BeanUtils.copyProperties(f, farmerPojo);
				itemPojo.setFarmer(farmerPojo);
				return itemPojo;
			} else
				throw new ItemNotFoundException("The Item that you are trying to view is not verified by Admin!");
		} else
			throw new ItemNotFoundException("Item not found!");
	}

	@Override
	public List<ItemPojo> listAllItems() throws ItemNotFoundException {
		List<Item> allItems = itemRepository.findAll();
		List<ItemPojo> itemsPojo = new ArrayList<ItemPojo>();
		for (Item item : allItems) {
			if (item.isVerified()) {
				ItemPojo itemPojo = new ItemPojo();
				BeanUtils.copyProperties(item, itemPojo);
				System.out.println(itemPojo);

				Farmer farmer = item.getFarmer();
				FarmerPojo farmerPojo = new FarmerPojo();
				BeanUtils.copyProperties(farmer, farmerPojo);

				itemPojo.setFarmer(farmerPojo);
				itemsPojo.add(itemPojo);
				
			}
		}
		if (!itemsPojo.isEmpty())
			return itemsPojo;
		else
			throw new ItemNotFoundException("No items to show!");
	}

	@Override
	public List<ItemPojo> listItemsByCategory(Category category)
			throws ItemNotFoundException, CategoryNotFoundException {
		if (Category.isCategoryExists(category)) {
			List<Item> allItems = itemRepository.findAllByCategory(category);
			List<ItemPojo> itemsPojo = new ArrayList<ItemPojo>();
			for (Item item : allItems) {
				if (item.isVerified()) {
					ItemPojo itemPojo = new ItemPojo();
					BeanUtils.copyProperties(item, itemPojo);

					Farmer farmer = item.getFarmer();
					FarmerPojo farmerPojo = new FarmerPojo();
					BeanUtils.copyProperties(farmer, farmerPojo);

					itemPojo.setFarmer(farmerPojo);
					itemsPojo.add(itemPojo);
				}
			}
			if (!itemsPojo.isEmpty())
				return itemsPojo;
			else
				throw new ItemNotFoundException("No items found in this Category!");
		} else
			throw new CategoryNotFoundException("Category not found!");
	}

	@Override
	public boolean verifyItem(int itemId) throws ItemNotFoundException {
		if (itemRepository.existsById(itemId)) {
			Item item = itemRepository.getById(itemId);
			if (!item.isVerified()) {
				item.setVerified(true);
				itemRepository.save(item);
				return true;
			} else
				throw new ItemNotFoundException("Item is already verified!");
		} else
			throw new ItemNotFoundException("Item not found!");
	}

}
