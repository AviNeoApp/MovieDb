package com.example.domain.model

data class MovieDetail(
    val id: Int,
    val name: String,
    val runtime: String,
    val description: String,
    val releaseDate: String,
    val posterPath: String,
    val backdropPath: String,
    val category: List<String>,
)
