package com.example.bbip_clone.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.bbip_clone.ui.theme.MainWhite
import com.example.bbip_clone.ui.theme.body2_m14
import com.example.bbip_clone.ui.theme.caption2_m12

@Composable
fun RoundedBackgroundText(thisWeek: String, content: String) {
    Box(
        modifier = Modifier
            .background(Color.Red, CircleShape)
            .padding(horizontal = 8.dp, vertical = 4.dp)
            .wrapContentSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = thisWeek,
            style = caption2_m12,
            color = MainWhite,
        )
    }
}