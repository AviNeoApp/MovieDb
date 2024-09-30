package com.example.data.source.remote

import com.example.data.source.remote.dto.GetMovieDetailDto
import com.example.data.source.remote.dto.GetMovieListResponseModel
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieService {

    @GET("/3/movie/{movieId}")
    suspend fun getMovie(
        @Path("movieId") movieId: Int
    ): GetMovieDetailDto

    @GET("/3/movie/popular")
    suspend fun getMovies(
        @Query("page") pageNumber: Int
    ): GetMovieListResponseModel

}