package com.ishan.quection_scrape.repo

import com.ishan.quection_scrape.model.Article
import org.springframework.data.jpa.repository.JpaRepository

interface ArticleRepository:JpaRepository<Article,Long>