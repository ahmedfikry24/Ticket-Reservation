@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.ticketreservations

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ticketreservations.screens.home.HomeScreen
import com.example.ticketreservations.screens.movieInfo.MovieInfoScreen
import com.example.ticketreservations.screens.movieReservation.MovieReservationScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieApp() {
    Scaffold { padding ->
        val navController = rememberNavController()
        NavHost(
            navController = navController,
            startDestination = AppDestination.HomeScreen.screen
        ) {
            composable(AppDestination.HomeScreen.screen) { HomeScreen(padding, navController) }
            composable(AppDestination.MovieInfo.screen) { MovieInfoScreen(padding, navController) }
            composable(AppDestination.MovieReservation.screen) {
                MovieReservationScreen(
                    padding,
                    navController
                )
            }
        }
    }
}