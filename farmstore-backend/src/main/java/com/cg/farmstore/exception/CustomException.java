package com.cg.farmstore.exception;

@SuppressWarnings("serial")
public class CustomException extends RuntimeException{
	
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public CustomException(String message) {
		super();
		this.message = message;
	}
	
}
