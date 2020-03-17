package com.angular.ishan.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Quection {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  int id;
  String title;
  String text;
  String subjectId;
  String lastModified;

  @OneToMany(cascade = CascadeType.ALL, targetEntity = Answer.class, mappedBy = "quection")
  List<Answer> answerList;

  @ManyToOne
  @JoinColumn
  @JsonIgnore
  Subject subject;

  public Quection(int id, String title, String text, String subjectId, String lastModified, List<Answer> answerList, Subject subject) {
    this.id = id;
    this.title = title;
    this.text = text;
    this.subjectId = subjectId;
    this.lastModified = lastModified;
    this.answerList = answerList;
    this.subject = subject;
  }

  public Subject getSubject() {
    return subject;
  }

  public void setSubject(Subject subject) {
    this.subject = subject;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public List<Answer> getAnswerList() {
    return answerList;
  }

  public void setAnswerList(List<Answer> answerList) {
    this.answerList = answerList;
  }

  public String getLastModified() {
    return lastModified;
  }

  public void setLastModified(String lastModified) {
    this.lastModified = lastModified;
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
