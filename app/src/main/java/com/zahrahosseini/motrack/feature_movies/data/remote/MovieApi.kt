package com.zahrahosseini.motrack.feature_movies.data.remote

import com.zahrahosseini.motrack.feature_movies.domain.movie_details.entity.MovieDetailsResponse
import com.zahrahosseini.motrack.feature_movies.domain.movie_list.entity.MoviesListResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApi {

    @GET("movie/popular")
    suspend fun getMoviesList(
        @Query("api_key") apiKey: String,
        @Query("language") language: String?,
        @Query("page") page: Int?,
        @Query("region") region: String?,
    ): Response<MoviesListResponse>

    @GET("movie/{movie_id}")
    suspend fun getMovieDetails(
        @Path("movie_id") movie_id: Int,
        @Query("api_key") apiKey: String,
        @Query("language") language: String?,
        @Query("append_to_response") append: String?,
    ): Response<MovieDetailsResponse>
}

