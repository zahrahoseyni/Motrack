package com.zahrahosseini.motrack.feature_movies.domain.entity

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class MoviesListResponse(
    val page: Int,
    val results: List<MovieItem>,
    @SerializedName("total_results")
    val totalResults: Int,
    @SerializedName("total_pages")
    val totalPages: Int
) : Parcelable
