package com.example.ticketreservations.composable

import androidx.compose.foundation.Canvas
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.ticketreservations.ui.theme.white

@Composable
fun CanvasDrawRect(modifier: Modifier = Modifier,background:Color= white) {
    Canvas(modifier = modifier) {
        drawRect(color = background, size = size)
    }
}