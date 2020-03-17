package com.admin.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Quection {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;

	String subject;

	String Topic;

	String addedBy;

	String addedDate;

	String quectionString;

	Integer difficulty;

	@OneToMany(cascade = CascadeType.ALL, targetEntity = Answer.class, mappedBy = "quection")
	List<Answer> answers;

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getTopic() {
		return Topic;
	}

	public void setTopic(String topic) {
		Topic = topic;
	}

	public String getAddedBy() {
		return addedBy;
	}

	public void setAddedBy(String addedBy) {
		this.addedBy = addedBy;
	}

	public String getAddedDate() {
		return addedDate;
	}

	public void setAddedDate(String addedDate) {
		this.addedDate = addedDate;
	}

	public String getQuectionString() {
		return quectionString;
	}

	public void setQuectionString(String quectionString) {
		this.quectionString = quectionString;
	}

	public Integer getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(Integer difficulty) {
		this.difficulty = difficulty;
	}
}
