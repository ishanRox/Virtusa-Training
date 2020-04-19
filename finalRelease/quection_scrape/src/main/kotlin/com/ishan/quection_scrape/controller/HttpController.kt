package com.ishan.quection_scrape.controller

import com.ishan.quection_scrape.model.Movie
import com.ishan.quection_scrape.repo.MovieRepository
import com.ishan.quection_scrape.service.ScrapeService
import org.springframework.web.bind.annotation.*

@RestController
class HttpController(private val repo: MovieRepository, private val scrapeService: ScrapeService
) {

    @GetMapping("/test/{id}")
    fun test(@PathVariable id: String): Movie = Movie(1, "is of $id",
            "the kotlin and java"
            , "ishan"
            , "vimulthi"
            , "vihanga"
            , "andage"
            , "don")

    @GetMapping("/save")
    fun saveMovie(@RequestBody Movie: Movie): Movie = repo.save(Movie)

    @GetMapping("all")
    fun getAll(): List<Movie> = repo.findAll()

    @GetMapping("scrape")
    fun scrape():List<String> {
        return scrapeService.extractData();
    }

}