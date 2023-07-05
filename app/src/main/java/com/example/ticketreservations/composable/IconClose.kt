package com.example.ticketreservations.composable

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.ticketreservations.R
import com.example.ticketreservations.ui.theme.white

@Composable
fun IconClose() {
    Box(contentAlignment = Alignment.Center) {
        Canvas(
            modifier = Modifier
                .size(40.dp)
                .alpha(.2f)
        ) {
            drawCircle(color = Color.LightGray)
        }
        Icon(
            modifier = Modifier
                .size(22.dp)
                .clip(CircleShape)
                .border(.5.dp, white, CircleShape),
            imageVector = Icons.Rounded.Close,
            contentDescription = stringResource(R.string.close),
            tint = white
        )
    }
}