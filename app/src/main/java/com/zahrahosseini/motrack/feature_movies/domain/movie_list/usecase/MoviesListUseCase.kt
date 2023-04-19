package com.zahrahosseini.motrack.feature_movies.domain.movie_list.usecase

import com.zahrahosseini.motrack.core.di.qualifiers.IoDispatcher
import com.zahrahosseini.motrack.core.domain.usecase.ApiUseCase
import com.zahrahosseini.motrack.feature_movies.data.repository.MovieRepository
import com.zahrahosseini.motrack.feature_movies.domain.movie_list.entity.MoviesListArg
import com.zahrahosseini.motrack.feature_movies.domain.movie_list.entity.MoviesListResponse
import kotlinx.coroutines.CoroutineDispatcher
import retrofit2.Response
import javax.inject.Inject


class MoviesListUseCase @Inject constructor(
    private val movieRepository: MovieRepository,
    @IoDispatcher ioDispatcher: CoroutineDispatcher
) : ApiUseCase<MoviesListArg, MoviesListResponse>(ioDispatcher) {

    override suspend fun execute(parameters: MoviesListArg): Response<MoviesListResponse> =
        movieRepository.getMoviesList(parameters)
}