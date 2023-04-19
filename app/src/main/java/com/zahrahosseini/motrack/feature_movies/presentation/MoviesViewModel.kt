package com.zahrahosseini.motrack.feature_movies.presentation

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zahrahosseini.motrack.core.utils.network.ApiResult
import com.zahrahosseini.motrack.feature_movies.domain.movie_details.entity.MovieDetailsResponse
import com.zahrahosseini.motrack.feature_movies.domain.movie_details.entity.MoviesDetailsArg
import com.zahrahosseini.motrack.feature_movies.domain.movie_details.usecase.MoviesDetailsUseCase
import com.zahrahosseini.motrack.feature_movies.domain.movie_list.entity.MovieItem
import com.zahrahosseini.motrack.feature_movies.domain.movie_list.entity.MoviesListArg
import com.zahrahosseini.motrack.feature_movies.domain.movie_list.entity.MoviesListResponse
import com.zahrahosseini.motrack.feature_movies.domain.movie_list.usecase.MoviesListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(
    private val moviesListUseCase: MoviesListUseCase,
    private val moviesDetailsUseCase: MoviesDetailsUseCase
) : ViewModel() {

    var selectedMovieId: MutableState<Int> = mutableStateOf(1)


    private val _moviesResult =
        MutableStateFlow<MutableList<MovieItem>>(mutableListOf())
    val moviesResult: StateFlow<MutableList<MovieItem>>
        get() = _moviesResult


    private val _errorMessage = MutableSharedFlow<String>()
    val errorMessage: SharedFlow<String>
        get() = _errorMessage

    private val _errorException = MutableSharedFlow<Exception>()
    val errorException: SharedFlow<Exception>
        get() = _errorException

    private val _movieDetailsResult =
        MutableStateFlow<MovieDetailsResponse?>(null)
    val movieDetailsResult: StateFlow<MovieDetailsResponse?>
        get() = _movieDetailsResult


    fun getMoviesList(args: MoviesListArg) {
        viewModelScope.launch {
            moviesListUseCase(args).run {
                when (this) {
                    is ApiResult.Error -> {
                        _errorException.emit(this.exception)
                    }
                    is ApiResult.ServerError -> {
                        _errorMessage.emit(this.errorBody.errors[0].toString())
                    }
                    is ApiResult.Success -> {
                        _moviesResult.value = this.data.results
                    }
                    else -> {}
                }
            }
        }
    }

    fun getMovieDetails(moviesDetailsArg: MoviesDetailsArg) {
        viewModelScope.launch {
            moviesDetailsUseCase(moviesDetailsArg).run {
                when (this) {
                    is ApiResult.Error -> {
                        _errorException.emit(this.exception)
                    }
                    is ApiResult.ServerError -> {
                        _errorMessage.emit(this.errorBody.errors[0].toString())
                    }
                    is ApiResult.Success -> {
                        _movieDetailsResult.emit(this.data)
                    }
                    else -> {}
                }
            }
        }
    }

}