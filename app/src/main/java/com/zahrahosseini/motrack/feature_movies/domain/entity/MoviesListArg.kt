package com.zahrahosseini.motrack.feature_movies.domain.entity

data class MoviesListArg(
    val apiKey: String,
    val language: String,
    val page: Int,
    val region: String
)