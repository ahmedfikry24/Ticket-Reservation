package com.example.ticketreservations.screens.home

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.lerp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.ticketreservations.AppDestination
import com.example.ticketreservations.R
import com.example.ticketreservations.composable.BottomNavigation
import com.example.ticketreservations.composable.HorizontalSpacer
import com.example.ticketreservations.composable.IconMovieTime
import com.example.ticketreservations.composable.ImageFromUrl
import com.example.ticketreservations.composable.MovieGenre
import com.example.ticketreservations.composable.MovieStatus
import com.example.ticketreservations.composable.TextMovieName
import com.example.ticketreservations.composable.VerticalSpacer
import com.example.ticketreservations.ui.theme.black
import kotlin.math.absoluteValue

@Composable
fun HomeScreen(
    paddingValues: PaddingValues,
    navController: NavController,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()
    HomeContent(
        paddingValues = paddingValues,
        state = state,
        onClickMovie = { navController.navigate(AppDestination.MovieInfo.screen) }
    )
}

@SuppressLint("SuspiciousIndentation")
@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun HomeContent(
    paddingValues: PaddingValues,
    state: HomeUiState,
    onClickMovie: () -> Unit
) {
    val deviceHeight = LocalConfiguration.current.screenHeightDp / 2
    val pagerState = rememberPagerState(2)
    val imageSize = LocalConfiguration.current.screenWidthDp / 1.5
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues), contentAlignment = Alignment.TopCenter
    ) {
        ImageFromUrl(
            url = state.movies[pagerState.currentPage].imageUrl,
            modifier = Modifier
                .fillMaxWidth()
                .height(deviceHeight.dp)
                .blur(40.dp),
            scale = ContentScale.FillBounds
        )
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            VerticalSpacer(height = 40.dp)
            MovieStatus(isShowingNow = state.movies[pagerState.currentPage].isShowingNow)
            HorizontalPager(
                pageCount = state.movies.size,
                state = pagerState,
                contentPadding = PaddingValues(16.dp),
                beyondBoundsPageCount = 2,
            ) { page ->
                ImageFromUrl(
                    url = state.movies[page].imageUrl,
                    modifier = Modifier
                        .size(imageSize.dp, 400.dp)
                        .clip(RoundedCornerShape(20.dp))
                        .graphicsLayer {
                            val pageOffset =
                                ((pagerState.currentPage - page) + pagerState.currentPageOffsetFraction).absoluteValue
                            alpha = lerp(
                                start = 0.5f,
                                stop = 1f,
                                fraction = 1f - pageOffset.coerceIn(0f, 1f)
                            ).also {
                                scaleX = it
                                scaleY = it
                            }
                        }
                        .clickable(onClick = onClickMovie),
                    scale = ContentScale.Crop
                )
            }
            VerticalSpacer(height = 16.dp)
            IconMovieTime(textColor = black)
            VerticalSpacer(height = 8.dp)
            TextMovieName(state.movies[pagerState.currentPage].name)
            VerticalSpacer(height = 16.dp)
            Row(horizontalArrangement = Arrangement.Center) {
                MovieGenre(stringId = R.string.fantasy)
                HorizontalSpacer(width = 8.dp)
                MovieGenre(stringId = R.string.adventure)
            }
            Spacer(modifier = Modifier.weight(1f))
            BottomNavigation()
        }
    }
}
