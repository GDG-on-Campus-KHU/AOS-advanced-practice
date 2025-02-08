package com.example.bbip_clone.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bbip_clone.ui.theme.MainWhite
import com.example.bbip_clone.ui.theme.body2_m14

@Composable
fun RoundBackgroundText(roundText: String, taskText: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .background(Color.Red, CircleShape)
                .size(30.dp, 24.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = roundText,
                color = Color.White,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold
            )
        }
        Spacer(modifier = Modifier.width(8.dp))

        Text(
            text = taskText,
            style = body2_m14,
            color = MainWhite,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}