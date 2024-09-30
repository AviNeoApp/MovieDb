package com.example.moviedb.screens.factory

import com.example.domain.model.Movie

object HomeScreenViewModelFactory {
    fun getMovieListResponse() = listOf(
        Movie(
            id = 1,
            name = "Inception",
            posterPath = "/path/to/inception_poster.jpg"
        ),
        Movie(
            id = 2,
            name = "The Dark Knight",
            posterPath = "/path/to/dark_knight_poster.jpg"
        ),
        Movie(
            id = 3,
            name = "Interstellar",
            posterPath = "/path/to/interstellar_poster.jpg"
        ),
        Movie(
            id = 4,
            name = "The Matrix",
            posterPath = "/path/to/matrix_poster.jpg"
        ),
        Movie(
            id = 5,
            name = "Parasite",
            posterPath = "/path/to/parasite_poster.jpg"
        ),
        Movie(
            id = 6,
            name = "The Shawshank Redemption",
            posterPath = "/path/to/shawshank_poster.jpg"
        ),
        Movie(
            id = 7,
            name = "Forrest Gump",
            posterPath = "/path/to/forrest_gump_poster.jpg"
        ),
        Movie(
            id = 8,
            name = "Gladiator",
            posterPath = "/path/to/gladiator_poster.jpg"
        ),
        Movie(
            id = 9,
            name = "The Social Network",
            posterPath = "/path/to/social_network_poster.jpg"
        ),
        Movie(
            id = 10,
            name = "Titanic",
            posterPath = "/path/to/titanic_poster.jpg"
        )
    )

}