package com.ishan.quection_scrape.repo

import com.ishan.quection_scrape.model.Movie
import org.springframework.data.jpa.repository.JpaRepository

interface MovieRepository:JpaRepository<Movie,Long>