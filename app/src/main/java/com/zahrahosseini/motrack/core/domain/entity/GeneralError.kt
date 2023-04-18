package com.zahrahosseini.motrack.core.domain.entity

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize


@Parcelize
data class GeneralError(
    @SerializedName("errors")
    val errors: List<Error>
) : Parcelable

@Parcelize
data class Error(
    @SerializedName("type")
    val type: String,
    @SerializedName("detail")
    val detail: String?
) : Parcelable
