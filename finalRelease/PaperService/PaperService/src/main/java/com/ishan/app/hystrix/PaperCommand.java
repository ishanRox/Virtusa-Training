package com.ishan.app.hystrix;

import com.ishan.app.model.Answer;
import com.ishan.app.model.Quection;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class PaperCommand extends HystrixCommand<Quection[]> {
  String subject;
  String title;
  HttpHeaders httpHeaders;
  RestTemplate restTemplate;

  public PaperCommand(String subject, String title, HttpHeaders httpHeaders, RestTemplate restTemplate) {
    super(HystrixCommandGroupKey.Factory.asKey("default"));
    this.subject = subject;
    this.title = title;
    this.httpHeaders = httpHeaders;
    this.restTemplate = restTemplate;

  }

  @Override
  protected Quection[] run() throws Exception {
    System.out.println("inside run");
    HttpEntity<String> httpEntity = new HttpEntity<>("", httpHeaders);
    System.out.println(subject + " subject and title " + title);
    //http://allocater/api/getpaper/?subjectid
    ResponseEntity<Quection[]> responseEntity = restTemplate.exchange(
            "http://allocater/api/getpaper/?subjectid=" + subject + "&title=" + title, HttpMethod.GET, httpEntity,
            Quection[].class);

    System.out.println("response entity in normal service call");
    Quection[] quections = responseEntity.getBody();

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

    return responseEntity.getBody();
  }

  @Override
  protected Quection[] getFallback() {


    HttpEntity<String> httpEntity = new HttpEntity<>("", httpHeaders);
    System.out.println(subject + " subject and title fallback" + title);

    ResponseEntity<Quection[]> responseEntity = restTemplate.exchange(
            "http://scraper/api/getpaper?subjectid=" + subject + "&title=" + title, HttpMethod.GET, httpEntity,
            Quection[].class);

    System.out.println("response entity in fallback from webScraper");
    Quection[] quections1 = responseEntity.getBody();

    System.out.println(quections1);


    return quections1;
  }


  public void QuectionMixer(Quection[] quectionSet) {
    System.out.println("before shuffle");
    Arrays.stream(quectionSet).forEach(e ->
            e.getAnswerList().forEach(x -> System.out.println(x.getQuection().getText())));


    Quection[] quectionMixAnswers = (Quection[]) Arrays.stream(quectionSet).map(e -> {
      List<Answer> answerList = e.getAnswerList();
      Collections.shuffle(answerList);
      return answerList;
    }).toArray();

    System.out.println("after shuffle");
    Arrays.stream(quectionMixAnswers).forEach(e ->
            e.getAnswerList().forEach(x -> System.out.println(x.getQuection().getText())));

    //Collections.shuffle();
  }


}
