package com.example.bbip_clone.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.example.bbip_clone.ui.theme.Gray2
import com.example.bbip_clone.ui.theme.Gray6
import com.example.bbip_clone.ui.theme.caption2_m12

@Composable
fun RoundedBackgroundText(
    thisWeek: String,
    textStyle: TextStyle,
    textColor: Color,
    backgroundColor: Color
) {
    Box(
        modifier = Modifier
            .background(backgroundColor, CircleShape)
            .padding(horizontal = 8.dp, vertical = 4.dp)
            .wrapContentSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = thisWeek,
            style = textStyle,
            color = textColor,
        )
    }
}

@Composable
fun WeekInfo(icon: ImageVector, text:String) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(
            imageVector = icon,
            contentDescription = "",
            modifier = Modifier.size(16.dp),
            tint = Gray6
        )
        Spacer(modifier = Modifier.width(4.dp))

        Text(
            text = text,
            style = caption2_m12,
            color = Gray2
        )
    }
}