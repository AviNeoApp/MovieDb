package com.example.domain.use_case

import com.example.domain.base.BaseUseCase
import com.example.domain.error.DataError
import com.example.domain.model.MovieDetail
import com.example.domain.repository.MovieRepository
import com.example.domain.util.Resource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetMovieByIdUseCase @Inject constructor(
    private val movieRepository: MovieRepository
) : BaseUseCase<Int, Resource<MovieDetail,DataError>>() {

    override val dispatcher: CoroutineDispatcher = Dispatchers.IO

    override suspend fun execute(params: Int) = flow {
        emit(movieRepository.getMovieById(params))
    }
}