package com.example.ticketreservations.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ticketreservations.R
import com.example.ticketreservations.ui.theme.orange
import com.example.ticketreservations.ui.theme.rubik
import com.example.ticketreservations.ui.theme.white

@Composable
fun MovieStatus(
    isShowingNow: Boolean,
) {
    val backgroundOne = if (isShowingNow) Modifier.background(
        orange,
        RoundedCornerShape(20.dp)
    ) else Modifier.border(
        .5.dp,
        white, RoundedCornerShape(20.dp)
    )

    val backgroundTwo = if (isShowingNow) Modifier.border(
        .5.dp,
        white, RoundedCornerShape(20.dp)
    ) else Modifier.background(
        orange,
        RoundedCornerShape(20.dp)
    )


    Row(horizontalArrangement = Arrangement.Center) {
        Box(
            Modifier
                .size(120.dp, 40.dp)
                .then(backgroundOne),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = stringResource(R.string.now_showing),
                color = white,
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium,
                fontFamily = rubik
            )
        }
        HorizontalSpacer(width = 4.dp)
        Box(
            Modifier
                .size(120.dp, 40.dp)
                .then(backgroundTwo),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = stringResource(R.string.coming_soon),
                color = white,
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium,
                fontFamily = rubik
            )
        }
    }

}