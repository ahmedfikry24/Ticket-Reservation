package com.example.ticketreservations.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ticketreservations.ui.theme.rubik

@Composable
fun TextCinemaChairsStatus(stringId: Int, circleColor: Color) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Box(
            Modifier
                .size(12.dp)
                .background(circleColor, CircleShape)
        )
        HorizontalSpacer4()
        Text(
            text = stringResource(stringId),
            fontWeight = FontWeight.Normal,
            fontFamily = rubik,
            color = Color.Gray,
            fontSize = 14.sp
        )
    }
}