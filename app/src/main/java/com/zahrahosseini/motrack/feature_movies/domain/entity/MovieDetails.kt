package com.zahrahosseini.motrack.feature_movies.domain.entity

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class MovieDetails(
    val id: Int,
    val title: String,
    @SerializedName("original_language")
    val originLanguage: String,
    @SerializedName("original_title")
    val originalTitle: String,
    @SerializedName("vote_average")
    val voteAvg: Float,
    @SerializedName("vote_count")
    val voteCount: Int,
    @SerializedName("release_date")
    val releaseDate: String,
    ) : Parcelable
