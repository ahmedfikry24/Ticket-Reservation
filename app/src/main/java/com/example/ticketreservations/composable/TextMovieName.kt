package com.example.ticketreservations.composable

import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ticketreservations.ui.theme.rubik

@Composable
fun TextMovieName(textName :String) {
    Text(
        text = textName ,
        fontSize = 18.sp,
        fontWeight = FontWeight.Normal,
        fontFamily = rubik,
        textAlign = TextAlign.Center,
        maxLines = 2,
        modifier = Modifier.widthIn(150.dp, 250.dp)
    )
}