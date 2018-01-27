package com.sleepingsloth.insuredme.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Offer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private long quoteRequestId;
	
	private long userId;
	
	private CoverType coverType;
	
	private boolean thirdParty;
	
	private boolean roadHelp;
	
	private boolean personalAccident;
	
	private boolean driverCover;
	
	private boolean passengersCover;
	
	private boolean legalAssistance;
	
	private String excess;
	
	private String price;

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getId() {
		return id;
	}

	public long getQuoteRequestId() {
		return quoteRequestId;
	}

	public void setQuoteRequestId(long quoteRequestId) {
		this.quoteRequestId = quoteRequestId;
	}

	public CoverType getCoverType() {
		return coverType;
	}

	public void setCoverType(CoverType coverType) {
		this.coverType = coverType;
	}

	public boolean isThirdParty() {
		return thirdParty;
	}

	public void setThirdParty(boolean thirdParty) {
		this.thirdParty = thirdParty;
	}

	public boolean isRoadHelp() {
		return roadHelp;
	}

	public void setRoadHelp(boolean roadHelp) {
		this.roadHelp = roadHelp;
	}

	public boolean isPersonalAccident() {
		return personalAccident;
	}

	public void setPersonalAccident(boolean personalAccident) {
		this.personalAccident = personalAccident;
	}

	public boolean isDriverCover() {
		return driverCover;
	}

	public void setDriverCover(boolean driverCover) {
		this.driverCover = driverCover;
	}

	public boolean isPassengersCover() {
		return passengersCover;
	}

	public void setPassengersCover(boolean passengersCover) {
		this.passengersCover = passengersCover;
	}

	public boolean isLegalAssistance() {
		return legalAssistance;
	}

	public void setLegalAssistance(boolean legalAssistance) {
		this.legalAssistance = legalAssistance;
	}

	public String getExcess() {
		return excess;
	}

	public void setExcess(String excess) {
		this.excess = excess;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
}
