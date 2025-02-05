package com.example.bbip_clone.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.bbip_clone.R

@Suppress("UNUSED_EXPRESSION")
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "AutoboxingStateValueProperty")
@Composable
fun TabScreen(navController: NavController) {
    val tabs = listOf(Icons.Filled.Home, Icons.Filled.DateRange)
    val pagerState = remember { mutableIntStateOf(0) }

    Scaffold(
        bottomBar = {
            Box(contentAlignment = Alignment.BottomCenter) {
                Image(
                    painter = painterResource(id = R.drawable.tab_bar),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxHeight(0.15f)
                        .fillMaxSize()
                )
                TabRow(
                    selectedTabIndex = pagerState.value,
                    containerColor = Color.Transparent,
                    indicator = {},
                    divider = {}
                ) {
                    tabs.forEachIndexed { index, icon ->
                        Tab(
                            modifier = Modifier.height(90.dp),
                            selected = pagerState.value == index,
                            onClick = { pagerState.value = index },
                            icon = {
                                Icon(
                                    modifier = Modifier
                                        .size(45.dp)
                                        .padding(bottom = 10.dp)
                                        .background(Color.White),
                                    imageVector = icon,
                                    contentDescription = null,
                                    tint = if (pagerState.value == index) Color.Black else Color.LightGray
                                )
                            }
                        )
                        if (index < tabs.size - 1) {
                            Spacer(modifier = Modifier.width(16.dp))
                        }
                    }
                }
            }
        }
    ) {
        when (pagerState.value) {
            0 -> UserHomeScreen(navController)
            1 -> StudyHomeScreen(navController)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TabPreview() {
    TabScreen(rememberNavController())
}