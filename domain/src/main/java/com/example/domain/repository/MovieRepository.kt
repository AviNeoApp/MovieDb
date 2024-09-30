package com.example.domain.repository

import androidx.paging.Pager
import com.example.domain.error.DataError
import com.example.domain.model.Movie
import com.example.domain.model.MovieDetail
import com.example.domain.util.Resource

interface MovieRepository {
    suspend fun getMovies(): Pager<Int, Movie>
    suspend fun getMovieById(id: Int): Resource<MovieDetail, DataError>
}