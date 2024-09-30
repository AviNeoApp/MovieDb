package com.example.moviedb.screens.detail.component

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.moviedb.R
import com.example.moviedb.ui.theme.LocalSpacing
import com.example.moviedb.util.noRippleClickable

@Composable
fun BackButton(
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit
) {
    val spacing = LocalSpacing.current
    Row(
        modifier = modifier
            .padding(spacing.medium)
            .noRippleClickable { onBackClick.invoke() },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(spacing.default)
    ) {
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = null,
            tint = Color.White
        )
        Text(
            text = stringResource(R.string.back),
            color = Color.White,
            fontWeight = FontWeight.Bold
        )
    }
}

@Preview
@Composable
private fun BackButtonPrev() {
    val context = LocalContext.current
    BackButton {
        Toast.makeText(context, "Going Back", Toast.LENGTH_SHORT).show()
    }
}