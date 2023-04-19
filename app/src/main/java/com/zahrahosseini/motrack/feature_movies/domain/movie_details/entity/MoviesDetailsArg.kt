package com.zahrahosseini.motrack.feature_movies.domain.movie_details.entity

data class MoviesDetailsArg(
    val movieId: Int,
    val apiKey: String,
    val language: String? = "en-US",
    val append: String? = null,
)