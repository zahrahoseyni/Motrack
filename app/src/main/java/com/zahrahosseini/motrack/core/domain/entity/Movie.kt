package com.zahrahosseini.motrack.core.domain.entity


interface Movie {
    val id: Int
    val title: String
    val originLanguage: String
    val originalTitle: String
    val voteAvg: Float
    val voteCount: Int
    val releaseDate: String
    val popularity: Float
}