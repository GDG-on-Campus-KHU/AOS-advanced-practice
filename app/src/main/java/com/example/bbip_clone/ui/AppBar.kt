package com.example.bbip_clone.ui

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bbip_clone.ui.theme.Gray1
import com.example.bbip_clone.ui.theme.MainBlack
import com.example.bbip_clone.ui.theme.MainWhite
import com.example.bbip_clone.ui.theme.home
import com.example.bbip_clone.ui.theme.title3_m20
import com.example.bbip_clone.ui.theme.title4_sb24

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar(screenCheck: String, noticeCheck: Boolean, studyTitle: String) {
    val notificationsIcon = Icons.Filled.Notifications
    val personIcon = Icons.Filled.Person
    val moreVertIcon = Icons.Filled.MoreVert

    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Transparent
        ),
        title = {
            Row(
                modifier = Modifier.fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                when (screenCheck) {
                    "UserHome" -> {
                        Text(text = home, style = title3_m20)
                        Spacer(modifier = Modifier.weight(1f))

                        Box {
                            IconButton(notificationsIcon, "notifications")
                            if (noticeCheck)
                                Box(
                                    modifier = Modifier
                                        .size(4.dp)
                                        .background(Color.Red, CircleShape)
                                        .align(Alignment.TopEnd)
                                )
                        }
                        Spacer(Modifier.width(12.dp))

                        IconButton(personIcon, "person")
                    }

                    "StudyHome" -> {
                        Text(text = studyTitle, style = title4_sb24, color = MainWhite)
                        Spacer(modifier = Modifier.weight(1f))

                        IconButton(moreVertIcon, "moreVert")
                    }
                }
                Spacer(Modifier.width(28.dp))
            }
        },
    )
}

@Composable
fun IconButton(icon: ImageVector, iconString: String) {
    Icon(
        imageVector = icon,
        contentDescription = "$icon",
        modifier = Modifier
            .size(20.dp)
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = rememberRipple(
                    bounded = false,
                    radius = 14.dp,
                    color = if (iconString == "moreVert") Gray1 else Color.Unspecified
                )
            ) {
                // 추가 api 설정 부분
                when (iconString) {
                    "notifications" -> Log.d("testt", "notifications")
                    "person" -> Log.d("testt", "person")
                    "moreVert" -> Log.d("testt", "moreVert")
                }
            },
        tint = if (iconString == "moreVert") MainWhite else MainBlack
    )
}

@Preview(showBackground = true)
@Composable
fun AppBarPreview() {
    AppBar("UserHome", true, "")
}