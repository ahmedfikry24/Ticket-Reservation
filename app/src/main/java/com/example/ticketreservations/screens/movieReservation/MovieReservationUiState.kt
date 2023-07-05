package com.example.ticketreservations.screens.movieReservation

import androidx.compose.ui.graphics.Color
import com.example.ticketreservations.ui.theme.white

data class MovieReservationUiState(
    val reservationDays: List<Int> = listOf(),
    val selectedDay: Int = 0,
    val reservationTime : List<String> = listOf("10:00","12:30","15:30","18:30","21:00"),
    val selectedTime: Int = 0,
)
