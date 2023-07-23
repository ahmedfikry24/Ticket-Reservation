package com.example.ticketreservations.screens.movieReservation

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import java.text.SimpleDateFormat
import java.util.Calendar

class MovieReservationViewModel : ViewModel() {

    private val _state = MutableStateFlow(MovieReservationUiState())
    val state: StateFlow<MovieReservationUiState>
        get() = _state

    init {
        getCurrentDay()
    }

    private fun getCurrentDay() {
        val calendar = Calendar.getInstance()
        val dayFormat = SimpleDateFormat("d").format(calendar.time).toInt()
        val reservationDays = mutableListOf<Int>()
        for (i in dayFormat..dayFormat + 6) {
            reservationDays.add(i)
        }
        _state.update { it.copy(reservationDays = reservationDays) }
    }

    fun onClickChair(index: Int, isLeft: Boolean, chairState: ChairState) {
        _state.update {
            it.copy(
                chairs = _state.value.chairs.toMutableList().apply {
                    this[index] = when (isLeft) {
                        true -> this[index].copy(
                            leftChair = ChairUiState(chairState)
                        )

                        false -> this[index].copy(
                            rightChair = ChairUiState(chairState)
                        )
                    }
                }
            )
        }
    }

    fun onClickDay(index: Int) {
        _state.update { it.copy(selectedDay = index) }
    }

    fun onClickTime(index: Int) {
        _state.update { it.copy(selectedTime = index) }
    }
}