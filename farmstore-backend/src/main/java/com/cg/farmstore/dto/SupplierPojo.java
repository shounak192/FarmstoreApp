package com.cg.farmstore.dto;

import java.util.List;

public class SupplierPojo {

	private int supplierId;
	private String supplierName;
	private String supplierMobile;
	private String supplierEmail;
	private String supplierLocation;
	private List<OrdersPojo> orders;
	private CredentialPojo credential;

	public SupplierPojo() {
		super();
	}

	public SupplierPojo(int supplierId, String supplierName, String supplierMobile, String supplierEmail, String supplierLocation,
			List<OrdersPojo> orders, CredentialPojo credential) {
		super();
		this.supplierId = supplierId;
		this.supplierName = supplierName;
		this.supplierMobile = supplierMobile;
		this.supplierEmail = supplierEmail;
		this.supplierLocation = supplierLocation;
		this.orders = orders;
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

	public List<OrdersPojo> getOrders() {
		return orders;
	}

	public void setOrders(List<OrdersPojo> orders) {
		this.orders = orders;
	}

	public CredentialPojo getCredential() {
		return credential;
	}

	public void setCredential(CredentialPojo credential) {
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
		return "SupplierPojo [supplierId=" + supplierId + ", supplierName=" + supplierName + ", supplierMobile="
				+ supplierMobile + ", supplierEmail=" + supplierEmail + ", supplierLocation=" + supplierLocation
				+ ", orders=" + orders + ", credential=" + credential + "]";
	}

}
