package com.admin.controller;

import com.admin.model.Answer;
import com.admin.model.Quection;
import com.admin.service.QuectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

//handle cors for our angular
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping({"/emp"})
public class Controller {

  @Autowired
  QuectionService quectionService;


  @RequestMapping(value = "test", method = RequestMethod.GET, produces = "application/json")
  public List<Quection> test() {
    Quection quection = new Quection();

    quection.setAddedBy("sdfsfsf");
    quection.setAddedDate("sdfsfsf");
    quection.setDifficulty(3);
    quection.setQuectionString("      sdfsfsf");
    quection.setSubject("sdfsfsf");
    quection.setTopic("sdfsfsf");

    List<Quection> quections = new ArrayList<>();
    List<Answer> answers = new ArrayList<>();
    Answer answer = new Answer();
    answer.setAnswerString("hello");

    answers.add(answer);
    quection.setAnswers(answers);
    quections.add(quection);
    return quections;
  }
//quection added

  @RequestMapping(value = "/save", method = RequestMethod.POST)
  public Quection save(@RequestBody  Quection e) {
    System.out.println(e.getTopic());

//  e.getAnswers().forEach(System.out::println);
//  e.getAnswers().forEach(a->a.setQuection(e));

    Quection quection = quectionService.save(e);

    return quection;
  }

  //quection deleted

  // Delete And check if the cascading works both employee and adress must be
  // deleted
  @DeleteMapping("/delete/{id}")
  public Quection deleteEmployee(@PathVariable int id) {
    Quection quection = quectionService.findById(id);
    String s = quectionService.deleteQ(id);

    return quection;
  }

  @RequestMapping("/all")
  public List<Quection> getAll() {
    return quectionService.fethAllQuections();
  }
}
