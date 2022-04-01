package com.cg.farmstore.exception;

public class NoOrdersFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public NoOrdersFoundException(String msg) {
		super(msg);
	}
}
