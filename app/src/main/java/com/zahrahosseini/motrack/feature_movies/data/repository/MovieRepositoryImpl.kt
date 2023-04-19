package com.zahrahosseini.motrack.feature_movies.data.repository

import com.zahrahosseini.motrack.feature_movies.data.remote.MovieApi
import com.zahrahosseini.motrack.feature_movies.domain.movie_details.entity.MovieDetailsResponse
import com.zahrahosseini.motrack.feature_movies.domain.movie_details.entity.MoviesDetailsArg
import com.zahrahosseini.motrack.feature_movies.domain.movie_list.entity.MoviesListArg
import com.zahrahosseini.motrack.feature_movies.domain.movie_list.entity.MoviesListResponse
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val movieApi: MovieApi, private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : MovieRepository {

    override suspend fun getMoviesList(moviesListArg: MoviesListArg): Response<MoviesListResponse> =
        withContext(ioDispatcher) {
            movieApi.getMoviesList(
                apiKey = moviesListArg.apiKey,
                language = moviesListArg.language,
                page = moviesListArg.page,
                region = moviesListArg.region
            )
        }

    override suspend fun getMovieDetails(moviesDetailsArg: MoviesDetailsArg): Response<MovieDetailsResponse> =
        withContext(ioDispatcher) {
            movieApi.getMovieDetails(
                movie_id = moviesDetailsArg.movieId,
                apiKey = moviesDetailsArg.apiKey,
                language = moviesDetailsArg.language,
                append = moviesDetailsArg.append
            )
        }
}