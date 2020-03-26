package com.ishan.quection_scrape.controller

import com.ishan.quection_scrape.model.Article
import com.ishan.quection_scrape.repo.ArticleRepository
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.*

@RestController
class HttpController(private val repo: ArticleRepository) {
    @GetMapping("/test/{id}")
    fun test(@PathVariable id: String): Article = Article(1, "java", "the kotlin and java")

    @GetMapping("/save")
    fun saveArticle(@RequestBody article: Article): Article = repo.save(article)

    @GetMapping("all")
    fun getAll(): List<Article> = repo.findAll()
}