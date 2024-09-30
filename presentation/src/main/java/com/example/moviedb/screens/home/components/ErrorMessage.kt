package com.example.moviedb.screens.home.components

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.moviedb.ui.theme.spacing

@Composable
fun ErrorMessage(
    modifier: Modifier = Modifier,
    message: String,
    onClickRetry: () -> Unit
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.default),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = message)
        Button(onClick = onClickRetry) {
            Text(text = "Retry")
        }
    }
}

@Preview
@Composable
private fun ErrorMessagePrev() {
    val context = LocalContext.current
    ErrorMessage(message = "Some error occurred") {
        Toast.makeText(context, "Retrying", Toast.LENGTH_SHORT).show()
    }
}