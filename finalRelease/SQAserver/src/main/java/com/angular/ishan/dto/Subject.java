package com.angular.ishan.dto;

public class Subject {

  String name;
  String id;
  Integer noOfNotes;

  public Subject(String name, String id, Integer noOfNotes) {
    this.name = name;
    this.id = id;
    this.noOfNotes = noOfNotes;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Integer getNoOfNotes() {
    return noOfNotes;
  }

  public void setNoOfNotes(Integer noOfNotes) {
    this.noOfNotes = noOfNotes;
  }
}
