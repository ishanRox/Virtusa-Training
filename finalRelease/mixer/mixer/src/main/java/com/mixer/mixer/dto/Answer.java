package com.mixer.mixer.dto;



public class Answer {

	int id;
	String answerString;
	boolean istrue;
	Quection quection;

	public Answer() {
	}

	public Answer(int id, String answerString, boolean istrue, Quection quection) {
		this.id = id;
		this.answerString = answerString;
		this.istrue = istrue;
		this.quection = quection;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAnswerString() {
		return answerString;
	}

	public void setAnswerString(String answerString) {
		this.answerString = answerString;
	}

	public boolean isIstrue() {
		return istrue;
	}

	public void setIstrue(boolean istrue) {
		this.istrue = istrue;
	}

	public Quection getQuection() {
		return quection;
	}

	public void setQuection(Quection quection) {
		this.quection = quection;
	}
}
