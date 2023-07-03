package com.example.ticketreservations.composable

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import com.example.ticketreservations.ui.theme.black

@Composable
fun MovieRateWithTitle(rateOne: Int, rateTwo: Int, title: Int) {
    Column (horizontalAlignment = Alignment.CenterHorizontally){
        Row {
            TextMovieRate(stringId = rateOne, fontSize = 16, color = black)
            TextMovieRate(
                stringId = rateTwo,
                fontSize = 16,
                color = Color.LightGray
            )
        }
        TextMovieRate(stringId = title, fontSize = 14, color = Color.LightGray)
    }
}