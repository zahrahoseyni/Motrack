package com.zahrahosseini.motrack.feature_movies.data.remote

import com.zahrahosseini.motrack.feature_movies.domain.entity.MoviesListResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi {

    @GET("/movie/popular")
    suspend fun getMoviesList(
        @Query("api_key") apiKey: String,
        @Query("language") language: String,
        @Query("page") page: Int,
        @Query("region") region: String,
    ): Response<MoviesListResponse>
}