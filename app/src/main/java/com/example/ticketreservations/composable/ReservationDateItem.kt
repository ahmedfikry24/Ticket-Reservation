package com.example.ticketreservations.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ticketreservations.ui.theme.rubik

@Composable
fun ReservationDateItem(
    boxColor: Color,
    dayOFMonth: String,
    dayOfWeek: String,
    textColor: Color,
    onClickItem: () -> Unit
) {
    Box(
        Modifier
            .size(40.dp, 60.dp)
            .background(boxColor, RoundedCornerShape(16.dp))
            .clickable(onClick = onClickItem),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceAround
        ) {

            Text(
                text = dayOFMonth,
                color = textColor,
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold,
                fontFamily = rubik,
            )
            Text(
                text = dayOfWeek,
                color = textColor,
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium,
                fontFamily = rubik,
            )
        }
    }
    HorizontalSpacer(8.dp)
}