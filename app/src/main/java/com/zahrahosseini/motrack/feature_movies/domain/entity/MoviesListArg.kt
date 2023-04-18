package com.zahrahosseini.motrack.feature_movies.domain.entity

data class MoviesListArg(
    val apiKey: String,
    val language: String? ="en-US",
    val page: Int? = 1,
    val region: String? = null
)