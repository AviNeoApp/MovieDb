package com.example.moviedb.util

import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.unit.IntSize
import com.example.domain.model.Movie
import com.example.domain.model.MovieDetail

fun Modifier.shimmer(
    backgroundColor: Color = Color(0xFFA0A0A0),
    highlightColor: Color = Color(0xFFC9C9C9)
): Modifier = composed {
    var size by remember {
        mutableStateOf(IntSize.Zero)
    }

    val transition = rememberInfiniteTransition("shimmer")
    val startOffsetX by transition.animateFloat(
        initialValue = -2 * size.width.toFloat(),
        targetValue = 2 * size.width.toFloat(),
        animationSpec = infiniteRepeatable(
            tween(
                durationMillis = 1000
            )
        ), label = ""
    )
    background(backgroundColor)
        .background(
            brush = Brush.linearGradient(
                colors = listOf(
                    highlightColor.copy(0.5f),
                    highlightColor,
                    highlightColor.copy(0.5f),
                ),
                start = Offset(startOffsetX, 0f),
                end = Offset(startOffsetX + size.width.toFloat(), size.height.toFloat()),
            ),
        )
        .onGloballyPositioned {
            size = it.size
        }
}

fun Modifier.noRippleClickable(onClick: () -> Unit): Modifier = composed {
    this.clickable(
        indication = null,
        interactionSource = remember { MutableInteractionSource() }) {
        onClick()
    }
}

fun String.getYear(): String {
    if (length >= 4) {
        return substring(0, 4)
    } else {
        return "NA"
    }
}

val emptyMovieDetail = MovieDetail(
    id = 0,
    name = "",
    posterPath = "",
    backdropPath = "",
    releaseDate = "",
    runtime = "",
    category = emptyList(),
    description = ""
)

val dummyMovieDetail = MovieDetail(
    id = 0,
    name = "Dummy",
    posterPath = "/58QT4cPJ2u2TqWZkterDq9q4yxQ.jpg",
    backdropPath = "/58QT4cPJ2u2TqWZkterDq9q4yxQ.jpg",
    releaseDate = "2021",
    runtime = "123",
    category = listOf("Horror", "Comedy"),
    description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.\n"
)

val dummyMovie = Movie(1, "Movie Name", "/58QT4cPJ2u2TqWZkterDq9q4yxQ.jpg")
