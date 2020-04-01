package com.ishan.quection_scrape.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Movie (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    var title: String? ,
    var directedBy: String ,
    var producedBy: String ,
    var writtenBy: String ,
    var starring: String ,
    var musicBy: String ,
    var releaseDate: String
)