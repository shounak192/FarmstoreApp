package com.cg.farmstore.entities;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Supplier {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int supplierId;
	private String supplierName;
	private String supplierMobile;
	private String supplierEmail;
	private String supplierLocation;
//	@OneToMany(cascade = CascadeType.ALL, mappedBy = "supplier")
//	private List<Orders> orders;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "username", referencedColumnName = "username")
	private Credentials credential;

	public Supplier() {
		super();
	}

	public Supplier(int supplierId, String supplierName, String supplierMobile, String supplierEmail, String supplierLocation,
			 Credentials credential) {
		super();
		this.supplierId = supplierId;
		this.supplierName = supplierName;
		this.supplierMobile = supplierMobile;
		this.supplierEmail = supplierEmail;
		this.supplierLocation = supplierLocation;
//		this.orders = orders;
		this.credential = credential;
	}

	public int getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public String getSupplierMobile() {
		return supplierMobile;
	}

	public void setSupplierMobile(String supplierMobile) {
		this.supplierMobile = supplierMobile;
	}

	public String getSupplierLocation() {
		return supplierLocation;
	}

	public void setSupplierLocation(String supplierLocation) {
		this.supplierLocation = supplierLocation;
	}

//	public List<Orders> getOrders() {
//		return orders;
//	}
//
//	public void setOrders(List<Orders> orders) {
//		this.orders = orders;
//	}

	public Credentials getCredential() {
		return credential;
	}

	public void setCredential(Credentials credential) {
		this.credential = credential;
	}

	public String getSupplierEmail() {
		return supplierEmail;
	}

	public void setSupplierEmail(String supplierEmail) {
		this.supplierEmail = supplierEmail;
	}

	@Override
	public String toString() {
		return "Supplier [supplierId=" + supplierId + ", supplierName=" + supplierName + ", supplierMobile="
				+ supplierMobile + ", supplierEmail=" + supplierEmail + ", supplierLocation=" + supplierLocation
				+ ", credential=" + credential + "]";
	}

}
