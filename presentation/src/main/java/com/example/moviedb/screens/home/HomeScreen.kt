package com.example.moviedb.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.moviedb.navigation.Screens
import com.example.moviedb.screens.home.components.ErrorMessage
import com.example.moviedb.screens.home.components.HomeTopBar
import com.example.moviedb.screens.home.components.MovieItemCard
import com.example.moviedb.screens.home.components.PageLoading
import com.example.moviedb.ui.theme.spacing


@Composable
fun HomeScreen(
    controller: NavHostController,
    viewModel: HomeViewModel = hiltViewModel()
) {
    Scaffold(
        topBar = {
            HomeTopBar()
        }
    ) { paddingValues ->
        val movieList = viewModel.moviesState.collectAsLazyPagingItems()
        Column(
            modifier = Modifier
                .background(Color.White)
                .padding(paddingValues)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.default)
        ) {
            LazyVerticalStaggeredGrid(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalItemSpacing = MaterialTheme.spacing.default,
                horizontalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.default),
                columns = StaggeredGridCells.Fixed(2),
                contentPadding = PaddingValues(MaterialTheme.spacing.default)
            ) {
                items(movieList.itemCount) {
                    MovieItemCard(movieList[it]!!) { movie ->
                        controller.navigate(Screens.Detail(movie.id))
                    }
                }
            }
            movieList.apply {
                when {
                    loadState.refresh is LoadState.Loading || loadState.append is LoadState.Loading -> {
                        PageLoading(modifier = Modifier.fillMaxWidth())
                    }

                    loadState.refresh is LoadState.Error -> {
                        val error = movieList.loadState.refresh as LoadState.Error
                        ErrorMessage(
                            modifier = Modifier.fillMaxWidth(),
                            message = error.error.localizedMessage!!,
                            onClickRetry = { retry() }
                        )
                    }

                    loadState.append is LoadState.Error -> {
                        val error = movieList.loadState.append as LoadState.Error
                        ErrorMessage(
                            modifier = Modifier.fillMaxWidth(),
                            message = error.error.localizedMessage!!,
                            onClickRetry = { retry() }
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun HomeScreenPrev() {
    HomeScreen(controller = rememberNavController())
}