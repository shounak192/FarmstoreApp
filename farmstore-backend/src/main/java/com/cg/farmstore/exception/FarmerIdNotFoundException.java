package com.cg.farmstore.exception;

@SuppressWarnings("serial")
public class FarmerIdNotFoundException extends Exception {

	final String msg;

	public FarmerIdNotFoundException() {
		super();
		this.msg = "";
	}

	public FarmerIdNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		this.msg = "";
	}

	public FarmerIdNotFoundException(String message, Throwable cause) {
		super(message, cause);
		this.msg = "";
	}

	public FarmerIdNotFoundException(String message) {
		super(message);
		this.msg = "";
	}

	public FarmerIdNotFoundException(Throwable cause) {
		super(cause);
		this.msg = "";
	}

	public String getMsg() {
		return msg;
	}

}
