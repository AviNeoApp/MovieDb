package com.example.moviedb.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class Sizing(
    val zero: Dp = 0.dp,
    val backDropHeight: Dp = 400.dp,
    val posterHeight: Dp = 180.dp,
    val posterWidth: Dp = 120.dp,
    val defaultCornerSize: Dp = 20.dp,
    val detailPosterHeight: Dp = 120.dp,
    val detailPosterWidth: Dp = 80.dp,
)

val LocalSizing = compositionLocalOf { Sizing() }

val MaterialTheme.sizing: Sizing
    @Composable
    @ReadOnlyComposable
    get() = LocalSizing.current