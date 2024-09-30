package com.example.moviedb.screens.detail.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.moviedb.R
import com.example.moviedb.ui.theme.LocalSpacing
import com.example.moviedb.ui.theme.spacing

@Composable
fun MovieCategoryRow(
    modifier: Modifier = Modifier,
    category: List<String>
) {
    val spacing = LocalSpacing.current
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(spacing.defaultSmall)
    ) {
        Text(text = stringResource(R.string.category_s))
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.defaultSmall)
        ) {
            items(category) {
                CategoryChip(text = it)
            }
        }
    }
}

@Preview
@Composable
private fun MovieCategoryRowPrev() {
    MovieCategoryRow(category = listOf("Horror","Comedy"))
}