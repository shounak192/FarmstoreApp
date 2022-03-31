package com.cg.farmstore.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "farmertable")
public class Farmer{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "farmerid")
	private int farmerId;

	@Column(name = "farmername")
	private String farmerName;

	@Column(name = "farmermobile")
	private String farmerMobile;
	
	@Column(name = "farmeremail")
	private String farmerEmail;

	@Column(name = "farmerlocation")
	private String farmerLocation;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "username", referencedColumnName = "username")
	private Credentials credential;

	public Farmer() {
		super();
	}

	public Farmer(int farmerId, String farmerName, String farmerMobile, String farmerEmail, String farmerLocation, Credentials credential) {
		super();
		this.farmerId = farmerId;
		this.farmerName = farmerName;
		this.farmerMobile = farmerMobile;
		this.farmerEmail = farmerEmail;
		this.farmerLocation = farmerLocation;
		this.credential = credential;
	}

	public int getFarmerId() {
		return farmerId;
	}

	public void setFarmerId(int farmerId) {
		this.farmerId = farmerId;
	}

	public String getFarmerName() {
		return farmerName;
	}

	public void setFarmerName(String farmerName) {
		this.farmerName = farmerName;
	}

	public String getFarmerMobile() {
		return farmerMobile;
	}

	public void setFarmerMobile(String farmerMobile) {
		this.farmerMobile = farmerMobile;
	}

	public String getFarmerLocation() {
		return farmerLocation;
	}

	public void setFarmerLocation(String farmerLocation) {
		this.farmerLocation = farmerLocation;
	}

	public Credentials getCredential() {
		return credential;
	}

	public void setCredential(Credentials credential) {
		this.credential = credential;
	}

	public String getFarmerEmail() {
		return farmerEmail;
	}

	public void setFarmerEmail(String farmerEmail) {
		this.farmerEmail = farmerEmail;
	}
	

}
