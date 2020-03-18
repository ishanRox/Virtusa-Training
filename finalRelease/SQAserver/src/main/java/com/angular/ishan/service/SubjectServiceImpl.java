package com.angular.ishan.service;


import com.angular.ishan.model.Subject;
import com.angular.ishan.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService {
  @Autowired
  SubjectRepository subjectRepository;

  @Override
  public Subject saveSubject(Subject subject) {
    subjectRepository.save(subject);
    return subject;
  }

  @Override
  public Subject findById(int id) {
    // TODO Auto-generated method stub

    return subjectRepository.findById(id).get();
  }

  @Override
  public void deleteSubject(int id) {
    Subject subject = findById(id);
    subjectRepository.delete(subject);

  }

  @Override
  public List<Subject> getAll() {
    return subjectRepository.findAll();
  }

}
