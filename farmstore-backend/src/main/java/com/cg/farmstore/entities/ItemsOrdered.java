package com.cg.farmstore.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class ItemsOrdered {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int slno;
	private int itemId;
	@OneToOne
	private Orders orders;
	private String itemName;
	private int itemQuantity;
	private int itemPrice;
	private Category itemCategory;
	public ItemsOrdered() {
		super();
	}
	public ItemsOrdered(int itemId, String itemName, int itemQuantity, int itemPrice, Category itemCategory) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemQuantity = itemQuantity;
		this.itemPrice = itemPrice;
		this.itemCategory = itemCategory;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getItemQuantity() {
		return itemQuantity;
	}
	public void setItemQuantity(int itemQuantity) {
		this.itemQuantity = itemQuantity;
	}
	public int getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}
	public Category getItemCategory() {
		return itemCategory;
	}
	public void setItemCategory(Category itemCategory) {
		this.itemCategory = itemCategory;
	}
	@Override
	public String toString() {
		return "ItemsOrdered [itemId=" + itemId + ", itemName=" + itemName + ", itemQuantity=" + itemQuantity
				+ ", itemPrice=" + itemPrice + ", itemCategory=" + itemCategory + "]";
	}


}
