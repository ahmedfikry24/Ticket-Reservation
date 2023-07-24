package com.example.ticketreservations.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import com.example.ticketreservations.R
import com.example.ticketreservations.ui.theme.black
import com.example.ticketreservations.ui.theme.orange
import com.example.ticketreservations.ui.theme.size24
import com.example.ticketreservations.ui.theme.size42
import com.example.ticketreservations.ui.theme.white

@Composable
fun BottomNavigation () {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(size42)
                .background(orange, CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                modifier = Modifier.size(size24),
                imageVector = ImageVector.vectorResource(R.drawable.ic_video_player),
                tint = white,
                contentDescription = null
            )
        }
        Icon(
            modifier = Modifier.size(size24),
            imageVector = ImageVector.vectorResource(R.drawable.ic_search),
            tint = black,
            contentDescription = null
        )
        Icon(
            modifier = Modifier.size(size24),
            imageVector = ImageVector.vectorResource(R.drawable.ic_ticket),
            tint = black,
            contentDescription = null
        )
        Icon(
            modifier = Modifier.size(size24),
            imageVector = ImageVector.vectorResource(R.drawable.ic_profile),
            tint = black,
            contentDescription = null
        )
    }
}