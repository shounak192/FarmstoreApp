package com.cg.farmstore.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "itemtable")
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int itemId;
	private String itemName;
	private int itemQuantity;
	private int itemPrice;
//	private int deleted = 0;
	private Category itemCategory;
	@ManyToOne(cascade = CascadeType.MERGE)
//	@JoinColumn(name = "farmerid", referencedColumnName = "farmerid")
	private Farmer farmer;
//	@ManyToMany( fetch = FetchType.LAZY, mappedBy = "items")
//	private List<Orders> orders;
	private boolean verified;

	public Item() {
		super();
	}

	public Item(int itemId, String itemName, int itemQuantity, int itemPrice, Category itemCategory, Farmer farmer,  boolean verified) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemQuantity = itemQuantity;
		this.itemPrice = itemPrice;
		this.itemCategory = itemCategory;
		this.farmer = farmer;
//		this.orders = orders;
		this.verified = verified;
//		this.deleted = deleted;
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

	public Farmer getFarmer() {
		return farmer;
	}

	public void setFarmer(Farmer farmer) {
		this.farmer = farmer;
	}

//	public List<Orders> getOrders() {
//		return orders;
//	}
//
//	public void setOrders(List<Orders> orders) {
//		this.orders = orders;
//	}

	public boolean isVerified() {
		return verified;
	}

	public void setVerified(boolean verified) {
		this.verified = verified;
	}

//	public int getDeleted() {
//		return deleted;
//	}
//
//	public void setDeleted(int deleted) {
//		this.deleted = deleted;
//	}

	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", itemName=" + itemName + ", itemQuantity=" + itemQuantity + ", itemPrice="
				+ itemPrice + ", itemCategory=" + itemCategory + ", farmer="
				+ farmer + ", verified=" + verified + "]";
	}

}
