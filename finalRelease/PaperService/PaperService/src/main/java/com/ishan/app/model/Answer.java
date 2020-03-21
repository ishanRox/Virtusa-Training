package com.ishan.app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

public class Answer {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  int id;
  String answerString;
  boolean istrue;

  public boolean isIstrue() {
    return istrue;
  }

  public void setIstrue(boolean istrue) {
    this.istrue = istrue;
  }

  @ManyToOne
  @JoinColumn
  @JsonIgnore
  Quection quection;

  public Quection getQuection() {
    return quection;
  }

  public void setQuection(Quection quection) {
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
}
