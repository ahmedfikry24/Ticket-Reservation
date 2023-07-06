package com.example.ticketreservations.composable

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun CinemaChairs(
    background:Color,
    onClick: () -> Unit
) {
    Row(Modifier.clickable(onClick = onClick), horizontalArrangement = Arrangement.Center) {
        Row {
            CanvasDrawRect(
                modifier = Modifier
                    .width(8.dp)
                    .height(22.dp)
                    .padding(1.dp)
                    .clip(RoundedCornerShape(2.dp)),background
            )
            Column {
                CanvasDrawRect(
                    modifier = Modifier
                        .size(16.dp)
                        .clip(RoundedCornerShape(2.dp)),background
                )
                CanvasDrawRect(
                    modifier = Modifier
                        .width(16.dp)
                        .height(8.dp)
                        .padding(1.dp)
                        .clip(RoundedCornerShape(2.dp)),background
                )
            }
            CanvasDrawRect(
                modifier = Modifier
                    .width(8.dp)
                    .height(22.dp)
                    .padding(1.dp)
                    .clip(RoundedCornerShape(2.dp)),background
            )
        }
        HorizontalSpacer(4.dp)
        Row {
            CanvasDrawRect(
                modifier = Modifier
                    .width(8.dp)
                    .height(22.dp)
                    .padding(1.dp)
                    .clip(RoundedCornerShape(2.dp)),background
            )
            Column {
                CanvasDrawRect(
                    modifier = Modifier
                        .size(16.dp)
                        .clip(RoundedCornerShape(2.dp)),background
                )
                CanvasDrawRect(
                    modifier = Modifier
                        .width(16.dp)
                        .height(8.dp)
                        .padding(1.dp)
                        .clip(RoundedCornerShape(2.dp)),background
                )
            }
            CanvasDrawRect(
                modifier = Modifier
                    .width(8.dp)
                    .height(22.dp)
                    .padding(1.dp)
                    .clip(RoundedCornerShape(2.dp)),background
            )
        }
    }
}