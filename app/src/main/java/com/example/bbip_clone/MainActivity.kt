package com.example.bbip_clone

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.bbip_clone.navigation.TabNavigationGraph
import com.example.bbip_clone.navigation.TabScreen
import com.example.bbip_clone.ui.TabBarScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TabScreen()
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun TabScreen() {
    val navController = rememberNavController()
    val screens = listOf(TabScreen.Home, TabScreen.Study)
    val currentBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = currentBackStackEntry?.destination?.route ?: TabScreen.Home.route

    Scaffold(
        bottomBar = { TabBarScreen(navController, screens, currentRoute) }
    ) {
        Box(modifier = Modifier.fillMaxSize()){ TabNavigationGraph(navController) }
    }
}