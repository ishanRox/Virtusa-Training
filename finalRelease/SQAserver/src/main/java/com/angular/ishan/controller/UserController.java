package com.angular.ishan.controller;

import com.angular.ishan.model.Quection;
import com.angular.ishan.model.Subject;
import com.angular.ishan.repository.AnswerRepository;
import com.angular.ishan.repository.QuectionRepository;
import com.angular.ishan.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
public class UserController {
  static List<Subject> list = new ArrayList<>();
  static List<Quection> quections = new ArrayList<>();
  @Autowired
  QuectionRepository quectionRepository;
  @Autowired
  SubjectService subjectService;
  @Autowired
  AnswerRepository answerRepository;

  @GetMapping("api/all")
  List<Subject> getAllSubjects() {
    List<Subject> all = subjectService.getAll();
    return all;
  }

  @GetMapping("api/allQ")
  List<Quection> getAllQuections() {
    List<Quection> all = quectionRepository.findAll();

    return all;
  }

  //subjects
  @GetMapping("api/subjects")
  Map<String, String> getSubjects(@RequestParam String sub, @RequestParam String topic) {

    System.out.println(sub + "   sdfdsfsf " + topic);


    Map<String, String> map = new HashMap<>();
    List<Subject> allSubjects = subjectService.getAll();
    if (!sub.equals("")){
      allSubjects=allSubjects.stream().filter(e -> e.getName().equals(sub)).collect(Collectors.toList());
      allSubjects.forEach(e->{
        System.out.println(e.getName());
      });
    }

    System.out.println(allSubjects);
    allSubjects.forEach(subTopic -> {

      subTopic.getQuectionList().forEach(x -> {
                if (!topic.equals("")) {
                  System.out.println(x.getTitle()+" title "+topic);
                  if (x.getTitle().equals(topic)) map.put(x.getTitle(), subTopic.getName());
                }else{
                  map.put(x.getTitle(), subTopic.getName());
                }
              }
      );
    });
    return map;
  }




  @PostMapping(value = "api/save")
  public Subject saveSubjects(@RequestBody Subject subject) {
    subjectService.saveSubject(subject);
    List<Subject> all = subjectService.getAll();
    Subject subject1 = all.get(all.size() - 1);
    return subject1;
  }

  @GetMapping("api/delete/{id}")
  public Subject deleteSubject(@PathVariable int id) {
    Subject subject = subjectService.findById(id);
    subjectService.deleteSubject(id);
    return subject;
  }

  //Quection handling endpoints

  @GetMapping("api/allone")
  public List<Quection> allQuection() {
    List<Quection> allQuections = quectionRepository.findAll();
    return allQuections;
  }

  @GetMapping("api/allone/{id}")
  public List<Quection> getQuection(@PathVariable int id) {
    System.out.println(id);
    List<Quection> bySubjectId = quectionRepository.findBySubjectId(id);
    return bySubjectId;
  }

  @PostMapping("api/saveone")
  @Transactional
  public Quection saveQuection(@RequestBody Quection quection) {

    answerRepository.deleteByQuectionId(quection.getId());
    quection.getAnswerList().forEach(e -> e.setQuection(quection));
    Quection save = quectionRepository.save(quection);
    System.out.println(save.getId());

    return quection;
  }

  @GetMapping("api/deleteone/{id}")
  public void deleteQuection(@PathVariable int id) {
    System.out.println(id);
    quectionRepository.deleteById(id);
  }

  @GetMapping("api/getpaper/")
  public List<Quection> getQuections(@RequestParam Optional<Integer> subjectid, @RequestParam Optional<String> title) {
    List<Quection> bySubjectIdAndTitle = quectionRepository.findAll();
    System.out.println("subject id"+bySubjectIdAndTitle);

    return bySubjectIdAndTitle;
  }
}