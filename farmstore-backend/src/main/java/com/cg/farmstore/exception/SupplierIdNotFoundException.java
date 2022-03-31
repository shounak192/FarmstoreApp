package com.cg.farmstore.exception;

@SuppressWarnings("serial")
public class SupplierIdNotFoundException extends Exception {

	final String msg;

	public SupplierIdNotFoundException() {
		super();
		this.msg = "";
	}

	public SupplierIdNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		this.msg = "";
	}

	public SupplierIdNotFoundException(String message, Throwable cause) {
		super(message, cause);
		this.msg = "";
	}

	public SupplierIdNotFoundException(String message) {
		super(message);
		this.msg = "";
	}

	public SupplierIdNotFoundException(Throwable cause) {
		super(cause);
		this.msg = "";
	}

	public String getMsg() {
		return msg;
	}

}
