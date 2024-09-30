package com.example.domain.use_case

import androidx.paging.PagingData
import com.example.domain.base.BaseUseCase
import com.example.domain.model.Movie
import com.example.domain.repository.MovieRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class GetMovieListUseCase @Inject constructor(
    private val movieRepository: MovieRepository
) : BaseUseCase<Unit, PagingData<Movie>>() {

    override val dispatcher: CoroutineDispatcher = Dispatchers.IO

    override suspend fun execute(params: Unit) = movieRepository.getMovies().flow
}