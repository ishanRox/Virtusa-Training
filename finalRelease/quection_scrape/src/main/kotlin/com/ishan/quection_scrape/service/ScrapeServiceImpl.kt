package com.ishan.quection_scrape.service

import com.ishan.quection_scrape.model.Movie
import org.jsoup.Jsoup
import org.jsoup.helper.StringUtil
import org.springframework.stereotype.Service
import org.w3c.dom.Element
import kotlin.streams.toList

@Service
class ScrapeServiceImpl : ScrapeService {
    override fun extractData(): List<String> {


            //1. Fetching the HTML from a given URL
            Jsoup.connect("https://www.google.co.in/search?q=this+is+a+test").get().run {
                //2. Parses and scrapes the HTML response
                select("div.rc").forEachIndexed { index, element ->
                    val titleAnchor = element.select("h3 a")
                    val title = titleAnchor.text()
                    val url = titleAnchor.attr("href")
                    //3. Dumping Search Index, Title and URL on the stdout.
                    println("$index. $title ($url)")
                }
            }



        val doc = Jsoup.connect("https://en.wikipedia.org/wiki/List_of_films_with_a_100%25_rating_on_Rotten_Tomatoes").get()
        val select = doc.select(".wikitable:first-of-type tr td:first-of-type a")

        val toList = select.map { it.attr("href") }
                .parallelStream()
                .filter { it != null }

        return toList.toList()

    }

    fun extractMovies(url: String) {

        val doc = Jsoup.connect("https://en.wikipedia.org/$url").get()
        val select = doc.select(".wikitable:first-of-type tr td:first-of-type a")

        return
    }
}

