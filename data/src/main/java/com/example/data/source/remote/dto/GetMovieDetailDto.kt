package com.example.data.source.remote.dto

import com.google.gson.annotations.SerializedName

data class GetMovieDetailDto(
    @SerializedName("adult")
    val adult: Boolean,
    @SerializedName("backdrop_path")
    val backdropPath: String?,
    @SerializedName("budget")
    val budget: Int,
    @SerializedName("genres")
    val genres: List<Genre>,
    @SerializedName("id")
    val id: Int,
    @SerializedName("overview")
    val overview: String,
    @SerializedName("popularity")
    val popularity: Double,
    @SerializedName("poster_path")
    val posterPath: String?,
    @SerializedName("release_date")
    val releaseDate: String,
    @SerializedName("revenue")
    val revenue: Int,
    @SerializedName("runtime")
    val runtime: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("vote_average")
    val voteAverage: Double,
)