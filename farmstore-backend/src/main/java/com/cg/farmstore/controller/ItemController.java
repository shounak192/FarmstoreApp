package com.cg.farmstore.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.cg.farmstore.dto.ItemPojo;
import com.cg.farmstore.dto.Response;
import com.cg.farmstore.entities.Category;
import com.cg.farmstore.exception.CategoryNotFoundException;
import com.cg.farmstore.exception.ItemNotFoundException;
import com.cg.farmstore.repository.IItemRepository;
import com.cg.farmstore.service.IItemService;

@CrossOrigin(origins = "*")
@RestController
public class ItemController {

	@Autowired
	private IItemService itemService;

	@PostMapping("/item/add")
	public ResponseEntity<ItemPojo> addItem(@RequestBody ItemPojo itemPojo) throws ItemNotFoundException {
		System.out.println(itemPojo);
		return new ResponseEntity<ItemPojo>(itemService.addItem(itemPojo), HttpStatus.OK);
	}

	@GetMapping("/item/delete/{itemId}")
	public List<ItemPojo> removeItem(@PathVariable int itemId) throws ItemNotFoundException {
			return itemService.removeItem(itemId);
	}

	@PutMapping("/item/verify")
	public ResponseEntity<Response> verifyItem(@RequestParam int itemId) throws ItemNotFoundException {
		if (itemService.verifyItem(itemId)) {
			return new ResponseEntity<Response>(new Response("Item verified successfully!"), HttpStatus.OK);
		} else {
			return new ResponseEntity<Response>(new Response("Item is not verified! Please try again later!"),
					HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/item/update")
	public ResponseEntity<ItemPojo> updateItem(@RequestBody ItemPojo itemPojo) throws ItemNotFoundException {
		return new ResponseEntity<ItemPojo>(itemService.updateItem(itemPojo), HttpStatus.OK);
	}

	@GetMapping("/item/view/")
	public ResponseEntity<ItemPojo> getItem(@RequestParam int itemId) throws ItemNotFoundException {
		return new ResponseEntity<ItemPojo>(itemService.getItem(itemId), HttpStatus.OK);
	}

	@GetMapping("/item/view/all")
	public ResponseEntity<List<ItemPojo>> listAllItems() throws ItemNotFoundException {
		return new ResponseEntity<List<ItemPojo>>(itemService.listAllItems(), HttpStatus.OK);
	}

	@GetMapping("/item/view/category")
	public ResponseEntity<List<ItemPojo>> listFarmerItemsByCategory(@RequestParam Category category)
			throws ItemNotFoundException, CategoryNotFoundException {
		return new ResponseEntity<List<ItemPojo>>(itemService.listItemsByCategory(category), HttpStatus.OK);
	}

}
