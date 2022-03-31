package com.cg.farmstore.dto;

public class FarmerPojo {

	private int farmerId;
	private String farmerName;
	private String farmerMobile;
	private String farmerEmail;
	private String farmerLocation;
	private CredentialPojo credential;

	public FarmerPojo() {
		super();
	}

	public FarmerPojo(int farmerId, String farmerName, String farmerMobile, String farmerEmail, String farmerLocation,
			CredentialPojo credential) {
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

	public CredentialPojo getCredential() {
		return credential;
	}

	public void setCredential(CredentialPojo credential) {
		this.credential = credential;
	}

	public String getFarmerEmail() {
		return farmerEmail;
	}

	public void setFarmeremail(String farmerEmail) {
		this.farmerEmail = farmerEmail;
	}

	@Override
	public String toString() {
		return "FarmerPojo [farmerId=" + farmerId + ", farmerName=" + farmerName + ", farmerMobile=" + farmerMobile
				+ ", farmerEmail=" + farmerEmail + ", farmerLocation=" + farmerLocation + ", credential=" + credential
				+ "]";
	}

	

}
