package com.sleepingsloth.insuredme.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String insuranceTypeCode;
	
	private String question;
	
	private QuestionType type;

	public String getInsuranceTypeCode() {
		return insuranceTypeCode;
	}

	public void setInsuranceTypeCode(String insuranceTypeCode) {
		this.insuranceTypeCode = insuranceTypeCode;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public QuestionType getType() {
		return type;
	}

	public void setType(QuestionType type) {
		this.type = type;
	}

	public long getId() {
		return id;
	}
}
