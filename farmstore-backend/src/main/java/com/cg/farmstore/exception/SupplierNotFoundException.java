package com.cg.farmstore.exception;

public class SupplierNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public SupplierNotFoundException(String msg) {
		super(msg);
	}
}
