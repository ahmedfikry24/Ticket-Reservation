package com.example.ticketreservations

sealed class AppDestination(val screen: String) {
    object HomeScreen : AppDestination("homeScreen")
    object MovieInfo : AppDestination("movieInfo")
    object MovieReservation : AppDestination("movieReservation")
}