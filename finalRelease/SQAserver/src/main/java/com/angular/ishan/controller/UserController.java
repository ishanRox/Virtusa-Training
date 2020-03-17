package com.angular.ishan.controller;

import com.angular.ishan.model.Quection;
import com.angular.ishan.model.Subject;
import com.angular.ishan.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
public class UserController {
  static List<Subject> list = new ArrayList<>();
  static List<Quection> quections = new ArrayList<>();

  @Autowired
  SubjectService subjectService;

  // standard constructors

//  private final UserRepository userRepository;

  static {

    list.add(new Subject(1,"ishan", 12,null));
    list.add(new Subject(2,"ishan", 12,null));
    list.add(new Subject(3,"ishan", 12,null));
    list.add(new Subject(4,"ishan", 12,null));
    list.add(new Subject(5,"ishan", 12,null));



    quections.add(new Quection(1, "java", "sdfsfsfdsf asfd", "i1", "2020",null,null));
    quections.add(new Quection(2, "java", "sdfsfsfdsf asfd", "i1", "2020",null,null));
    quections.add(new Quection(3, "java", "sdfsfsfdsf asfd", "i1", "2020",null,null));
    quections.add(new Quection(4, "java", "sdfsfsfdsf asfd", "i1", "2020",null,null));

  }


  @GetMapping("api/all")
  List<Subject> getNotes() {
    List<Subject> all = subjectService.getAll();
    return all;
  }

  @PostMapping(value = "api/save")
  public Subject save(@RequestBody Subject subject) {
    System.out.println(subject.getId());
    System.out.println(subject.getName());
     subjectService.saveSubject(subject);
    List<Subject> all = subjectService.getAll();
    Subject subject1 = all.get(all.size() - 1);
    return subject1;
  }

  @GetMapping("api/delete/{id}")
  public Subject delet(@PathVariable int id) {

    Subject subject = subjectService.findById(id);
    subjectService.deleteSubject(id);
    return subject;
  }

  @GetMapping("api/allone")
  public List<Quection> onenotes() {
    return quections;
  }

  @GetMapping("api/allone/{id}")
  public List<Quection> onenotes(@PathVariable String id) {
    List<Quection> collect = quections.stream().filter(note -> note.getSubjectId().equals(id)).collect(Collectors.toList());
    return collect;
  }

  @PostMapping("api/saveone")
  public Quection saveNote(@RequestBody Quection quection) {
    System.out.println(quection.getText());
    quections.add(quection);
    return quection;
  }

  @GetMapping("api/deleteone/{id}")
  public void deleteNote(@PathVariable String id) {
    System.out.println(id);
    List<Quection> collect = quections.stream().filter(e -> !( e.getId()+"").equals(id+"")).collect(Collectors.toList());
    if (collect != null)
      quections = collect;
  }
}