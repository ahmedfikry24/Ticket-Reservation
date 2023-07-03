package com.example.ticketreservations.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.ticketreservations.R
import com.example.ticketreservations.ui.theme.lightGrey
import com.example.ticketreservations.ui.theme.white

@Composable
fun IconClose() {
    Box(
        Modifier
            .size(32.dp)
            .background(lightGrey, CircleShape).alpha(.5f), Alignment.Center) {
        Icon(
            modifier = Modifier
                .background(lightGrey, CircleShape)
                .size(24.dp)
                .border(.5.dp, white, CircleShape),
            imageVector = Icons.Rounded.Close,
            contentDescription = stringResource(R.string.close),
            tint = white
        )
    }
}