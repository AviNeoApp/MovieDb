package com.example.moviedb.screens.detail.component

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.moviedb.screens.components.TmdbImage
import com.example.moviedb.ui.theme.LocalSizing
import com.example.moviedb.ui.theme.LocalSpacing

@Composable
fun MoviePosterImage(
    modifier: Modifier = Modifier,
    posterPath: String
) {
    val spacing = LocalSpacing.current
    val sizing = LocalSizing.current
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(sizing.defaultCornerSize),
        elevation = CardDefaults.cardElevation(
            defaultElevation = spacing.defaultSmall
        )
    ) {
        TmdbImage(
            modifier = Modifier.fillMaxSize(),
            imageUrl = posterPath,
            placeholder = posterPath
        )
    }
}

@Preview
@Composable
private fun MoviePosterImagePrev() {
    val sizing = LocalSizing.current
    MoviePosterImage(
        modifier = Modifier
            .height(sizing.detailPosterHeight)
            .width(sizing.detailPosterWidth),
        posterPath = ""
    )
}