package com.example.ticketreservations.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.ticketreservations.R
import com.example.ticketreservations.ui.theme.space8

@Composable
fun CinemaChairs(
    backgroundLeft: Color,
    backgroundRight: Color,
    onClickLeft: () -> Unit,
    onClickRight: () -> Unit,
) {
    Box(
        contentAlignment = Alignment.BottomCenter
    ) {
        Column {
            Row(horizontalArrangement = Arrangement.Center) {
                Row(modifier = Modifier.clickable(onClick = onClickLeft)) {
                    CanvasDrawRect(
                        modifier = Modifier
                            .width(7.dp)
                            .height(22.dp)
                            .padding(1.dp)
                            .clip(RoundedCornerShape(2.dp)), backgroundLeft
                    )
                    Column {
                        CanvasDrawRect(
                            modifier = Modifier
                                .size(15.dp)
                                .clip(RoundedCornerShape(2.dp)), backgroundLeft
                        )
                        CanvasDrawRect(
                            modifier = Modifier
                                .width(16.dp)
                                .height(8.dp)
                                .padding(1.dp)
                                .clip(RoundedCornerShape(2.dp)), backgroundLeft
                        )
                    }
                    CanvasDrawRect(
                        modifier = Modifier
                            .width(7.dp)
                            .height(22.dp)
                            .padding(1.dp)
                            .clip(RoundedCornerShape(2.dp)), backgroundLeft
                    )
                }
                HorizontalSpacer(1.dp)
                Row(modifier = Modifier.clickable(onClick = onClickRight)) {
                    CanvasDrawRect(
                        modifier = Modifier
                            .width(7.dp)
                            .height(22.dp)
                            .padding(1.dp)
                            .clip(RoundedCornerShape(2.dp)), backgroundRight
                    )
                    Column {
                        CanvasDrawRect(
                            modifier = Modifier
                                .size(15.dp)
                                .clip(RoundedCornerShape(2.dp)), backgroundRight
                        )
                        CanvasDrawRect(
                            modifier = Modifier
                                .width(16.dp)
                                .height(8.dp)
                                .padding(1.dp)
                                .clip(RoundedCornerShape(2.dp)), backgroundRight
                        )
                    }
                    CanvasDrawRect(
                        modifier = Modifier
                            .width(7.dp)
                            .height(22.dp)
                            .padding(1.dp)
                            .clip(RoundedCornerShape(2.dp)), backgroundRight
                    )
                }
            }
            VerticalSpacer(height = space8)
        }
        Image(painter = painterResource(R.drawable.container), contentDescription = "")
    }
}