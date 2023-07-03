package com.example.ticketreservations.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarToday
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
fun ButtonBooking(stringId: Int, width: Int, onClickEvent: () -> Unit) {
    Button(
        onClick = onClickEvent, modifier = Modifier
            .size(width.dp, 50.dp)
            .background(
                orange, RoundedCornerShape(24.dp)
            ), colors = ButtonDefaults.buttonColors(
            orange
        )
    ) {
        Icon(
            imageVector = Icons.Default.CalendarToday,
            contentDescription = stringResource(R.string.booking),
            tint = white,
            modifier = Modifier.background(orange)
        )
        Text(
            text = stringResource(stringId),
            fontSize = 14.sp,
            color = white,
            fontFamily = rubik,
            fontWeight = FontWeight.Normal,
            modifier = Modifier.padding(start = 4.dp)
        )
    }
}