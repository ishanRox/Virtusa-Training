package com.ishan.app.model;

import javax.persistence.*;
import java.util.List;


public class Subject {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Integer id;

  String name;
  Integer noOfNotes;

  @OneToMany(cascade = CascadeType.REMOVE, targetEntity = Quection.class, mappedBy = "subjectId")
  List<Quection> quectionList;

  public Subject(int id, String name, Integer noOfNotes, List<Quection> quectionList) {
    this.id = id;
    this.name = name;
    this.noOfNotes = noOfNotes;
    this.quectionList = quectionList;
  }

  public Subject(){}

  public List<Quection> getQuectionList() {
    return quectionList;
  }

  public void setQuectionList(List<Quection> quectionList) {
    this.quectionList = quectionList;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public Integer getNoOfNotes() {
    return noOfNotes;
  }

  public void setNoOfNotes(Integer noOfNotes) {
    this.noOfNotes = noOfNotes;
  }
}
