package com.cg.farmstore.entities;

import java.io.Serializable;
import com.cg.farmstore.dto.Response;

public class JwtResponse implements Serializable {

	private static final long serialVersionUID = -8091879091924046844L;
	private final String jwttoken;
	private Credentials credential;
	private Response response;

	public JwtResponse(String jwttoken, Credentials credential, Response response) {
		super();
		this.jwttoken = jwttoken;
		this.credential = credential;
		this.response = response;
	}

	public JwtResponse(String jwttoken, Credentials credential) {
		super();
		this.jwttoken = jwttoken;
		this.credential = credential;
	}

	public String getToken() {
		return this.jwttoken;
	}

	public Response getResponse() {
		return response;
	}

	public void setResponse(Response response) {
		this.response = response;
	}

	public Credentials getCredential() {
		return credential;
	}

	public void setCredential(Credentials credential) {
		this.credential = credential;
	}

	public String getJwttoken() {
		return jwttoken;
	}

}
