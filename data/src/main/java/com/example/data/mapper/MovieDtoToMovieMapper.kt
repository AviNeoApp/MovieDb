package com.example.data.mapper

import com.example.data.source.remote.dto.MovieDto
import com.example.domain.model.Movie
import javax.inject.Inject

class MovieDtoToMovieMapper @Inject constructor() : Mapper<MovieDto,Movie> {
    override fun map(from: MovieDto): Movie {
        return Movie(
            id = from.id,
            name = from.title,
            posterPath = from.posterPath ?: ""
        )
    }
}