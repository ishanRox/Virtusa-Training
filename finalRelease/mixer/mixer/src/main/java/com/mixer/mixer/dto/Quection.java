package com.mixer.mixer.dto;

import java.util.List;

public class Quection {
  String id;
  String title;
  String text;
  String subjectId;
  String lastModified;
  List<Answer> answerList;

  public Quection() {
  }

  public Quection(String id, String title, String text, String subjectId, String lastModified, List<Answer> answerList) {
    this.id = id;
    this.title = title;
    this.text = text;
    this.subjectId = subjectId;
    this.lastModified = lastModified;
    this.answerList = answerList;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public String getSubjectId() {
    return subjectId;
  }

  public void setSubjectId(String subjectId) {
    this.subjectId = subjectId;
  }

  public String getLastModified() {
    return lastModified;
  }

  public void setLastModified(String lastModified) {
    this.lastModified = lastModified;
  }

  public List<Answer> getAnswerList() {
    return answerList;
  }

  public void setAnswerList(List<Answer> answerList) {
    this.answerList = answerList;
  }
}
