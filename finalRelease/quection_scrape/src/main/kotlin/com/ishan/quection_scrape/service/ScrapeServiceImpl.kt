package com.ishan.quection_scrape.service

import org.jsoup.Jsoup
import org.springframework.stereotype.Service

@Service
class ScrapeServiceImpl : ScrapeService {
    override fun extractData(): String {

        val doc = Jsoup.connect("https://en.wikipedia.org/wiki/List_of_films_with_a_100%25_rating_on_Rotten_Tomatoes").get()
        println(doc)
        return "sfdsf"
    }
}