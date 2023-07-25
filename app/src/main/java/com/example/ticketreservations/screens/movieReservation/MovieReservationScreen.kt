package com.example.ticketreservations.screens.movieReservation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.ticketreservations.AppDestination
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
import com.example.ticketreservations.ui.theme.space16
import com.example.ticketreservations.ui.theme.space24
import com.example.ticketreservations.ui.theme.space8
import com.example.ticketreservations.ui.theme.white

@Composable
fun MovieReservationScreen(
    paddingValues: PaddingValues,
    navController: NavController,
    viewModel: MovieReservationViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()
    MovieReservationContent(paddingValues,
        state = state,
        onClickChair = viewModel::onClickChair,
        onClickDay = viewModel::onClickDay,
        onClickTime = viewModel::onClickTime,
        onClickBuyTickets = { navController.popBackStack(AppDestination.HomeScreen.screen, false) },
        onClickIcon = { navController.popBackStack() })
}

@Composable
private fun MovieReservationContent(
    paddingValues: PaddingValues,
    state: MovieReservationUiState,
    onClickDay: (Int) -> Unit,
    onClickTime: (Int) -> Unit,
    onClickChair: (Int, Boolean, ChairState) -> Unit,
    onClickBuyTickets: () -> Unit,
    onClickIcon: () -> Unit,
) {
    val curveShape = CustomShape()
    val cardHeight = LocalConfiguration.current.screenHeightDp / 3
    val imageHeight = LocalConfiguration.current.screenHeightDp / 5
    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.BottomCenter) {
        Column(
            Modifier
                .fillMaxSize()
                .background(black)
                .padding(paddingValues)
                .padding(space16),
        ) {
            IconClose(onClick = onClickIcon)
            ImageFromUrl(
                url = "https://hips.hearstapps.com/hmg-prod/images/d1pklzbuyaab0la-1552597012.jpg?crop=0.977xw:0.661xh;0.0226xw,0.0625xh&resize=2048:*",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(imageHeight.dp)
                    .clip(shape = curveShape),
                scale = ContentScale.FillWidth
            )
            VerticalSpacer(height = space24)
            LazyVerticalGrid(
                modifier = Modifier.fillMaxWidth(),
                columns = GridCells.Fixed(count = 3),
                contentPadding = PaddingValues(vertical = space16),
                verticalArrangement = Arrangement.spacedBy(space8),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                items(state.chairs.size) { index ->
                    val backgroundLeft = when (state.chairs[index].leftChair.state) {
                        ChairState.AVAILABLE -> white
                        ChairState.TAKEN -> Color.Gray
                        ChairState.SELECTED -> orange
                    }
                    val backgroundRight = when (state.chairs[index].rightChair.state) {
                        ChairState.AVAILABLE -> white
                        ChairState.TAKEN -> Color.Gray
                        ChairState.SELECTED -> orange
                    }
                    Box(modifier = Modifier
                        .fillMaxWidth()
                        .graphicsLayer {
                            val rotation = when (index) {
                                0, 3, 6, 9, 12 -> 10f
                                2, 5, 8, 11, 14 -> -10f
                                else -> 0f
                            }

                            val yAix = when (index) {
                                1, 4, 7, 10, 13 -> 20f
                                else -> 0f
                            }

                            translationY = yAix
                            rotationZ = rotation
                        }, contentAlignment = Alignment.Center) {
                        CinemaChairs(backgroundLeft = backgroundLeft,
                            backgroundRight = backgroundRight,
                            onClickLeft = {
                                onClickChair(
                                    index, true, when (state.chairs[index].leftChair.state) {
                                        ChairState.AVAILABLE -> ChairState.SELECTED
                                        ChairState.TAKEN -> ChairState.AVAILABLE
                                        ChairState.SELECTED -> ChairState.TAKEN
                                    }
                                )
                            },
                            onClickRight = {
                                onClickChair(
                                    index, false, when (state.chairs[index].rightChair.state) {
                                        ChairState.AVAILABLE -> ChairState.SELECTED
                                        ChairState.TAKEN -> ChairState.AVAILABLE
                                        ChairState.SELECTED -> ChairState.TAKEN
                                    }
                                )
                            })
                    }

                }
            }
        }
        Column {
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround) {
                TextCinemaChairsStatus(stringId = R.string.available, circleColor = white)
                TextCinemaChairsStatus(stringId = R.string.taken, circleColor = Color.Gray)
                TextCinemaChairsStatus(stringId = R.string.selected_, circleColor = orange)
            }
            VerticalSpacer(height = space8)
            Card(
                shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp),
                elevation = CardDefaults.cardElevation(12.dp),
                colors = CardDefaults.cardColors(white),
                modifier = Modifier
                    .height(cardHeight.dp)
                    .background(Color.Transparent)
            ) {
                Column {
                    LazyRow(
                        horizontalArrangement = Arrangement.spacedBy(space16),
                        contentPadding = PaddingValues(16.dp)
                    ) {
                        val weekDays: List<String> =
                            listOf("Thu", "Fri", "Sat", "Sun", "Mon", "Thr", "Wed")
                        items(state.reservationDays.size) {
                            val background = if (state.selectedDay == it) lightGrey else white
                            val textColor = if (state.selectedDay == it) white else navy
                            ReservationDateItem(boxColor = background,
                                dayOFMonth = state.reservationDays[it].toString(),
                                dayOfWeek = weekDays[it],
                                textColor = textColor,
                                onClickItem = { onClickDay(it) })
                        }
                    }
                    LazyRow(
                        horizontalArrangement = Arrangement.spacedBy(space16),
                        contentPadding = PaddingValues(16.dp)
                    ) {
                        items(state.reservationTime.size) {
                            val background = if (state.selectedTime == it) lightGrey else white
                            val textColor = if (state.selectedTime == it) white else navy
                            ReservationTimeItem(boxColor = background,
                                reservationTime = state.reservationTime[it],
                                textColor = textColor,
                                onClickItem = { onClickTime(it) })
                        }
                    }
                    Spacer(modifier = Modifier.weight(1f))
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
                                stringId = R.string._100, fontSize = 12, color = Color.LightGray
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
}
