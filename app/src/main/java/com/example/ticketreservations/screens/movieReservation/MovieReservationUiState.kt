package com.example.ticketreservations.screens.movieReservation

data class MovieReservationUiState(
    val reservationDays: List<Int> = listOf(),
    val selectedChair: Int = 0,
    val selectedDay: Int = 0,
    val reservationTime: List<String> = listOf("10:00", "12:30", "15:30", "18:30", "21:00"),
    val selectedTime: Int = 0,
)
