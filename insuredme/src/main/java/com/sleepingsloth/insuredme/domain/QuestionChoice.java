package com.sleepingsloth.insuredme.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class QuestionChoice {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private long questionId;

	private String choice;

	public long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(long questionId) {
		this.questionId = questionId;
	}

	public String getChoice() {
		return choice;
	}

	public void setChoice(String choice) {
		this.choice = choice;
	}

	public long getId() {
		return id;
	}

}
