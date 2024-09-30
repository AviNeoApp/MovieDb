package com.example.moviedb.screens.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import app.cash.turbine.test
import com.example.domain.error.DataError
import com.example.domain.model.MovieDetail
import com.example.domain.repository.MovieRepository
import com.example.domain.use_case.GetMovieByIdUseCase
import com.example.domain.util.Resource
import com.example.moviedb.screens.factory.DetailsScreenViewModelFactory
import com.example.moviedb.util.dummyMovieDetail
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner


@OptIn(ExperimentalCoroutinesApi::class)
@RunWith(MockitoJUnitRunner::class)
class DetailScreenViewModelTest {

    init {
        MockitoAnnotations.openMocks(this)
    }

    @get:Rule
    val testCoroutineRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var repo: MovieRepository
    private lateinit var getMovieByIdUseCase: GetMovieByIdUseCase
    private lateinit var viewModel: DetailScreenViewModel

    private val testDispatcher = UnconfinedTestDispatcher()
    private val testScope = TestScope(testDispatcher)

    @Before
    fun setUp() {
        Dispatchers.setMain(testDispatcher)
        getMovieByIdUseCase = GetMovieByIdUseCase((repo))
        viewModel = DetailScreenViewModel(getMovieByIdUseCase)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `on movie details retrieved successfully`() = testScope.runTest {
        val movieDetail = DetailsScreenViewModelFactory.getMovieDetailsResponse()
        val movieId = movieDetail.id
        val expected = Resource.Success<MovieDetail, DataError>(movieDetail)
        `when`(repo.getMovieById(movieId)).thenReturn(expected)
        val x = repo.getMovieById(movieId)
        println(x)
        viewModel.movies.test {
            val item = awaitItem()
            assert(dummyMovieDetail.id == item.id)
            viewModel.onEvent(DetailScreenEvent.GetDetail(movieId))
            val result = awaitItem()
            println(result)
            assert(result.id == expected.data.id)
        }
    }

}