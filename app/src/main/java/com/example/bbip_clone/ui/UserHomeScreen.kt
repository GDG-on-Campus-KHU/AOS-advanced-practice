package com.example.bbip_clone.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.bbip_clone.ui.theme.home
import com.example.bbip_clone.ui.theme.title3_m20

@Composable
fun UserHomeScreen(navController: NavController) {
    var noticeCheck by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        // 알림 여부(빨간 점)
        noticeCheck = true
    }

    Scaffold(
        topBar = { AppBar(noticeCheck) }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            HorizontalDivider()

        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar(noticeCheck: Boolean) {
    val notificationIcon = Icons.Filled.Notifications
    val personIcon = Icons.Filled.Person

    TopAppBar(
        title = {
            Row(
                modifier = Modifier.fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = home, style = title3_m20)
                Spacer(modifier = Modifier.weight(1f))

                Box {
                    IconButton(notificationIcon)
                    if (noticeCheck)
                        Box(
                            modifier = Modifier
                                .size(4.dp)
                                .background(Color.Red, CircleShape)
                                .align(Alignment.TopEnd)
                        )
                }
                Spacer(Modifier.width(12.dp))

                IconButton(personIcon)
                Spacer(Modifier.width(28.dp))
            }
        },
    )
}

@Composable
fun IconButton(icon: ImageVector) {
    Icon(
        imageVector = icon,
        contentDescription = "$icon",
        modifier = Modifier
            .size(20.dp)
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = rememberRipple(bounded = false, radius = 14.dp)
            ) {
                // 추가 api 설정 부분
            }
    )
}

@Preview(showBackground = true)
@Composable
fun UserHomePreview() {
    UserHomeScreen(rememberNavController())
}