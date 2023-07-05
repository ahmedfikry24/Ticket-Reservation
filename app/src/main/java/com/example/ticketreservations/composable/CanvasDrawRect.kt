package com.example.ticketreservations.composable

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.ticketreservations.ui.theme.white

@Composable
fun CanvasDrawRect(modifier: Modifier = Modifier) {
    Canvas(modifier = modifier) {
        drawRect(color = white, size = size)
    }
}