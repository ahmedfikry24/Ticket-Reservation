package com.example.ticketreservations.screens.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.lerp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.ticketreservations.R
import com.example.ticketreservations.composable.HorizontalSpacer
import com.example.ticketreservations.composable.IconMovieTime
import com.example.ticketreservations.composable.ImageFromUrl
import com.example.ticketreservations.composable.MovieGenre
import com.example.ticketreservations.composable.MovieStatus
import com.example.ticketreservations.composable.TextMovieName
import com.example.ticketreservations.composable.VerticalSpacer
import com.example.ticketreservations.ui.theme.black
import com.example.ticketreservations.ui.theme.orange
import com.example.ticketreservations.ui.theme.white
import kotlin.math.absoluteValue

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()
    HomeContent(
        state = state,
        onClickMovie = {}
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun HomeContent(
    state: HomeUiState,
    onClickMovie: () -> Unit
) {
    val deviceHeight = LocalConfiguration.current.screenHeightDp / 2
    val tileSize = with(LocalDensity.current) { deviceHeight.dp.toPx() }
    val brushBackground = Brush.verticalGradient(
        listOf(
            orange.copy(alpha = .6f), Color.Black.copy(alpha = .5f), white
        ), endY = tileSize, tileMode = TileMode.Clamp
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(brushBackground),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val pagerState = rememberPagerState(2)
        val imageSize = LocalConfiguration.current.screenWidthDp / 1.5
        HorizontalPager(
            modifier = Modifier.fillMaxWidth(),
            pageCount = state.movies.size,
            state = pagerState,
            contentPadding = PaddingValues(16.dp),
            beyondBoundsPageCount = 2,
        ) { page ->
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                VerticalSpacer(height = 40.dp)
                MovieStatus(isShowingNow = state.movies[page].isShowingNow)
                VerticalSpacer(height = 20.dp)
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
                VerticalSpacer(height = 16.dp)
                IconMovieTime(textColor = black)
                VerticalSpacer(height = 8.dp)
                TextMovieName(state.movies[page].name)
                VerticalSpacer(height = 16.dp)
                Row(horizontalArrangement = Arrangement.Center) {
                    MovieGenre(stringId = R.string.fantasy)
                    HorizontalSpacer(width = 8.dp)
                    MovieGenre(stringId = R.string.adventure)
                }
                VerticalSpacer(height = 16.dp)
            }
        }

    }

}
