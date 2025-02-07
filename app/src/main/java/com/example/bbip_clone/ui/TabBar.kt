package com.example.bbip_clone.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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


@SuppressLint("UnrememberedMutableInteractionSource", "UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun TabScreen(navController: NavController) {
    val tabs = listOf(Icons.Filled.Home, Icons.Filled.DateRange)
    var pagerState by remember { mutableIntStateOf(0) }

    Scaffold(
        bottomBar = {
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
                    selectedTabIndex = pagerState,
                    containerColor = Color.Transparent,
                    indicator = {},
                    divider = {}
                ) {
                    tabs.forEachIndexed { index, icon ->
                        Tab(
                            modifier = Modifier.height(100.dp),
                            selected = pagerState == index,
                            onClick = { },
                            enabled = false,
                            icon = {
                                Icon(
                                    modifier = Modifier
                                        .size(30.dp)
                                        .background(Color.White)
                                        .clickable(
                                            interactionSource = MutableInteractionSource(),
                                            indication = null
                                        ) { pagerState = index },
                                    imageVector = icon,
                                    contentDescription = null,
                                    tint = if (pagerState == index) Color.Black else Color.LightGray
                                )
                            }
                        )
                        if (index < tabs.size - 1) {
                            Spacer(modifier = Modifier.fillMaxWidth())
                        }
                    }
                }
            }
        }
    ) {
        when (pagerState) {
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