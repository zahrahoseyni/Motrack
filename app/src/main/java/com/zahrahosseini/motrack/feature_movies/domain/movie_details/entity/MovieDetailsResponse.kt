package com.zahrahosseini.motrack.feature_movies.domain.movie_details.entity

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.zahrahosseini.motrack.core.domain.entity.Movie
import kotlinx.parcelize.Parcelize

@Parcelize
data class MovieDetailsResponse(
    override val id: Int,
    override val title: String,
    @SerializedName("original_language")
    override val originLanguage: String,
    @SerializedName("original_title")
    override val originalTitle: String,
    @SerializedName("vote_average")
    override val voteAvg: Float,
    @SerializedName("vote_count")
    override val voteCount: Int,
    @SerializedName("release_date")
    override val releaseDate: String,
    override val popularity: Float,
    @SerializedName("imdb_id")
    val imdbId: String,
    val budget: String,
    val revenue: String,
) : Movie, Parcelable
