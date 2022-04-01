package com.cg.farmstore.service;

import java.util.List;
import com.cg.farmstore.dto.ItemPojo;
import com.cg.farmstore.entities.Category;
import com.cg.farmstore.exception.CategoryNotFoundException;
import com.cg.farmstore.exception.ItemNotFoundException;

public interface IItemService {

	public ItemPojo addItem(ItemPojo itemPojo) throws ItemNotFoundException;

	public List<ItemPojo> removeItem(int itemId) throws ItemNotFoundException;

	public ItemPojo updateItem(ItemPojo itemPojo) throws ItemNotFoundException;

	public List<ItemPojo> listAllItems() throws ItemNotFoundException;

	public List<ItemPojo> listItemsByCategory(Category category)
			throws ItemNotFoundException, CategoryNotFoundException;

	public ItemPojo getItem(int itemId) throws ItemNotFoundException;

	public boolean verifyItem(int itemId) throws ItemNotFoundException;

}
