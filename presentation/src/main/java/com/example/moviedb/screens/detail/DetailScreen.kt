package com.example.moviedb.screens.detail

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.moviedb.screens.detail.component.DetailTopHalf
import com.example.moviedb.screens.detail.component.MovieCategoryRow
import com.example.moviedb.screens.detail.component.ThreeColDetail
import com.example.moviedb.ui.theme.LocalSizing
import com.example.moviedb.ui.theme.LocalSpacing
import com.example.moviedb.util.emptyMovieDetail
import kotlinx.coroutines.flow.collectLatest

@Composable
fun DetailScreen(
    onBackClick: () -> Unit,
    id: Int,
    viewModel: DetailScreenViewModel = hiltViewModel()
) {
    val sizing = LocalSizing.current
    val spacing = LocalSpacing.current
    val context = LocalContext.current

    val movie by viewModel.movies.collectAsStateWithLifecycle(emptyMovieDetail)

    LaunchedEffect(id) {
        viewModel.onEvent(DetailScreenEvent.GetDetail(id))
        viewModel.userEvent.collectLatest {
            when(it){
                is UserEvent.Error -> {
                    Toast.makeText(context, it.error.asString(context), Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(spacing.default)
    ) {
        DetailTopHalf(
            modifier = Modifier
                .fillMaxWidth()
                .height(sizing.backDropHeight),
            movie = movie,
            onBackClick = onBackClick
        )

        ThreeColDetail(
            modifier = Modifier
                .align(Alignment.CenterHorizontally),
            category = if (movie.category.isNotEmpty()) movie.category[0] else "",
            runtime = movie.runtime,
            date = movie.releaseDate
        )

        Text(
            text = movie.description,
            modifier = Modifier.padding(horizontal = spacing.default)
        )

        MovieCategoryRow(
            modifier = Modifier.padding(horizontal = spacing.default),
            category = movie.category
        )
    }
}

@Preview
@Composable
private fun DetailScreenPrev() {
    DetailScreen({ }, id = 957452)
}