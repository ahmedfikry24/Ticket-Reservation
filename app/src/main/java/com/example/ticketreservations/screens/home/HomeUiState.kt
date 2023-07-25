package com.example.ticketreservations.screens.home

data class HomeUiState(
    val movies: List<MovieInfo> = listOf(
        MovieInfo(
            "https://cdn.moviefone.com/admin-uploads/posters/fastx-movie-poster_1678807228.jpg?d=360x540&q=60",
            "Fast X",true
        ),
        MovieInfo(
            "https://static-koimoi.akamaized.net/wp-content/new-galleries/2023/06/extraction-2-01.jpg",
            "Extraction 2",false
        ),
        MovieInfo(
            "https://static-koimoi.akamaized.net/wp-content/new-galleries/2023/01/indiana-jones-and-the-dial-of-destiny-001.jpg",
            "Indiana Jones",false
        ),
        MovieInfo(
            "https://static-koimoi.akamaized.net/wp-content/new-galleries/2022/12/ant-man-and-the-wasp-quantumania-01.jpg",
            "Ant Man",false
        ),
        MovieInfo(
            "https://cdn.moviefone.com/image-assets/603692/borxnSky4iAtOBWohFCWEUT2uZF.jpg?d=360x540&q=60",
            "John Wick",false
        ),
        MovieInfo(
            "https://cdn.moviefone.com/admin-uploads/posters/transformers-movie-poster_1682615239.jpg?d=360x540&q=60",
            "Transformers",false
        ),
    ),
)
