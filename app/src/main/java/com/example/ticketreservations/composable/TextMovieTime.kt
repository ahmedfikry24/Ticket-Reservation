package com.example.ticketreservations.composable

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.ticketreservations.ui.theme.rubik
import com.example.ticketreservations.ui.theme.white87

@Composable
fun TextMovieTime(
    modifier: Modifier = Modifier,
    stringId :Int
){
    Text(
        text = stringResource(stringId),
        modifier = modifier,
        color = white87, fontSize = 10.sp,
        fontFamily = rubik,
        fontWeight = FontWeight.Normal
    )
}