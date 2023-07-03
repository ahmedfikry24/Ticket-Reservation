package com.example.ticketreservations.composable
import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import coil.compose.rememberAsyncImagePainter

@Composable
fun ImageFromUrl(
    modifier: Modifier = Modifier,
    url: String,
    description: String = "",
    scale: ContentScale = ContentScale.Crop,
) {
    Image(
        painter = rememberAsyncImagePainter(url),
        contentDescription = description,
        contentScale = scale,
        modifier = modifier

    )
}