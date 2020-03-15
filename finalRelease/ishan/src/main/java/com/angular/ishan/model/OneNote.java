package com.angular.ishan.model;

public class OneNote {
  String id;
  String title;
  String text;
  String noteBookId;
  String lastModified;


  public OneNote(String id, String title, String text, String noteBookId, String lastModified) {
    this.id = id;
    this.title = title;
    this.text = text;
    this.noteBookId = noteBookId;
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

  public String getNoteBookId() {
    return noteBookId;
  }

  public void setNoteBookId(String noteBookId) {
    this.noteBookId = noteBookId;
  }
}
