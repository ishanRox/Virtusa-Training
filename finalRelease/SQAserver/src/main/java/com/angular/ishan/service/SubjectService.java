package com.angular.ishan.service;

import com.angular.ishan.model.Subject;

import java.util.List;

public interface SubjectService{

  public Subject saveSubject(Subject subject);

  Subject findById(int id);

  void deleteSubject(int id);

  public List<Subject> getAll();
}