package com.example.ticketreservations.screens.movieInfo

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.PlayCircle
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.ticketreservations.AppDestination
import com.example.ticketreservations.R
import com.example.ticketreservations.composable.ButtonBooking
import com.example.ticketreservations.composable.HorizontalSpacer
import com.example.ticketreservations.composable.IconClose
import com.example.ticketreservations.composable.IconMovieTime
import com.example.ticketreservations.composable.ImageFromUrl
import com.example.ticketreservations.composable.MovieGenre
import com.example.ticketreservations.composable.MovieRateWithTitle
import com.example.ticketreservations.composable.TextMovieDescription
import com.example.ticketreservations.composable.TextMovieName
import com.example.ticketreservations.composable.VerticalSpacer
import com.example.ticketreservations.ui.theme.grey
import com.example.ticketreservations.ui.theme.orange
import com.example.ticketreservations.ui.theme.white

@Composable
fun MovieInfoScreen(
    paddingValues: PaddingValues,
    navController: NavController,
    viewModel: MovieInfoViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()
    MovieInfoContent(
        paddingValues,
        state,
        onClickBooking = { navController.navigate(AppDestination.MovieReservation.screen) },
        onClickIcon = { navController.popBackStack() }
    )
}

@Composable
private fun MovieInfoContent(
    paddingValues: PaddingValues,
    state: List<String>,
    onClickBooking: () -> Unit,
    onClickIcon: () -> Unit,
) {
    val cardHeight = LocalConfiguration.current.screenHeightDp / 2
    val imageHeight = LocalConfiguration.current.screenHeightDp / 1.8
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues),
        contentAlignment = Alignment.BottomCenter
    ) {
        Box(Modifier.fillMaxSize(), Alignment.TopCenter) {
            Box(
                modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center
            ) {
                ImageFromUrl(
                    url = "https://hips.hearstapps.com/hmg-prod/images/d1pklzbuyaab0la-1552597012.jpg?crop=0.977xw:0.661xh;0.0226xw,0.0625xh&resize=2048:*",
                    modifier = Modifier
                        .fillMaxWidth()
                        .heightIn(imageHeight.dp),
                    description = stringResource(R.string.movie_image),
                    scale = ContentScale.FillBounds
                )
                Icon(
                    imageVector = Icons.Rounded.PlayCircle, contentDescription = stringResource(
                        R.string.play_movie
                    ), tint = orange, modifier = Modifier.size(48.dp)
                )
            }
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 32.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconClose(onClick = onClickIcon)
                IconMovieTime(backgroundColor = grey)
            }
        }

        Card(
            shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp),
            elevation = CardDefaults.cardElevation(12.dp),
            colors = CardDefaults.cardColors(white),
            modifier = Modifier
                .fillMaxWidth()
                .height(cardHeight.dp)
                .background(Color.Transparent)
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                VerticalSpacer(16.dp)
                Row(
                    Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    MovieRateWithTitle(
                        rateOne = R.string._6_8, rateTwo = R.string._10, title = R.string.imdb
                    )
                    MovieRateWithTitle(
                        rateOne = R.string._36,
                        rateTwo = R.string.percentage_mark,
                        title = R.string.rotten_tomatoes
                    )
                    MovieRateWithTitle(
                        rateOne = R.string._4, rateTwo = R.string._10, title = R.string.ign
                    )
                }
                VerticalSpacer(8.dp)
                TextMovieName(stringResource(R.string.fantastic_beasts_the_secrets_of_dumbledore))
                VerticalSpacer(8.dp)
                Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                    MovieGenre(stringId = R.string.fantasy)
                    HorizontalSpacer(width = 8.dp)
                    MovieGenre(stringId = R.string.adventure)
                }
                LazyRow(
                    modifier = Modifier.fillMaxWidth(), contentPadding = PaddingValues(16.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(state.size) {
                        ImageFromUrl(
                            url = state[it],
                            modifier = Modifier
                                .size(60.dp)
                                .clip(CircleShape),
                            description = stringResource(R.string.actor_image),
                        )
                    }
                }
                VerticalSpacer(8.dp)
                TextMovieDescription()
                VerticalSpacer(8.dp)
                ButtonBooking(
                    stringId = R.string.booking,
                    width = 160,
                    onClickEvent = onClickBooking
                )
            }
        }
    }
}
