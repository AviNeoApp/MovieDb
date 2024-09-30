package com.example.moviedb.screens.detail.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.example.moviedb.ui.theme.spacing

@Composable
private fun getDefaultCategoryPadding(): PaddingValues {
    return PaddingValues(
        horizontal = MaterialTheme.spacing.defaultSmall,
        vertical = MaterialTheme.spacing.small
    )
}

@Composable
fun CategoryChip(
    text: String,
    backgroundColor: Color = Color.DarkGray,
    fontSize: TextUnit = 15.sp,
    color: Color = Color.White,
    paddingValues: PaddingValues = getDefaultCategoryPadding()
) {
    Text(
        text = text,
        fontSize = fontSize,
        color = color,
        modifier = Modifier
            .clip(RoundedCornerShape(50))
            .background(backgroundColor)
            .padding(paddingValues)
    )
}

@Preview
@Composable
private fun CategoryChipPrev() {
    CategoryChip(
        text = "Horror"
    )
}