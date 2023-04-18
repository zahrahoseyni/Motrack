package com.zahrahosseini.motrack.feature_movies.di

import com.zahrahosseini.motrack.feature_movies.data.remote.MovieApi
import com.zahrahosseini.motrack.feature_movies.data.repository.MovieRepository
import com.zahrahosseini.motrack.feature_movies.data.repository.MovieRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MoviesModule {

    @Singleton
    @Provides
    fun providesMoviesRepository(movieApi: MovieApi): MovieRepository =
        MovieRepositoryImpl(movieApi)

    @Singleton
    @Provides
    fun provideMovieApi(retrofit: Retrofit): MovieApi =
        retrofit.create(MovieApi::class.java)
}