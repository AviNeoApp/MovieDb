package com.example.moviedb.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class Spacing(
    val zero: Dp = 0.dp,
    val xxSmall: Dp = 2.dp,
    val extraSmall: Dp = 4.dp,
    val small: Dp = 8.dp,
    val defaultSmall: Dp = 10.dp,
    val medium: Dp = 16.dp,
    val default: Dp = 20.dp,
    val large: Dp = 32.dp,
    val extraLarge: Dp = 64.dp
)

val LocalSpacing = compositionLocalOf { Spacing() }

val MaterialTheme.spacing: Spacing
    @Composable
    @ReadOnlyComposable
    get() = LocalSpacing.current