package com.example.data.source.mediator

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.data.mapper.Mapper
import com.example.data.source.remote.MovieService
import com.example.data.source.remote.dto.MovieDto
import com.example.domain.model.Movie
import retrofit2.HttpException
import java.io.IOException

class MoviePagingSource(
    private val movieService: MovieService,
    private val movieMapper: Mapper<MovieDto,Movie>
) : PagingSource<Int, Movie>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Movie> {
        return try {
            val currentPage = params.key ?: 1
            val movies = movieService.getMovies(
                pageNumber = currentPage
            )
            LoadResult.Page(
                data = movies.results.map { movieMapper.map(it) },
                prevKey = if (currentPage == 1) null else currentPage - 1,
                nextKey = if (movies.results.isEmpty()) null else movies.page + 1
            )
        } catch (exception: IOException) {
            return LoadResult.Error(exception)
        } catch (exception: HttpException) {
            return LoadResult.Error(exception)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Movie>): Int? {
        return state.anchorPosition
    }
}