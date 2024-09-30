package com.example.moviedb.screens.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Size
import com.example.moviedb.BuildConfig
import com.example.moviedb.R

@Composable
fun TmdbImage(modifier: Modifier = Modifier, imageUrl: String, placeholder: String) {
    val context = LocalContext.current
    val imagePainter = rememberAsyncImagePainter(
        ImageRequest.Builder(context)
            .data("${BuildConfig.BASE_IMAGE_URL}${imageUrl}")
            .size(Size.ORIGINAL)
            .build()
    )

    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        if (imageUrl.isBlank()) {
            Image(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.LightGray),
                painter = painterResource(id = R.drawable.img_placeholder),
                contentDescription = placeholder,
                contentScale = ContentScale.Inside,
            )
        } else {
            when (imagePainter.state) {
                AsyncImagePainter.State.Empty, is AsyncImagePainter.State.Loading -> {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(Color.LightGray)
                    )
                }

                is AsyncImagePainter.State.Error -> {
                    Image(
                        modifier = Modifier.fillMaxSize(),
                        imageVector = Icons.Default.Warning,
                        contentDescription = placeholder,
                        contentScale = ContentScale.Inside,
                    )
                }

                is AsyncImagePainter.State.Success -> {
                    Image(
                        modifier = Modifier.fillMaxSize(),
                        painter = imagePainter,
                        contentDescription = placeholder,
                        contentScale = ContentScale.Crop,
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun TmdbImageValidPath() {
    val imagePath = "/58QT4cPJ2u2TqWZkterDq9q4yxQ.jpg"
    TmdbImage(
        modifier = Modifier.size(100.dp),
        imageUrl = imagePath,
        placeholder = imagePath
    )
}

@Preview
@Composable
private fun TmdbImageInvalidPath() {
    val imagePath = "/58QT4cPJ2u2TqWZkterDq9q4yjpg"
    TmdbImage(
        modifier = Modifier.size(100.dp),
        imageUrl = imagePath,
        placeholder = imagePath
    )
}

@Preview
@Composable
private fun TmdbImageEmptyPath() {
    val imagePath = ""
    TmdbImage(
        modifier = Modifier.size(100.dp),
        imageUrl = imagePath,
        placeholder = imagePath
    )
}