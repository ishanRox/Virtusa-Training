package com.quectionscraper.quectionscraper.controller;

import com.quectionscraper.quectionscraper.dto.Answer;
import com.quectionscraper.quectionscraper.dto.Quection;
import com.quectionscraper.quectionscraper.model.GoogleCrawler;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
public class scraperController {

  @GetMapping("api/getpaper")
  public List<Quection> getQuections(@RequestParam Optional<String> subjectid, @RequestParam Optional<String> title) throws IOException {
    List<Quection> quectionList = new ArrayList<>();
    System.out.println(subjectid.get() + "subject  topic" + title);

    GoogleCrawler obj = new GoogleCrawler();
    List<String> result = obj.getDataFromGoogle(subjectid.get() + " online quiz tutorialspoint");
    boolean foundASite = false;


    //for (String temp : result)
    {
      //   if (foundASite) break;
      //reduce the time
      result = result.stream().filter(e -> e.contains("www.tutorialspoint.com")).filter(e -> e.contains("online_quiz")).collect(Collectors.toList());

      String temp = result.get(0);
      System.out.println(temp + " site loaded");
      if (temp.startsWith("https://www.tutorialspoint.com") && temp.endsWith("_online_quiz")) {
        foundASite = !foundASite;
        Document document = Jsoup.connect(temp).get();
        Elements elements = document.select(".QA");

        for (int i = 0; i < elements.size(); i++) {
          Elements p = elements.get(i).select("p");
          Quection quection = new Quection();
          List<Answer> answerList = new ArrayList<>();

          // make quection from scraped data
          for (int j = 0; j < p.size() - 1; j++) {
            if (j == 0) {
              System.out.println(p.get(j).text().substring(p.get(j).text().indexOf("-") + 1));
              quection.setId(j + "");
              quection.setText(p.get(j).text().substring(p.get(j).text().indexOf("-") + 1));
            } else {
              System.out.println(p.get(j).select("a"));
              Answer answer = new Answer();
              answer.setAnswerString(p.get(j).text());
              //get the correct answer
              if (p.get(j).toString().contains("class=\"true\"")) {
                answer.setIstrue(true);
              } else {
                answer.setIstrue(false);
              }
              answerList.add(answer);
            }
          }

          quection.setAnswerList(answerList);
          quectionList.add(quection);
          System.out.println("_____________");
        }
      }


    }
    System.out.println(quectionList.size());
    quectionList = quectionList.stream().filter(e -> e.getText() != null).collect(Collectors.toList());
    System.out.println(quectionList.size());
//    quectionList = quectionList.stream()
//            .filter(e->e!=null)
//            .filter(e -> !e.getText().equals(""))
//            .filter(e -> e.getAnswerList().size() != 0)
//            .collect(Collectors.toList());

    //https://www.tutorialspoint.com/java/java_online_quiz.htm

    //  quectionList.remove(0);
    return quectionList;
  }
}
