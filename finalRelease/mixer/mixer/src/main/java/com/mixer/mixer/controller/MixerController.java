package com.mixer.mixer.controller;

import com.mixer.mixer.dto.Answer;
import com.mixer.mixer.dto.Quection;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RestController
public class MixerController {


  @RequestMapping("/mix")
  private Quection[] mixQandA(@RequestBody Quection[] quections) {
    //Mixing Quections
    List<Quection> listToMix = Arrays.asList(quections);
    Collections.shuffle(listToMix);
    quections = (Quection[]) listToMix.toArray();


    //Mixing Answers
    for (int i = 0; i < quections.length; i++) {
      List<Answer> mixedAnswerList = quections[i].getAnswerList();
      Collections.shuffle(mixedAnswerList);
      quections[i].setAnswerList(mixedAnswerList);
    }
    return quections;
  }
}
