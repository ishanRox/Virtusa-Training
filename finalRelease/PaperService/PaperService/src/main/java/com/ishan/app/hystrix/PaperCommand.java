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
  protected Quection[] run() throws Exception{

    System.out.println("inside run");
    HttpEntity<String> httpEntity = new HttpEntity<>("", httpHeaders);
    System.out.println(subject + " subject and title " + title);
    //Simple quection
    ResponseEntity<Quection[]> responseEntity = restTemplate.exchange(
            "http://sqaserver/api/getp?subjectid=" + subject + "&title=" + title, HttpMethod.GET, httpEntity,
            Quection[].class);

    System.out.println("response entity in normal service call");
    Quection[] quections = responseEntity.getBody();
    quections = mixQandA(quections);
    //  mixPost(quections);
    return quections;
  }

  private Quection[] mixQandA(Quection[] quections) {
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

  @Override
  protected Quection[] getFallback() {
    try {


      HttpEntity<String> httpEntity = new HttpEntity<>("", httpHeaders);
      System.out.println(subject + " subject and title fallback" + title);

      ResponseEntity<Quection[]> responseEntity = restTemplate.exchange(
              "http://scraper/api/getpaper?subjectid=" + subject + "&title=" + title, HttpMethod.GET, httpEntity,
              Quection[].class);

      System.out.println("response entity in fallback from webScraper");
      Quection[] quections1 = responseEntity.getBody();

      System.out.println(quections1);
      return quections1;

    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;


  }

  private Quection[] mixPost(Quection[] quections) {
    Quection[] mixedResult = null;
    try {
      final String uri = "http://localhost:8088/mix";
      System.out.println("hereeeeeeee");

      RestTemplate restTemplate = new RestTemplate();
      mixedResult = restTemplate.postForObject(uri, quections, Quection[].class);

      System.out.println(mixedResult);

    } catch (Exception e) {
      e.printStackTrace();
    }
    return mixedResult;
  }

}
