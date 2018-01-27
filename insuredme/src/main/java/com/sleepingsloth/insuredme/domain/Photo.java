package com.sleepingsloth.insuredme.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Photo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private long quoteRequestId;
	
	@Lob
	@Column(name = "data", columnDefinition = "LONGBLOB", nullable = false)
	private String data;

	public long getQuoteRequestId() {
		return quoteRequestId;
	}

	public void setQuoteRequestId(long quoteRequestId) {
		this.quoteRequestId = quoteRequestId;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public long getId() {
		return id;
	}

}
