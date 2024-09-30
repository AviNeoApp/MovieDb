package com.example.moviedb.screens.factory

import com.example.domain.model.MovieDetail

object DetailsScreenViewModelFactory {
    fun getMovieDetailsResponse(): MovieDetail {
        return MovieDetail(
            id = 1,
            name = "Dummy",
            posterPath = "/58QT4cPJ2u2TqWZkterDq9q4yxQ.jpg",
            backdropPath = "/58QT4cPJ2u2TqWZkterDq9q4yxQ.jpg",
            releaseDate = "2021",
            runtime = "123",
            category = listOf("Horror", "Comedy"),
            description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.\n"
        )
    }
}