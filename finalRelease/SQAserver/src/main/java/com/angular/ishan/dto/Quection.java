package com.angular.ishan.dto;

import java.util.List;

public class Quection {
  String id;
  String title;
  String text;
  String subjectId;
  String lastModified;
  List<Answer> answerList;

  public Quection(String id, String title, String text, String subjectId, String lastModified) {
    this.id = id;
    this.title = title;
    this.text = text;
    this.subjectId = subjectId;
    this.lastModified = lastModified;
  }

  public String getLastModified() {
    return lastModified;
  }

  public void setLastModified(String lastModified) {
    this.lastModified = lastModified;
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
}
