package com.sleepingsloth.insuredme.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class QuoteRequest {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String insuranceTypeCode;
	
	private boolean open;
	
	private boolean photosTaken;

	private long userId;

	public String getInsuranceTypeCode() {
		return insuranceTypeCode;
	}

	public void setInsuranceTypeCode(String insuranceTypeCode) {
		this.insuranceTypeCode = insuranceTypeCode;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getId() {
		return id;
	}

	public boolean isOpen() {
		return open;
	}

	public void setOpen(boolean open) {
		this.open = open;
	}

	public boolean isPhotosTaken() {
		return photosTaken;
	}

	public void setPhotosTaken(boolean photosTaken) {
		this.photosTaken = photosTaken;
	}
}
