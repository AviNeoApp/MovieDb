package com.example.moviedb.screens.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.moviedb.R
import com.example.moviedb.ui.theme.spacing

@Composable
fun HomeTopBar() {
    Text(
        modifier = Modifier
            .statusBarsPadding()
            .fillMaxWidth()
            .padding(MaterialTheme.spacing.zero)
            .background(Color.White)
            .padding(MaterialTheme.spacing.default),
        text = stringResource(id = R.string.app_name),
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp,
        textAlign = TextAlign.Center
    )
}

@Preview
@Composable
private fun HomeTopBarPrev() {
    HomeTopBar()
}