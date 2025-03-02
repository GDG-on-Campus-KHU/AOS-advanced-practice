package com.example.bbip_clone.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.bbip_clone.R
import com.example.bbip_clone.navigation.Screen
import com.example.bbip_clone.ui.theme.Gray4
import com.example.bbip_clone.ui.theme.MainBlack
import com.example.bbip_clone.ui.theme.MainWhite

@SuppressLint("UnrememberedMutableInteractionSource")
@Composable
fun TabBarScreen(navController: NavController, screens: List<Screen>, currentRoute: String) {
    Box(contentAlignment = Alignment.BottomCenter) {
        Image(
            painter = painterResource(R.drawable.tab_bar),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(127.dp),
            contentScale = ContentScale.FillBounds
        )
        TabRow(
            selectedTabIndex = screens.indexOfFirst { it.route == currentRoute },
            containerColor = Color.Transparent,
            indicator = {},
            divider = {}
        ) {
            screens.forEach { screen ->
                val isSelected = screen.route == currentRoute

                Tab(
                    modifier = Modifier.height(100.dp),
                    selected = isSelected,
                    onClick = { navController.navigate(screen.route) },
                    enabled = false,
                    icon = {
                        Icon(
                            modifier = Modifier
                                .size(30.dp)
                                .background(MainWhite)
                                .clickable(
                                    interactionSource = MutableInteractionSource(),
                                    indication = null
                                ) { navController.navigate(screen.route) },
                            imageVector = screen.icon,
                            contentDescription = null,
                            tint = if (isSelected) MainBlack else Gray4
                        )
                    }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TabPreview() {
    TabBarScreen(rememberNavController(), listOf(), Screen.Home.route)
}