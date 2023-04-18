package com.zahrahosseini.motrack.feature_movies.data.repository

import com.zahrahosseini.motrack.feature_movies.domain.entity.MoviesListArg
import com.zahrahosseini.motrack.feature_movies.domain.entity.MoviesListResponse
import retrofit2.Response

interface MovieRepository {

    suspend fun getMoviesList(moviesListArg: MoviesListArg): Response<MoviesListResponse>
}