package com.example.moviedb.screens.detail.component

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.domain.model.MovieDetail
import com.example.moviedb.screens.components.TmdbImage
import com.example.moviedb.ui.theme.LocalSizing
import com.example.moviedb.ui.theme.LocalSpacing
import com.example.moviedb.util.dummyMovieDetail

@Composable
fun DetailTopHalf(
    modifier: Modifier = Modifier,
    movie: MovieDetail,
    onBackClick: () -> Unit,
) {
    val spacing = LocalSpacing.current
    val sizing = LocalSizing.current
    Box(
        modifier = modifier
    ) {
        TmdbImage(
            modifier = Modifier.matchParentSize(),
            imageUrl = movie.backdropPath,
            placeholder = movie.backdropPath
        )
        BackButton(
            modifier = Modifier
                .padding(top = spacing.default),
            onBackClick = onBackClick
        )
        Row(
            modifier = Modifier
                .padding(spacing.zero)
                .fillMaxWidth()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(Color.Transparent, Color.White)
                    )
                )
                .padding(horizontal = spacing.default)
                .align(Alignment.BottomCenter),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(spacing.default)
        ) {
            MoviePosterImage(
                modifier = Modifier
                    .height(sizing.detailPosterHeight)
                    .width(sizing.detailPosterWidth),
                posterPath = movie.posterPath
            )
            Text(
                text = movie.name,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )
        }
    }
}

@Preview
@Composable
private fun DetailTopHalfPrev() {
    val context = LocalContext.current
    val sizing = LocalSizing.current
    DetailTopHalf(
        modifier = Modifier
            .fillMaxWidth()
            .height(sizing.backDropHeight)
        ,
        movie = dummyMovieDetail
    ) {
        Toast.makeText(context, "Going Back", Toast.LENGTH_SHORT).show()
    }
}