package com.example.ticketreservations.screens.movieInfo

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MovieInfoViewModel : ViewModel() {

    private val actorImageUrls = listOf(
        "https://source.boomplaymusic.com/buzzgroup1/M00/3D/A7/rBEevGLXpSiAU3jLAAIwlwO9nlo220.jpg",
        "https://variety.com/wp-content/uploads/2022/09/GettyImages-1398468797.jpg?w=1000&h=563&crop=1&resize=681%2C383",
        "https://www.mrdustbin.com/us/wp-content/uploads/2021/08/kevin-hart-768x921.jpg",
        "https://www.mrdustbin.com/us/wp-content/uploads/2021/08/will-smith-768x817.jpg",
        "https://content.api.news/v3/images/bin/b098ced64bf2b03c7390dd1e726e8171?width=1024",
        "https://actinginlondon.co.uk/wp-content/uploads/2014/09/Actors-That-Became-Famous-Later-in-Their-Lives.jpg"
    )
    private val _state = MutableStateFlow(actorImageUrls)
    val state: StateFlow<List<String>>
        get() = _state
}