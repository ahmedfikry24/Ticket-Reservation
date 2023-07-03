package com.example.ticketreservations.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ticketreservations.ui.theme.rubik
import com.example.ticketreservations.ui.theme.white60

@Composable
fun MovieGenre(stringId: Int) {
    Box(
        modifier = Modifier
            .width(80.dp)
            .height(40.dp)
            .background(white60, RoundedCornerShape(24.dp)),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = stringResource(stringId),
            fontSize = 12.sp,
            fontWeight = FontWeight.Normal,
            fontFamily = rubik
        )
    }
}