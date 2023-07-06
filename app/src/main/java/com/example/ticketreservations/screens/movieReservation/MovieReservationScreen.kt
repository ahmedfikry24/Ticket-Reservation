package com.example.ticketreservations.screens.movieReservation

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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.ticketreservations.R
import com.example.ticketreservations.composable.ButtonBooking
import com.example.ticketreservations.composable.CinemaChairs
import com.example.ticketreservations.composable.IconClose
import com.example.ticketreservations.composable.ImageFromUrl
import com.example.ticketreservations.composable.ReservationDateItem
import com.example.ticketreservations.composable.ReservationTimeItem
import com.example.ticketreservations.composable.TextCinemaChairsStatus
import com.example.ticketreservations.composable.TextMovieRate
import com.example.ticketreservations.composable.VerticalSpacer
import com.example.ticketreservations.ui.theme.black
import com.example.ticketreservations.ui.theme.lightGrey
import com.example.ticketreservations.ui.theme.navy
import com.example.ticketreservations.ui.theme.orange
import com.example.ticketreservations.ui.theme.white

@Composable
fun MovieReservationScreen(
    viewModel: MovieReservationViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()
    MovieReservationContent(
        state = state,
        onClickChair = viewModel::onClickChair,
        onClickDay = viewModel::onClickDay,
        onClickTime = viewModel::onClickTime,
        onClickBuyTickets = {}
    )
}

@Composable
private fun MovieReservationContent(
    state: MovieReservationUiState,
    onClickDay: (Int) -> Unit,
    onClickTime: (Int) -> Unit,
    onClickChair: (Int) -> Unit,
    onClickBuyTickets: () -> Unit
) {
    val curveShape = CustomShape()
    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.BottomCenter) {
        Column(
            Modifier
                .fillMaxSize()
                .background(black)
                .padding(16.dp),
        ) {
            IconClose()
            ImageFromUrl(
                url = "https://hips.hearstapps.com/hmg-prod/images/d1pklzbuyaab0la-1552597012.jpg?crop=0.977xw:0.661xh;0.0226xw,0.0625xh&resize=2048:*",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
                    .clip(shape = curveShape),
                scale = ContentScale.FillWidth
            )
            VerticalSpacer(16.dp)
            LazyVerticalGrid(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                columns = GridCells.Fixed(count = 3),
                verticalArrangement = Arrangement.spacedBy(8.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                items(count = 15) {
                    val background = if (state.selectedChair == it) orange else white
                    CinemaChairs(background) { onClickChair(it) }
                }
            }
            VerticalSpacer(32.dp)
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround) {
                TextCinemaChairsStatus(stringId = R.string.available, circleColor = white)
                TextCinemaChairsStatus(stringId = R.string.taken, circleColor = Color.Gray)
                TextCinemaChairsStatus(stringId = R.string.selected_, circleColor = orange)
            }
        }
        Card(
            shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp),
            elevation = CardDefaults.cardElevation(12.dp),
            colors = CardDefaults.cardColors(white),
            modifier = Modifier
                .heightIn(250.dp, 500.dp)
                .background(Color.Transparent)
        ) {
            Column {
                LazyRow(
                    contentPadding = PaddingValues(16.dp)
                ) {
                    val weekDays: List<String> =
                        listOf("Thu", "Fri", "Sat", "Sun", "Mon", "Thr", "Wed")
                    items(state.reservationDays.size) {
                        val background = if (state.selectedDay == it) lightGrey else white
                        val textColor = if (state.selectedDay == it) white else navy
                        ReservationDateItem(
                            boxColor = background,
                            dayOFMonth = state.reservationDays[it].toString(),
                            dayOfWeek = weekDays[it],
                            textColor = textColor,
                            onClickItem = { onClickDay(it) }
                        )
                    }
                }
                LazyRow(contentPadding = PaddingValues(16.dp)) {
                    items(state.reservationTime.size) {
                        val background = if (state.selectedTime == it) lightGrey else white
                        val textColor = if (state.selectedTime == it) white else navy
                        ReservationTimeItem(
                            boxColor = background,
                            reservationTime = state.reservationTime[it],
                            textColor = textColor,
                            onClickItem = { onClickTime(it) }
                        )
                    }
                }
                Row(
                    Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column {
                        TextMovieRate(stringId = R.string._100, fontSize = 18, color = black)
                        VerticalSpacer(height = 4.dp)
                        TextMovieRate(
                            stringId = R.string._100,
                            fontSize = 12,
                            color = Color.LightGray
                        )
                    }
                    ButtonBooking(
                        stringId = R.string.buy_Tickets,
                        width = 160,
                        onClickEvent = onClickBuyTickets
                    )
                }
            }
        }
    }
}
