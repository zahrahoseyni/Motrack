package com.zahrahosseini.motrack.feature_movies.data.repository

import com.zahrahosseini.motrack.feature_movies.domain.movie_details.entity.MovieDetailsResponse
import com.zahrahosseini.motrack.feature_movies.domain.movie_details.entity.MoviesDetailsArg
import com.zahrahosseini.motrack.feature_movies.domain.movie_list.entity.MoviesListArg
import com.zahrahosseini.motrack.feature_movies.domain.movie_list.entity.MoviesListResponse
import retrofit2.Response

interface MovieRepository {
    suspend fun getMoviesList(moviesListArg: MoviesListArg): Response<MoviesListResponse>
    suspend fun getMovieDetails(moviesDetailsArg: MoviesDetailsArg): Response<MovieDetailsResponse>
}