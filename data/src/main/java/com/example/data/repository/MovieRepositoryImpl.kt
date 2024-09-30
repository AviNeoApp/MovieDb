package com.example.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.example.data.mapper.MovieDtoToMovieDetailMapper
import com.example.data.mapper.MovieDtoToMovieMapper
import com.example.data.source.mediator.MoviePagingSource
import com.example.data.source.remote.MovieService
import com.example.domain.error.DataError
import com.example.domain.model.Movie
import com.example.domain.model.MovieDetail
import com.example.domain.repository.MovieRepository
import com.example.domain.util.Resource
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val api: MovieService,
    private val movieMapper: MovieDtoToMovieMapper,
    private val movieDetailMapper: MovieDtoToMovieDetailMapper
) : MovieRepository, BaseRepository() {
    override suspend fun getMovies(): Pager<Int, Movie> {
        return Pager(
            config = PagingConfig(pageSize = 20, prefetchDistance = 2),
            pagingSourceFactory = {
                MoviePagingSource(api,movieMapper)
            }
        )
    }

    override suspend fun getMovieById(id: Int): Resource<MovieDetail, DataError> {
        return execute {
            val movieDto = api.getMovie(id)
            movieDetailMapper.map(movieDto)
        }
    }
}