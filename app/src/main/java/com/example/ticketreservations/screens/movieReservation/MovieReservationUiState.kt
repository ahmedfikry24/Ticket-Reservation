package com.example.ticketreservations.screens.movieReservation

data class MovieReservationUiState(
    val chairs: List<CoupleChairUiState> = listOf(
        CoupleChairUiState(),
        CoupleChairUiState(),
        CoupleChairUiState(),
        CoupleChairUiState(),
        CoupleChairUiState(),
        CoupleChairUiState(),
        CoupleChairUiState(),
        CoupleChairUiState(),
        CoupleChairUiState(),
        CoupleChairUiState(),
        CoupleChairUiState(),
        CoupleChairUiState(),
        CoupleChairUiState(),
        CoupleChairUiState(),
        CoupleChairUiState(),
    ),
    val reservationDays: List<Int> = listOf(),
    val selectedDay: Int = 0,
    val reservationTime: List<String> = listOf("10:00", "12:30", "15:30", "18:30", "21:00"),
    val selectedTime: Int = 0,
)

data class CoupleChairUiState(
    val rightChair: ChairUiState = ChairUiState(),
    val leftChair: ChairUiState = ChairUiState(),
)

data class ChairUiState(
    val state: ChairState = ChairState.AVAILABLE,
)

enum class ChairState {
    AVAILABLE,
    TAKEN,
    SELECTED,
}
