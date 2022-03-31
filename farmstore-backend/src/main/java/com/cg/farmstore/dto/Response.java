package com.cg.farmstore.dto;

public class Response {
	private String msg;

	public Response(String msg) {
		super();
		this.msg = msg;
	}

	public Response() {
		super();
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "Response [msg=" + msg + "]";
	}
	

}
