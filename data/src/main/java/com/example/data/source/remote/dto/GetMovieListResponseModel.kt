package com.example.data.source.remote.dto

import com.google.gson.annotations.SerializedName

data class GetMovieListResponseModel(
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val results: List<MovieDto>
)