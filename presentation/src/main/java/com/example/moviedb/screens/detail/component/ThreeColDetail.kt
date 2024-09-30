package com.example.moviedb.screens.detail.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.moviedb.R
import com.example.moviedb.ui.theme.LocalSpacing
import com.example.moviedb.util.dummyMovieDetail
import com.example.moviedb.util.getYear

@Composable
fun ThreeColDetail(
    modifier: Modifier = Modifier,
    date: String,
    runtime: String,
    category: String
) {
    val spacing = LocalSpacing.current
    Row(
        modifier = modifier
            .padding(horizontal = spacing.default),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(
            spacing.defaultSmall,
            Alignment.CenterHorizontally
        ),
    ) {
        TextWithStartIcon(
            imageVector = Icons.Outlined.DateRange,
            text = date.getYear()
        )
        Spacer(
            modifier = Modifier
                .width(1.dp)
                .height(20.dp)
                .background(
                    color = Color.DarkGray
                )
        )
        TextWithStartIcon(
            imageVector = Icons.Filled.PlayArrow,
            text = stringResource(R.string.mins_args, runtime)
        )
        Spacer(
            modifier = Modifier
                .width(1.dp)
                .height(20.dp)
                .background(
                    color = Color.DarkGray
                )
        )
        TextWithStartIcon(
            imageVector = Icons.Filled.Info,
            text = category
        )
    }
}

@Preview
@Composable
private fun ThreeColDetailPrev() {
    ThreeColDetail(
        date = dummyMovieDetail.releaseDate,
        runtime = dummyMovieDetail.runtime,
        category = dummyMovieDetail.category[0]
    )
}