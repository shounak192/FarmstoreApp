package com.cg.farmstore.dto;

import java.util.Date;
import java.util.List;

public class OrdersPojo {

	private int orderId;
	private int quantity;
	private double price;
	private Date orderDate;
	private List<ItemPojo> items;
	private SupplierPojo supplier;
	
	public OrdersPojo() {
		super();
	}

	public OrdersPojo(int orderId, int quantity, double price, Date orderDate, List<ItemPojo> items,
			SupplierPojo supplier) {
		super();
		this.orderId = orderId;
		this.quantity = quantity;
		this.price = price;
		this.orderDate = orderDate;
		this.items = items;
		this.supplier = supplier;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public List<ItemPojo> getItems() {
		return items;
	}

	public void setItems(List<ItemPojo> items) {
		this.items = items;
	}

	public SupplierPojo getSupplier() {
		return supplier;
	}

	public void setSupplier(SupplierPojo supplier) {
		this.supplier = supplier;
	}

	@Override
	public String toString() {
		return "OrdersPojo [orderId=" + orderId + ", quantity=" + quantity + ", price=" + price + ", orderDate="
				+ orderDate + ", items=" + items + ", supplier=" + supplier + "]";
	}

}
