package com.cg.farmstore.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Orders {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int orderId;
	private int quantity;
	private double price;
	private Date orderDate;
//	private int deleted = 0;
	@OneToMany(cascade = CascadeType.REMOVE)
	private List<ItemsOrdered> items = new ArrayList<>();
	@ManyToOne(cascade = CascadeType.MERGE)
//	@JoinColumn(name = "supplierId", referencedColumnName = "supplierId") 
	private Supplier supplier;

	public Orders() {
		super();
	}

	public Orders(int orderId, int quantity, double price, Date orderDate, List<ItemsOrdered> items, Supplier supplier,
			int deleted) {
		super();
		this.orderId = orderId;
		this.quantity = quantity;
		this.price = price;
		this.orderDate = orderDate;
		this.items = items;
		this.supplier = supplier;
//		this.deleted = deleted;
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

	public List<ItemsOrdered> getItems() {
		return items;
	}

	public void setItems(List<ItemsOrdered> items) {
		this.items = items;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
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
		return "Order [orderId=" + orderId + ", quantity=" + quantity + ", price=" + price + ", orderDate=" + orderDate
				+ ", items=" + items + ", supplier=" + supplier + "]";
	}

}
