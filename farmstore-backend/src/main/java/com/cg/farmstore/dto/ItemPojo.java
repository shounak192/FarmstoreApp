package com.cg.farmstore.dto;

import com.cg.farmstore.entities.Category;

public class ItemPojo {

	private int itemId;
	private String itemName;
	private int itemQuantity;
	private int itemPrice;
	private Category itemCategory;
	private FarmerPojo farmer;
	private boolean verified;
	/* private List<OrdersPojo> ordersPojo; */

	public ItemPojo() {
		super();
	}

	public ItemPojo(int itemId, String itemName, int itemQuantity, int itemPrice, Category itemCategory,
			FarmerPojo farmer, boolean verified/* , List<OrdersPojo> ordersPojo */) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemQuantity = itemQuantity;
		this.itemPrice = itemPrice;
		this.itemCategory = itemCategory;
		this.farmer = farmer;
		this.verified = verified;
//		this.ordersPojo = ordersPojo;
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

	public FarmerPojo getFarmer() {
		return farmer;
	}

	public void setFarmer(FarmerPojo farmer) {
		this.farmer = farmer;
	}

//	public List<OrdersPojo> getOrdersPojo() {
//		return ordersPojo;
//	}

//	public void setOrdersPojo(List<OrdersPojo> ordersPojo) {
//		this.ordersPojo = ordersPojo;
//	}
	

	@Override
	public String toString() {
		return "ItemPojo [itemId=" + itemId + ", itemName=" + itemName + ", itemQuantity=" + itemQuantity
				+ ", itemPrice=" + itemPrice + ", itemCategory=" + itemCategory + ", farmer=" + farmer
				/* + ", ordersPojo=" + ordersPojo */ + "]";
	}

	public boolean isVerified() {
		return verified;
	}

	public void setVerified(boolean verified) {
		this.verified = verified;
	}

}
